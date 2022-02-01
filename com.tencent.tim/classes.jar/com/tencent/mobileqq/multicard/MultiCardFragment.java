package com.tencent.mobileqq.multicard;

import ajim;
import ajjd;
import ajje;
import ajjf;
import ajjh;
import ajji;
import ajjj;
import ajjl;
import ajjl.a;
import ajjn;
import ajjo;
import ajjp;
import ajjq;
import ajjr;
import ajjs;
import ajjt;
import ajju;
import ajjv;
import ajjw;
import ajjx;
import ajjy;
import ajkl;
import ajko;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.j;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import wja;

public class MultiCardFragment
  extends PublicBaseFragment
  implements ajjd, ajjl.a
{
  private View EJ;
  private ajjj jdField_a_of_type_Ajjj;
  private MultiAIOViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  private MultiCardShowArrow jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow = new MultiCardShowArrow(null);
  private ReportRunnable jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$ReportRunnable = new ReportRunnable();
  private a jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a;
  private MultiCardPageIndicator jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator;
  private MultiCardPagerAdapter jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter;
  private ValueAnimator av;
  private ValueAnimator aw;
  private boolean coY;
  private int djt;
  private int dju;
  private int djv = -1;
  private WeakReference<ajji> hp;
  private QQAppInterface mApp;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  public MultiCardFragment()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, System.identityHashCode(this) + " MultiCardFragment() called");
    }
  }
  
  private void Md(boolean paramBoolean)
  {
    vD(null);
    if (!paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) && (this.djv != this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.getCurrentItem()))
      {
        this.djv = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.getCurrentItem();
        if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
          this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.hideArrow();
        }
      }
    }
    for (;;)
    {
      this.mUiHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.hideArrow();
      }
    }
  }
  
  private void Me(boolean paramBoolean)
  {
    this.coY = paramBoolean;
    ajjf localajjf;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Ajjj == null) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager == null)) {}
      do
      {
        return;
        localajjf = this.jdField_a_of_type_Ajjj.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.getCurrentItem());
      } while (localajjf == null);
      Object localObject2 = this.jdField_a_of_type_Ajjj.getNickName(localajjf.getUin());
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localajjf.getUin();
      }
      try
      {
        if (this.hp != null)
        {
          localObject2 = (ajji)this.hp.get();
          if (localObject2 != null)
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(Long.valueOf(localajjf.getUin()));
            ((ajji)localObject2).b(localArrayList, true, true);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("MultiCardFragment", 2, "checkShowNickName exception:" + localException + "  " + localajjf.getUin());
        }
      }
      vD((String)localObject1);
      return;
    }
    vD(null);
  }
  
  private TopGestureLayout a(Activity paramActivity)
  {
    paramActivity = (FrameLayout)paramActivity.getWindow().getDecorView();
    int i = 0;
    while (i < paramActivity.getChildCount())
    {
      View localView = paramActivity.getChildAt(i);
      if ((localView instanceof TopGestureLayout)) {
        return (TopGestureLayout)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator = ((MultiCardPageIndicator)paramView.findViewById(2131369149));
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.c(this.mApp, getActivity());
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setMultiCardContext(this.jdField_a_of_type_Ajjj);
    }
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = ((MultiAIOViewPager)paramView.findViewById(2131381896));
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOffscreenPageLimit(3);
    }
    paramView = getResources();
    int i = (int)((paramView.getDisplayMetrics().widthPixels - wja.dp2px(42.0F, paramView) * 2) * (1.0F - ajje.MIN_SCALE) * 0.5F);
    int j = wja.dp2px(2.0F, paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageMargin(-(j + i));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageTransformer(false, new ajje());
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOnClickListener(new ajjr(this));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setTouchEventConsumer(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnClickListener(new ajjs(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setTouchEventConsumer(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter = new MultiCardPagerAdapter(getChildFragmentManager());
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter.a(this.jdField_a_of_type_Ajjj);
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setActTAG("MultiWindowCardFPS");
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setIdleListener(new ajjt(this));
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setFlingListener(new ajju(this));
    }
    paramView = new ajjv(this);
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnPageChangeListener(paramView);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnTabClickListener(new ajjw(this));
    }
    paramView.onPageScrollStateChanged(0);
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.a(new ajjx(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOnActionUpNotFling(new ajjy(this));
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setOverScrollMode(2);
    }
    paramView = a(getActivity());
    if (paramView != null) {
      paramView.setInterceptScrollLRFlag(false);
    }
  }
  
  private void a(a parama)
  {
    if (parama == null) {}
    do
    {
      return;
      if (parama.jdField_a_of_type_Ajjl != null) {
        parama.jdField_a_of_type_Ajjl.bZu();
      }
      float f3 = parama.c.getWidth();
      float f1 = parama.c.getHeight();
      float f4 = f3 / 2.0F;
      float f2 = f1 / 2.0F;
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setPivotX(f4);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setPivotY(f2);
      f4 = parama.mScaleX * parama.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getWidth() / 2.0F;
      f4 = parama.mMarginLeft;
      f4 = parama.mScaleY * parama.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight() / 2.0F;
      float f5 = parama.ZY;
      f3 = parama.mScaleX * parama.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getWidth() / f3;
      float f6 = parama.mScaleY * parama.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight() / f1;
      float f7 = (1.0F - f6 / f3) * f1 * f3 / 2.0F;
      this.aw = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aw.setDuration(400L);
      this.aw.addUpdateListener(new ajjn(this, parama, f3, f2 - (f4 + f5) - f7, f1, f6));
      this.aw.addListener(new ajjo(this));
      this.aw.start();
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator == null);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setVisibility(0);
  }
  
  private void b(a parama)
  {
    if (parama == null) {}
    do
    {
      return;
      if (parama.jdField_a_of_type_Ajjl != null) {
        parama.jdField_a_of_type_Ajjl.bZt();
      }
      ViewGroup localViewGroup = (ViewGroup)parama.c.getParent();
      float f1 = localViewGroup.getHeight();
      float f4 = parama.mScaleY;
      float f5 = parama.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getHeight();
      float f2 = parama.mScaleX * parama.c.getWidth() / localViewGroup.getWidth();
      float f3 = parama.mScaleY * parama.c.getHeight() / localViewGroup.getHeight();
      int i = parama.ZY;
      f4 = (int)(f4 * f5) / 2 + i;
      f5 = localViewGroup.getWidth() / 2;
      float f6 = localViewGroup.getHeight() / 2;
      float f7 = (1.0F - f3 / f2) * f1 * f2 / 2.0F;
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setPivotX(f5);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setPivotY(f6);
      this.av = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.av.setDuration(400L);
      this.av.addUpdateListener(new ajjp(this, parama, f2, f7 + (f4 - f6), f1, f3));
      this.av.addListener(new ajjq(this));
      this.av.start();
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setVisibility(0);
      }
      parama = new AlphaAnimation(1.0F, 0.0F);
      parama.setDuration(400L);
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.startAnimation(parama);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator == null);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.startAnimation(parama);
  }
  
  public static void cN(String paramString, int paramInt)
  {
    anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private void dxD()
  {
    ((FrameLayout)getActivity().getWindow().getDecorView()).removeView(this.EJ);
  }
  
  private void dxT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "scheduleShowArrow() ");
    }
    Md(false);
    this.mUiHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$MultiCardShowArrow, 100L);
  }
  
  private void dxU()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a != null)
    {
      ViewGroup localViewGroup = getContainerView();
      if ((localViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setScaleX(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setScaleY(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setTranslationX(0.0F);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setTranslationY(0.0F);
        localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.zoomOut();
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a = null;
    }
    this.aw = null;
  }
  
  private void dxV()
  {
    this.av = null;
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setScaleX(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setScaleY(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setTranslationX(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.c.setTranslationY(0.0F);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(8);
    }
  }
  
  private ViewGroup getContainerView()
  {
    if (this.hp != null)
    {
      ajji localajji = (ajji)this.hp.get();
      if (localajji != null) {
        return (ViewGroup)localajji.getRootView();
      }
    }
    return null;
  }
  
  private boolean ks(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "checkPreLoadData, nPos:" + paramInt + " requestPos:" + this.djt + " preloadcountL" + this.dju);
    }
    if (this.dju == 0) {
      return false;
    }
    if (paramInt == -1) {}
    try
    {
      this.djt = 0;
      if (this.dju + paramInt < this.djt) {
        return false;
      }
    }
    finally {}
    do
    {
      if ((this.jdField_a_of_type_Ajjj != null) && (this.jdField_a_of_type_Ajjj.Go() > this.djt))
      {
        if (this.hp != null)
        {
          ajji localajji = (ajji)this.hp.get();
          if (localajji != null)
          {
            ArrayList localArrayList = this.jdField_a_of_type_Ajjj.h(this.djt, this.dju);
            if ((localArrayList != null) && (localArrayList.size() > 0))
            {
              localajji.b(localArrayList, true, true);
              this.djt += localArrayList.size();
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardFragment", 2, "checkPreLoadData, end, requestPos:" + this.djt);
        }
        return true;
      }
    } while (this.djt < paramInt);
    return false;
  }
  
  private void unInit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "unInit");
    }
    this.mUiHandler.removeCallbacksAndMessages(null);
    if ((this.av != null) && (this.av.isRunning()))
    {
      this.av.cancel();
      this.av = null;
    }
    if ((this.aw != null) && (this.aw.isRunning()))
    {
      this.aw.cancel();
      this.aw = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter.a(null);
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPagerAdapter = null;
    }
    if (this.jdField_a_of_type_Ajjj != null) {
      this.jdField_a_of_type_Ajjj = null;
    }
    this.hp = null;
    this.mApp = null;
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator = null;
    MultiCardItemFragment.a.clear();
    for (Object localObject = (ajjl)MultiCardItemFragment.c.P(); localObject != null; localObject = (ajjl)MultiCardItemFragment.c.P()) {
      ((ajjl)localObject).unInit();
    }
    MultiCardItemFragment.c.clear();
    for (localObject = (ajjl)MultiCardItemFragment.b.P(); localObject != null; localObject = (ajjl)MultiCardItemFragment.b.P()) {
      ((ajjl)localObject).unInit();
    }
    MultiCardItemFragment.b.clear();
    for (localObject = (View)MultiCardItemFragment.d.P(); localObject != null; localObject = (View)MultiCardItemFragment.d.P()) {}
    MultiCardItemFragment.d.clear();
  }
  
  private void vD(String paramString)
  {
    if (this.hp != null)
    {
      ajji localajji = (ajji)this.hp.get();
      if (localajji != null) {
        localajji.setNickName(paramString);
      }
    }
  }
  
  public void Mc(boolean paramBoolean)
  {
    View localView = getView();
    if ((localView != null) && ((localView instanceof ViewGroup))) {
      ((ViewGroup)localView).requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void Rb(int paramInt)
  {
    if ((!ks(paramInt)) && (this.jdField_a_of_type_Ajjj != null) && (this.hp != null))
    {
      ajji localajji = (ajji)this.hp.get();
      if (localajji != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Ajjj.h(paramInt, 1);
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          localajji.b(localArrayList, true, true);
        }
      }
    }
  }
  
  public MultiAIOBaseViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  }
  
  public void a(MultiCardRootLayout paramMultiCardRootLayout, MultiCardCustomLayout paramMultiCardCustomLayout, ajjl paramajjl)
  {
    cN("0X800A214", 1);
    if ((paramajjl instanceof ajkl)) {
      cN("0X800A217", 1);
    }
    do
    {
      while (paramMultiCardRootLayout == null)
      {
        QLog.e("MultiCardFragment", 1, "onClick: view == null, activity was destroyed ?");
        return;
        if ((paramajjl instanceof ajjh)) {
          if ((paramajjl != null) && (paramajjl.a != null) && (paramajjl.a.aqV())) {
            cN("0X800A217", 3);
          } else {
            cN("0X800A217", 2);
          }
        }
      }
    } while ((this.aw != null) || (this.av != null) || (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a != null));
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a = new a(paramMultiCardRootLayout, paramMultiCardCustomLayout, paramajjl, this);
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a.zoomIn();
    paramMultiCardRootLayout = getContainerView();
    if (paramMultiCardRootLayout != null) {
      paramMultiCardRootLayout.addView(paramMultiCardCustomLayout, new RelativeLayout.LayoutParams(-1, -1));
    }
    b(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a);
  }
  
  public void a(List<Long> paramList, Map<Long, IntimateInfo> paramMap, Map<Long, String> paramMap1)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardFragment.1(this, paramList, paramMap, paramMap1));
  }
  
  public boolean aqW()
  {
    if (this.hp != null)
    {
      ajji localajji = (ajji)this.hp.get();
      if (localajji != null) {
        return localajji.coV;
      }
    }
    return false;
  }
  
  public void b(ajjl paramajjl)
  {
    if ((this.av != null) || (this.aw != null)) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a);
  }
  
  public void c(ajjl paramajjl)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a == null) {
      return;
    }
    b(paramajjl);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.av != null) && (this.av.isRunning())) {}
    while ((this.aw != null) && (this.aw.isRunning())) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void dxW()
  {
    if (this.hp != null)
    {
      ajji localajji = (ajji)this.hp.get();
      if (localajji != null) {
        localajji.dxR();
      }
    }
  }
  
  public void g(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator == null) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager == null) || (!this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.equals(paramView)) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.isScrollFinished()));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.dxM();
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardFragment$a != null) && (this.aw == null))
    {
      b(null);
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    localObject1 = null;
    do
    {
      try
      {
        View localView = paramLayoutInflater.inflate(2131559441, paramViewGroup, false);
        localObject2 = localView;
        localObject1 = localView;
        if (this.hp.get() != null)
        {
          localObject2 = localView;
          localObject1 = localView;
          if (((ajji)this.hp.get()).coV)
          {
            localObject1 = localView;
            localObject2 = (FrameLayout.LayoutParams)localView.getLayoutParams();
            localObject1 = localView;
            ((FrameLayout.LayoutParams)localObject2).topMargin = wja.dp2px(20.0F, getResources());
            localObject1 = localView;
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject2 = localView;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("MultiCardFragment", 1, "onCreateView: ", localThrowable);
          ajim.dxL();
          Object localObject3 = localObject1;
        }
      }
      localObject1 = localObject2;
    } while (localObject2 == null);
    a((View)localObject2, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, System.identityHashCode(this) + " onCreateView() cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, (View)localObject2);
    return localObject2;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onDestroy");
    }
    unInit();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onDestroyView");
    }
    TopGestureLayout localTopGestureLayout = a(getActivity());
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptScrollLRFlag(true);
    }
    dxD();
    if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator != null) {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardPageIndicator.destroy();
    }
    unInit();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onMultiWindowModeChanged() called MultiAIOFragment isInMultiWindowMode = " + paramBoolean);
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24)) {
      dxW();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  class MultiCardShowArrow
    implements Runnable
  {
    private MultiCardShowArrow() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardFragment", 2, "run() called MiniAIOScrollToNewMsg");
      }
      if (MultiCardFragment.a(MultiCardFragment.this) != null) {
        MultiCardFragment.a(MultiCardFragment.this).showArrow();
      }
    }
  }
  
  public static class ReportRunnable
    implements Runnable
  {
    public boolean coZ = true;
    private int mCurrentPos;
    private int mTargetPos;
    private int mTotalCount;
    
    public void Rc(int paramInt)
    {
      try
      {
        if (paramInt > this.mTargetPos) {
          this.mTargetPos = paramInt;
        }
        return;
      }
      finally {}
    }
    
    public void doReport()
    {
      ThreadManager.getSubThreadHandler().post(this);
    }
    
    public void init(int paramInt)
    {
      this.mCurrentPos = -1;
      this.mTargetPos = -1;
      this.mTotalCount = paramInt;
    }
    
    public void run()
    {
      int i;
      try
      {
        if (this.mCurrentPos == this.mTargetPos) {
          return;
        }
        i = this.mTargetPos - this.mCurrentPos;
        int j = this.mTotalCount - this.mTargetPos - 1;
        if (j >= 5) {
          i += 5;
        }
        for (;;)
        {
          this.mCurrentPos += i;
          this.mTargetPos = this.mCurrentPos;
          j = 0;
          while (j < i)
          {
            MultiCardFragment.cN("0X800A215", 0);
            j += 1;
          }
          i += j;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      finally {}
      QLog.d("MultiCardFragment", 2, "0X800A215_report:" + i + " pos:" + this.mCurrentPos);
    }
    
    public int uS()
    {
      return this.mTargetPos;
    }
  }
  
  public class a
  {
    public int ZY;
    public ajjl a;
    public MultiCardRootLayout a;
    public MultiCardCustomLayout c;
    public int djw;
    public ViewGroup.LayoutParams mLayoutParams;
    public int mMarginLeft;
    public float mScaleX;
    public float mScaleY;
    
    public a(MultiCardRootLayout paramMultiCardRootLayout, MultiCardCustomLayout paramMultiCardCustomLayout, ajjl paramajjl, ajjl.a parama)
    {
      this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout = paramMultiCardRootLayout;
      this.c = paramMultiCardCustomLayout;
      this.jdField_a_of_type_Ajjl = paramajjl;
      if (this.jdField_a_of_type_Ajjl != null) {
        this.jdField_a_of_type_Ajjl.a(parama);
      }
    }
    
    public void zoomIn()
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.Ma(false);
        this.mScaleX = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getScaleX();
        this.mScaleY = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.getScaleY();
      }
      if (this.c != null)
      {
        this.mLayoutParams = this.c.getLayoutParams();
        Object localObject = new int[2];
        this.c.getLocationOnScreen((int[])localObject);
        this.mMarginLeft = localObject[0];
        this.ZY = localObject[1];
        this.c.Ma(true);
        localObject = this.c.findViewById(2131372080);
        if (localObject != null)
        {
          this.djw = ((View)localObject).getVisibility();
          ((View)localObject).setVisibility(8);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null) && (this.c != null)) {
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.removeView(this.c);
      }
      if (this.jdField_a_of_type_Ajjl != null) {
        this.jdField_a_of_type_Ajjl.setMode(0);
      }
    }
    
    public void zoomOut()
    {
      if ((this.c != null) && (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout != null))
      {
        if ((this.c.getParent() instanceof ViewGroup)) {
          ((ViewGroup)this.c.getParent()).removeView(this.c);
        }
        this.c.Ma(false);
        this.c.setLayoutParams(this.mLayoutParams);
        this.c.setScaleX(1.0F);
        this.c.setScaleY(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.Ma(true);
        this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardRootLayout.addView(this.c, 0);
      }
      if (this.jdField_a_of_type_Ajjl != null) {
        this.jdField_a_of_type_Ajjl.setMode(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment
 * JD-Core Version:    0.7.0.1
 */