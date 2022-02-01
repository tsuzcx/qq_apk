package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import anot;
import aobh;
import aocc;
import araz;
import arbf;
import arbs;
import arbz;
import arcd.a;
import arcn.a;
import arcp;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import jqo;

public class UnVisibleWebViewFragment
  extends WebViewFragment
{
  private aocc a;
  
  private void VS(String paramString)
  {
    CookieManager.getInstance().setCookie(".docs.qq.com", "preloading_id=" + aobh.nP(paramString));
    CookieSyncManager.createInstance(BaseApplicationImpl.getApplication());
    CookieSyncManager.getInstance().sync();
  }
  
  public static WebViewFragment b(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new UnVisibleWebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  public aocc a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Arcd$a.Ds & 0x40) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Aocc = new aocc(this.mApp, super.getActivity(), this, this.intent, bool1);
      this.jdField_a_of_type_Aocc.setSonicClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      TouchWebView localTouchWebView = this.jdField_a_of_type_Aocc.a();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
      }
      this.mPluginEngine.e(localTouchWebView);
      localTouchWebView.setPluginEngine(this.mPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        arbz localarbz = this.jdField_a_of_type_Arbz;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).flag) {
          bool1 = true;
        }
        localarbz.cXY = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.aMX = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.avR) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.jdField_a_of_type_Aocc;
    }
  }
  
  public void aCP()
  {
    jqo.le("Web_readyToLoadUrl");
    if (this.j == null) {
      return;
    }
    aBA();
    if ((this.jdField_a_of_type_Arbz.cXQ) && (this.jdField_a_of_type_Arbz.auw > 0L))
    {
      anot.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Arbz.auw) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Arbz.flag);
      this.jdField_a_of_type_Arbz.auw = 0L;
    }
    this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl = System.currentTimeMillis();
    long l = this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl;
    l = this.jdField_a_of_type_Arbz.mClickTime;
    VS(this.mUrl);
    if (!TextUtils.isEmpty(this.mUrl))
    {
      QLog.i("WebLog_WebViewFragment", 1, "tendocpreload , UnVisibleWebViewFragment  preload =" + this.j);
      this.j.loadUrl(this.mUrl);
    }
    jqo.lf("Web_readyToLoadUrl");
    this.jdField_a_of_type_Arbz.a(this.j, this.mUrl, 0, 0, 0, 0, 0, null);
  }
  
  void bVW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    arbz localarbz = this.jdField_a_of_type_Arbz;
    this.isDestroyed = true;
    localarbz.isDestroyed = true;
    if (this.jdField_a_of_type_Aocc != null)
    {
      this.jdField_a_of_type_Aocc.destroy();
      this.jdField_a_of_type_Aocc = null;
      this.j = null;
    }
    this.mApp = null;
  }
  
  protected void initWebView()
  {
    int i = -1;
    long l1;
    long l2;
    if (this.j == null)
    {
      this.j = a(null).a();
      this.j.getView().setOnTouchListener(this);
      this.j.setOnLongClickListener(new a());
      l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x10000) == 0L) {
        break label434;
      }
      i = 2;
      if (AppSetting.aNT) {
        i = 2;
      }
      this.j.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i);
      }
      this.j.getSettings().setAllowFileAccessFromFileURLs(false);
      this.j.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Arbz.auz = (l2 - l1);
      this.jdField_a_of_type_Arbz.auY = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.jdField_a_of_type_Arbz.auz);
      }
      l2 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.j.getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        break label489;
      }
      i = 1;
      label228:
      if (i == 0) {
        break label518;
      }
      Bundle localBundle = arcp.v();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      if (!this.jdField_a_of_type_Arbz.isWebViewCache) {
        break label494;
      }
      l1 = 2L;
      if (!(this.j instanceof SwiftReuseTouchWebView)) {
        break label542;
      }
      if (1 != ((SwiftReuseTouchWebView)this.j).flag) {
        break label513;
      }
      i = 1;
    }
    for (;;)
    {
      label295:
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(arcn.a.avr) }));
      }
      System.currentTimeMillis();
      this.j.reportInitPerformance(l1, i, this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, arcn.a.avr);
      System.currentTimeMillis();
      this.jdField_a_of_type_Arbz.eeh = 2;
      label513:
      label518:
      for (this.jdField_a_of_type_Arbz.czr = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.jdField_a_of_type_Arbz.czr = String.valueOf(Build.VERSION.SDK_INT))
      {
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l1 - l2));
        }
        return;
        label434:
        switch (this.intent.getIntExtra("reqType", -1))
        {
        case 2: 
        case 3: 
        default: 
          break;
        case 1: 
          i = 2;
          break;
        case 4: 
          i = 0;
          break;
          label489:
          i = 0;
          break label228;
          label494:
          if (arbz.aeo) {}
          for (i = 1;; i = 0)
          {
            l1 = i;
            break;
          }
          i = 0;
          break label295;
          this.jdField_a_of_type_Arbz.eeh = 1;
        }
      }
      label542:
      i = 0;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setVisibility(8);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bVW();
  }
  
  class a
    implements View.OnLongClickListener
  {
    a() {}
    
    public boolean onLongClick(View paramView)
    {
      if (!UnVisibleWebViewFragment.this.jdField_a_of_type_Arbs.J("web_view_long_click", true))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
        }
        return true;
      }
      if (!UnVisibleWebViewFragment.this.jdField_a_of_type_Arbs.J("image_long_click", false))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
        }
        return false;
      }
      arbf localarbf = (arbf)UnVisibleWebViewFragment.this.jdField_a_of_type_Araz.q(8);
      if ((localarbf != null) && (localarbf.U(paramView))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment
 * JD-Core Version:    0.7.0.1
 */