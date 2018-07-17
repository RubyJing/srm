package com.ritto.srm.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Auther: Eiden J.P Zhou
 * @Date: 2018/7/17
 * @Description:
 * @Modified By:
 */
@Entity
@Table(name = "authorities", schema = "Hotel_manage", catalog = "")
public class AuthoritiesBean {
    private String username;
    private String authority;

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthoritiesBean that = (AuthoritiesBean) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, authority);
    }
}
