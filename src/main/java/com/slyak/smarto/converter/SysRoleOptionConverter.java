package com.slyak.smarto.converter;

import com.slyak.smarto.domain.OS;
import com.slyak.smarto.domain.OptionExt;
import com.slyak.smarto.domain.SysRole;
import com.slyak.smarto.repository.OSRepository;
import com.slyak.smarto.repository.SysRoleRepository;
import com.slyak.spring.jpa.converter.AbstractConverter;
import com.slyak.web.ui.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * .
 *
 * @author stormning 2018/5/14
 * @since 1.3.0
 */
@Component
public class SysRoleOptionConverter extends AbstractConverter<SysRole, OptionExt, Integer> {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    protected Integer getId(SysRole sysRole) {
        return sysRole.getRoleId();
    }

    @Override
    protected OptionExt internalConvert(SysRole sysRole) {
        OptionExt option = new OptionExt();
        option.setTitle(sysRole.getRole());
        option.setValue(sysRole.getRole());
        option.setContent(Collections.singletonList(new ArrayList<SysRole>() {
            {
                add(sysRole);
            }
        }));
        return option;
    }

    @Override
    protected SysRole internalGet(Integer integer) {
        return sysRoleRepository.findOne(integer);
    }

    @Override
    protected Map<Integer, SysRole> internalMGet(Collection<Integer> collection) {
        return sysRoleRepository.mget(collection);
    }
}
