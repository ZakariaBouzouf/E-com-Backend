package com.dezo.e_com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dezo.e_com.model.UserProfile;

public interface UserRepository extends JpaRepository<UserProfile,Integer>{
  Optional<UserProfile> findByEmail(String email);
}
