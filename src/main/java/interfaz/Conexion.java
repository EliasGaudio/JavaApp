package interfaz;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;

public class Conexion {

	public static void main(String[] args) throws MalformedURLException, IOException, UnirestException {
		
		
		URLConnection connection = new URL("http://127.0.0.1:4567").openConnection();
		connection.setRequestProperty("Content-type", "application/json");
		System.out.println(connection.getContentType());
			
		String query = String.format("s=%s", URLEncoder.encode("elpepe", "UTF-8"));
			
		String host = "http://127.0.0.1:4567";
		HttpResponse<JsonNode> httpResponse = Unirest.get("http://127.0.0.1:4567/elpepe")
	      .header("Content-type", "application/json")
	      .asJson();
		System.out.println(httpResponse.getStatus());
		System.out.println( httpResponse.getHeaders().get("Content-Type"));


		
			
		
		
		

	}

}
