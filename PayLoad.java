
public class PayLoad {
	static String  name;
	public static String users()
	
	{
		
		String gender = "male";
		
		
		if(gender == "male")
		{
			name = "ram";
		return "{\r\n" + 
				"    \"name\": \""+name+"\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";
		
		}
		else
		{
			name = "Shyamala";  
			return "{\r\n" + 
					"    \"name\": \"\""+name+"\"\",\r\n" + 
					"    \"job\": \"leader\"\r\n" + 
					"}";
		}
	}
	

}
