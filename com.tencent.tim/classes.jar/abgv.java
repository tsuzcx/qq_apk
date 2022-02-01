import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class abgv
  extends DefaultHandler
{
  private int nVersion;
  private ArrayList<String> urlList;
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    paramArrayOfChar = paramArrayOfChar.toString();
    QLog.d("SAXForHandler", 4, "characters: " + paramArrayOfChar);
  }
  
  public ArrayList<String> cl()
  {
    return this.urlList;
  }
  
  public void endDocument()
    throws SAXException
  {
    QLog.d("SAXForHandler", 4, "endDocument");
    super.endDocument();
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    QLog.d("SAXForHandler", 4, "endElement uri:" + paramString1 + " localName:" + paramString2 + " qName:" + paramString3);
  }
  
  public void startDocument()
    throws SAXException
  {
    QLog.d("SAXForHandler", 4, "startDocument");
    this.urlList = null;
    this.urlList = new ArrayList();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    int j = 0;
    int i = 0;
    QLog.d("SAXForHandler", 4, "startElement: uri:" + paramString1 + " localName:" + paramString2 + " qName:" + paramString3);
    if ("config".equals(paramString2)) {
      while (i < paramAttributes.getLength())
      {
        this.nVersion = Integer.valueOf(paramAttributes.getValue(i)).intValue();
        QLog.d("SAXForHandler", 4, "startElement: localName:" + paramString2 + " value: " + this.nVersion);
        i += 1;
      }
    }
    if ("Elem".equals(paramString2))
    {
      i = j;
      while (i < paramAttributes.getLength())
      {
        paramString1 = paramAttributes.getValue(i);
        paramString3 = paramAttributes.getLocalName(i);
        QLog.d("SAXForHandler", 4, "startElement: localName:" + paramString2 + "name: " + paramString3 + " url: " + paramString1);
        this.urlList.add(paramString1);
        i += 1;
      }
    }
  }
  
  public int zx()
  {
    return this.nVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgv
 * JD-Core Version:    0.7.0.1
 */