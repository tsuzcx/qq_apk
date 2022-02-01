import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@SuppressLint({"UseSparseArrays"})
public class zaq
{
  private static zaq a;
  HashMap<Integer, Integer> ho = new HashMap();
  
  private zaq(Context paramContext)
  {
    ds(paramContext);
  }
  
  public static zaq a()
  {
    try
    {
      if (a == null) {
        a = new zaq(BaseApplicationImpl.getContext());
      }
      return a;
    }
    finally {}
  }
  
  private void ds(Context paramContext)
  {
    try
    {
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      zaq.a locala = new zaq.a();
      localSAXParser.parse(paramContext.getAssets().open("online_status_icon_config.xml"), locala);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public int am(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.ho.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {
      return paramInt2;
    }
    return localInteger.intValue();
  }
  
  public int fA(int paramInt)
  {
    return am(paramInt, 1);
  }
  
  public boolean gR(int paramInt)
  {
    paramInt = fA(paramInt);
    return (paramInt == 3) || (paramInt == 2);
  }
  
  class a
    extends DefaultHandler
  {
    a() {}
    
    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws SAXException
    {}
    
    public void endDocument()
      throws SAXException
    {}
    
    public void endElement(String paramString1, String paramString2, String paramString3) {}
    
    public void endPrefixMapping(String paramString)
      throws SAXException
    {}
    
    public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws SAXException
    {}
    
    public void processingInstruction(String paramString1, String paramString2)
      throws SAXException
    {}
    
    public void setDocumentLocator(Locator paramLocator) {}
    
    public void skippedEntity(String paramString)
      throws SAXException
    {}
    
    public void startDocument()
      throws SAXException
    {}
    
    public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    {
      if (paramString3.equals("config")) {
        zaq.this.ho.clear();
      }
      while (!paramString3.equals("value")) {
        return;
      }
      int i = Integer.parseInt(paramAttributes.getValue("termType"));
      try
      {
        int j = Integer.parseInt(paramAttributes.getValue("icon"));
        zaq.this.ho.put(Integer.valueOf(i), Integer.valueOf(j));
        return;
      }
      catch (Exception paramString1) {}
    }
    
    public void startPrefixMapping(String paramString1, String paramString2)
      throws SAXException
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zaq
 * JD-Core Version:    0.7.0.1
 */