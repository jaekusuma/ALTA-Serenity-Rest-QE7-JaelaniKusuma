package starter.tugas.stepDefinitions;
import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.tugas.reqresAPI;
import starter.tugas.response;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class postRegisterUserdefValid {
    @Steps
    reqresAPI regAPI;

    @Given("Post user register with valid json")
    public void postUserRegister(){
        File json = new File(regAPI.JSON_REQ_BODY+"/registerUserValid.json");
        regAPI.postLoginUser(json);
    }

    @When("Send post register user request")
    public void sendPostRegisterUserRequest() {
        SerenityRest.when().post(regAPI.REGISTER_USER);
    }

    @And("Response body contain id {int} token {string}")
    public void responseBodyContainIdToken(int id, String token) {
        SerenityRest.then()
                .body(response.USER_ID,equalTo(id))
                .body(response.TOKEN,equalTo(token));
    }

    @And("Validate post register user schema")
    public void validatePostRegisterUserSchema() {
        File json = new File(regAPI.JSON_SCHEMA+"/postRegisterUserSchemaValid.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
