package com.hetao.aop.demo;

import com.hetao.aop.demo.service.Business;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopDemoApplicationTests {

    @Autowired
    private Business business;


    @Test
    public void contextLoads() {

//        System.out.println(business.doBusiness());

        business.testAdviceOrder();

    }

}
