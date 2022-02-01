package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

@JsPlugin
public class SystemInfoPlugin
  extends BaseJsPlugin
{
  public static final String TAG = "SystemInfoPlugin";
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  @JsEvent({"getSystemInfo", "getSystemInfoSync"})
  public String handleGetSystemInfo(RequestEvent paramRequestEvent)
  {
    int i = 1;
    int m = 0;
    if (this.mContext == null)
    {
      QMLog.e("SystemInfoPlugin", "getSystemInfo error,context is NULL");
      return paramRequestEvent.fail();
    }
    Object localObject1;
    boolean bool1;
    label83:
    boolean bool2;
    label155:
    double d;
    int n;
    int k;
    int j;
    int i1;
    int i2;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject1 = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject1);
      if ((!DisplayUtil.checkNavigationBarShow(this.mContext)) && (!DisplayUtil.isFlymeOS7NavBarShow())) {
        break label786;
      }
      bool1 = true;
      localObject3 = this.mMiniAppContext.getAttachedActivity();
      bool2 = bool1;
      if (localObject3 != null)
      {
        bool2 = bool1;
        if (!((Activity)localObject3).isFinishing())
        {
          bool2 = bool1;
          if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))
          {
            if (((!DisplayUtil.hasNavBar((Context)localObject3)) || (!DisplayUtil.isNavigationBarExist((Activity)localObject3))) && (!DisplayUtil.isFlymeOS7NavBarShow())) {
              break label792;
            }
            bool2 = true;
          }
        }
      }
      QMLog.d("SystemInfoPlugin", " hasNavBar : " + bool2 + "; " + Build.BRAND);
      d = ((DisplayMetrics)localObject1).density;
      n = (int)((float)Math.round(((DisplayMetrics)localObject1).widthPixels / d) + 0.5F);
      k = (int)((float)Math.round(((DisplayMetrics)localObject1).heightPixels / d) + 0.5F);
      j = k;
      if (bool2) {
        j = k - (int)(DisplayUtil.getNavigationBarHeight(this.mContext) / d);
      }
      i1 = (int)(Math.round(DisplayUtil.getStatusBarHeight(this.mContext)) / d);
      i2 = (int)(DisplayUtil.dip2px(this.mContext, 44.0F) / d + 0.5D);
      k = (int)(DisplayUtil.dip2px(this.mContext, 54.0F) / d + 0.5D);
      localObject1 = PageAction.obtain(this.mMiniAppContext).getPageUrl();
      if (StringUtil.isEmpty((String)localObject1)) {
        break label798;
      }
      label334:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label874;
      }
    }
    label786:
    label792:
    label798:
    label874:
    for (Object localObject3 = this.mApkgInfo.getAppConfigInfo().getPageInfo((String)localObject1).windowInfo.navigationBarInfo.style;; localObject3 = "default")
    {
      if ((this.mApkgInfo != null) && (this.mApkgInfo.getAppConfigInfo() != null)) {
        if ((this.mApkgInfo.getAppConfigInfo().tabBarInfo == null) || (!this.mApkgInfo.isTabBarPage((String)localObject1)) || (!this.mApkgInfo.getAppConfigInfo().tabBarInfo.isShow())) {}
      }
      for (;;)
      {
        if ("default".equals(localObject3))
        {
          if (i != 0) {
            m = k;
          }
          i = j - i1 - i2 - m;
          try
          {
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("brand", Build.BRAND);
            ((JSONObject)localObject1).put("model", Build.MODEL);
            ((JSONObject)localObject1).put("pixelRatio", d);
            ((JSONObject)localObject1).put("screenWidth", n);
            ((JSONObject)localObject1).put("screenHeight", j);
            ((JSONObject)localObject1).put("windowWidth", n);
            ((JSONObject)localObject1).put("windowHeight", i);
            ((JSONObject)localObject1).put("statusBarHeight", i1);
            ((JSONObject)localObject1).put("language", "zh_CN");
            ((JSONObject)localObject1).put("version", this.mMiniAppProxy.getAppVersion());
            ((JSONObject)localObject1).put("system", "Android " + Build.VERSION.RELEASE);
            ((JSONObject)localObject1).put("platform", "android");
            ((JSONObject)localObject1).put("fontSizeSetting", 16);
            ((JSONObject)localObject1).put("SDKVersion", this.mMiniAppContext.getBaseLibVersion());
            ((JSONObject)localObject1).put("AppPlatform", this.mMiniAppProxy.getAppName());
            localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject1).toString();
            if ("getSystemInfo".equals(paramRequestEvent.event)) {
              paramRequestEvent.evaluateCallbackJs((String)localObject1);
            }
            QMLog.i("SystemInfoPlugin", "getSystemInfo ： " + (String)localObject1);
            return localObject1;
          }
          catch (Exception localException)
          {
            QMLog.e("SystemInfoPlugin", "getSystemInfo exception: " + new Throwable(localException));
            return paramRequestEvent.fail();
          }
          Object localObject2 = this.mContext.getResources().getDisplayMetrics();
          break;
          bool1 = false;
          break label83;
          bool2 = false;
          break label155;
          localObject3 = this.mMiniAppInfo.launchParam.entryPath;
          localObject2 = this.mApkgInfo.mAppConfigInfo.entryPagePath;
          if (!this.mApkgInfo.isUrlFileExist((String)localObject3)) {
            break label334;
          }
          localObject2 = localObject3;
          break label334;
          i = 0;
          continue;
        }
        if (i != 0) {}
        for (;;)
        {
          i = j - k;
          break;
          k = 0;
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.SystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */