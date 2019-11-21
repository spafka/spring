package io.github.spafka;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class Ioctest {

	@Test
	public void init() {



		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);

		applicationContext.start();


		Map<String, String> map = (Map<String, String>) applicationContext.getBean("map");

		String van = map.get("deep");

		System.out.println(van);
	}
}

@Configuration
@ComponentScan(value = {})
class config {

	@Bean("map")
	Map map() {

		return new HashMap() {{
			put("deep", "dark");
		}};
	}

}

@Component
class A {

}

@Component
class B {
	@Autowired
	D d;

	@PostConstruct
	public void init(){

		System.out.println("init method in b");
	}

	public B() {

		System.out.println("B 的私有方法被调用");
	}

	private B(String args[]) {

		System.out.println("B 的私有方法 String args[] 被调用");
	}
}

@Component
class C {

	@Autowired
	A a;
	@Autowired
	B b;
}

@Component
class D {

}


/**
 * 后置处理器：初始化前后进行处理工作
 * 将后置处理器加入到容器中
 */
//@Component
//@Order(Integer.MAX_VALUE)
class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("postProcessBeforeInitialization..." + beanName + "=>" + bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessAfterInitialization..." + beanName + "=>" + bean);
		return bean;
	}

	public MyBeanPostProcessor() {
		System.out.println("后置处理器");
	}
}