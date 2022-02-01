package com.tencent.mobileqq.fragment;

import acfp;
import ahmz;
import ahna;
import ahpb;
import ajrk;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aqiw;
import aqmj;
import aqyg;
import ardn;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import jml;

public class HotChatFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public NearbyActivity a;
  public HotChatWebView a;
  BroadcastReceiver bj = new ahna(this);
  public boolean chz = false;
  public RefreshView e;
  View.OnClickListener fj;
  BroadcastReceiver mBroadcastReceiver = new ahmz(this);
  public View mLoadingView;
  public ArrayList<Rect> wV = new ArrayList();
  
  public HotChatFragment()
  {
    this.tabID = 2;
    if (QLog.isColorLevel()) {
      ajrk.m("HotChatFragment", new Object[] { "HotChatFragment" });
    }
  }
  
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
  
  public void H(View.OnClickListener paramOnClickListener)
  {
    this.fj = paramOnClickListener;
    if ((this.zw) && (this.isResume)) {
      doM();
    }
  }
  
  void a(Activity paramActivity, NearbyAppInterface paramNearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        ajrk.f("HotChatFragment", "createWebView", new Object[] { this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView, paramActivity, paramNearbyAppInterface });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) && ((paramActivity instanceof NearbyActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity = ((NearbyActivity)paramActivity);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView == null) && (paramActivity != null) && (paramNearbyAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView = new HotChatWebView(paramActivity.getBaseContext(), paramActivity, paramNearbyAppInterface);
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
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      init();
    }
  }
  
  void init()
  {
    if ((this.mIsInited) || (this.rootView == null)) {}
    for (;;)
    {
      return;
      long l = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
        l = System.currentTimeMillis();
      }
      this.mIsInited = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.mIsInit)
      {
        this.mHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.init();
      }
      if (this.e != null)
      {
        this.e.setDelayBeforeScrollBack(800L);
        this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.mWebview.setOnOverScrollHandler(this.e);
        this.e.addView(this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.atY) && (this.mLoadingView != null)) {
        this.mLoadingView.setVisibility(8);
      }
      try
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.refresh_hot_chat_list");
        this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.registerReceiver(this.mBroadcastReceiver, localIntentFilter);
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.get_banner_rect");
        this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.registerReceiver(this.bj, localIntentFilter);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime = (System.currentTimeMillis() - l);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        ajrk.f("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitTime) });
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.at(this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent());
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
        ajrk.m("HotChatFragment", new Object[] { "onCreateView", Long.valueOf(l) });
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
      if ((this.chA) && (!this.mIsInited)) {
        init();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv == 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          ajrk.f("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gv) });
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
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.mIsInited) {
      return;
    }
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.unregisterReceiver(this.mBroadcastReceiver);
      this.jdField_b_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.unregisterReceiver(this.bj);
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.mIsInited) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.mIsInited) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment$HotChatWebView.onResume();
    } while (aqiw.isNetworkAvailable(getActivity()));
    QQToast.a(getActivity(), 1, acfp.m(2131707205), 0).show(getActivity().getTitleBarHeight());
  }
  
  public final class HotChatWebView
    extends aqyg
    implements TouchWebView.OnScrollChangedListener
  {
    public boolean atY;
    boolean avR = false;
    public int dae;
    public boolean mIsInit;
    
    public HotChatWebView(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
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
      if (HotChatFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
      for (long l = System.currentTimeMillis();; l = 0L)
      {
        this.mIsInit = true;
        jml.a();
        this.mUrl = aqmj.V(this.mContext, HotChatFragment.this.b.getCurrentAccountUin());
        this.mWebview = new HotChatTouchWebView(this.mContext);
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
        if ((HotChatFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) || (HotChatFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw != 0L)) {
          break;
        }
        HotChatFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw = (System.currentTimeMillis() - l);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        ajrk.f("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(HotChatFragment.this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.Gw) });
        return;
      }
    }
    
    public void onDestroy()
    {
      super.doOnDestroy();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (HotChatFragment.this.jdField_a_of_type_Ahpb != null)
      {
        HotChatFragment.this.jdField_a_of_type_Ahpb.b(false).Kv(true);
        HotChatFragment.this.jdField_a_of_type_Ahpb.refresh();
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      this.atY = true;
      if (HotChatFragment.this.jdField_a_of_type_Ahpb != null)
      {
        HotChatFragment.this.jdField_a_of_type_Ahpb.b(true).Kv(true);
        HotChatFragment.this.jdField_a_of_type_Ahpb.refresh();
      }
      if ((HotChatFragment.this.mLoadingView != null) && (HotChatFragment.this.mLoadingView.getVisibility() != 8)) {
        HotChatFragment.this.mLoadingView.setVisibility(8);
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
    
    public class HotChatTouchWebView
      extends TouchWebView
    {
      public HotChatTouchWebView(Context paramContext)
      {
        super();
      }
      
      public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
      {
        boolean bool = super.onTouchEvent(paramMotionEvent, paramView);
        int j = paramMotionEvent.getAction();
        float f = paramMotionEvent.getY();
        f = HotChatFragment.HotChatWebView.this.dae + f;
        paramMotionEvent = HotChatFragment.this.wV.iterator();
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
                QLog.e("HotChatFragment", 4, "HotChatFrgmentWebView onTouchEvent action down requestDisallowInterceptTouchEvent true");
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
          QLog.e("HotChatFragment", 4, "HotChatFrgmentWebView onTouchEvent action cancel or up requestDisallowInterceptTouchEvent false");
          return bool;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.HotChatFragment
 * JD-Core Version:    0.7.0.1
 */