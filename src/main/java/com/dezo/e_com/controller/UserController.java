package com.dezo.e_com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dezo.e_com.model.Address;
import com.dezo.e_com.model.User;
import com.dezo.e_com.repository.AddressRepository;
import com.dezo.e_com.repository.UserRepository;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AddressRepository addressRepository;

  @GetMapping("/users")
  public List<User> retrievAllUsers() {
    List<User> users = userRepository.findAll();
    return users;
  }

  @GetMapping("/users/{id}")
  public User retrieveSingleUser(@PathVariable int id) {
    User user = userRepository.findById(id).get();
    System.out.println(user.getAddresses());
    return user;
  }

  @GetMapping("/users/{id}/address")
  public List<Address> retrieveAddresses(@PathVariable int id) {
    Optional<User> user = userRepository.findById(id);

    List<Address> address = user.get().getAddresses();
    return address;
  }

  @PostMapping("/users")
  public User createNewUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  @PutMapping("/users/{id}")
  public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
    User user = userRepository.findById(id).get();
    user.setUsername(updatedUser.getUsername());
    // System.out.println("Created user"+ user);
    userRepository.save(user);
    return user;
  }

  @PostMapping("/users/{id}/address")
  public User addAddress(@PathVariable int id, @RequestBody Address address) {
    User user = userRepository.findById(id).get();
    user.getAddresses().add(address);
    address.setUser(user);
    System.out.println("newUser" + user.getAddresses());
    addressRepository.save(address);
    userRepository.save(user);
    return user;
  }

  @GetMapping("/users/{id}/address/{idAddress}")
  public Address retrieveOneAddress(@PathVariable int id, @PathVariable int idAddress) {
    Address address = addressRepository.findById(idAddress).get();
    return address;
  }

  @PutMapping("/users/{id}/address/{idAddress}")
  public Address updateAnAddress(@PathVariable int id, @PathVariable int idAddress,
      @RequestBody Address updatedAddress) {
    Address address = addressRepository.findById(idAddress).get();
    address.setStreet(updatedAddress.getStreet());
    address.setNumber(updatedAddress.getNumber());
    addressRepository.save(address);

    return address;
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    User user = userRepository.findById(id).get();
    List<Address> addresses = user.getAddresses();

    for(Address address : addresses){
      addressRepository.deleteById(address.getId());
    }

    userRepository.deleteById(id);
  }

  @DeleteMapping("/users/{id}/address/{idAddress}")
  public void deleteAddress(@PathVariable int id, @PathVariable int idAddress) {
    addressRepository.deleteById(idAddress);
  }

}
