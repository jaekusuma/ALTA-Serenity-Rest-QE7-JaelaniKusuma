package starter.tugas.stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.tugas.reqresAPI;
import starter.tugas.response;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class postLoginUserDefValid {
    @Steps
    reqresAPI regAPI;

    @Given("Post user login with valid json")
    public void postLoginUserWithValidJson(){
        File json = new File(regAPI.JSON_REQ_BODY+"/loginUserValid.json");
        regAPI.postLoginUser(json);
    }

    @When("Send post login user request")
    public void sendPostLoginUserRequest() {
        SerenityRest.when().post(regAPI.LOGIN_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK){
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body contain token {string}")
    public void userGetRequestBodyToken(String token){
        SerenityRest.then()
                .body(response.TOKEN,equalTo(token));
    }

    @And("Validate valid login user schema")
    public void validateValidLoginUserSchema() {
        File json = new File(regAPI.JSON_SCHEMA+"/postLoginuserSchemaValid.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
