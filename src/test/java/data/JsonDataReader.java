package data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    String firstName, lastName, email, password;

    public void jsonReader() throws IOException, ParseException {
        String filePath = "src\\test\\java\\data\\UserData.json";
        File srcFile = new File(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(srcFile));

        for (Object jsonObject : jsonArray) {
            JSONObject person = (JSONObject) jsonObject;
            password = (String) person.get("password");
            System.out.println("json file reader " + password);
        }
    }
}
