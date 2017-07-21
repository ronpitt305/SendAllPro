package com.ronone.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
  private JavaMailSender javaMailSender;

  @Autowired
  public void setJavaMailSender(JavaMailSender javaMailSender)
  {
    this.javaMailSender = javaMailSender;
  }
  
  public void send(String to, String subject, String text) throws MessagingException
  {
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(text);
    helper.setReplyTo("DONOTREPLY@RONONE.COM");
    
    javaMailSender.send(message);
  }
}
