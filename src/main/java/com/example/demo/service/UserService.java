package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	//ユーザー全件取得メソッド
	public List<UserEntity> getAllUser(){
		return userRepository.findAll();
	}
	
	public Page<UserEntity> findById(Integer id,Pageable pageable) {
        return userRepository.findById(id , pageable);
    }
	
	public Page<UserEntity> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
