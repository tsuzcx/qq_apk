package com.tencent.mobileqq.fragment;

import acfp;
import ahob;
import ahoc;
import ahod;
import ahoe;
import ahpb;
import ajrb;
import ajrk;
import ajvd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aqiw;
import aqyg;
import ardn;
import auuw;
import auuw.a;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jml;
import mqq.manager.TicketManager;

public class NowLiveFragment
  extends NearbyBaseFragment
  implements View.OnClickListener
{
  public static String aWM = "";
  private static boolean chM;
  private static final Runnable gz = new NowLiveFragment.6();
  public NearbyActivity a;
  public NowLiveWebView a;
  auuw b;
  public CookieManager b;
  public String bKW = "";
  public String bLd = "https://now.qq.com/qq/nearby/live.html?_wv=16777219&_bid=2452&from=50036";
  public String bLe = "https://now.qq.com/qq/nearby/user.html?_wv=3&_bid=2452&from=50036";
  public String bLf = "https://now.qq.com/qq/nearby/help.html?_wv=3&_bid=2452&from=50036";
  boolean chz = false;
  public RefreshView e;
  String[] fk = { acfp.m(2131709200), acfp.m(2131709199), acfp.m(2131709198) };
  int[] lu = { 2130842166, 2130842167, 2130842165 };
  public View mLoadingView;
  ArrayList<Rect> wV = new ArrayList();
  
  void a(Activity paramActivity, NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("NowLiveFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView, paramActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView == null) && (paramActivity != null) && (paramNearbyAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView = new NowLiveWebView(paramActivity.getBaseContext(), paramActivity, paramNearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          paramActivity = new Intent();
          paramActivity.putExtra("url", NearbyActivity.aOq);
          WebAccelerateHelper.getInstance().preGetKey(paramActivity, paramNearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  public aqyg b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView;
  }
  
  public void c(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    int i = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().GC() + 1;
    if (paramSosoLbsInfo != null)
    {
      this.bKW = ("&latitude=" + paramSosoLbsInfo.a.cd + "&longitude=" + paramSosoLbsInfo.a.ce);
      str = paramSosoLbsInfo.a.city;
      paramSosoLbsInfo = paramSosoLbsInfo.a.province;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramSosoLbsInfo))) {
        this.bKW = (this.bKW + "&city=" + str + "&province=" + paramSosoLbsInfo);
      }
    }
    else if (i != -1)
    {
      paramSosoLbsInfo = new StringBuilder().append(this.bKW).append("&gender=");
      if (i != 2) {
        break label284;
      }
    }
    label284:
    for (i = 2;; i = 1)
    {
      this.bKW = i;
      if ((aWM == null) || (aWM.length() <= 0)) {
        break label289;
      }
      this.jdField_b_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + aWM);
      if (QLog.isColorLevel()) {
        QLog.i("NowLiveFragment", 2, "now.qq.com pskey : " + aWM);
      }
      CookieSyncManager.getInstance().sync();
      init();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("NowLiveFragment", 2, "onLocFinish, city or province is empty");
      break;
    }
    label289:
    if (this.jdField_b_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com") != null)
    {
      paramSosoLbsInfo = this.jdField_b_of_type_ComTencentSmttSdkCookieManager.getCookie("now.qq.com");
      if (QLog.isColorLevel()) {
        QLog.i("NowLiveFragment", 2, "now.qq.com cookie : " + paramSosoLbsInfo);
      }
      if (paramSosoLbsInfo.contains("p_skey"))
      {
        init();
        return;
      }
    }
    aWM = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
    long l = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
    if ((aWM != null) && (aWM.length() > 0) && (System.currentTimeMillis() - l < 21600000L))
    {
      this.jdField_b_of_type_ComTencentSmttSdkCookieManager.setCookie("now.qq.com", "p_skey=" + aWM);
      CookieSyncManager.getInstance().sync();
      init();
      return;
    }
    paramSosoLbsInfo = new NowLiveFragment.2(this);
    this.mHandler.postDelayed(paramSosoLbsInfo, 2000L);
    paramSosoLbsInfo = (TicketManager)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(2);
    String str = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
    ahoc localahoc = new ahoc(this);
    paramSosoLbsInfo.GetPskey(str, 16L, new String[] { "now.qq.com" }, localahoc);
  }
  
  public void ckW()
  {
    super.ckW();
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.getWebView();
    if (localCustomWebView != null)
    {
      str = WebViewPlugin.toJsScript("onPageSelected", null, null);
      localCustomWebView.callJs(str);
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveFragment", 2, "onPageSelected:" + str);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("NowLiveFragment", 2, "onPageSelected, webView==null");
  }
  
  public void cuB()
  {
    int i = 0;
    this.jdField_a_of_type_Ahpb.a(acfp.m(2131709202)).a(false).a(this).refresh();
    ArrayList localArrayList = new ArrayList();
    while (i < this.fk.length)
    {
      auuw.a locala = new auuw.a();
      locala.id = i;
      locala.title = this.fk[i];
      locala.contentDescription = this.fk[i];
      locala.iconId = this.lu[i];
      localArrayList.add(locala);
      i += 1;
    }
    this.jdField_b_of_type_Auuw = auuw.a(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, localArrayList, new ahoe(this));
  }
  
  public void doL()
  {
    if (getActivity() == null) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
      QLog.e("NowLiveFragment", 1, "ACCESS_FINE_LOCATION permission not granted!");
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        SosoInterface.a(new ahob(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab"));
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
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveFragment", 2, "startLocation start" + System.currentTimeMillis());
      }
      doL();
    }
  }
  
  public void init()
  {
    if ((this.mIsInited) || (this.rootView == null)) {}
    do
    {
      long l;
      do
      {
        return;
        l = 0L;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
          l = System.currentTimeMillis();
        }
        this.mIsInited = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.mIsInit) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.init();
        }
        if (this.e != null)
        {
          this.e.setDelayBeforeScrollBack(800L);
          this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.mWebview.setOnOverScrollHandler(this.e);
          this.e.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.atY) && (this.mLoadingView != null)) {
          this.mLoadingView.setVisibility(8);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gt = (System.currentTimeMillis() - l);
    } while (!QLog.isDevelopLevel());
    ajrk.f("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gt) });
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Auuw != null) {
        if (!this.jdField_b_of_type_Auuw.isShowing()) {
          this.jdField_b_of_type_Auuw.showAtLocation(this.rootView, 53, this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131299275), this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131299628) + this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDimensionPixelSize(2131298746));
        } else {
          this.jdField_b_of_type_Auuw.dismiss();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_b_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
    this.jdField_b_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
    CookieSyncManager.createInstance(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.at(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null)
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gq = l;
    }
    if (QLog.isColorLevel()) {
      ajrk.m("NowLiveFragment", new Object[] { "mNowOnCreateMilliTimeStamp", Long.valueOf(l) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gr == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gr = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gq);
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gr) });
      }
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.rootView == null)
    {
      this.rootView = paramLayoutInflater.inflate(2131559684, null);
      this.mLoadingView = this.rootView.findViewById(2131368640);
      this.e = ((RefreshView)this.rootView.findViewById(2131382153));
    }
    paramLayoutInflater = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("nearByTabUrl", "");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyActivity.nearByTabUrl frg", 4, paramLayoutInflater);
    }
    if (!paramLayoutInflater.equals(""))
    {
      NearbyActivity.aOq = paramLayoutInflater;
      this.bLd = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_startLive", "");
      this.bLe = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_personalCenter", "");
      this.bLf = this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("menuCell_help", "");
    }
    this.jdField_a_of_type_Ahpb.b(getString(2131696191)).a(false);
    this.e.setOnRefreshListener(new ahod(this));
    if ((this.chA) && (!this.mIsInited)) {
      doL();
    }
    cuB();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gs == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gs = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        ajrk.f("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gs) });
      }
    }
    if (!this.chz)
    {
      paramLayoutInflater = new Rect();
      paramLayoutInflater.top = 0;
      paramLayoutInflater.bottom = ((int)(315.0F * this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDisplayMetrics().density));
      this.wV.add(paramLayoutInflater);
    }
    paramLayoutInflater = this.rootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.mIsInited) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.mIsInited) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.mIsInited) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment$NowLiveWebView.onResume();
    } while (aqiw.isNetworkAvailable(getActivity()));
    QQToast.a(getActivity(), 1, acfp.m(2131709204), 0).show(getActivity().getTitleBarHeight());
  }
  
  public final class NowLiveWebView
    extends aqyg
    implements TouchWebView.OnScrollChangedListener
  {
    public boolean atY;
    boolean avR = false;
    public int dae;
    public boolean mIsInit;
    
    public NowLiveWebView(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
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
      if (NowLiveFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
      for (long l = System.currentTimeMillis();; l = 0L)
      {
        this.mIsInit = true;
        jml.a();
        this.mUrl = (NearbyActivity.aOq + NowLiveFragment.this.bKW + "&_t=" + System.currentTimeMillis() + ajrb.mq(ajrb.xz()));
        this.mWebview = new TouchWebView(this.mContext);
        this.mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
        buildBaseWebView(this.mInterface);
        this.avR = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
        if (this.avR) {
          this.mWebview.setMask(true);
        }
        this.mWebview.setBackgroundColor(-1);
        this.mWebview.setOnScrollChangedListener(this);
        setmTimeBeforeLoadUrl(System.currentTimeMillis());
        if (QLog.isDevelopLevel()) {
          ajrk.f("WebSpeedTrace", "AbsWebView mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.mTimeBeforeLoadUrl) });
        }
        this.mWebview.loadUrl(this.mUrl);
        if (QLog.isColorLevel()) {
          ajrk.m("AbsWebView", new Object[] { "NowLiveWebView.init", this.mUrl });
        }
        if ((NowLiveFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (NowLiveFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gu == 0L))
        {
          NowLiveFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gu = (System.currentTimeMillis() - l);
          if (QLog.isDevelopLevel()) {
            ajrk.f("WebSpeedTrace", "AbsWebView mInitWebViewTime", new Object[] { Long.valueOf(NowLiveFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gu) });
          }
        }
        if (NowLiveFragment.chM) {
          break;
        }
        NowLiveFragment.this.mHandler.postDelayed(NowLiveFragment.gz, 5000L);
        return;
      }
    }
    
    public void onDestroy()
    {
      super.doOnDestroy();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (NowLiveFragment.this.jdField_a_of_type_Ahpb != null)
      {
        NowLiveFragment.this.jdField_a_of_type_Ahpb.b(false).Kv(true);
        NowLiveFragment.this.jdField_a_of_type_Ahpb.refresh();
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      this.atY = true;
      if (NowLiveFragment.this.jdField_a_of_type_Ahpb != null)
      {
        NowLiveFragment.this.jdField_a_of_type_Ahpb.b(true).Kv(true);
        NowLiveFragment.this.jdField_a_of_type_Ahpb.refresh();
      }
      if ((NowLiveFragment.this.mLoadingView != null) && (NowLiveFragment.this.mLoadingView.getVisibility() != 8)) {
        NowLiveFragment.this.mLoadingView.setVisibility(8);
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
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      boolean bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
      if ((paramString.startsWith("tmast://")) || (paramString.startsWith("tnow://")))
      {
        paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramWebView.addFlags(268435456);
        NowLiveFragment.this.startActivity(paramWebView);
      }
      return bool;
    }
    
    public class NowLiveTouchWebView
      extends TouchWebView
    {
      public NowLiveTouchWebView(Context paramContext)
      {
        super();
      }
      
      public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
      {
        boolean bool = super.onTouchEvent(paramMotionEvent, paramView);
        int j = paramMotionEvent.getAction();
        float f = paramMotionEvent.getY();
        f = NowLiveFragment.NowLiveWebView.this.dae + f;
        paramMotionEvent = NowLiveFragment.this.wV.iterator();
        do
        {
          if (!paramMotionEvent.hasNext()) {
            break;
          }
          paramView = (Rect)paramMotionEvent.next();
        } while ((f <= paramView.top) || (f >= paramView.bottom));
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            if (j != 0) {
              break label130;
            }
            paramMotionEvent = (ViewGroup)getParent();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              if (QLog.isDevelopLevel()) {
                QLog.e("CustomWebView", 4, "NowLiveFrgmentWebView onTouchEvent action down requestDisallowInterceptTouchEvent true");
              }
            }
          }
          label130:
          do
          {
            do
            {
              do
              {
                return bool;
              } while ((j != 3) && (j != 1));
              paramMotionEvent = (ViewGroup)getParent();
            } while (paramMotionEvent == null);
            paramMotionEvent.requestDisallowInterceptTouchEvent(false);
          } while (!QLog.isDevelopLevel());
          QLog.e("CustomWebView", 4, "NowLiveFrgmentWebView onTouchEvent action cancel or up requestDisallowInterceptTouchEvent false");
          return bool;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment
 * JD-Core Version:    0.7.0.1
 */