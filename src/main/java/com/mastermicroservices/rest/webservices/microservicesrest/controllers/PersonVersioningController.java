package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.mastermicroservices.rest.webservices.microservicesrest.versioning.Name;
import com.mastermicroservices.rest.webservices.microservicesrest.versioning.PersonV1;
import com.mastermicroservices.rest.webservices.microservicesrest.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //Params Versioning
    @GetMapping(value="/person/param", params = "version=1")
    public PersonV1 personParamV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/param", params = "version=2")
    public PersonV2 personParamV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //Headers Versioning
    @GetMapping(value="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 personParamHeaderV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 personParamHeaderV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //Produces Versioning
    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 personParamProducesV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 personParamProducesV2(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

}
