import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkAppPreloader;
import com.tencent.ark.ArkAppPreloader.PreloadAppCallback;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.2;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class adqy
{
  private ArkAppPreloader.PreloadAppCallback a = new adra(this);
  private boolean bQw;
  private boolean bQx;
  private int cJs;
  private ConcurrentHashMap<String, adqy.a> eH = new ConcurrentHashMap(8);
  private WeakReference<QQAppInterface> gj;
  
  public adqy(QQAppInterface paramQQAppInterface)
  {
    this.gj = new WeakReference(paramQQAppInterface);
    this.bQw = false;
    ThreadManagerV2.executeOnSubThread(new ArkAppPreDownloadMgr.1(this));
  }
  
  private void a(adqy.a parama)
  {
    if (parama == null)
    {
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling preDownloadApp failed for item null");
      return;
    }
    ThreadManagerV2.executeOnSubThread(new ArkAppPreDownloadMgr.3(this, parama));
  }
  
  private void a(String paramString1, String paramString2, ArkAppPreloader.PreloadAppCallback paramPreloadAppCallback, int paramInt)
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    String str3 = ArkEnvironmentManager.getInstance().getAppResPath(paramString1);
    yg(str3);
    ArkAppPreloader.preloadApp(paramString1, paramString2, str2, str3, str1, paramPreloadAppCallback, paramInt);
  }
  
  private void cTT()
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    yg(str1);
    yg(str2);
    BaseApplicationImpl.sApplication.getApplicationContext();
    ArkAppPreloader.preloadCommon(adqr.getDensity(), str2, str1);
  }
  
  private static void yg(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public void a(aeix.e parame)
  {
    if ((parame != null) && (parame.a() != null)) {
      this.eH = parame.a().eH;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling updatePreloadConfig cfg is empty");
  }
  
  public void bX(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (!TextUtils.isEmpty(paramString))
        {
          bool = this.eH.containsKey(paramString);
          if (bool) {}
        }
        else
        {
          return;
        }
        String str;
        HashMap localHashMap;
        try
        {
          SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_app_first_use", 0);
          bool = localSharedPreferences.getBoolean(paramString, false);
          if (bool) {
            break label213;
          }
          str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
          localHashMap = new HashMap();
          localHashMap.put("app_name", paramString);
          if (!paramBoolean) {
            break label189;
          }
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(str, "ark_app_predownload_first_hit", true, 0L, 0L, localHashMap, "", false);
          QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling reportPredownloadFirstHit app=", paramString, ",hasUsed=", Boolean.valueOf(bool), ",hasPreDownload=", Boolean.valueOf(paramBoolean) });
          localSharedPreferences.edit().putBoolean(paramString, true).apply();
        }
        catch (Exception paramString)
        {
          QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling reportPredownloadFirstHit exception=", paramString);
        }
        continue;
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(str, "ark_app_predownload_first_hit", false, 0L, 0L, localHashMap, "", false);
      }
      finally {}
      label189:
      continue;
      label213:
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling reportPredownloadFirstHit not first use app=", paramString });
    }
  }
  
  public void cTR()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling startPredownload");
    }
    if ((this.eH.size() > 0) && (!this.bQw))
    {
      this.bQw = true;
      this.cJs = 0;
      Iterator localIterator = this.eH.entrySet().iterator();
      while (localIterator.hasNext())
      {
        adqy.a locala = (adqy.a)((Map.Entry)localIterator.next()).getValue();
        if (!TextUtils.isEmpty(locala.appname)) {
          if (TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(locala.appname, "", null, false))) {
            a(locala);
          } else {
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling ark app predowloaded,app=", locala.appname });
          }
        }
      }
    }
  }
  
  public void cTS()
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling startPreload");
    ArkAppCenter.i(new ArkAppPreDownloadMgr.2(this), 10000L);
  }
  
  public static class a
  {
    public String appname = "";
    public int cJt = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqy
 * JD-Core Version:    0.7.0.1
 */