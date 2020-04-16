package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Pan;
import jbr.springmvc.service.PanServiceImpl;

@Controller
public class CreditCardCheckController {

  
  @Autowired
  private PanServiceImpl panServiceImpl;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView showIndex(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("index");
    mav.addObject("pan", new Pan());
    return mav;
  }

  @RequestMapping(value = "/checkEligibility", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("pan") Pan pan) {
    ModelAndView mav = panServiceImpl.validateUser(pan);
    return mav;
  }

}
