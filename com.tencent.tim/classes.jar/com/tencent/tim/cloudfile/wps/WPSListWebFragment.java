package com.tencent.tim.cloudfile.wps;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aqzl;
import atwl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.BinderWarpper;

public class WPSListWebFragment
  extends WebViewFragment
{
  private View Kz;
  private atwl jdField_a_of_type_Atwl;
  BinderWarpper jdField_a_of_type_ComTencentUtilBinderWarpper = null;
  private String aGC;
  private WebViewPlugin e;
  private String mUin;
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    this.e = this.mPluginEngine.b("wps");
    return i;
  }
  
  public int b(Bundle paramBundle)
  {
    int i = super.b(paramBundle);
    this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
    this.jdField_a_of_type_Aqzl.centerView.setText("WPS云文档");
    paramBundle = getResources().getDrawable(2130839410);
    paramBundle.setBounds(0, 0, (int)(paramBundle.getIntrinsicWidth() * 0.46D), (int)(paramBundle.getIntrinsicHeight() * 0.46D));
    this.jdField_a_of_type_Aqzl.centerView.setCompoundDrawables(paramBundle, null, null, null);
    this.jdField_a_of_type_Aqzl.rightViewImg.setOnClickListener(this);
    this.jdField_a_of_type_Aqzl.leftView.setOnClickListener(this);
    return i;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.aGC = paramBundle.getStringExtra("_nick_name_");
    this.mUin = paramBundle.getStringExtra("_uin_");
    this.jdField_a_of_type_ComTencentUtilBinderWarpper = ((BinderWarpper)paramBundle.getParcelableExtra("file_manager_provider"));
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.Kz.setVisibility(0);
      continue;
      if (this.Kz != null)
      {
        this.Kz.setVisibility(8);
        continue;
        this.Kz.setVisibility(8);
        this.e.dispatchJsEvent("switchAccount", null, null);
        continue;
        getHostActivity().finish();
        BrowserAppInterface localBrowserAppInterface = this.browserApp;
        BrowserAppInterface.IE(1);
        continue;
        getHostActivity().finish();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Atwl != null) {
      this.jdField_a_of_type_Atwl.unregisterCallback();
    }
    super.onDestroy();
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.jdField_a_of_type_Aqzl.setTitle("WPS云文档");
    paramWebView = getResources().getDrawable(2130839410);
    paramWebView.setBounds(0, 0, (int)(paramWebView.getIntrinsicWidth() * 0.46D), (int)(paramWebView.getIntrinsicHeight() * 0.46D));
    this.jdField_a_of_type_Aqzl.centerView.setCompoundDrawables(paramWebView, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.wps.WPSListWebFragment
 * JD-Core Version:    0.7.0.1
 */