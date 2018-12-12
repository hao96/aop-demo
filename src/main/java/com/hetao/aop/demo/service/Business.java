package com.hetao.aop.demo.service;

import org.springframework.stereotype.Service;

/**
 * @program: aop-demo
 * @description:
 * @author: hetao
 * @create: 2018-12-10 17:13
 **/

@Service
public class Business {

    public String doBusiness(){
//        throw new NullPointerException("空空如也！");
        return "干大事情！！";
    }

    public void testAdviceOrder(){
        System.out.println("test order");
    }

    public void testAdviceArgName(String name , int age){
        System.out.println("我的名字:" + name + ",我的年龄:" + age);
        throw new NullPointerException("空空");
    }

    public void testAdeviceArgs(String name , String sex , int age){
        System.out.println("我的名字:" + name + ", 我的性别:" + sex + ", 我的年龄:" + age);
    }
}
