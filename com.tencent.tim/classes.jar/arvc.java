import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi.1;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi.2;
import com.tencent.open.downloadnew.DownloadInfo;
import mqq.os.MqqHandler;

public class arvc
{
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    arwt.v("DownloadJSApi", "doDownloadActionBySDK pParmas =" + paramBundle);
    String str3 = paramBundle.getString(aryv.PARAM_SNG_APPID);
    String str4 = paramBundle.getString(aryv.PARAM_URL);
    String str5 = paramBundle.getString(aryv.PARAM_TASK_PACKNAME);
    int i = paramBundle.getInt(aryv.PARAM_ACTIONCODE);
    String str6 = paramBundle.getString(aryv.PARAM_VIA);
    String str7 = paramBundle.getString(aryv.PARAM_APPNAME);
    paramBundle.getString(aryv.PARAM_NOTIFYKEY);
    String str2 = paramBundle.getString(aryv.PARAM_ICON_URL);
    int j = paramBundle.getInt(aryv.PARAM_SHOW_NOTIFICATION);
    String str1 = paramBundle.getString(aryv.PARAM_EXTRA_INFO);
    boolean bool1 = paramBundle.getBoolean(aryv.PARAM_PATCH_UPDATE);
    boolean bool2 = paramBundle.getBoolean(aryv.PARAM_IS_APK, true);
    boolean bool3 = paramBundle.getBoolean(aryv.PARAM_AUTO_INSTALL, true);
    boolean bool4 = paramBundle.getBoolean(aryv.PARAM_BLOCK_NOTIFY);
    int k = paramBundle.getInt(aryv.cDD, 0);
    boolean bool5 = paramBundle.getBoolean(aryv.PARAM_IS_AUTOINSTALL_BY_SDK, false);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
      paramString.ekZ = i;
      if (bool2)
      {
        paramString.isAutoInstall = bool3;
        paramString.ddi = bool4;
      }
      for (;;)
      {
        paramString.from = k;
        paramString.iconUrl = str2;
        paramString.ell = j;
        paramString.extraData = str1;
        paramString.isAutoInstallBySDK = bool5;
        paramString.elk = 0;
        paramString.versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
        arwt.d("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        arux.a().b(paramString);
        break;
        paramString.isAutoInstall = false;
        paramString.ddi = true;
        paramString.updateType = 2;
      }
      paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
      paramString.ekZ = i;
      paramString.isAutoInstall = bool3;
      paramString.ddi = bool4;
      paramString.elk = 0;
      paramString.versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
      paramString.extraData = str1;
      if ((paramApkUpdateDetail != null) && (paramString.versionCode != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
        paramString.versionCode = paramApkUpdateDetail.versioncode;
      }
      bool2 = arxs.a(aroi.a().getContext(), null).ss("Common_QQ_Patch_Switch");
      if (!bool1) {
        arux.a().b(paramString);
      }
      for (;;)
      {
        arwt.d("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
        break;
        if (bool2) {
          arux.a().a(paramString, paramApkUpdateDetail);
        } else {
          arux.a().b(paramString);
        }
      }
      arux.a().pauseDownload(str3);
      continue;
      if (bool2)
      {
        arxt.X("305", str6, str3, str1);
        arux.a().iI(str3, str5);
        continue;
        arux.a().cancelDownload(str3);
        continue;
        paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
        paramString.ekZ = i;
        paramString.versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
        paramString.ddi = bool4;
        arux.a().a(paramString);
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadJSApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
  }
  
  private static void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadJSApi.2(paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvc
 * JD-Core Version:    0.7.0.1
 */