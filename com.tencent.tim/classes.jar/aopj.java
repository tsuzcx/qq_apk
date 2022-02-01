import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class aopj
{
  private aopk a;
  private XmlPullParser b;
  
  private void dWy()
  {
    String str1 = this.b.getAttributeValue(null, "extension");
    String str2 = this.b.getAttributeValue(null, "mimetype");
    this.a.put(str1, str2);
  }
  
  public aopk a()
    throws XmlPullParserException, IOException
  {
    this.a = new aopk();
    int i = this.b.getEventType();
    if (i != 1)
    {
      String str = this.b.getName();
      if (i == 2) {
        if (!str.equals("MimeTypes")) {}
      }
      for (;;)
      {
        i = this.b.next();
        break;
        if (str.equals("type"))
        {
          dWy();
          continue;
          if ((i != 3) || (!str.equals("MimeTypes"))) {}
        }
      }
    }
    return this.a;
  }
  
  public aopk a(XmlResourceParser paramXmlResourceParser)
    throws XmlPullParserException, IOException
  {
    this.b = paramXmlResourceParser;
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopj
 * JD-Core Version:    0.7.0.1
 */