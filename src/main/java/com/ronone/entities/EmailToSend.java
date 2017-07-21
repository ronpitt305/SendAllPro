package com.ronone.entities;

import java.util.List;
import javax.persistence.*;

@Entity
public class EmailToSend
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long emailSendId;

  @OneToOne
  private EmailUser emailUser;

  @OneToMany
  private List<Contact> contactsToSend;

  @Column(name="message")
  private String message;
  
  public EmailToSend() {}
  
  public EmailToSend(EmailUser emailUser, List<Contact> contactsToSend, String message)
  {
    this.emailUser = emailUser;
    this.contactsToSend = contactsToSend;
    this.message = message;
  }
  
  public EmailUser getEmailUser() {
    return emailUser;
  }
  
  public void setEmailUser(EmailUser emailUser) {
    this.emailUser = emailUser;
  }
  
  public List<Contact> getContactsToSend() {
    return contactsToSend;
  }
  
  public void setContactsToSend(List<Contact> contactsToSend) {
    this.contactsToSend = contactsToSend;
  }
  
  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
}
