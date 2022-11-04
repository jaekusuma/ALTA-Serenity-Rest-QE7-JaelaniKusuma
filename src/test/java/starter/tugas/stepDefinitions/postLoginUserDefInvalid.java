package starter.tugas.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.tugas.reqresAPI;
import starter.tugas.response;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class postLoginUserDefInvalid {
    @Steps
    reqresAPI regAPI;

    @Given("Post user login with invalid json")
    public void postUserLoginWithInvalidJson() {
        File json = new File(regAPI.JSON_REQ_BODY+"/loginUserInvalid.json");
        regAPI.postLoginUser(json);
    }

    @When("Send post invalid login user request")
    public void sendPostInvalidLoginUserRequest() {
        SerenityRest.when().post(regAPI.LOGIN_USER);
    }

    @And("Response body contain error {string}")
    public void responseBodyContainError(String error) {
        SerenityRest.then()
                .body(response.ERROR,equalTo(error));
    }

    @And("Validate invalid login user schema")
    public void validateInvalidLoginUserSchema() {
        File json = new File(regAPI.JSON_SCHEMA+"/postLloginUserSchemaInvalid.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
