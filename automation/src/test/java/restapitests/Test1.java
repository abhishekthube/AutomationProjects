package restapitests;

import static org.junit.Assert.*;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test1 {

	@Test
	public void checkUserLocation() throws ClientProtocolException, IOException, ParseException
	  {

		//check that user does not exist on github 
			HttpUriRequest request1 = new HttpGet( "https://api.github.com/users/abhishekthube12"  );
			HttpResponse httpResponse1 = HttpClientBuilder.create().build().execute( request1 );
			assertEquals(404, httpResponse1.getStatusLine().getStatusCode());
			System.out.println("abhishekthube12 not found on github, status = " + httpResponse1.getStatusLine().getStatusCode());

		//check that user exists on github
		   HttpUriRequest request = new HttpGet( "https://api.github.com/users/abhishekthube"  );
		   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		   assertEquals(200, httpResponse.getStatusLine().getStatusCode());
		   System.out.println("abhishekthube found on github, status = " + httpResponse.getStatusLine().getStatusCode());
	   
	   //check that the location for the user is 'Parramatta'
		   String jsonResponse = EntityUtils.toString(httpResponse.getEntity());	   
		   JSONParser parser = new JSONParser();
		   JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
		   assertEquals("Parramatta", jsonObject.get("location"));
		   System.out.println("abhishekthube's location on github = " + jsonObject.get("location"));
	   
	  }
	
}


