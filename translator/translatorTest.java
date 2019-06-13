package translator;

import java.io.IOException;

public class translator{
    public static void main(String[] args){
        try{
            System.out.println(GoogleTranslate.translate("es","hello"));

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}