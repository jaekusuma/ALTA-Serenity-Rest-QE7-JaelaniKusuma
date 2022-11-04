package starter.tugas.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.tugas.reqresAPI;

import java.io.File;

public class patchUpdateUserDef {
    @Given("Patch update user with valid json with {int}")
    public void patchUpdateUserWithValidJsonWithId(int id){
        File json = new File(reqresAPI.JSON_REQ_BODY+"/updateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send patch update user request")
    public void sendPatchUpdateUserRequest() {
        SerenityRest.when().put(reqresAPI.GET_SINGLE_USER);
    }

    @And("Validate patch update json scheme")
    public void validatePatchUpdateJsonScheme() {
        File json = new File(reqresAPI.JSON_SCHEMA+"/patchUpdateSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
