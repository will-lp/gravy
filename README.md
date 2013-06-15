Gravy
=====

Gravy is an expression tree builder to query data structures. 

The objective is to create an API which can build object oriented expression trees. These can be matched against a dictionary, which will provide the code to process the expressions, and can be used to query any data structure.

Current status (2013-06-15):

* Modelling.

Main classes for the expression tree structure:

    Expression
    |
    +--Projection
    |  |
    |  +--FieldReference
    |     |
    |     +name: String
    |
    +--Source
    |  |
    |  +--datasource: T
    |
    +--Conditions
       |
       +--Operator 
       |  |
       |  +--Not
       |  +--And
       |  +--Or
       |
       +--FieldReferences: List<FieldReference>


