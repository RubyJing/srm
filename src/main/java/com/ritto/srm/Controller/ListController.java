package com.ritto.srm.Controller;

import com.ritto.srm.Entity.CpuBean;
import com.ritto.srm.Entity.SyncBean;
import com.ritto.srm.Entity2.CpuBeanBack;
import com.ritto.srm.Thread.SyncThread;
import com.ritto.srm.Util.ObjectConvertor;
import com.ritto.srm.service.jpa.SyncRepository;
import com.ritto.srm.service.jpa.cpuRepository;
import com.ritto.srm.service.jpa2.cpuRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/4/24
 * @Description:
 * @Modified By:
 */
@RequestMapping("/list")
@RestController
public class ListController {
    @PersistenceContext //注入的是实体管理器,执行持久化操作
    EntityManager entityManager;

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Autowired
    private SyncRepository syncRepository;

    @Autowired
    private cpuRepository cpuRepository;

    @Autowired
    private cpuRepository2 cpuRepository2;

    private ObjectConvertor convertor;

    @GetMapping("/dothis")
    public String dothis(){
        convertor = new ObjectConvertor();
        List<CpuBean> cpuBeanList = cpuRepository.findAll();
        cpuBeanList.forEach(cpuBean -> {
            //连接另外一个数据库，然后持久化这个输出
            CpuBeanBack cpuBeanBack = convertor.toAnotherObj(cpuBean, CpuBeanBack.class);
            //断言不为空

            cpuRepository2.save(cpuBeanBack);
        });
        return "";
    }

    /**
     * @Auther: Eiden J.P Zhou
     * @Date: 2018/7/17 17:35
     * @Method: findallsync
     * @Params: []
     * @Return: java.util.List<com.ritto.srm.Entity.SyncBean>
     * @Description: 查找全部同步计划
     */
    @PostMapping("/findallsync")
    public List<SyncBean> findallsync(){

        List<SyncBean> syncBeanList = syncRepository.findAll();
        return syncBeanList;
    }

    @PostMapping("/findalltab")
    public List findAlltable(){

        List tablelist = entityManager.createNativeQuery("select table_name from information_schema.tables where table_schema='Hotel_manage'").getResultList();
        return tablelist;
    }

    /**
     * @Auther: Eiden J.P Zhou
     * @Date: 2018/7/17 17:22
     * @Method: addSyncTab
     * @Params: [sb]
     * @Return: java.lang.String
     * @Description: 将一张表加入同步计划
     */
    @PostMapping("/addsynctab")
    public String addSyncTab(SyncBean sb){
        String result = "fail";
        sb.setLastSyncDate(new Timestamp(new Date().getTime()));
        sb.setLastSyncState("未同步");
        if (null != syncRepository.save(sb)){
            result = "success";
        }
        return result;
    }

    @PostMapping("/synctab")
    public String synctab(String tabname){
        SyncThread syncThread = new SyncThread(tabname,jdbcTemplate1,jdbcTemplate2,entityManager);
        syncThread.start();
        return "";
    }

    @GetMapping("/jdt")
    public String jdt(){
        return SyncThread.jdt.toString();
    }
}
