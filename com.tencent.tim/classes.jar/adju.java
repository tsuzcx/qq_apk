import android.content.Context;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class adju
  extends adjk
{
  public static boolean SP;
  private static final Object lock = new Object();
  
  protected static void Gm(boolean paramBoolean)
  {
    SP = paramBoolean;
  }
  
  public static boolean aeI()
  {
    boolean bool = true;
    if ((!adjk.a(1, SP, "QMCF_qr")) || (!adjk.a(1, SP, "yuvutil")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectSoLoader", 2, "native so is not exist!");
      }
      bool = false;
    }
    return bool;
  }
  
  public static byte e(String paramString)
  {
    return adjk.a(1, paramString);
  }
  
  public static boolean e(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MiniRecog.MiniScanDetectSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label222;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("QMCF_qr"))
      {
        paramHashMap.put("QMCF_qr", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("yuvutil"))
        {
          paramHashMap.put("yuvutil", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("QMCF_qr_64"))
        {
          paramHashMap.put("QMCF_qr_64", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("yuvutil_64")) {
          continue;
        }
        paramHashMap.put("yuvutil_64", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MiniRecog.MiniScanDetectSoLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label222:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static String getFileName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static Object getLock()
  {
    return lock;
  }
  
  public static byte h(String paramString)
  {
    return adjk.a(1, SP, paramString);
  }
  
  public static String jO(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static String jP(String paramString)
  {
    return adjk.w(1, paramString);
  }
  
  public static String sD()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDetectSoLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.minidetect.so_v8.2.0";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniScanDetectSoLoader", 2, "getLibDir ,path = " + str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adju
 * JD-Core Version:    0.7.0.1
 */