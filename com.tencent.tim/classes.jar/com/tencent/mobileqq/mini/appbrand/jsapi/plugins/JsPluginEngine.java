package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Build.VERSION;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin;
import com.tencent.mobileqq.mini.appbrand.page.MiniAppWebSocket;
import com.tencent.mobileqq.mini.appbrand.page.ServiceRemoteRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebViewEventListener;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.MiniAppDexLoader;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class JsPluginEngine
  extends BaseJsPluginEngine
  implements WebViewEventListener
{
  public static final String TAG = "JsPluginEngine";
  
  public JsPluginEngine(AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramAppBrandRuntime);
  }
  
  public static List<IJsPlugin> initJsPluginList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NavigationPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.TabBarJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InputJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ClipboardJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NetworkJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapViewJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePlayerJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LivePusherJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.CanvasJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.LogJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SchemeJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PersonalizeJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ReportJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InterstitialAdPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MapJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedVideoJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedLivePlayerJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedLivePusherJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PreCacheJsPlugin"));
    if (Build.VERSION.SDK_INT >= 18) {
      localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BluetoothJsPlugin"));
    }
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SensorJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ScreenJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BatteryJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OuterJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.WifiJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ContactJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NativeFeatureJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SharePlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.QQFriendsJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppBoxPlugin"));
    localArrayList.add(MiniAppDexLoader.getInstance().createJsPlugin("com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin"));
    return localArrayList;
  }
  
  public void callbackJsEventCancel(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJsRuntime != null)
    {
      paramString = ApiUtil.wrapCallbackCancel(paramString, paramJSONObject);
      if (paramString == null) {
        break label29;
      }
    }
    label29:
    for (paramString = paramString.toString();; paramString = "")
    {
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public void callbackJsEventFail(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    callbackJsEventFail(paramJsRuntime, paramString, paramJSONObject, null, paramInt);
  }
  
  public void callbackJsEventFail(JsRuntime paramJsRuntime, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (paramJsRuntime != null)
    {
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, paramJSONObject, paramString2);
      if (paramString1 == null) {
        break label31;
      }
    }
    label31:
    for (paramString1 = paramString1.toString();; paramString1 = "")
    {
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString1);
      return;
    }
  }
  
  public void callbackJsEventOK(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJsRuntime != null)
    {
      paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
      if (paramString == null) {
        break label29;
      }
    }
    label29:
    for (paramString = paramString.toString();; paramString = "")
    {
      paramJsRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public String getPkgName()
  {
    return ((AppBrandRuntime)this.appBrandRuntime).apkgInfo.apkgName;
  }
  
  public JsRuntime getServiceRuntime()
  {
    return ((AppBrandRuntime)this.appBrandRuntime).serviceRuntime;
  }
  
  public void init()
  {
    super.init();
    List localList2 = this.appBrandRuntime.getPluginList();
    List localList1;
    if (localList2 != null)
    {
      localList1 = localList2;
      if (localList2.size() > 0) {}
    }
    else
    {
      localList1 = initJsPluginList();
    }
    registerPlugins(new ArrayList(localList1));
  }
  
  public void onWebViewEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QLog.d("JsPluginEngine", 4, "onWebViewEvent eventName=" + paramString1 + ",webviewIds=" + paramString3 + ",appId=" + paramString4 + ",pageWebviewId=" + paramInt);
    ((AppBrandRuntime)this.appBrandRuntime).evaluateServiceSubcribeJS(paramString1, paramString2, paramInt);
  }
  
  public String onWebViewNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("JsPluginEngine", 4, "onWebViewNativeRequest eventName=" + paramString1 + ",callbackId=" + paramInt);
    if ((paramString1.equals("remoteDebugInfo")) && ((((AppBrandRuntime)this.appBrandRuntime).serviceRuntime instanceof ServiceRemoteRuntime)))
    {
      ((ServiceRemoteRuntime)((AppBrandRuntime)this.appBrandRuntime).serviceRuntime).getMiniAppWebSocket().sendDomEvent(paramString2, paramInt);
      return "";
    }
    return handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine
 * JD-Core Version:    0.7.0.1
 */