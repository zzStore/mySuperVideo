package com.symphony.supervideo.repository;

import com.symphony.supervideo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zz.
 * @2018/1/17 14:34.
 * 用户信息CRUD接口
 */

public interface IUserRepository extends JpaRepository<UserInfo,Integer> {

}
