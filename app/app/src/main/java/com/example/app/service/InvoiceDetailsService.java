package com.example.app.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.model.InvoiceDetails;
import com.example.app.repo.InvoiceDetailsREpo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InvoiceDetailsService {

  @Autowired
  private InvoiceDetailsREpo invoiceDetailsREpo;

  public InvoiceDetails store(MultipartFile attachments,MultipartFile invoiceDocument,String data ) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    InvoiceDetails invoiceDetails = mapper.readValue(data, InvoiceDetails.class);
    invoiceDetails.setAttachments(attachments.getBytes());
    invoiceDetails.setInvoiceDocument(invoiceDocument.getBytes());
    return invoiceDetailsREpo.save(invoiceDetails);
  }
  public InvoiceDetails getInvoiceDetails(String invoiceNumber) {
	  return invoiceDetailsREpo.getInvoiceDetailsByInvoiceNumber(invoiceNumber);
  }
}
