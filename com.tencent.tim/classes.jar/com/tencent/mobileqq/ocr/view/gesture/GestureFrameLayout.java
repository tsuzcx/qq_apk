package com.tencent.mobileqq.ocr.view.gesture;

import akpa;
import akpe;
import akpm;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;

public class GestureFrameLayout
  extends FrameLayout
{
  private final Matrix K = new Matrix();
  private final Matrix L = new Matrix();
  private final GestureProxy a = new GestureProxy(this);
  private final RectF aH = new RectF();
  private final float[] cR = new float[2];
  private View dc;
  private MotionEvent k;
  private final Matrix matrix = new Matrix();
  private final Matrix tempMatrix = new Matrix();
  
  public GestureFrameLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public GestureFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GestureFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.a().g(paramContext, paramAttributeSet);
    this.a.a(new akpa(this));
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent, Matrix paramMatrix)
  {
    this.cR[0] = paramMotionEvent.getX();
    this.cR[1] = paramMotionEvent.getY();
    paramMatrix.mapPoints(this.cR);
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setLocation(this.cR[0], this.cR[1]);
    return paramMotionEvent;
  }
  
  private void a(Rect paramRect, Matrix paramMatrix)
  {
    this.aH.set(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    paramMatrix.mapRect(this.aH);
    paramRect.set(Math.round(this.aH.left), Math.round(this.aH.top), Math.round(this.aH.right), Math.round(this.aH.bottom));
  }
  
  protected static int n(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == -2) {
      return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0);
    }
    return getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
  }
  
  public void P(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        P((ViewGroup)localView);
      }
      for (;;)
      {
        i += 1;
        break;
        localView.invalidate();
      }
    }
  }
  
  public GestureProxy a()
  {
    return this.a;
  }
  
  @TargetApi(16)
  public void a(akpm paramakpm)
  {
    if ((!isHardwareAccelerated()) || (this.dc == null))
    {
      this.matrix.set(paramakpm.getMatrix());
      this.matrix.invert(this.K);
      if (a().a() != null) {
        a().a().c(this.K);
      }
      invalidate();
    }
    do
    {
      return;
      this.dc.setPivotX(0.0F);
      this.dc.setPivotY(0.0F);
      this.dc.setScaleX(paramakpm.getZoom());
      this.dc.setScaleY(paramakpm.getZoom());
      this.dc.setTranslationX(paramakpm.getX());
      this.dc.setTranslationY(paramakpm.getY());
      this.tempMatrix.set(paramakpm.getMatrix());
      this.tempMatrix.invert(this.L);
    } while (a().a() == null);
    a().a().c(this.L);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() != 0) {
      throw new IllegalArgumentException("GestureFrameLayout can contain only one child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.matrix);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.k = paramMotionEvent;
    paramMotionEvent = a(paramMotionEvent, this.K);
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      paramMotionEvent.recycle();
    }
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    a(paramRect, this.matrix);
    return super.invalidateChildInParent(paramArrayOfInt, paramRect);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int m = localMarginLayoutParams.leftMargin;
    int n = localMarginLayoutParams.rightMargin;
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i3 = localMarginLayoutParams.topMargin;
    int i4 = localMarginLayoutParams.bottomMargin;
    paramView.measure(n(paramInt1, i + j + m + n + paramInt2, localMarginLayoutParams.width), n(paramInt3, i1 + i2 + i3 + i4 + paramInt4, localMarginLayoutParams.height));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.m(this, this.k);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() == 0) {}
    for (View localView = null;; localView = getChildAt(0))
    {
      this.dc = localView;
      if (this.dc != null)
      {
        this.a.a().b(this.dc.getMeasuredWidth(), this.dc.getMeasuredHeight());
        this.a.updateState();
      }
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a().a(paramInt1 - getPaddingLeft() - getPaddingRight(), paramInt2 - getPaddingTop() - getPaddingBottom());
    this.a.updateState();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.onTouch(this, this.k);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(this.k);
      localMotionEvent.setAction(3);
      this.a.m(this, localMotionEvent);
      localMotionEvent.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout
 * JD-Core Version:    0.7.0.1
 */