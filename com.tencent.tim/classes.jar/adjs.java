import android.content.Context;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class adjs
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
    if (!adjk.a(0, SP, "minicode"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDecodeSoLoader", 2, "native so is not exist!");
      }
      return false;
    }
    return true;
  }
  
  public static byte e(String paramString)
  {
    return adjk.a(0, paramString);
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
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MiniRecog.MiniScanDecodeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label165;
      str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("minicode")) {
        paramHashMap.put("minicode", localXmlPullParser.nextText());
      }
      if (str.equalsIgnoreCase("minicode_64"))
      {
        paramHashMap.put("minicode_64", localXmlPullParser.nextText());
        break label132;
        ;;
        label132:
        if (QLog.isColorLevel())
        {
          QLog.d("MiniRecog.MiniScanDecodeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
          return true;
          label165:
          if (i != 1) {
            switch (i)
            {
            }
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
    return adjk.a(0, SP, paramString);
  }
  
  public static String jO(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static String jP(String paramString)
  {
    return adjk.w(0, paramString);
  }
  
  public static String sD()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDecodeSoLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.minidecode.so_v8.2.0";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniScanDecodeSoLoader", 2, "getLibDir ,path = " + str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjs
 * JD-Core Version:    0.7.0.1
 */