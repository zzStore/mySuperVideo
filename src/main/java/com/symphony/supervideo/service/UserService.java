package com.symphony.supervideo.service;

import com.symphony.supervideo.domain.UserInfo;
import com.symphony.supervideo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zz.
 * 2018/1/17 14:36.
 * 用户信息业务逻辑层
 */

@Service
public class UserService {
    @Autowired
    public IUserRepository iUserRepository;

    public List<UserInfo> queryAllUsers(){
        List<UserInfo> list = new ArrayList<UserInfo>();
        list = iUserRepository.findAll();
        return list;
    }
}
