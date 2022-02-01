import android.graphics.Color;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class aixv
{
  private aixr jdField_a_of_type_Aixr;
  private aiye jdField_a_of_type_Aiye;
  private aixu b;
  
  private void a(XmlPullParser paramXmlPullParser, aixr paramaixr)
  {
    paramaixr.name = paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "timeout");
    if (str != null) {
      paramaixr.timeout = Integer.parseInt(str);
    }
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "nextActionIfTimeout");
    if (paramXmlPullParser != null) {
      paramaixr.cmz = Boolean.parseBoolean(paramXmlPullParser);
    }
  }
  
  public aixt a(String paramString)
  {
    try
    {
      localObject1 = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject1).setNamespaceAware(true);
      localXmlPullParser = ((XmlPullParserFactory)localObject1).newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      i = localXmlPullParser.getEventType();
      paramString = null;
    }
    catch (Exception localException3)
    {
      label980:
      for (;;)
      {
        try
        {
          Object localObject1;
          int i = localXmlPullParser.next();
          continue;
          try
          {
            localObject1 = new aixt();
            paramString = (String)localObject1;
          }
          catch (Exception localException1) {}
          localException1.printStackTrace();
          localObject2 = paramString;
          return localObject2;
          localObject2 = localXmlPullParser.getName();
          if (((String)localObject2).equalsIgnoreCase("magicface"))
          {
            localObject2 = localXmlPullParser.getAttributeValue(null, "isAutoPlay");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramString.isAutoPlay = Boolean.parseBoolean((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "action");
            if (localObject2 != null)
            {
              boolean bool = Boolean.parseBoolean((String)localObject2);
              if (!bool)
              {
                paramString.cmB = bool;
                return paramString;
              }
            }
            paramString.bPV = localXmlPullParser.getAttributeValue(null, "useSensor");
            localObject2 = localXmlPullParser.getAttributeValue(null, "fullScreen");
            if (localObject2 != null) {
              paramString.fullScreen = Boolean.parseBoolean((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "minQVer");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramString.bPU = ((String)localObject2);
            }
            paramString.type = localXmlPullParser.getAttributeValue(null, "type");
            str = localXmlPullParser.getAttributeValue(null, "colorMask");
            if (str != null)
            {
              localObject2 = str;
              if (str.contains("0x")) {
                localObject2 = str.substring(2);
              }
            }
          }
        }
        catch (Exception localException3)
        {
          try
          {
            XmlPullParser localXmlPullParser;
            paramString.dgh = ((int)Long.parseLong((String)localObject2, 16));
            Object localObject2 = localXmlPullParser.getAttributeValue(null, "windowWidth");
            if (localObject2 != null) {
              paramString.windowWidth = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "windowHeight");
            if (localObject2 != null) {
              paramString.windowHeight = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "avatarCenter");
            if (localObject2 != null) {
              paramString.dgj = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "windowCenter");
            if (localObject2 != null) {
              paramString.dgk = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "isShowCount");
            if (localObject2 != null) {
              paramString.cmD = Boolean.parseBoolean((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "faceCenter");
            if (localObject2 != null) {
              paramString.dgl = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "faceLevel");
            if (localObject2 != null) {
              paramString.dgm = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "isHideFace");
            if (localObject2 != null) {
              paramString.cmE = Boolean.parseBoolean((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "bntCenter");
            if (localObject2 != null) {
              paramString.dgn = Integer.parseInt((String)localObject2);
            }
            localObject2 = localXmlPullParser.getAttributeValue(null, "isHideGetBtn");
            if (localObject2 != null) {
              paramString.cmF = Boolean.parseBoolean((String)localObject2);
            }
            String str = localXmlPullParser.getAttributeValue(null, "titleColor");
            if (str != null)
            {
              localObject2 = str;
              if (!str.startsWith("#")) {
                localObject2 = "#" + str;
              }
              paramString.titleColor = Color.parseColor((String)localObject2);
            }
            str = localXmlPullParser.getAttributeValue(null, "resultSuccessColor");
            if (str != null)
            {
              localObject2 = str;
              if (!str.startsWith("#")) {
                localObject2 = "#" + str;
              }
              paramString.dgo = Color.parseColor((String)localObject2);
            }
            str = localXmlPullParser.getAttributeValue(null, "resultFailedColor");
            if (str != null)
            {
              localObject2 = str;
              if (!str.startsWith("#")) {
                localObject2 = "#" + str;
              }
              paramString.dgp = Color.parseColor((String)localObject2);
            }
            paramString.bPY = localXmlPullParser.getAttributeValue(null, "titleStr");
            localObject2 = localXmlPullParser.getAttributeValue(null, "detailStripColor");
            if (localObject2 != null)
            {
              paramString.bPX = ((String)localObject2);
              break label980;
              if (((String)localObject2).equalsIgnoreCase("title"))
              {
                paramString.title = localXmlPullParser.getAttributeValue(null, "text");
              }
              else
              {
                if (((String)localObject2).equalsIgnoreCase("feekbacktext"))
                {
                  localObject2 = new aixw();
                  ((aixw)localObject2).type = localXmlPullParser.getAttributeValue(null, "type");
                  str = localXmlPullParser.getAttributeValue(null, "timeout");
                  ((aixw)localObject2).bQa = str;
                  if (str != null) {
                    paramString.dgi = Integer.parseInt(str);
                  }
                  ((aixw)localObject2).text = localXmlPullParser.getAttributeValue(null, "text");
                  paramString.a = ((aixw)localObject2);
                  return paramString;
                }
                if ("subtitle".equalsIgnoreCase((String)localObject2))
                {
                  paramString.subTitle = localXmlPullParser.getAttributeValue(null, "text");
                  continue;
                  localException2 = localException2;
                  paramString = null;
                  continue;
                  localException3 = localException3;
                }
              }
            }
          }
          catch (Exception localException4) {}
        }
      }
    }
    localObject1 = paramString;
    if (i != 1) {
      switch (i)
      {
      }
    }
  }
  
  public List<aixr> ay(String paramString)
  {
    localXmlPullParser = Xml.newPullParser();
    try
    {
      localXmlPullParser.setInput(new StringReader(paramString));
      i = localXmlPullParser.getEventType();
      paramString = null;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        try
        {
          int i = localXmlPullParser.next();
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
          if ((((String)localObject).equalsIgnoreCase("action")) || (((String)localObject).equalsIgnoreCase("ActionDef")))
          {
            this.jdField_a_of_type_Aixr = new aixr();
            paramString.add(this.jdField_a_of_type_Aixr);
            a(localXmlPullParser, this.jdField_a_of_type_Aixr);
            localObject = localXmlPullParser.getAttributeValue(null, "willDo");
            if ((localObject != null) && ("send".equalsIgnoreCase(((String)localObject).trim()))) {
              this.jdField_a_of_type_Aixr.cmA = true;
            }
          }
          else
          {
            if (((String)localObject).equalsIgnoreCase("process"))
            {
              this.b = new aixu();
              this.jdField_a_of_type_Aixr.a = this.b;
              this.b.type = localXmlPullParser.getAttributeValue(null, "type");
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("gravity"))
            {
              this.b.bPV = "gravity";
              localObject = localXmlPullParser.getAttributeValue(null, "value");
              if (localObject != null) {
                this.b.dgq = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1319;
              }
              this.b.bPZ = ((String)localObject);
              break label1319;
            }
            if ("mic".equalsIgnoreCase((String)localObject))
            {
              this.b.bPV = "mic";
              localObject = localXmlPullParser.getAttributeValue(null, "value");
              if (localObject != null) {
                this.b.dgq = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "replacevalue");
              if (localObject != null) {
                this.b.dgq = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1322;
              }
              this.b.bPZ = ((String)localObject);
              break label1322;
            }
            if ("touch".equalsIgnoreCase((String)localObject))
            {
              this.b.bPV = "touch";
              localObject = localXmlPullParser.getAttributeValue(null, "stopType");
              if (localObject == null) {
                break label1325;
              }
              this.b.bPZ = ((String)localObject);
              break label1325;
            }
            if (((String)localObject).equalsIgnoreCase("value"))
            {
              localObject = new aixx();
              str = localXmlPullParser.getAttributeValue(null, "min");
              if (str != null) {
                ((aixx)localObject).min = Integer.parseInt(str);
              }
              str = localXmlPullParser.getAttributeValue(null, "max");
              if (str != null)
              {
                ((aixx)localObject).max = Integer.parseInt(str);
                if (((aixx)localObject).max == -1) {
                  ((aixx)localObject).max = 2147483647;
                }
              }
              str = localXmlPullParser.getAttributeValue(null, "sum");
              if (str != null) {
                ((aixx)localObject).cEg = Integer.parseInt(str);
              }
              this.b.CK.add(localObject);
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("text")) {
              continue;
            }
            if ((((String)localObject).equalsIgnoreCase("playRes")) || (((String)localObject).equalsIgnoreCase("playResDef")))
            {
              this.jdField_a_of_type_Aiye = new aiye();
              this.jdField_a_of_type_Aixr.CJ.add(this.jdField_a_of_type_Aiye);
              localObject = localXmlPullParser.getAttributeValue(null, "min");
              if (localObject != null) {
                this.jdField_a_of_type_Aiye.min = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "max");
              if (localObject == null) {
                break label1328;
              }
              this.jdField_a_of_type_Aiye.max = Integer.parseInt((String)localObject);
              if (this.jdField_a_of_type_Aiye.max != -1) {
                break label1328;
              }
              this.jdField_a_of_type_Aiye.max = 2147483647;
              break label1328;
            }
            if (((String)localObject).equalsIgnoreCase("video"))
            {
              if (this.jdField_a_of_type_Aiye == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "src");
              this.jdField_a_of_type_Aiye.bQb = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "srcAlpha");
              this.jdField_a_of_type_Aiye.bQc = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "duration");
              if (localObject != null) {
                this.jdField_a_of_type_Aiye.duration = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "fps");
              if (localObject != null) {
                this.jdField_a_of_type_Aiye.fps = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "repeat");
              if (localObject == null) {
                break label1331;
              }
              this.jdField_a_of_type_Aiye.dgO = Integer.parseInt((String)localObject);
              break label1331;
            }
            if ("sound".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_Aiye == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "src");
              this.jdField_a_of_type_Aiye.bQd = ((String)localObject);
              localObject = localXmlPullParser.getAttributeValue(null, "duration");
              if (localObject != null) {
                this.jdField_a_of_type_Aiye.aLO = Integer.parseInt((String)localObject);
              }
              localObject = localXmlPullParser.getAttributeValue(null, "repeat");
              if (localObject == null) {
                break label1334;
              }
              this.jdField_a_of_type_Aiye.dgP = Integer.parseInt((String)localObject);
              break label1334;
            }
            if ("vibrator".equalsIgnoreCase((String)localObject))
            {
              if (this.jdField_a_of_type_Aiye == null) {
                continue;
              }
              this.jdField_a_of_type_Aiye.cmI = true;
              localObject = localXmlPullParser.getAttributeValue(null, "time");
              if (localObject == null) {}
            }
          }
        }
        catch (Exception localException3)
        {
          try
          {
            this.jdField_a_of_type_Aiye.dgQ = Integer.parseInt((String)localObject);
            continue;
            if ("swipeGesture".equalsIgnoreCase((String)localObject))
            {
              if (this.b == null) {
                continue;
              }
              localObject = localXmlPullParser.getAttributeValue(null, "direction");
              if ("up".equalsIgnoreCase((String)localObject))
              {
                this.b.dgr = 2;
                break label1337;
              }
              if ("down".equalsIgnoreCase((String)localObject))
              {
                this.b.dgr = 3;
                break label1337;
              }
              if ("left".equalsIgnoreCase((String)localObject))
              {
                this.b.dgr = 0;
                break label1337;
              }
              if (!"right".equalsIgnoreCase((String)localObject)) {
                break label1337;
              }
              this.b.dgr = 1;
              break label1337;
            }
            if ("dbTapGesture".equalsIgnoreCase((String)localObject))
            {
              if (this.b == null) {
                continue;
              }
              this.b.dgr = 5;
              continue;
            }
            if ((!"tapGesture".equalsIgnoreCase((String)localObject)) || (this.b == null)) {
              continue;
            }
            this.b.dgr = 4;
            continue;
            Object localObject = localXmlPullParser.getName();
            if (((String)localObject).equalsIgnoreCase("action"))
            {
              this.jdField_a_of_type_Aixr = null;
              continue;
            }
            if (((String)localObject).equalsIgnoreCase("process"))
            {
              this.b = null;
              continue;
            }
            if (!((String)localObject).equalsIgnoreCase("playRes")) {
              continue;
            }
            this.jdField_a_of_type_Aiye = null;
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
        continue;
        continue;
      }
    }
    str = paramString;
    if (i != 1) {
      switch (i)
      {
      }
    }
  }
  
  public int dt(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = XmlPullParserFactory.newInstance();
        ((XmlPullParserFactory)localObject).setNamespaceAware(true);
        localObject = ((XmlPullParserFactory)localObject).newPullParser();
        ((XmlPullParser)localObject).setInput(new StringReader(paramString));
        i = ((XmlPullParser)localObject).getEventType();
      }
      catch (Exception paramString)
      {
        Object localObject;
        paramString.printStackTrace();
        return 0;
      }
      int i = ((XmlPullParser)localObject).next();
      if (((XmlPullParser)localObject).getName().equalsIgnoreCase("random"))
      {
        i = Integer.parseInt(((XmlPullParser)localObject).getAttributeValue(null, "value"));
        return i;
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixv
 * JD-Core Version:    0.7.0.1
 */