package com.dezo.e_com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dezo.e_com.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
