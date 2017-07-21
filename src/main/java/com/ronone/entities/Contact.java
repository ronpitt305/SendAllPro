package com.ronone.entities;

import javax.persistence.*;

@Entity
public class Contact
{
  @Id
  @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
  private Long id;
  @Column(name="Contact_Name")
  private String contactName;
  @Column(name="Contact_Email")
  private String contactEmail;
  @ManyToOne
  private EmailUser emailUser;
  
  public Contact() {}
  
  public Contact(String contactName, String contactEmail, EmailUser emailUser)
  {
    this.contactName = contactName;
    this.contactEmail = contactEmail;
    this.emailUser = emailUser;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public EmailUser getEmailUser() {
    return emailUser;
  }
  
  public void setEmailUser(EmailUser emailUser) {
    this.emailUser = emailUser;
  }
  
  public String getContactName() {
    return contactName;
  }
  
  public void setContactName(String contactName) {
    this.contactName = contactName;
  }
  
  public String getContactEmail() {
    return contactEmail;
  }
  
  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }
  

  public String toString()
  {
    return "Contact{id=" + id + ", contactName='" + contactName + '\'' + ", contactEmail='" + contactEmail + '\'' + ", emailUser=" + emailUser + '}';
  }
}
