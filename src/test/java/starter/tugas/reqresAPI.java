package starter.tugas;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class reqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String JSON_REQ_BODY = "src/test/resources/features/JSON/requestBody";
    public static final String JSON_SCHEMA = "src/test/resources/features/JSON/jsonSchema";


    public static String LIST_USER = URL + "/api/users?page={page}";
    public static String GET_SINGLE_USER = URL + "/api/users/{id}";
    public static String GET_LIST_RESOURCE = URL + "/api/unknown?page={page}";
    public static String LOGIN_USER = URL + "/api/login";
    public static String REGISTER_USER = URL + "/api/register";
    public static String CREATE_USER = URL + "/api/users";


    @Step("Get list users")
    public static void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Get single users")
    public static void singleUserGet(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Post Login user")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create user")
    public static void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public static void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public static void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}
