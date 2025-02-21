package com.loogibot.lil.data.entity;

import java.util.UUID;

public class Customer {
  private UUID customerId;
  private String name;

  public UUID getCustomerId() {
    return customerId;
  }
  public void setCustomerId(UUID serviceId) {
    this.customerId = serviceId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public String toString() {
    return "Customer [serviceId=" + customerId + ", name=" + name + "]";
  }
  
}
