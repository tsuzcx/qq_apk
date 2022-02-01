package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@JsPlugin
public class EmbeddedLivePlayerJsPlugin
  extends BaseJsPlugin
{
  private static final int EMBEDDED_ON_DESTROY_EVENT = 3;
  private static final int EMBEDDED_ON_PAUSE_EVENT = 2;
  private static final int EMBEDDED_ON_RESUME_EVENT = 1;
  public static final String EVENT_EXIT_FULL_SCREEN = "xWebLivePlayerExitFullScreen";
  public static final String EVENT_HIDE_NAVIGATIONBAR = "hideVirtualBottomNavigationBar";
  public static final String EVENT_INSERT_XWEB_LIVE_PLAYER = "insertXWebLivePlayer";
  public static final String EVENT_OPERATE_XWEB_LIVE_PLAYER = "operateXWebLivePlayer";
  public static final String EVENT_ORIENTATION_CHANGE = "onXWebLivePlayerOrientationChanged";
  public static final String EVENT_REMOVE_XWEB_LIVE_PLAYER = "removePositioningContainer";
  public static final String EVENT_REQUEST_FULL_SCREEN = "xWebLivePlayerRequestFullScreen";
  public static final String EVENT_SET_DISPLAY_ORIENTATION = "setDisplayOrientation";
  public static final String EVENT_SHOW_NAVIGATIONBAR = "showVirtualBottomNavigationBar";
  public static final String EVENT_STATE_CHANGE = "xWebLivePlayerStateChange";
  public static final String EVENT_TYPE_NET_STATUS = "onXWebLivePlayerNetStatus";
  public static final String EVENT_TYPE_PLAYER_EVENT = "onXWebLivePlayerEvent";
  public static final String EVENT_UPDATE_XWEB_LIVE_PLAYER = "updateXWebLivePlayer";
  public static final String TAG = "EmbeddedLivePlayerJsPlugin";
  private int lastNavBarVisibility = 8;
  private int lastTabBarVisibility = 8;
  
  private void enterFullScreenMode(Activity paramActivity)
  {
    int i;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
      if (Build.VERSION.SDK_INT < 21) {
        break label60;
      }
      i = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label75;
      }
      i |= 0x800;
    }
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
      return;
      label60:
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i = 1798;
      break;
      label75:
      i |= 0x1;
    }
  }
  
  private void enterSmallScreenMode()
  {
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    WeakReference localWeakReference = new WeakReference(localActivity);
    if (localActivity != null) {}
    try
    {
      if (!localActivity.isFinishing())
      {
        if (Build.VERSION.SDK_INT >= 16) {
          localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
        }
        this.mMiniAppContext.performAction(new EmbeddedLivePlayerJsPlugin.5(this, localWeakReference));
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("EmbeddedLivePlayerJsPlugin", "smallScreen: ", localException);
    }
  }
  
  private EmbeddedWidgetClientFactory getFactory()
  {
    return (EmbeddedWidgetClientFactory)this.mMiniAppContext.performAction(new EmbeddedLivePlayerJsPlugin.2(this));
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
  
  @JsEvent({"hideVirtualBottomNavigationBar"})
  public void hideNavigationBar(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(new EmbeddedLivePlayerJsPlugin.4(this, paramRequestEvent));
  }
  
  @JsEvent({"hideVirtualBottomNavigationBar"})
  public void hideVirtualBottomNavigationBar() {}
  
  @JsEvent({"insertXWebLivePlayer"})
  public void insertXWebLivePlayer(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    IJsService localIJsService = (IJsService)this.mMiniAppContext.performAction(new EmbeddedLivePlayerJsPlugin.1(this));
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleInsertEmbeddedWidgetEvent(paramRequestEvent.event, paramRequestEvent.jsonParams, paramRequestEvent.jsService, localIJsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
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
  
  @JsEvent({"operateXWebLivePlayer"})
  public void operateXWebLivePlayer(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"removePositioningContainer"})
  public void removeXWebVideo(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"setDisplayOrientation"})
  public void setDisplayOrientation(RequestEvent paramRequestEvent)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        int j = new JSONObject(paramRequestEvent.jsonParams).optInt("orientation", 0);
        if (j == 90)
        {
          if (i != this.mMiniAppContext.getAttachedActivity().getRequestedOrientation())
          {
            QMLog.i("EmbeddedLivePlayerJsPlugin", "EVENT_SET_DISPLAY_ORIENTATION, setRequestedOrientation: " + j);
            this.mMiniAppContext.getAttachedActivity().setRequestedOrientation(i);
          }
          paramRequestEvent.ok();
          return;
        }
        if (j == -90) {
          i = 8;
        } else {
          i = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        paramRequestEvent.fail();
        return;
      }
    }
  }
  
  @JsEvent({"showVirtualBottomNavigationBar"})
  public void showNavigationBar(RequestEvent paramRequestEvent)
  {
    this.mMiniAppContext.performAction(new EmbeddedLivePlayerJsPlugin.3(this, paramRequestEvent));
  }
  
  @JsEvent({"showVirtualBottomNavigationBar"})
  public void showVirtualBottomNavigationBar() {}
  
  @JsEvent({"updateXWebLivePlayer"})
  public void updateXWebLivePlayer(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePlayerJsPlugin
 * JD-Core Version:    0.7.0.1
 */