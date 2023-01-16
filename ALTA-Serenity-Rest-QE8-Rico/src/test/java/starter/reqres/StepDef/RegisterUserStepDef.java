package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/Register.json");
        reqresAPI.postRegisterSuccessful(json);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESSFUL);
    }

    @And("Response body name should be id {int} and token {string}")
    public void responsBodyNameShouldBeIdAndToken(int id, String token) {
        SerenityRest.then()
                .body("id", equalTo(id))
                .body("token", equalTo(token));
    }

    @And("Validate json schema register user")
    public void validateJsonSchemaRegisterUser() {
        File JsonSchema = new File(Constant.JSON_REQUEST+"RegisterUserSuccessfulSchema.json");
    }

    @Given("Post user register user with blank password with valid json")
    public void postRegisterUserBlankPasswordWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/RegisterBlankPassword.json");
        reqresAPI.postRegisterUnsuccessful(json);
    }

    @When("Send post register request is unsuccessful")
    public void sendRequestPostBlankPasswordRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_UNSUCCESSFUL);
    }

    @And("Validate json schema register unsuccessful")
    public void validateJsonSchemaRegisterUnsuccessful() {
        File JasonSchema = new File(Constant.JSON_SCHEMA+"/RegisterUserUnsuccessful.json");
    }
}
