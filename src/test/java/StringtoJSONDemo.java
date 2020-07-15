import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.apache.log.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Given;

public class StringtoJSONDemo {

	/*This is way to capture the request and response in the extent logger which is commented below.
	 * The new filters has been introduced by restassured which can be seen in line 37
	 * This is can be used to implement the same in framework by setting this filter in requestspecification*/
	
	static StringWriter requestWriter;
    static PrintStream requestCapture;
    
    @BeforeMethod()
    public void test1()
    {
    	requestWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter));
    }
    
    @Test
    public void test2()
    {
    	Response response = given().filter(new RequestLoggingFilter(requestCapture)).
    			auth().basic(
                "sk_test_51H3hf8G1vWrroZEBLBS7lK3oVThSnY0hwBpkUvFDAkcBlK7d17p5ac37xjOXHedlRnxmmFrd50x3miFuORGxmkJ100EKkIMm26",
                " ").formParam("description", "My Test").request(Method.POST, "https://api.stripe.com/v1/customers").then()
                .extract().response();
    	
    	requestCapture.flush();
    	System.out.println("Request is "+requestWriter.toString());
    	System.out.println("Response: "+response.asString());
//    	Logger().log(Status.INFO,"Request is "+requestWriter.toString());
//    	Logger().log(Status.INFO,"Respone is "+response.asString())
//    	
    	
    }
    
    
	
	
}
