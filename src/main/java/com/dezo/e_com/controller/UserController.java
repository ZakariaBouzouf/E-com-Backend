package com.dezo.e_com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dezo.e_com.model.Address;
import com.dezo.e_com.model.UserProfile;
import com.dezo.e_com.service.AddressService;
import com.dezo.e_com.service.UserService;


@RestController
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private AddressService addressService;

  @GetMapping("/users")
  public List<UserProfile> retrievAllUsers() {
    return userService.retrievAllUsers();
  }

  @GetMapping("/users/{id}")
  public UserProfile retrieveSingleUser(@PathVariable int id) {
    return userService.retrieveSingleUser(id);
  }

  @GetMapping("/users/{id}/address")
  public List<Address> retrieveAddresses(@PathVariable int id) {
    return addressService.retrieveAddresses(id);
  }

  @PutMapping("/users/{id}")
  public UserProfile updateUser(@PathVariable int id, @RequestBody UserProfile updatedUser) {
    return userService.updateUser(id,updatedUser);
  }

  @PostMapping("/users/{id}/address")
  public UserProfile addAddress(@PathVariable int id, @RequestBody Address address) {
    return addressService.addAddress(id,address);
  }

  @GetMapping("/users/{id}/address/{idAddress}")
  public Address retrieveOneAddress(@PathVariable int id, @PathVariable int idAddress) {
    return addressService.retrieveOneAddress(id,idAddress);
  }

  @PutMapping("/users/{id}/address/{idAddress}")
  public Address updateAnAddress(@PathVariable int id, @PathVariable int idAddress,
      @RequestBody Address updatedAddress) {
    return addressService.updateAnAddress(id,idAddress,updatedAddress);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteUser(id);
  }

  @DeleteMapping("/users/{id}/address/{idAddress}")
  public void deleteAddress(@PathVariable int id, @PathVariable int idAddress) {
    //TODO:Check if the id of user is required or not
    addressService.deleteAddress(id,idAddress);
  }

}
