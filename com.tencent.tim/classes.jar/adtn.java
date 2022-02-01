import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class adtn
{
  private static final Object di = new Object();
  private static HashMap<String, Integer> jG = new HashMap(8);
  private static HashMap<String, Integer> jH = new HashMap(8);
  private static String sQQVersion = "";
  
  public static void GV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (di)
    {
      Integer localInteger = (Integer)jG.get(paramString);
      if (localInteger != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report valid resource app=", paramString, ", count=", localInteger, ", result=0 , QQVersion=", getQQVersion() });
        }
        anot.b(null, "dc00898", "", "", "0X8009BCF", "0X8009BCF", 0, localInteger.intValue(), 0, getQQVersion(), "", paramString, "");
        jG.remove(paramString);
      }
      synchronized (di)
      {
        localInteger = (Integer)jH.get(paramString);
        if (localInteger != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report valid navigation app=", paramString, ", count=", localInteger, ", result=0, r3=1, QQVersion=", getQQVersion() });
          }
          anot.b(null, "dc00898", "", "", "0X8009BD0", "0X8009BD0", 0, localInteger.intValue(), 0, getQQVersion(), "1", paramString, "");
          jH.remove(paramString);
        }
        return;
      }
    }
  }
  
  private static void a(adtn.a parama)
  {
    if (parama == null) {}
    do
    {
      do
      {
        return;
        parama = parama.toString();
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report reportRealTime content=", parama });
        }
        if (1 != BaseApplicationImpl.sProcessId) {
          break;
        }
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      } while (localObject == null);
      localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(121)).a();
    } while (localObject == null);
    ((adqb)localObject).lO(parama);
    return;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("reportContent", parama);
    adst.a().a("callReportUrlCheck", (Bundle)localObject, null);
  }
  
  public static void d(String paramString1, String arg1, int paramInt1, int paramInt2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {
      return;
    }
    if (paramInt2 == 0) {
      for (;;)
      {
        synchronized (di)
        {
          paramString3 = (Integer)jG.get(paramString1);
          if (paramString3 != null)
          {
            paramInt1 = paramString3.intValue();
            jG.put(paramString1, Integer.valueOf(paramInt1 + 1));
            return;
          }
        }
        jG.put(paramString1, Integer.valueOf(1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report invalid resource url app=", paramString1, ", count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), ",sender uin=", paramString3, " ,url=", jqo.filterKeyForLog(???, new String[0]), " ,QQVersion=", getQQVersion() });
    }
    anot.c(null, "dc00898", "", paramString3, "0X8009BCF", "0X8009BCF", paramInt1, paramInt2, getQQVersion(), "0", paramString1, ???);
    paramString3 = new adtn.a();
    paramString3.app = paramString1;
    paramString3.url = ???;
    paramString3.scene = 0;
    paramString3.type = paramInt1;
    paramString3.result = paramInt2;
    a(paramString3);
  }
  
  public static void e(String paramString1, String arg1, int paramInt1, int paramInt2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {
      return;
    }
    if (paramInt2 == 0) {
      for (;;)
      {
        synchronized (di)
        {
          paramString3 = (Integer)jH.get(paramString1);
          if (paramString3 != null)
          {
            paramInt1 = paramString3.intValue();
            jH.put(paramString1, Integer.valueOf(paramInt1 + 1));
            return;
          }
        }
        jH.put(paramString1, Integer.valueOf(1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report invalid navigation url app=", paramString1, ",count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), ",sender uin=", paramString3, ",r3=1 ,url=", jqo.filterKeyForLog(???, new String[0]), " ,QQVersion=", getQQVersion() });
    }
    anot.c(null, "dc00898", "", paramString3, "0X8009BD0", "0X8009BD0", paramInt1, paramInt2, getQQVersion(), "1", paramString1, ???);
    paramString3 = new adtn.a();
    paramString3.app = paramString1;
    paramString3.url = ???;
    paramString3.scene = 1;
    paramString3.type = paramInt1;
    paramString3.result = paramInt2;
    a(paramString3);
  }
  
  public static void f(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report web url app=", paramString1, ", count=1, result=0, r3=2, url=", jqo.filterKeyForLog(paramString2, new String[0]), ",QQVersion=", getQQVersion() });
      }
      anot.c(null, "dc00898", "", "", "0X8009BD0", "0X8009BD0", 0, 0, getQQVersion(), "2", paramString1, "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report web url app=", paramString1, ", count=1, result=", Integer.valueOf(paramInt2), ",validType=", Integer.valueOf(paramInt1), " ,sender uin=", paramString3, " ,r3=2 ,url=", jqo.filterKeyForLog(paramString2, new String[0]), " ,QQVersion=", getQQVersion() });
    }
    anot.c(null, "dc00898", "", paramString3, "0X8009BD0", "0X8009BD0", paramInt1, paramInt2, getQQVersion(), "2", paramString1, paramString2);
    paramString3 = new adtn.a();
    paramString3.app = paramString1;
    paramString3.url = paramString2;
    paramString3.result = paramInt2;
    paramString3.scene = 2;
    paramString3.type = paramInt1;
    paramString3.result = paramInt2;
    a(paramString3);
  }
  
  private static String getQQVersion()
  {
    if (TextUtils.isEmpty(sQQVersion)) {}
    for (;;)
    {
      try
      {
        arrayOfString = "3.4.4".split("\\.");
        if (arrayOfString != null)
        {
          if (arrayOfString.length < 3) {
            continue;
          }
          sQQVersion = String.format("%d%02d%02d", new Object[] { Integer.valueOf(Integer.parseInt(arrayOfString[0])), Integer.valueOf(Integer.parseInt(arrayOfString[1])), Integer.valueOf(Integer.parseInt(arrayOfString[2])) });
        }
      }
      catch (Exception localException)
      {
        String[] arrayOfString;
        QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkSecurityReporter", 2, new Object[] { "ArkSafe.report get QQVersion=", sQQVersion });
      }
      return sQQVersion;
      if (arrayOfString.length == 2) {
        sQQVersion = String.format("%d%02d00", new Object[] { Integer.valueOf(Integer.parseInt(arrayOfString[0])), Integer.valueOf(Integer.parseInt(arrayOfString[1])) });
      }
    }
  }
  
  static class a
  {
    public String app;
    public String os = "android";
    public int result;
    public int scene;
    public int type;
    public String url;
    public String ver = adtn.access$000();
    
    public String toString()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("os", this.os);
        localJSONObject.put("app", this.app);
        localJSONObject.put("url", this.url);
        localJSONObject.put("result", this.result);
        localJSONObject.put("scene", this.scene);
        localJSONObject.put("type", this.type);
        localJSONObject.put("ver", this.ver);
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ArkApp.ArkSecurityReporter", 1, "ArkSafe.report exception=", localJSONException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtn
 * JD-Core Version:    0.7.0.1
 */