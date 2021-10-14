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