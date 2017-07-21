package com.ronone.controller;

import com.ronone.entities.EmailUser;
import com.ronone.services.EmailUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewUserController
{
  @Autowired
  private EmailUserService emailUserService;

  
  @RequestMapping("/adde")
  public String addEmailUser(Model model)
  {
    model.addAttribute("emailUser", new EmailUser());
    return "addeuser";
  }
  
  @PostMapping("/savedEUser")
  public String savedEmailUser(Model model, @org.springframework.web.bind.annotation.ModelAttribute("emailUser") EmailUser emailUser)
  {
    model.addAttribute("emailUser", new EmailUser());
    emailUserService.saveEmailUser(emailUser);
    return "addeuser";
  }
}
