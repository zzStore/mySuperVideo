package com.symphony.supervideo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author zz.
 * 2018/1/20 12:17.
 * 各个控制器的AOP日志
 */
@Aspect
@Component
public class ControllerAspect {
    @Before("execution(public * com.symphony.supervideo.controller.VideoController.*(..))")
    public void videoAspect(){
        System.out.println("VideoController运行中");
    }

    @Before("execution(public * com.symphony.supervideo.controller.UserController.*(..))")
    public void userAspect(){
        System.out.println("UserController运行中");
    }
}
