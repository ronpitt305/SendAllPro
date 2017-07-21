package com.ronone.entities;

import com.ronone.entities.enums.UserProfileType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserProfile {

  @Id
  @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
  private Long id;

  @Column(name="type")
  private String type = UserProfileType.USER
    .getUserProfileType();
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if ((o == null) || (getClass() != o.getClass())) { return false;
    }
    UserProfile that = (UserProfile)o;
    
    if (id != null ? !id.equals(id) : id != null) return false;
    return type == null ? true : type != null ? type.equals(type) : false;
  }
  
  public int hashCode()
  {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (type != null ? type.hashCode() : 0);
    return result;
  }
  
  public String toString()
  {
    return "UserProfile{id=" + id + ", type='" + type + '\'' + '}';
  }
}
