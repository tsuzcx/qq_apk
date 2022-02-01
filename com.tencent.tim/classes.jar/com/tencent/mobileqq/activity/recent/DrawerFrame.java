package com.tencent.mobileqq.activity.recent;

import aaix;
import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import ankt;
import aqcl;
import aqgz;
import auru;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  public static final boolean DEBUG = ;
  public static int cgR = 0;
  private StringBuilder L;
  private int MAX_Y;
  private int MIN_Y;
  private a jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a;
  private c jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$c;
  private int actionFlag;
  private FrameHelperActivity b;
  private boolean brq;
  private boolean bvL = true;
  private boolean bvM;
  private boolean bvN;
  private boolean bvO;
  private boolean bvP = true;
  private boolean bvQ = true;
  private boolean bvR = true;
  private int cgS;
  private int cgT;
  private int cgU;
  private int cgV;
  private int cgW;
  private int cgX;
  private int cgY;
  private int cgZ;
  private int cha;
  private int chb;
  private int chc;
  private int chd = 0;
  private int che = -1;
  private int chf;
  private ViewGroup dJ;
  private ViewGroup dK;
  private ViewGroup dL;
  private Map<Integer, c> iC = new HashMap();
  public boolean isTouchable = true;
  private auru j;
  private ViewGroup mContentView;
  private int mHeight;
  private Scroller mScroller;
  private VelocityTracker mVelocityTracker;
  private int mWidth;
  private final float rq = 0.8F;
  private final float rr = 0.7F;
  private final float rs = 0.4F;
  private View zv;
  private View zw;
  private View zx;
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3, FrameHelperActivity paramFrameHelperActivity)
    throws NullPointerException
  {
    super(paramContext);
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.actionFlag = 0;
    this.cgZ = ((int)(localDisplayMetrics.density * 100.0F + 0.5D));
    this.chb = localResources.getDimensionPixelSize(2131298881);
    this.cgU = localResources.getDimensionPixelSize(2131299314);
    this.cha = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    this.bvP = bool;
    this.j = new auru(Looper.getMainLooper(), this);
    this.mScroller = new Scroller(paramContext, new b());
    if ((paramContext instanceof Activity)) {}
    for (this.che = aqgz.q((Activity)paramContext);; this.che = paramContext.getResources().getConfiguration().orientation)
    {
      if (DEBUG) {
        u("DrawerFrame", null);
      }
      this.b = paramFrameHelperActivity;
      a(paramViewGroup1, paramViewGroup2, paramView, paramViewGroup3);
      gp(this.chd, 1);
      return;
    }
  }
  
  private void Cn(boolean paramBoolean)
  {
    ApngImage.pauseByTag(1);
    if (!isDraggable()) {
      return;
    }
    Scroller localScroller;
    int k;
    int m;
    if (this.bvN)
    {
      this.j.removeMessages(1);
      this.j.removeMessages(2);
      this.j.removeMessages(4);
      this.j.removeMessages(3);
      this.bvN = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a.AD(this.chd);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a.aC(this.chd, false);
      }
      localScroller = this.mScroller;
      k = this.cgS;
      m = -this.cgS;
      if (!paramBoolean) {
        break label152;
      }
    }
    label152:
    for (int i = 300;; i = 0)
    {
      localScroller.startScroll(k, 0, m, 0, i);
      this.j.sendEmptyMessage(2);
      return;
      if (this.bvM) {
        break;
      }
      return;
    }
  }
  
  private boolean Wv()
  {
    if ((this.che == 1) && (this.mWidth > this.mHeight)) {}
    while ((this.che == 0) && (this.mWidth < this.mHeight)) {
      return false;
    }
    return true;
  }
  
  private void ba(int paramInt, boolean paramBoolean)
  {
    this.actionFlag = 2;
    if (!this.bvM)
    {
      openDrawer(paramInt, paramBoolean);
      return;
    }
    Cn(paramBoolean);
  }
  
  private void gp(int paramInt1, int paramInt2)
  {
    int k = 0;
    int i;
    if (paramInt2 == 1)
    {
      i = 8;
      if ((this.dL != null) && (this.dL.getVisibility() != i)) {
        this.dL.setVisibility(i);
      }
      if ((paramInt2 != 1) && (paramInt1 != 1)) {
        break label197;
      }
      i = 8;
      label50:
      if ((this.dK != null) && (this.dK.getVisibility() != i)) {
        this.dK.setVisibility(i);
      }
      if ((paramInt2 != 1) && (paramInt1 != 0)) {
        break label202;
      }
      paramInt1 = 8;
      label88:
      if ((this.zv != null) && (this.zv.getVisibility() != paramInt1)) {
        this.zv.setVisibility(paramInt1);
      }
      if ((paramInt2 != 2) && (paramInt2 != 0)) {
        break label207;
      }
      paramInt1 = 0;
      label125:
      if ((this.zw != null) && (this.zw.getVisibility() != paramInt1) && (this.bvQ)) {
        this.zw.setVisibility(paramInt1);
      }
      if (paramInt2 != 0) {
        break label213;
      }
    }
    label197:
    label202:
    label207:
    label213:
    for (paramInt1 = k;; paramInt1 = 8)
    {
      if ((this.zx != null) && (this.zx.getVisibility() != paramInt1)) {
        this.zx.setVisibility(paramInt1);
      }
      return;
      i = 0;
      break;
      i = 0;
      break label50;
      paramInt1 = 0;
      break label88;
      paramInt1 = 8;
      break label125;
    }
  }
  
  private boolean isDraggable()
  {
    return (this.bvL) && (this.dK != null) && (this.mContentView != null);
  }
  
  private void openDrawer(int paramInt, boolean paramBoolean)
  {
    int i = 300;
    if (!isDraggable()) {
      return;
    }
    this.chd = paramInt;
    if (this.bvN)
    {
      this.j.removeMessages(1);
      this.j.removeMessages(2);
      this.j.removeMessages(4);
      this.j.removeMessages(3);
      label56:
      if (this.chd != 0) {
        break label156;
      }
      this.dK.setVisibility(0);
    }
    for (;;)
    {
      this.bvN = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a.AD(this.chd);
      }
      switch (paramInt)
      {
      default: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a.aC(paramInt, true);
        }
        this.j.sendEmptyMessage(1);
        return;
        if (!this.bvM) {
          break label56;
        }
        return;
        label156:
        if (this.chd == 1) {
          this.zv.setVisibility(0);
        }
        break;
      }
    }
    Scroller localScroller = this.mScroller;
    int k = this.cgS;
    int m = this.cgT;
    int n = this.cgS;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(k, 0, m - n, 0, i);
      break;
      i = 1;
    }
    localScroller = this.mScroller;
    k = this.cgS;
    m = -this.cgU;
    n = this.cgS;
    if (paramBoolean) {}
    for (;;)
    {
      localScroller.startScroll(k, 0, m - n, 0, i);
      break;
      i = 1;
    }
  }
  
  private void u(String paramString, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      if (this.L != null) {
        break label150;
      }
      this.L = new StringBuilder(120);
    }
    for (;;)
    {
      this.L.append(paramString).append(", mConfigurationFlag = ").append(this.chf).append(", mCurOrientation = ").append(this.che).append(", mDecorOffsetX = ").append(this.cgS).append(", mLeftDrawerWidth = ").append(this.cgT).append(", mConfigurationFlag = ").append(this.chf).append(", mWidth = ").append(this.mWidth).append(", mHeight =").append(this.mHeight).append(", param = ").append(paramObject);
      QLog.i("DrawerFrame", 4, this.L.toString());
      return;
      label150:
      this.L.setLength(0);
    }
  }
  
  public void FW(int paramInt)
  {
    this.iC.remove(Integer.valueOf(paramInt));
  }
  
  public boolean Ws()
  {
    return this.bvL;
  }
  
  public boolean Wt()
  {
    return this.bvM;
  }
  
  public boolean Wu()
  {
    return this.bvN;
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, View paramView, ViewGroup paramViewGroup3)
  {
    int i = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    int k = i - yD();
    int m = ankt.dip2px(170.0F);
    if (QLog.isColorLevel()) {
      QLog.d("DrawerFrame", 2, "Screen:(" + i + "," + ankt.cIE + ") cover:(" + k + "," + m + ")");
    }
    if (paramViewGroup3 != this.dL)
    {
      if (this.dL != null) {
        removeView(this.dL);
      }
      this.dL = paramViewGroup3;
      if (this.dL != null)
      {
        paramViewGroup3 = (RandomCoverView)this.dL.findViewById(2131380003);
        if (paramViewGroup3 != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup3.getLayoutParams();
          localLayoutParams.width = k;
          localLayoutParams.height = m;
          paramViewGroup3.setLayoutParams(localLayoutParams);
          paramViewGroup3.setDefaultCoverBg();
        }
        paramViewGroup3 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.dL, paramViewGroup3);
      }
    }
    if (paramViewGroup2 != this.dK)
    {
      if (this.dK != null) {
        removeView(this.dK);
      }
      this.dK = paramViewGroup2;
      if (this.dK != null)
      {
        paramViewGroup2 = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.dK, paramViewGroup2);
      }
    }
    if (paramView != this.zv)
    {
      if (this.zv != null) {
        removeView(this.zv);
      }
      this.zv = paramView;
      if (this.zv != null)
      {
        paramViewGroup2 = new FrameLayout.LayoutParams(-2, -1, 21);
        addView(this.zv, paramViewGroup2);
      }
    }
    if (paramViewGroup1 != this.mContentView)
    {
      if (this.mContentView != null)
      {
        removeView(this.mContentView);
        if (this.dJ != null)
        {
          this.dJ.removeView(this);
          this.dJ.addView(this.mContentView);
          this.dJ.setOnClickListener(null);
          this.dJ = null;
        }
      }
      this.mContentView = paramViewGroup1;
      aqcl.R(this.mContentView, true);
      if (this.mContentView != null)
      {
        paramViewGroup1 = this.mContentView.getParent();
        if (!(paramViewGroup1 instanceof ViewGroup)) {
          break label711;
        }
        this.dJ = ((ViewGroup)paramViewGroup1);
        this.dJ.removeView(this.mContentView);
        paramViewGroup1 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.mContentView, paramViewGroup1);
      }
      if ((this.dK == null) || (!this.bvP)) {
        break label736;
      }
      if (this.zw == null)
      {
        this.zw = new View(getContext());
        this.zw.setBackgroundColor(0);
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label719;
      }
      this.bvQ = true;
      this.zw.setVisibility(0);
      label539:
      paramViewGroup1 = new FrameLayout.LayoutParams(-1, -1);
      if (this.mContentView != null) {
        this.mContentView.addView(this.zw, paramViewGroup1);
      }
    }
    for (;;)
    {
      if (this.dJ != null)
      {
        this.dJ.addView(this);
        this.dJ.setOnClickListener(new aaix(this));
      }
      if ((this.dK != null) && (this.zx == null))
      {
        this.zx = new View(getContext());
        this.zx.setFocusable(true);
        this.zx.setFocusableInTouchMode(true);
        this.zx.setClickable(true);
        this.zx.setVisibility(8);
        this.zx.setBackgroundResource(17170445);
        this.zx.setContentDescription(acfp.m(2131705312));
        paramViewGroup1 = new FrameLayout.LayoutParams(this.cgT, this.chc, 21);
        addView(this.zx, paramViewGroup1);
      }
      return;
      label711:
      this.dJ = null;
      break;
      label719:
      this.bvQ = false;
      this.zw.setVisibility(8);
      break label539;
      label736:
      if ((this.zw != null) && (this.mContentView != null)) {
        this.mContentView.removeView(this.zw);
      }
    }
  }
  
  public void cuA()
  {
    Cn(true);
  }
  
  public void cut()
  {
    if (this.zw != null) {
      this.zw.setVisibility(8);
    }
    this.bvQ = false;
  }
  
  public void cuu()
  {
    if (this.zw != null) {
      this.zw.setVisibility(0);
    }
    this.bvQ = true;
  }
  
  public void cuv()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DrawerFrame", 2, "stopMovingOnPause");
    }
    if (this.chd == 0)
    {
      if (this.cgS > this.mWidth / 2.0D)
      {
        this.bvM = false;
        cux();
        return;
      }
      this.bvM = true;
      cuA();
      return;
    }
    if (this.cgS < -(this.cgU / 3.0D * 2.0D))
    {
      this.bvM = false;
      cuy();
      return;
    }
    this.bvM = true;
    cuA();
  }
  
  public void cuw()
  {
    ba(1, true);
  }
  
  public void cux()
  {
    openDrawer(0, true);
  }
  
  public void cuy()
  {
    openDrawer(1, true);
  }
  
  public void cuz()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DrawerFrame", 4, "resetDrawer()");
    }
    this.j.removeMessages(1);
    this.j.removeMessages(2);
    this.j.removeMessages(4);
    this.j.removeMessages(3);
    this.bvN = false;
    this.chd = 0;
    this.cgS = 0;
    if (this.mContentView != null) {
      this.mContentView.offsetLeftAndRight(0 - this.mContentView.getLeft());
    }
    go(this.chd, this.cgS);
    postInvalidate();
    if (this.bvM)
    {
      this.bvM = false;
      this.j.sendEmptyMessage(4);
    }
    gp(this.chd, 1);
    cgR = 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1 = this.b.getActivity().app;
    Object localObject2;
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localObject2 = ((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject2 == null) {}
    }
    for (int i = ((MainFragment)localObject2).getCurrentTab();; i = -1)
    {
      boolean bool1;
      if ((!((QQAppInterface)localObject1).bJd) && (this.bvR))
      {
        localObject1 = MotionEvent.obtain(paramMotionEvent);
        if ((localObject1 != null) && (i != -1))
        {
          localObject2 = (c)this.iC.get(Integer.valueOf(i));
          if (localObject2 != null)
          {
            bool1 = ((c)localObject2).interceptDrawer(this, (MotionEvent)localObject1);
            bool2 = bool1;
            if (localObject1 != null) {
              ((MotionEvent)localObject1).recycle();
            }
          }
        }
      }
      for (boolean bool2 = bool1;; bool2 = false)
      {
        if (paramMotionEvent.getAction() == 0) {
          this.brq = false;
        }
        if ((this.brq) && (!bool2)) {
          paramMotionEvent.setAction(0);
        }
        this.brq = bool2;
        if (bool2) {
          return true;
        }
        return super.dispatchTouchEvent(paramMotionEvent);
        bool1 = false;
        break;
      }
    }
  }
  
  @TargetApi(11)
  protected void go(int paramInt1, int paramInt2)
  {
    gp(paramInt1, 2);
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt1 != 0) {
        break label102;
      }
      f1 = paramInt2 / this.cgT;
      if (paramInt1 != 0) {
        break label115;
      }
      f2 = this.mWidth * (f1 - 1.0F);
      label42:
      if (paramInt1 != 0) {
        break label130;
      }
    }
    label130:
    for (Object localObject = this.dK;; localObject = this.zv)
    {
      if (localObject != null) {
        ((View)localObject).setTranslationX(f2);
      }
      if (this.dL != null) {
        this.dL.setTranslationX(f2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a.m(this.chd, f1);
      }
      return;
      label102:
      f1 = -paramInt2 / this.cgU;
      break;
      label115:
      f2 = -this.mWidth * (f1 - 1.0F);
      break label42;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                boolean bool = this.mScroller.computeScrollOffset();
                i = this.mScroller.getCurrX();
                int k = this.cgS;
                this.cgS = this.mScroller.getCurrX();
                if (this.mContentView != null)
                {
                  this.mContentView.offsetLeftAndRight(i - k);
                  go(this.chd, this.cgS);
                }
                postInvalidate();
                if (!bool)
                {
                  this.bvN = false;
                  this.bvM = true;
                  this.j.sendEmptyMessage(3);
                  return true;
                }
                this.j.sendEmptyMessage(1);
                return true;
                bool = this.mScroller.computeScrollOffset();
                i = this.mScroller.getCurrX();
                k = this.cgS;
                this.cgS = this.mScroller.getCurrX();
                if (this.mContentView != null)
                {
                  this.mContentView.offsetLeftAndRight(i - k);
                  go(this.chd, this.cgS);
                }
                postInvalidate();
                if (!bool)
                {
                  this.bvN = false;
                  this.bvM = false;
                  if (this.dK != null) {
                    this.dK.setVisibility(8);
                  }
                  if (this.zv != null) {
                    this.zv.setVisibility(8);
                  }
                  this.j.sendEmptyMessage(4);
                  return true;
                }
                this.j.sendEmptyMessage(2);
                return true;
              } while (this.bvN);
              aqcl.R(this.mContentView, true);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a.fa(this.chd, this.actionFlag);
              }
              this.actionFlag = 0;
              this.chd = 0;
              this.bvR = true;
              gp(this.chd, 1);
            } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
            paramMessage = ((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
          } while (paramMessage == null);
          i = ((MainFragment)paramMessage).getCurrentTab();
          if (i == MainFragment.bIk)
          {
            ApngImage.playByTag(2);
            return true;
          }
          if (i == MainFragment.bIm)
          {
            ApngImage.playByTag(3);
            return true;
          }
          if (i == MainFragment.bIn)
          {
            ApngImage.playByTag(4);
            return true;
          }
          if (i == MainFragment.bIp)
          {
            ApngImage.playByTag(5);
            return true;
          }
        } while (i != MainFragment.bIq);
        ApngImage.playByTag(8);
        return true;
      } while (this.bvN);
      aqcl.R(this.mContentView, false);
      gp(this.chd, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a.eZ(this.chd, this.actionFlag);
      }
      this.actionFlag = 0;
      this.bvR = false;
      ApngImage.playByTag(1);
      return true;
    } while (!Wt());
    if (this.chd == 0)
    {
      i = this.cgT - this.cgS;
      this.cgS = this.cgT;
    }
    for (;;)
    {
      if ((this.mContentView != null) && (i != 0))
      {
        this.mContentView.offsetLeftAndRight(i);
        go(this.chd, this.cgS);
        postInvalidate();
      }
      if (!DEBUG) {
        break;
      }
      u("MSG_CONFIGURATION_CHANGED", Integer.valueOf(i));
      return true;
      if (this.chd == 1)
      {
        i = -this.cgU - this.cgS;
        this.cgS = (-this.cgU);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.che)
    {
      this.che = paramConfiguration.orientation;
      if ((Wt()) && (this.chf == 0)) {
        this.chf = 1;
      }
      if (DEBUG) {
        u("onConfigurationChanged", Boolean.valueOf(Wt()));
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (!isDraggable()) {
      bool2 = bool1;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool2;
              bool2 = bool1;
            } while (!this.isTouchable);
            i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            k = (int)(paramMotionEvent.getX() + 0.5F);
            m = (int)(paramMotionEvent.getY() + 0.5F);
            switch (paramMotionEvent.getAction() & 0xFF)
            {
            default: 
              return false;
            case 0: 
              this.cgW = k;
              this.cgV = k;
              this.cgY = m;
              this.cgX = m;
              if ((!this.bvM) || (this.cgV > this.cha)) {
                this.bvO = true;
              }
              bool2 = bool1;
            }
          } while (!this.bvN);
          if ((this.chd == 0) && (this.cgV > this.cgS)) {
            break;
          }
          bool2 = bool1;
        } while (this.chd != 1);
        bool2 = bool1;
      } while (this.cgV >= this.mWidth + this.cgS);
      this.bvO = true;
      return true;
      bool2 = bool1;
    } while (!this.bvO);
    if ((!this.bvM) && ((k < this.cgW) || (k < this.cgV)))
    {
      this.bvO = false;
      return false;
    }
    this.cgW = k;
    this.cgY = m;
    int k = Math.abs(this.cgW - this.cgV);
    int m = Math.abs(this.cgY - this.cgX);
    if (this.bvM)
    {
      bool1 = bool3;
      if (k > i) {
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!this.bvN) {
        break;
      }
      this.j.removeMessages(1);
      this.j.removeMessages(2);
      this.j.removeMessages(4);
      this.j.removeMessages(3);
      return bool1;
      bool1 = bool3;
      if (k > i)
      {
        bool1 = bool3;
        if ((m + 0.0F) / k < 0.6F) {
          bool1 = true;
        }
      }
    }
    this.bvO = false;
    if (((this.bvM) && (this.chd == 0) && (this.cgV > this.cgT)) || ((this.chd == 1) && (this.cgV < this.mWidth - this.cgU)))
    {
      this.actionFlag = 3;
      if ((this.cgX >= this.MIN_Y) && (this.cgX <= this.MAX_Y)) {
        this.actionFlag = 4;
      }
      cuA();
      this.cgW = -1;
      this.cgV = -1;
      this.cgY = -1;
      this.cgX = -1;
      return true;
    }
    this.cgW = -1;
    this.cgV = -1;
    this.cgY = -1;
    this.cgX = -1;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.dL != null) && (this.dL.getVisibility() != 8)) {
      this.dL.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.dK != null) && (this.dK.getVisibility() != 8)) {
      this.dK.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.zv != null) && (this.zv.getVisibility() != 8)) {
      this.zv.layout(paramInt3 - this.cgU, this.MIN_Y, paramInt3, this.MAX_Y);
    }
    if ((this.mContentView != null) && (this.mContentView.getVisibility() != 8)) {
      this.mContentView.layout(this.mContentView.getLeft(), this.mContentView.getTop(), this.mContentView.getLeft() + paramInt3, paramInt4);
    }
    if ((this.zx != null) && (this.zx.getVisibility() != 8))
    {
      if (this.chd != 0) {
        break label270;
      }
      this.zx.layout(this.cgT, this.MIN_Y, this.cgT + this.chb, this.MAX_Y);
    }
    label270:
    do
    {
      while (Wv())
      {
        if (this.chf == 2)
        {
          this.chf = 0;
          if (!this.j.hasMessages(5)) {
            this.j.sendEmptyMessage(5);
          }
          if (DEBUG) {
            u("onLayout", "valid orientation");
          }
        }
        return;
        if (this.chd == 1) {
          this.zx.layout(0, this.MIN_Y, paramInt3 - this.cgU, this.MAX_Y);
        }
      }
    } while (!DEBUG);
    u("onLayout", "not valid orientation");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = getMeasuredWidth();
    this.mHeight = getMeasuredHeight();
    this.cgT = (this.mWidth - this.chb);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.chc = ((int)(this.mHeight * 0.8F + 0.5D));
      this.MIN_Y = ((int)(this.mHeight * 0.2F / 2.0F));
      this.MAX_Y = (this.MIN_Y + this.chc);
      if (this.zv != null) {
        this.zv.getLayoutParams().height = this.chc;
      }
      if (!Wv()) {
        break label177;
      }
      if (this.chf == 1)
      {
        this.chf = 2;
        if (DEBUG) {
          u("onMeasure", "valid orientation");
        }
      }
    }
    label177:
    while (!DEBUG)
    {
      return;
      this.chc = this.mHeight;
      this.MIN_Y = 0;
      this.MAX_Y = (this.MIN_Y + this.chc);
      break;
    }
    u("onMeasure", "not valid orientation");
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawerFrame", 2, "onMultiWindowModeChanged, isInMultiWindowMode:" + paramBoolean);
    }
    RandomCoverView localRandomCoverView = (RandomCoverView)this.dL.findViewById(2131380003);
    if (localRandomCoverView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRandomCoverView.getLayoutParams();
      localLayoutParams.width = (ankt.SCREEN_WIDTH - yD());
      localLayoutParams.height = ankt.dip2px(170.0F);
      localRandomCoverView.setLayoutParams(localLayoutParams);
      localRandomCoverView.setDefaultCoverBg();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isDraggable()) {}
    while (!this.isTouchable) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int i = (int)(paramMotionEvent.getX() + 0.5F);
    int k = (int)(paramMotionEvent.getY() + 0.5F);
    int m = i - this.cgW;
    int n = this.cgY;
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.cgW = i;
    this.cgY = k;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      if (this.bvN)
      {
        this.j.removeMessages(1);
        this.j.removeMessages(2);
        this.j.removeMessages(4);
        this.j.removeMessages(3);
      }
    case 2: 
      ApngImage.pauseAll();
      boolean bool = this.bvN;
      this.bvN = true;
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a.AD(this.chd);
      }
      this.actionFlag = 1;
      if ((this.chd == 0) && (this.cgS + m > this.cgT)) {
        if (this.cgS != this.cgT)
        {
          this.bvM = true;
          this.mContentView.offsetLeftAndRight(this.cgT - this.cgS);
          this.cgS = this.cgT;
          go(this.chd, this.cgS);
          invalidate();
        }
      }
      for (;;)
      {
        return true;
        if ((this.chd == 0) && (this.cgS + m < 0))
        {
          if (this.cgS != 0)
          {
            this.bvM = false;
            this.mContentView.offsetLeftAndRight(0 - this.mContentView.getLeft());
            this.cgS = 0;
            go(this.chd, this.cgS);
            invalidate();
          }
        }
        else if ((this.chd == 1) && (this.cgS + m < -this.cgU))
        {
          if (this.cgS != -this.cgU)
          {
            this.bvM = true;
            this.mContentView.offsetLeftAndRight(-this.cgU - this.cgS);
            this.cgS = (-this.cgU);
            go(this.chd, this.cgS);
            invalidate();
          }
        }
        else if ((this.chd == 1) && (this.cgS + m > 0))
        {
          if (this.cgS != 0)
          {
            this.bvM = false;
            this.mContentView.offsetLeftAndRight(0 - this.mContentView.getLeft());
            this.cgS = 0;
            go(this.chd, this.cgS);
            invalidate();
          }
        }
        else
        {
          this.mContentView.offsetLeftAndRight(m);
          this.cgS += m;
          go(this.chd, this.cgS);
          invalidate();
        }
      }
    }
    this.bvO = false;
    this.bvN = false;
    this.mVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.mVelocityTracker.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity()) {
      if (this.chd == 0) {
        if (this.mVelocityTracker.getXVelocity() > 0.0F)
        {
          this.bvM = false;
          cux();
        }
      }
    }
    for (;;)
    {
      return true;
      this.bvM = true;
      cuA();
      continue;
      if (this.mVelocityTracker.getXVelocity() < 0.0F)
      {
        this.bvM = false;
        cuy();
      }
      else
      {
        this.bvM = true;
        cuA();
        continue;
        if (this.chd == 0)
        {
          if (this.cgS > this.mWidth / 2.0D)
          {
            this.bvM = false;
            cux();
          }
          else
          {
            this.bvM = true;
            cuA();
          }
        }
        else if (this.cgS < -(this.cgU / 3.0D * 2.0D))
        {
          this.bvM = false;
          cuy();
        }
        else
        {
          this.bvM = true;
          cuA();
        }
      }
    }
  }
  
  public void setDrawerCallbacks(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$a = parama;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.bvL = paramBoolean;
  }
  
  public void setDrawerShadowFlag(boolean paramBoolean)
  {
    this.bvQ = paramBoolean;
  }
  
  public void setMiniAppTouchEventInterceptor(int paramInt, c paramc)
  {
    this.iC.put(Integer.valueOf(paramInt), paramc);
  }
  
  public void setStoryTouchEventInterceptor(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$c = paramc;
  }
  
  public int yC()
  {
    return this.cgZ;
  }
  
  public int yD()
  {
    this.chb = getContext().getResources().getDimensionPixelSize(2131298881);
    return this.chb;
  }
  
  public static abstract interface a
  {
    public abstract void AD(int paramInt);
    
    public abstract void aC(int paramInt, boolean paramBoolean);
    
    public abstract void eZ(int paramInt1, int paramInt2);
    
    public abstract void fa(int paramInt1, int paramInt2);
    
    public abstract void m(int paramInt, float paramFloat);
  }
  
  public static class b
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return (float)(Math.pow(paramFloat - 1.0D, 3.0D) + 1.0D);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */