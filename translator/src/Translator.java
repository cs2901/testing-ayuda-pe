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
            Arrays.asList("de","ar","zh-CN","ko","es","fr","el","iw","hi","en","it","ja","la","no","pl","pt","ru","sv","th","tr"));
    private static ArrayList<String> languagesName = new ArrayList<String>(
            Arrays.asList("German","Arabic","Chinese","Korean","Spanish","French","Greek","Hebrew","Hindi","English","Italian","Japanese","Latin","Norwegian","Polish","Portuguese","Russian","Swedish","Thai","Turkish"));

    public static void main(String[] args) throws IOException {
            System.out.println("Choose input language (type language number):");
            for (int i = 0; i < languages.size(); i++) {
                String text = (i + 1) + " " + languages.get(i) + " " + languagesName.get(i);
                System.out.println(text);
            }
            int inputLanguage;
            String input;
            Scanner scanLang = new Scanner(System.in);
            input = scanLang.nextLine();
            inputLanguage = Integer.parseInt(input) - 1;
            if (inputLanguage >= languages.size()) {
                System.out.println("Error: no language for inserted number");
                return;
            }
            else {
                System.out.println("You chose: " + languagesName.get(inputLanguage)+"\n");
            }

            System.out.println("Choose language to translate to(type language number):");
            for (int i = 0; i < languages.size(); i++) {
                String text = (i + 1) + " " + languages.get(i) + " " + languagesName.get(i);
                System.out.println(text);
            }
            int languageSelected;
            input = scanLang.nextLine();

            languageSelected = Integer.parseInt(input) - 1;
            if (languageSelected >= languages.size()) {
                System.out.println("Error: no language for inserted number");
            }
            else
            {
                System.out.println("You chose: "+ languagesName.get(languageSelected)+"\n");
                Scanner scan = new Scanner(System.in);
                System.out.println("Insert text in "+ languagesName.get(inputLanguage) + ": ");
                input = scan.nextLine();
                System.out.println(languagesName.get(languageSelected) + " translation:\n" + translate(input, languages.get(inputLanguage),languages.get(languageSelected)));
            }
    }

    public static String translate(String text, String langFrom, String langTo) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbwoewR66GN4nBRmwKUzAz7dlyOZ2MIN9T5pAsUk56puPV7P0xJa/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
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
