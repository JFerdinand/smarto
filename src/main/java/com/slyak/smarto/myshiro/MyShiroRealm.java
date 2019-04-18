package com.slyak.smarto.myshiro;

import com.slyak.smarto.domain.SysPermission;
import com.slyak.smarto.domain.SysRole;
import com.slyak.smarto.domain.UserInfo;
import com.slyak.smarto.service.SmartoManager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jiangmingjun
 * @create 2019/4/4
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SmartoManager smartoManager;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo)principalCollection.getPrimaryPrincipal();
        for (SysRole role:userInfo.getRoleList()
             ) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission:role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String)authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        UserInfo userInfo = smartoManager.queryByUserName(userName);
        if (null == userInfo) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(userInfo.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (UserInfo.STATUS_LOCK == userInfo.getState()) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        return new SimpleAuthenticationInfo(
                userInfo,
                userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                getName()
        );
    }

    @Override
    public  boolean isPermitted(PrincipalCollection principals, String permission){
        UserInfo user = (UserInfo) principals.getPrimaryPrincipal();
        // 如果是管理员拥有所有的访问权限
        return user.getUserId() == 1 || super.isPermitted(principals, permission);
    }
    @Override
    public boolean hasRole(PrincipalCollection principals, String roleIdentifier) {
        UserInfo user = (UserInfo) principals.getPrimaryPrincipal();
        // 如果是管理员拥有所有的角色权限
        return user.getUserId() == 1 || super.hasRole(principals, roleIdentifier);
    }
}
