package com.simple.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.basic.controller.HomeController;

@Configuration //개별적인 스프링 빈 설정 파일
public class WebConfig implements WebMvcConfigurer{
	
	//빈을 확인할 수 있는 장소
	@Autowired
	ApplicationContext applicationContext;
	
	@Value("${server.port}")
	String port;
	
	//해당 메서드 실행하게 됨.
	@Bean 
	public void test() {
		TestBean t = applicationContext.getBean(TestBean.class);
		System.out.println(t);
		
		HomeController h = applicationContext.getBean(HomeController.class);
		System.out.println(h);
		
		int count = applicationContext.getBeanDefinitionCount();
		System.out.println("빈의 개수: " + count);
		
		System.out.println("properties 선언된 값: " + port);
	}
	
	@Bean
	public TestBean testBean() {
		return new TestBean();
	}
}
