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

public class getListUsersDef {
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPagePage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when()
                .get(reqresAPI.LIST_USER);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then()
                .body(response.PAGE,equalTo(page));
    }

    @And("Validate get list user json scheme")
    public void validateGetListUserJsonScheme() {
        File json = new File(reqresAPI.JSON_SCHEMA+"/getListUserSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
