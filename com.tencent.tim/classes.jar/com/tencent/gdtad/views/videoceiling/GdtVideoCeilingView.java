package com.tencent.gdtad.views.videoceiling;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqyx;
import com.tencent.TMG.utils.QLog;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.d;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tkw;
import tlg;
import tls;
import tmo;
import tmr;
import tms;
import tmt;

public class GdtVideoCeilingView
  extends FrameLayout
  implements GdtVideoCommonView.d, GdtVideoCeilingTitleBar.a, tmo
{
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private GdtVideoCeilingData jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData;
  private GdtVideoCeilingLandView jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
  private GdtVideoCeilingTitleBar jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar;
  private tmt jdField_b_of_type_Tmt;
  private int bCl = 1;
  private TouchWebView j;
  private int mScreenHeight = 1920;
  private View rg;
  private int videoHeight = 607;
  private FrameLayout webViewContainer;
  
  public GdtVideoCeilingView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GdtVideoCeilingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public GdtVideoCeilingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, GdtVideoCeilingLandView paramGdtVideoCeilingLandView, boolean paramBoolean)
  {
    if (paramGdtVideoCeilingLandView == null) {
      return;
    }
    if (paramGdtVideoCeilingLandView.mState == 0) {}
    for (paramLayoutParams.height = (this.mScreenHeight - this.videoHeight);; paramLayoutParams.height = this.mScreenHeight)
    {
      paramGdtVideoCeilingLandView.isAnimating = false;
      paramGdtVideoCeilingLandView.setLayoutParams(paramLayoutParams);
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.aPq)) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.bDK();
      }
      if (this.rg == null) {
        break;
      }
      this.rg.setVisibility(4);
      return;
    }
  }
  
  private void bDZ()
  {
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar = ((GdtVideoCeilingTitleBar)findViewById(2131382166));
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setOnBtnClickListener(this);
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.aC();
  }
  
  private void bEa()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData == null)
    {
      tkw.e("GdtVideoCeilingView", "doAppOpen data==null");
      return;
    }
    switch (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getStyle())
    {
    default: 
      return;
    case 1: 
      tkw.e("GdtVideoCeilingView", "doAppOpen should not go here");
      return;
    case 2: 
      bEb();
      return;
    }
    bEc();
  }
  
  private void bEb()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_ads");
    localObject = AdAppUtil.launch(getContext(), this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd().getAppPackageName(), (Bundle)localObject);
    StringBuilder localStringBuilder = new StringBuilder().append("doOpenMain result ");
    if (localObject != null) {}
    for (boolean bool = ((AdError)localObject).isSuccess();; bool = false)
    {
      tkw.d("GdtVideoCeilingView", bool);
      return;
    }
  }
  
  private void bEc()
  {
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("big_brother_source_key", "biz_src_ads");
    AdAppDeeplinkLauncher.Params localParams = new AdAppDeeplinkLauncher.Params();
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd() != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd().getAppDeeplink();
      localParams.deeplink = ((String)localObject1);
      localParams.addflags = 268435456;
      localParams.extrasForIntent = ((Bundle)localObject2);
      localObject1 = AdAppDeeplinkLauncher.launch(getActivity(), localParams);
      if ((localObject1 != null) && (((AdAppDeeplinkLauncher.Result)localObject1).isSuccess())) {
        tlg.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getAd(), 246);
      }
      localObject2 = new StringBuilder().append("doOpenDeepLink result ");
      if (localObject1 == null) {
        break label147;
      }
    }
    label147:
    for (boolean bool = ((AdAppDeeplinkLauncher.Result)localObject1).isSuccess();; bool = false)
    {
      tkw.d("GdtVideoCeilingView", bool);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private void eO(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView == null) {
      return;
    }
    boolean bool;
    label76:
    label80:
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramInt1 < paramInt2)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCeilingView", 0, "updateLayout width " + paramInt1 + " height " + paramInt2 + " Portrait " + bool);
      }
      if (!bool) {
        break label238;
      }
      paramInt1 = (int)(paramInt1 * 0.5625D);
      if (paramInt1 <= 0) {
        break label243;
      }
      this.videoHeight = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCeilingView", 0, "videoView height " + this.videoHeight);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
      localLayoutParams.height = this.videoHeight;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.rg.getLayoutParams();
      localLayoutParams.height = this.videoHeight;
      this.rg.setLayoutParams(localLayoutParams);
      if (paramInt2 <= 0) {
        break label250;
      }
    }
    for (;;)
    {
      this.mScreenHeight = paramInt2;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      localLayoutParams.topMargin = this.videoHeight;
      localLayoutParams.height = (this.mScreenHeight - this.videoHeight);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      return;
      bool = false;
      break;
      label238:
      paramInt1 = paramInt2;
      break label76;
      label243:
      paramInt1 = 607;
      break label80;
      label250:
      paramInt2 = 1920;
    }
  }
  
  private Activity getActivity()
  {
    if ((getContext() instanceof Activity)) {
      return (Activity)getContext();
    }
    return null;
  }
  
  private Intent getIntent()
  {
    if (getActivity() == null) {
      return null;
    }
    return getActivity().getIntent();
  }
  
  private void init()
  {
    initView();
  }
  
  private void initTouchEvent()
  {
    this.rg = findViewById(2131381741);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView = ((GdtVideoCeilingLandView)findViewById(2131367892));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setGdtVideoCeilingListeners(this, this.j);
  }
  
  private void initVideoView()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = ((GdtVideoCommonView)findViewById(2131381570));
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setOnVideoFullScreen(this);
  }
  
  private void initView()
  {
    inflate(getContext(), 2131559401, this);
    initVideoView();
    bDZ();
    initWebView();
    initTouchEvent();
  }
  
  private void initWebView()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.webViewContainer = ((FrameLayout)findViewById(2131382169));
    this.j = new TouchWebView(getContext());
    this.webViewContainer.addView(this.j);
    this.jdField_b_of_type_Tmt = new tmr(this, getContext(), getActivity(), getIntent(), localAppInterface);
    this.jdField_b_of_type_Tmt.a(this.j);
    new aqyx(this.jdField_b_of_type_Tmt).a(null, localAppInterface, getIntent());
  }
  
  public void a(GdtVideoCeilingLandView paramGdtVideoCeilingLandView, int paramInt, boolean paramBoolean)
  {
    if (paramGdtVideoCeilingLandView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramGdtVideoCeilingLandView.getLayoutParams();
    localValueAnimator.addUpdateListener(new tms(this, localLayoutParams, localLayoutParams.topMargin, paramInt, paramGdtVideoCeilingLandView, paramBoolean));
    localValueAnimator.setDuration(300L);
    paramGdtVideoCeilingLandView.isAnimating = true;
    localValueAnimator.start();
  }
  
  public void aUp()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(false, 0);
  }
  
  public void aVf()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.isFullScreen())) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(true, 0);
    }
  }
  
  public boolean back()
  {
    boolean bool = true;
    tkw.d("GdtVideoCeilingView", "----back click");
    String str = "";
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.isFullScreen())
    {
      aUp();
      str = " videoView.isFullScreen() result = true";
    }
    for (;;)
    {
      tkw.d("GdtVideoCeilingView", "----back return " + bool + str);
      return bool;
      if ((this.j != null) && (this.j.canGoBack()))
      {
        this.j.goBack();
        str = " webView.goBack() result = true";
      }
      else if (getActivity() != null)
      {
        getActivity().finish();
        getActivity().overridePendingTransition(17432576, 17432577);
        str = " getActivity().finish() result = true";
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void er(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363222: 
      back();
      return;
    }
    bEa();
  }
  
  public long getCurrentPosition()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      return this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getCurrentPosition();
    }
    return 0L;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Tmt != null) {
      this.jdField_b_of_type_Tmt.onCreate(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.onDestroy();
    }
    if (this.jdField_b_of_type_Tmt != null) {
      this.jdField_b_of_type_Tmt.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.onDestroy();
    }
    if (this.j != null)
    {
      ViewParent localViewParent = this.j.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeAllViewsInLayout();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      eO(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.pauseVideo();
    }
    if (this.jdField_b_of_type_Tmt != null) {
      this.jdField_b_of_type_Tmt.onPause();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.resumeVideo();
    }
    if (this.jdField_b_of_type_Tmt != null) {
      this.jdField_b_of_type_Tmt.onResume();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.onResume();
    }
  }
  
  public void onStart(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.EF()) {}
    for (paramInt = 1;; paramInt = 2)
    {
      this.bCl = paramInt;
      return;
    }
  }
  
  public void setData(GdtVideoCeilingData paramGdtVideoCeilingData)
  {
    if ((paramGdtVideoCeilingData == null) || (!paramGdtVideoCeilingData.isValid()) || (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView == null) || (this.j == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData = paramGdtVideoCeilingData;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setData(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getVideoData());
    AdCanvasView localAdCanvasView = (AdCanvasView)findViewById(2131372214);
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getStyle() == 4)
    {
      this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setVisibility(8);
      findViewById(2131378044).setVisibility(8);
      this.webViewContainer.setVisibility(8);
      localAdCanvasView.setVisibility(0);
      tls.e(localAdCanvasView);
      localAdCanvasView.setData(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getCanvasData());
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setGdtVideoCeilingNativeListeners(this, localAdCanvasView);
      return;
    }
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setVisibility(0);
    findViewById(2131378044).setVisibility(0);
    this.webViewContainer.setVisibility(0);
    localAdCanvasView.setVisibility(8);
    this.j.loadUrl(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingData.getWebUrl());
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setAppName(paramGdtVideoCeilingData.getAd().getAppName());
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setStyle(paramGdtVideoCeilingData.getStyle());
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.bDY();
  }
  
  public void zw(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView == null) || (this.rg == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.bDP();
    }
    zy(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.mState);
    int i = (int)(paramInt + 0.5F) + this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getTop();
    if (i > this.videoHeight) {
      paramInt = this.videoHeight;
    }
    for (;;)
    {
      tkw.i("GdtVideoCeilingView", "onDrag newTop " + paramInt);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      try
      {
        if (this.videoHeight == 0) {
          this.videoHeight = 607;
        }
        if (this.rg.getVisibility() == 4) {
          this.rg.setVisibility(0);
        }
        float f = paramInt * 1.0F / this.videoHeight;
        this.rg.setAlpha(1.0F - f);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
    }
  }
  
  public void zx(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView == null)
    {
      tkw.e("GdtVideoCeilingView", "onEnd  view null ");
      return;
    }
    int k = (int)(this.videoHeight * 0.2F);
    int m = this.videoHeight;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    if (paramInt == 0) {
      if (i <= m - k)
      {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.mState = 2;
        paramInt = -i;
        bool1 = bool2;
      }
    }
    while (Math.abs(paramInt) > 0)
    {
      a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView, paramInt, bool1);
      return;
      paramInt = this.videoHeight;
      if (this.bCl == 1) {}
      for (;;)
      {
        paramInt -= i;
        break;
        bool1 = false;
      }
      if (i >= k)
      {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.mState = 0;
        paramInt = this.videoHeight - i;
        bool1 = true;
      }
      else
      {
        paramInt = -i;
        bool1 = bool2;
      }
    }
    a(localLayoutParams, this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView, bool1);
  }
  
  protected void zy(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (paramInt == 0))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
      localLayoutParams.topMargin = this.videoHeight;
      if (localLayoutParams.height != this.mScreenHeight)
      {
        localLayoutParams.height = this.mScreenHeight;
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(localLayoutParams);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView
 * JD-Core Version:    0.7.0.1
 */