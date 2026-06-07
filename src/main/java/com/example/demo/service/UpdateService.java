package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.UserForm;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateService {
	
	private final UserRepository userRepository;
	
	//ID元にDB取得
	public UserEntity findUser(Integer id) {
		return userRepository.findById(id).get();
	}
	
	//更新処理
	public void userUpdate(UserForm userForm) {
		//インスタンス生成
	    UserEntity entity = new UserEntity();
	    entity.setId(userForm.getId());
	    entity.setName(userForm.getName());
	    entity.setAge(userForm.getAge());
	    entity.setMessage(userForm.getMessage());
	    
	    //保存処理
	    userRepository.save(entity);
	}
	
}
