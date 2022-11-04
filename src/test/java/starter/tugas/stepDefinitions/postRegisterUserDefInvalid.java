package starter.tugas.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.tugas.reqresAPI;

import java.io.File;

public class postRegisterUserDefInvalid {
    @Steps
    reqresAPI regAPI;

    @Given("Post user register with invalid json")
    public void postUserRegisterWithInvalidJson() {
        File json = new File(regAPI.JSON_REQ_BODY+"/registerUserInvalid.json");
        regAPI.postLoginUser(json);
    }

    @When("Send post invalid register user request")
    public void sendPostInvalidRegisterUserRequest() {
        SerenityRest.when().post(regAPI.LOGIN_USER);
    }

    @And("Validate post invalid register user schema")
    public void validatePostInvalidRegisterUserSchema() {
        File json = new File(regAPI.JSON_SCHEMA+"/postRegisterUserSchemaInvalid.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post user register with null json")
    public void postUserRegisterWithNullJson() {
        File json = new File(regAPI.JSON_REQ_BODY+"/blankBodyReq.json");
        regAPI.postLoginUser(json);
    }

    @When("Send post invalid user register request")
    public void sendPostInvalidUserRegisterRequest() {
        SerenityRest.when().post(regAPI.LOGIN_USER);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int bad) {
        SerenityRest.then().statusCode(bad);
    }
    @And("Validate post invalid user register schema")
    public void validatePostInvalidUserRegisterSchema() {
        File json = new File(regAPI.JSON_REQ_BODY+"/blankBodyReq.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
