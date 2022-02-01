package com.tencent.gdtad.api.interstitial;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import arhz;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityReverseLandscapeForTool;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import thi;
import thl;
import tho;
import thp;
import thr;
import thv;
import tkw;
import tls;

public final class GdtInterstitialFragment
  extends PublicBaseFragment
{
  private static Set<String> aX = new HashSet();
  private GdtInterstitialStatus jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus = new GdtInterstitialStatus();
  private thv jdField_a_of_type_Thv;
  private GdtInterstitialParams b;
  private arhz t;
  
  public static int a(Activity paramActivity, GdtInterstitialParams paramGdtInterstitialParams)
  {
    int j = 4;
    int i;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      i = j;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialFragment", String.format("start errorCode:%d", new Object[] { Integer.valueOf(i) }));
      return i;
      i = j;
      if (paramActivity != null)
      {
        i = j;
        if (paramGdtInterstitialParams != null)
        {
          i = j;
          if (paramGdtInterstitialParams.iD())
          {
            AdProcessManager.INSTANCE.getWebProcessName();
            Object localObject = null;
            if (paramGdtInterstitialParams.orientation == 1)
            {
              localObject = PublicTransFragmentActivityForTool.class;
              if (tho.a().aG(paramActivity))
              {
                localObject = PublicTransFragmentActivity.class;
                AdProcessManager.INSTANCE.getMainProcessName();
              }
            }
            for (;;)
            {
              i = j;
              if (localObject == null) {
                break;
              }
              if (!aX.contains(paramGdtInterstitialParams.getTraceId())) {
                break label157;
              }
              i = 2;
              break;
              if (paramGdtInterstitialParams.orientation == 0) {
                localObject = PublicTransFragmentActivityLandscapeForTool.class;
              } else if (paramGdtInterstitialParams.orientation == 8) {
                localObject = PublicTransFragmentActivityReverseLandscapeForTool.class;
              }
            }
            label157:
            aX.add(paramGdtInterstitialParams.getTraceId());
            Bundle localBundle = new Bundle();
            if ((paramGdtInterstitialParams.a.extra != null) && (!paramGdtInterstitialParams.a.extra.isEmpty())) {
              localBundle.putAll(paramGdtInterstitialParams.a.extra);
            }
            localBundle.putParcelable("interstitialParams", paramGdtInterstitialParams);
            localBundle.putLong("interstitialStartToShowTimeMillis", System.currentTimeMillis());
            localBundle.putString("interstitialProcessName", AdProcessManager.INSTANCE.getCurrentProcessName(paramActivity));
            paramGdtInterstitialParams = new Intent();
            paramGdtInterstitialParams.putExtra("public_fragment_window_feature", 1);
            paramGdtInterstitialParams.putExtras(localBundle);
            PublicFragmentActivity.b.startForResult(paramActivity, paramGdtInterstitialParams, (Class)localObject, GdtInterstitialFragment.class, 10001);
            i = 0;
          }
        }
      }
    }
  }
  
  private String getTraceId()
  {
    if ((this.b != null) && (this.b.iD())) {
      return this.b.getTraceId();
    }
    return null;
  }
  
  private void setLoading(boolean paramBoolean)
  {
    tkw.i("GdtInterstitialFragment", String.format("setLoading visible:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (paramBoolean) {
      if ((this.t == null) || (!this.t.isShowing())) {}
    }
    while ((paramBoolean) || (this.t == null))
    {
      return;
      this.t = new arhz(getActivity(), getResources().getDimensionPixelSize(2131299627));
      this.t.setCancelable(false);
      this.t.setMessage(acfp.m(2131706872) + "加载");
      this.t.show();
      return;
    }
    if (this.t.isShowing()) {}
    try
    {
      this.t.dismiss();
      this.t = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        tkw.e("GdtInterstitialFragment", "setLoading", localThrowable);
      }
    }
  }
  
  public GdtInterstitialParams a()
  {
    return this.b;
  }
  
  public GdtInterstitialStatus a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
  }
  
  boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      return bool;
      setLoading(false);
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.bBr = paramInt1;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.bBs = paramInt2;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.bBt = paramInt3;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.bBu = paramInt4;
      if (paramLong != -2147483648L) {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.videoPositionMillis = paramLong;
      }
      if (getActivity() == null)
      {
        bool = false;
      }
      else
      {
        getActivity().finish();
        bool = true;
      }
    }
  }
  
  void bCV()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.aPe)
    {
      tkw.e("GdtInterstitialFragment", "onLoaded error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.aPe = true;
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus == 2)
    {
      thp.a(getActivity(), this.b, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.Eo == -2147483648L) {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.Eo = System.currentTimeMillis();
      }
    }
    setLoading(false);
    tkw.i("GdtInterstitialFragment", String.format("onLoaded timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.ee()) }));
  }
  
  void bCW()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.exposed) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.exposed = true;
    tkw.i("GdtInterstitialFragment", String.format("onImpression timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.ee()) }));
  }
  
  public void beforeFinish()
  {
    tkw.i("GdtInterstitialFragment", "beforeFinish");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 4;
    if (this.jdField_a_of_type_Thv != null) {
      this.jdField_a_of_type_Thv.destroy(getActivity());
    }
    tho.a().unregister(getTraceId());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("interstitialStatus", this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    getActivity().setResult(-1, localIntent);
    super.beforeFinish();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {}
    while ((paramActivity == null) || (Build.VERSION.SDK_INT < 5)) {
      return;
    }
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    tkw.i("GdtInterstitialFragment", "onActivityCreated");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 6;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    tkw.i("GdtInterstitialFragment", "onAttach");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 7;
  }
  
  public boolean onBackEvent()
  {
    return true;
  }
  
  boolean onClick()
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      tkw.i("GdtInterstitialFragment", String.format("onClick %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      if (this.b != null)
      {
        if (!this.b.iD())
        {
          bool = false;
        }
        else
        {
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.activity = new WeakReference(getActivity());
          localParams.appReceiver = new WeakReference(tho.a().a());
          localParams.n = GdtVideoCeilingFragmentForJS.class;
          localParams.p = GdtCanvasFragmentForJS.class;
          localParams.ad = this.b.a.ad;
          localParams.reportForClick = this.b.a.reportForClick;
          localParams.sceneID = this.b.a.sceneID;
          localParams.componentID = this.b.a.componentID;
          localParams.aOV = this.b.a.aOV;
          localParams.videoCeilingSupportedIfNotInstalled = this.b.a.videoCeilingSupportedIfNotInstalled;
          localParams.videoCeilingSupportedIfInstalled = this.b.a.videoCeilingSupportedIfInstalled;
          localParams.videoSpliceSupported = this.b.a.videoSpliceSupported;
          localParams.mediaViewLocationRect = this.b.a.mediaViewLocationRect;
          localParams.videoStartPositionMillis = this.b.a.videoStartPositionMillis;
          localParams.directPlay = this.b.a.directPlay;
          localParams.antiSpamParams = this.b.a.antiSpamParams;
          localParams.extra = this.b.a.extra;
          if (!localParams.isValid())
          {
            bool = false;
          }
          else
          {
            GdtHandler.a(localParams);
            bool = true;
          }
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    tkw.i("GdtInterstitialFragment", "onCreate");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 8;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 1;
    paramLayoutInflater = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
    if (thr.a().getStatus() == 3) {
      paramLayoutInflater.aPa = bool;
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          paramLayoutInflater = new FrameLayout(getActivity());
          try
          {
            setLoading(true);
            AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialFragment.1(this), 0, tho.a().o(getActivity()));
            thl.init();
            ArkAppNotifyCenter.setNotify(tho.a().a().appName, new WeakReference(tho.a().a()));
            if (getArguments() == null) {}
            for (;;)
            {
              tkw.i("GdtInterstitialFragment", String.format("onCreateView traceId:%s", new Object[] { getTraceId() }));
              AdThreadManager.INSTANCE.post(new GdtInterstitialFragment.2(this), 5);
              V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
              return paramLayoutInflater;
              bool = false;
              break;
              if (getArguments().containsKey("interstitialParams"))
              {
                this.b = ((GdtInterstitialParams)getArguments().getParcelable("interstitialParams"));
                if ((this.b != null) && (this.b.iD()) && (!TextUtils.isEmpty(getTraceId())) && (getArguments().containsKey("interstitialStartToShowTimeMillis")))
                {
                  this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.En = getArguments().getLong("interstitialStartToShowTimeMillis");
                  if (getArguments().containsKey("interstitialProcessName"))
                  {
                    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.processName = getArguments().getString("interstitialProcessName");
                    if ((tho.a().a(getTraceId(), new WeakReference(this))) || (getActivity() != null))
                    {
                      getActivity().setRequestedOrientation(this.b.orientation);
                      this.b.width = tls.getScreenWidth(getActivity());
                      this.b.height = tls.getScreenHeight(getActivity());
                      if ((this.b.width > 0) && (this.b.height > 0))
                      {
                        this.jdField_a_of_type_Thv = new thv(getActivity(), this.b, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
                        if (this.jdField_a_of_type_Thv.getView() != null)
                        {
                          paramViewGroup = new FrameLayout.LayoutParams(this.b.width, this.b.height);
                          paramViewGroup.gravity = 17;
                          paramLayoutInflater.addView(this.jdField_a_of_type_Thv.getView(), paramViewGroup);
                          if (!this.b.aOZ) {
                            getActivity().getWindow().addFlags(1024);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            tkw.e("GdtInterstitialFragment", "onCreateView", paramViewGroup);
          }
          catch (Throwable paramViewGroup) {}
        }
      }
      catch (Throwable paramViewGroup)
      {
        paramLayoutInflater = null;
      }
    }
  }
  
  public void onDestroy()
  {
    tkw.i("GdtInterstitialFragment", "onDestroy");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 12;
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    tkw.i("GdtInterstitialFragment", "onDestroyView");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 11;
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    tkw.i("GdtInterstitialFragment", "onDetach");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 13;
    super.onDetach();
  }
  
  public void onFinish()
  {
    tkw.i("GdtInterstitialFragment", "onFinish");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 5;
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (Build.VERSION.SDK_INT >= 5)) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPause()
  {
    tkw.i("GdtInterstitialFragment", "onPause");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 3;
    if (this.jdField_a_of_type_Thv != null) {
      this.jdField_a_of_type_Thv.pause(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.aPe)
    {
      thp.b(getActivity(), this.b, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.Ep == -2147483648L) {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.Ep = System.currentTimeMillis();
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    tkw.i("GdtInterstitialFragment", "onResume");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 2;
    if (this.jdField_a_of_type_Thv != null) {
      this.jdField_a_of_type_Thv.resume(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.aPe)
    {
      setLoading(false);
      thp.a(getActivity(), this.b, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.Eo == -2147483648L) {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.Eo = System.currentTimeMillis();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    tkw.i("GdtInterstitialFragment", "onStart");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 9;
  }
  
  public void onStop()
  {
    tkw.i("GdtInterstitialFragment", "onStop");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.activityStatus = 10;
    super.onStop();
  }
  
  void zr(int paramInt)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.videoStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment
 * JD-Core Version:    0.7.0.1
 */