package com.cts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cts.bean.User;
import com.cts.service.UserService;
@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister() {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    
    return mav;
  }
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(@ModelAttribute("user") User user) throws Exception {
  userService.register(user);
  return new ModelAndView("welcome", "Name", user.getName());
  }
}