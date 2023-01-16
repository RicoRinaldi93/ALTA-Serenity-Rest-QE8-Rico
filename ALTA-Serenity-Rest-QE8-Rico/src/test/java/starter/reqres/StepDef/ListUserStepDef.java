package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;



public class ListUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body("page",equalTo(page));
    }

    @Given("Get list user with page {string}")
    public void getListUserWithPage(String page) {
        reqresAPI.getListUsersInvalid(page);
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser() {
        File JsonSchema = new File (Constant.JSON_SCHEMA+"ListUserSchema.json");
    }
}
