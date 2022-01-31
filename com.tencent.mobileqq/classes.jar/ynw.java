import android.text.TextUtils;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ynw
{
  public static JSONObject a(String paramString)
  {
    try
    {
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), null);
      paramString = a(localXmlPullParser);
      if (paramString == null) {}
      do
      {
        yny.d("GdtJsonXmlUtil", "toJSONObject error");
        return null;
        paramString = paramString.a();
      } while ((paramString == null) || (paramString == JSONObject.NULL) || (!(paramString instanceof JSONObject)));
      paramString = (JSONObject)JSONObject.class.cast(paramString);
      return paramString;
    }
    catch (XmlPullParserException paramString)
    {
      yny.d("GdtJsonXmlUtil", "toJSONObject", paramString);
    }
    return null;
  }
  
  private static ynx a(XmlPullParser paramXmlPullParser)
  {
    try
    {
      if (paramXmlPullParser.getEventType() != 0)
      {
        yny.d("GdtJsonXmlUtil", "parserDocument error");
        return null;
      }
      a(paramXmlPullParser);
      if (paramXmlPullParser.getEventType() == 1) {
        break label86;
      }
      if (paramXmlPullParser.getEventType() == 2)
      {
        ynx localynx = b(paramXmlPullParser);
        if (paramXmlPullParser.getEventType() == 1) {
          return localynx;
        }
        yny.d("GdtJsonXmlUtil", "parserDocument error");
        return null;
      }
    }
    catch (XmlPullParserException paramXmlPullParser)
    {
      yny.d("GdtJsonXmlUtil", "parserDocument", paramXmlPullParser);
      return null;
    }
    yny.d("GdtJsonXmlUtil", "parserDocument error");
    label86:
    return null;
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    try
    {
      boolean bool;
      do
      {
        if (paramXmlPullParser.next() != 4) {
          break;
        }
        String str = paramXmlPullParser.getText();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        bool = str.matches("\\s+");
      } while (bool);
      return;
    }
    catch (XmlPullParserException paramXmlPullParser)
    {
      yny.d("GdtJsonXmlUtil", "skip", paramXmlPullParser);
      return;
    }
    catch (IOException paramXmlPullParser)
    {
      yny.d("GdtJsonXmlUtil", "skip", paramXmlPullParser);
    }
  }
  
  private static ynx b(XmlPullParser paramXmlPullParser)
  {
    ynx localynx1;
    try
    {
      if (paramXmlPullParser.getEventType() != 2)
      {
        yny.d("GdtJsonXmlUtil", "parseTag error");
        return null;
      }
      localynx1 = new ynx();
      localynx1.jdField_a_of_type_JavaLangString = paramXmlPullParser.getName();
      if (TextUtils.isEmpty(localynx1.jdField_a_of_type_JavaLangString))
      {
        yny.d("GdtJsonXmlUtil", "parseTag error");
        return null;
      }
    }
    catch (XmlPullParserException paramXmlPullParser)
    {
      yny.d("GdtJsonXmlUtil", "parseTag", paramXmlPullParser);
      return null;
    }
    a(paramXmlPullParser);
    if (paramXmlPullParser.getEventType() == 3)
    {
      a(paramXmlPullParser);
      return localynx1;
    }
    if (paramXmlPullParser.getEventType() == 2)
    {
      ArrayList localArrayList = new ArrayList();
      localynx1.jdField_a_of_type_JavaLangObject = localArrayList;
      while (paramXmlPullParser.getEventType() == 2)
      {
        ynx localynx2 = b(paramXmlPullParser);
        if (localynx2 != null) {
          localArrayList.add(localynx2);
        }
      }
    }
    if (paramXmlPullParser.getEventType() == 4)
    {
      localynx1.jdField_a_of_type_JavaLangObject = paramXmlPullParser.getText();
      a(paramXmlPullParser);
      if (paramXmlPullParser.getEventType() == 3)
      {
        a(paramXmlPullParser);
        return localynx1;
      }
    }
    else
    {
      yny.d("GdtJsonXmlUtil", "parseTag error");
      return null;
    }
    yny.d("GdtJsonXmlUtil", "parseTag error");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynw
 * JD-Core Version:    0.7.0.1
 */