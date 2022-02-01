package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import aqcl;
import areq;
import ariq;
import auum;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.ScrollView;

public class BounceScrollView
  extends ScrollView
{
  ariq jdField_a_of_type_Ariq = null;
  auum jdField_a_of_type_Auum;
  private a jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$a;
  private b jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$b;
  protected c a;
  private int brc;
  private int brd;
  private float[] cA = { 0.0F, 1.0F };
  private boolean cZs;
  private boolean cZt;
  private boolean cZu;
  private int[] lH = { -654311425, -654311425 };
  private GestureDetector mGestureDetector = new GestureDetector(getContext(), new areq(this));
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int maxHeight;
  private float wX;
  
  public BounceScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(9)
  public BounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOverScrollMode(0);
    setFadingEdgeLength(0);
    if (AppSetting.enableTalkBack) {
      aqcl.Q(this, false);
    }
  }
  
  private void dub()
  {
    if (this.cZu)
    {
      this.mPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.wX, this.lH, this.cA, Shader.TileMode.CLAMP));
      this.mWidth = getWidth();
      this.mHeight = getHeight();
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$a.aDi();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$b != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$b.d(this, localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    for (;;)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$c != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$c.w(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        if (this.jdField_a_of_type_Ariq != null) {
          this.jdField_a_of_type_Ariq.d(this, paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      for (;;)
      {
        if (!bool1) {}
        try
        {
          boolean bool3 = super.dispatchTouchEvent(paramMotionEvent);
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
          return bool1;
        }
        catch (Exception paramMotionEvent)
        {
          return bool1;
        }
        if (i == 3)
        {
          if (this.jdField_a_of_type_Ariq != null) {
            this.jdField_a_of_type_Ariq.d(this, paramMotionEvent.getX(), paramMotionEvent.getY());
          }
        }
        else if ((i == 0) && (this.jdField_a_of_type_Ariq != null)) {
          this.jdField_a_of_type_Ariq.e(this, paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      bool1 = false;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (!this.cZu) {
      return super.drawChild(paramCanvas, paramView, paramLong);
    }
    int i = paramCanvas.saveLayer(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight(), null, 31);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    int j = paramCanvas.save();
    paramCanvas.drawRect(0.0F, this.mHeight + getScrollY() - this.wX, this.mWidth, this.mHeight + getScrollY(), this.mPaint);
    paramCanvas.restoreToCount(j);
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt);
    if (this.jdField_a_of_type_Ariq != null) {
      this.jdField_a_of_type_Ariq.P(this, paramInt);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).setInterceptTouchFlag(true);
    }
    try
    {
      if (this.cZs)
      {
        super.onInterceptTouchEvent(paramMotionEvent);
        return this.mGestureDetector.onTouchEvent(paramMotionEvent);
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.maxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$c.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.jdField_a_of_type_Ariq != null) {
      this.jdField_a_of_type_Ariq.k(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.cZu) {
      getChildAt(0).invalidate();
    }
    invalidate();
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    dub();
    if (this.jdField_a_of_type_Auum != null) {
      this.jdField_a_of_type_Auum.a(paramInt1, paramInt2, paramInt3, paramInt4, false, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    int i;
    int j;
    int k;
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      View localView;
      do
      {
        return bool;
        if ((!this.cZt) || (this.brc >= 0) || (this.brd <= 0)) {
          break;
        }
        localView = getChildAt(0);
        if (localView == null) {
          break;
        }
        i = getScrollY();
      } while (i < this.brc);
      j = localView.getMeasuredHeight();
      k = getHeight();
    } while ((i <= 0) || (k <= 0) || (j <= 0) || (j + this.brd > i + k));
    return true;
  }
  
  public void setDrawFinishedListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$a = parama;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public void setMotionEventInterceptor(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$b = paramb;
  }
  
  public void setNeedHorizontalGesture(boolean paramBoolean)
  {
    this.cZs = paramBoolean;
  }
  
  public void setOnScrollChangedListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$c = paramc;
  }
  
  public void setOnSizeChangeListener(auum paramauum)
  {
    this.jdField_a_of_type_Auum = paramauum;
  }
  
  public void setScrollListener(ariq paramariq)
  {
    this.jdField_a_of_type_Ariq = paramariq;
  }
  
  public void w(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.cZt = paramBoolean;
    this.brc = paramInt1;
    this.brd = paramInt2;
  }
  
  public static abstract interface a
  {
    public abstract void aDi();
  }
  
  public static abstract interface b
  {
    public abstract boolean d(View paramView, MotionEvent paramMotionEvent);
  }
  
  public static abstract interface c
  {
    public abstract void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void w(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BounceScrollView
 * JD-Core Version:    0.7.0.1
 */