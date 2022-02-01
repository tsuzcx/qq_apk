package com.tencent.mobileqq.microapp.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import aqgz;
import com.tencent.mobileqq.microapp.R.drawable;

public class SwipeBackLayout
  extends FrameLayout
{
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private int lastX;
  private int lastY;
  private a mCallback;
  protected View mContentView;
  private int mContentWidth;
  private boolean mEnable = true;
  private boolean mIsClose;
  private int mLeftMoveDistance;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private float mScrollPercent;
  private Drawable mShadowDrawable;
  private int mTouchSlop;
  private h mViewDragHelper;
  
  public SwipeBackLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SwipeBackLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void drawScrim(Canvas paramCanvas, View paramView)
  {
    int i = (int)(((this.mScrimColor & 0xFF000000) >>> 24) * this.mScrimOpacity);
    int j = this.mScrimColor;
    paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
    paramCanvas.drawColor(i << 24 | j & 0xFFFFFF);
  }
  
  private void drawShadow(Canvas paramCanvas, View paramView)
  {
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    this.mShadowDrawable.setBounds(localRect.left - this.mShadowDrawable.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
    this.mShadowDrawable.draw(paramCanvas);
  }
  
  private void init()
  {
    this.mViewDragHelper = h.a(this, 1.0F, new g(this));
    this.mViewDragHelper.a(1);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.mShadowDrawable = getResources().getDrawable(R.drawable.g);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.mScrimOpacity = (1.0F - this.mScrollPercent);
    if ((this.mViewDragHelper != null) && (this.mViewDragHelper.a(true))) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if ((paramView == this.mContentView) && (this.mViewDragHelper.a() != 0))
    {
      drawShadow(paramCanvas, paramView);
      drawScrim(paramCanvas, paramView);
    }
    return bool;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() == 1)
    {
      this.mContentView = getChildAt(0);
      return;
    }
    throw new IllegalStateException("SwipeBackLayout can host only one direct child");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (!this.mEnable) {
      return false;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      this.lastX = j;
      this.lastY = k;
      if (i == 0) {
        break;
      }
      if (this.mViewDragHelper == null) {
        break label153;
      }
      return this.mViewDragHelper.a(paramMotionEvent);
      if (Math.abs(j) >= aqgz.getDesity() * 30.0F)
      {
        i = 0;
        continue;
        int m = this.lastX;
        int n = this.lastY;
        if (Math.abs(j - m) <= Math.abs(k - n))
        {
          i = 0;
          continue;
          i = 0;
        }
      }
    }
    label153:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mContentWidth = this.mContentView.getMeasuredWidth();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnable) {
      return false;
    }
    if (this.mViewDragHelper != null)
    {
      this.mViewDragHelper.b(paramMotionEvent);
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCallback(a parama)
  {
    this.mCallback = parama;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void onSwipeFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */