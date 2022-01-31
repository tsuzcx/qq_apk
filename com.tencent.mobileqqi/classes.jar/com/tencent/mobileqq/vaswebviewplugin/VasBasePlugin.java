package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;

public abstract class VasBasePlugin
  extends WebViewPlugin
{
  protected long business;
  public long onPageFinishedTime = -1L;
  public long onPageStartedTime = -1L;
  public long startOpenPageTime;
  
  protected Intent getInfoIntent()
  {
    if (this.mRuntime.a() != null) {
      return this.mRuntime.a().getIntent();
    }
    return new Intent();
  }
  
  protected long getPluginBusiness()
  {
    return 0L;
  }
  
  protected void onCreate()
  {
    this.startOpenPageTime = this.mRuntime.a().getIntent().getLongExtra("startOpenPageTime", 0L);
    this.business = this.mRuntime.a().getIntent().getLongExtra("business", 0L);
  }
  
  protected boolean shouldGetBusiness()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
 * JD-Core Version:    0.7.0.1
 */