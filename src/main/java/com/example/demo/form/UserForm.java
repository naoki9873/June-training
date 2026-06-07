package com.example.demo.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
	
	private int id;
	
	@NotBlank(message = "入力してください")
	@Size(min = 3 , max = 10 ,message = "3から10文字で入力してください")
	private String name;
	
	@NotNull(message = "入力してください")
	@Min(value = 0 ,message = "0才以上でで入力してください")
	private Integer age ;
	
	@NotBlank(message = "入力してください")
	private String message ;

}
