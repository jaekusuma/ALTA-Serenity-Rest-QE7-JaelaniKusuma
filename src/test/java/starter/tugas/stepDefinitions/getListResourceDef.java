package starter.tugas.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.tugas.reqresAPI;

import java.io.File;

public class getListResourceDef {
    @Given("Get list resource with parameter page {int}")
    public void getListResourceWithParameterPage(int page){
        reqresAPI.getListUsers(page);
    }

    @When("Send get list resource request")
    public void sendGetListResourceRequest() {
        SerenityRest.when()
                .get(reqresAPI.GET_LIST_RESOURCE);
    }

    @And("Validate get list resource json scheme")
    public void validateGetListResourceJsonScheme() {
        File json = new File(reqresAPI.JSON_SCHEMA+"/getListResourceSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
