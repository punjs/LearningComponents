import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateJiraCookieAuth
{
    /*
     * This is a demonstration of Cookie based Authentication for Jira Tools Jira is installed locally on my machine
     * with port 8070 http://localhost:8070/ The example uses Jsession Cokiee and is recieved in response of Username
     * and Password It also shows chaining concept for maintaining the session(Output of one api as input of another
     * api) Few other basics learned. code Beautify to convert Json payload to JsonString Payload Eclipse sometime
     * handles Json into string by itself by just copying it Json object as a Map using dependency
     * com.googlecode.json-simple For API reference
     * https://developer.atlassian.com/server/jira/platform/cookie-based-authentication/
     * https://developer.atlassian.com/server/jira/platform/jira-rest-api-examples/
     */

    static String getCookie;

    @Test(priority = 1)
    public static void generateCookie()
    {
        JSONObject json = new JSONObject();
        json.put("username", "spunjggn");
        json.put("password", "Iaminggn122004");

        Response response = RestAssured.given().header("Content-Type", "application/json").body(json)
            .post("http://localhost:8070/rest/auth/1/session").then().extract().response();
        System.out.println(response.getStatusCode());
        System.out.println(response.body().jsonPath().prettify());
        getCookie = response.getCookies().get("JSESSIONID");
        System.out.println("The cookie we got from Server is " + getCookie);

    }

    @Test(priority = 2, dependsOnMethods = "generateCookie")

    public static void createtask()
    {
        String bdy =
            "{ \"fields\": {       \"project\":       {          \"key\": \"SPA\"       },       \"summary\": \"My first task via APi.\",       \"description\": \"First API call using post method using cookies for authentication\",       \"issuetype\": {          \"name\": \"Task\"       }   }}";
        Response response = RestAssured.given().header("Content-Type", "application/json")
            .cookie("JSESSIONID", getCookie).body(bdy).post("http://localhost:8070/rest/api/2/issue").andReturn();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

    }

}
