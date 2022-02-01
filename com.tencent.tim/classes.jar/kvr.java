import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils.1;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.biz.pubaccount.util.Achilles;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class kvr
{
  private static kvr.a jdField_a_of_type_Kvr$a = new kvr.a(null);
  private static kvr.b jdField_a_of_type_Kvr$b = new kvr.b(null);
  private static long sR;
  
  private static boolean AD()
  {
    String str = a(kxm.getAppRuntime(), "sp_key_local_apk_path");
    QLog.d("KBPreDownloadUtils", 2, "[isPkgExist] localApkPath=" + str);
    return (!TextUtils.isEmpty(str)) && (new File(str).exists());
  }
  
  private static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "getSharedPreferences: return null for runtime is null");
      return null;
    }
    paramAppRuntime = "readinjoy_sp_kb_predownload_" + paramAppRuntime.getAccount();
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0);
  }
  
  private static String a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[getString] sp is null");
      return null;
    }
    return paramAppRuntime.getString(paramString, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[setString] val for key: " + paramString1 + " is null.");
      return;
    }
    QLog.d("KBPreDownloadUtils", 2, "[setString] set: " + paramString1 + " to: " + String.valueOf(paramString2));
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[setString] sp is null");
      return;
    }
    paramAppRuntime.edit().putString(paramString1, paramString2).apply();
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    QLog.d("KBPreDownloadUtils", 2, "[setBoolean] set: " + paramString + " to: " + paramBoolean);
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[setBoolean] sp is null");
      return;
    }
    paramAppRuntime.edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  private static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("KBPreDownloadUtils", 1, "[getBoolean] sp is null");
      return false;
    }
    return paramAppRuntime.getBoolean(paramString, false);
  }
  
  private static void aH(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null)
    {
      a(kxm.getAppRuntime(), "sp_key_current_app_version_name", paramContext.versionName);
      QLog.d("KBPreDownloadUtils", 2, "[saveVersionInfo] versionName: " + paramContext.versionName);
      paramContext = arwv.encodeFileHexStr(paramString);
      if (paramContext == null) {
        break label123;
      }
    }
    label123:
    for (paramContext = paramContext.toLowerCase();; paramContext = null)
    {
      a(kxm.getAppRuntime(), "sp_key_local_apk_path", paramString);
      a(kxm.getAppRuntime(), "sp_key_current_app_md5", paramContext);
      QLog.d("KBPreDownloadUtils", 2, "[saveVersionInfo] md5: " + paramContext);
      return;
      QLog.e("KBPreDownloadUtils", 1, "[saveVersionInfo] package info is null");
      break;
    }
  }
  
  public static void aHv()
  {
    int i = new Random().nextInt(5000);
    QLog.i("KBPreDownloadUtils", 1, "[maybePDKB] delay= " + i + "ms");
    ThreadManager.getFileThreadHandler().postDelayed(new KBPDUtils.1(), i);
  }
  
  private static void aHw()
  {
    try
    {
      String str = a(kxm.getAppRuntime(), "sp_key_local_apk_path");
      if (str != null) {
        aqhq.deleteFile(str);
      }
      for (;;)
      {
        asac.a().Xv("101480433");
        return;
        QLog.i("KBPreDownloadUtils", 1, "[clearDownloadInfo] won't delete since apkPath is null");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("KBPreDownloadUtils", 1, "[clearDownloadInfo] ", localException);
    }
  }
  
  private static boolean am(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = a(kxm.getAppRuntime(), "sp_key_current_app_version_name");
    String str1 = a(kxm.getAppRuntime(), "sp_key_latest_app_version_name");
    String str2 = a(kxm.getAppRuntime(), "sp_key_current_app_md5");
    String str3 = a(kxm.getAppRuntime(), "sp_key_latest_app_md5");
    QLog.d("KBPreDownloadUtils", 2, "[isCurrentVersionLatest] currentAppVersion: " + paramContext + " latestAppVersion: " + str1 + " currentAppMd5: " + str2 + " latestAppMd5: " + str3);
    boolean bool1;
    if ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str1))) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (!AD())
        {
          QLog.i("KBPreDownloadUtils", 1, "[isCurrentVersionLatest] pkg not exists");
          return false;
        }
        if ((str3 == null) || (str2 == null)) {
          break;
        }
        bool1 = bool2;
      } while (!TextUtils.equals(str3.toLowerCase(), str2.toLowerCase()));
      if ((TextUtils.isEmpty(paramContext)) || (TextUtils.isEmpty(str1))) {
        break;
      }
      bool1 = bool2;
    } while (Achilles.compareVersion(paramContext, str1) < 0);
    return true;
  }
  
  public static String b(AppRuntime paramAppRuntime)
  {
    Object localObject = iK();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("app_id", "101480433");
      ((JSONObject)localObject).put("download_url", a(paramAppRuntime, "sp_key_kb_download_url"));
      if (AD())
      {
        i = 1;
        ((JSONObject)localObject).put("download_finished", i);
        if (!a(paramAppRuntime, "sp_key_enable_pre_download")) {
          break label96;
        }
      }
      label96:
      for (int i = 1;; i = 0)
      {
        ((JSONObject)localObject).put("enable_predownload", i);
        paramAppRuntime = ((JSONObject)localObject).toString();
        return paramAppRuntime;
        i = 0;
        break;
      }
      return "";
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("KBPreDownloadUtils", 1, "[queryKBDownloadInfo] ", paramAppRuntime);
    }
  }
  
  private static void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str = kxm.getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    anpc.a(kxm.getAppRuntime().getApplication()).collectPerformance(str, "actKBPreDownload", paramBoolean, paramLong, 0L, localHashMap, null, false);
  }
  
  private static void bx(String paramString1, String paramString2)
  {
    QLog.d("KBPreDownloadUtils", 2, "[persistDownloadInfo] url=" + paramString1 + " savedPath=" + paramString2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = "101480433";
    localDownloadInfo.ekZ = 2;
    localDownloadInfo.urlStr = paramString1;
    localDownloadInfo.filePath = paramString2;
    localDownloadInfo.packageName = "com.tencent.reading";
    localDownloadInfo.via = "ANDROIDQQ.QNREADING";
    localDownloadInfo.isAutoInstall = false;
    localDownloadInfo.ell = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
    localDownloadInfo.isAutoInstallBySDK = false;
    localDownloadInfo.source = "biz_src_feeds_kandian";
    asac.a().j(localDownloadInfo);
  }
  
  private static String iK()
  {
    label248:
    for (;;)
    {
      try
      {
        awit.eDN();
        Object localObject2 = Achilles.t();
        if ((localObject2 == null) || (((Set)localObject2).isEmpty()))
        {
          QLog.e("KBPreDownloadUtils", 1, "[queryKBPreDownloadInfoAladdin] empty param set.");
          return "";
        }
        Object localObject1 = null;
        Iterator localIterator = ((Set)localObject2).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (AchillesParams)localIterator.next();
          if (TextUtils.equals(((AchillesParams)localObject2).getPackageName(), "com.tencent.reading"))
          {
            localObject1 = localObject2;
            break label248;
          }
        }
        else
        {
          if (localObject1 == null)
          {
            QLog.e("KBPreDownloadUtils", 1, "[queryKBPreDownloadInfoAladdin] param not found for com.tencent.reading");
            return "";
          }
          localObject2 = asac.a().f("com.tencent.reading");
          boolean bool;
          if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).filePath)))
          {
            bool = new File(((DownloadInfo)localObject2).filePath).exists();
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("app_id", "101480433");
            ((JSONObject)localObject2).put("download_url", localObject1.getDownloadUrl());
            if (bool)
            {
              i = 1;
              ((JSONObject)localObject2).put("download_finished", i);
              if (!localObject1.isEnable()) {
                continue;
              }
              i = 1;
              ((JSONObject)localObject2).put("enable_predownload", i);
              return ((JSONObject)localObject2).toString();
            }
          }
          else
          {
            QLog.e("KBPreDownloadUtils", 1, "[queryKBPreDownloadInfoAladdin] download info not found");
            bool = false;
            continue;
          }
          int i = 0;
          continue;
          i = 0;
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("KBPreDownloadUtils", 1, "[queryKBDownloadInfo] ", localException);
        return "";
      }
    }
  }
  
  public static class a
    implements lab
  {
    public void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
    {
      QLog.d("KBPreDownloadUtils", 2, "[onDownloadStateChanged] url=" + paramString1 + " savedPath=" + paramString2 + " errorCode=" + paramInt2 + " errorMsg=" + paramString3);
      if (!TextUtils.equals(paramString1, kvr.b(kxm.getAppRuntime(), "sp_key_kb_download_url"))) {
        return;
      }
      switch (paramInt1)
      {
      default: 
        return;
      case 4: 
        long l = System.currentTimeMillis() - kvr.cn();
        QLog.d("KBPreDownloadUtils", 2, "[onDownloadFinish] cost=" + l + "ms, info=" + paramString1);
        paramString3 = BaseApplicationImpl.getApplication();
        if (paramString3 != null)
        {
          kvr.aI(paramString3, paramString2);
          kvr.c(true, l, 0);
          kvr.by(paramString1, paramString2);
          lad.a().d(kvr.a());
          return;
        }
        QLog.e("KBPreDownloadUtils", 1, "[onDownloadStateChanged] return since context is null");
        return;
      }
      QLog.e("KBPreDownloadUtils", 1, "[onDownloadError] errorCode=" + paramInt2 + ", errorMsg=" + paramString3);
      kvr.c(false, System.currentTimeMillis() - kvr.cn(), paramInt2);
      lad.a().d(kvr.a());
    }
  }
  
  public static class b
    implements INetInfoHandler
  {
    public void onNetMobile2None() {}
    
    public void onNetMobile2Wifi(String paramString)
    {
      QLog.d("KBPreDownloadUtils", 2, "[onNetMobile2Wifi] ");
      AppNetConnInfo.unregisterNetInfoHandler(kvr.a());
      kvr.aHv();
    }
    
    public void onNetNone2Mobile(String paramString) {}
    
    public void onNetNone2Wifi(String paramString)
    {
      QLog.d("KBPreDownloadUtils", 2, "[onNetNone2Wifi] ");
      AppNetConnInfo.unregisterNetInfoHandler(kvr.a());
      kvr.aHv();
    }
    
    public void onNetWifi2Mobile(String paramString)
    {
      QLog.i("KBPreDownloadUtils", 1, "[onNetWifi2Mobile] pause download");
      aryy.a().fw("101480433");
    }
    
    public void onNetWifi2None()
    {
      QLog.i("KBPreDownloadUtils", 1, "[onNetWifi2None] pause download");
      aryy.a().fw("101480433");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvr
 * JD-Core Version:    0.7.0.1
 */