package br.com.neon.apis;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;

public class testeAPIs {

    @Test
    public void teste() {
        String uriBase = "https://swapi.co/api/films/";

        given()
                .param("results", "title").param("count", "episode_id")
                .when()
                .get(uriBase)
                .then()
                .log()
                .all()
                .assertThat().statusCode(200)
                .body("count", is(7))
                .body("title", equalTo("A New Hope"));
    }
}
