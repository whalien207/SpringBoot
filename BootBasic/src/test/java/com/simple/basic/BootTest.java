package com.simple.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO.Builder;
import com.simple.basic.controller.HomeController;

@SpringBootTest //스프링 부트 테스트 클래스
public class BootTest {
	
	@Autowired
	HomeController homeController;

//	@Test
//	public void testCode01() {
//		System.out.println(homeController);
//	}
	
	//빌더패턴 객체의 사용
	@Test
	public void testCode02() {
//		Builder xx = BuilderVO.builder();
//		xx = xx.setAge(10);
//		xx = xx.setName("하하하");
//		
//		BuilderVO vo = xx.build();
//		System.out.println(vo.toString());
		
		BuilderVO vo = BuilderVO.builder().setAge(10)
											.setName("하하하")
											.build();
		
		System.out.println(vo.toString());
				
		
	}
}
