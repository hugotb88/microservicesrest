# microservicesrest
Repo for "Master Microservices with Spring Boot and Spring Cloud" from Udemy
Udemy Course "Master Microservices with Spring Boot and Spring Cloud"

RESTful Web Services Concepts
SOAP Web Services Concepts
Differences

- RESTful with  Spring Boot
- Spring Boot Auto Configuration and DispatcherServlet
- Bean Creation
- Service Creation
- GET,POST,PUT,DELETE,OPTIONAL
- Handle HTTP 4xx responses
- Handle Generic Exceptions
- Handle Resources
- HATEOAS (Hypermedia as the Engine of Application State)
- Internationalization i18n


HATEOAS
- Adding links to the response of a service to let the user which other action he can perform
  {
      "id": 1,
      "name": "Batman",
      "birthDate": "2021-10-11",
      "_links": {
      "all-users": {
        "href": "http://localhost:8080/users"
        }
      }
  }
  
Swagger using Springdoc OpenAPI 1.5.9
- OpenAPI = Specification
- Swagger = Tools for implementing the specification
- localhost:8080/swagger-ui.html


Spring Boot Actuator
- Monitoring the Application
- Health of the application
  localhost:8080/actuator

**JSON formatter extension in Chrome can help to read better the information of the Actuator 

HAL Explorer (JSON Hypertext Application Language)
- An easy way to hyperlink between resources in our API
- Provides an in-browser GUI to traverse the REST API
- localhost:8080

REST API Filtering
- A way to filter the data that you sent in the response without modifying the Bean, only filtering the Response
- @JsonIgnore
- @JsonIgnoreProperties --> Static Filtering

Dynamic Filtering
- @JsonFilter(<nameOfTheFilter>)

Versioning
- PersonV1
- PersonV2
- Name

Versioning (Header and Content Negotiation Approach)
- params
- headers (Headers in request)
- produces (Accept in headers)

** Depends of the type of versioning if can be executed in Browser, or generate Documentation, do a research considering the following factors

Factors to choose Versioning
- URI pollution
- Missuse of HTTP Headers
- Caching
- Can we Execute the request in the browser?
- API Documentation


Security with Spring Security (Basic Authentication, no OAuth or OAuth2)
- Once the dependency is added and the app started, search in the Console the following "Using generated security password: <xxxx...>"
- You will need the value in Postman to perform a Request, if you don't use it you will receive a HTTP 401 error
- Basic Auth
    - Username: user
    - Password: <xxx...>
- You can configure user and password in the .properties file
    - spring.security.user.name = username
    - spring.security.user.password = password
    
JPA
1) H2 database name is randomly generated each time you restart the server. You can find the database name and URL from the console log.

2) To use data.sql, you need to add this to application.properties -  spring.jpa.defer-datasource-initialization=true

e.g
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.defer-datasource-initialization=true


To enable h2 console and perform queries on it.
spring.jpa.show-sql = true
spring.h2.console.enabled = true

localhost:8080/h2-console
jdbc:h2:mem:testdb


Tips for JPA Code
- When you create a relationship (@OneToMany,@OneToOne...) 
    - Example: "One User can have multiple Posts, but a Post is only from one User"
    - That Means @ManyToOne in Post class and @OneToMany in User class, but the owner of the relationship is Post
    - Then in User, you need to specify who is the Owner to not create the Relationship twice
    - You can do that in User using the keyword @OneToMany(mappedBy = "user") --> user is the name of the field in Post class that owns the relationship.


From IntelliJ console:
Hibernate: create table post (id integer not null, description varchar(255), user_id integer, primary key (id))
Hibernate: create table user (id integer not null, birth_date date, name varchar(255), primary key (id))

Post Table have a reference to User table with the id, but User table doesn't have a reference to Post Table, that's ok

- In Post Class added @JsonIgnore to user object
  - Because i don't want the details of the user when i get a specific post, not adding this could generate an infinite loop
    

Richardson Maturity Model (RMM)
- To evaluate/grade your RESTful API
- 4 stages, 3 Different Levels of Maturity (Level 0, Level 1, Level 2, Level 3)
    - Level 0: "Expose SOAP WEB Services in REST Style" --> Expose the URLs (e.g. http://server/getPosts,http://server/deletePosts...)
    - Level 1: "Expose Resources with proper URI" --> Group endpoints in resources (Users (/users), Posts (/posts)...)
    - Level 2: Level 1 + "Http Methods " --> Use proper HTTP method in a group of resources (GET, POST, PUT, DELETE, OPTIONAL)
    - Level 3: Level 2 + HATEOAS DATA + Next Possible Actions --> With HATEOAS we return what are the next possible actions after perform an action.