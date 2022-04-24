package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ToDoTest {

    @Before
    public void setup() {
        RestAssured.baseURI="https://api.todoist.com";
        RestAssured.basePath="/rest/v1/";
        RestAssured.requestSpecification=RestAssured
                        .given()
                        .header("Authorization", "Bearer bfdf616134cf16503026f6432c47eabc8c7d2139")
                        .contentType(ContentType.JSON);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
            }

            @Test
        public void createNewProject(){
        String projectName = "projekt Enid";
        ValidatableResponse newProject = SerenityRest
                .given()
                .body("{\"name\": \"" + projectName + "\"}")
                .when()
                .post("/projects")
                .then()
                .assertThat()
                .statusCode(200);

            }
}
