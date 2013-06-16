package org.gravy.mock

/**
 * Checks whether this invoice was paid in one form or in multiple forms
 * 
 */
enum InvoicePaymentType {
  SINGLE(1, "Single"),
  MIXED(2, "Mixed")
  
  Integer code
  String description
  
  private InvoicePaymentType(Integer code, String description) {
    this.code = code
    this.description = description
  }
  
  Integer getCode() { code }
  String getDescription() { description }
}
