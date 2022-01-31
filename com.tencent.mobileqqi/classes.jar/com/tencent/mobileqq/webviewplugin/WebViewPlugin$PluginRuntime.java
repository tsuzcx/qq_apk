package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

public class WebViewPlugin$PluginRuntime
{
  private WeakReference a;
  private WeakReference b;
  private WeakReference c;
  
  public WebViewPlugin$PluginRuntime(WebView paramWebView, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.a = new WeakReference(paramWebView);
    this.c = new WeakReference(paramActivity);
    this.b = new WeakReference(paramAppInterface);
  }
  
  public Activity a()
  {
    return (Activity)this.c.get();
  }
  
  public AppInterface a()
  {
    return (AppInterface)this.b.get();
  }
  
  public WebView a()
  {
    return (WebView)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime
 * JD-Core Version:    0.7.0.1
 */