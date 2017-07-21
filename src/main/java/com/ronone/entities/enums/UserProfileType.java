package com.ronone.entities.enums;


public enum UserProfileType
{
  DBA("DBA"), 
  USER("USER"), 
  ADMIN("ADMIN");
  
  String userProfileType;
  
  private UserProfileType(String userProfileType) {
    this.userProfileType = userProfileType;
  }
  
  public String getUserProfileType() {
    return userProfileType;
  }
}
