package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.repository.DetailsRepository;

@Service
@Component
public class DetailsService implements DetailsInterface {
	private DetailsRepository detailsRepository;
	DetailsService detailsservice;

	@Autowired
	public DetailsService(DetailsRepository detailsRepository) {
		super();
		this.detailsRepository = detailsRepository;
	}

	@Override
	public Details addDetails(Details details) {
		System.out.println("Times");
		if (detailsRepository.findByid(details.getId())==null) {
			detailsRepository.save(details);
			System.out.println("");
			return details;
		}
		System.out.println("Error");
		throw new DetailsAlreadyFoundException();
	}

	@Override
	public String deleteDetails(int id) {
		if (detailsRepository.findByid(id)!= null) {
			detailsRepository.deleteById(id);
			return " id deleted";
		}
		throw new DetailsNotFoundException();
	}

	@Override
	public Details update(Details details) {
		Details details2 = detailsRepository.findByid(details.getId());
		if(details2!=null) {
			
			if(details.getAccount()==null || details.getAccount()==""){
				details.setAccount(details2.getAccount());
		}
			
			if(details.getStatus()==null || details.getStatus()==""){
				details.setStatus(details2.getStatus());
		}
			
			if(details.getExecutionArea()==null || details.getExecutionArea()==""){
				details.setExecutionArea(details2.getExecutionArea());
		}
			
			
			
		return detailsRepository.save(details);
	}
		throw new DetailsNotFoundException();
 }

     @Override
     public List<Details> getDetails() {
	 return (List<Details>) detailsRepository.findAll();
  }
	
	 @Override
	 public Details getDetailsById(int id) {
		System.out.println(id);
		Details findByid = detailsRepository.findByid(id);
		if(findByid!=null) {
			System.out.println(findByid);
			return findByid;
		}
		throw new DetailsNotFoundException();
	}
}