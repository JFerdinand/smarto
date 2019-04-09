package com.slyak.smarto.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author jiangmingjun
 * @create 2019/4/4
 */
@Entity
@Table(name = "t_sysPermission")
@Data
public class SysPermission {
    @Id
    @GeneratedValue
    private Integer permissionId;
    private String name;
    private String resourceType;
    private String url;
    private String permission;
    private Long parentId;
    private String ancestorIds;
    private Boolean available = Boolean.FALSE;
    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;
}
