import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class adjt
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
    if ((!kU("qr_anchor.bin")) || (!kU("qr_detection_model.txt")) || (!kU("qr_detection_model.bin")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "modules is not exist!");
      }
      return false;
    }
    return true;
  }
  
  public static byte e(String paramString)
  {
    return adjk.a(2, paramString);
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
        QLog.e("MiniRecog.MiniScanDetectModelLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label245;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("qr_anchor.bin"))
      {
        paramHashMap.put("qr_anchor.bin", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("qr_detection_model.txt"))
        {
          paramHashMap.put("qr_detection_model.txt", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("qr_detection_model.bin"))
        {
          paramHashMap.put("qr_detection_model.bin", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("match_detect_so_md5"))
        {
          fo("match_detect_so_md5", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("match_detect_so_md5_64")) {
          continue;
        }
        fo("match_detect_so_md5_64", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label245:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static void fo(String paramString1, String paramString2)
  {
    Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).edit();
    if (TextUtils.isEmpty(paramString2)) {
      ((SharedPreferences.Editor)localObject).putString("mini_native_" + paramString1, "").apply();
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = paramString2;
        if (paramString2 == null) {
          localObject = "null";
        }
        QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("saveMatchDetectSoMd5=%s tag=%s", new Object[] { localObject, paramString1 }));
      }
      return;
      ((SharedPreferences.Editor)localObject).putString("mini_native_" + paramString1, paramString2).apply();
    }
  }
  
  public static String getFileName(String paramString)
  {
    return paramString;
  }
  
  public static Object getLock()
  {
    return lock;
  }
  
  public static String jO(String paramString)
  {
    return paramString;
  }
  
  public static boolean kU(String paramString)
  {
    return adjk.a(2, SP, paramString);
  }
  
  public static String sD()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.minidetect.model_v8.2.0";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getLibDir ,path = " + str);
    return str;
  }
  
  public static String sE()
  {
    String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("mini_native_" + "match_detect_so_md5", null);
    if (QLog.isColorLevel()) {
      if (str2 != null) {
        break label75;
      }
    }
    label75:
    for (String str1 = "null";; str1 = str2)
    {
      QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("getMatchDetectSoMd5=%s tag=%s", new Object[] { str1, "match_detect_so_md5" }));
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjt
 * JD-Core Version:    0.7.0.1
 */