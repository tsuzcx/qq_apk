package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import auuz;
import com.tencent.qphone.base.util.QLog;

public class PullToZoomListView
  extends XListView
{
  private static final Interpolator sInterpolator = new auuz();
  protected View Ly;
  protected ScalingRunnalable a;
  protected int aVz;
  protected FrameLayout bR;
  protected int eun;
  protected float kt = -1.0F;
  protected int mActivePointerId = -1;
  protected boolean mEnable = true;
  protected boolean mInited;
  protected float mLastMotionY = -1.0F;
  protected float mMaxScale = -1.0F;
  protected int mScreenHeight;
  
  public PullToZoomListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PullToZoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PullToZoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void dc(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PullToZoomListView", 2, "initHeaderView");
    }
    this.bR = new FrameLayout(getContext());
    this.bR.addView(paramView);
  }
  
  private void exl()
  {
    if (!this.mInited) {
      return;
    }
    if ((this.bR.getBottom() >= this.aVz) && (QLog.isColorLevel())) {
      QLog.d("PullToZoomListView", 2, "endScraling");
    }
    this.a.startAnimation(200L);
  }
  
  private void init(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.mScreenHeight = localDisplayMetrics.heightPixels;
    this.a = new ScalingRunnalable();
  }
  
  private void reset()
  {
    this.mActivePointerId = -1;
    this.mLastMotionY = -1.0F;
    this.mMaxScale = -1.0F;
    this.kt = -1.0F;
  }
  
  public void Wi(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void addHeaderView(View paramView)
  {
    dc(paramView);
    super.addHeaderView(this.bR);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    dc(paramView);
    super.addHeaderView(this.bR, paramObject, paramBoolean);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mInited) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (!this.a.mIsFinished) {
        this.a.abortAnimation();
      }
      this.mLastMotionY = paramMotionEvent.getY();
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mMaxScale = (this.mScreenHeight * 1.0F / this.aVz);
      this.kt = (this.bR.getBottom() / this.aVz);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.aVz == 0) && (this.bR != null) && (this.Ly != null))
    {
      this.aVz = this.bR.getHeight();
      this.eun = (this.aVz - this.Ly.getHeight());
      if (QLog.isColorLevel()) {
        QLog.d("PullToZoomListView", 2, "mHeaderHeight:" + this.aVz + " mHeaderBottomHeight:" + this.eun);
      }
      if (this.aVz > 0) {
        this.mInited = true;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.mInited) || (!this.mEnable)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PullToZoomListView", 2, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
        }
      }
      else
      {
        if (this.mLastMotionY == -1.0F) {
          this.mLastMotionY = paramMotionEvent.getY(i);
        }
        if (this.bR.getBottom() >= this.aVz)
        {
          ViewGroup.LayoutParams localLayoutParams1 = this.bR.getLayoutParams();
          ViewGroup.LayoutParams localLayoutParams2 = this.Ly.getLayoutParams();
          float f = ((paramMotionEvent.getY(i) - this.mLastMotionY + this.bR.getBottom()) / this.aVz - this.kt) / 2.0F + this.kt;
          if ((this.kt <= 1.0D) && (f < this.kt))
          {
            localLayoutParams1.height = this.aVz;
            localLayoutParams2.height = (this.aVz - this.eun);
            this.bR.setLayoutParams(localLayoutParams1);
            this.Ly.setLayoutParams(localLayoutParams2);
            return super.onTouchEvent(paramMotionEvent);
          }
          this.kt = Math.min(Math.max(f, 1.0F), this.mMaxScale);
          localLayoutParams1.height = ((int)(this.aVz * this.kt));
          localLayoutParams1.height -= this.eun;
          if (QLog.isColorLevel()) {
            QLog.d("PullToZoomListView", 2, "new height:" + localLayoutParams1.height + " imgHeight:" + localLayoutParams2.height + " mLastScale:" + this.kt);
          }
          if (localLayoutParams1.height < this.mScreenHeight)
          {
            this.bR.setLayoutParams(localLayoutParams1);
            this.Ly.setLayoutParams(localLayoutParams2);
          }
          this.mLastMotionY = paramMotionEvent.getY(i);
        }
        else
        {
          this.mLastMotionY = paramMotionEvent.getY(i);
          continue;
          reset();
          exl();
          continue;
          i = paramMotionEvent.getActionIndex();
          this.mLastMotionY = paramMotionEvent.getY(i);
          this.mActivePointerId = paramMotionEvent.getPointerId(i);
        }
      }
    }
  }
  
  public void setHeaderImage(View paramView)
  {
    this.Ly = paramView;
  }
  
  class ScalingRunnalable
    implements Runnable
  {
    long mDuration;
    boolean mIsFinished = true;
    float mScale;
    long mStartTime;
    
    ScalingRunnalable() {}
    
    public void abortAnimation()
    {
      this.mIsFinished = true;
    }
    
    public void run()
    {
      if (PullToZoomListView.this.bR == null) {}
      while ((this.mIsFinished) || (this.mScale <= 1.0D)) {
        return;
      }
      float f1 = ((float)SystemClock.currentThreadTimeMillis() - (float)this.mStartTime) / (float)this.mDuration;
      float f2 = this.mScale;
      float f3 = this.mScale;
      f1 = f2 - PullToZoomListView.d().getInterpolation(f1) * (f3 - 1.0F);
      ViewGroup.LayoutParams localLayoutParams1 = PullToZoomListView.this.bR.getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams2 = PullToZoomListView.this.Ly.getLayoutParams();
      if (f1 > 1.0F)
      {
        localLayoutParams1.height = PullToZoomListView.this.aVz;
        localLayoutParams2.height = (PullToZoomListView.this.aVz - PullToZoomListView.this.eun);
        localLayoutParams1.height = ((int)(f1 * PullToZoomListView.this.aVz));
        localLayoutParams1.height -= PullToZoomListView.this.eun;
        PullToZoomListView.this.bR.setLayoutParams(localLayoutParams1);
        PullToZoomListView.this.Ly.setLayoutParams(localLayoutParams2);
        PullToZoomListView.this.post(this);
        return;
      }
      this.mIsFinished = true;
    }
    
    public void startAnimation(long paramLong)
    {
      if (!PullToZoomListView.this.mInited) {
        return;
      }
      this.mStartTime = SystemClock.currentThreadTimeMillis();
      this.mDuration = paramLong;
      this.mScale = (PullToZoomListView.this.bR.getBottom() / PullToZoomListView.this.aVz);
      this.mIsFinished = false;
      PullToZoomListView.this.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.PullToZoomListView
 * JD-Core Version:    0.7.0.1
 */