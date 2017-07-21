package com.ronone.services;

import com.ronone.dao.ContactDao;
import com.ronone.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

  @Autowired
  private ContactDao contactDao;

  public void saveContact(Contact contact) {
    contactDao.save(contact);
  }
  
  public Contact findByContactId(Long id) {
    return contactDao.findOne(id);
  }
  
  public Contact findByContactName(String s) {
    return contactDao.findByContactName(s);
  }
}
