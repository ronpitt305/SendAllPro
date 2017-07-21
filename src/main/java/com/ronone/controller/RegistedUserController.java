package com.ronone.controller;

import com.ronone.entities.Contact;
import com.ronone.entities.EmailToSend;
import com.ronone.entities.EmailUser;
import com.ronone.services.ContactService;
import com.ronone.services.EmailUserService;
import com.ronone.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class RegistedUserController {

  @Autowired
  private ContactService contactService;

  @Autowired
  private SendEmailService sendEmailService;

  @Autowired
  private EmailUserService emailUserService;

  Contact contactHolder = new Contact();
  EmailUser testUser = new EmailUser();
  EmailToSend sendEmailHolder = new EmailToSend();

  
  @RequestMapping("/registed")
  public String getRegistedUserPage(Model model) { model.addAttribute("contact", new Contact());
    return "registed_user_page";
  }
  

  @PostMapping("/addContacts")
  public String postContact(Model model, @ModelAttribute("contact") Contact contact)
  {
    testUser = emailUserService.findEUserByID(Long.valueOf(1L));
    
    model.addAttribute("contact", new Contact());
    contactService.saveContact(new Contact(contact.getContactName(), contact.getContactEmail(), testUser));
    
    contactHolder = contactService.findByContactName(contact.getContactName());
    System.out.println("The current contact saved is with id " + contactHolder.getId() + " who's name is " + contactHolder
      .getContactName());
    
    System.out.println("Contact added" + contact);
    return "redirect:/registedSendEmail";
  }
  
  @RequestMapping("/registedSendEmail")
  public String getEmailMessage(Model model) {
    model.addAttribute("sendEmail", new EmailToSend());
    return "registed_email_to_send";
  }
  
  @PostMapping("/emailSet")
  public String emailSetToSend(Model model, @ModelAttribute EmailToSend emailToSend)
  {
    sendEmailService.saveEmailToSend(new EmailToSend(testUser, emailToSend.getContactsToSend(), emailToSend.getMessage()));
    
    sendEmailHolder = sendEmailService.findByMessage(emailToSend.getMessage());
    
    System.out.println("TEST: " + sendEmailHolder);
    return "redirect:/registed_email_to_send";
  }
}
