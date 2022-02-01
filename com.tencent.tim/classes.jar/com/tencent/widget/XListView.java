package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import atau.a;
import auum;
import wja;

public class XListView
  extends ListView
{
  private auum jdField_a_of_type_Auum;
  private a jdField_a_of_type_ComTencentWidgetXListView$a;
  private b jdField_a_of_type_ComTencentWidgetXListView$b;
  private boolean dlk;
  private int mLastRadius;
  private int mLastRoundMode;
  private int mMaxHeight = -1;
  private int mOrientation;
  private int mRadius;
  private int mRoundMode = 0;
  private Path mRoundPath;
  
  public XListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mOverscrollDistance = 2147483647;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.tf);
    setMaxHeight(localTypedArray.getDimensionPixelSize(0, -1));
    localTypedArray.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sP);
    boolean bool = paramContext.getBoolean(0, false);
    paramContext.recycle();
    setEdgeEffectEnabled(bool);
    this.mRoundPath = new Path();
    this.mRoundPath.setFillType(Path.FillType.EVEN_ODD);
  }
  
  private int OY()
  {
    if (getContext().getResources().getDisplayMetrics().widthPixels > getContext().getResources().getDisplayMetrics().heightPixels) {
      return 1;
    }
    return 2;
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if (this.jdField_a_of_type_Auum != null) {
      this.jdField_a_of_type_Auum.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
    }
  }
  
  private void checkPathChanged()
  {
    if ((this.mLastRadius == this.mRadius) && (this.mLastRoundMode == this.mRoundMode)) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.mLastRadius = this.mRadius;
    this.mRoundPath.reset();
    switch (this.mRoundMode)
    {
    default: 
      return;
    case 1: 
      this.mRoundPath.addRoundRect(new RectF(0.0F, 0.0F, i, j), this.mRadius, this.mRadius, Path.Direction.CW);
      return;
    case 2: 
      localPath = this.mRoundPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.mRadius;
      f2 = this.mRadius;
      f3 = this.mRadius;
      f4 = this.mRadius;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, f4 }, localDirection);
      return;
    case 3: 
      localPath = this.mRoundPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.mRadius;
      f2 = this.mRadius;
      f3 = this.mRadius;
      f4 = this.mRadius;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      return;
    case 4: 
      localPath = this.mRoundPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.mRadius;
      f2 = this.mRadius;
      f3 = this.mRadius;
      f4 = this.mRadius;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, f1, f2, f3, f4, 0.0F, 0.0F }, localDirection);
      return;
    }
    Path localPath = this.mRoundPath;
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    float f1 = this.mRadius;
    float f2 = this.mRadius;
    float f3 = this.mRadius;
    float f4 = this.mRadius;
    Path.Direction localDirection = Path.Direction.CW;
    localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f2, f3, f4 }, localDirection);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentWidgetXListView$a != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView$a.aDi();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentWidgetXListView$b != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = this.jdField_a_of_type_ComTencentWidgetXListView$b.d(this, localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    for (;;)
    {
      if (!bool1) {
        try
        {
          bool2 = super.dispatchTouchEvent(paramMotionEvent);
          if (!bool1)
          {
            bool1 = bool3;
            if (!bool2) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
        catch (RuntimeException paramMotionEvent)
        {
          for (;;)
          {
            wja.a("XLISTVIEW_dispatchTouchEvent_ERROR", "dispatchTouchEvent_ERROR", paramMotionEvent);
            boolean bool2 = false;
          }
        }
      }
      return true;
      bool1 = false;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mRoundMode != 0)
    {
      int i = paramCanvas.save();
      checkPathChanged();
      paramCanvas.clipPath(this.mRoundPath);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    if (this.mMaxHeight > 0)
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      i = paramInt2;
      if (View.MeasureSpec.getSize(paramInt2) > this.mMaxHeight)
      {
        i = paramInt2;
        if (j != 0) {
          i = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, j);
        }
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, i);
      return;
      i = paramInt2;
      if (this.dlk) {
        i = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = OY();
    if (this.mOrientation != i) {}
    for (boolean bool = true;; bool = false)
    {
      c(paramInt1, paramInt2, paramInt3, paramInt4, bool, i);
      this.mOrientation = i;
      return;
    }
  }
  
  public void setCornerRadiusAndMode(int paramInt1, int paramInt2)
  {
    this.mRadius = paramInt1;
    this.mRoundMode = paramInt2;
  }
  
  public void setDrawFinishedListener(a parama)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView$a = parama;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
    if (this.mMaxHeight < getMeasuredHeight()) {
      requestLayout();
    }
  }
  
  public void setMotionEventInterceptor(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView$b = paramb;
  }
  
  public void setOnSizeChangeListener(auum paramauum)
  {
    this.jdField_a_of_type_Auum = paramauum;
  }
  
  public void setOverScrollDistance(int paramInt)
  {
    this.mOverscrollDistance = paramInt;
  }
  
  public void setWrapByScroll(boolean paramBoolean)
  {
    this.dlk = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void aDi();
  }
  
  public static abstract interface b
  {
    public abstract boolean d(View paramView, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.widget.XListView
 * JD-Core Version:    0.7.0.1
 */