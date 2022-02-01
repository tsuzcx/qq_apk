package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.R.anim;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class InternalJSPlugin
  extends BaseJsPlugin
{
  private static final String CONFIG_SPLIT = ",";
  private static final String TAG = "InternalJSPlugin";
  private ArrayList<String> openUrlDomainWhiteList;
  private String privateOpenUrlDomainWhiteList;
  
  private void confirmOpenAppDetailPage(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, RequestEvent paramRequestEvent)
  {
    paramActivity.runOnUiThread(new InternalJSPlugin.9(this, paramActivity, paramString3, paramString4, paramString1, paramString2, paramRequestEvent));
  }
  
  private void getOpenUrlDomainWhiteList()
  {
    if (this.openUrlDomainWhiteList == null)
    {
      String str1 = WnsConfig.getConfig("qqminiapp", "domainWhiteList", "tucao.qq.com,mobile.qzone.qq.com");
      if ((str1 != null) && (!str1.equals(this.privateOpenUrlDomainWhiteList)))
      {
        QMLog.i("InternalJSPlugin", "getOpenUrlDomainWhiteList:" + str1);
        this.openUrlDomainWhiteList = new ArrayList();
        try
        {
          String[] arrayOfString = str1.split(",");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str2 = arrayOfString[i];
              if (!TextUtils.isEmpty(str2)) {
                this.openUrlDomainWhiteList.add(str2);
              }
              i += 1;
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.privateOpenUrlDomainWhiteList = str1;
        }
      }
    }
  }
  
  private void onOpenThirdApp(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, RequestEvent paramRequestEvent)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QMLog.d("InternalJSPlugin", "onOpenThridApp - appid : " + paramString1 + "; packageName : " + paramString2 + "; appName : " + paramString3);
      paramRequestEvent.fail("invalid parameter");
      return;
    }
    PackageManager localPackageManager = paramActivity.getPackageManager();
    for (;;)
    {
      try
      {
        if (localPackageManager.getPackageInfo(paramString2, 1) != null)
        {
          paramActivity.runOnUiThread(new InternalJSPlugin.6(this, paramActivity, paramString3, paramString5, localPackageManager, paramString2, paramRequestEvent));
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramString5)
      {
        paramString5 = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
        if ((paramString5 == null) || (!paramString5.isGooglePlayVersion())) {
          break label355;
        }
        if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_download_switch", 0) != 1) {
          break label333;
        }
        i = 1;
        j = i;
        if (i == 0)
        {
          AppBrandTask.runTaskOnUiThread(new InternalJSPlugin.8(this));
          j = i;
        }
        if ((paramInt == 1) || (j == 0)) {
          break label339;
        }
        confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, paramString4, paramRequestEvent);
        return;
        paramString5 = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
        if ((paramString5 == null) || (!paramString5.isGooglePlayVersion())) {
          break label361;
        }
        if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_download_switch", 0) == 1)
        {
          i = 1;
          j = i;
          if (i == 0)
          {
            AppBrandTask.runTaskOnUiThread(new InternalJSPlugin.7(this));
            j = i;
          }
          if ((paramInt == 1) || (j == 0)) {
            break label317;
          }
          confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, paramString4, paramRequestEvent);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QMLog.d("InternalJSPlugin", "open app err", paramActivity);
        paramRequestEvent.fail("open app err");
        return;
      }
      int i = 0;
      continue;
      label317:
      QMLog.d("InternalJSPlugin", "only open");
      paramRequestEvent.fail("app not installed");
      return;
      label333:
      i = 0;
      continue;
      label339:
      QMLog.d("InternalJSPlugin", "only open");
      paramRequestEvent.fail("app not installed");
      return;
      label355:
      int j = 1;
      continue;
      label361:
      j = 1;
    }
  }
  
  private void openAppDetailPage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {}
    while (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).downloadApp(paramContext, this.mMiniAppInfo, paramString1, paramString2, paramString3, paramString4)) {
      return;
    }
    MiniToast.makeText(paramContext, 0, "暂不支持在" + QUAUtil.getApplicationName(paramContext) + "中下载应用", 1);
  }
  
  private boolean openUrlForStyle(Bundle paramBundle, JSONObject paramJSONObject, openUrlCallback paramopenUrlCallback)
  {
    if (paramJSONObject.has("style"))
    {
      int i = paramJSONObject.optInt("style");
      if ((i < 0) || (i > 2))
      {
        QMLog.e("InternalJSPlugin", "style error, return.");
        if (paramopenUrlCallback != null) {
          paramopenUrlCallback.openResult(false, "style error");
        }
        return true;
      }
      switch (i)
      {
      default: 
        switch (paramJSONObject.optInt("navigationBarStyle"))
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramBundle.putBoolean("hide_title_left_arrow", paramJSONObject.optBoolean("hideLeftArrow", false));
      return false;
      paramBundle.putBoolean("hide_more_button", false);
      paramBundle.putBoolean("hide_operation_bar", true);
      break;
      paramBundle.putBoolean("hide_more_button", true);
      paramBundle.putBoolean("hide_operation_bar", true);
      break;
      paramBundle.putBoolean("hide_more_button", false);
      paramBundle.putBoolean("hide_operation_bar", false);
      paramBundle.putString("webStyle", "");
      break;
      paramBundle.putBoolean("hide_more_button", true);
      paramBundle.putBoolean("hide_operation_bar", false);
      paramBundle.putString("webStyle", "");
      break;
      paramBundle.putBoolean("hide_left_button", true);
      paramBundle.putBoolean("show_right_close_button", true);
      break;
      paramBundle.putBoolean("isTransparentTitleAndClickable", true);
    }
  }
  
  private boolean openUrlForTarget(String paramString, JSONObject paramJSONObject, openUrlCallback paramopenUrlCallback)
  {
    if (paramJSONObject.has("target"))
    {
      int i = paramJSONObject.optInt("target");
      if ((i < 0) || (i > 1)) {
        if (paramopenUrlCallback != null) {
          paramopenUrlCallback.openResult(false, "target error");
        }
      }
      label207:
      for (;;)
      {
        return true;
        if (i != 1) {
          break;
        }
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("big_brother_source_key", "biz_src_miniapp");
        if (paramString.resolveActivity(this.mContext.getPackageManager()) != null)
        {
          QMLog.d("InternalJSPlugin", "openUrl by system webview.");
          this.mMiniAppContext.getAttachedActivity().startActivity(paramString);
          switch (paramJSONObject.optInt("animation"))
          {
          }
        }
        for (;;)
        {
          if (paramopenUrlCallback == null) {
            break label207;
          }
          paramopenUrlCallback.openResult(true, null);
          return true;
          QMLog.d("InternalJSPlugin", "openUrl by system webview error.");
          break;
          this.mMiniAppContext.getAttachedActivity().overridePendingTransition(0, 0);
          continue;
          this.mMiniAppContext.getAttachedActivity().overridePendingTransition(R.anim.mini_sdk_slide_in_from_bottom, 0);
        }
      }
    }
    return false;
  }
  
  private static void saveToMiniAppStorage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null) || (paramString3 == null)) {
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new InternalJSPlugin.1(paramContext, paramString1, paramString2, paramString3));
  }
  
  @JsEvent({"getQua"})
  public void getQua(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qua", QUAUtil.getPlatformQUA());
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("InternalJSPlugin", "getQua", localJSONException);
      }
    }
  }
  
  @JsEvent({"getStoreAppList"})
  public void getStoreAppList(RequestEvent paramRequestEvent)
  {
    if (TextUtils.isEmpty(""))
    {
      paramRequestEvent.fail("no dataCacheKey at app.json");
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new InternalJSPlugin.2(this, paramRequestEvent));
  }
  
  @JsEvent({"launchApplication"})
  public void launchApplication(RequestEvent paramRequestEvent)
  {
    int i = -1;
    QMLog.e("InternalJSPlugin", "openapp");
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("extInfo");
        String str1 = ((JSONObject)localObject).optString("appConnectId");
        String str2 = ((JSONObject)localObject).optString("appPackagename");
        localObject = ((JSONObject)localObject).optString("appParameter", "");
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getMiniAppInfo() == null) || (this.mMiniAppContext.getMiniAppInfo().launchParam == null)) {
          break label294;
        }
        j = this.mMiniAppContext.getMiniAppInfo().launchParam.scene;
        if (this.mMiniAppContext.canLaunchApp())
        {
          i = this.mMiniAppContext.getLaunchAppScene();
          QMLog.d("InternalJSPlugin", "API_LAUNCH_APP  realscene : " + j + "   scene:" + i);
          if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getMiniAppInfo() != null))
          {
            ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.getMiniAppInfo().appId, str1, str2, i, new InternalJSPlugin.5(this, (String)localObject, paramRequestEvent, str1, str2));
            return;
          }
          QMLog.e("InternalJSPlugin", "launchApplication error, appBrandRuntime or getApkgInfo is null.");
          paramRequestEvent.fail("appBrandRuntime or getApkgInfo is null.");
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("InternalJSPlugin", paramRequestEvent.event + " error,", localException);
        paramRequestEvent.fail();
        return;
      }
      i = j;
      continue;
      label294:
      int j = -1;
    }
  }
  
  @JsEvent({"notifyNative"})
  public void notifyNative(RequestEvent paramRequestEvent)
  {
    try
    {
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateEntryList(paramRequestEvent.jsonParams))
      {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中更新下拉列表", 1);
        paramRequestEvent.fail();
        return;
      }
      paramRequestEvent.ok();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("InternalJSPlugin", "notifyNative", localException);
      localException.printStackTrace();
      paramRequestEvent.fail();
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    getOpenUrlDomainWhiteList();
  }
  
  @JsEvent({"openUrl"})
  public void openUrl(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("url");
      if ((TextUtils.isEmpty(str)) || ("null".equals(str)))
      {
        paramRequestEvent.fail("url error");
        return;
      }
      openUrl(localJSONObject, new InternalJSPlugin.3(this, paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("InternalJSPlugin", paramRequestEvent.event + " error,", localJSONException);
      paramRequestEvent.fail();
    }
  }
  
  public void openUrl(JSONObject paramJSONObject, openUrlCallback paramopenUrlCallback)
  {
    for (;;)
    {
      String str;
      try
      {
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getAttachedActivity() == null) || (this.mMiniAppContext.getAttachedActivity().isFinishing()) || (paramJSONObject == null))
        {
          if (paramopenUrlCallback != null) {
            paramopenUrlCallback.openResult(false, "activity or json error.");
          }
          QMLog.e("InternalJSPlugin", "openurl error, return.");
          return;
        }
        try
        {
          str = paramJSONObject.optString("url");
          if ((!TextUtils.isEmpty(str)) && (!"null".equals(str))) {
            break label142;
          }
          if (paramopenUrlCallback == null) {
            continue;
          }
          paramopenUrlCallback.openResult(false, "url is null.");
        }
        catch (Exception paramJSONObject)
        {
          QMLog.e("InternalJSPlugin", "openUrl error; ", paramJSONObject);
        }
        if (paramopenUrlCallback == null) {
          continue;
        }
        paramopenUrlCallback.openResult(false, "openUrl error");
        continue;
        if (openUrlForTarget(str, paramJSONObject, paramopenUrlCallback)) {
          continue;
        }
      }
      finally {}
      label142:
      Bundle localBundle = new Bundle();
      if (!openUrlForStyle(localBundle, paramJSONObject, paramopenUrlCallback))
      {
        MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        Intent localIntent = new Intent();
        localIntent.putExtra("articalChannelId", 0);
        if ((this.mMiniAppContext == null) || (!this.mMiniAppContext.getMiniAppInfo().isInternalApp())) {
          localIntent.setFlags(402653184);
        }
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtras(localBundle);
        localIntent.putExtra("url", str);
        int i = paramJSONObject.optInt("animation");
        if ((i < 0) || (i > 2))
        {
          QMLog.e("InternalJSPlugin", "animation error, return.");
          if (paramopenUrlCallback != null) {
            paramopenUrlCallback.openResult(false, "animation error");
          }
        }
        else
        {
          localMiniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachedActivity(), localIntent);
          if (paramopenUrlCallback != null)
          {
            paramopenUrlCallback.openResult(true, null);
            break label374;
            this.mMiniAppContext.getAttachedActivity().overridePendingTransition(0, 0);
            continue;
            this.mMiniAppContext.getAttachedActivity().overridePendingTransition(R.anim.mini_sdk_slide_in_from_bottom, 0);
            continue;
          }
          label374:
          switch (i)
          {
          }
        }
      }
    }
  }
  
  @JsEvent({"private_openUrl"})
  public void private_openUrl(RequestEvent paramRequestEvent)
  {
    Object localObject1;
    String str2;
    String str1;
    Object localObject2;
    try
    {
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      QMLog.d("InternalJSPlugin", "API_PRIVATE_OPENURL " + localObject1);
      str2 = ((JSONObject)localObject1).optString("url");
      if (TextUtils.isEmpty(str2))
      {
        paramRequestEvent.fail("url is empty");
        return;
      }
      boolean bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
      str1 = str2.toLowerCase();
      localObject2 = DomainConfig.getDomainConfig(str1);
      if (bool) {
        break label154;
      }
      if (!this.mApkgInfo.isValidPrefix(str1, false))
      {
        paramRequestEvent.fail("url is not https");
        return;
      }
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("InternalJSPlugin", "private_openUrl", paramRequestEvent);
      return;
    }
    if ((this.openUrlDomainWhiteList != null) && (!this.openUrlDomainWhiteList.contains(((DomainConfig)localObject2).host)))
    {
      paramRequestEvent.fail("url domain not configured.");
      return;
    }
    label154:
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ("tucao.qq.com".equals(((DomainConfig)localObject2).host))
    {
      localObject1 = "";
      try
      {
        localObject2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          QMLog.e("InternalJSPlugin", "startComplainAndCallback, url = " + "");
          localUnsupportedEncodingException.printStackTrace();
        }
        paramRequestEvent.fail("url error");
        return;
      }
      if (!TextUtils.isEmpty(str2))
      {
        str1 = LoginManager.getInstance().getAccount();
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        str1 = str2.replace("{openid}", (CharSequence)localObject2).replace("{clientVersion}", localMiniAppProxy.getAppVersion()).replace("{platform}", "android").replace("{osVersion}", String.valueOf(Build.VERSION.SDK_INT)).replace("{netType}", NetworkUtil.getNetWorkTypeByStr(this.mContext)).replace("{avatar}", (CharSequence)localObject1);
        localObject2 = LoginManager.getInstance().getNickName();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "";
        }
        localObject1 = str1.replace("{nickname}", (CharSequence)localObject1);
        QMLog.d("InternalJSPlugin", "API_PRIVATE_OPENURL url : " + (String)localObject1);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("selfSet_leftViewText", "返回");
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        localMiniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachedActivity(), (Intent)localObject2);
        paramRequestEvent.ok();
        if (!((String)localObject1).startsWith("https://tucao.qq.com/qq_miniprogram")) {
          return;
        }
        QMLog.d("InternalJSPlugin", "feedback, prepare to upload log ");
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).uploadUserLog(this.mMiniAppInfo.appId);
        return;
      }
    }
    openUrl((JSONObject)localObject1, new InternalJSPlugin.4(this, paramRequestEvent));
  }
  
  public static abstract interface openUrlCallback
  {
    public abstract void openResult(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin
 * JD-Core Version:    0.7.0.1
 */