package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.UserForm;
import com.example.demo.service.InsertService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InsertController {

	private final InsertService insertService;

	//入力画面表示
	@GetMapping("/insert")
	public String insert(Model model) {
		//空のオブジェクト渡す
		model.addAttribute("userForm", new UserForm());
		//入力画面表示
		return "insert";
	}

	//登録ボタン押下処理
	@PostMapping("/doInsert")
	public String doInsert(@Validated UserForm userForm , BindingResult bindingResult) {
		
		//バリデーションチェック
		if(bindingResult.hasErrors()) {
			return "insert";
		}
		
		//引数を元にDB登録する
		insertService.userInsert(userForm);
		//view画面リダイレクト
		return "redirect:/view";
	}
}
