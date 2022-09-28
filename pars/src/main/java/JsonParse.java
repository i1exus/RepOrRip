import java.io.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParse {

    private static final String filePath = "/Users/ilexus/IdeaProjects/pars/src/main/java/package.json";

    public static void main(String[] args) {
        FileWriter Запись_в_файл = null;
        try {
            Запись_в_файл = new FileWriter("ParsingCoinMarketCap.txt", false);
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray lang= (JSONArray) jsonObject.get("info");

            Iterator i = lang.iterator();
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("Вид токена: "+ innerObj.get("name") +
                        "\nСписок токенов по ссылке: https://coinmarketcap.com/view/" + innerObj.get("slug")+"/\n\n");

                    Запись_в_файл.write("Вид токена: "+ innerObj.get("name") +
                            "\nСписок токенов по ссылке: https://coinmarketcap.com/view/" + innerObj.get("slug")+"/\n\n");
                    Запись_в_файл.append('\n');
                    Запись_в_файл.flush();
                    
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

}