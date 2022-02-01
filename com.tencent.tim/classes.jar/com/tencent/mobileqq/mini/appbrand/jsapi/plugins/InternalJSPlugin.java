package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import arue;
import aryr;
import aryv;
import aryx;
import avpq;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalJSPlugin
  extends BaseJsPlugin
{
  public static final String PRIVATE_API_GET_QUA = "getQua";
  public static final String PRIVATE_API_GET_STORE_APP_LIST = "getStoreAppList";
  public static final String PRIVATE_API_NOTIFY_NATIVE = "notifyNative";
  public static final String PRIVATE_API_WNS_CGI_REQUEST = "wnsRequest";
  private static final Set<String> S_EVENT_MAP = new InternalJSPlugin.1();
  public static final String TAG = "InternalJSPlugin";
  public Set<String> eventMap;
  private aryx mDownloadListener = new InternalJSPlugin.8(this);
  private String mDownloadNativeAppId;
  private String mDownloadPackageName;
  private String mDownloadUrl;
  
  private void confirmOpenAppDetailPage(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, JsRuntime paramJsRuntime, int paramInt)
  {
    paramActivity.runOnUiThread(new InternalJSPlugin.7(this, paramActivity, paramString3, paramString4, paramString1, paramString2, paramJsRuntime, paramString5, paramInt));
  }
  
  private void downloadByDownloadApi(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mDownloadUrl = paramString4;
    this.mDownloadNativeAppId = paramString1;
    this.mDownloadPackageName = paramString2;
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_SNG_APPID, paramString1);
    localBundle.putString(aryv.PARAM_URL, paramString4);
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, paramString2);
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 2);
    localBundle.putString(aryv.PARAM_VIA, "MiniApp");
    localBundle.putString(aryv.PARAM_APPNAME, paramString3);
    localBundle.putInt(aryv.PARAM_SHOW_NOTIFICATION, 1);
    aryr.c(this.mDownloadListener);
    aryr.d(paramActivity, localBundle, "biz_src_miniapp", null, 0);
    QQToast.a(paramActivity, "开始下载", 1).show();
    InnerAppReportDc4239.innerAppReport(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, null, "launchapp", "downloadapp", "qqdownload");
  }
  
  private void onOpenThridApp(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, JsRuntime paramJsRuntime, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("InternalJSPlugin", 2, "onOpenThridApp - appid : " + paramString1 + "; packageName : " + paramString2 + "; appName : " + paramString3);
      }
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString6, null, "invalid parameter", paramInt2);
      return;
    }
    PackageManager localPackageManager = paramActivity.getPackageManager();
    try
    {
      if (localPackageManager.getPackageInfo(paramString2, 1) != null)
      {
        paramActivity.runOnUiThread(new InternalJSPlugin.4(this, paramActivity, paramString3, paramString5, localPackageManager, paramString2, paramJsRuntime, paramString6, paramInt2));
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramString5)
    {
      if (paramInt1 == 1) {
        break label224;
      }
      confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, paramString4, paramString6, paramJsRuntime, paramInt2);
      return;
      if (paramInt1 != 1)
      {
        confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, paramString4, paramString6, paramJsRuntime, paramInt2);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.e("InternalJSPlugin", 2, "open app err", paramActivity);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("InternalJSPlugin", 2, "only open");
    }
    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString6, null, "app not installed", paramInt2);
    return;
    label224:
    if (QLog.isColorLevel()) {
      QLog.d("InternalJSPlugin", 2, "only open");
    }
    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString6, null, "app not installed", paramInt2);
  }
  
  private void openAppDetailPage(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("packageName", paramString2);
    localBundle.putString("appId", paramString1);
    localBundle.putString("big_brother_source_key", "biz_src_miniapp");
    if ((paramContext instanceof BasePluginActivity))
    {
      arue.s(((BasePluginActivity)paramContext).getOutActivity(), localBundle);
      InnerAppReportDc4239.innerAppReport(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, null, "launchapp", "downloadapp", "yybdownload");
      return;
    }
    if ((paramContext instanceof Activity))
    {
      arue.s((Activity)paramContext, localBundle);
      InnerAppReportDc4239.innerAppReport(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, null, "launchapp", "downloadapp", "yybdownload");
      return;
    }
    QLog.e("InternalJSPlugin", 2, "onOpenThridApp mContext 必现是一个Activity");
  }
  
  public static void openUrl(JSONObject paramJSONObject, BaseJsPluginEngine paramBaseJsPluginEngine, openUrlCallback paramopenUrlCallback)
  {
    if (paramBaseJsPluginEngine != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if ((paramBaseJsPluginEngine.getActivityContext() == null) || (paramBaseJsPluginEngine.getActivityContext().isFinishing()) || (paramJSONObject == null))
        {
          if (paramopenUrlCallback != null) {
            paramopenUrlCallback.openResult(false, "activity or json error.");
          }
          QLog.e("InternalJSPlugin", 2, "openurl error, return.");
          return;
        }
        try
        {
          localObject = paramJSONObject.optString("url");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"null".equals(localObject))) {
            break label153;
          }
          if (paramopenUrlCallback == null) {
            continue;
          }
          paramopenUrlCallback.openResult(false, "url is null.");
        }
        catch (Exception paramJSONObject)
        {
          QLog.e("InternalJSPlugin", 1, "openUrl error; " + Log.getStackTraceString(paramJSONObject));
        }
        if (paramopenUrlCallback == null) {
          continue;
        }
        paramopenUrlCallback.openResult(false, "openUrl error");
        continue;
        if (!paramJSONObject.has("target")) {
          break label349;
        }
      }
      finally {}
      label153:
      int i = paramJSONObject.optInt("target");
      if ((i < 0) || (i > 1))
      {
        if (paramopenUrlCallback != null) {
          paramopenUrlCallback.openResult(false, "target error");
        }
      }
      else
      {
        if (i == 1)
        {
          localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_miniapp");
          if (((Intent)localObject).resolveActivity(paramBaseJsPluginEngine.getActivityContext().getPackageManager()) != null)
          {
            QLog.d("InternalJSPlugin", 2, "openUrl by system webview.");
            paramBaseJsPluginEngine.getActivityContext().startActivity((Intent)localObject);
          }
        }
        label263:
        label296:
        label347:
        label349:
        Bundle localBundle;
        switch (paramJSONObject.optInt("animation"))
        {
        case 0: 
        case 1: 
        case 2: 
          for (;;)
          {
            if (paramopenUrlCallback == null) {
              break label347;
            }
            paramopenUrlCallback.openResult(true, null);
            break;
            QLog.d("InternalJSPlugin", 2, "openUrl by system webview error.");
            break label263;
            paramBaseJsPluginEngine.getActivityContext().overridePendingTransition(0, 0);
            continue;
            paramBaseJsPluginEngine.getActivityContext().overridePendingTransition(2130772367, 0);
          }
          continue;
          localBundle = new Bundle();
          if (paramJSONObject.has("style"))
          {
            i = paramJSONObject.optInt("style");
            if ((i >= 0) && (i <= 2)) {
              break label803;
            }
            QLog.e("InternalJSPlugin", 2, "style error, return.");
            if (paramopenUrlCallback == null) {
              continue;
            }
            paramopenUrlCallback.openResult(false, "style error");
            continue;
            switch (paramJSONObject.optInt("navigationBarStyle"))
            {
            }
          }
        default: 
          for (;;)
          {
            label411:
            localBundle.putBoolean("hide_title_left_arrow", paramJSONObject.optBoolean("hideLeftArrow", false));
            Intent localIntent = new Intent(paramBaseJsPluginEngine.getActivityContext(), QQBrowserActivity.class);
            localIntent.putExtra("articalChannelId", 0);
            if ((paramBaseJsPluginEngine == null) || (paramBaseJsPluginEngine.appBrandRuntime == null) || (paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo() == null) || (paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig == null) || (!paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.isInternalApp())) {
              localIntent.setFlags(402653184);
            }
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            localIntent.putExtras(localBundle);
            localIntent.putExtra("url", (String)localObject);
            i = paramJSONObject.optInt("animation");
            if ((i < 0) || (i > 2))
            {
              QLog.e("InternalJSPlugin", 2, "animation error, return.");
              if (paramopenUrlCallback == null) {
                break;
              }
              paramopenUrlCallback.openResult(false, "animation error");
              break;
              localBundle.putBoolean("hide_more_button", false);
              localBundle.putBoolean("hide_operation_bar", true);
              break label411;
              localBundle.putBoolean("hide_more_button", true);
              localBundle.putBoolean("hide_operation_bar", true);
              break label411;
              localBundle.putBoolean("hide_more_button", false);
              localBundle.putBoolean("hide_operation_bar", false);
              localBundle.putString("webStyle", "");
              break label411;
              localBundle.putBoolean("hide_more_button", true);
              localBundle.putBoolean("hide_operation_bar", false);
              localBundle.putString("webStyle", "");
              break label411;
              localBundle.putBoolean("hide_left_button", true);
              localBundle.putBoolean("show_right_close_button", true);
              break label411;
              localBundle.putBoolean("isTransparentTitleAndClickable", true);
              continue;
            }
            paramBaseJsPluginEngine.getActivityContext().startActivity(localIntent);
            if (paramopenUrlCallback == null) {
              break label846;
            }
            paramopenUrlCallback.openResult(true, null);
            break label846;
            paramBaseJsPluginEngine.getActivityContext().overridePendingTransition(0, 0);
            break;
            paramBaseJsPluginEngine.getActivityContext().overridePendingTransition(2130772367, 0);
            break;
            break label296;
            label803:
            switch (i)
            {
            }
            break label411;
          }
          label846:
          switch (i)
          {
          }
          break;
        }
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("InternalJSPlugin", 2, "handleNativeRequest eventName=" + paramString1 + ",jsonParams=" + paramString2);
    Object localObject1;
    if ("openUrl".equals(paramString1))
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        localObject1 = paramString2.optString("url");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("null".equals(localObject1)))
        {
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "url error", paramInt);
          return "";
        }
        openUrl(paramString2, this.jsPluginEngine, new InternalJSPlugin.2(this, paramJsRuntime, paramString1, paramInt));
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          QLog.e("InternalJSPlugin", 1, paramString1 + " error,", paramString2);
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
        }
      }
      return "";
    }
    if ("launchApplication".equals(paramString1)) {
      QLog.e("InternalJSPlugin", 2, "openapp");
    }
    for (;;)
    {
      int j;
      try
      {
        Object localObject2 = new JSONObject(paramString2).optJSONObject("extInfo");
        paramString2 = ((JSONObject)localObject2).optString("appConnectId");
        localObject1 = ((JSONObject)localObject2).optString("appPackagename");
        localObject2 = ((JSONObject)localObject2).optString("appParameter", "");
        int k = -1;
        int m = -1;
        j = k;
        i = m;
        if (this.jsPluginEngine != null)
        {
          j = k;
          i = m;
          if (this.jsPluginEngine.appBrandRuntime != null)
          {
            j = k;
            i = m;
            if (this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null)
            {
              j = k;
              i = m;
              if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null)
              {
                j = k;
                i = m;
                if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam != null)
                {
                  j = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.scene;
                  if (!this.jsPluginEngine.appBrandRuntime.canLaunchApp()) {
                    break label808;
                  }
                  i = this.jsPluginEngine.appBrandRuntime.getLaunchAppScene();
                }
              }
            }
          }
        }
        QLog.d("InternalJSPlugin", 2, "API_LAUNCH_APP  realscene : " + j + "   scene:" + i);
        if ((this.jsPluginEngine == null) || (this.jsPluginEngine.appBrandRuntime == null) || (this.jsPluginEngine.appBrandRuntime.getApkgInfo() == null)) {
          continue;
        }
        MiniAppCmdUtil.getInstance().getNativeAppInfoForJump(null, this.jsPluginEngine.appBrandRuntime.getApkgInfo().appId, paramString2, (String)localObject1, i, new InternalJSPlugin.3(this, (String)localObject2, paramString1, paramJsRuntime, paramInt, paramString2, (String)localObject1));
      }
      catch (Exception paramString2)
      {
        QLog.e("InternalJSPlugin", 1, paramString1 + " error,", paramString2);
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
        continue;
      }
      return "";
      QLog.e("InternalJSPlugin", 1, "launchApplication error, appBrandRuntime or getApkgInfo is null.");
      continue;
      if ("getQua".equals(paramString1))
      {
        if (this.jsPluginEngine == null) {
          return "";
        }
        localObject1 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          ((JSONObject)localObject1).put("qua", avpq.getQUA3());
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, (JSONObject)localObject1, paramInt);
          return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("InternalJSPlugin", 1, localJSONException, new Object[0]);
          localJSONException.printStackTrace();
          continue;
        }
        if ("notifyNative".equals(paramString1))
        {
          if (this.jsPluginEngine == null) {
            return "";
          }
          try
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("data", paramString2);
            QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "update_entry_list", (Bundle)localObject1, null);
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("InternalJSPlugin", 1, localException, new Object[0]);
              localException.printStackTrace();
            }
          }
        }
        else if ("wnsRequest".equals(paramString1))
        {
          if (this.jsPluginEngine == null) {
            return "";
          }
          MiniAppUtils.performWnsCgiRequest(paramString2, paramJsRuntime, paramString1, paramInt, this.jsPluginEngine);
        }
        else if ("getStoreAppList".equals(paramString1))
        {
          if (this.jsPluginEngine == null) {
            return "";
          }
          MiniAppUtils.getMiniAppStoreAppList(paramString2, paramJsRuntime, paramString1, paramInt, this.jsPluginEngine);
        }
      }
      label808:
      int i = j;
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
  
  public static abstract interface openUrlCallback
  {
    public abstract void openResult(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin
 * JD-Core Version:    0.7.0.1
 */