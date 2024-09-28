package com.dezo.e_com.model;

public class LoginResponse {
  private Integer id;
  private String message;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public LoginResponse() {
  }
  public LoginResponse(Integer id, String message) {
    this.id = id;
    this.message = message;
  }
}
