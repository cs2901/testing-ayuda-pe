import org.junit.Assert;
import org.junit.Test;

public class TranslatorTest{

    @Test
    public void testear1() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("Hello"), new String("pt"));
        if(!result.equals("Olá") )
        {
            Assert.fail();
        }
    }

    @Test
    public void testear2() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("We want to program a dictionary to translate a English text into a language of our choice, say German."), new String("de"));
        if(!result.equals("Wir möchten ein Wörterbuch programmieren, um einen englischen Text in eine Sprache unserer Wahl zu übersetzen, beispielsweise Deutsch.") )
        {
            Assert.fail();
        }
    }

    @Test
    public void testear3() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("We want to program a dictionary to translate a English text into a language of our choice, say Italian."), new String("it"));
        if(!result.equals("Vogliamo programmare un dizionario per tradurre un testo inglese in una lingua a nostra scelta, per esempio italiana.") )
        {
            Assert.fail();
        }
    }

    @Test
    public void testear4() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("We want to program a dictionary to translate a English text into a language of our choice, say Spanish."), new String("es"));
        if(!result.equals("Queremos programar un diccionario para traducir un texto en inglés a un idioma de nuestra elección, digamos en español.") )
        {
            Assert.fail();
        }
    }

}
