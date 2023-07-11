package day1;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequestTest {

    @Test
    void getUsers() {
        given()
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test
    void createUser(){
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Alex");
        data.put("job", "trainer");


        given()
                .contentType(ContentType.JSON)
                .body(data)
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .log().all();
    }
}
