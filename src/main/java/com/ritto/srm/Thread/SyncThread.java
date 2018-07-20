package com.ritto.srm.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @PersistenceContext
    EntityManager entityManager;

    private String tabname;
    public SyncThread(String name){
        tabname = name;
    }

    @Transactional
    @Override
    public void run(){
        int count = Integer.parseInt(entityManager.createNativeQuery("SELECT COUNT(*) FROM "+tabname).getSingleResult().toString());
        for (int i=0;i<count;i+=100){
            Query query = entityManager.createNativeQuery("SELECT * FROM "+tabname+" WHERE 1=1 LIMIT "+i+",100");
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
        }
    }
}
