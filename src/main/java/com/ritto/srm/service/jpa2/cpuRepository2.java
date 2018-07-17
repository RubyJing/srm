package com.ritto.srm.service.jpa2;

import com.ritto.srm.Entity2.CpuBeanBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/7/13
 * @Description:
 * @Modified By:
 */
public interface cpuRepository2 extends JpaRepository<CpuBeanBack,Integer> {
    @Query(value="select table_name from information_schema.tables where table_schema='testback'", nativeQuery = true)
    public List findalltab();
}
