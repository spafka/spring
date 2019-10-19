package io.github.spafka;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

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
@ComponentScan
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
}

@Component
class C {

	@Autowired
	A a;
	@Autowired
	B b;
}
@Component
class  D{

}