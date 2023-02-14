package com.simple.basic.mapper;
import org.apache.ibatis.annotations.Mapper;

//Mapper 어노테이션 필수필수~! 
//스프링 부트에서는 매퍼 인터페이스 꼭 붙이세요
@Mapper 
public interface TestMapper {
	
	public String getTime();
	
}

