package com.dezo.e_com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dezo.e_com.model.Role;
import com.dezo.e_com.model.UserProfile;
import com.dezo.e_com.repository.UserRepository;

//@Component
public class DataInitializer {

  @Bean
  CommandLineRunner init(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
    System.out.println("PASSWORD" + passwordEncoder.encode("123"));
    return args -> {
      // Only insert data if not already present
      if (userRepository.findByEmail("dezo@test.com") == null) {
        System.out.println("Saving the user");
        userRepository
            .save(new UserProfile(1, "dezo", "dezo@test.com", passwordEncoder.encode("123"), Role.ROLE_ADMIN));
      }
    };
  }
}
