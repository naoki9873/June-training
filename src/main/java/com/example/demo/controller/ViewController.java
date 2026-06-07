package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	private static final int PAGE_SIZE = 10;

	//一覧表示
	@GetMapping("/view")
	public String view(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(required = false) Integer id,
			Model model) {
		//インスタンス生成
		Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("id").ascending());
		Page<UserEntity> userPage;

		//検索処理
		if (id != null) {
			//id検索
			userPage = userService.findById(id, pageable);
		} else {
			//全件取得
			userPage = userService.findAll(pageable);
		}

		//HTMLに渡す　「userList」これ大事
		model.addAttribute("userPage", userPage);
		//HTML返す
		return "view";
	}

}