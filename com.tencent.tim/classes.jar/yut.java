import android.text.TextUtils;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class yut
{
  public boolean boZ;
  public boolean bpa = true;
  public int cbo;
  public int cbp;
  public int cbq;
  public String text;
  public int totalNum;
  public String url;
  public int version;
  
  public static yut a(String paramString)
    throws XmlPullParserException, IOException
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      yut localyut = new yut();
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      for (int i = 0;; i = localXmlPullParser.next())
      {
        localObject = localyut;
        if (i == 1) {
          break;
        }
        if ((i == 2) && (localXmlPullParser.getName().equalsIgnoreCase("banner")))
        {
          int j = localXmlPullParser.getAttributeCount();
          i = 0;
          if (i < j)
          {
            paramString = localXmlPullParser.getAttributeName(i);
            if ("text".equals(paramString)) {
              localyut.text = localXmlPullParser.getAttributeValue(i);
            }
            for (;;)
            {
              i += 1;
              break;
              if ("url".equals(paramString)) {
                localyut.url = localXmlPullParser.getAttributeValue(i);
              } else if ("dayNum".equals(paramString)) {
                localyut.cbo = Integer.valueOf(localXmlPullParser.getAttributeValue(i)).intValue();
              } else if ("dayIntervalNum".equals(paramString)) {
                localyut.cbp = Integer.valueOf(localXmlPullParser.getAttributeValue(i)).intValue();
              } else if ("totalNum".equals(paramString)) {
                localyut.totalNum = Integer.valueOf(localXmlPullParser.getAttributeValue(i)).intValue();
              } else if ("loginNum".equals(paramString)) {
                localyut.cbq = Integer.valueOf(localXmlPullParser.getAttributeValue(i)).intValue();
              } else if ("banner".equals(paramString)) {
                localyut.boZ = "1".equals(localXmlPullParser.getAttributeValue(i));
              } else if ("setEntry".equals(paramString)) {
                localyut.bpa = "1".equals(localXmlPullParser.getAttributeValue(i));
              }
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public String toString()
  {
    return "MobileUnityBannerData [url=" + this.url + ", text=" + this.text + ", dayNum=" + this.cbo + ", dayIntervalNum=" + this.cbp + ", totalNum=" + this.totalNum + ", loginNum = " + this.cbq + ", version=" + this.version + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yut
 * JD-Core Version:    0.7.0.1
 */