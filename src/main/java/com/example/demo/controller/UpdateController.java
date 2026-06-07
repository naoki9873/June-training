package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.UserForm;
import com.example.demo.service.UpdateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UpdateController {

	private final UpdateService updateService;

	//更新画面表示
	@GetMapping("/update")
	public String upDate(@RequestParam Integer id,
			@ModelAttribute("userForm") UserForm userForm, // ← 追加
			Model model) {
		var form = updateService.findUser(id);
		model.addAttribute("userForm", form);
		return "update";
	}

	//更新ボタン押下処理
	@PostMapping("/doUpdate")
	public String doUpdate(@Validated UserForm userForm, BindingResult bindeingResult, Model model) {
		//バリデーションチェック
		if (bindeingResult.hasErrors()) {

			//DB値取得
			var user = updateService.findUser(userForm.getId());
			//DBの値を渡す
			model.addAttribute("userForm", user);
			return "update";
		}

		//受け取った値を元にDB更新
		updateService.userUpdate(userForm);

		//view返す
		return "redirect:/view";
	}
}