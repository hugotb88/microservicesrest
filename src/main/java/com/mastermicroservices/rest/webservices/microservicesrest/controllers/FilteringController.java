package com.mastermicroservices.rest.webservices.microservicesrest.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mastermicroservices.rest.webservices.microservicesrest.pojos.SomeBean;
import com.mastermicroservices.rest.webservices.microservicesrest.pojos.SomeBeanDynamicFiltering;
import com.mastermicroservices.rest.webservices.microservicesrest.pojos.SomeBeanTwo;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveSomeBeanList(){
        return Arrays.asList(
                new SomeBean("value1","value2","value3"),
                new SomeBean("value21","value22","value23"));
    }

    @GetMapping("/filtering-list-example-two")
    public List<SomeBeanTwo> retrieveSomeBeanTwoList(){
        return Arrays.asList(
                new SomeBeanTwo("value1","value2","value3"),
                new SomeBeanTwo("value21","value22","value23"));
    }


    //Dynamic Filtering
    //field1, field2
    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue retrieveSomeBeanFiltering(){
        SomeBeanDynamicFiltering someBeanDynamic = new SomeBeanDynamicFiltering("value1","value2","value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
                filterOutAllExcept("field1","field2");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBeanDynamic);
        mapping.setFilters(filters);

        return mapping;
    }

    //field2, field3
    @GetMapping("/filtering-list-dynamic")
    public MappingJacksonValue retrieveSomeBeanFilteringList(){
        List<SomeBeanDynamicFiltering> list = Arrays.asList(
                new SomeBeanDynamicFiltering("value1","value2","value3"),
                new SomeBeanDynamicFiltering("value21","value22","value23"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
                filterOutAllExcept("field1","field2");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;

    }
}
