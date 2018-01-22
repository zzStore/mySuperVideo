package com.symphony.supervideo.repository;

import com.symphony.supervideo.domain.UserInfo;
import com.symphony.supervideo.domain.VideoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zz.
 * @2018/1/18 17:20.
 * 视频资源接口
 */

public interface IVideoRepository extends JpaRepository<VideoInfo,Integer> {

}
