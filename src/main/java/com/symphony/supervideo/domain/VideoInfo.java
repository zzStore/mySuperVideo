package com.symphony.supervideo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author zz.
 * 2018/1/18 17:07.
 */
@Entity
public class VideoInfo {

    @Id  //JPA中要添加主键注解
    @GeneratedValue //该注解让id从1开始自动递增，依次+1
    private Integer videoId;

    private String videoName;

    private Date videoTime;

    private String videoURL;

    private String videoMsg;

    private String videoComment;

    private Integer videoSum;

    public VideoInfo() {
        videoSum = 0;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Date getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Date videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getVideoMsg() {
        return videoMsg;
    }

    public void setVideoMsg(String videoMsg) {
        this.videoMsg = videoMsg;
    }

    public String getVideoComment() {
        return videoComment;
    }

    public void setVideoComment(String videoComment) {
        this.videoComment = videoComment;
    }

    public Integer getVideoSum() {
        return videoSum;
    }

    public void setVideoSum(Integer videoSum) {
        this.videoSum = videoSum;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "videoId=" + videoId +
                ", videoName='" + videoName + '\'' +
                ", videoTime=" + videoTime +
                ", videoURL='" + videoURL + '\'' +
                ", videoMsg='" + videoMsg + '\'' +
                ", videoComment='" + videoComment + '\'' +
                ", videoSum=" + videoSum +
                '}';
    }
}

