package com.ronone.services;

import com.ronone.dao.SendEmailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

  @Autowired
  private SendEmailDao sendEmailDao;

  public void saveEmailToSend(com.ronone.entities.EmailToSend emailToSend) {
    sendEmailDao.save(emailToSend);
  }
  
  public com.ronone.entities.EmailToSend findByMessage(String s) {
    return sendEmailDao.findByMessage(s);
  }
}
