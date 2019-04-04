package com.slyak.smarto.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * .
 *
 * @author stormning 2018/4/20
 * @since 1.3.0
 */
@Controller
public class HomeController {

    @GetMapping("")
    public String home() {
        return "redirect:/login";
    }

}