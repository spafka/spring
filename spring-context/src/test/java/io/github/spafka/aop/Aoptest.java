package io.github.spafka.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan(value = "io.github.spafka.aop")
@Configuration
@EnableAspectJAutoProxy
public class Aoptest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Aoptest.class);

        applicationContext.start();

        Aoptest aoptest = (Aoptest) applicationContext.getBean("aoptest");

        aoptest.work();


    }

    public void work() {
        System.out.println("my name is van!");
    }
}







