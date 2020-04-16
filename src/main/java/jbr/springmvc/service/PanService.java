package jbr.springmvc.service;

import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Pan;

public interface PanService {
	
	 int register(Pan pan);

	 ModelAndView validateUser(Pan pan);

}
