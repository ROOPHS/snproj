package com.example.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class InvoiceDetails {

	@Id
	private String invoiceNumber;
    @Lob
	private byte[] attachments;
	private double amount;
	private boolean sc_billing;
    @Lob
	private byte[] invoiceDocument;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	private Date date;
	
	public InvoiceDetails() {
		super();
	}
	public InvoiceDetails(String invoiceNumber, byte[] attachments, double amount, boolean sc_billing,
			byte[] invoiceDocument, Date date) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.attachments = attachments;
		this.amount = amount;
		this.sc_billing = sc_billing;
		this.invoiceDocument = invoiceDocument;
		this.date = date;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public byte[] getAttachments() {
		return attachments;
	}
	public void setAttachments(byte[] attachments) {
		this.attachments = attachments;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isSc_billing() {
		return sc_billing;
	}
	public void setSc_billing(boolean sc_billing) {
		this.sc_billing = sc_billing;
	}
	public byte[] getInvoiceDocument() {
		return invoiceDocument;
	}
	public void setInvoiceDocument(byte[] invoiceDocument) {
		this.invoiceDocument = invoiceDocument;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
