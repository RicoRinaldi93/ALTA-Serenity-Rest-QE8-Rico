package starter.reqres;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;

import static starter.reqres.Utils.Constant.DIR;


public class ReqresAPI {
 //   public static String BASE_URL = "https://reqres.in"; //ini base URL
 //   public static final String DIR = System.getProperty("user.dir"); //ini untuk dapatkan location project
 //   public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request"; //untuk path JSON Request
 //   public static String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}"; //untuk URL get list users
    public static String POST_CREATE_USER =Constant.BASE_URL+"/api/users"; //untuk URL create user
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}"; //untuk URL update user
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}"; //untuk URL delete user

    public static String POST_REGISTER_SUCCESSFUL = Constant.BASE_URL+"/api/register";

    public static String POST_REGISTER_UNSUCCESSFUL = Constant.BASE_URL+"/api/register";

    public static  String POST_LOGIN_USER = Constant.BASE_URL+"/api/login";

    public static String POST_LOGIN_UNSUCCESSFULL = Constant.BASE_URL+"/api/login";


    //METHOD
    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Get list users invalid")
    public void getListUsersInvalid(String page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Register Successful")
    public void postRegisterSuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Register Unsuccessful")
    public void postRegisterUnsuccessful (File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Login Successful")
    public void postLoginSuccessful(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step ("Login Unsuccessful")
    public void LoginUnsuccessful (File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


}