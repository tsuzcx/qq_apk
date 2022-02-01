package com.tencent.mobileqq.widget.qus;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import arly;
import com.tencent.qphone.base.util.QLog;

public class QUSDragFloatingScreenView
  extends FrameLayout
{
  private int FA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private ImageView Ga;
  private arly a;
  private byte aY = 0;
  private FrameLayout cp;
  private boolean dcf;
  private LinearLayout dl = new LinearLayout(getContext());
  private int ekr = kH(60);
  private int eks;
  private int mCurState;
  private float mDensity = getContext().getResources().getDisplayMetrics().density;
  private float mLastY;
  private int mMinimumHeight = kH(36);
  private int mMode = 0;
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QUSDragFloatingScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.topMargin = kH(60);
    this.dl.setLayoutParams(paramContext);
    this.dl.setBackgroundResource(2130839677);
    this.dl.setOrientation(1);
    addView(this.dl);
    paramInt = kH(36);
    this.cp = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, paramInt);
    this.cp.setLayoutParams(paramContext);
    this.dl.addView(this.cp);
    this.Ga = new ImageView(getContext());
    paramContext = new FrameLayout.LayoutParams(paramInt, paramInt);
    paramContext.gravity = 17;
    this.Ga.setImageResource(2130850666);
    this.Ga.setLayoutParams(paramContext);
    this.cp.addView(this.Ga);
  }
  
  private void TO(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void Zi(int paramInt)
  {
    ObjectAnimator.ofFloat(this.dl, "y", new float[] { this.dl.getY(), paramInt }).setDuration(250L).start();
    this.dcf = false;
    TO(false);
  }
  
  private void ah(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY();
    bi(f1);
    f1 -= this.mLastY;
    float f2 = this.dl.getY();
    float f3 = f2 + f1;
    if (f3 < this.ekr) {
      this.dl.offsetTopAndBottom((int)(this.ekr - f2));
    }
    for (;;)
    {
      this.mLastY = paramMotionEvent.getRawY();
      return;
      if (f3 > this.eks - this.mMinimumHeight) {
        this.dl.offsetTopAndBottom((int)(this.eks - this.mMinimumHeight - f2));
      } else {
        this.dl.offsetTopAndBottom((int)f1);
      }
    }
  }
  
  private void bi(float paramFloat)
  {
    paramFloat -= this.mLastY;
    if (Math.abs(paramFloat) > this.FA)
    {
      if (paramFloat <= 0.0F) {
        break label66;
      }
      this.aY = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QUSDragFloatingScreenView", 2, "swipeDirectionJudge : mSlideStartDir -> " + this.aY);
      }
      return;
      label66:
      if (paramFloat < 0.0F) {
        this.aY = 2;
      }
    }
  }
  
  private void cnJ()
  {
    float f = this.dl.getY();
    if (f < this.eks - getDefaultHeight()) {
      if (this.mCurState <= 1) {
        if ((f < (this.eks - getDefaultHeight()) / 2.0F) || (this.aY == 2)) {
          ekr();
        }
      }
    }
    do
    {
      do
      {
        return;
        eks();
        return;
      } while (this.mCurState != 2);
      if ((f > (this.eks - getDefaultHeight()) / 2.0F) || (this.aY == 1))
      {
        eks();
        return;
      }
      ekr();
      return;
      if (this.mCurState >= 1)
      {
        if ((f >= this.eks - this.mMinimumHeight - (getDefaultHeight() - this.mMinimumHeight) / 2) || (this.aY == 1))
        {
          ekt();
          return;
        }
        eks();
        return;
      }
    } while (this.mCurState != 0);
    if ((f <= this.eks - this.mMinimumHeight - (getDefaultHeight() - this.mMinimumHeight) / 2) || (this.aY == 2))
    {
      eks();
      return;
    }
    ekt();
  }
  
  private int getDefaultHeight()
  {
    int j = this.mMinimumHeight;
    if (this.a == null) {}
    for (int i = this.mMinimumHeight;; i = this.a.MY()) {
      return Math.max(j, Math.min(i, this.eks - this.ekr));
    }
  }
  
  private int kH(int paramInt)
  {
    return (int)(paramInt * this.mDensity + 0.5F);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "dispatchTouchEvent : " + paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.dcf)
    {
      return true;
      this.mLastY = paramMotionEvent.getRawY();
      Rect localRect = new Rect();
      this.cp.getGlobalVisibleRect(localRect);
      if ((!localRect.isEmpty()) && (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {}
      for (boolean bool = true;; bool = false)
      {
        this.dcf = bool;
        if (this.dcf) {
          TO(true);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QUSDragFloatingScreenView", 2, "mConsumeTouchEvent : " + this.dcf);
        break;
      }
      if (this.dcf)
      {
        ah(paramMotionEvent);
        return true;
        if (this.dcf) {
          cnJ();
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void ekr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showTotal");
    }
    this.mCurState = 2;
    this.Ga.setImageResource(2130850667);
    Zi(this.ekr);
    if (this.a != null) {
      this.a.eko();
    }
  }
  
  public void eks()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showDefaultHeight");
    }
    if (this.eks - getDefaultHeight() > this.ekr)
    {
      this.mCurState = 1;
      this.Ga.setImageResource(2130850666);
      Zi(this.eks - getDefaultHeight());
      if (this.a != null) {
        this.a.ekp();
      }
    }
  }
  
  public void ekt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QUSDragFloatingScreenView", 2, "showMinHeight");
    }
    this.mCurState = 0;
    this.Ga.setImageResource(2130850666);
    Zi(this.eks - this.mMinimumHeight);
    if (this.a != null) {
      this.a.ekq();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.eks <= 0)
    {
      this.eks = getMeasuredHeight();
      paramInt2 = this.eks;
      if (this.mMode == 0) {}
      for (paramInt1 = getDefaultHeight();; paramInt1 = 0)
      {
        paramInt2 -= paramInt1;
        paramInt1 = 0;
        while (paramInt1 < getChildCount())
        {
          View localView = getChildAt(paramInt1);
          localView.layout(0, paramInt2, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
          localView.setTag("QUSDragFloatingScreenView");
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void setQUSDragFloatController(arly paramarly)
  {
    int j = 0;
    this.a = paramarly;
    if (paramarly != null)
    {
      View localView = paramarly.createContentView();
      if (localView != null)
      {
        if (localView.getParent() != null) {
          ((ViewGroup)localView.getParent()).removeView(localView);
        }
        this.dl.addView(localView);
      }
      this.mMode = paramarly.MZ();
      if (this.mMode != 0) {
        break label98;
      }
    }
    label98:
    for (int i = this.mMinimumHeight;; i = 0)
    {
      this.mMinimumHeight = i;
      i = j;
      if (this.mMode == 0) {
        i = 1;
      }
      this.mCurState = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qus.QUSDragFloatingScreenView
 * JD-Core Version:    0.7.0.1
 */