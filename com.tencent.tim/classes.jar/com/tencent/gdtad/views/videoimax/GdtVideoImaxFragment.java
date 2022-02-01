package com.tencent.gdtad.views.videoimax;

import acfp;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqbn;
import aqhu;
import aqyx;
import awdo;
import com.tencent.ad.tangram.canvas.statistics.AdTimeStatistics;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.e;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tkw;
import tla;
import tla.a;
import tlg;
import tls;
import tmt;
import tmv;
import tmw;
import tmx;
import tmy;
import tmz;

public class GdtVideoImaxFragment
  extends PublicBaseFragment
{
  private TextView Bx;
  private GdtVideoCommonView.e jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$e = new tmv(this);
  private GdtVideoCeilingLandView jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView;
  private GdtImaxData jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
  private boolean aPK;
  private boolean aPL;
  private URLImageView ad;
  private GdtVideoCommonView jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private GdtVideoCeilingTitleBar jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar;
  private tmt jdField_b_of_type_Tmt;
  private TouchWebView c;
  private Button cN;
  private View.OnClickListener cR = new tmw(this);
  private View gQ;
  private RelativeLayout gk;
  protected AdTimeStatistics loadTimeStatistics = new AdTimeStatistics();
  private ResultReceiver mResultReceiver;
  private Runnable mTimeoutRunnable = new GdtVideoImaxFragment.2(this);
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private View rh;
  private AdTimeStatistics stayTimeStatistics = new AdTimeStatistics();
  private FrameLayout webViewContainer;
  
  private boolean Ok()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height > 0;
  }
  
  private void a(GdtVideoCommonView paramGdtVideoCommonView, GdtVideoData paramGdtVideoData)
  {
    paramGdtVideoCommonView.setData(paramGdtVideoData);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramGdtVideoCommonView.getLayoutParams();
    paramGdtVideoData = tls.d(getActivity());
    localMarginLayoutParams.height = paramGdtVideoData[1];
    tkw.d("GdtVideoImaxFragment", "bindVideo() called with: width = [" + localMarginLayoutParams.width + "], height = [" + localMarginLayoutParams.height + "]");
    localMarginLayoutParams.leftMargin = (getResources().getDisplayMetrics().widthPixels - 1);
    paramGdtVideoCommonView.setLayoutParams(localMarginLayoutParams);
    this.gQ = getView().findViewById(2131367205);
    localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.gQ.getLayoutParams();
    localMarginLayoutParams.height = paramGdtVideoData[1];
    this.gQ.setLayoutParams(localMarginLayoutParams);
    paramGdtVideoData = (RelativeLayout.LayoutParams)((RelativeLayout)paramGdtVideoCommonView.findViewById(2131364677)).getLayoutParams();
    paramGdtVideoData.addRule(9, 0);
    paramGdtVideoData.addRule(11);
    paramGdtVideoData = (ImageView)paramGdtVideoCommonView.findViewById(2131369707);
    paramGdtVideoData.setImageResource(2130840567);
    paramGdtVideoData = (RelativeLayout.LayoutParams)paramGdtVideoData.getLayoutParams();
    paramGdtVideoData.addRule(11);
    paramGdtVideoData.width = -2;
    paramGdtVideoData.leftMargin = 0;
    paramGdtVideoData.rightMargin = tls.dp2px(15.0F, getResources());
    paramGdtVideoCommonView.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView$e);
  }
  
  private void bDZ()
  {
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.aC();
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setAppName(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAppName());
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setStyle(1);
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.bDY();
    if (awdo.a(getActivity(), getActivity()) > 0)
    {
      this.rh.setVisibility(0);
      ViewGroup.LayoutParams localLayoutParams = this.rh.getLayoutParams();
      localLayoutParams.height = awdo.a(getActivity(), getActivity());
      this.rh.setLayoutParams(localLayoutParams);
    }
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar.setOnBtnClickListener(new tmy(this));
  }
  
  private void bEd()
  {
    this.mUiHandler.postDelayed(this.mTimeoutRunnable, 500L);
  }
  
  private void bEe()
  {
    tkw.d("GdtVideoImaxFragment", "setPreviewImageVisible() called");
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
    localMarginLayoutParams.leftMargin = 0;
    this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams(localMarginLayoutParams);
  }
  
  private void bEf()
  {
    if (this.cN == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd() != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getProductType() == 12))
    {
      if (AdAppUtil.isInstalled(getActivity(), this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAppPackageName()))
      {
        this.cN.setText(acfp.m(2131706931));
        return;
      }
      this.cN.setText(acfp.m(2131706930));
      return;
    }
    this.cN.setText(acfp.m(2131706925));
  }
  
  private void bEg()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData == null) || (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd() == null)) {
      return;
    }
    tlg.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd(), 280);
  }
  
  private void bEh()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData == null) || (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd() == null) || (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().info == null)) {
      return;
    }
    try
    {
      Object localObject2 = getActivity();
      Object localObject1 = localObject2;
      if ((localObject2 instanceof BasePluginActivity)) {
        localObject1 = ((BasePluginActivity)localObject2).getOutActivity();
      }
      localObject2 = new GdtHandler.Params();
      ((GdtHandler.Params)localObject2).processId = 7;
      ((GdtHandler.Params)localObject2).activity = new WeakReference((Activity)localObject1);
      ((GdtHandler.Params)localObject2).ad = new GdtAd(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().info);
      ((GdtHandler.Params)localObject2).reportForClick = false;
      ((GdtHandler.Params)localObject2).aOV = true;
      ((GdtHandler.Params)localObject2).n = null;
      ((GdtHandler.Params)localObject2).p = GdtCanvasFragmentForArk.class;
      ((GdtHandler.Params)localObject2).videoSpliceSupported = false;
      ((GdtHandler.Params)localObject2).extra = new Bundle();
      ((GdtHandler.Params)localObject2).appReceiver = new WeakReference(new GdtAppReceiver());
      ((GdtHandler.Params)localObject2).extra.putString("big_brother_ref_source_key", "biz_src_jc_qzone");
      GdtHandler.a((GdtHandler.Params)localObject2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void e(int paramInt, float paramFloat1, float paramFloat2)
  {
    tkw.d("GdtVideoImaxFragment", "showWebView() called with: total = [" + paramInt + "], from = [" + paramFloat1 + "], to = [" + paramFloat2 + "]");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(250L);
    localValueAnimator.addUpdateListener(new tmx(this, paramFloat1, paramFloat2, paramInt));
    localValueAnimator.start();
    ((ViewGroup)getActivity().getWindow().getDecorView()).setSystemUiVisibility(7942);
  }
  
  private void es(View paramView)
  {
    paramView.findViewById(2131369656).setVisibility(8);
    this.gk = ((RelativeLayout)paramView.findViewById(2131377378));
    this.gk.setVisibility(0);
    this.ad = ((URLImageView)paramView.findViewById(2131369031));
    this.Bx = ((TextView)paramView.findViewById(2131380546));
    this.cN = ((Button)paramView.findViewById(2131362270));
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd() != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_logo()))
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = aqhu.at();
        paramView.mLoadingDrawable = localDrawable;
        paramView.mFailedDrawable = localDrawable;
        paramView = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_logo(), paramView);
        paramView.setDecodeHandler(aqbn.b);
        paramView.setFadeInImage(true);
        this.ad.setImageDrawable(paramView);
      }
      this.Bx.setText(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().getAdvertiser_corporate_image_name());
      bEf();
    }
    this.gk.setOnClickListener(this.cR);
    this.ad.setOnClickListener(this.cR);
    this.Bx.setOnClickListener(this.cR);
    this.cN.setOnClickListener(this.cR);
  }
  
  private void initTouchEvent()
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setIgnoreInterceptTouchEvent(true);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setIgnoreTouchEvent(true);
  }
  
  private void initWebView()
  {
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    FragmentActivity localFragmentActivity = getActivity();
    this.c = new TouchWebView(localFragmentActivity);
    this.webViewContainer.addView(this.c);
    this.jdField_b_of_type_Tmt = new tmz(this, localFragmentActivity, localFragmentActivity, localFragmentActivity.getIntent(), (AppInterface)localObject);
    this.jdField_b_of_type_Tmt.a(this.c);
    new aqyx(this.jdField_b_of_type_Tmt).a(null, (AppInterface)localObject, getActivity().getIntent());
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = 0;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getWebUrl();
    this.c.loadUrl((String)localObject);
    this.loadTimeStatistics.start();
  }
  
  private void onAnimationEnd()
  {
    tkw.d("GdtVideoImaxFragment", "onAnimationEnd() called");
    this.aPK = true;
    startPlay();
    bEe();
    bEd();
  }
  
  private void reportLoadTimeForAction(long paramLong, boolean paramBoolean)
  {
    tkw.d("GdtVideoImaxFragment", "reportLoadTimeForAction() called with: time = [" + paramLong + "], success = [" + paramBoolean + "]");
    tla.a locala = new tla.a();
    locala.ad = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd();
    PBUInt32Field localPBUInt32Field = locala.a.landing_page_action_type;
    if (paramBoolean) {}
    for (int i = 3;; i = 4)
    {
      localPBUInt32Field.set(i);
      locala.a.latency_ms.set(paramLong);
      tla.a(locala);
      return;
    }
  }
  
  private void reportStayTimeForAction()
  {
    tkw.d("GdtVideoImaxFragment", "reportStayTimeForAction() called");
    tla.a locala = new tla.a();
    locala.ad = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd();
    locala.a.landing_page_action_type.set(7);
    locala.a.latency_ms.set(this.stayTimeStatistics.getTime());
    tla.a(locala);
  }
  
  private void startPlay()
  {
    tkw.d("GdtVideoImaxFragment", "startPlay() called");
    this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.bDK();
  }
  
  private void vz(boolean paramBoolean)
  {
    tkw.d("GdtVideoImaxFragment", "onWebViewLoadFinish() called with: success = [" + paramBoolean + "]");
    if (!this.aPL)
    {
      this.aPL = true;
      this.loadTimeStatistics.stop();
      reportLoadTimeForAction(this.loadTimeStatistics.getTime(), paramBoolean);
    }
  }
  
  public boolean back()
  {
    boolean bool = true;
    tkw.d("GdtVideoImaxFragment", "----back click");
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 1) && (getActivity() != null))
    {
      getActivity().finish();
      return true;
    }
    String str;
    if (this.c.canGoBack())
    {
      this.c.goBack();
      str = " mWebView.goBack() result = true";
    }
    for (;;)
    {
      tkw.d("GdtVideoImaxFragment", "----back return " + bool + str);
      return bool;
      if (Ok())
      {
        e(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height, this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.getLayoutParams().height, 0.0F);
        this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.bDK();
        str = " webViewIsShowing result = true";
      }
      else if (getActivity() != null)
      {
        getActivity().finish();
        str = " getActivity().finish() result = true";
      }
      else
      {
        bool = false;
        str = "";
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {}
    do
    {
      return;
      paramActivity.setRequestedOrientation(1);
      Window localWindow = paramActivity.getWindow();
      localWindow.addFlags(1024);
      ((ViewGroup)localWindow.getDecorView()).setSystemUiVisibility(7942);
    } while (!tls.p(paramActivity));
    tls.bl(paramActivity);
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
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    paramActivity = paramActivity.getIntent();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData = ((GdtImaxData)paramActivity.getSerializableExtra("data"));
    this.mResultReceiver = ((ResultReceiver)paramActivity.getParcelableExtra("callback"));
    paramActivity = new Bundle();
    MyResultReceiver localMyResultReceiver = new MyResultReceiver(new Handler(Looper.getMainLooper()));
    localMyResultReceiver.d(this);
    ClassLoader localClassLoader = localMyResultReceiver.getClass().getClassLoader();
    tkw.d("GdtVideoImaxFragment", "onAttach() classLoader = [" + localClassLoader + "]");
    paramActivity.setClassLoader(localClassLoader);
    paramActivity.putParcelable("callback", localMyResultReceiver);
    this.mResultReceiver.send(0, paramActivity);
  }
  
  public boolean onBackEvent()
  {
    return back();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559402, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.onDestroy();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 0)
    {
      this.jdField_b_of_type_Tmt.onDestroy();
      ViewParent localViewParent = this.c.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeAllViewsInLayout();
      }
    }
  }
  
  public void onDetach()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 0)) {
      reportStayTimeForAction();
    }
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.pauseVideo();
    this.stayTimeStatistics.stop();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.resumeVideo();
    this.stayTimeStatistics.start();
    bEf();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = ((GdtVideoCommonView)paramView.findViewById(2131381570));
    this.webViewContainer = ((FrameLayout)paramView.findViewById(2131382169));
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingTitleBar = ((GdtVideoCeilingTitleBar)paramView.findViewById(2131382166));
    this.rh = paramView.findViewById(2131372481);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView = ((GdtVideoCeilingLandView)paramView.findViewById(2131367892));
    a(this.jdField_b_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView, this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoData());
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 1) {
      es(paramView);
    }
    for (;;)
    {
      initTouchEvent();
      return;
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getVideoSplicePageStyle() == 0)
      {
        bDZ();
        initWebView();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
  
  public static class MyResultReceiver
    extends ResultReceiver
  {
    private WeakReference<GdtVideoImaxFragment> mFragment;
    
    public MyResultReceiver(Handler paramHandler)
    {
      super();
    }
    
    public void d(GdtVideoImaxFragment paramGdtVideoImaxFragment)
    {
      this.mFragment = new WeakReference(paramGdtVideoImaxFragment);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      tkw.d("GdtVideoImaxFragment", "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
      paramBundle = (GdtVideoImaxFragment)this.mFragment.get();
      if ((paramBundle != null) && (paramInt == 1)) {
        GdtVideoImaxFragment.c(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment
 * JD-Core Version:    0.7.0.1
 */