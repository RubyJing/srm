package com.ritto.srm.Thread;

import com.ritto.srm.Entity.SyncBean;

import java.util.List;

/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/7/19
 * @Description:
 * @Modified By:
 */
public class AutoSyncThread extends Thread {
    private long time;
    AutoSyncThread(List<SyncBean> syncBeanList){
        syncBeanList.forEach(syncBean -> {
            time = syncBean.getSyncRateH() * 3600;
        });
    }
    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
