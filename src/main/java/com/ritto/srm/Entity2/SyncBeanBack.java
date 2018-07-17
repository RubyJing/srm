package com.ritto.srm.Entity2;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/7/17
 * @Description:
 * @Modified By:
 */
@Entity
@Table(name = "sync", schema = "Hotel_manage", catalog = "")
public class SyncBeanBack {
    private int id;
    private String syncTabName;
    private Timestamp lastSyncDate;
    private String lastSyncState;
    private Integer syncRateH;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sync_tab_name")
    public String getSyncTabName() {
        return syncTabName;
    }

    public void setSyncTabName(String syncTabName) {
        this.syncTabName = syncTabName;
    }

    @Basic
    @Column(name = "last_sync_date")
    public Timestamp getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(Timestamp lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }

    @Basic
    @Column(name = "last_sync_state")
    public String getLastSyncState() {
        return lastSyncState;
    }

    public void setLastSyncState(String lastSyncState) {
        this.lastSyncState = lastSyncState;
    }

    @Basic
    @Column(name = "sync_rate_h")
    public Integer getSyncRateH() {
        return syncRateH;
    }

    public void setSyncRateH(Integer syncRateH) {
        this.syncRateH = syncRateH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyncBeanBack syncBeanBack = (SyncBeanBack) o;
        return id == syncBeanBack.id &&
                Objects.equals(syncTabName, syncBeanBack.syncTabName) &&
                Objects.equals(lastSyncDate, syncBeanBack.lastSyncDate) &&
                Objects.equals(lastSyncState, syncBeanBack.lastSyncState) &&
                Objects.equals(syncRateH, syncBeanBack.syncRateH);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, syncTabName, lastSyncDate, lastSyncState, syncRateH);
    }
}
