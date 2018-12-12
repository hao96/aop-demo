package com.hetao.aop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: aop-demo
 * @description:
 * @author: hetao
 * @create: 2018-12-12 16:01
 **/

@Aspect
@Component
public class Args {

    /**
     * 得到传到 join point 方法中的多个参数
     */

    @Pointcut("execution(public * com.hetao.aop.demo.service.Business.testAdeviceArgs(..))")
    public void point(){}

    @Before(value = "point()")
    public void before(JoinPoint joinPoint){
        //打印所调用的方法名
        System.out.println(joinPoint.getSignature());
        //得到参数
        Object[] objects = joinPoint.getArgs();
        for (Object object : objects){
            System.out.println(object.toString());
        }
    }
}
