import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {
    public static void main(String[] args) throws IOException {
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string");
        input = scan.nextLine();
        System.out.println("Traducción:\n" + translate(input));
    }

    private static String translate(String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbwoewR66GN4nBRmwKUzAz7dlyOZ2MIN9T5pAsUk56puPV7P0xJa/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + "es" +
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
