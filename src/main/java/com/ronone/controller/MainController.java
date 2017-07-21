package com.ronone.controller;

import com.ronone.entities.EmailUser;
import com.ronone.services.EmailUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController
{

  @Autowired
  private EmailUserService emailUserService;

  @RequestMapping("/")
  public String mainPage()
  {
    return "index";
  }
  
  @RequestMapping("/list")
  public String listpage(Model model) {
    List<EmailUser> users = emailUserService.findAllEmails();
    model.addAttribute("users", users);
    return "list";
  }
}
