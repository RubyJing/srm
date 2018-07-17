package com.ritto.srm.service.jpa;

import com.ritto.srm.Entity.SyncBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/7/17
 * @Description:
 * @Modified By:
 */
public interface SyncRepository extends JpaRepository<SyncBean,Integer> {

}
