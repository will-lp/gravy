package org.gravy.mock

class Invoice {
  Long id
  BigDecimal total
  List<Item> items
  Client client
  Date soldDate
  Integer invoicePaymentType // codes in InvoicePaymentType enum
  BigDecimal change
  Integer changeType // in PaymentType enum
}
