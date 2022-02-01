import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class apyj
  extends DefaultHandler
{
  protected ArrayList<apyg> CD = new ArrayList();
  protected boolean cSX;
  protected apyg e;
  protected apyg f;
  protected String id;
  
  public apyj(String paramString)
  {
    this.id = paramString;
  }
  
  public apyg b()
  {
    return this.e;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {}
  
  public ArrayList<apyg> dY()
  {
    return this.CD;
  }
  
  public void endDocument()
    throws SAXException
  {}
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if (this.f != null) {
      this.f = this.f.c;
    }
  }
  
  public void startDocument()
    throws SAXException
  {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    paramString3 = null;
    int j = paramAttributes.getLength();
    int i = 0;
    paramString1 = null;
    String str2;
    String str1;
    if (i < j)
    {
      str2 = paramAttributes.getLocalName(i);
      str1 = paramAttributes.getValue(str2);
      if ("id".equals(str2)) {
        paramString1 = str1;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ("value".equals(str2))
      {
        paramString3 = str1;
        continue;
        if (("0".equals(paramString1)) || (paramString1 == null)) {}
        for (;;)
        {
          return;
          paramAttributes = this.f;
          if (paramString2.startsWith("L"))
          {
            paramString2 = paramString2.substring(1);
            try
            {
              i = Integer.parseInt(paramString2);
              if (i != 0)
              {
                paramString2 = new apyg(i, paramString1, paramString3);
                this.f = paramString2;
                if (paramString2.a(paramAttributes))
                {
                  paramAttributes.a(this.f);
                  if ((this.cSX) || (!String.valueOf(this.id).equals(paramString1))) {
                    continue;
                  }
                  this.cSX = true;
                  this.e = paramString2;
                }
              }
            }
            catch (NumberFormatException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
                i = 0;
                continue;
                this.CD.add(this.f);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyj
 * JD-Core Version:    0.7.0.1
 */