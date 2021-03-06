package com.ritto.srm.service.jpa;

import com.ritto.srm.Entity.SyncBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/7/17
 * @Description:
 * @Modified By:
 */
public interface SyncRepository extends JpaRepository<SyncBean,Integer> {
    @Query(value = "select count(*) from sync", nativeQuery = true)
    public long count();

    public SyncBean findBySyncTabName(String tabname);

}
