package com.slyak.smarto.service;

import com.slyak.smarto.dto.ScriptInstances;

import java.util.List;

/**
 * .
 *
 * @author stormning 2018/6/1
 * @since 1.3.0
 */
public interface BatchProvider {

    List<Long> getOwnerHostIds(Long ownerId);

    ScriptInstances getScriptsInstances(Long ownerId);
}
