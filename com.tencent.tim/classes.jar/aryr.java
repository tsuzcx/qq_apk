import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadApi.1;
import com.tencent.open.downloadnew.DownloadApi.10;
import com.tencent.open.downloadnew.DownloadApi.11;
import com.tencent.open.downloadnew.DownloadApi.12;
import com.tencent.open.downloadnew.DownloadApi.2;
import com.tencent.open.downloadnew.DownloadApi.3;
import com.tencent.open.downloadnew.DownloadApi.4;
import com.tencent.open.downloadnew.DownloadApi.5;
import com.tencent.open.downloadnew.DownloadApi.6;
import com.tencent.open.downloadnew.DownloadApi.7;
import com.tencent.open.downloadnew.DownloadApi.8;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aryr
{
  public static final String TAG = aryr.class.getName();
  protected static ITMAssistantExchangeURLListenner c = new aryu();
  protected static ConcurrentHashMap<String, Integer> cR;
  public static Object mLock = new Object();
  
  static
  {
    cR = new ConcurrentHashMap();
  }
  
  public static boolean G(Bundle paramBundle)
  {
    if (paramBundle.getInt(aryv.PARAM_ACTIONCODE) == 5)
    {
      String str2 = paramBundle.getString(aryv.PARAM_SNG_APPID);
      String str3 = paramBundle.getString(aryv.PARAM_URL);
      String str4 = paramBundle.getString(aryv.PARAM_TASK_PACKNAME);
      String str1 = paramBundle.getString(aryv.PARAM_VIA);
      String str5 = paramBundle.getString(aryv.PARAM_APPNAME);
      arxt.X("305", str1, str2, paramBundle.getString(aryv.PARAM_EXTRA_INFO));
      DownloadInfo localDownloadInfo = aryy.a().c(str2);
      if (localDownloadInfo == null)
      {
        localDownloadInfo = new DownloadInfo();
        localDownloadInfo.appId = str2;
        localDownloadInfo.urlStr = str3.trim();
        localDownloadInfo.packageName = str4;
        localDownloadInfo.pushTitle = str5;
        localDownloadInfo.via = str1;
        localDownloadInfo.cDG = paramBundle.getString(aryv.PARAM_TASK_APPID);
        localDownloadInfo.cCL = paramBundle.getString(aryv.PARAM_TASK_APK_ID);
        localDownloadInfo.versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
        localDownloadInfo.extraData = paramBundle.getString(aryv.PARAM_EXTRA_INFO);
        paramBundle = localDownloadInfo;
      }
      for (;;)
      {
        aryy.a().y(paramBundle);
        return true;
        paramBundle = localDownloadInfo;
        if (!TextUtils.isEmpty(str1))
        {
          localDownloadInfo.via = str1;
          paramBundle = localDownloadInfo;
        }
      }
    }
    return false;
  }
  
  public static void Z(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.7(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static void a(String paramString, arzf paramarzf)
  {
    if (paramString == null)
    {
      arwt.v(TAG, "getQueryDownloadActionByVia via == null");
      return;
    }
    if (paramarzf == null) {
      arwt.v(TAG, "getQueryDownloadActionByVia listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.6(paramString, paramarzf));
  }
  
  public static boolean a(aryp paramaryp)
  {
    arvv.a().a(paramaryp);
    return aryy.a().a(paramaryp);
  }
  
  public static void aa(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.8(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static int b(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      arxt.X("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(aryv.PARAM_EXTRA_INFO));
    }
    arwt.v(TAG, "doDownloadActionBySDK pParmas =" + paramBundle);
    String str4 = paramBundle.getString(aryv.PARAM_SNG_APPID);
    String str5 = paramBundle.getString(aryv.PARAM_URL);
    String str6 = paramBundle.getString(aryv.PARAM_TASK_PACKNAME);
    int i = paramBundle.getInt(aryv.PARAM_ACTIONCODE);
    String str7 = paramBundle.getString(aryv.PARAM_VIA);
    String str8 = paramBundle.getString(aryv.PARAM_APPNAME);
    paramBundle.getString(aryv.PARAM_NOTIFYKEY);
    String str3 = paramBundle.getString(aryv.PARAM_ICON_URL);
    int j = paramBundle.getInt(aryv.PARAM_SHOW_NOTIFICATION);
    String str2 = paramBundle.getString(aryv.PARAM_EXTRA_INFO);
    boolean bool1 = paramBundle.getBoolean(aryv.PARAM_PATCH_UPDATE);
    boolean bool2 = paramBundle.getBoolean(aryv.PARAM_IS_APK, true);
    boolean bool3 = paramBundle.getBoolean(aryv.PARAM_AUTO_INSTALL, true);
    boolean bool4 = paramBundle.getBoolean(aryv.PARAM_BLOCK_NOTIFY);
    int k = paramBundle.getInt(aryv.cDD, 0);
    boolean bool5 = paramBundle.getBoolean(aryv.PARAM_IS_AUTOINSTALL_BY_SDK, false);
    String str1 = paramBundle.getString("big_brother_ref_source_key", "");
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      paramString = new DownloadInfo(str4, str5.trim(), str6, str8, str7, null, paramString, bool2);
      paramString.ekZ = i;
      if (bool2)
      {
        paramString.isAutoInstall = bool3;
        paramString.ddi = bool4;
        label317:
        paramString.from = k;
        paramString.iconUrl = str3;
        paramString.ell = j;
        paramString.extraData = str2;
        paramString.isAutoInstallBySDK = bool5;
        paramString.elk = 0;
      }
      try
      {
        paramString.versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
        paramString.fileSize = paramBundle.getLong(aryv.PARAM_DOWNLOADSIZE);
        label374:
        arwt.d(TAG, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        paramString.ce("big_brother_ref_source_key", str1);
        aryy.a().b(paramString);
        continue;
        paramString.isAutoInstall = false;
        paramString.ddi = true;
        paramString.updateType = 2;
        break label317;
        paramString = new DownloadInfo(str4, str5.trim(), str6, str8, str7, null, paramString, bool2);
        paramString.ekZ = i;
        paramString.isAutoInstall = bool3;
        paramString.ddi = bool4;
        paramString.elk = 0;
        paramString.versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
        paramString.extraData = str2;
        if ((paramApkUpdateDetail != null) && (paramString.versionCode != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
          paramString.versionCode = paramApkUpdateDetail.versioncode;
        }
        paramString.ce("big_brother_ref_source_key", str1);
        bool2 = arxs.a(aroi.a().getContext(), null).ss("Common_QQ_Patch_Switch");
        if (!bool1) {
          aryy.a().b(paramString);
        }
        for (;;)
        {
          arwt.d(TAG, "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
          break;
          if (bool2) {
            aryy.a().a(paramString, paramApkUpdateDetail);
          } else {
            aryy.a().b(paramString);
          }
        }
        return aryy.a().fw(str4);
        if (!bool2) {
          continue;
        }
        arxt.X("305", str7, str4, str2);
        paramApkUpdateDetail = aryy.a().c(str4);
        paramString = paramApkUpdateDetail;
        if (paramApkUpdateDetail == null)
        {
          paramString = new DownloadInfo();
          paramString.appId = str4;
          paramString.urlStr = str5.trim();
          paramString.packageName = str6;
          paramString.pushTitle = str8;
          paramString.via = str7;
          paramString.cDG = paramBundle.getString(aryv.PARAM_TASK_APPID);
          paramString.cCL = paramBundle.getString(aryv.PARAM_TASK_APK_ID);
          paramString.versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
          paramString.ddw = paramBundle.getBoolean(aryv.PARAM_IS_APK, true);
          paramString.from = k;
          paramString.iconUrl = str3;
          paramString.elk = 0;
          paramString.extraData = str2;
        }
        paramString.ce("big_brother_ref_source_key", str1);
        aryy.a().y(paramString);
        continue;
        aryy.a().i(str4, null, true);
      }
      catch (NumberFormatException paramBundle)
      {
        break label374;
      }
    }
  }
  
  public static void b(List<DownloadInfo> paramList, arzf paramarzf)
  {
    if (paramList == null)
    {
      arwt.v(TAG, "getQueryDownloadAction infos == null");
      return;
    }
    if (paramarzf == null) {
      arwt.v(TAG, "getQueryDownloadAction listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.5(paramList, paramarzf));
  }
  
  public static boolean b(aryp paramaryp)
  {
    arvv.a().b(paramaryp);
    return aryy.a().b(paramaryp);
  }
  
  public static void c(aryx paramaryx)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.11(paramaryx));
  }
  
  public static void cancelNotification(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.10(paramString));
  }
  
  public static void d(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(aroi.a().getContext()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if (paramString == "biz_src_jc_update") {
      arxt.X("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(aryv.PARAM_EXTRA_INFO));
    }
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < localObject.length)
    {
      localStringBuilder.append(localObject[i].toString());
      i += 1;
    }
    localObject = paramBundle.getString(aryv.PARAM_SNG_APPID);
    String str = paramBundle.getString(aryv.PARAM_URL);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      arvu.jk.put(localObject, localStringBuilder.toString());
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
      return;
      if (!TextUtils.isEmpty(str)) {
        arvu.jk.put(str, localStringBuilder.toString());
      }
    }
  }
  
  public static void d(aryx paramaryx)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.12(paramaryx));
  }
  
  public static void dJ(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.3(paramBundle));
  }
  
  public static void dK(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.4(paramBundle));
  }
  
  public static void e(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    arwt.v(TAG, "doDownloadActionByMyApp pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      arxt.X("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(aryv.PARAM_EXTRA_INFO));
    }
    Object localObject1;
    if (paramBundle.getInt(aryv.PARAM_TASK_VERSION, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(c, aroi.a().getContext());
      localObject1 = paramBundle.getString(aryv.PARAM_TASK_PACKNAME);
      Object localObject3 = paramBundle.getString(aryv.cDC);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localStringBuilder.append(";");
          localStringBuilder.append((String)localObject3);
        }
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localStringBuilder.toString());
        ((TMAssistantGetAppDetailTool)???).exchangeUrlsFromPackageNames((ArrayList)localObject3);
      }
    }
    label288:
    do
    {
      synchronized (mLock)
      {
        try
        {
          mLock.wait(5000L);
          if (cR == null) {
            break label288;
          }
          localObject1 = (Integer)cR.remove(localObject1);
          if (localObject1 == null)
          {
            aryy.a().showToast(aroi.a().getContext().getString(2131696634));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      paramBundle.putInt(aryv.PARAM_TASK_VERSION, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(aryv.PARAM_PATCH_SIZE, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(aryv.cDA, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        arzk.a().a(paramActivity, paramBundle, new arys(paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    arzk.a().b(paramActivity, paramBundle, new aryt(paramBundle, paramString, paramApkUpdateDetail));
  }
  
  public static int getVersionCode()
  {
    return 3;
  }
  
  public static boolean sA(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
  
  public static boolean sz(String paramString)
  {
    paramString = aryy.a().c(paramString);
    return (paramString != null) && (paramString.downloadType == 1);
  }
  
  public static void t(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramActivity == null)) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.2(paramActivity, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryr
 * JD-Core Version:    0.7.0.1
 */