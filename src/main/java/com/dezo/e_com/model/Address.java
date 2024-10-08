package com.dezo.e_com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String street;

  private int number;

  @ManyToOne
  @JsonIgnore
  private UserProfile userProfile;

  public Address() {
  }

  public Address(int id, String street, int number, UserProfile userProfile) {
    this.id = id;
    this.street = street;
    this.number = number;
    this.userProfile = userProfile;
  }

  public Address(int id, String street, int number) {
    this.id = id;
    this.street = street;
    this.number = number;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "Address [id=" + id + ", street=" + street + ", number=" + number + "]";
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUser(UserProfile userProfile) {
    this.userProfile = userProfile;
  }
}
