package com.tencent.mobileqq.nearby.widget;

import akkg;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import apuh;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import rpq;

public class AvatarWallViewPager
  extends RelativeLayout
{
  public RollViewPager a;
  protected RollerChangeListener a;
  protected boolean auq = true;
  public AvatarWallPagerAdapter b;
  public int baC;
  protected boolean csA;
  protected boolean csB;
  protected boolean csC;
  protected LinearLayout.LayoutParams d;
  protected int dnk = 500;
  protected int dnl = 4000;
  protected int dnm = this.dnk;
  public int dnn = this.dnl;
  protected LinearLayout eq;
  protected Drawable fb;
  protected Drawable fc;
  protected float lg;
  protected float lh;
  protected Context mContext;
  public Handler mHandler = new akkg(this, Looper.getMainLooper());
  protected float mLastX;
  protected float mLastY;
  protected int mTouchSlop;
  protected View[] n;
  
  public AvatarWallViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarWallViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  protected View a(boolean paramBoolean, int paramInt)
  {
    View localView2 = this.b.a(paramBoolean, paramInt);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = d(paramBoolean);
    }
    return localView1;
  }
  
  protected RollViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager;
  }
  
  protected View d(boolean paramBoolean)
  {
    View localView = new View(this.mContext);
    if (this.d == null)
    {
      int i = rpq.dip2px(this.mContext, 7.0F);
      this.d = new LinearLayout.LayoutParams(i, i);
      this.d.leftMargin = i;
      this.d.rightMargin = i;
    }
    if (paramBoolean)
    {
      if (this.fc == null) {
        this.fc = apuh.a(getResources(), Color.parseColor("#CC12B7F5"), getResources().getDrawable(2130844522));
      }
      localView.setLayoutParams(this.d);
      if (!paramBoolean) {
        break label157;
      }
    }
    label157:
    for (Drawable localDrawable = this.fc;; localDrawable = this.fb)
    {
      localView.setBackgroundDrawable(localDrawable);
      return localView;
      if (this.fb != null) {
        break;
      }
      this.fb = apuh.a(getResources(), Color.parseColor("#66FFFFFF"), getResources().getDrawable(2130844522));
      break;
    }
  }
  
  protected void dBD()
  {
    int j = this.b.GS();
    this.eq.removeAllViews();
    if (j > 1)
    {
      this.n = new View[j - 2];
      int i = 0;
      if (i < j - 2)
      {
        Object localObject = this.n;
        if (i == 0)
        {
          bool = true;
          label51:
          localObject[i] = a(bool, i);
          localObject = this.eq;
          if (i != 0) {
            break label96;
          }
        }
        label96:
        for (boolean bool = true;; bool = false)
        {
          ((LinearLayout)localObject).addView(a(bool, i));
          i += 1;
          break;
          bool = false;
          break label51;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollerChangeListener.baD = 0;
  }
  
  protected RelativeLayout.LayoutParams f()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = rpq.dip2px(this.mContext, 50.0F);
    return localLayoutParams;
  }
  
  protected void init()
  {
    this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager = new RollViewPager(this.mContext);
    addView(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager, new RelativeLayout.LayoutParams(-1, -1));
    this.eq = m();
    this.eq.setBackgroundColor(getResources().getColor(17170445));
    this.eq.setGravity(17);
    addView(this.eq, f());
    RollViewPager localRollViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager;
    RollerChangeListener localRollerChangeListener = new RollerChangeListener();
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollerChangeListener = localRollerChangeListener;
    localRollViewPager.setOnPageChangeListener(localRollerChangeListener);
    new a(this.mContext, new LinearInterpolator()).dnl();
  }
  
  protected LinearLayout m()
  {
    return new LinearLayout(this.mContext);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.csA = true;
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    if (this.b != null)
    {
      this.b.onDetached();
      this.b = null;
    }
  }
  
  public void onStart()
  {
    if ((this.csA) || (this.b.GS() <= 1)) {}
    while (!this.csB) {
      return;
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), this.dnn);
  }
  
  public void onStop()
  {
    if (this.csA) {
      return;
    }
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void setAdapter(AvatarWallPagerAdapter paramAvatarWallPagerAdapter)
  {
    if (paramAvatarWallPagerAdapter != null)
    {
      this.b = paramAvatarWallPagerAdapter;
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager.setAdapter(paramAvatarWallPagerAdapter.a());
      dBD();
    }
  }
  
  public void setDotLayoutParams(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null) {
      this.eq.setLayoutParams(paramLayoutParams);
    }
  }
  
  public void setScrollInterpolator(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      new a(this.mContext, paramInterpolator).dnl();
    }
  }
  
  public class RollViewPager
    extends ViewPager
  {
    int count;
    
    public RollViewPager(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public RollViewPager(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      boolean bool1 = false;
      if (AvatarWallViewPager.this.b == null) {
        return false;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = Math.abs(f1 - AvatarWallViewPager.this.mLastX);
      float f4 = Math.abs(f2 - AvatarWallViewPager.this.mLastY);
      boolean bool2;
      switch (paramMotionEvent.getAction())
      {
      case 4: 
      default: 
        return false;
      case 0: 
      case 5: 
        this.count = AvatarWallViewPager.this.b.GS();
        requestDisallowInterceptTouchEvent(true);
        AvatarWallViewPager localAvatarWallViewPager = AvatarWallViewPager.this;
        AvatarWallViewPager.this.mLastX = f1;
        localAvatarWallViewPager.lg = f1;
        localAvatarWallViewPager = AvatarWallViewPager.this;
        AvatarWallViewPager.this.mLastY = f2;
        localAvatarWallViewPager.lh = f2;
        AvatarWallViewPager.this.onStop();
        try
        {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
          return bool1;
        }
        catch (Exception paramMotionEvent)
        {
          QLog.i("AvatarWallViewPager", 1, "MotionEvent.ACTION_DOWN|MotionEvent.ACTION_POINTER_DOWN,e=" + paramMotionEvent.toString());
          return false;
        }
      case 2: 
        if (this.count <= 1) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        for (;;)
        {
          AvatarWallViewPager.this.mLastX = f1;
          AvatarWallViewPager.this.mLastY = f2;
          return bool1;
          if ((f3 < f4) && (Math.abs(f2 - AvatarWallViewPager.this.lh) > AvatarWallViewPager.this.mTouchSlop)) {
            getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            for (;;)
            {
              if ((f3 <= f4) || (Math.abs(f1 - AvatarWallViewPager.this.lg) <= AvatarWallViewPager.this.mTouchSlop)) {
                break label379;
              }
              try
              {
                bool2 = super.dispatchTouchEvent(paramMotionEvent);
                bool1 = bool2;
              }
              catch (Exception paramMotionEvent)
              {
                QLog.i("AvatarWallViewPager", 1, "MotionEvent.ACTION_MOVE,e=" + paramMotionEvent.toString());
              }
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            break;
          }
          label379:
          requestDisallowInterceptTouchEvent(false);
        }
      }
      requestDisallowInterceptTouchEvent(false);
      try
      {
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
        bool2 = bool1;
        if (Math.abs(f1 - AvatarWallViewPager.this.lg) < AvatarWallViewPager.this.mTouchSlop)
        {
          bool2 = bool1;
          if (Math.abs(f2 - AvatarWallViewPager.this.lh) < AvatarWallViewPager.this.mTouchSlop)
          {
            bool2 = bool1;
            if (AvatarWallViewPager.this.auq)
            {
              requestDisallowInterceptTouchEvent(false);
              AvatarWallViewPager.this.performClick();
              bool2 = false;
            }
          }
        }
        AvatarWallViewPager.this.onStart();
        return bool2;
      }
      catch (Exception paramMotionEvent)
      {
        for (;;)
        {
          QLog.i("AvatarWallViewPager", 1, "MotionEvent.ACTION_UP|MotionEvent.ACTION_POINTER_UP|MotionEvent.ACTION_CANCEL,e=" + paramMotionEvent.toString());
          bool1 = false;
        }
      }
    }
  }
  
  public class RollerChangeListener
    extends ViewPager.SimpleOnPageChangeListener
  {
    public int baD;
    
    protected RollerChangeListener() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      int j = 1;
      AvatarWallViewPager localAvatarWallViewPager = AvatarWallViewPager.this;
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        localAvatarWallViewPager.auq = bool;
        if (AvatarWallViewPager.this.auq) {
          break label39;
        }
      }
      label39:
      label175:
      for (;;)
      {
        return;
        bool = false;
        break;
        int i = AvatarWallViewPager.this.a.getCurrentItem();
        AvatarWallViewPager.this.baC = i;
        int k = AvatarWallViewPager.this.b.GS();
        if (k > 1)
        {
          if (i == 1)
          {
            AvatarWallViewPager.this.b.a().instantiateItem(null, k - 2);
            if (i != 0) {
              break label162;
            }
            paramInt = k - 2;
          }
          for (;;)
          {
            if (i == paramInt) {
              break label175;
            }
            AvatarWallViewPager.this.baC = paramInt;
            AvatarWallViewPager.this.a.setCurrentItem(paramInt, false);
            return;
            if (i != k - 2) {
              break;
            }
            AvatarWallViewPager.this.b.a().instantiateItem(null, 1);
            break;
            paramInt = j;
            if (i != k - 1) {
              paramInt = i;
            }
          }
        }
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      if (AvatarWallViewPager.this.b.GS() <= 1) {
        this.baD = 0;
      }
      do
      {
        return;
        paramInt = AvatarWallViewPager.this.b.it(paramInt);
        if ((this.baD < AvatarWallViewPager.this.eq.getChildCount()) && (paramInt < AvatarWallViewPager.this.eq.getChildCount()))
        {
          AvatarWallViewPager.this.eq.removeViewAt(this.baD);
          AvatarWallViewPager.this.eq.addView(AvatarWallViewPager.this.a(false, this.baD), this.baD);
          AvatarWallViewPager.this.eq.removeViewAt(paramInt);
          AvatarWallViewPager.this.eq.addView(AvatarWallViewPager.this.a(true, paramInt), paramInt);
          this.baD = paramInt;
          return;
        }
        this.baD = 0;
      } while (!QLog.isColorLevel());
      QLog.e("AvatarWallViewPager", 2, "onPageSelected error, lastPos = " + this.baD + ", pos = " + paramInt + ", childCount = " + AvatarWallViewPager.this.eq.getChildCount());
    }
  }
  
  class a
    extends Scroller
  {
    public a(Context paramContext, Interpolator paramInterpolator)
    {
      super(paramInterpolator);
    }
    
    public void dnl()
    {
      try
      {
        Field localField = AvatarWallViewPager.RollViewPager.class.getDeclaredField("mScroller");
        localField.setAccessible(true);
        localField.set(AvatarWallViewPager.this.a, this);
        localField.setAccessible(false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, AvatarWallViewPager.this.dnm);
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, AvatarWallViewPager.this.dnm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager
 * JD-Core Version:    0.7.0.1
 */