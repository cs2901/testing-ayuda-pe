import org.junit.Assert;
import org.junit.Test;

public class TranslatorTest{

    @Test
    public void testear1() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("Ahora puedes navegar con privacidad. Si otras personas usan este dispositivo, no verán tu actividad. Sin embargo, se guardarán las descargas y los favoritos."),new String("es") ,new String("en"));
        if(!result.equals("Now you can navigate with privacy. If other people use this device, they will not see your activity. However, downloads and favorites will be saved.") )
        {
            Assert.fail();
        }
    }

    @Test
    public void testear2() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("We want to program a dictionary to translate a English text into a language of our choice, say German."),new String("en"), new String("de"));
        if(!result.equals("Wir möchten ein Wörterbuch programmieren, um einen englischen Text in eine Sprache unserer Wahl, beispielsweise Deutsch, zu übersetzen.") )
        {
            Assert.fail();
        }
    }

    @Test
    public void testear3() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("We want to program a dictionary to translate a English text into a language of our choice, say Italian."),new String("en") ,new String("ru"));
        if(!result.equals("Мы хотим запрограммировать словарь для перевода английского текста на язык по нашему выбору, например, немецкий.") )
        {
            Assert.fail();
        }
    }

    @Test
    public void testear4() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("We want to program a dictionary to translate a English text into a language of our choice, say Spanish."),new String("en") ,new String("es"));
        if(!result.equals("Queremos programar un diccionario para traducir un texto en inglés a un idioma de nuestra elección, digamos en español.") )
        {
            Assert.fail();
        }
    }

}
