package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.model.InvoiceDetails;
import com.example.app.service.InvoiceDetailsService;

@RestController
public class AppController {
	@Autowired
	private InvoiceDetailsService invoiceDetailseService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("attachments") MultipartFile attachments,
			@RequestParam("invoiceDocument") MultipartFile invoiceDocument, @RequestParam("data") String data) {
		try {
			invoiceDetailseService.store(attachments, invoiceDocument, data);
			return ResponseEntity.status(HttpStatus.OK).body("Done");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Not done");
		}
	}

	@GetMapping("/getInvioce/{invoiceNumber}")
	public ResponseEntity<Object> getInVoice(@PathVariable("invoiceNumber") String invoiceNumber) {
		System.out.println(invoiceNumber);
		InvoiceDetails invoiceDetails = invoiceDetailseService.getInvoiceDetails(invoiceNumber);
		return invoiceDetails != null ? new ResponseEntity<Object>(invoiceDetails, HttpStatus.OK)
				: new ResponseEntity<>("Not present", HttpStatus.NOT_FOUND);
	}

}
