package com.tencent.mobileqq.webview.swift;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

@Deprecated
public class JsBridgeListener
{
  public long abC;
  public boolean cXk;
  WeakReference<WebView> hh;
  
  public JsBridgeListener(WebView paramWebView, long paramLong, String paramString)
  {
    this.hh = new WeakReference(paramWebView);
    this.abC = paramLong;
  }
  
  public JsBridgeListener(WebView paramWebView, long paramLong, boolean paramBoolean)
  {
    this.hh = new WeakReference(paramWebView);
    this.abC = paramLong;
    this.cXk = paramBoolean;
  }
  
  public static String a(int paramInt, Object paramObject, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return String.format("{'r':%d,'result':'%s'}", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    if (paramObject == null) {
      return String.format("{'r':%d,'result':'%s'}", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    if (((paramObject instanceof Number)) || ((paramObject instanceof Boolean))) {}
    for (paramObject = paramObject.toString();; paramObject = "'" + paramObject.toString().replace("\\", "\\\\").replace("'", "\\'") + "'") {
      return String.format("{'r':0,'result':%s}", new Object[] { paramObject });
    }
  }
  
  public void bV(JSONObject paramJSONObject)
  {
    if (this.abC == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.hh.get();
    } while (localWebView == null);
    if (paramJSONObject == null)
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':0});");
      return;
    }
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':0,'result':" + paramJSONObject.toString() + "});");
  }
  
  public void dsB()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onPermissionDenied");
    }
    if (this.abC == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.hh.get();
    } while (localWebView == null);
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':2,'result':'Permission denied'})");
  }
  
  public long hX()
  {
    return this.abC;
  }
  
  @Deprecated
  public void onComplete(Object paramObject)
  {
    if (this.abC == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.hh.get();
    } while (localWebView == null);
    if (paramObject == null)
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':0});");
      return;
    }
    if (((paramObject instanceof Number)) || ((paramObject instanceof Boolean))) {}
    for (paramObject = paramObject.toString();; paramObject = "'" + paramObject.toString().replace("\\", "\\\\").replace("'", "\\'") + "'")
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':0,'result':" + paramObject + "});");
      return;
    }
  }
  
  public void onError(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onNoMatchMethod");
    }
    if (this.abC == -1L) {}
    WebView localWebView;
    do
    {
      return;
      localWebView = (WebView)this.hh.get();
    } while (localWebView == null);
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.abC + ",{'r':1,'result':'" + paramString + "'})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.JsBridgeListener
 * JD-Core Version:    0.7.0.1
 */