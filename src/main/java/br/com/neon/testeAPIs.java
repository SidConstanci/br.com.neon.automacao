package br.com.neon;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class testeAPIs {

    @Test
    public void teste() {
        String uriBase = "https://swapi.co/api/films/";

        given()
                .param("results", "episode_id").param("count",  "episode_id")
                .when()
                .get(uriBase)
                .then()
                .log()
                .all()
                .assertThat().statusCode(200)
                .body("count", is(7));
    }
}
