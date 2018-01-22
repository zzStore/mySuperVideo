package com.symphony.supervideo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author zz.
 * @2018/1/17 14:22.
 * 用户信息实体类
 */
@Entity
public class UserInfo {
    @Id  //JPA中要添加主键注解
    @GeneratedValue //该注解让id从1开始自动递增，依次+1
    private Integer userId;

    private String userName;

    private String userPass;

    private String userNum;

    private Long userTel;

    private String userStatus;

    public UserInfo() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public Long getUserTel() {
        return userTel;
    }

    public void setUserTel(Long userTel) {
        this.userTel = userTel;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userNum='" + userNum + '\'' +
                ", userTel=" + userTel +
                ", userStatus='" + userStatus + '\'' +
                '}';
    }
}
