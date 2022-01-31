package com.tencent.mobileqq.magicface.magicfaceaction;

import android.util.Xml;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MagicfaceActionDecoder
{
  public static final String A = "repeat";
  public static final String B = "colorMask";
  public static final String C = "vibrator";
  public static final String D = "time";
  public static final String E = "swipeGesture";
  public static final String F = "tapGesture";
  public static final String G = "dbTapGesture";
  public static final String H = "direction";
  public static final String I = "up";
  public static final String J = "down";
  public static final String K = "left";
  public static final String L = "right";
  public static final String a = "MagicfaceActionDecoder";
  public static final String b = "magicface";
  public static final String c = "useSensor";
  public static final String d = "record";
  public static final String e = "fullScreen";
  public static final String f = "action";
  public static final String g = "ready";
  public static final String h = "playRes";
  public static final String i = "timeout";
  public static final String j = "soundsrc";
  public static final String k = "stopcondition";
  public static final String l = "min";
  public static final String m = "max";
  public static final String n = "text";
  public static final String o = "name";
  public static final String p = "process";
  public static final String q = "type";
  public static final String r = "value";
  public static final String s = "gravity";
  public static final String t = "mic";
  public static final String u = "touch";
  public static final String v = "video";
  public static final String w = "sound";
  public static final String x = "title";
  public static final String y = "subtitle";
  public static final String z = "feekbacktext";
  private Action jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
  private ActionProcess jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
  private MagicfacePlayRes jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes;
  
  private void a(XmlPullParser paramXmlPullParser, Action paramAction)
  {
    paramAction.jdField_b_of_type_JavaLangString = paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "timeout");
    if (str != null) {
      paramAction.jdField_a_of_type_Int = Integer.parseInt(str);
    }
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "nextActionIfTimeout");
    if (paramXmlPullParser != null) {
      paramAction.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramXmlPullParser);
    }
  }
  
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
          break label280;
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
        paramString.h = localXmlPullParser.getAttributeValue(null, "useSensor");
        localObject2 = localXmlPullParser.getAttributeValue(null, "fullScreen");
        if (localObject2 == null) {
          break label212;
        }
        paramString.b = Boolean.parseBoolean((String)localObject2);
        label212:
        paramString.g = localXmlPullParser.getAttributeValue(null, "type");
        str = localXmlPullParser.getAttributeValue(null, "colorMask");
        if (str == null) {
          break label277;
        }
        localObject2 = str;
        if (!str.contains("0x")) {
          break label265;
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
            label265:
            paramString.jdField_a_of_type_Int = ((int)Long.parseLong((String)localObject2, 16));
            label277:
            continue;
            label280:
            if (((String)localObject2).equalsIgnoreCase("title"))
            {
              paramString.j = localXmlPullParser.getAttributeValue(null, "text");
            }
            else
            {
              if (((String)localObject2).equalsIgnoreCase("feekbacktext"))
              {
                localObject2 = new MagicfacebackText();
                ((MagicfacebackText)localObject2).jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "type");
                str = localXmlPullParser.getAttributeValue(null, "timeout");
                ((MagicfacebackText)localObject2).jdField_b_of_type_JavaLangString = str;
                if (str != null) {
                  paramString.jdField_c_of_type_Int = Integer.parseInt(str);
                }
                ((MagicfacebackText)localObject2).jdField_c_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "text");
                paramString.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText = ((MagicfacebackText)localObject2);
                return paramString;
              }
              if ("subtitle".equalsIgnoreCase((String)localObject2))
              {
                paramString.l = localXmlPullParser.getAttributeValue(null, "text");
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
          break label277;
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
  
  public List a(String paramString)
  {
    localXmlPullParser = Xml.newPullParser();
    try
    {
      localXmlPullParser.setInput(new StringReader(paramString));
      i1 = localXmlPullParser.getEventType();
      paramString = null;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        try
        {
          int i1 = localXmlPullParser.next();
          continue;
          try
          {
            ArrayList localArrayList = new ArrayList();
            paramString = localArrayList;
          }
          catch (Exception localException1) {}
          String str = paramString;
          if (QLog.isColorLevel())
          {
            QLog.d("MagicfaceActionDecoder", 2, "e=" + localException1.getMessage());
            str = paramString;
          }
          return str;
          localObject = localXmlPullParser.getName();
          if (((String)localObject).equalsIgnoreCase("action"))
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = new Action();
            paramString.add(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction);
            a(localXmlPullParser, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction);
            continue;
          }
          if (((String)localObject).equalsIgnoreCase("process"))
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = new ActionProcess();
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "type");
            continue;
          }
          if (((String)localObject).equalsIgnoreCase("gravity"))
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d = "gravity";
            localObject = localXmlPullParser.getAttributeValue(null, "value");
            if (localObject != null) {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
            }
          }
          else
          {
            if ("mic".equalsIgnoreCase((String)localObject))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d = "mic";
              localObject = localXmlPullParser.getAttributeValue(null, "value");
              if (localObject == null) {
                break label1131;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              break label1131;
            }
            if ("touch".equalsIgnoreCase((String)localObject))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d = "touch";
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("value"))
            {
              localObject = new RecordCondition();
              str = localXmlPullParser.getAttributeValue(null, "min");
              if (str != null) {
                ((RecordCondition)localObject).jdField_a_of_type_Int = Integer.parseInt(str);
              }
              str = localXmlPullParser.getAttributeValue(null, "max");
              if (str != null)
              {
                ((RecordCondition)localObject).jdField_b_of_type_Int = Integer.parseInt(str);
                if (((RecordCondition)localObject).jdField_b_of_type_Int == -1) {
                  ((RecordCondition)localObject).jdField_b_of_type_Int = 2147483647;
                }
              }
              str = localXmlPullParser.getAttributeValue(null, "sum");
              if (str != null) {
                ((RecordCondition)localObject).jdField_c_of_type_Int = Integer.parseInt(str);
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaUtilList.add(localObject);
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("text")) {
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("playRes"))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = new MagicfacePlayRes();
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
              localObject = localXmlPullParser.getAttributeValue(null, "min");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Int = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "max");
              if (localObject == null) {
                break label1134;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int = Integer.parseInt((String)localObject);
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int != -1) {
                break label1134;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int = 2147483647;
              break label1134;
            }
            if (((String)localObject).equalsIgnoreCase("video"))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "src");
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "srcAlpha");
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "duration");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.f = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "fps");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.g = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "repeat");
              if (localObject == null) {
                break label1137;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_Int = Integer.parseInt((String)localObject);
              break label1137;
            }
            if ("sound".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "src");
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "duration");
              if (localObject != null) {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.d = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "repeat");
              if (localObject == null) {
                break label1140;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.e = Integer.parseInt((String)localObject);
              break label1140;
            }
            if ("vibrator".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Boolean = true;
              localObject = localXmlPullParser.getAttributeValue(null, "time");
              if (localObject == null) {}
            }
          }
        }
        catch (Exception localException3)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.h = Integer.parseInt((String)localObject);
            continue;
            if ("swipeGesture".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "direction");
              if ("up".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 2;
                break label1143;
              }
              if ("down".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 3;
                break label1143;
              }
              if ("left".equalsIgnoreCase((String)localObject))
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 0;
                break label1143;
              }
              if (!"right".equalsIgnoreCase((String)localObject)) {
                break label1143;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 1;
              break label1143;
            }
            if ("dbTapGesture".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 5;
              continue;
            }
            if ((!"tapGesture".equalsIgnoreCase((String)localObject)) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 4;
            continue;
            Object localObject = localXmlPullParser.getName();
            if (((String)localObject).equalsIgnoreCase("action"))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = null;
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("process"))
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = null;
              continue;
            }
            if (!((String)localObject).equalsIgnoreCase("playRes")) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = null;
            continue;
            localException2 = localException2;
            paramString = null;
            continue;
            localException3 = localException3;
          }
          catch (Exception localException4)
          {
            continue;
          }
        }
        continue;
        continue;
        continue;
        continue;
        continue;
      }
    }
    str = paramString;
    if (i1 != 1) {
      switch (i1)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder
 * JD-Core Version:    0.7.0.1
 */