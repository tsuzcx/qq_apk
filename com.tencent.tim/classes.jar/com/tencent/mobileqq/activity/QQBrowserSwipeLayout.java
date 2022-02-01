package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import odu;

public class QQBrowserSwipeLayout
  extends SwipeBackLayout
{
  private GestureDetector e;
  
  public QQBrowserSwipeLayout(Context paramContext)
  {
    this(paramContext, true);
    setBackgroundColor(0);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    this.e = new GestureDetector(paramContext, new a(paramContext));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewPager localViewPager = a(this.kX, paramMotionEvent);
    if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return this.e.onTouchEvent(paramMotionEvent);
        this.awF = false;
        int i = (int)paramMotionEvent.getRawX();
        this.beC = i;
        this.downX = i;
        this.downY = ((int)paramMotionEvent.getRawY());
        if ((this.downX < this.viewWidth / 3) && ((this.jdField_a_of_type_Odu.GE()) || (!A(paramMotionEvent))) && (this.awG)) {
          this.awF = true;
        }
      }
    } while ((!this.awF) || ((int)paramMotionEvent.getRawX() - this.downX <= this.mTouchSlop) || (Math.abs((int)paramMotionEvent.getRawY() - this.downY) >= this.mTouchSlop));
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.e.onTouchEvent(paramMotionEvent);
      if (this.awF)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = this.beC - i;
        this.beC = i;
        if ((i - this.downX > this.mTouchSlop) && (Math.abs((int)paramMotionEvent.getRawY() - this.downY) < this.mTouchSlop)) {
          this.awE = true;
        }
        if ((i - this.downX > 0) && (this.awE))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQBrowserSwipeLayout", 2, "moveX:" + i + "downX:" + this.downX + "deltaX:" + j);
          }
          this.mContentView.scrollBy(j, 0);
          continue;
          if (this.awF)
          {
            this.awE = false;
            if (QLog.isColorLevel()) {
              QLog.i("QQBrowserSwipeLayout", 2, "event.getRawX():" + paramMotionEvent.getRawX() + "screenWidth:" + this.screenWidth + "viewWidth:" + this.viewWidth);
            }
            if (paramMotionEvent.getRawX() - this.downX >= this.screenWidth / 2)
            {
              this.isFinish = true;
              bdP();
            }
            else
            {
              postDelayed(new QQBrowserSwipeLayout.1(this), 100L);
              this.isFinish = false;
            }
          }
        }
      }
    }
  }
  
  public class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private float lB;
    
    public a(Context paramContext)
    {
      this.lB = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      boolean bool = false;
      if (QQBrowserSwipeLayout.a(QQBrowserSwipeLayout.this) != null) {
        bool = QQBrowserSwipeLayout.a(QQBrowserSwipeLayout.this, paramMotionEvent1);
      }
      if ((!QQBrowserSwipeLayout.c(QQBrowserSwipeLayout.this)) || (paramFloat1 < 200.0F)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      if ((f1 < 0.0F) && (f2 < 0.5F) && (!bool))
      {
        if (!(QQBrowserSwipeLayout.a(QQBrowserSwipeLayout.this) instanceof Activity)) {
          break label175;
        }
        QQBrowserSwipeLayout.a(QQBrowserSwipeLayout.this, true);
        if (QQBrowserSwipeLayout.b(QQBrowserSwipeLayout.this) != null)
        {
          QQBrowserSwipeLayout.c(QQBrowserSwipeLayout.this).flingLToR();
          QQBrowserSwipeLayout.b(QQBrowserSwipeLayout.this);
        }
      }
      for (;;)
      {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label175:
        if (QQBrowserSwipeLayout.d(QQBrowserSwipeLayout.this) != null)
        {
          QQBrowserSwipeLayout.e(QQBrowserSwipeLayout.this).flingLToR();
          QQBrowserSwipeLayout.c(QQBrowserSwipeLayout.this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserSwipeLayout
 * JD-Core Version:    0.7.0.1
 */