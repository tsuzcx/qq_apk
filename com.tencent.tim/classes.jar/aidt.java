import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.huayang.MonitorConfig.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class aidt
{
  public static Map<String, aidt> ls = new HashMap();
  public int dda;
  public int ddb;
  public int ddc;
  public int ddd;
  public int dde;
  public int ddf;
  public int ddg;
  public int ddh;
  
  public static void B(Context paramContext, String paramString1, String paramString2)
  {
    if ((ls.get(paramString1) != null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramContext.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit().putString("pre_monitor" + paramString1, paramString2).commit();
    gp(paramString1, paramString2);
  }
  
  public static void bC(Context paramContext, String paramString)
  {
    if (ls.get(paramString) != null) {}
    do
    {
      return;
      paramContext = paramContext.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).getString("pre_monitor" + paramString, null);
    } while (paramContext == null);
    gp(paramString, paramContext);
  }
  
  public static void bD(Context paramContext, String paramString)
  {
    if (ls.get(paramString) != null)
    {
      aids.report(String.valueOf(((aidt)ls.get(paramString)).dda));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MonitorConfig", 2, "没有找到匹配的monitor离线配置文件，重新拉取一次");
    }
    aids.report("3235982");
    new Handler(Looper.getMainLooper()).postDelayed(new MonitorConfig.1(paramContext, paramString), 1500L);
  }
  
  private static void gp(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      aidt localaidt = new aidt();
      localaidt.dda = paramString2.optInt("startupId");
      localaidt.ddb = paramString2.optInt("downloadSucId");
      localaidt.ddc = paramString2.optInt("downloadFailId");
      localaidt.ddd = paramString2.optInt("loadSucId");
      localaidt.dde = paramString2.optInt("loadFailId");
      localaidt.ddf = paramString2.optInt("startSucId");
      localaidt.ddg = paramString2.optInt("firstUserId");
      localaidt.ddh = paramString2.optInt("exitId");
      ls.put(paramString1, localaidt);
      if (QLog.isColorLevel()) {
        QLog.d("MonitorConfig", 2, paramString1 + localaidt);
      }
      return;
    }
    catch (Throwable paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MonitorConfig", 2, "pareMonitorConfig exception :" + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidt
 * JD-Core Version:    0.7.0.1
 */