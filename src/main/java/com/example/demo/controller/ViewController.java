package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {
	
	private final UserService userService;
	
	//一覧表示
	@GetMapping("/view")
	public String view(Model model) {
		
		//DB取得する
		var userList = userService.getAllUser();
		
		//HTMLに渡す　「userList」これ大事
		model.addAttribute("userList" , userList);
		
		//HTML返す
		return "view";
	}
	
}
