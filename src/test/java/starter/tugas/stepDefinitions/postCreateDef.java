package starter.tugas.stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.tugas.reqresAPI;
import starter.tugas.response;

import java.io.File;

public class postCreateDef {
    @Steps
    reqresAPI regAPI;

    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(regAPI.JSON_REQ_BODY+"/createUser.json");
        regAPI.postCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when().post(reqresAPI.CREATE_USER);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body contain name {string} job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(response.NAME, Matchers.equalTo(name))
                .body(response.JOB, Matchers.equalTo(job));
    }

    @And("Validate create user json schema")
    public void validateCreateUserJsonSchema() {
        File json = new File(reqresAPI.JSON_SCHEMA+"/postCreateUserSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
