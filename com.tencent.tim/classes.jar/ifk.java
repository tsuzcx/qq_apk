import android.content.Context;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class ifk
  extends ifd
{
  private static ifk jdField_a_of_type_Ifk;
  private ifk.a jdField_a_of_type_Ifk$a = new ifk.a(null);
  DocumentBuilder jdField_a_of_type_JavaxXmlParsersDocumentBuilder;
  DocumentBuilderFactory jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
  
  private ifk()
  {
    try
    {
      this.jdField_a_of_type_JavaxXmlParsersDocumentBuilder = this.jdField_a_of_type_JavaxXmlParsersDocumentBuilderFactory.newDocumentBuilder();
      return;
    }
    catch (ParserConfigurationException localParserConfigurationException)
    {
      localParserConfigurationException.printStackTrace();
    }
  }
  
  public static ifk a()
  {
    try
    {
      if (jdField_a_of_type_Ifk == null) {
        jdField_a_of_type_Ifk = new ifk();
      }
      return jdField_a_of_type_Ifk;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Long paramLong, iet paramiet)
  {
    paramLong = new HashMap();
    paramLong.put("client_id", paramString1);
    paramLong.put("client_secret", paramString2);
    paramLong.put("scope", "https://api.microsofttranslator.com");
    paramLong.put("grant_type", "client_credentials");
    try
    {
      ifj.a(paramContext, null, paramLong, new ifn(this, paramiet));
      return;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramiet.c(new TranslateError(paramContext), "UnsupportedEncodingException");
    }
  }
  
  private void b(Context paramContext, List<String> paramList, Language paramLanguage, String paramString, Long paramLong, ifv paramifv)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
    }
    for (;;)
    {
      paramString = new BasicHeader("Authorization", "Bearer " + paramString);
      try
      {
        localObject = new ifm(this, paramList, paramifv, paramLong);
        ifj.a(paramContext, new Header[] { paramString }, paramList, paramLanguage, (ier)localObject);
        return;
      }
      catch (UnsupportedEncodingException paramContext)
      {
        Object localObject;
        paramifv.a(new TranslateError(paramContext), paramLong);
        return;
      }
      catch (Exception paramContext)
      {
        paramifv.a(new TranslateError(paramContext), paramLong);
      }
      localObject = paramLanguage.toString();
      if (localObject != null)
      {
        paramLanguage = (Language)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramLanguage = Language.MS_CHINESE_SIMPLIFIED.toString();
      }
    }
  }
  
  public void a(Context paramContext, List<String> paramList, Language paramLanguage, Long paramLong, String paramString1, String paramString2, ifv paramifv)
  {
    if (System.currentTimeMillis() < this.jdField_a_of_type_Ifk$a.kv)
    {
      b(paramContext, paramList, paramLanguage, this.jdField_a_of_type_Ifk$a.LH, paramLong, paramifv);
      return;
    }
    a(paramContext, paramString1, paramString2, paramLong, new ifl(this, paramLong, paramContext, paramList, paramLanguage, paramifv));
  }
  
  class a
  {
    public String LH;
    public long kv;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifk
 * JD-Core Version:    0.7.0.1
 */