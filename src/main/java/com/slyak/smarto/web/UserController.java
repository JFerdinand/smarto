package com.slyak.smarto.web;

import com.slyak.smarto.service.SmartoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;

/**
 * @author jiangmingjun
 * @create 2019/4/9
 */
@Controller
public class UserController {
    @Autowired
    private SmartoManager smartoManager;

    @RequestMapping("/users")
    public void user(Pageable pageable, ModelMap modelMap) {

    }
}
