package com.slyak.smarto.domain;

import com.slyak.web.ui.Option;

import java.util.List;

/**
 * @author jiangmingjun
 * @create 2019/4/19
 */
public class OptionExt extends Option {
    private List<Object> content;

    public List<Object> getContent() {
        return content;
    }

    public void setContent(List<Object> content) {
        this.content = content;
    }
}
