package com.simple.basic.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidVO {
	
	/*
	 * @NotNull - null값만 허용하지 않음(wrapper의 Integer, Long, String 등등)
	 * @NotBlank - null과 공백 둘다 허용하지 않는다. (String에만 적용)
	 * @NotEmpty - null값을 허용하지 않음(Array, list적용) 
	 * @Pattern - 정규표현식에 맞는 문자열을 정의할 수 있음(String타입에만 적용가능)
	 * 
	 * @Email - 이메일형식검증(공백은 통과)
	 * @Min - 최소값
	 * @Max - 최대값
	 */
	
	@NotBlank(message = "이름은 필수입니다")
	private String name;
	
	//문제가 있다 int형은 null을 가질수 없고 기본값이 0인데 어노테이션이 없더라도 
	//값이 비어있다면 공백으로 들어오게되어 파싱에러가 일어난다.
	//숫자, 실수형의 원시타입은 기본값이 0이라서 공백맵핑이 불가능하기 떄문에 래퍼타입으로 선언
	@NotNull(message = "급여는 필수입니다")
	private Integer salary;
	
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호 형식은 000-0000-0000 입니다")
	private String phone;
	
	@NotBlank //동시에 적용
	@Email(message = "email형식이어야 합니다") //email 형식이어야 한다
	private String email;

}
