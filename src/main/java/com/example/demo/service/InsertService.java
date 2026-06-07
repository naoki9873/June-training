package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.UserForm;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsertService {

	private final UserRepository userRepository;

	//新規登録処理（Entityにセットする）
	public void userInsert(UserForm userForm) {
		//型変換
		UserEntity user = new UserEntity();
		user.setName(userForm.getName());
		user.setAge(userForm.getAge());
		user.setMessage(userForm.getMessage());
		//saveでDB登録する
		userRepository.save(user);
	}
}
