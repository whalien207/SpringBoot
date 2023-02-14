package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.ValidVO;

@Controller
@RequestMapping("/valid")
public class ValidController {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "valid/ex01";
	}
	
	//@Valid - 유효성검사를 진행,
	//Errors - 유효성 검사에 실패하면 에러 객체로 바인딩..
	@PostMapping("/actionForm")
	public String actionForm(@Valid ValidVO vo, Errors error, Model model) {
		
		System.out.println("!!! 에러 갯수:" + error.getErrorCount());
		
		//hasErrors - error가 있다면 True, 없다면 False
		
		if(error.hasErrors()) {
			List<FieldError> list = error.getFieldErrors(); //에러가 발생된 목록들
			
			for(FieldError err : list) {
//				System.out.println(err.getField()); //에러필드명
//				System.out.println(err.getDefaultMessage()); //에러메세지
				
				if(err.isBindingFailure()) { //유효성 검사의 실패가 아니라, 자바 내부의 에러라면 true
					model.addAttribute("valid_" + err.getField() , "형식이 올바르지 않습니다.");
				}else { //유효성 검사에 실패한 목록
					model.addAttribute("valid_" + err.getField() , err.getDefaultMessage());
				}
			}
			
			//사용자가 입력했던 값들을 유지 시켜주기
			model.addAttribute("vo", vo);
			
			return "valid/ex01"; //원래 화면으로 돌아가도록 처리
		}
		

		
		System.out.println(vo.toString());
		return "valid/ex01_result";
	}
	

}
