# springbootRest
This repo will have Rest api with Spring boot. Three branches will have 3 different DAO implementation.
1. Use EntityManager but leverage native Hibernate API.
2. Use EntityManager and standard JPA API
3. Spring Data JPA


Methods of RestController
1. GetRequest to get the list all employees.
2. Post to insert a employee to table
   if there is a id in the body of the request. Ignore that id and use the autoincrement for id (primary key)
   and return the employee with the autoincremented id
3. Put to update an employee.
4. Delete an employee from table.
5. Get for finding a employee by id
http://localhost:8090/employee/3

6. get a list of employees with similar firstname and greater than an id
http://localhost:8090/employeelist?id=0&name=Koe
