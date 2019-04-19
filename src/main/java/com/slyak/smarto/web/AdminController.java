package com.slyak.smarto.web;

import com.slyak.smarto.converter.OsVersionsOptionConverter;
import com.slyak.smarto.converter.SysRoleOptionConverter;
import com.slyak.smarto.domain.*;
import com.slyak.smarto.service.SmartoManager;
import com.slyak.web.support.data.RequestParamBind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * .
 *
 * @author stormning 2018/4/20
 * @since 1.3.0
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {

    @Autowired
    private SmartoManager smartoManager;

    @Autowired
    private SysRoleOptionConverter optionConverter;

    @RequestMapping("/users")
    public void users(Pageable pageable, ModelMap modelMap) {
        modelMap.put("page",smartoManager.queryUsers(pageable));
    }

    @GetMapping("/user")
    public void user(@RequestParamBind("id")UserInfo userInfo, ModelMap modelMap) {
        modelMap.put("sysRoles", optionConverter.convert(smartoManager.queryRoles()));
        if (userInfo != null) {
            modelMap.put("userInfo", userInfo);
        }
    }

    @PostMapping("/user")
    public void user(@RequestParamBind("id") UserInfo userInfo, HttpServletRequest request) {
        List<SysRole> list = new ArrayList<>();
        String[] ids = request.getParameterValues("roleIds");
        for (String id:ids
             ) {
            list.add(new SysRole(){
                {
                    setRoleId(Integer.valueOf(id));
                }
            });
        }
        userInfo.setRoleList(list);
        smartoManager.saveUser(userInfo);
    }

    @GetMapping("/index")
    public void index(ModelMap modelMap) {
        modelMap.put("global", smartoManager.findGlobal());
    }

    @GetMapping("/oss")
    public void oss(ModelMap modelMap) {
        modelMap.put("oss", smartoManager.queryOss());
    }

    @GetMapping("/os")
    public void os(@RequestParamBind("id") OS os, ModelMap map) {
        map.put("os", os);
    }

    @PostMapping("/os")
    public void saveOs(@RequestParamBind("id") OS os) {
        smartoManager.saveOs(os);
    }

    @GetMapping("/testHost")
    @ResponseBody
    public boolean validateTestHost() {
        Host testHost = smartoManager.getTestHost();
        return smartoManager.validateHost(testHost, "docker -v", "version");
    }

    @GetMapping("/mirrors")
    public void mirrors(ModelMap modelMap) {
        modelMap.put("mirrors", smartoManager.queryMirrors());
    }

    @GetMapping("/mirror")
    public void mirror(@RequestParamBind("id") Mirror mirror) {

    }

    @PostMapping("/mirror")
    public void saveMirror(@RequestParamBind("id") Mirror mirror) {
        smartoManager.saveMirror(mirror);
    }


    @GetMapping("/files")
    public void files() {
    }

    @GetMapping("/sysEnvs")
    public void sysEnvs(ModelMap modelMap) {
        modelMap.put("sysEnvs", smartoManager.querySysEnvs());
    }
}