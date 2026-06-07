package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {
	
	private final UserService userService;
	
	//一覧表示
	@GetMapping("/view")
	public String view(@RequestParam(defaultValue = "0") int page , Model model) {
		
		Page<UserEntity> userPage = userService.findAll(page);
		
		
		
		//HTMLに渡す　「userList」これ大事
		model.addAttribute("userPage" , userPage);
		
		//HTML返す
		return "view";
	}
	
}
