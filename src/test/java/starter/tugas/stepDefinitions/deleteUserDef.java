package starter.tugas.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.tugas.reqresAPI;

public class deleteUserDef {
    @Given("Delete user with {int}")
    public void deleteUserWithId(int id){
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when()
                .delete(reqresAPI.GET_SINGLE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int nothing) {
        SerenityRest.then()
                .statusCode(nothing);
    }
}
