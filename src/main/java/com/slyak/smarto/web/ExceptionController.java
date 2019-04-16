package com.slyak.smarto.web;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangmingjun
 * @create 2019/4/11
 */
@ControllerAdvice
public class ExceptionController {
//    @ResponseBody
//    @ExceptionHandler(UnauthorizedException.class)
//    public Map<String,Object> errorHandler() {
//        Map<String,Object> map = new HashMap(2);
//        map.put("code", 100);
//        return map;
//    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ModelAndView errorHandler() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("code", 403);
        return modelAndView;
    }

}
