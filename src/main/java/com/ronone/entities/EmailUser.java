package com.ronone.entities;

import com.ronone.entities.enums.State;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="users")
public class EmailUser
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="first_name")
  private String firstName;
  @Column(name="last_name")
  private String lastName;
  @Column(name="username")
  private String username;
  @Column(name="password")
  private String password;
  private String confirmPassword;
  @Column(name="email")
  private String email;
  @Column(name="state")
  private String state = State.ACTIVE
    .getState();
  @ManyToMany
  private Set<UserProfile> userProfiles = new HashSet();
  
  @OneToMany
  private List<Contact> contacts;
  
  @OneToOne
  private EmailToSend emailToSend;
  

  public EmailUser() {}
  
  public EmailUser(String firstName, String lastName, String username, String password, String confirmPassword, String email)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.email = email;
  }
  
  public EmailUser(String firstName, String lastName, String username, String password, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.email = email;
  }
  
  public EmailUser(String username, String password) {
    this.username = username;
    this.password = password;
  }
  
  public Long getId()
  {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getConfirmPassword() {
    return confirmPassword;
  }
  
  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public List<Contact> getContacts() {
    return contacts;
  }
  
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }
  
  public String getState() {
    return state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public Set<UserProfile> getUserProfiles() {
    return userProfiles;
  }
  
  public void setUserProfiles(Set<UserProfile> userProfiles) {
    this.userProfiles = userProfiles;
  }
}
