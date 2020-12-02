import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.Scanner;

import static io.restassured.RestAssured.*;

public class learn200 {
static String[] pages = new String[8];
static int[] n = new int[8];
	public static void listUsers() {
		
		int[] arr = {7, 8, 9, 10, 11, 12};
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in";
		String res = given().log().all().queryParam("page", "2")
		.when().get("api/users")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(res);
		
		for(int i=0;i<6;i++)
		{
		
	pages[i]=  js.getString("data.id["+i+"]");
	System.out.println(pages[i]);
		}
		
		
	

for(int j=0;j<6;j++)
{
	n[j] =  Integer.parseInt(pages[j]);

}	

for(int x=0;x<6;x++)
{
if(n[x]==arr[x])
{
	System.out.println("TCA pass");
}
else
{
	System.out.println("TCA fail");
}

}//for loop



	}
	
	
	public static void main(String args[])
	{
		learn200 l = new learn200();
		//l.listUsers();
		l.createUsers();
	}
	//https://reqres.in/api/users
	public void createUsers()
	{
		//Scanner s = new Scanner(System.in);
		//System.out.println("Enter name");
	//String name = s.nextLine();
		//String name="Rajesh";
		RestAssured.baseURI="https://reqres.in";
	String createuser =	given().log().all().header("content-type","application/json; charset=utf-8").body(PayLoad.users())
		.when().post("api/users")
		.then().log().all().assertThat().statusCode(201).body("name",equalTo(PayLoad.name)).extract().response().asString();
	
	
	System.out.println(createuser);
	
	JsonPath p = new JsonPath(createuser);
	
	System.out.println(p.getString("job"));
	
	}	
}