package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetailsRepository extends MongoRepository<Details, Integer> {
	 
	public Details findByid(int getid);
 
}
