package com.slyak.smarto.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author jiangmingjun
 * @create 2019/4/4
 */
@Entity
@Table(name="t_sysRole")
@Data
public class SysRole {
    @Id
    @GeneratedValue
    private Integer roleId;
    private String role;
    private String description;
    private byte isDel;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
    private List<UserInfo> userInfos;
}
