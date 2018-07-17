package com.ritto.srm.Controller;

import com.ritto.srm.Entity.CpuBean;
import com.ritto.srm.Entity2.CpuBeanBack;
import com.ritto.srm.Util.ObjectConvertor;
import com.ritto.srm.service.jpa.cpuRepository;
import com.ritto.srm.service.jpa2.cpuRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PostMapping("/pgg")
    public String postgg(String s){

        return s;
    }

    @PostMapping("/findalltab")
    public List findAlltable(){

        List tablelist = entityManager.createNativeQuery("select table_name from information_schema.tables where table_schema='Hotel_manage'").getResultList();
        return tablelist;
    }
}
