package com.tencent.mobileqq.multiaio.widget;

import ajiq;
import ajiw;
import ajix;
import ajjd;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class MultiAIOViewPager
  extends MultiAIOBaseViewPager
{
  private ajjd jdField_a_of_type_Ajjd;
  private a jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager$a;
  private ajiq b;
  private int djo;
  private int djp = -1;
  private GestureDetector mGestureDetector;
  private View.OnClickListener mOnClickListener;
  private Paint mPaint = new Paint(1);
  
  public MultiAIOViewPager(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MultiAIOViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private boolean aqR()
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      Object localObject = localView.getTag();
      if ((localObject == null) || (!(localObject instanceof Integer))) {}
      int j;
      do
      {
        i += 1;
        break;
        j = ((Integer)localObject).intValue();
      } while ((localView.getScaleX() != 1.0F) || (j == getCurrentItem()));
      return false;
    }
    return true;
  }
  
  private void init()
  {
    this.mGestureDetector = new GestureDetector(getContext(), new ajiw(this), new Handler(Looper.getMainLooper()));
    a(new ajix(this));
  }
  
  public void aU(float paramFloat)
  {
    this.mMaximumVelocity = ((int)(this.djn * paramFloat));
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOViewPager", 2, "updateMaxVelocity() called with: mMaximumVelocity = [" + this.mMaximumVelocity + "]");
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOViewPager", 2, "dispatchTouchEvent() called with: ev = [" + paramMotionEvent + "], handled " + bool);
    }
    if ((bool) && (this.jdField_a_of_type_Ajjd != null)) {
      this.jdField_a_of_type_Ajjd.g(this, paramMotionEvent);
    }
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.b != null) {
      this.b.bEQ();
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i;
    try
    {
      i = super.getChildDrawingOrder(paramInt1, paramInt2);
      if ((i < 0) || (i >= paramInt1)) {
        throw new IndexOutOfBoundsException("childCount = " + paramInt1 + ", childDrawingOrder = " + i + ", try fix it");
      }
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOViewPager", 1, "getChildDrawingOrder: ", localException);
      super.sortChildDrawingOrder();
      return paramInt2;
    }
    return i;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOViewPager", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "], handled = " + bool);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager$a.setViewPagerBusy(bool);
      }
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramMotionEvent = getContext();
      if (!(paramMotionEvent instanceof Activity)) {
        break label152;
      }
    }
    Activity localActivity = (Activity)paramMotionEvent;
    paramMotionEvent = "onInterceptTouchEvent: Dispatching touch event activity.isFinish = " + localActivity.isFinishing();
    if (Build.VERSION.SDK_INT >= 17) {
      paramMotionEvent = paramMotionEvent + ", isDestroyed = " + localActivity.isDestroyed();
    }
    for (;;)
    {
      QLog.e("MultiAIOViewPager", 1, paramMotionEvent, localIllegalArgumentException);
      label152:
      return true;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    int i = getChildCount();
    boolean bool1 = aqP();
    Object localObject = getAdapter();
    if ((localObject instanceof MultiAIOPagerAdapter))
    {
      localObject = (MultiAIOPagerAdapter)localObject;
      boolean bool3 = ((MultiAIOPagerAdapter)localObject).aqQ();
      ((MultiAIOPagerAdapter)localObject).LZ(false);
      if (bool3) {
        bool1 = true;
      }
    }
    for (;;)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.djo != i) {
        bool1 = true;
      }
      if (!aqR()) {}
      for (paramBoolean = bool2;; paramBoolean = bool1)
      {
        if (paramBoolean) {
          super.pageScrolled(getScrollX());
        }
        this.djo = i;
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOViewPager", 2, "onTouchEvent() called with: ev = [" + paramMotionEvent + "], handled " + bool);
    }
    return bool;
  }
  
  public void pause()
  {
    if (this.b != null) {
      this.b.printLog();
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.b = new ajiq();
    this.b.setActTAG(paramString);
  }
  
  public void setAnchorX(int paramInt)
  {
    this.djp = paramInt;
    invalidate();
  }
  
  public void setIdleListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqMultiaioWidgetMultiAIOViewPager$a = parama;
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEventConsumer(ajjd paramajjd)
  {
    this.jdField_a_of_type_Ajjd = paramajjd;
  }
  
  public static abstract interface a
  {
    public abstract void setViewPagerBusy(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager
 * JD-Core Version:    0.7.0.1
 */