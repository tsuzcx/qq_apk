package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;

public class WebViewPlugin$PluginRuntime
{
  private WeakReference a;
  private WeakReference b;
  private WeakReference c;
  
  public WebViewPlugin$PluginRuntime(CustomWebView paramCustomWebView, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.a = new WeakReference(paramCustomWebView);
    this.c = new WeakReference(paramActivity);
    this.b = new WeakReference(paramAppInterface);
  }
  
  public Activity a()
  {
    return (Activity)this.c.get();
  }
  
  public CustomWebView a()
  {
    return (CustomWebView)this.a.get();
  }
  
  public AppInterface a()
  {
    return (AppInterface)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime
 * JD-Core Version:    0.7.0.1
 */