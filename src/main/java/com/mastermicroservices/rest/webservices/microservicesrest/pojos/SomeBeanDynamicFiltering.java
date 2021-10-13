package com.mastermicroservices.rest.webservices.microservicesrest.pojos;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author Victor Hugo Olvera Cruz
 * POJO SomeBeanDynamicFiltering
 */
@JsonFilter("SomeBeanFilter")
public class SomeBeanDynamicFiltering {

    //Attributes
    private String field1;
    private String field2;
    private String field3;

    //Constructor
    public SomeBeanDynamicFiltering(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    //Getters and Setters
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
