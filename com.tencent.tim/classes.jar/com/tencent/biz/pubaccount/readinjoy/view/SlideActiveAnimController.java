package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import aqmj;
import awit;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.SkinPullRefreshHeader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.List;
import kbp;
import kxm.b;
import mfo;
import mgh;
import njd;
import nje;
import njf;
import njg;
import njh;
import nji;
import njj;
import org.json.JSONException;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tlb;
import wja;

public class SlideActiveAnimController
  implements Animator.AnimatorListener, Runnable
{
  private static int aZi = 1;
  private static int aZj = 2;
  ValueAnimator G;
  ValueAnimator H;
  public ReadInJoyXListView a;
  public ReadInjoySlideAnimLayout a;
  SkinPullRefreshHeader a;
  private int aUC = 0;
  int aWq;
  private int aZd;
  private int aZe;
  int aZf;
  int aZg;
  int aZh;
  private int aZk = aZi;
  int aZl;
  String alm;
  String alu;
  public boolean asA;
  boolean asv;
  boolean asw;
  private boolean asx;
  public boolean asy;
  public boolean asz;
  ReadInJoySkinSlideDownView b;
  private Runnable cT;
  Runnable cU = new SlideActiveAnimController.8(this);
  private long exposureTime = 9223372036854775807L;
  private View hY;
  private View mBottomView;
  private int mChannelId;
  private Activity mContext;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private View mJ;
  private View mK;
  public ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
  private boolean ob;
  long startTime = -1L;
  
  public SlideActiveAnimController(int paramInt, Activity paramActivity, ReadInjoySlideAnimLayout paramReadInjoySlideAnimLayout, ReadInJoyXListView paramReadInJoyXListView, View paramView1, View paramView2, Runnable paramRunnable)
  {
    this.mChannelId = paramInt;
    this.mContext = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(new njd(this));
    this.mK = paramActivity.findViewById(2131381456);
    this.hY = paramActivity.findViewById(2131378734);
    this.hY = paramView1;
    this.mBottomView = paramView2;
    this.mJ = paramActivity.findViewById(2131374354);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout = paramReadInjoySlideAnimLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setVisibility(4);
    this.aZf = paramActivity.getResources().getDimensionPixelSize(2131299308);
    this.aZh = (this.aZf * 3);
    this.mOnGlobalLayoutListener = new nje(this, paramRunnable);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
  }
  
  private boolean FC()
  {
    long l = System.currentTimeMillis();
    return (this.startTime != -1L) && (l - this.startTime >= 300L);
  }
  
  private boolean FD()
  {
    return this.b != null;
  }
  
  private boolean FG()
  {
    return mgh.ph() == 1;
  }
  
  private boolean FH()
  {
    return true;
  }
  
  private void aTA()
  {
    if (this.startTime == -1L) {
      this.startTime = System.currentTimeMillis();
    }
  }
  
  private void aXZ()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getVisibility() != 0)
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getHeight();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.ap.setTranslationY(-i);
    }
  }
  
  private void aYa()
  {
    if (this.mJ != null) {
      this.mJ.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.smoothScrollBy(0, 0);
    aYb();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setMessage(false, "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setVisibility(0);
    if (this.mBottomView != null) {
      this.mBottomView.setVisibility(8);
    }
    if (this.mK != null) {
      this.mK.setVisibility(8);
    }
    pI(true);
  }
  
  private void aYb()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setDisableContentTouch(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setEnabled(false);
    this.hY.setEnabled(false);
  }
  
  private void aYc()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setDisableContentTouch(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setEnabled(true);
    this.hY.setEnabled(true);
  }
  
  private void aYd()
  {
    float f = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.ap.getTranslationY();
    if ((this.G != null) && (this.G.isRunning())) {
      this.G.cancel();
    }
    this.G = ValueAnimator.ofFloat(new float[] { 0.0F, f });
    this.G.addUpdateListener(new njh(this, f));
    this.G.setDuration(300L);
    this.G.addListener(this);
    this.G.start();
  }
  
  private void aYe()
  {
    if ((!this.asy) || (ImmersiveUtils.hasNotchInScreen(this.mContext))) {}
    do
    {
      return;
      Window localWindow = this.mContext.getWindow();
      this.aWq = localWindow.getAttributes().flags;
      localWindow.setFlags(1024, 1024);
    } while ((!(this.mContext instanceof BaseActivity)) || (((BaseActivity)this.mContext).mSystemBarComp == null));
    ((BaseActivity)this.mContext).mSystemBarComp.setStatusBarVisible(2, 0);
  }
  
  private void aYf()
  {
    if ((this.H != null) && (this.H.isRunning()) && (this.asx)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.aZk == aZj);
        if (QLog.isColorLevel()) {
          QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim enter");
        }
        if (this.aZe != 0) {
          break;
        }
        this.aZe = this.hY.getHeight();
        if (this.aZe != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim return3 : mOriginHeadHeight=" + this.aZe);
      return;
      this.asx = true;
      this.mHandler.postDelayed(this.cU, 500L);
      this.H = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      this.H.addUpdateListener(new nji(this));
      this.H.addListener(new njj(this));
      this.H.setDuration(500L);
      this.H.start();
    } while (!QLog.isColorLevel());
    QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim mHeadAnimator start");
  }
  
  private void aYg()
  {
    if ((this.asv) || (this.asw)) {}
    do
    {
      return;
      if ((this.H != null) && (this.H.isRunning())) {
        this.H.cancel();
      }
      this.mHandler.removeCallbacks(this.cU);
    } while (this.aZk == aZi);
    this.asx = false;
    this.aZk = aZi;
    this.hY.setTranslationY(0.0F);
    this.hY.setVisibility(0);
    this.hY.setAlpha(1.0F);
    showStatusBar();
  }
  
  private void aYh()
  {
    this.aZd = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.springBackOverScrollHeaderView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setTranslationY(0.0F);
    if (FD()) {
      aYc();
    }
  }
  
  private void aYi()
  {
    aYm();
    this.asv = false;
    this.asw = false;
    aYg();
    aYj();
    if (this.mJ != null) {
      this.mJ.setVisibility(0);
    }
    if (this.mBottomView != null)
    {
      this.mBottomView.setVisibility(0);
      this.mBottomView.setTranslationY(0.0F);
    }
    if (this.mK != null) {
      this.mK.setVisibility(0);
    }
  }
  
  private void aYj()
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getHeight();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.ap.setTranslationY(-i);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setVisibility(4);
  }
  
  private void aYm()
  {
    long l = System.currentTimeMillis() - this.exposureTime;
    this.exposureTime = 9223372036854775807L;
    if (l > 0L) {}
    try
    {
      kbp.a(null, "CliOper", "", "", "0X800A1A6", "0X800A1A6", 0, 0, awit.sn("default_feeds_proteus_offline_bid"), "", "", new kxm.b().a("duration", (int)l).build(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static void di(View paramView)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  private boolean eb(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isDirectory()));
    return true;
  }
  
  private void g(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = this.mContext;
    String str;
    if ((localObject instanceof BaseActivity))
    {
      aqmj.aJ((Context)localObject, ((BaseActivity)localObject).getCurrentAccountUin());
      str = ((mfo)((BaseActivity)localObject).app.getManager(270)).jL();
      localObject = new kxm.b();
    }
    for (;;)
    {
      try
      {
        ((kxm.b)localObject).c().d().a(paramInt).f().g().h().i().a(str).d(0).e(2).b();
        if (!TextUtils.isEmpty(paramString)) {
          continue;
        }
        paramInt = 0;
        ((kxm.b)localObject).a("image_jump", String.valueOf(paramInt));
        if (!paramBoolean) {
          continue;
        }
        paramInt = 1;
        ((kxm.b)localObject).a("ad_page", paramInt);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      kbp.a(null, "CliOper", "", "", "0X800969B", "0X800969B", 0, 0, awit.sn("default_feeds_proteus_offline_bid"), "", "", ((kxm.b)localObject).build(), false);
      return;
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  private void l(String paramString1, String paramString2, int paramInt)
  {
    if (!eb(paramString2)) {
      this.b = null;
    }
    while (TextUtils.isEmpty(paramString1)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.mContext).getAppInterface();
    this.b = new ReadInJoySkinSlideDownView(this.mChannelId, this.mContext, localQQAppInterface, paramString1, paramString2, paramInt, new njf(this), null, new njg(this));
    QLog.i("SlideActiveAnimController", 1, "makeAndAddPosterView current state id = " + paramString1 + ",rootPath = " + paramString2 + ",manager = " + paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setContentView(this.b);
  }
  
  private void pI(boolean paramBoolean)
  {
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localReadInjoySlideAnimLayout.setVisibility(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.ap.setTranslationY(-this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getHeight());
      return;
    }
  }
  
  private void resetStartTime()
  {
    this.startTime = -1L;
  }
  
  private void showStatusBar()
  {
    if ((!this.asy) || (ImmersiveUtils.hasNotchInScreen(this.mContext))) {}
    do
    {
      return;
      Window localWindow = this.mContext.getWindow();
      localWindow.clearFlags(1024);
      localWindow.addFlags(this.aWq);
    } while ((!(this.mContext instanceof BaseActivity)) || (((BaseActivity)this.mContext).mSystemBarComp == null));
    ((BaseActivity)this.mContext).mSystemBarComp.setStatusBarVisible(0, 0);
  }
  
  public boolean FE()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.asv) || (this.asw)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      if (!FG()) {
        break;
      }
      bool1 = bool2;
    } while (!FD());
    if ((FG()) && (this.aZd >= this.aZg) && (FC()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.isTouchHolding = false;
      startAnim();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader.B(false, "");
      return true;
    }
    if (this.aZk == aZj) {
      aYg();
    }
    for (;;)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader.B(false, "");
      return false;
      if ((this.H != null) && (this.H.isRunning()))
      {
        this.H.cancel();
        aYg();
      }
    }
  }
  
  public boolean FF()
  {
    return (FG()) || (FH());
  }
  
  public void a(SkinPullRefreshHeader paramSkinPullRefreshHeader)
  {
    this.ob = true;
    this.aZd = 0;
    aYg();
  }
  
  public void a(SkinPullRefreshHeader paramSkinPullRefreshHeader, int paramInt1, int paramInt2)
  {
    this.aZd = paramInt1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshSkinPullRefreshHeader = paramSkinPullRefreshHeader;
    if ((this.asv) || (this.asw) || (this.asA) || (this.ob)) {}
    do
    {
      do
      {
        return;
      } while ((FG()) && (!FD()));
      if (paramInt1 >= this.aZg)
      {
        if (FG())
        {
          aTA();
          this.b.onResume();
        }
        aYf();
        return;
      }
      if (paramInt1 < this.aZf) {
        break;
      }
      if (paramInt1 >= this.aZe - this.aZf) {
        aYf();
      }
    } while (!FG());
    this.b.onPause();
    return;
    if (FG())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setMessage(false, "");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.setVisibility(4);
      paramSkinPullRefreshHeader.B(false, "");
    }
    aYg();
    resetStartTime();
  }
  
  public void aCB()
  {
    this.ob = false;
    this.asA = false;
    this.aZd = 0;
  }
  
  public void aXY()
  {
    aXZ();
    this.aZe = this.hY.getHeight();
    this.aZg = (wja.dp2px(210.0F, this.mContext.getResources()) - this.aZe);
  }
  
  public void aYk()
  {
    if (FD())
    {
      this.b.onDestroy();
      this.b = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.aXg();
    }
  }
  
  public void aYl()
  {
    if (this.mOnGlobalLayoutListener == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }
    for (;;)
    {
      this.mOnGlobalLayoutListener = null;
      QLog.d("SlideActiveAnimController", 1, "removeOnGlobalLayoutListener");
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    }
  }
  
  public void k(String paramString1, String paramString2, int paramInt)
  {
    if (!FG()) {
      return;
    }
    QLog.i("SlideActiveAnimController", 1, "setGuideAttrs id = " + paramString1 + ",rootPath = " + paramString2 + ",manager = " + paramInt + ",guideView = " + this.b);
    QLog.i("SlideActiveAnimController", 1, "setGuideAttrs current state id = " + this.alu + ",rootPath = " + this.alm + ",manager = " + this.aZl);
    if (this.b == null) {
      l(paramString1, paramString2, paramInt);
    }
    for (;;)
    {
      this.alu = paramString1;
      this.alm = paramString2;
      this.aZl = paramInt;
      return;
      if ((!paramString1.equals(this.alu)) || (!paramString2.equals(this.alm)) || (paramInt != this.aZl))
      {
        this.b.onDestroy();
        this.b = null;
        l(paramString1, paramString2, paramInt);
      }
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.asv = false;
    aYh();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    boolean bool = true;
    this.asv = false;
    this.exposureTime = System.currentTimeMillis();
    aYh();
    int i;
    Object localObject;
    if (FD())
    {
      paramAnimator = mfo.b(this.mContext, 0);
      i = this.mChannelId;
      localObject = this.b.getJumpUrl();
      if ((paramAnimator == null) || (!paramAnimator.isAD)) {
        break label161;
      }
    }
    for (;;)
    {
      g(i, (String)localObject, bool);
      if ((paramAnimator != null) && (paramAnimator.isAD) && (paramAnimator.adExposureReports != null) && (paramAnimator.adExposureReports.size() > 0)) {}
      try
      {
        localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
        long l = paramAnimator.adId.longValue();
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.trace_info.aid.set(l);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(paramAnimator.getUrls(paramAnimator.adExposureReports));
        tlb.a(0, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject);
        return;
      }
      catch (NumberFormatException paramAnimator)
      {
        label161:
        paramAnimator.printStackTrace();
      }
      bool = false;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.asw = true;
  }
  
  public boolean onBackPressed()
  {
    if (this.asv) {
      return true;
    }
    if (this.asw)
    {
      aYi();
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.cT != null)
    {
      this.mHandler.removeCallbacks(this.cT);
      this.cT = null;
    }
    if (this.b != null) {
      this.b.onDestroy();
    }
    aYl();
  }
  
  public void onLogout()
  {
    this.alu = null;
    this.alm = null;
    this.aZl = -1;
    aYk();
    aYh();
    aYi();
  }
  
  public void onPause()
  {
    if (!this.asz) {
      aYm();
    }
    this.ob = false;
    if (this.b != null) {
      this.b.onPause();
    }
  }
  
  public void onResume()
  {
    this.asz = false;
    if (this.cT != null)
    {
      this.mHandler.removeCallbacks(this.cT);
      this.cT.run();
      this.cT = null;
    }
    aYh();
    if (!this.asw) {
      aYi();
    }
    do
    {
      return;
      aYc();
    } while (this.b == null);
    this.b.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((FG()) && (!FD())) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      return false;
    case 0: 
      if ((this.asv) || (this.asw)) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.qz() != 6) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.asA = bool;
      if ((!this.asv) && (!this.asw)) {
        break;
      }
      return true;
    }
  }
  
  public void run()
  {
    this.asw = true;
    aYd();
    aYf();
  }
  
  public void startAnim()
  {
    this.asv = true;
    this.asw = false;
    aYa();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController
 * JD-Core Version:    0.7.0.1
 */