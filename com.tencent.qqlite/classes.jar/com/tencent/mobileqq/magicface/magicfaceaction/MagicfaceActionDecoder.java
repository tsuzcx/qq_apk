package com.tencent.mobileqq.magicface.magicfaceaction;

import android.text.TextUtils;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MagicfaceActionDecoder
{
  public static final String A = "title";
  public static final String B = "subtitle";
  public static final String C = "feekbacktext";
  public static final String D = "repeat";
  public static final String E = "colorMask";
  public static final String F = "vibrator";
  public static final String G = "time";
  public static final String H = "swipeGesture";
  public static final String I = "tapGesture";
  public static final String J = "dbTapGesture";
  public static final String K = "direction";
  public static final String L = "up";
  public static final String M = "down";
  public static final String N = "left";
  public static final String O = "right";
  public static final String P = "stopType";
  public static final String Q = "willDo";
  public static final String R = "replacevalue";
  public static final String a = "MagicfaceActionDecoder";
  public static final String b = "magicface";
  public static final String c = "useSensor";
  public static final String d = "record";
  public static final String e = "fullScreen";
  public static final String f = "minQVer";
  public static final String g = "action";
  public static final String h = "ActionDef";
  public static final String i = "playResDef";
  public static final String j = "ready";
  public static final String k = "playRes";
  public static final String l = "timeout";
  public static final String m = "soundsrc";
  public static final String n = "stopcondition";
  public static final String o = "min";
  public static final String p = "max";
  public static final String q = "text";
  public static final String r = "name";
  public static final String s = "process";
  public static final String t = "type";
  public static final String u = "value";
  public static final String v = "gravity";
  public static final String w = "mic";
  public static final String x = "touch";
  public static final String y = "video";
  public static final String z = "sound";
  
  public ActionGlobalData a(String paramString)
  {
    try
    {
      localObject1 = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject1).setNamespaceAware(true);
      localXmlPullParser = ((XmlPullParserFactory)localObject1).newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      i1 = localXmlPullParser.getEventType();
      paramString = null;
    }
    catch (Exception localException3)
    {
      try
      {
        for (;;)
        {
          Object localObject1;
          int i1 = localXmlPullParser.next();
          continue;
          try
          {
            localObject1 = new ActionGlobalData();
            paramString = (String)localObject1;
          }
          catch (Exception localException1) {}
        }
        localException1.printStackTrace();
        localObject2 = paramString;
        return localObject2;
        localObject2 = localXmlPullParser.getName();
        if (!((String)localObject2).equalsIgnoreCase("magicface")) {
          break label306;
        }
        localObject2 = localXmlPullParser.getAttributeValue(null, "action");
        if (localObject2 == null) {
          break label172;
        }
        boolean bool = Boolean.parseBoolean((String)localObject2);
        if (bool) {
          break label172;
        }
        paramString.jdField_a_of_type_Boolean = bool;
        return paramString;
        label172:
        paramString.j = localXmlPullParser.getAttributeValue(null, "useSensor");
        localObject2 = localXmlPullParser.getAttributeValue(null, "fullScreen");
        if (localObject2 == null) {
          break label212;
        }
        paramString.b = Boolean.parseBoolean((String)localObject2);
        label212:
        localObject2 = localXmlPullParser.getAttributeValue(null, "minQVer");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label238;
        }
        paramString.i = ((String)localObject2);
        label238:
        paramString.h = localXmlPullParser.getAttributeValue(null, "type");
        str = localXmlPullParser.getAttributeValue(null, "colorMask");
        if (str == null) {
          break label303;
        }
        localObject2 = str;
        if (!str.contains("0x")) {
          break label291;
        }
        localObject2 = str.substring(2);
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            XmlPullParser localXmlPullParser;
            Object localObject2;
            String str;
            label291:
            paramString.jdField_a_of_type_Int = ((int)Long.parseLong((String)localObject2, 16));
            label303:
            continue;
            label306:
            if (((String)localObject2).equalsIgnoreCase("title"))
            {
              paramString.l = localXmlPullParser.getAttributeValue(null, "text");
            }
            else
            {
              if (((String)localObject2).equalsIgnoreCase("feekbacktext"))
              {
                localObject2 = new MagicfacebackText();
                ((MagicfacebackText)localObject2).a = localXmlPullParser.getAttributeValue(null, "type");
                str = localXmlPullParser.getAttributeValue(null, "timeout");
                ((MagicfacebackText)localObject2).b = str;
                if (str != null) {
                  paramString.c = Integer.parseInt(str);
                }
                ((MagicfacebackText)localObject2).c = localXmlPullParser.getAttributeValue(null, "text");
                paramString.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText = ((MagicfacebackText)localObject2);
                return paramString;
              }
              if ("subtitle".equalsIgnoreCase((String)localObject2))
              {
                paramString.n = localXmlPullParser.getAttributeValue(null, "text");
                continue;
                localException2 = localException2;
                paramString = null;
              }
            }
          }
          localException3 = localException3;
        }
        catch (Exception localException4)
        {
          break label303;
        }
      }
    }
    localObject1 = paramString;
    if (i1 != 1) {
      switch (i1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder
 * JD-Core Version:    0.7.0.1
 */