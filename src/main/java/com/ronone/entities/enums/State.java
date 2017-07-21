package com.ronone.entities.enums;


public enum State
{
  ACTIVE("ACTIVE"), 
  INACTIVE("INACTIVE"), 
  DELETED("DELETED"), 
  LOCKED("LOCKED");
  
  private String state;
  
  private State(String state) {
    this.state = state;
  }
  
  public String getState() {
    return state;
  }
  
  public String toString()
  {
    return state;
  }
}
