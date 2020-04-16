package jbr.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.dao.PANDaoImpl;
import jbr.springmvc.model.Pan;

@Service
public class PanServiceImpl implements PanService {
	
	@Autowired
	private PANDaoImpl panDaoImpl;
	

	@Override
	public int register(Pan pan) {
		return panDaoImpl.register(pan);
	}

	@Override
	public ModelAndView validateUser(Pan pan) {
		
		ModelAndView mav = null;
		Pan fetchPan = panDaoImpl.validatePan(pan);
		   
	    if(fetchPan != null)
	    {
	    	mav = new ModelAndView("success");
	    	Double score = fetchPan.getScore();
		    if(score >= 5.0)
		    {
		    	mav.addObject("title", "CreditCard-Eligible");
		    	mav.addObject("bgcolor", "#FF7F50");
		    	mav.addObject("msg", "Congratulations!!! You are eligible for a credit card");
		    }
		    else
		    {
		    	mav.addObject("title", "CreditCard-Not Eligible ");
		    	mav.addObject("bgcolor", "#90EE90");
		    	mav.addObject("msg", "Sorry!!! You are not eligible for a credit card");
		    }
	    }
	    else
	    {
	    	 mav = new ModelAndView("invalid");
	    	 mav.addObject("title", "CreditCard-Invalid ");
		     mav.addObject("bgcolor", "#FF7F50");
		     mav.addObject("msg", "Invalid PAN Entry !!!");
	    }
		return mav;
	}

}
