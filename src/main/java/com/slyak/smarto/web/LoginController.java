package com.slyak.smarto.web;

import com.slyak.smarto.domain.ResponseBo;
import com.slyak.smarto.domain.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.apache.shiro.SecurityUtils.getSubject;

/**
 * @author jiangmingjun
 * @create 2019/4/4
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public void login () {

    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String userName,String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        password = new SimpleHash("md5", password, ByteSource.Util.bytes(userInfo.getCredentialsSalt()), 2).toHex();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            Subject subject = getSubject();
            if (subject != null) {
                subject.logout();
                subject.login(token);
            }
            return ResponseBo.ok();
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }
}
