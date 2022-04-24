package org.example;

import io.restassured.RestAssured;
import org.junit.Test;

public class Apptest {
    @Test
    public void hello_world_test(){
        //System.out.println("hello_world_test");

        RestAssured
                .given().baseUri("http://numbersapi.com")
                .log().all()
                .when()
                .get("/940/year")
                .then()
                .log().all();

    }
}
