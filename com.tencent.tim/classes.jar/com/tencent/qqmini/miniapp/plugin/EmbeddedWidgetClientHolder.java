package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import org.json.JSONObject;

public class EmbeddedWidgetClientHolder
  implements IExtendedEmbeddedWidgetClient
{
  private static final String TAG = "miniapp-embedded-EmbeddedWidgetClientHolder";
  private Map<String, String> attributes;
  private IExtendedEmbeddedWidgetClient realClient = null;
  private Surface surfaceCreated;
  private String tagName;
  private IEmbeddedWidget widget;
  
  public EmbeddedWidgetClientHolder(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.tagName = paramString;
    this.attributes = paramMap;
    this.widget = paramIEmbeddedWidget;
  }
  
  public void handleEmbeddedWidgetEvent(String paramString, IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject, int paramInt)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "handleEmbeddedWidgetEvent event:" + paramString);
    if ((this.realClient instanceof VideoEmbeddedWidgetClient)) {
      if ("operateXWebVideo".equals(paramString)) {
        ((VideoEmbeddedWidgetClient)this.realClient).handleOperateXWebVideo(paramIMiniAppContext, paramJSONObject);
      }
    }
    label55:
    do
    {
      do
      {
        do
        {
          break label55;
          do
          {
            return;
          } while (!"updateXWebVideo".equals(paramString));
          ((VideoEmbeddedWidgetClient)this.realClient).handleUpdateXWebVideo(paramIMiniAppContext, paramJSONObject);
          return;
          if (!(this.realClient instanceof LivePlayerEmbeddedWidgetClient)) {
            break;
          }
          if ("operateXWebLivePlayer".equals(paramString))
          {
            ((LivePlayerEmbeddedWidgetClient)this.realClient).handleOperateXWebLivePlayer(paramIMiniAppContext, paramJSONObject, paramInt);
            return;
          }
          if ("updateXWebLivePlayer".equals(paramString))
          {
            ((LivePlayerEmbeddedWidgetClient)this.realClient).handleUpdateXWebLivePlayer(paramJSONObject);
            return;
          }
        } while (!"removePositioningContainer".equals(paramString));
        ((LivePlayerEmbeddedWidgetClient)this.realClient).handleRemoveXWebLivePlayer();
        return;
      } while (!(this.realClient instanceof LivePusherEmbeddedWidgetClient));
      if ("operateXWebLivePusher".equals(paramString))
      {
        ((LivePusherEmbeddedWidgetClient)this.realClient).handleOperateXWebLivePusher(paramIMiniAppContext, paramJSONObject, paramInt);
        return;
      }
      if ("updateXWebLivePusher".equals(paramString))
      {
        ((LivePusherEmbeddedWidgetClient)this.realClient).handleUpdateXWebLivePusher(paramJSONObject);
        return;
      }
    } while (!"removeXWebLivePusher".equals(paramString));
    ((LivePusherEmbeddedWidgetClient)this.realClient).handleRemoveXWebLivePusher();
  }
  
  public void handleInsertEmbeddedWidgetEvent(String paramString, JSONObject paramJSONObject, IJsService paramIJsService1, IJsService paramIJsService2)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "handleInsertEmbeddedWidgetEvent event:" + paramString);
    if ("insertXWebVideo".equals(paramString))
    {
      this.realClient = new VideoEmbeddedWidgetClient(this.tagName, this.attributes, this.widget);
      if (this.surfaceCreated != null) {
        this.realClient.onSurfaceCreated(this.surfaceCreated);
      }
      ((VideoEmbeddedWidgetClient)this.realClient).handleInsertXWebVideo(paramJSONObject, paramIJsService1, paramIJsService2);
    }
    do
    {
      return;
      if ("insertXWebLivePlayer".equals(paramString))
      {
        this.realClient = new LivePlayerEmbeddedWidgetClient(this.tagName, this.attributes, this.widget);
        if (this.surfaceCreated != null) {
          this.realClient.onSurfaceCreated(this.surfaceCreated);
        }
        ((LivePlayerEmbeddedWidgetClient)this.realClient).handleInsertXWebLivePlayer(paramJSONObject, paramIJsService1, paramIJsService2);
        return;
      }
    } while (!"insertXWebLivePusher".equals(paramString));
    this.realClient = new LivePusherEmbeddedWidgetClient(this.tagName, this.attributes, this.widget);
    if (this.surfaceCreated != null) {
      this.realClient.onSurfaceCreated(this.surfaceCreated);
    }
    ((LivePusherEmbeddedWidgetClient)this.realClient).handleInsertXWebLivePusher(paramJSONObject, paramIJsService1, paramIJsService2);
  }
  
  public void nativeDestroy()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativeDestroy");
    if (this.realClient != null)
    {
      this.realClient.nativeDestroy();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativeDestroy-realClient is null");
  }
  
  public void nativePause()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativePause");
    if (this.realClient != null)
    {
      this.realClient.nativePause();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativePause-realClient is null");
  }
  
  public void nativeResume()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativeResume");
    if (this.realClient != null)
    {
      this.realClient.nativeResume();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativeResume-realClient is null");
  }
  
  public void onActive()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onActive");
    if (this.realClient != null)
    {
      this.realClient.onActive();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onActive-realClient is null");
  }
  
  public void onDeactive()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onDeactive");
    if (this.realClient != null)
    {
      this.realClient.onDestroy();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onDeactive-realClient is null");
  }
  
  public void onDestroy()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onDestroy");
    if (this.realClient != null)
    {
      this.realClient.onDestroy();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onDestroy-realClient is null");
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRectChanged");
    if (this.realClient != null)
    {
      QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRectChanged-realClient.onRectChanged");
      this.realClient.onRectChanged(paramRect);
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRectChanged-realClient is null");
  }
  
  public void onRequestRedraw()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRequestRedraw");
    if (this.realClient != null)
    {
      this.realClient.onRequestRedraw();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRequestRedraw-realClient is null");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onSurfaceCreated");
    if (this.realClient != null)
    {
      this.realClient.onSurfaceCreated(paramSurface);
      return;
    }
    this.surfaceCreated = paramSurface;
    QMLog.e("miniapp-embedded-EmbeddedWidgetClientHolder", "onSurfaceCreated-realClient is null");
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onSurfaceDestroyed");
    if (this.realClient != null)
    {
      this.realClient.onSurfaceDestroyed(paramSurface);
      return;
    }
    this.surfaceCreated = null;
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onSurfaceDestroyed-realClient is null");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onTouchEvent");
    if (this.realClient != null)
    {
      QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onTouchEvent-realClient.onTouchEvent");
      return this.realClient.onTouchEvent(paramMotionEvent);
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onTouchEvent-realClient is null");
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onVisibilityChanged");
    if (this.realClient != null)
    {
      this.realClient.onVisibilityChanged(paramBoolean);
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onVisibilityChanged-realClient is null");
  }
  
  public void webViewDestory()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewDestory");
    if (this.realClient != null)
    {
      this.realClient.webViewDestory();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewDestory-realClient is null");
  }
  
  public void webViewPause()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewPause");
    if (this.realClient != null)
    {
      this.realClient.webViewPause();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewPause-realClient is null");
  }
  
  public void webViewResume()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewResume");
    if (this.realClient != null)
    {
      this.realClient.webViewResume();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewResume-realClient is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientHolder
 * JD-Core Version:    0.7.0.1
 */