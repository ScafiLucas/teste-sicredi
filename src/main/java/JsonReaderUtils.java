import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReaderUtils {


    /**
     * Reads a file containing a Json and return it as a JSON Object
     * @param fileName
     * @return
     */
    public static JSONObject readJsonFile(String fileName){

        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();

        try{

            return jsonObject = (JSONObject) parser.parse(new FileReader(fileName));

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONObject getRequestBody(String fileName){
        JSONObject jsonObject = readJsonFile(fileName);
        return (JSONObject) jsonObject.get("body");
    }

    public static JSONObject getResponseBody(String fileName){
        JSONObject jsonObject =  readJsonFile(fileName);
        return (JSONObject) jsonObject.get("response");
    }

    public static String getRequestURI(String fileName){
        JSONObject jsonObject = readJsonFile(fileName);
        return (String) jsonObject.get("uri");
    }

    public static Long getResponseStatusCode(String fileName){
        JSONObject jsonObject = readJsonFile(fileName);
        return (Long) jsonObject.get("statusCode");
    }
}
