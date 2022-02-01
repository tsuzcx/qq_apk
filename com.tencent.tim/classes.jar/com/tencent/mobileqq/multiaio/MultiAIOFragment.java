package com.tencent.mobileqq.multiaio;

import aalb;
import acfp;
import achw;
import ajhk;
import ajhl;
import ajhm;
import ajhn;
import ajho;
import ajhp;
import ajhq;
import ajhr;
import ajhs;
import ajht;
import ajhu;
import ajhv;
import ajhw;
import ajhx;
import ajhy;
import ajhz;
import ajik;
import ajil;
import ajim;
import ajin;
import ajip;
import ajjd;
import ajje;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import android.widget.TextView;
import anot;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.g;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.j;
import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import com.tencent.mobileqq.multiaio.widget.TabPageIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.observer.BusinessObserver;
import wja;

public class MultiAIOFragment
  extends PublicBaseFragment
  implements ajip, ajjd, BusinessObserver
{
  private View EH;
  private View EI;
  private View EJ;
  private ValueAnimator W;
  private MiniAIOScrollToNewMsg jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$MiniAIOScrollToNewMsg = new MiniAIOScrollToNewMsg(null);
  private UpdateMsgReadTimer jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$UpdateMsgReadTimer = new UpdateMsgReadTimer(null);
  private MultiAIOPagerAdapter jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOPagerAdapter;
  private MultiAIOViewPager jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  private TabPageIndicator jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator;
  private QQAppInterface app;
  private ValueAnimator au;
  private achw b = new ajhq(this);
  private String bRv;
  private String bRw;
  private String bRx;
  private boolean coA;
  private boolean coB;
  private boolean coC;
  private boolean coD;
  private int diZ;
  private int dja;
  private int[] lP;
  private int[] lQ = new int[2];
  private List<RecentBaseData> mDataList;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  public MultiAIOFragment()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, System.identityHashCode(this) + " MultiAIOFragment() called");
    }
  }
  
  private void QP(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "scheduleUpdateMsgReadState() called with: position = [" + paramInt + "]");
    }
    dxE();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$UpdateMsgReadTimer.setPosition(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$MiniAIOScrollToNewMsg.setPosition(paramInt);
    this.mUiHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$UpdateMsgReadTimer, 1000L);
    this.mUiHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$MiniAIOScrollToNewMsg, 100L);
  }
  
  private void S(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.coA)) {}
    do
    {
      return;
      this.coA = true;
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "tryToPlayEnterAnimation() called with: decorViewBitmap = [" + paramBitmap + "]");
      }
    } while (!"open_from_aio".equals(this.bRv));
    T(paramBitmap);
  }
  
  private void T(Bitmap paramBitmap)
  {
    FrameLayout localFrameLayout = (FrameLayout)getActivity().getWindow().getDecorView();
    int i = ImmersiveUtils.getStatusBarHeight(getActivity());
    ImageView localImageView = new ImageView(getActivity());
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(paramBitmap.getWidth(), paramBitmap.getHeight());
    localMarginLayoutParams.leftMargin = 0;
    localMarginLayoutParams.topMargin = i;
    i = localMarginLayoutParams.leftMargin;
    int j = localMarginLayoutParams.topMargin;
    int k = localMarginLayoutParams.width;
    int m = localMarginLayoutParams.height;
    int n = getResources().getDimensionPixelSize(2131296441);
    int i2 = getResources().getDimensionPixelSize(2131296441);
    int i1 = getResources().getDimensionPixelOffset(2131296442);
    i2 = getResources().getDisplayMetrics().widthPixels - n - i2;
    int i3 = getResources().getDisplayMetrics().heightPixels - i1;
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "enterAnimation() called with: destinationWidth = [" + i2 + "], destinationHeight = [" + i3 + "]");
    }
    localImageView.setLayoutParams(localMarginLayoutParams);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localFrameLayout.addView(localImageView);
    this.W = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.W.setDuration(400);
    this.W.addUpdateListener(new ajhm(this, localImageView, i, n, j, i1, k, i2, i3, m));
    this.W.addListener(new ajhn(this, localImageView));
    this.W.start();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setVisibility(0);
    paramBitmap = new AlphaAnimation(0.0F, 1.0F);
    paramBitmap.setDuration(400);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.startAnimation(paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.startAnimation(paramBitmap);
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
  
  private void a(Context paramContext, View paramView, int paramInt1, RecentBaseData paramRecentBaseData, boolean paramBoolean, Bitmap paramBitmap, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "openAIO() called with: recentBaseData = [" + paramRecentBaseData + "], showKeyBoard = [" + paramBoolean + "]");
    }
    paramContext = getActivity();
    if (paramContext == null)
    {
      QLog.e("MultiAioFragment", 1, "openAIO: activity == null 1");
      return;
    }
    paramView = paramContext.getIntent();
    RecentUser localRecentUser;
    Bundle localBundle;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      localRecentUser = ((RecentUserBaseData)paramRecentBaseData).a();
      localBundle = new Bundle();
      localBundle.putBoolean("KEY_SHOULD_SHOW_KEYBOARD", paramBoolean);
      localBundle.putBoolean("open_chatfragment_withanim", false);
      localBundle.putInt("KEY_MULTI_WINDOW_AIO_CONTEXT_ID", this.dja);
      localBundle.putBoolean("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", true);
      if (SplashActivity.dO == null) {
        break label336;
      }
      paramContext = (Activity)SplashActivity.dO.get();
    }
    label336:
    for (;;)
    {
      paramView = paramView.getStringExtra("OPEN_MULTI_FROM_ACTIVITY");
      paramBoolean = ChatActivity.class.getSimpleName().equals(paramView);
      if (paramBoolean)
      {
        localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
        paramContext = null;
      }
      paramView = paramContext;
      if (paramContext == null) {
        paramView = getActivity();
      }
      if (paramView == null)
      {
        QLog.e("MultiAioFragment", 1, "openAIO: activity == null 2");
        return;
      }
      paramContext = a();
      paramContext.LY(true);
      paramContext.QV(paramInt2);
      if (!paramBoolean)
      {
        aalb.a(paramView, this.app, localRecentUser, paramRecentBaseData.mTitleName, true, 2, null, localBundle, null);
        a(paramBitmap, paramArrayOfInt);
        return;
      }
      Intent[] arrayOfIntent = new Intent[1];
      aalb.a(paramView, this.app, localRecentUser, paramRecentBaseData.mTitleName, true, 2, null, localBundle, arrayOfIntent);
      paramContext.bI(arrayOfIntent[0]);
      a(paramBitmap, paramArrayOfInt);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MultiAioFragment", 2, "openAIO() called with: recentBaseData is wrong type");
      return;
    }
  }
  
  private void a(Bitmap paramBitmap, int[] paramArrayOfInt)
  {
    ViewGroup localViewGroup = (ViewGroup)getView();
    ImageView localImageView = new ImageView(localViewGroup.getContext());
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(i, j);
    localMarginLayoutParams.leftMargin = paramArrayOfInt[0];
    localMarginLayoutParams.topMargin = paramArrayOfInt[1];
    int k = localMarginLayoutParams.topMargin;
    int m = localMarginLayoutParams.leftMargin;
    localImageView.setLayoutParams(localMarginLayoutParams);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    ((FrameLayout)getActivity().getWindow().getDecorView()).addView(localImageView);
    int n = ImmersiveUtils.getStatusBarHeight(getActivity());
    int i1 = this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.getWidth();
    int i2 = localViewGroup.getHeight();
    this.au = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.au.setDuration(400);
    this.au.addUpdateListener(new ajho(this, localImageView, m, k, n, i, i1, j, i2 - n));
    this.au.addListener(new ajhp(this));
    this.au.start();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setVisibility(0);
    paramBitmap = new AlphaAnimation(1.0F, 0.0F);
    paramBitmap.setDuration(400);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.startAnimation(paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.startAnimation(paramBitmap);
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator = ((TabPageIndicator)paramView.findViewById(2131369149));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.c(this.app, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager = ((MultiAIOViewPager)paramView.findViewById(2131381896));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOffscreenPageLimit(2);
    paramBundle = getResources();
    int i = (int)((paramBundle.getDisplayMetrics().widthPixels - wja.dp2px(42.0F, paramBundle) * 2) * (1.0F - ajje.MIN_SCALE) * 0.5F);
    int j = wja.dp2px(2.0F, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageMargin(-(j + i));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setPageTransformer(false, new ajje());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setOnClickListener(new ajhr(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setTouchEventConsumer(this);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnClickListener(new ajhs(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setTouchEventConsumer(this);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOPagerAdapter = new MultiAIOPagerAdapter(getChildFragmentManager());
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOPagerAdapter.cS(this.mDataList);
    paramBundle = a();
    j = this.mDataList.size();
    i = j;
    if (j > 0) {
      i = 0;
    }
    paramBundle.a(getActivity().getLayoutInflater(), this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager, i);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setActTAG("MultiWindowAIOFPS");
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setIdleListener(new ajht(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.setFlingListener(new ajhu(this));
    Object localObject = new ajhv(this);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnPageChangeListener((MultiAIOBaseViewPager.g)localObject);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnTabClickListener(new ajhw(this));
    ((MultiAIOBaseViewPager.j)localObject).onPageScrollStateChanged(0);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.a(new ajhx(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOnActionUpNotFling(new ajhy(this));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.setOverScrollMode(2);
    localObject = a(getActivity());
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptScrollLRFlag(false);
    }
    localObject = paramBundle.aA();
    paramBundle.V(null);
    S((Bitmap)localObject);
    d(paramView, paramBundle.aB());
    paramBundle.W(null);
  }
  
  private void bk(Activity paramActivity)
  {
    paramActivity = paramActivity.getIntent();
    if (paramActivity != null)
    {
      this.bRv = paramActivity.getStringExtra("conversation_tab_flag");
      this.bRw = paramActivity.getStringExtra("uin");
      this.diZ = paramActivity.getIntExtra("uintype", -1);
      this.bRx = paramActivity.getStringExtra("uinname");
      this.dja = paramActivity.getIntExtra("OPEN_MULTI_AIO_CONTEXT", 0);
      this.lP = paramActivity.getIntArrayExtra("OPEN_MULTI_AIO_LIST_VIEW_SPECIFY_BOTTOM");
    }
  }
  
  public static void cN(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "report() called with: key = [" + paramString + "], fromType = [" + paramInt + "]");
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private void d(View paramView, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "tryToSetBlurBackground() called with: root = [" + paramView + "], blurBitmap = [" + paramBitmap + "]");
    }
    if (this.coB) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          localView = paramView;
          if (paramView == null) {
            localView = getView();
          }
        } while (localView == null);
        if (paramBitmap != null) {
          break;
        }
        localView.setBackgroundColor(Color.parseColor("#7F000000"));
      } while (!QLog.isColorLevel());
      QLog.d("MultiAioFragment", 2, "tryToSetBlurBackground() setBackgroundColor");
      return;
      this.coB = true;
      paramView = getActivity();
    } while ((paramView == null) || (paramView.isFinishing()));
    paramView = new BitmapDrawable(paramBitmap);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "tryToSetBlurBackground() called with: root = [" + localView + "], blurBitmap = [" + paramBitmap + "]");
    }
    localView.setBackgroundDrawable(paramView);
  }
  
  private void dxB()
  {
    dxD();
    FragmentActivity localFragmentActivity = getActivity();
    ViewGroup localViewGroup = (ViewGroup)localFragmentActivity.getWindow().getDecorView();
    this.EJ = localFragmentActivity.getLayoutInflater().inflate(2131561197, localViewGroup, false);
    this.EJ.findViewById(2131363906).setOnClickListener(new ajhk(this));
    this.EJ.findViewById(2131363767).setOnClickListener(new ajhl(this));
    ((TextView)this.EJ.findViewById(2131381020)).setText(acfp.m(2131708565) + ajin.djl);
    dxC();
    localViewGroup.addView(this.EJ);
  }
  
  private void dxC()
  {
    float f = ajin.djl * 1.0F / 20.0F;
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.aU(f);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.aU(f);
  }
  
  private void dxD()
  {
    ((FrameLayout)getActivity().getWindow().getDecorView()).removeView(this.EJ);
  }
  
  private void dxE()
  {
    this.mUiHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$UpdateMsgReadTimer);
    this.mUiHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOFragment$MiniAIOScrollToNewMsg);
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.hideArrow();
  }
  
  private void dxF()
  {
    if (this.coC) {
      return;
    }
    this.mUiHandler.postDelayed(new MultiAIOFragment.16(this), 500L);
    this.coC = true;
  }
  
  private void finishActivity()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      localFragmentActivity.finish();
    }
  }
  
  private boolean l(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.findViewById(2131369276);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[0];
    int m = paramView.getWidth();
    int n = arrayOfInt[1];
    localRect.set(i, j, k + m, paramView.getHeight() + n);
    return localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
  
  private void r(ImageView paramImageView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramImageView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramImageView);
    }
    this.W = null;
  }
  
  private void registerListener()
  {
    this.app.a(this.b);
  }
  
  private int s(View paramView)
  {
    int j = 0;
    paramView = ((ChatXListView)paramView.findViewById(2131370537)).getAdapter();
    int i = 0;
    if (i < paramView.getCount())
    {
      Object localObject = paramView.getItem(i);
      int k;
      if (localObject == null) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j;
        if ((localObject instanceof ChatMessage)) {
          k = j + 1;
        }
      }
    }
    return j;
  }
  
  public int[] T()
  {
    return this.lP;
  }
  
  public int[] U()
  {
    return this.lQ;
  }
  
  public ajil a()
  {
    return ((ajik)getActivity().app.getManager(325)).b(this.dja);
  }
  
  public RecentBaseData a(int paramInt)
  {
    try
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.mDataList.get(paramInt);
      return localRecentBaseData;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAioFragment", 1, "getData: ", localException);
      finishActivity();
    }
    return null;
  }
  
  public MultiAIOBaseViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.W != null) && (this.W.isRunning())) {}
    while ((this.au != null) && (this.au.isRunning())) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void dxG()
  {
    finishActivity();
  }
  
  public ListView e()
  {
    if (this.EI != null) {
      return (ListView)this.EI.findViewById(2131370537);
    }
    return null;
  }
  
  /* Error */
  public void f(View paramView, MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 95
    //   6: iconst_1
    //   7: ldc_w 919
    //   10: invokestatic 364	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 922	android/view/View:getTag	()Ljava/lang/Object;
    //   18: checkcast 924	java/lang/Integer
    //   21: invokevirtual 927	java/lang/Integer:intValue	()I
    //   24: istore_3
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial 929	com/tencent/mobileqq/multiaio/MultiAIOFragment:l	(Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   31: istore 5
    //   33: aload_1
    //   34: ldc_w 930
    //   37: invokevirtual 493	android/view/View:findViewById	(I)Landroid/view/View;
    //   40: astore 6
    //   42: aload_1
    //   43: invokevirtual 933	android/view/View:destroyDrawingCache	()V
    //   46: aload_1
    //   47: iconst_1
    //   48: invokevirtual 936	android/view/View:setDrawingCacheEnabled	(Z)V
    //   51: aload 6
    //   53: ifnull +10 -> 63
    //   56: aload 6
    //   58: bipush 8
    //   60: invokevirtual 937	android/view/View:setVisibility	(I)V
    //   63: aload_1
    //   64: invokevirtual 940	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   67: astore 7
    //   69: aload 7
    //   71: aload 7
    //   73: invokevirtual 202	android/graphics/Bitmap:getWidth	()I
    //   76: i2f
    //   77: aload_1
    //   78: invokevirtual 943	android/view/View:getScaleX	()F
    //   81: fmul
    //   82: f2i
    //   83: aload 7
    //   85: invokevirtual 205	android/graphics/Bitmap:getHeight	()I
    //   88: i2f
    //   89: aload_1
    //   90: invokevirtual 946	android/view/View:getScaleY	()F
    //   93: fmul
    //   94: f2i
    //   95: iconst_1
    //   96: invokestatic 950	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   99: astore 7
    //   101: iconst_2
    //   102: newarray int
    //   104: astore 8
    //   106: aload_1
    //   107: aload 8
    //   109: invokevirtual 822	android/view/View:getLocationOnScreen	([I)V
    //   112: aload_0
    //   113: aload_1
    //   114: invokespecial 952	com/tencent/mobileqq/multiaio/MultiAIOFragment:s	(Landroid/view/View;)I
    //   117: istore 4
    //   119: aload_0
    //   120: aload_1
    //   121: putfield 911	com/tencent/mobileqq/multiaio/MultiAIOFragment:EI	Landroid/view/View;
    //   124: aload_0
    //   125: aload_1
    //   126: invokevirtual 953	android/view/View:getContext	()Landroid/content/Context;
    //   129: aload_1
    //   130: iload_3
    //   131: aload_0
    //   132: getfield 550	com/tencent/mobileqq/multiaio/MultiAIOFragment:mDataList	Ljava/util/List;
    //   135: iload_3
    //   136: invokeinterface 894 2 0
    //   141: checkcast 448	com/tencent/mobileqq/activity/recent/RecentBaseData
    //   144: iload 5
    //   146: aload 7
    //   148: aload 8
    //   150: iload 4
    //   152: invokespecial 955	com/tencent/mobileqq/multiaio/MultiAIOFragment:a	(Landroid/content/Context;Landroid/view/View;ILcom/tencent/mobileqq/activity/recent/RecentBaseData;ZLandroid/graphics/Bitmap;[II)V
    //   155: iload 5
    //   157: ifeq +33 -> 190
    //   160: iconst_2
    //   161: istore_3
    //   162: ldc_w 957
    //   165: iload_3
    //   166: invokestatic 959	com/tencent/mobileqq/multiaio/MultiAIOFragment:cN	(Ljava/lang/String;I)V
    //   169: aload 6
    //   171: ifnull +9 -> 180
    //   174: aload 6
    //   176: iconst_0
    //   177: invokevirtual 937	android/view/View:setVisibility	(I)V
    //   180: aload_1
    //   181: iconst_0
    //   182: invokevirtual 936	android/view/View:setDrawingCacheEnabled	(Z)V
    //   185: aload_1
    //   186: invokevirtual 933	android/view/View:destroyDrawingCache	()V
    //   189: return
    //   190: iconst_1
    //   191: istore_3
    //   192: goto -30 -> 162
    //   195: astore 7
    //   197: ldc 95
    //   199: iconst_1
    //   200: iconst_2
    //   201: anewarray 961	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: ldc_w 963
    //   209: aastore
    //   210: dup
    //   211: iconst_1
    //   212: aload_2
    //   213: aastore
    //   214: invokestatic 966	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   217: invokestatic 971	ajim:dxL	()V
    //   220: aload 6
    //   222: ifnull +9 -> 231
    //   225: aload 6
    //   227: iconst_0
    //   228: invokevirtual 937	android/view/View:setVisibility	(I)V
    //   231: aload_1
    //   232: iconst_0
    //   233: invokevirtual 936	android/view/View:setDrawingCacheEnabled	(Z)V
    //   236: aload_1
    //   237: invokevirtual 933	android/view/View:destroyDrawingCache	()V
    //   240: return
    //   241: astore_2
    //   242: aload 6
    //   244: ifnull +9 -> 253
    //   247: aload 6
    //   249: iconst_0
    //   250: invokevirtual 937	android/view/View:setVisibility	(I)V
    //   253: aload_1
    //   254: iconst_0
    //   255: invokevirtual 936	android/view/View:setDrawingCacheEnabled	(Z)V
    //   258: aload_1
    //   259: invokevirtual 933	android/view/View:destroyDrawingCache	()V
    //   262: aload_2
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	MultiAIOFragment
    //   0	264	1	paramView	View
    //   0	264	2	paramMotionEvent	MotionEvent
    //   24	168	3	i	int
    //   117	34	4	j	int
    //   31	125	5	bool	boolean
    //   40	208	6	localView	View
    //   67	80	7	localBitmap	Bitmap
    //   195	1	7	localThrowable	Throwable
    //   104	45	8	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   42	51	195	java/lang/Throwable
    //   56	63	195	java/lang/Throwable
    //   63	155	195	java/lang/Throwable
    //   162	169	195	java/lang/Throwable
    //   42	51	241	finally
    //   56	63	241	finally
    //   63	155	241	finally
    //   162	169	241	finally
    //   197	220	241	finally
  }
  
  public void g(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      return;
      this.EH = paramView;
    } while ((!this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.equals(paramView)) || (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.isScrollFinished()));
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.dxM();
  }
  
  public void iI(int paramInt1, int paramInt2)
  {
    this.lQ[0] = paramInt1;
    this.lQ[1] = paramInt2;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    bk(paramActivity);
    if (!"open_from_aio".equals(this.bRv)) {}
    for (int i = 2130772006;; i = 0)
    {
      paramActivity.overridePendingTransition(i, 0);
      return;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onAttach() called with: activity = [" + paramActivity + "]");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app = ((QQAppInterface)getActivity().getAppRuntime());
    this.app.registObserver(this);
    ajil localajil2 = a();
    ajil localajil1 = localajil2;
    if (localajil2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "onCreate() called with: savedInstanceState = [" + paramBundle + "], multiAioContext == null");
      }
      localajil1 = ajil.a(this.app);
      this.dja = localajil1.getId();
    }
    localajil1.a(this);
    this.mDataList = localajil1.a(this.app, getActivity(), this.bRv, this.diZ, this.bRw, this.bRx);
    int i;
    if ((this.mDataList == null) || (this.mDataList.size() == 0))
    {
      i = 1;
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiAioFragment", 2, "onCreate() called with: savedInstanceState != null finish Activity");
        }
        i = 1;
      }
      if (i != 0) {
        finishActivity();
      }
      if (!"open_from_aio".equals(this.bRv)) {
        break label209;
      }
      i = 1;
    }
    for (;;)
    {
      cN("0X8009F7D", i);
      return;
      i = 0;
      break;
      label209:
      if ("conversation_tab_bottom".equals(this.bRv)) {
        i = 2;
      } else if ("conversation_tab_list".equals(this.bRv)) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = null;
    try
    {
      View localView;
      do
      {
        localView = paramLayoutInflater.inflate(2131561198, paramViewGroup, false);
        localObject1 = localView;
      } while (localView == null);
      a(localView, paramBundle);
      registerListener();
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, System.identityHashCode(this) + " onCreateView() cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, localView);
      return localView;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MultiAioFragment", 1, "onCreateView: ", localThrowable);
        ajim.dxL();
        Object localObject2 = localObject1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mUiHandler.removeCallbacksAndMessages(null);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (localFragmentActivity.isFinishing()))
    {
      ajhz.clear();
      ((ajik)this.app.getManager(325)).a(this.dja);
    }
    if ((this.au != null) && (this.au.isRunning()))
    {
      this.au.cancel();
      this.au = null;
    }
    if ((this.W != null) && (this.W.isRunning()))
    {
      this.W.cancel();
      this.W = null;
    }
    if (this.app != null)
    {
      this.app.a(null);
      this.app.unRegistObserver(this);
    }
    ajig.coN = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    TopGestureLayout localTopGestureLayout = a(getActivity());
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptScrollLRFlag(true);
    }
    dxD();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetTabPageIndicator.destroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onMultiWindowModeChanged() called MultiAIOFragment isInMultiWindowMode = " + paramBoolean);
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24)) {
      finishActivity();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager.pause();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onReceive() called with: type = [" + paramInt + "], isSuccess = [" + paramBoolean + "]");
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      S((Bitmap)paramBundle.getParcelable("KEY_AIO_BITMAP"));
      return;
    } while (!paramBoolean);
    Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("KEY_AIO_BITMAP_BLURED");
    View localView = getView();
    paramBundle = localView;
    if (localView != null) {
      paramBundle = localView.findViewById(2131372057);
    }
    d(paramBundle, localBitmap);
  }
  
  public void onResume()
  {
    super.onResume();
    SystemBarCompact localSystemBarCompact = getActivity().mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(false, 0);
    }
    if (ajin.coQ) {}
    dxC();
  }
  
  class MiniAIOScrollToNewMsg
    implements Runnable
  {
    private boolean coE;
    private int dji;
    private int mPosition;
    
    private MiniAIOScrollToNewMsg() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "run() called MiniAIOScrollToNewMsg");
      }
      MultiAIOFragment.a(MultiAIOFragment.this).QT(this.mPosition);
      MultiAIOFragment.a(MultiAIOFragment.this).showArrow();
      if ((this.dji != this.mPosition) && (this.coE) && (MultiAIOFragment.b(MultiAIOFragment.this) != null))
      {
        if (!MultiAIOFragment.b(MultiAIOFragment.this).equals(MultiAIOFragment.a(MultiAIOFragment.this))) {
          break label159;
        }
        MultiAIOFragment.cN("0X8009F7E", 1);
      }
      label159:
      while (!MultiAIOFragment.b(MultiAIOFragment.this).equals(MultiAIOFragment.a(MultiAIOFragment.this)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiAioFragment", 2, "run() MiniAIOScrollToNewMsg pageChanged from = " + this.dji + " to = " + this.mPosition + ", view = " + MultiAIOFragment.b(MultiAIOFragment.this));
        }
        this.coE = false;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "run() MiniAIOScrollToNewMsg mClickAvatarTab = " + MultiAIOFragment.a(MultiAIOFragment.this));
      }
      if (MultiAIOFragment.a(MultiAIOFragment.this)) {
        MultiAIOFragment.cN("0X8009F7E", 3);
      }
      for (;;)
      {
        MultiAIOFragment.a(MultiAIOFragment.this, false);
        break;
        MultiAIOFragment.cN("0X8009F7E", 2);
      }
    }
    
    public void setPosition(int paramInt)
    {
      if (this.mPosition != paramInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiAioFragment", 2, "setPosition() from = [" + this.mPosition + "], to = [" + paramInt + "]");
        }
        this.dji = this.mPosition;
        this.mPosition = paramInt;
        this.coE = true;
      }
    }
  }
  
  class UpdateMsgReadTimer
    implements Runnable
  {
    private int mPosition;
    
    private UpdateMsgReadTimer() {}
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAioFragment", 2, "run() called UpdateMsgReadTimer");
      }
      MultiAIOFragment.a(MultiAIOFragment.this).QS(this.mPosition);
    }
    
    public void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment
 * JD-Core Version:    0.7.0.1
 */