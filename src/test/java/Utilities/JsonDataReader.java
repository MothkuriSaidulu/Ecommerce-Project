package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {

	
	
	public List<HashMap<String, String>> readJsonData(String JsoniFilePath) throws IOException 
	{
		// Read json data into string
//		String jsonStringData = FileUtils.readFileToString(new File(".\\Utilities\\DataFile.json"), StandardCharsets.UTF_8);
		
		String jsonStringData = FileUtils.readFileToString(new File(JsoniFilePath), StandardCharsets.UTF_8);

		
		// convert string data to hash map data
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> jsonHashMapData = mapper.readValue(jsonStringData, new TypeReference<List<HashMap<String, String>>>(){});
		return jsonHashMapData;
	}

}
