package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public Page<UserEntity> findAll(int page) {
        // 1ページ5件、id昇順で取得
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").ascending());
        return userRepository.findAll(pageable);
    }
}
