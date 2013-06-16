package org.gravy

import org.gravy.Gravy
import org.gravy.mock.*

class SqlTest extends GroovyTestCase {
  
  /**
   * A simple query test. Must return every invoice in the database
   */
  void testSimpleSelect() {
    def invoices = [
      new Invoice(total: 10.0), new Invoice(total: 20.0),
      new Invoice(total: 30.0), new Invoice(total: 40.0),
      new Invoice(total: 50.0),
    ]
    
    List<Object[]> result = Gravy.pick( Invoice ) { Invoice invoice ->
      select invoice, invoice.total
      from invoices
    }
    
    assert result[0][0] instanceof Invoice
    assert result[0][1] == 10.0
    assert result[1][1] == 20.0
    assert result[4][1] == 50.0
  }
  
  
  /**
   * A simple query test. Must return every invoice in the database
   */
  void testAlternativeSimpleSelect() {
    def invoices = [
      new Invoice(total: 10.0), new Invoice(total: 20.0),
      new Invoice(total: 30.0), new Invoice(total: 40.0),
      new Invoice(total: 50.0),
    ]
    
    List<Object[]> result = Gravy.jpql {
      def invoice = from invoices
      select invoice, invoice.total
    }
    
    assert result[0][0] instanceof Invoice
    assert result[0][1] == 10.0
    assert result[1][1] == 20.0
    assert result[4][1] == 50.0
  }
  
  
  
  /**
   * This test must select from database using jpa (or whatever, 
   * i have no idea :-))
   * 
   */
  void testDatabaseSelect() {
    def itemsSizeLimit = 10
    Gravy.pick(Invoice) { Invoice invoice ->
      select invoice
      from Invoice
      where invoice.items.size() le itemsSizeLimit
      and invoice.soldDate gt '2013-01-01' or invoice.change gt 0
      limit 10, 20
    }
  }
  
  
  /**
   * This test must project a map
   */
  void testSelectMap() {
    Iterator<Map> iter = Gravy.pick(Product) { Product p ->
      select map([id: p.id, name: p.name])
      from Product
    }
  }
  
  
  /**
   * Must create a query to select all invoices' totals with an alias
   */
  void testAliases() {
    Gravy.from(Invoice) { Invoice invoice ->
      select invoice.total.as "full price" 
    }
  }
  
  
  /**
   * Must create a query to select all invoice having more than 10 itens. 
   * For those, project the total price of the invoice multiplied by
   * a tax, according to the kind of payment was made.
   * 
   */
  void testInnerSelectProjection() {
    Gravy.from(Invoice) { Invoice invoice ->
      select invoice.total * { // TODO: multiply? really? :-(
        'case' {
          when invoice.invoicePaymentType eq InvoicePaymentType.MIXED 
            then 0.17
          'else' 0.12
        }
      }.as("total tax"), 
      where {
        invoice.items.size() > 10
      }
    }
  }
  
  
  void testSearchCriterias() {
    
  }
  
  
  /**
   * How to query a xml?
   */
  void testDifferentDatasource() {
    
  }
  
  
  void testJoin() {
    Gravy.from(Invoice, Product, Item) { Invoice invoice, Product product, Item item ->
      select invoice, product, item.price
      from Invoice, Product, Item
      where product.id eq item.id
      and item.invoice.id eq invoice.id
    }
  }
  
}


