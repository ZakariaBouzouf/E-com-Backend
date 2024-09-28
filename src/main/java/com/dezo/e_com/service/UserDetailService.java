package com.dezo.e_com.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dezo.e_com.model.UserProfile;
import com.dezo.e_com.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

  @Autowired
  private UserRepository userRepository;

  private Set set = new HashSet<>();

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
    UserProfile user = userRepository.findByEmail(email).get();

    if(user == null){
      new UsernameNotFoundException("User not exists by Username");
    }
    GrantedAuthority authorities = new SimpleGrantedAuthority(user.getRole().toString());
    set.add(authorities);

    return new org.springframework.security.core.userdetails.User(email,user.getPassword(), set);

  }
}
