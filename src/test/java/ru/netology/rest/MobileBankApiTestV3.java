package ru.netology.rest;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestV3 {
    @Test
    void shouldReturnDemoAccounts() {
      given()
          .baseUri("http://localhost:9999/api/v1")

      .when()
          .get("/demo/accounts")

      .then()
          .statusCode(200)
          .contentType(ContentType.JSON)
          .header("Content-Type", "application/json; charset=UTF-8")
          .body("", hasSize(3))
          .body("[0].currency", oneOf("RUB","USD"))
          .body("[1].currency", oneOf("RUB","USD"))
          .body("[2].currency", oneOf("RUB","USD"))

          .body("[0].balance", greaterThanOrEqualTo(0))
      ;
    }


}
