package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
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
import apue;
import apuh;
import apuu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import rpq;

public class AvatarWallViewPager
  extends RelativeLayout
{
  protected ViewPager.SimpleOnPageChangeListener a;
  public RollViewPager a;
  protected boolean auq = true;
  public AvatarWallViewPagerAdapter b;
  public int baC;
  protected Drawable cP;
  protected Drawable cQ;
  protected LinearLayout.LayoutParams d;
  protected LinearLayout eq;
  protected float lg;
  protected float lh;
  private boolean mAttached;
  protected Context mContext;
  public Handler mHandler = new apuu(this, Looper.getMainLooper());
  private boolean mIsStop = true;
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
  
  protected View aq()
  {
    View localView = new View(this.mContext);
    if (this.d == null)
    {
      int i = rpq.dip2px(this.mContext, 6.0F);
      this.d = new LinearLayout.LayoutParams(i, i);
      this.d.leftMargin = rpq.dip2px(this.mContext, 7.0F);
      this.cP = apuh.a(getResources(), Color.parseColor("#80ffffff"), getResources().getDrawable(2130844522));
      this.cQ = apuh.a(getResources(), Color.parseColor("#ffffffff"), getResources().getDrawable(2130844522));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        this.cP.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        this.cQ.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
    }
    localView.setLayoutParams(this.d);
    localView.setBackgroundDrawable(this.cP);
    return localView;
  }
  
  public void baF()
  {
    int j = this.b.ju();
    if (j == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPager", 2, "startRoll error, the count of avatars is 0...");
      }
    }
    for (;;)
    {
      return;
      this.eq.removeAllViews();
      if (j > 1)
      {
        this.n = new View[j];
        int i = 0;
        while (i < j)
        {
          this.n[i] = aq();
          this.eq.addView(this.n[i]);
          i += 1;
        }
        this.n[0].setBackgroundDrawable(this.cQ);
        this.baC = 1;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(this.baC, false);
        start();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AvatarWallViewPager", 2, "startRoll is called successfully");
        return;
        stop();
      }
    }
  }
  
  protected void init()
  {
    this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager = new RollViewPager(this.mContext);
    addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager, new RelativeLayout.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = rpq.dip2px(this.mContext, 13.0F);
    localLayoutParams.bottomMargin = rpq.dip2px(this.mContext, 10.0F);
    this.eq = m();
    this.eq.setBackgroundColor(getResources().getColor(17170445));
    this.eq.setGravity(5);
    addView(this.eq, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setOnPageChangeListener(new RollerChangeListener());
    new a(this.mContext, new LinearInterpolator()).dnl();
  }
  
  protected LinearLayout m()
  {
    return new LinearLayout(this.mContext);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mAttached = true;
    if (!this.mIsStop)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mAttached = false;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void setAdapter(AvatarWallViewPagerAdapter paramAvatarWallViewPagerAdapter)
  {
    if (paramAvatarWallViewPagerAdapter != null)
    {
      this.b = paramAvatarWallViewPagerAdapter;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setAdapter(paramAvatarWallViewPagerAdapter);
    }
  }
  
  public void setOnPageChangeListener(ViewPager.SimpleOnPageChangeListener paramSimpleOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener = paramSimpleOnPageChangeListener;
  }
  
  protected void start()
  {
    this.mIsStop = false;
    if (this.mAttached)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void stop()
  {
    this.mIsStop = true;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void stopRoll()
  {
    stop();
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
      boolean bool2 = false;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = Math.abs(f1 - AvatarWallViewPager.this.mLastX);
      float f4 = Math.abs(f2 - AvatarWallViewPager.this.mLastY);
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      case 0: 
      case 261: 
        this.count = AvatarWallViewPager.this.b.ju();
        requestDisallowInterceptTouchEvent(true);
        AvatarWallViewPager localAvatarWallViewPager = AvatarWallViewPager.this;
        AvatarWallViewPager.this.mLastX = f1;
        localAvatarWallViewPager.lg = f1;
        localAvatarWallViewPager = AvatarWallViewPager.this;
        AvatarWallViewPager.this.mLastY = f2;
        localAvatarWallViewPager.lh = f2;
        AvatarWallViewPager.this.stop();
        return super.dispatchTouchEvent(paramMotionEvent);
      case 2: 
        if (this.count <= 1)
        {
          getParent().requestDisallowInterceptTouchEvent(false);
          bool1 = bool2;
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
            if ((f3 <= f4) || (Math.abs(f1 - AvatarWallViewPager.this.lg) <= AvatarWallViewPager.this.mTouchSlop)) {
              break label312;
            }
            bool1 = super.dispatchTouchEvent(paramMotionEvent);
            break;
            getParent().requestDisallowInterceptTouchEvent(true);
          }
          label312:
          requestDisallowInterceptTouchEvent(false);
          bool1 = bool2;
        }
      }
      requestDisallowInterceptTouchEvent(false);
      bool2 = super.dispatchTouchEvent(paramMotionEvent);
      if ((Math.abs(f1 - AvatarWallViewPager.this.lg) < AvatarWallViewPager.this.mTouchSlop) && (Math.abs(f2 - AvatarWallViewPager.this.lh) < AvatarWallViewPager.this.mTouchSlop) && (AvatarWallViewPager.this.auq))
      {
        requestDisallowInterceptTouchEvent(false);
        AvatarWallViewPager.this.performClick();
      }
      for (;;)
      {
        AvatarWallViewPager.this.start();
        return bool1;
        bool1 = bool2;
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        apue.m("avatarWallViewPager", "ote_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        apue.m("avatarWallViewPager", "te_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
  }
  
  public class RollerChangeListener
    extends ViewPager.SimpleOnPageChangeListener
  {
    int baD = 0;
    
    protected RollerChangeListener() {}
    
    public void onPageScrollStateChanged(int paramInt)
    {
      int j = 1;
      if (AvatarWallViewPager.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
        AvatarWallViewPager.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageScrollStateChanged(paramInt);
      }
      AvatarWallViewPager localAvatarWallViewPager = AvatarWallViewPager.this;
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        localAvatarWallViewPager.auq = bool;
        if (AvatarWallViewPager.this.auq) {
          break label60;
        }
      }
      label60:
      label190:
      for (;;)
      {
        return;
        bool = false;
        break;
        int i = AvatarWallViewPager.this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.getCurrentItem();
        AvatarWallViewPager.this.baC = i;
        int k = AvatarWallViewPager.this.b.getCount();
        if (k > 1)
        {
          if (i == 1)
          {
            AvatarWallViewPager.this.b.instantiateItem(null, k - 2);
            if (i != 0) {
              break label177;
            }
            paramInt = k - 2;
          }
          for (;;)
          {
            if (i == paramInt) {
              break label190;
            }
            AvatarWallViewPager.this.baC = paramInt;
            AvatarWallViewPager.this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(paramInt, false);
            return;
            if (i != k - 2) {
              break;
            }
            AvatarWallViewPager.this.b.instantiateItem(null, 1);
            break;
            paramInt = j;
            if (i != k - 1) {
              paramInt = i;
            }
          }
        }
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      super.onPageScrolled(paramInt1, paramFloat, paramInt2);
      if (AvatarWallViewPager.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
        AvatarWallViewPager.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      int i = AvatarWallViewPager.this.b.getCount();
      if (paramInt == 0) {
        i -= 2;
      }
      for (;;)
      {
        i -= 1;
        if ((i >= 0) && (this.baD >= 0) && (AvatarWallViewPager.this.n.length > i) && (AvatarWallViewPager.this.n.length > this.baD))
        {
          AvatarWallViewPager.this.n[this.baD].setBackgroundDrawable(AvatarWallViewPager.this.cP);
          AvatarWallViewPager.this.n[i].setBackgroundDrawable(AvatarWallViewPager.this.cQ);
          this.baD = i;
        }
        if (AvatarWallViewPager.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener != null) {
          AvatarWallViewPager.this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener.onPageSelected(paramInt);
        }
        return;
        if (paramInt == i - 1) {
          i = 1;
        } else {
          i = paramInt;
        }
      }
    }
  }
  
  public class a
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
        Field localField = ViewPager.class.getDeclaredField("mScroller");
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
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, 500);
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, 500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager
 * JD-Core Version:    0.7.0.1
 */