package jbr.springmvc.dao;

import jbr.springmvc.model.Pan;

public interface PANDao {
	
	Pan validatePan(Pan pan);
	
	int register(Pan user);

}
