package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity;

//参照型じゃないといけない　注）Integerにする
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Page<UserEntity> findById(Integer id, Pageable pageable); // 追加

}
