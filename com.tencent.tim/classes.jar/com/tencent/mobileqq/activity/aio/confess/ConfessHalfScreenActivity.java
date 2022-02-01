package com.tencent.mobileqq.activity.aio.confess;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqzl;
import araz;
import araz.b;
import arcd;
import ardn;
import com.tencent.biz.ui.RefreshView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import wqt;
import wqu;
import wqv;

public class ConfessHalfScreenActivity
  extends QQBrowserActivity
{
  private BroadcastReceiver ak;
  private int mDstHeight;
  
  public ConfessHalfScreenActivity()
  {
    this.s = ConfessBrowserFragment.class;
  }
  
  public static void cbb()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167595);
    paramBundle = findViewById(2131363728);
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131167595);
    }
    this.mDstHeight = getIntent().getIntExtra("confessDstHeight", 0);
    if (this.mDstHeight <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_QQBrowserActivity", 2, "height==0");
      }
      finish();
    }
    if (this.ak == null) {
      this.ak = new wqt(this);
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
      registerReceiver(this.ak, paramBundle);
      return bool;
    }
    catch (Exception paramBundle)
    {
      QLog.e("WebLog_QQBrowserActivity", 1, "register mFinishReceiver receiver exception.");
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    try
    {
      if (this.ak != null)
      {
        unregisterReceiver(this.ak);
        this.ak = null;
      }
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebLog_QQBrowserActivity", 2, "doOnDestroy mFinishReceiver unregisterReceiver, e:" + localException.getMessage());
        }
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.executeOnSubThread(new ConfessHalfScreenActivity.2(this));
    new Handler().postDelayed(new ConfessHalfScreenActivity.3(this), 200L);
  }
  
  public static class ConfessBrowserFragment
    extends WebViewFragment
  {
    private boolean bfv;
    private int dstHeight;
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      this.jdField_a_of_type_Aqzl.bC(false);
      this.jdField_a_of_type_Arcd.mLoadingProgressBar.setVisibility(8);
      return i;
    }
    
    public araz a()
    {
      return new araz(this, 127, new wqu(this));
    }
    
    public boolean doOnCreate(Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "ConfessBrowserFragment doOnCreate = ");
      }
      boolean bool = super.doOnCreate(paramBundle);
      this.mPluginEngine.aa(new String[] { "sayHonest", ardn.PLUGIN_NAMESPACE, "QQApi", "ui", "share", "PublicAccountJs" });
      return bool;
    }
    
    public int o(Bundle paramBundle)
    {
      this.jdField_a_of_type_Arcd$a.Dr = 0L;
      int i = super.o(paramBundle);
      super.getActivity().getWindow().setBackgroundDrawableResource(2131167595);
      if ((this.jdField_a_of_type_Arcd.eQ instanceof RefreshView)) {
        ((RefreshView)this.jdField_a_of_type_Arcd.eQ).uW(false);
      }
      if (this.jdField_a_of_type_Arcd.eG != null) {
        this.jdField_a_of_type_Arcd.eG.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.setBackgroundColor(0);
      return i;
    }
    
    public void onDestroy()
    {
      super.onDestroy();
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "ConfessBrowserFragment onReceivedError = ");
      }
      this.bfv = true;
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    
    public class a
      extends arcd
    {
      public a() {}
      
      public void aCR()
      {
        WebView localWebView;
        if (this.jdField_a_of_type_Araz$b.getWebView() != null)
        {
          localWebView = this.jdField_a_of_type_Araz$b.getWebView();
          localWebView.setId(2131382171);
          if (this.ees != -1) {
            localWebView.setBackgroundColor(this.ees);
          }
          Object localObject = (Activity)localWebView.getContext();
          if ((localObject instanceof ConfessHalfScreenActivity))
          {
            localObject = (ConfessHalfScreenActivity)localObject;
            ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment, ConfessHalfScreenActivity.a((ConfessHalfScreenActivity)localObject));
          }
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserUIStyleHandler", 2, "initWebViewInContentView height=" + ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment));
          }
          if (!(this.eQ instanceof RelativeLayout)) {
            break label171;
          }
          localObject = new RelativeLayout.LayoutParams(-1, ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment));
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.eQ.addView(localWebView, 0, (ViewGroup.LayoutParams)localObject);
        }
        for (;;)
        {
          this.eQ.setOnClickListener(new wqv(this));
          return;
          label171:
          this.eQ.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessHalfScreenActivity$ConfessBrowserFragment)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity
 * JD-Core Version:    0.7.0.1
 */