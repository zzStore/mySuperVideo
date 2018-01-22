package com.symphony.supervideo.controller;

import com.symphony.supervideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * @author zz.
 * @2018/1/18 17:04.
 * 视频资源控制层
 */
@Controller
public class VideoController {

    @Autowired
    private VideoService videoService;
    /**
     * 登录管理员主界面
     * @ author zz
     */
    @GetMapping(value = "/adminLogin")
    public String adminLogin(){
        return "api/adminMain";
    }
    /**
     * 输入完爬虫目标网站后，返回管理员主界面
     * @ author zz
     */
    @GetMapping(value = "/catchVideo")
    public String catchVideo(String url) throws IOException,Exception{
        videoService.catchVideos(url);
        return "api/adminMain";
    }

}
