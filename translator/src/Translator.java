import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;



public class Translator {
    private static ArrayList<String> languages = new ArrayList<String>(
            Arrays.asList("es", "de", "it", "ru", "pt"));
    private static ArrayList<String> languagesName = new ArrayList<String>(
            Arrays.asList("Spanish", "German", "Italian", "Russian", "Portuguese"));


    public static void main(String[] args) throws IOException {
            System.out.println("Choose language (type language number):");
            for (int i = 0; i < languages.size(); i++) {
                String text = (i + 1) + " " + languages.get(i) + " " + languagesName.get(i);
                System.out.println(text);
            }
            int languageSelected;
            String input;
            Scanner scanLang = new Scanner(System.in);
            input = scanLang.nextLine();

            languageSelected = Integer.parseInt(input) - 1;
            if (languageSelected >= languages.size()) {
                System.out.println("Error: no language for inserted number");
            }
            else
            {
                System.out.println("You chose: "+ languagesName.get(languageSelected));
                Scanner scan = new Scanner(System.in);
                System.out.println("Insert text in english:");
                input = scan.nextLine();
                System.out.println(languagesName.get(languageSelected) + " translation:\n" + translate(input, languages.get(languageSelected)));
            }
    }

    public static String translate(String text, String lang) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbwoewR66GN4nBRmwKUzAz7dlyOZ2MIN9T5pAsUk56puPV7P0xJa/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + lang +
                "&source=" + "en";
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }


}
