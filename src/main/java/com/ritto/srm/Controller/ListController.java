package com.ritto.srm.Controller;

import com.ritto.srm.Entity.CpuBean;
import com.ritto.srm.service.jpa.cpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private cpuRepository cpuRepository;

    @GetMapping("/dothis")
    public String dothis(){
        CpuBean cpu = cpuRepository.findById(1).get();

        List<CpuBean> cpuBeanList = cpuRepository.findAll();
        cpuBeanList.forEach(cpuBean -> {
            //连接另外一个数据库，然后持久化这个输出
        });
        System.out.println(cpu.getName());
        return "";
    }
}
