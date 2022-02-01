package com.tencent.mobileqq.fragment;

import acfp;
import ahmr;
import ahms;
import ahpb;
import ajrk;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import aqiw;
import aqmj;
import aqyg;
import ardn;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Map;
import jml;

public class CommonTabFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public NearbyActivity a;
  public a a;
  public String bKW = "";
  public RefreshView e;
  View.OnClickListener fj;
  public View mLoadingView;
  
  private void doM()
  {
    if (this.fj != null) {
      this.jdField_a_of_type_Ahpb.a(getString(2131701388)).a(this.fj);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahpb.refresh();
      return;
      this.jdField_a_of_type_Ahpb.a("").a(null);
    }
  }
  
  void a(Activity paramActivity, NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("CommonTabFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a, paramActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a == null) && (paramActivity != null) && (paramNearbyAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a = new a(paramActivity.getBaseContext(), paramActivity, paramNearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("url", aqmj.V(paramActivity, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()));
          WebAccelerateHelper.getInstance().preGetKey(localIntent, paramNearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean a(long paramLong, Map<String, Object> paramMap, int paramInt1, int paramInt2, Intent paramIntent)
  {
    CustomWebView localCustomWebView;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a != null) {
      localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.getWebView();
    }
    while (localCustomWebView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.onResume();
      WebViewPluginEngine localWebViewPluginEngine = localCustomWebView.getPluginEngine();
      if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.handleEvent(localCustomWebView.getUrl(), paramLong, paramMap)))
      {
        return true;
        localCustomWebView = null;
      }
      else
      {
        int i = paramInt2 >> 8 & 0xFF;
        if (i > 0)
        {
          if ((localCustomWebView != null) && (localWebViewPluginEngine != null))
          {
            if ((paramIntent != null) && (paramIntent.hasExtra("entryId")) && (localWebViewPluginEngine.b("card") == null)) {
              localWebViewPluginEngine.aa(new String[] { "card" });
            }
            paramMap = localWebViewPluginEngine.a(i, true);
            if (paramMap != null)
            {
              paramMap.onActivityResult(paramIntent, (byte)(paramInt2 & 0xFF), paramInt1);
              return true;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.w("CommonTabFragment", 2, "Caution! activity result not handled!");
          }
        }
      }
    }
    return false;
  }
  
  public aqyg b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a;
  }
  
  public void c(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo != null) {
      if (TextUtils.isEmpty(paramSosoLbsInfo.a.cityCode)) {
        break label126;
      }
    }
    label126:
    for (int i = 0;; i = 1)
    {
      this.bKW = ("latitude=" + paramSosoLbsInfo.a.cd + "&longitude=" + paramSosoLbsInfo.a.ce + "&areaStat=" + i + "&code=" + paramSosoLbsInfo.a.cityCode);
      if (QLog.isDevelopLevel()) {
        QLog.i("CommonTabFragment", 4, " nearbyTabLocParams = " + this.bKW);
      }
      init();
      return;
    }
  }
  
  public void ckW()
  {
    super.ckW();
  }
  
  public void doL()
  {
    if (getActivity() == null) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
      QLog.e("CommonTabFragment", 1, "ACCESS_FINE_LOCATION permission not granted!");
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        SosoInterface.a(new ahmr(this, 3, true, false, 30000L, true, false, "NearbyNowliveTab"));
        return;
      }
      init();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.needLoc == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CommonTabFragment", 2, "startLocation start" + System.currentTimeMillis());
        }
        doL();
      }
      else
      {
        init();
      }
    }
  }
  
  public void init()
  {
    if ((this.mIsInited) || (this.rootView == null)) {}
    do
    {
      return;
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
        l = System.currentTimeMillis();
      }
      this.mIsInited = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.mIsInit)
      {
        this.mHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.init();
      }
      if (this.e != null)
      {
        this.e.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.mWebview.setOnOverScrollHandler(this.e);
        this.e.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.atY) && (this.mLoadingView != null)) {
        this.mLoadingView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          ajrk.f("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime) });
        }
      }
    } while ((!(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity instanceof NearbyActivity)) || (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a == null));
    this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.centerView.setClickable(true);
    ((NearbyActivity)this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity).u(new ahms(this));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp) });
      }
    }
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.at(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.onCreateTime) });
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (QLog.isColorLevel()) {
        ajrk.m("CommonTabFragment", new Object[] { "onCreateView", Long.valueOf(l) });
      }
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (this.rootView == null)
      {
        this.rootView = paramLayoutInflater.inflate(2131559684, null);
        this.e = ((RefreshView)this.rootView.findViewById(2131382153));
        this.mLoadingView = this.rootView.findViewById(2131368640);
      }
      this.jdField_a_of_type_Ahpb.b(getString(2131696191)).a(false);
      doM();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.needLoc == 1)) {
        if ((this.chA) && (!this.mIsInited)) {
          doL();
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv == 0L))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv = (System.currentTimeMillis() - l);
          if (QLog.isDevelopLevel()) {
            ajrk.f("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv) });
          }
        }
        paramLayoutInflater = this.rootView;
        V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
        return paramLayoutInflater;
        init();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.mIsInited) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.mIsInited) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.mIsInited) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment$a.onResume();
    } while (aqiw.isNetworkAvailable(getActivity()));
    QQToast.a(getActivity(), 1, acfp.m(2131704244), 0).show(getActivity().getTitleBarHeight());
  }
  
  public final class a
    extends aqyg
    implements TouchWebView.OnScrollChangedListener
  {
    public boolean atY;
    boolean avR = false;
    public int dae;
    public boolean mIsInit;
    
    public a(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
    {
      super(paramActivity, paramAppInterface);
      super.preInitPluginEngine();
    }
    
    public void at(Intent paramIntent)
    {
      super.doOnCreate(paramIntent);
    }
    
    public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
    {
      if (paramArrayList != null) {
        paramArrayList.add(new ardn());
      }
    }
    
    public void init()
    {
      if (this.mIsInit) {
        return;
      }
      if (CommonTabFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
      for (long l = System.currentTimeMillis();; l = 0L)
      {
        this.mIsInit = true;
        jml.a();
        if (CommonTabFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo != null) {
          this.mUrl = CommonTabFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity$TabInfo.tabUrl;
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
          if (!this.mUrl.contains("?")) {
            break label351;
          }
        }
        label351:
        for (this.mUrl += "&";; this.mUrl += "?")
        {
          this.mUrl += CommonTabFragment.this.bKW;
          this.mWebview = new TouchWebView(this.mContext);
          buildBaseWebView(this.mInterface);
          this.avR = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
          if (this.avR) {
            this.mWebview.setMask(true);
          }
          this.mWebview.setBackgroundColor(-1);
          this.mWebview.setOnScrollChangedListener(this);
          setmTimeBeforeLoadUrl(System.currentTimeMillis());
          if (QLog.isDevelopLevel()) {
            ajrk.f("WebSpeedTrace", "mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.mTimeBeforeLoadUrl) });
          }
          this.mWebview.loadUrl(this.mUrl);
          if (QLog.isColorLevel()) {
            ajrk.m("AbsWebView", new Object[] { "HotChatWebView.init", this.mUrl });
          }
          if ((CommonTabFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) || (CommonTabFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw != 0L)) {
            break;
          }
          CommonTabFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw = (System.currentTimeMillis() - l);
          if (!QLog.isDevelopLevel()) {
            break;
          }
          ajrk.f("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(CommonTabFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw) });
          return;
        }
      }
    }
    
    public void onDestroy()
    {
      super.doOnDestroy();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (CommonTabFragment.this.jdField_a_of_type_Ahpb != null)
      {
        CommonTabFragment.this.jdField_a_of_type_Ahpb.b(false).Kv(true);
        CommonTabFragment.this.jdField_a_of_type_Ahpb.refresh();
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      this.atY = true;
      if (CommonTabFragment.this.jdField_a_of_type_Ahpb != null)
      {
        CommonTabFragment.this.jdField_a_of_type_Ahpb.b(true).Kv(true);
        CommonTabFragment.this.jdField_a_of_type_Ahpb.refresh();
      }
      if ((CommonTabFragment.this.mLoadingView != null) && (CommonTabFragment.this.mLoadingView.getVisibility() != 8)) {
        CommonTabFragment.this.mLoadingView.setVisibility(8);
      }
    }
    
    public void onPause()
    {
      super.doOnPause();
    }
    
    public void onResume()
    {
      super.doOnResume();
    }
    
    public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
    {
      if (this.mWebview != null) {
        this.dae = this.mWebview.getWebScrollY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CommonTabFragment
 * JD-Core Version:    0.7.0.1
 */