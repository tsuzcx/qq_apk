package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public abstract class VasBasePlugin
  extends WebViewPlugin
{
  protected long business;
  public long onPageFinishedTime = -1L;
  public long onPageStartedTime = -1L;
  public long startOpenPageTime;
  
  protected Intent getInfoIntent()
  {
    if ((this.mRuntime != null) && (this.mRuntime.getActivity() != null)) {
      return this.mRuntime.getActivity().getIntent();
    }
    return new Intent();
  }
  
  protected long getPluginBusiness()
  {
    return 0L;
  }
  
  public void onCreate()
  {
    this.startOpenPageTime = getInfoIntent().getLongExtra("startOpenPageTime", System.currentTimeMillis());
    this.business = getInfoIntent().getLongExtra("business", 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
 * JD-Core Version:    0.7.0.1
 */