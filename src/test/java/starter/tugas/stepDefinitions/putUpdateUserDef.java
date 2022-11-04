package starter.tugas.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.tugas.reqresAPI;
import starter.tugas.response;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class putUpdateUserDef {

    @Given("Put update user with valid json with {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(reqresAPI.JSON_REQ_BODY+"/updateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send put update user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when().put(reqresAPI.GET_SINGLE_USER);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(response.NAME,equalTo(name))
                .body(response.JOB,equalTo(job));
    }

    @And("Validate put update json scheme")
    public void validatePutUpdateJsonScheme() {
        File json = new File(reqresAPI.JSON_SCHEMA+"/putUpdateUserSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
