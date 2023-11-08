package com.example.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.InvoiceDetails;

public interface InvoiceDetailsREpo extends JpaRepository<InvoiceDetails, String> {

	InvoiceDetails getInvoiceDetailsByInvoiceNumber(String invoiceNumber);
}
