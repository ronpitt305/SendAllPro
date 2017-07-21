package com.ronone.services;

import com.ronone.dao.EmailUserDao;
import com.ronone.entities.EmailUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailUserService {

  @Autowired
  public EmailUserDao emailUserDao;

  public void saveEmailUser(EmailUser emailUser)
  {
    emailUserDao.save(emailUser);
  }
  
  public List<EmailUser> findAllEmails() {
    return (List)emailUserDao.findAll();
  }
  
  public EmailUser findEUserByID(Long id) {
    return emailUserDao.findOne(id);
  }

}
