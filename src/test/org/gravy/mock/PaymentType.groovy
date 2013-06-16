package org.gravy.mock

enum PaymentType {
  CREDIT_CARD(1, "Credit card"), 
  DEBIT_CARD(2, "Debit card"), 
  MONEY(3, "Money"), 
  CHECK(4, "Check")
  
  Integer code
  String description
  
  private PaymentType(Integer code, String description) {
    this.code = code
    this.description = description
  }
  
  Integer getCode() { code }
  String getDescription() { description }
}
