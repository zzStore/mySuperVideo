package com.symphony.supervideo.controller;

import com.symphony.supervideo.domain.UserInfo;
import com.symphony.supervideo.domain.VideoInfo;
import com.symphony.supervideo.service.UserService;
import com.symphony.supervideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zz.
 * @2018/1/17 14:39.
 * 用户信息控制层
 */

@Controller
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    public VideoService videoService;
    /**
     * 登录主页控制器
     * @zz
     */
    @GetMapping(value = "/index")
    public String index(Model model){
        List<VideoInfo> listInit = new ArrayList<VideoInfo>();
        listInit = videoService.queryAllVideos();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        for (VideoInfo video:listInit) {
            if(video.getVideoURL() != null && !video.getVideoURL().equals("")){
                list.add(video);
            }
        }
        model.addAttribute("list",list);
        return "api/main";
    }
    /**
     * 查询所有用户控制器
     * @zz
     * @return list<UserInfo>
     */
    @RequestMapping (value = "/queryAllUsers",method = RequestMethod.GET)
    public String queryAllUsers(Model model){
        List<UserInfo> list = new ArrayList<UserInfo>();
        list = userService.queryAllUsers();
        model.addAttribute("list",list);
        return "api/queryAllUser";
    }
}
