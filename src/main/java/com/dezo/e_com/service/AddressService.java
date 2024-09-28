package com.dezo.e_com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dezo.e_com.model.Address;
import com.dezo.e_com.model.UserProfile;
import com.dezo.e_com.repository.AddressRepository;
import com.dezo.e_com.repository.UserRepository;

@Service
public class AddressService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AddressRepository addressRepository;

  public Address retrieveOneAddress(int id,int idAddress) {
    Address address = addressRepository.findById(idAddress).get();
    return address;
  }

  public List<Address> retrieveAddresses(int id) {
    Optional<UserProfile> user = userRepository.findById(id);

    List<Address> address = user.get().getAddresses();
    return address;
  }

  public UserProfile addAddress(int id, Address address) {
    UserProfile user = userRepository.findById(id).get();
    user.getAddresses().add(address);
    address.setUser(user);
    System.out.println("newUser" + user.getAddresses());
    addressRepository.save(address);
    userRepository.save(user);
    return user;
  }

  public Address updateAnAddress(int id, int idAddress,
      Address updatedAddress) {
    Address address = addressRepository.findById(idAddress).get();
    address.setStreet(updatedAddress.getStreet());
    address.setNumber(updatedAddress.getNumber());
    addressRepository.save(address);

    return address;
  }

  public void deleteAddress(int id, int idAddress) {
    addressRepository.deleteById(idAddress);
  }

}
