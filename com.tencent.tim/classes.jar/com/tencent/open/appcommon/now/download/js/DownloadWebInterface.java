package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import arux;
import arvb;
import arvc;
import arvf;
import arwt;
import arxp;
import aryr;
import aryv;
import aryy;
import arzx;
import arzx.a;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadWebInterface
  extends BaseInterface
  implements arxp
{
  public static final String PLUGIN_NAMESPACE = "q_download_now";
  protected final String TAG = DownloadWebInterface.class.getSimpleName();
  protected String jsCallBackMethod = "";
  protected arzx.a listener;
  protected Activity mActivity;
  protected Handler mHandler;
  protected final WebView webview;
  
  public DownloadWebInterface(Activity paramActivity, WebView paramWebView)
  {
    arwt.d(this.TAG, "init in");
    this.mActivity = paramActivity;
    this.webview = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
    if ((paramActivity instanceof PublicFragmentActivityForTool)) {
      paramWebView = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    for (;;)
    {
      aryy.a().setAppInterface(paramWebView);
      arvf.a().a(this);
      arwt.d(this.TAG, "init out");
      return;
      paramWebView = localObject;
      if ((paramActivity instanceof BaseActivity)) {
        paramWebView = (AppInterface)((BaseActivity)paramActivity).getAppRuntime();
      }
    }
  }
  
  public static boolean changeIntToBoolean(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      bool = false;
    }
    while (paramInt != 1) {
      return bool;
    }
    return true;
  }
  
  public void destroy()
  {
    arwt.d(this.TAG, "destroy");
    arvf.a().b(this);
    if (arzx.PN()) {
      arzx.a().b(this.listener);
    }
    arux.a().b(arvb.a());
  }
  
  public int doDownloadAction(String paramString)
  {
    arwt.d("TIME-STATISTIC", "DownloadWebInterface--doDownloadAction");
    if (!hasRight()) {
      return -1;
    }
    Bundle localBundle = new Bundle();
    try
    {
      localJSONObject = new JSONObject(paramString);
      localBundle.putString(aryv.PARAM_SNG_APPID, localJSONObject.optString("appid"));
      localBundle.putString(aryv.PARAM_URL, localJSONObject.optString("url"));
      localBundle.putString(aryv.PARAM_TASK_PACKNAME, localJSONObject.optString("packageName"));
      localBundle.putInt(aryv.PARAM_ACTIONCODE, localJSONObject.optInt("actionCode"));
      localBundle.putString(aryv.PARAM_VIA, localJSONObject.optString("via"));
      localBundle.putString(aryv.PARAM_APPNAME, localJSONObject.optString("appName"));
      localBundle.putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, changeIntToBoolean(localJSONObject.optInt("showNetworkDialog")));
      localBundle.putString(aryv.PARAM_ICON_URL, localJSONObject.optString("iconUrl"));
      localBundle.putInt(aryv.PARAM_SHOW_NOTIFICATION, localJSONObject.optInt("showNotification"));
      localBundle.putBoolean(aryv.PARAM_IS_AUTOINSTALL_BY_SDK, changeIntToBoolean(localJSONObject.optInt("isAutoInstallBySdk")));
      localBundle.putString(aryv.PARAM_EXTRA_INFO, localJSONObject.optString("extraData"));
      localBundle.putString(aryv.PARAM_DOWNLOADTSTYLE, localJSONObject.optString("downloadStyle"));
      localBundle.putString(aryv.PARAM_DOWNLOADSIZE, localJSONObject.optString("downloadSize"));
      localBundle.putString(aryv.PARAM_WORDING, localJSONObject.optString("wording"));
      if (localJSONObject.has("bolckNotify")) {
        localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, localJSONObject.optBoolean("bolckNotify"));
      }
      paramString = localJSONObject.optString(aryv.cDC);
      arwt.w(this.TAG, " feedChannel:" + paramString);
      if (TextUtils.isEmpty(paramString)) {
        break label886;
      }
      if (!paramString.startsWith("0;")) {
        break label775;
      }
    }
    catch (JSONException paramString)
    {
      JSONObject localJSONObject;
      int i;
      Object localObject;
      boolean bool;
      arwt.e(this.TAG, "JSONException", paramString);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        arwt.e(this.TAG, "Exception", paramString);
        continue;
        paramString = null;
        continue;
        paramString = "";
        continue;
        paramString = "";
      }
    }
    arwt.w(this.TAG, " finalFeedChannel:" + paramString);
    localBundle.putString(aryv.cDC, paramString);
    localJSONObject.optString("via");
    localJSONObject.optString("appid");
    i = localJSONObject.optInt("actionCode");
    localObject = null;
    paramString = (String)localObject;
    if (i == 12)
    {
      bool = changeIntToBoolean(localJSONObject.optInt("updateType"));
      localBundle.putBoolean(aryv.PARAM_PATCH_UPDATE, bool);
      bool = localJSONObject.has("updateData");
      paramString = (String)localObject;
      if (!bool) {}
    }
    for (;;)
    {
      try
      {
        localObject = localJSONObject.optString("updateData");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        paramString = new ApkUpdateDetail();
      }
      catch (Exception paramString)
      {
        String str;
        label775:
        paramString = null;
        continue;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        paramString.packageName = ((JSONObject)localObject).optString("packageName");
        paramString.newapksize = ((JSONObject)localObject).optInt("newapksize");
        paramString.patchsize = ((JSONObject)localObject).optInt("patchsize");
        paramString.updatemethod = ((JSONObject)localObject).optInt("updatemethod");
        paramString.versioncode = ((JSONObject)localObject).optInt("versioncode");
        paramString.versionname = ((JSONObject)localObject).optString("versionname");
        paramString.fileMd5 = ((JSONObject)localObject).optString("fileMd5");
        paramString.sigMd5 = ((JSONObject)localObject).optString("sigMd5");
        paramString.url = ((JSONObject)localObject).optString("url");
        i = localJSONObject.optInt("myAppConfig");
        localBundle.putString(aryv.PARAM_TASK_APPID, localJSONObject.optString("myAppId"));
        localBundle.putString(aryv.PARAM_TASK_APK_ID, localJSONObject.optString("apkId"));
        localBundle.putInt(aryv.PARAM_TASK_VERSION, localJSONObject.optInt("versionCode"));
        localBundle.putInt(aryv.PARAM_TO_PAGETYPE, localJSONObject.optInt("toPageType"));
        localBundle.putBoolean(aryv.PARAM_AUTO_DOWNLOAD, changeIntToBoolean(localJSONObject.optInt("isAutoDownload")));
        localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, changeIntToBoolean(localJSONObject.optInt("isAutoInstall")));
        str = localJSONObject.optString("sourceType");
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = DownloadInterface.getSourceInfoFromActivity(this.mActivity);
        }
        arwt.d(this.TAG, "doDownloadAction object " + localJSONObject.toString());
        arvc.a(this.mActivity, localBundle, (String)localObject, paramString, i);
        return 0;
      }
      catch (Exception localException)
      {
        continue;
      }
      paramString = paramString.split(";");
      if (paramString == null)
      {
        paramString = "";
        break;
      }
      if (paramString.length <= 0)
      {
        paramString = "";
        break;
      }
      localObject = paramString[0];
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        continue;
      }
      paramString = (String)localObject;
      if (!((String)localObject).equals("0")) {
        break;
      }
      continue;
      arwt.d(this.TAG, "enter doDownloadAction updateData json");
    }
  }
  
  public String getDownloadVersion()
  {
    return aryr.getVersionCode() + "";
  }
  
  public String getInterfaceName()
  {
    return "q_download_now";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jsCallBackMethod;
  }
  
  public WebView getWebview()
  {
    return this.webview;
  }
  
  protected void jsCallBack(String paramString)
  {
    this.mHandler.post(new DownloadWebInterface.1(this, paramString));
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    arwt.d(this.TAG, "enter registerDownloadCallBackListener");
    this.jsCallBackMethod = paramString;
    arux.a().a(arvb.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadWebInterface
 * JD-Core Version:    0.7.0.1
 */