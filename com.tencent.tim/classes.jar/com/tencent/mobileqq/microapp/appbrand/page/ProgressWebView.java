package com.tencent.mobileqq.microapp.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import aqyg;
import aqyx;
import aqza;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.widget.ProgressView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import rpq;

public class ProgressWebView
  extends TouchWebView
{
  public int htmlId;
  public aqyx mWebViewDirector;
  
  public ProgressWebView(Context paramContext)
  {
    super(paramContext);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setUserAgent(localWebSettings.getUserAgentString() + "QQ/MicroApp/H5");
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setPluginState(WebSettings.PluginState.ON);
    localWebSettings.setPluginsEnabled(true);
    localWebSettings.setAllowContentAccess(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      localWebSettings.setMixedContentMode(0);
    }
    try
    {
      requestFocus();
      label116:
      init(paramContext);
      return;
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  private void init(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof MutableContextWrapper))
      {
        BaseActivity localBaseActivity = (BaseActivity)((MutableContextWrapper)paramContext).getBaseContext();
        if (localBaseActivity != null)
        {
          this.mWebViewDirector = new aqyx(new MiniAppWebviewBuilder(paramContext, localBaseActivity, localBaseActivity.getAppInterface(), this));
          this.mWebViewDirector.a(null, localBaseActivity.app, localBaseActivity.getIntent());
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public static class MiniAppWebviewBuilder
    extends aqyg
    implements aqza
  {
    ProgressView progressView;
    
    public MiniAppWebviewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
    {
      super(paramActivity, paramAppInterface);
      this.mWebview = paramTouchWebView;
    }
    
    public void buildBottomBar() {}
    
    public void buildContentView(Bundle paramBundle) {}
    
    public void buildData() {}
    
    public void buildLayout()
    {
      this.progressView = new ProgressView(this.mWebview.getContext());
      this.progressView.setLayoutParams(new ViewGroup.LayoutParams(-1, rpq.dip2px(this.mWebview.getContext(), 3.0F)));
      this.progressView.b(Color.parseColor("#12B7F5"));
      this.mWebview.addView(this.progressView);
    }
    
    public void buildTitleBar() {}
    
    public void buildWebView(AppInterface paramAppInterface)
    {
      super.buildBaseWebView(paramAppInterface);
    }
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        this.progressView.setVisibility(8);
      }
      for (;;)
      {
        super.onProgressChanged(paramWebView, paramInt);
        return;
        this.progressView.a(paramInt);
      }
    }
    
    public void preInitWebviewPlugin() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ProgressWebView
 * JD-Core Version:    0.7.0.1
 */