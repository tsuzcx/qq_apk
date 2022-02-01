package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientFactory;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientHolder;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EmbeddedLivePlayerJsPlugin
  extends BaseJsPlugin
{
  private static final int EMBEDDED_ON_DESTROY_EVENT = 3;
  private static final int EMBEDDED_ON_PAUSE_EVENT = 2;
  private static final int EMBEDDED_ON_RESUME_EVENT = 1;
  public static final String EVENT_EXIT_FULL_SCREEN = "xWebLivePlayerExitFullScreen";
  public static final String EVENT_INSERT_XWEB_LIVE_PLAYER = "insertXWebLivePlayer";
  public static final String EVENT_OPERATE_XWEB_LIVE_PLAYER = "operateXWebLivePlayer";
  public static final String EVENT_ORIENTATION_CHANGE = "onXWebLivePlayerOrientationChanged";
  public static final String EVENT_REMOVE_XWEB_LIVE_PLAYER = "removePositioningContainer";
  public static final String EVENT_REQUEST_FULL_SCREEN = "xWebLivePlayerRequestFullScreen";
  public static final String EVENT_STATE_CHANGE = "xWebLivePlayerStateChange";
  public static final String EVENT_TYPE_NET_STATUS = "onXWebLivePlayerNetStatus";
  public static final String EVENT_TYPE_PLAYER_EVENT = "onXWebLivePlayerEvent";
  public static final String EVENT_UPDATE_XWEB_LIVE_PLAYER = "updateXWebLivePlayer";
  private static final Set<String> S_EVENT_MAP = new EmbeddedLivePlayerJsPlugin.1();
  public static final String TAG = "EmbeddedLivePlayerJsPlugin";
  
  private EmbeddedWidgetClientFactory getFactory()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jsPluginEngine != null)
    {
      localObject1 = localObject2;
      if (this.jsPluginEngine.appBrandRuntime != null)
      {
        localObject1 = localObject2;
        if (this.jsPluginEngine.appBrandRuntime.getCurWebviewContainer() != null)
        {
          localObject1 = localObject2;
          if (this.jsPluginEngine.appBrandRuntime.getCurWebviewContainer().getPageWebview() != null) {
            localObject1 = this.jsPluginEngine.appBrandRuntime.getCurWebviewContainer().getPageWebview().getEmbeddedWidgetClientFactory();
          }
        }
      }
    }
    return localObject1;
  }
  
  private void onEmbeddedWidgetLifeCycleEvent(int paramInt)
  {
    Object localObject = getFactory();
    if ((localObject != null) && (((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap() != null))
    {
      localObject = ((EmbeddedWidgetClientFactory)localObject).getEmbeddedWidgetClientHolderMap().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmbeddedWidgetClientHolder localEmbeddedWidgetClientHolder = (EmbeddedWidgetClientHolder)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localEmbeddedWidgetClientHolder != null) {
          switch (paramInt)
          {
          default: 
            break;
          case 1: 
            localEmbeddedWidgetClientHolder.nativeResume();
            break;
          case 2: 
            localEmbeddedWidgetClientHolder.nativePause();
            break;
          case 3: 
            localEmbeddedWidgetClientHolder.nativeDestroy();
            ((Iterator)localObject).remove();
          }
        }
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("EmbeddedLivePlayerJsPlugin", 1, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getContainer() != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()) != null) && (((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()).getWebView(paramJsRuntime.getPageWebViewId()) != null)) {
      localEmbeddedWidgetClientFactory = ((AppBrandPageContainer)this.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(paramJsRuntime.getPageWebViewId()).getWebView(paramJsRuntime.getPageWebViewId()).getEmbeddedWidgetClientFactory();
    }
    for (;;)
    {
      if ("insertXWebLivePlayer".equals(paramString1)) {
        if ((this.jsPluginEngine != null) && (localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleInsertEmbeddedWidgetEvent("insertXWebLivePlayer", paramString2, paramJsRuntime, this.jsPluginEngine.appBrandRuntime))) {
          if (this.jsPluginEngine != null) {
            this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          }
        }
      }
      for (;;)
      {
        return "";
        if (this.jsPluginEngine != null)
        {
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
          continue;
          if ("updateXWebLivePlayer".equals(paramString1))
          {
            if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, "updateXWebLivePlayer", paramString2, paramInt)))
            {
              if (this.jsPluginEngine != null) {
                this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
              }
            }
            else if (this.jsPluginEngine != null) {
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            }
          }
          else if ("operateXWebLivePlayer".equals(paramString1))
          {
            if (((localEmbeddedWidgetClientFactory == null) || (!localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramJsRuntime, "operateXWebLivePlayer", paramString2, paramInt))) && (this.jsPluginEngine != null)) {
              this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
            }
          }
          else if ("removePositioningContainer".equals(paramString1)) {
            QLog.e("EmbeddedLivePlayerJsPlugin", 1, "handleNativeRequest-removePositioningContainer ,jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
          }
        }
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    onEmbeddedWidgetLifeCycleEvent(3);
  }
  
  public void onPause()
  {
    super.onPause();
    onEmbeddedWidgetLifeCycleEvent(2);
  }
  
  public void onResume()
  {
    super.onResume();
    onEmbeddedWidgetLifeCycleEvent(1);
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.EmbeddedLivePlayerJsPlugin
 * JD-Core Version:    0.7.0.1
 */