package com.ritto.srm.Thread;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/7/20
 * @Description: 手动同步线程
 * @Modified By:
 */
public class SyncThread extends Thread{
    public static Integer jdt = 0 ;
    protected JdbcTemplate jdbcTemplate1;

    protected JdbcTemplate jdbcTemplate2;

    EntityManager entityManager;

    private String tabname;
    public SyncThread(String name,JdbcTemplate jt1,JdbcTemplate jt2,EntityManager em){
        tabname = name;
        jdbcTemplate1 = jt1;
        jdbcTemplate2 = jt2;
        entityManager = em;
        jdt = 0;
    }

    @Transactional
    @Override
    public void run(){
        int count = Integer.parseInt(entityManager.createNativeQuery("SELECT COUNT(*) FROM "+tabname).getSingleResult().toString());
         for (int i=0;i<count;i+=10){
            Query query = entityManager.createNativeQuery("SELECT * FROM "+tabname+" WHERE 1=1 LIMIT "+i+",10");
//			query.setParameter(1,tablename);
            List objectList = query.getResultList();
            Iterator it = objectList.iterator();
            while(it.hasNext()){
                Object[] object = (Object[])it.next();
                StringBuffer sql = new StringBuffer();
                sql.append("INSERT INTO ");
                sql.append(tabname);
                sql.append(" VALUES( ");
                for (int j=0;j < object.length;j++){
                    if (null!=object[j]){
                        if (object[j].getClass().getName().equals("java.lang.String")||object[j].getClass().getName().equals("java.sql.Timestamp")){
                            sql.append("'"+object[j].toString()+"'");
                        }else {
                            sql.append(object[j]);
                        }
                    }else {
                        sql.append(object[j]);
                    }

                    sql.append(" ,");
                }
                sql.deleteCharAt(sql.length()-1);
                sql.append(" )");
                if(jdbcTemplate2.update(sql.toString())>0){
                    System.out.println("seccess");
                }
            }
            jdt = i*100/count>100?100:i*100/count;
        }
        jdt = 100;
         //同步完成后
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE sync SET last_sync_state ='已同步' WHERE sync_tab_name = '");
        sql.append(tabname);
        sql.append("'");
        if (jdbcTemplate1.update(sql.toString())>0){
            System.out.println("同步成功");
        }
    }
}
