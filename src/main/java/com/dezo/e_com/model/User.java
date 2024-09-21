package com.dezo.e_com.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "users")
public class User {
  @Id
  @GeneratedValue
  private int id;

  private String username;

  @OneToMany(mappedBy = "user")
  private List<Address> address;

  public User() {
  }

  public User(int id, String username, List<Address> address) {
    this.id = id;
    this.username = username;
    this.address = address;
  }

  public User(int id, String username) {
    this.id = id;
    this.username = username;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  // public Address getAddress() {
  //   return address;
  // }
  //
  // public void setAddress(Address address) {
  //   this.address = address;
  // }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username +  "]";
  }

  public List<Address> getAddress() {
    return address;
  }

  public void setAddress(List<Address> address) {
    this.address = address;
  }

}
