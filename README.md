Spring Boot Tutorial

Tools used in this application :
1. Spring Boot, Spring FrameWork
2. Maven
3. JPA, JPA Hibernate, H2 Database, MySQL
4. PostMan

   Various checkpoints

1. Spring Initializer using Maven https://start.spring.io/
   i) Learnt how to inject dependencies and plugins directly into pom.xml
   ii) Add additional dependencies while switching databases

2. Run Spring Boot application via the Application Context
   i) Update application.properties, add in-memory H2 Database and JPA to start
   ii) Important annotations like Bean, AutoWired, etc to give flow control to Spring

4. Create Controller, Service and Repository Layers
   i) Add API Endpoints in Controller Layer
   ii) Implement Service Layer
   iii) Add Custom methods in Repository Layer on top of JPARepository methods

5. Test API Endpoints using Postman, sending HTTP Requests
6. Validate JSON data retrieved from RestFul Client using Hibernate
7. Added Loggers, Lomboks, and many other annotations to reduce boilerplate code

8. Added JUnit Testing + Mockito
   i) Test cases in Controller Layer, mocked Rest API calls
   ii) Testing in Service Layer, mocking Respository Layer
   iii) Tested Repository Layer, used EntityManager to mock a database

9. Switch Database from H2 to MySQL
   i) Install MySQL instance on machine and MySQL WorkBench
   ii) Create a database schema, setup MySQL connection
   iii) Add dependency of MySQL connector, update application.properties to use MySQL as datasource

10. Convert application.properties to application.yaml file
    i) Learn yaml/yml basic structure

11. Add multiple profiles in .yaml
    i) Switch between different profiles : dev, qa, production
    ii) Set Default profile for working, Run Application on any profile by overriding command

12. Add additional database schema for each profile
    i) Host Application on different databases
    ii) Make changes made in dev, Test in QA, finalize in Prod

13. Actuators
    i) Enable Actuators
    ii) Add Custom Actuator endpoint to track health/status of application entities
