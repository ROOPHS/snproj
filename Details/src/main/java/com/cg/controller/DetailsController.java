package com.cg.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.DetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Details")	
	public class DetailsController {
		@Autowired
		private DetailsService detailsservice;

		@PostMapping("/adddetails")
		public ResponseEntity<Object> addDetails(@RequestBody Details details) {
			System.out.println(details);
		return  new ResponseEntity(detailsservice.addDetails(details),(HttpStatus.SC_ACCEPTED));
		}
	    
		
		@GetMapping("/findAllDetails")
		public List<Details> getDetails() {
			return detailsservice.getDetails();
		}
		@GetMapping("/findDetails/{id}")
        public Details getDetails(@PathVariable int id) {
            System.out.println(id);
            return  detailsservice.getDetailsById(id);
        }
		
		@GetMapping("/")
		String send() {
			return "server is running";
		}

		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Object> deleteDetails(@PathVariable int id) {
			System.out.println(id);
			HashMap<String, String> hashMap = new HashMap<String,String>();
			
			if(detailsservice.deleteDetails(id)!=null)
				hashMap.put("message","id deleted");
			else {
				hashMap.clear();
				hashMap.put("message", "id not delete");
			}
			return new ResponseEntity(hashMap,HttpStatus.OK) ;
		}
      
		@PutMapping("/update")
		public ResponseEntity<Object> updateNameById(@RequestBody Details details) {
			return new ResponseEntity(detailsservice.update(details),HttpStatus.SC_ACCEPTED);
		}


}
