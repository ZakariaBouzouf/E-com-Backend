package com.dezo.e_com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dezo.e_com.model.Address;
import com.dezo.e_com.model.LoginRequest;
import com.dezo.e_com.model.LoginResponse;
import com.dezo.e_com.model.Role;
import com.dezo.e_com.model.UserProfile;
import com.dezo.e_com.repository.AddressRepository;
import com.dezo.e_com.repository.UserRepository;

@Service
public class UserService {
  private UserRepository userRepository;
  private AddressRepository addressRepository;

  public UserService(UserRepository userRepository,AddressRepository addressRepository) {
    this.userRepository = userRepository;
    this.addressRepository = addressRepository;
  }

  @Autowired
  private PasswordEncoder pwdEncoder;

  public List<UserProfile> retrievAllUsers() {
    List<UserProfile> users = userRepository.findAll();
    return users;
  }

  public UserProfile retrieveSingleUser(Integer id) {
    UserProfile user = userRepository.findById(id).get();
    System.out.println(user.getAddresses());
    return user;
  }

  public boolean createNewUser(UserProfile user) {
    // TODO:Check if all the fields are correct and if the email is used return the proper message
    Optional<UserProfile> userContainer = userRepository.findByEmail(user.getEmail());
    if(userContainer.isEmpty()){
      user.setRole(Role.ROLE_ADMIN);
      user.setPassword(pwdEncoder.encode(user.getPassword()));
      userRepository.save(user);
      return true;
    }
    return false;
  }

  public UserProfile updateUser(int id, UserProfile updatedUser) {
    UserProfile user = userRepository.findById(id).get();
    user.setUsername(updatedUser.getUsername());
    // System.out.println("Created user"+ user);
    userRepository.save(user);
    return user;
  }

    public void deleteUser(int id) {
      UserProfile user = userRepository.findById(id).get();
      List<Address> addresses = user.getAddresses();

      for (Address address : addresses) {
        addressRepository.deleteById(address.getId());
      }

      userRepository.deleteById(id);
    }

  // public boolean authenticate(String email, String password) {
  //   Optional<User> user = userRepository.findByEmail(email);
  //
  //   if (!user.isPresent()) {
  //     throw new Error("User not found");
  //   } else {
  //
  //     System.out.println("We got them");
  //
  //     if (!user.get().getPassword().equals(password)) {
  //       throw new Error("Password false.");
  //     }
  //     System.out.println("Authentication succeed.");
  //     return true;
  //   }
  // }
  public ResponseEntity<LoginResponse> authenticate(String email, String password) {
    Optional<UserProfile> user = userRepository.findByEmail(email);
    LoginResponse response;
    if (!user.isPresent()) {

      response = new LoginResponse(null, "Email doesn't exist.");
      return ResponseEntity.badRequest().body(response);
    } else {

      System.out.println("We got them");

      if (!pwdEncoder.matches(password, user.get().getPassword())){
        response = new LoginResponse(null, "Invalid credentials.");
        return ResponseEntity.badRequest().body(response);
      }
      System.out.println("Authentication succeed.");
      response = new LoginResponse(user.get().getId(),"Authentication succeed.");
      return ResponseEntity.ok().body(response);
    }
  }
}
