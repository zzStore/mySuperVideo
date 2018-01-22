package com.symphony.supervideo.service;

import com.symphony.supervideo.domain.VideoInfo;

import com.symphony.supervideo.repository.IVideoRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zz.
 * @2018/1/18 17:21.
 * 视频信息业务逻辑层
 */
@Service
public class VideoService {

    @Autowired
    public IVideoRepository iVideoRepository;

    /**
     * 查询所有视频资源
     * @return list<VideoInfo>
     * @author zz
     */
    public List<VideoInfo> queryAllVideos(){
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        list = iVideoRepository.findAll();
        return list;
    }

    /**
     * 计划任务,定时更新网站资源
     * @author zz
     */
    @Scheduled(fixedRate = 20000)
    public void autoUpdateVideos()throws Exception{
        System.out.println("网站资源更新中");
        updateVideos("https://v.qq.com/index.html");
    }

    /**
     * 获取目标网站的视频资源
     * @ author zz
     * @throws IOException
     */
    public void catchVideos(String url) throws IOException,Exception{
//        url="https://v.qq.com/index.html";
        Document doc = Jsoup.connect(url).get();
        //查找属性对应的标签,获取网站标题信息
//        System.out.println(doc.toString());
        Elements elements = doc.select("div [class=list_item] a,[class=figure_pic]"); //该网站标题统一格式
//        System.out.println(elements.toString());
        int i = 0;
        for (Element element: elements) {
//            System.out.println(i + "," + element.toString());i++;
            VideoInfo video = new VideoInfo();
            int flag = 0;//如果名字不为空，地址不为空，将视频资源存入数据库
           /* if(element.attr("title") != null &&
                    !element.attr("title").equals("")){
                video.setVideoName(element.attr("title"));
                flag++;
            }*/
            if(element.attr("alt") != null &&
                    !element.attr("alt").equals("")){
                video.setVideoName(element.attr("alt"));
                flag++;
            }
            if(element.attr("lz_src") != null &&
                    !element.attr("lz_src").equals("")){
                video.setVideoMsg(element.attr("lz_src"));
                flag++;
            }
            if(element.attr("href").contains("http")){
                video.setVideoURL(element.attr("href"));
                flag++;
            }
            if(flag == 2){
                Date date = new Date();
                video.setVideoTime(date);
                iVideoRepository.save(video);
            }
        }
        System.out.println("网站视频资源抓取成功");
    }
//未完成
    /*public VideoInfo getImgs(String url,VideoInfo video) throws IOException{
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("div [class=scroll_wrap] a img[class=figure_pic]");
//        System.out.println(elements.toString());
        for (Element ele:elements) {
           if(ele.attr("alt").equals(video.getVideoName()))
//               System.out.println(ele.toString());
//            System.out.println("获取图片信息成功");
            video.setVideoMsg(ele.attr("r-lazyload").toString());
        }
        return video;
    }*/

    /**
     * 更新目标网站的视频资源，遍历视频数据，如果视频名称一致，修改其信息
     * @ author zz
     * @throws IOException
     */
    public void updateVideos(String url) throws IOException,Exception{
//        url="https://v.qq.com/index.html";
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("div [class=list_item] a,img"); //该网站标题统一格式
        for (Element element: elements) {
            List<VideoInfo> list = iVideoRepository.findAll();
            for (VideoInfo video:list) {
                if(element.attr("title") != null &&!element.attr("title").equals("")){
                    if(video.getVideoName().equals(element.attr("title"))){
                        if(element.attr("href").contains("http")){
                            video.setVideoURL(element.attr("href"));
                        }
                            Date date = new Date();
                            video.setVideoTime(date);
                            iVideoRepository.save(video);
                    }
                }
            }
        }
        System.out.println("网站视频资源更新成功");
    }
}
