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

public class CreateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body("name",equalTo(name))
                .body("job",equalTo(job));
    }

    @And("Validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File JsonSchema = new File(Constant.JSON_SCHEMA +"CreateUserSchema.json");
    }

}
