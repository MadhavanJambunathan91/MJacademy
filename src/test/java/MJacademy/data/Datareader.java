package MJacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
 
import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {
	
	public List<HashMap<String, String>> getjsondatatomap() throws IOException {
		
		//Reading data from json as String
	
		String json =	FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "\\src\\test\\java\\MJacademy\\data\\Purchaseorder.json\r\n"),StandardCharsets.UTF_8 );
		
		//Convert the sting to hash by using external dependency called "Jackson-databind'
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>(){
			
		}); 
		
		return data;
  
	}

}
