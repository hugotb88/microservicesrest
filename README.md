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