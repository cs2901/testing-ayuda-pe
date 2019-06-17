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
        String result = mytranslator.translate(new String("hello"),new String("en") ,new String("zh-CN"));
        if(!result.equals("你好") )
        {
            Assert.fail();
        }
    }

    @Test
    public void testear4() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("แบทแมนเป็นคนไร้เดียงสาและขาดความบริสุทธิ์ คุณจะดึงวิศวกรรมซอฟต์แวร์สำหรับการขาดเรียนทั้งหมดและไม่ทำอะไรเลย"),new String("th") ,new String("ja"));
        if(!result.equals("バットマンは無実で無実を欠いています。あなたはすべてのクラスの欠如のためにソフトウェア工学を引っ張り、何もしないでしょう。") )
        {
            Assert.fail();
        }
    }

    @Test
    public void testear5() throws Exception {
        Translator mytranslator = new Translator();
        String result = mytranslator.translate(new String("Ce dictionnaire, sous la forme d'une classe, Dictionnaire, est initialisé avec un fichier mot et nous permet d'interroger la traduction d'un mot anglais."),new String("fr") ,new String("en"));
        if(!result.equals("This dictionary, in the form of a class, Dictionary, is initialized with a word file and allows us to query the translation of an English word.") )
        {
            Assert.fail();
        }
    }

}
