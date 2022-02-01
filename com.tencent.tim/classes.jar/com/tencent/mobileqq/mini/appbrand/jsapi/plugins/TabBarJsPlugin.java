package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONObject;

public class TabBarJsPlugin
  extends BaseJsPlugin
{
  private static final String API_HIDE_TABBAR = "hideTabBar";
  private static final String API_HITD_RED_DOT = "hideTabBarRedDot";
  private static final String API_REMOVE_TABBAR_BADGE = "removeTabBarBadge";
  private static final String API_SET_TABBAR_BADGE = "setTabBarBadge";
  private static final String API_SET_TABBAR_ITEM = "setTabBarItem";
  private static final String API_SET_TABBAR_STYLE = "setTabBarStyle";
  private static final String API_SHOW_RED_DOT = "showTabBarRedDot";
  private static final String API_SHOW_TABBAR = "showTabBar";
  private static final Set<String> S_EVENT_MAP = new TabBarJsPlugin.1();
  private static final String TAG = "[mini] TabBarJsPlugin";
  
  public TabBarView getTabBarView()
  {
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getContainer() != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList != null))
    {
      Iterator localIterator = ((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).pageLinkedList.iterator();
      while (localIterator.hasNext())
      {
        AbsAppBrandPage localAbsAppBrandPage = (AbsAppBrandPage)localIterator.next();
        if (localAbsAppBrandPage.isTabPage()) {
          return localAbsAppBrandPage.getTabBar();
        }
      }
    }
    return null;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] TabBarJsPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    Object localObject2 = getTabBarView();
    if (this.jsPluginEngine == null) {
      return "";
    }
    if (localObject2 == null)
    {
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
      localObject2 = new WeakReference(localObject2);
      if (("showTabBar".equals(paramString1)) || ("hideTabBar".equals(paramString1)))
      {
        AppBrandTask.runTaskOnUiThread(new TabBarJsPlugin.2(this, (WeakReference)localObject2, paramString1, localJSONObject.optBoolean("animation", false)));
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ApkgInfo localApkgInfo;
        localThrowable.printStackTrace();
        Object localObject1 = new JSONObject();
        continue;
        if ("setTabBarStyle".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new TabBarJsPlugin.3(this, (WeakReference)localObject2, (JSONObject)localObject1));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
        else if ("setTabBarItem".equals(paramString1))
        {
          int i = ((JSONObject)localObject1).optInt("index", -1);
          if ((i < 0) || (i > 3))
          {
            this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "invalid index", paramInt);
          }
          else
          {
            String str1 = ((JSONObject)localObject1).optString("text");
            String str2 = ((JSONObject)localObject1).optString("iconPath");
            localObject1 = ((JSONObject)localObject1).optString("selectedIconPath");
            AppBrandTask.runTaskOnUiThread(new TabBarJsPlugin.4(this, (WeakReference)localObject2, i, str1, localApkgInfo.getBitmap(localApkgInfo.getFilePath(str2)), localApkgInfo.getBitmap(localApkgInfo.getFilePath((String)localObject1))));
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
        }
        else if ("setTabBarBadge".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new TabBarJsPlugin.5(this, (WeakReference)localObject2, ((JSONObject)localObject1).optString("type"), ((JSONObject)localObject1).optInt("index", -1), ((JSONObject)localObject1).optString("text")));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
        else if ("removeTabBarBadge".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new TabBarJsPlugin.6(this, (WeakReference)localObject2, ((JSONObject)localObject1).optInt("index", -1)));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
        else if ("showTabBarRedDot".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new TabBarJsPlugin.7(this, (WeakReference)localObject2, ((JSONObject)localObject1).optInt("index", -1)));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
        else if ("hideTabBarRedDot".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new TabBarJsPlugin.8(this, (WeakReference)localObject2, ((JSONObject)localObject1).optInt("index", -1)));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.TabBarJsPlugin
 * JD-Core Version:    0.7.0.1
 */