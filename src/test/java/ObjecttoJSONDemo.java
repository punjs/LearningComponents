import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class ObjecttoJSONDemo {
	
	/*This method is used to capture request and response in the restassured and got them print in Extent report
	 * 
	 */

	   @Test
	    public void test2()
	    {
	    	Response response = given().
	    			auth().basic(
	                "sk_test_51H3hf8G1vWrroZEBLBS7lK3oVThSnY0hwBpkUvFDAkcBlK7d17p5ac37xjOXHedlRnxmmFrd50x3miFuORGxmkJ100EKkIMm26",
	                " ").formParam("description", "My Test").request(Method.POST, "https://api.stripe.com/v1/customers").then()
	                .extract().response();
	    	
	    	Converter conv = new Converter();
	    	//System.out.println(conv.getresponse(response));
	    	
	    	
	    }
	   
	   
	   class Converter{
		   
		   Converter()
		   {
			   
		   }

		   ObjectMapper objmapper = new ObjectMapper();
		   public String getresponse(Object o)
		   {
			  
			   try
			   {
			   return objmapper.writeValueAsString(o);
		       }catch(JsonProcessingException e)
			   {
		    	   e.printStackTrace();
			   }
			   return null;
		   }
		   
		   
		   public <T> T softConvertValue(Object fromValue, Class<T> toValueType) 
		   {
		       ObjectMapper objMapper = new ObjectMapper();
		       return objMapper
		           .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		           .convertValue(fromValue, toValueType);
		   }
		   
		   
		   /*The easiest way is that you can use this softconvertvalue method which is a custom method in which you can convert jsonData into your specific Dto class.

		   Dto response = softConvertValue(jsonData, Dto.class);


		   public static <T> T softConvertValue(Object fromValue, Class<T> toValueType) 
		   {
		       ObjectMapper objMapper = new ObjectMapper();
		       return objMapper
		           .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		           .convertValue(fromValue, toValueType);
		   }*/
		   
		   
//		   public static <T> void logDetails(final T response,String logtype)
//		   {
////		   	String res = JSONUtils.toJSON(response);
////		   	Logger().log(Status.INFO,
////		   	("<details>" + "<summary>" + "<b>" + "<font color=" + "blue>" + logtype
////		   	+ "</font>" + "</b >" + "</summary>" + res.replaceAll(",", "<br>") + "</details>"
////		   	+ " \n"));
//		   }
		   
	   }
	
}


class JSONUtils {
	
	
	
	private static ObjectMapper objectmapper = new ObjectMapper();

	private JSONUtils()
	{
		
	}
	
	/* Convert an object to its JSON representation.
	 * 
	 * @param o The object to convert.
	 * 
	 * @return The JSON string representation of specified objects.
	 * 
	 * @throws Json ProcessingException
	 * */
	
	
	public static String toJSON(final Object o)
	{
		try
		{
			return objectmapper.writeValueAsString(o);
		}catch(JsonProcessingException e )
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}