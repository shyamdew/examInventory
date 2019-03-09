1> update database.propertires 
2> open cmd and run : mvn clean install
3> deploy spring-rest.war in the server 
4> excute sql script
5> use postman client and post the below request
URL : http://localhost:8000/spring-rest/inventory/orders
{  
   "customerId":"shyamdewk@gmail.com",
   "fmtUserId":1,
   "orders":[  
      {  
         "productId":2,
         "quantity":2
      }
   ]
}