package com.tencent.moai.nativepages.util;

import android.util.Log;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlParser
{
  private static final String TAG = "MicroMsg.SDK.XmlParser";
  private static ThreadLocal<XmlPullParser> threadLocalPool = new ThreadLocal();
  
  public static Map<String, String> parseXml(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {}
    for (int i = -1; i < 0; i = paramString1.indexOf("<" + paramString2))
    {
      Log.e("MicroMsg.SDK.XmlParser", "can not find the tag + " + paramString2);
      return null;
    }
    String str = paramString1;
    if (i > 0) {
      str = paramString1.substring(i);
    }
    try
    {
      paramString1 = new MMXmlPullParser(str, paramString2, paramString3).parse();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  static class MMXmlPullParser
  {
    private Map<Integer, Integer> countMap;
    private StringBuilder pathSB = new StringBuilder();
    private Map<String, String> result;
    private String rootTag;
    private XmlPullParser xmlParser;
    
    public MMXmlPullParser(String paramString1, String paramString2, String paramString3)
      throws XmlPullParserException
    {
      this.rootTag = paramString2;
      paramString2 = (XmlPullParser)XmlParser.threadLocalPool.get();
      this.xmlParser = paramString2;
      if (paramString2 == null)
      {
        paramString2 = XmlParser.threadLocalPool;
        paramString3 = XmlPullParserFactory.newInstance().newPullParser();
        this.xmlParser = paramString3;
        paramString2.set(paramString3);
      }
      this.xmlParser.setInput(new StringReader(paramString1));
      this.countMap = new HashMap();
      this.result = new HashMap();
    }
    
    private void handleElementContent()
    {
      String str = this.xmlParser.getText();
      if (str != null) {
        this.result.put(this.pathSB.toString(), str);
      }
    }
    
    private void handleEndElement()
    {
      this.pathSB = this.pathSB.delete(this.pathSB.lastIndexOf("."), this.pathSB.length());
    }
    
    private void handleStartElement()
    {
      this.pathSB.append('.').append(this.xmlParser.getName());
      String str = this.pathSB.toString();
      int i = str.hashCode();
      Integer localInteger = (Integer)this.countMap.get(Integer.valueOf(i));
      if (localInteger != null)
      {
        localInteger = Integer.valueOf(localInteger.intValue() + 1);
        this.pathSB.append(localInteger);
        this.countMap.put(Integer.valueOf(i), localInteger);
        str = str + localInteger;
      }
      for (;;)
      {
        this.result.put(str, "");
        i = 0;
        while (i < this.xmlParser.getAttributeCount())
        {
          this.result.put(str + ".$" + this.xmlParser.getAttributeName(i), this.xmlParser.getAttributeValue(i));
          i += 1;
        }
        this.countMap.put(Integer.valueOf(i), Integer.valueOf(0));
      }
    }
    
    public Map<String, String> parse()
      throws XmlPullParserException, IOException
    {
      int i = this.xmlParser.getEventType();
      do
      {
        int j;
        do
        {
          for (;;)
          {
            if (i == 1) {
              break label76;
            }
            j = this.xmlParser.next();
            if (j == 2)
            {
              handleStartElement();
              i = j;
            }
            else
            {
              if (j != 4) {
                break;
              }
              handleElementContent();
              i = j;
            }
          }
          i = j;
        } while (j != 3);
        handleEndElement();
        i = j;
      } while (this.pathSB.length() != 0);
      label76:
      return this.result;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.XmlParser
 * JD-Core Version:    0.7.0.1
 */