# Spring-Cache-Caffeine


By Using spring cache we can reduce the N number of calls like (Not only DataBase Calls but also  Restful Service calls)
In this application 

If i hit http://localhost:8080/customer/ranga2
Result will show in UI but service method(public String sayHai(String customer))
will not execue multiple times it only calls one time so here

ranga2 is a key and its result will store in cache 
