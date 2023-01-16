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

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/LoginSuccessful.json");
        reqresAPI.postLoginSuccessful(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Response body name should be token {string}")
    public void responseBodyNameShouldBeToken(String token) {
        SerenityRest.then()
                .body("token", equalTo(token));
    }

    @Given("Post user login with blank password with valid json")
    public void postLoginUserBlankPasswordWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUnsuccessful.json");
        reqresAPI.postRegisterUnsuccessful(json);
    }

    @When("Send post login request is unsuccessful")
    public void sendRequestPostLoginUnsuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_UNSUCCESSFULL);
    }

    @And("Validate json schema post login")
    public void validateJsonSchemaPostLogin() {
        File JsonSchema = new File(Constant.JSON_SCHEMA+"LoginUnsuccessful.json");
    }
}