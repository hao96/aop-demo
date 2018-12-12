package com.hetao.aop.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: aop-demo
 * @description:
 * @author: hetao
 * @create: 2018-12-10 17:11
 **/

@Component
@Aspect
public class MyAspect {

    @Pointcut(value = "execution(public * com.hetao.aop.demo.service.Business.doBusiness())")
    public void pointcut(){}

    /**
     * 在 join point 前执行，但不能阻止执行流向前执行
     */
    @Before("pointcut()")
    public void before(){
        System.out.println("before");
    }

    /**
     * 被调用的方法正常执行结束后
     * @param after
     */
    @AfterReturning(pointcut = "pointcut()",returning = "after")
    public void afterReturn(Object after){
        System.out.println(after.toString());
    }

    /**
     * 无论join point （regardless）是否正常被调用都执行
     */
    @After("pointcut()")
    public void after(){
        System.out.println("after");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("around begin");
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around end");
        return obj;
    }


    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void afterThrow(Exception exception){
        System.out.println(exception.getMessage());
    }

}
