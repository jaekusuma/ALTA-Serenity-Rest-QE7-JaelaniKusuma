package starter.tugas.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.tugas.reqresAPI;
import starter.tugas.response;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class getSingleUsersDef {
    @Given("Get user with parameter {int}")
    public void getUpdateUserWithParameterId(int id) {
        reqresAPI.singleUserGet(id);
    }

    @When("Send get user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when()
                .get(reqresAPI.GET_SINGLE_USER);
    }

    @And("Response body should contain id {int}")
    public void responseBodyShouldContainIdId(int id) {
        SerenityRest.then()
                .body(response.USER_SINGLE_ID,equalTo(id));
    }

    @And("Validate get single user json scheme")
    public void validatePutUpdateJsonScheme() {
        File json = new File(reqresAPI.JSON_SCHEMA+"/getSingleUsersSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
