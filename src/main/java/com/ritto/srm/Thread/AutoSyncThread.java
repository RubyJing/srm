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
    private int time;
    List<SyncBean> list;
    AutoSyncThread(List<SyncBean> syncBeanList){
        time = 0;
        list = syncBeanList;

    }
    @Override
    public void run(){
        while (true){

            try {
                Thread.sleep(3600000);//休眠一小时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time ++;
            list.forEach(syncBean -> {
                if(time % syncBean.getSyncRateH() == 0){
                    //开始同步
                }
            });
        }
    }
}
