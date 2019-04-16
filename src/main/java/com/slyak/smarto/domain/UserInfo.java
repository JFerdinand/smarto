package com.slyak.smarto.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author jiangmingjun
 * @create 2019/4/4
 */
@Entity
@Table(name = "t_user")
@Data
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String password;
    private String salt = "smarto";
    private byte state;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;
    public static byte STATUS_LOCK = 0;

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName+this.salt;
    }

    @Override
    public String toString() {
        return userName;
    }
}
