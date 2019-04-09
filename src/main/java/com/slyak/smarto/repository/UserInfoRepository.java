package com.slyak.smarto.repository;

import com.slyak.smarto.domain.UserInfo;
import com.slyak.spring.jpa.GenericJpaRepository;

/**
 * @author jiangmingjun
 * @create 2019/4/4
 */
public interface UserInfoRepository extends GenericJpaRepository<UserInfo,Long> {
    UserInfo queryByUserName(String userName);
}
