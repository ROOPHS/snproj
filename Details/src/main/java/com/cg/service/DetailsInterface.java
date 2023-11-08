package com.cg.service;

import java.util.List;

public interface DetailsInterface {

	Details addDetails(Details details);
	String deleteDetails(int id);
	Details update(Details details);
	List<Details> getDetails();
	Details getDetailsById(int id);
 
}