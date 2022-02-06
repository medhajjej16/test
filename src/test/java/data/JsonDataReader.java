package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


	public class JsonDataReader 
	{
		public String firstname, lastename , email , password  ; 

		public void JsonReader() throws FileNotFoundException, IOException, ParseException 
		{
			String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";

			File srcFile = new File(filePath); 
			JSONParser parser=new JSONParser();
			JSONArray jarray= (JSONArray)parser.parse(new FileReader(srcFile));
			for(Object jsobject:jarray) {
				JSONObject person= (JSONObject) jsobject;
				firstname= (String) person.get("firstname");
				System.out.println(firstname);

				lastename = (String) person.get("lastename"); 
				System.out.println(lastename);

				email = (String) person.get("email"); 
				System.out.println(email);

				password = (String) person.get("password"); 
				System.out.println(password);
			}

}
}