package com.ronone.controller;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController
{
  
  private static Logger logger = org.slf4j.LoggerFactory.getLogger(ErrorController.class);
  
  @ExceptionHandler({Throwable.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String exception(Throwable throwable, Model model) {
    logger.error("There was a problem in spring security", throwable);
    String errorMessage = throwable != null ? throwable.getMessage() : "Unknown Error";
    model.addAttribute("errorMessage", errorMessage);
    return "error";
  }
}
