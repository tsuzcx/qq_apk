import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lcl
{
  private static int aNm;
  private static String aeu = "";
  private static String aev = "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/android.qq.readinjoy.viola_biz_810.js";
  public static String aew = "_viola_reinstall_delBiz_succ_810";
  public static String aex = "_viola_reinstall_delJSC_succ_810";
  private static Object lock = new Object();
  
  private static boolean BK()
  {
    SharedPreferences localSharedPreferences = awit.a(kxm.getAppRuntime(), true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "isReinstallDelSucc  failed");
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean(aex, false);
    QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "isReinstallDelSucc sp result=" + bool);
    return bool;
  }
  
  public static boolean a(lci.a parama)
  {
    if (BK()) {
      return true;
    }
    ThreadManager.post(new ReadInjoyWebRenderSoLoader.1(parama), 8, null, true);
    return false;
  }
  
  private static void aJQ()
  {
    Object localObject = awit.a(kxm.getAppRuntime(), true, true);
    if (localObject == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "delSoReinstall sp failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "delSoReinstall sp update to true");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(aex, true);
    awit.a((SharedPreferences.Editor)localObject, true);
  }
  
  private static void aJR()
  {
    Object localObject = awit.a(kxm.getAppRuntime(), true, true);
    if (localObject == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "delSoReinstall sp failed");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(aew, true);
    awit.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static boolean dJ(String paramString)
  {
    synchronized (lock)
    {
      jg();
      boolean bool = TextUtils.isEmpty(aeu);
      if (!bool) {}
      try
      {
        aNm = 1;
        aqhq.W(paramString, aeu, false);
        aNm = 0;
        QLog.i("viola.ReadInjoyWebRenderSoLoader", 1, "succeed to unzip so.");
        if (aNm == 0) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          aNm = 2;
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 1, paramString, new Object[0]);
        }
      }
    }
    return false;
  }
  
  private static boolean dK(String paramString)
  {
    QLog.i("viola.ReadInjoyWebRenderSoLoader", 1, "[delAllSo]" + paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        String str = jg();
        aqhq.deleteFile(str + paramString);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          try
          {
            if (new File(jg(), paramString).exists()) {
              break;
            }
            QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "reinstallDelSO  " + paramString + "succ");
            return true;
          }
          catch (Throwable paramString) {}
          localThrowable = localThrowable;
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 1, localThrowable, new Object[0]);
        }
      }
    }
    return false;
  }
  
  public static String jg()
  {
    if (TextUtils.isEmpty(aeu))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label65;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (TextUtils.isEmpty(aeu)) {
        aeu = ((File)localObject).getParent() + "/txlib/" + "readinjoy_viola/";
      }
    }
    for (;;)
    {
      return aeu;
      label65:
      QLog.w("viola.ReadInjoyWebRenderSoLoader", 2, "getSoLibPath but context is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcl
 * JD-Core Version:    0.7.0.1
 */