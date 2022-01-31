import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.DefaultHandler;

public class edg
  extends DefaultHandler
{
  private static final String jdField_a_of_type_JavaLangString = "config";
  private static final String b = "value";
  private static final String c = "termType";
  private static final String d = "icon";
  
  public edg(OnlineStatusIconHelper paramOnlineStatusIconHelper) {}
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public void endDocument() {}
  
  public void endElement(String paramString1, String paramString2, String paramString3) {}
  
  public void endPrefixMapping(String paramString) {}
  
  public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public void processingInstruction(String paramString1, String paramString2) {}
  
  public void setDocumentLocator(Locator paramLocator) {}
  
  public void skippedEntity(String paramString) {}
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("config")) {
      this.a.a.clear();
    }
    while (!paramString3.equals("value")) {
      return;
    }
    int i = Integer.parseInt(paramAttributes.getValue("termType"));
    try
    {
      int j = Integer.parseInt(paramAttributes.getValue("icon"));
      this.a.a.put(Integer.valueOf(i), Integer.valueOf(j));
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void startPrefixMapping(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     edg
 * JD-Core Version:    0.7.0.1
 */