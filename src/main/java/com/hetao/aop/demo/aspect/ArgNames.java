package com.hetao.aop.demo.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: aop-demo
 * @description:
 * @author: hetao
 * @create: 2018-12-12 11:42
 **/

@Aspect
@Component
public class ArgNames {


    /**
     *
     * args() argNames() point() 三个参数 名字，顺序 需一一对应
     *
     * @param name
     */
    @Pointcut(value = "execution(public * com.hetao.aop.demo.service.Business.testAdviceArgName(..)) && args(name,age)", argNames = "name,age")
    public void point(String name,int age){}


    /**
     *
     * point() 中的参数 与pointcut中的 参数 是按顺序对应的
     *
     * point() 中的参数 与argNames中的参数是 按名字匹配的
     *
     * argNames 中的参数 与 before中的参数 是按顺序和名字匹配的
     *
     * @param age
     * @param name
     */
    @Before(value = "point(name,age)",argNames = "name,age")
    public void before(String name,int age){
        System.out.println("name : " + name + "," + "age : " + age);
    }

    @AfterThrowing(value = "point(name,age)",throwing = "exception",argNames = "name,age,exception")
    public void afterThrow(String name,int age,Exception exception){
        System.out.println("throw : " + name);
        System.out.println("throw : " + age);
        System.out.println("throw : " + exception.getMessage());
    }



}
