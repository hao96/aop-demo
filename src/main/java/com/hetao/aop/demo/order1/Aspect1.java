package com.hetao.aop.demo.order1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: aop-demo
 * @description:
 * @author: hetao
 * @create: 2018-12-11 14:53
 **/

@Aspect
@Component
public class Aspect1{

    @Pointcut("execution(public * com.hetao.aop.demo.service.Business.testAdviceOrder())")
    public void pointcut(){}


    @Before("pointcut()")
    @Order(99)
    public void before1(){
        System.out.println("before 1");
    }

    @Before("pointcut()")
    @Order(100)
    public void before2(){
        System.out.println("before 2");
    }

    @Before("pointcut()")
    @Order(98)
    public void before3(){
        System.out.println("before 3");
    }
}
