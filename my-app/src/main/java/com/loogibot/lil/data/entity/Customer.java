package com.loogibot.lil.data.entity;

import java.util.UUID;

public class Customer {
  private UUID customerId;
  private String first_name;
  private String last_name;
  private String email;
  private String phone;
  
  public String getFirst_name() {
    return first_name;
  }
  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }
  public String getLast_name() {
    return last_name;
  }
  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public UUID getCustomerId() {
    return customerId;
  }
  public void setCustomerId(UUID serviceId) {
    this.customerId = serviceId;
  }

  @Override
  public String toString() {
    return "Customer [customerId=" + customerId + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
        + email + ", phone=" + phone + "]";
  }
  
  
}
