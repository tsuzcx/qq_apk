package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.GridView;
import atau.a;

public class ExtendGridView
  extends GridView
{
  protected int mHorizontalSpacing;
  protected int mNumColumns;
  protected boolean mPenetrateTouch;
  protected int mScreenHeight;
  protected int mScreenWidth;
  protected boolean mStretchable;
  protected int mVerticalSpacing;
  
  public ExtendGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qM);
    this.mStretchable = paramContext.getBoolean(1, false);
    this.mPenetrateTouch = paramContext.getBoolean(0, false);
    paramContext.recycle();
    updateScreenSize();
  }
  
  private void updateScreenSize()
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    this.mScreenWidth = localDisplay.getWidth();
    this.mScreenHeight = localDisplay.getHeight();
  }
  
  public int computeItemWidth()
  {
    if (getWidth() > 0) {}
    for (int i = getWidth();; i = getMeasuredWidth())
    {
      int j = i;
      if (i <= 0) {
        j = this.mScreenWidth;
      }
      i = getHorizontalSpacing();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      int n = getNumColumns();
      j = (j - (k + m) - i * (n - 1)) / n;
      i = j;
      if (j < 0) {
        i = -2;
      }
      return i;
    }
  }
  
  public int getHorizontalSpacing()
  {
    return this.mHorizontalSpacing;
  }
  
  public int getNumColumns()
  {
    return this.mNumColumns;
  }
  
  public int getVerticalSpacing()
  {
    return this.mVerticalSpacing;
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    updateScreenSize();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mStretchable) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((this.mPenetrateTouch) && (i < 0)) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    super.setHorizontalSpacing(paramInt);
    this.mHorizontalSpacing = paramInt;
  }
  
  public void setNumColumns(int paramInt)
  {
    super.setNumColumns(paramInt);
    this.mNumColumns = paramInt;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setPenetrateTouch(boolean paramBoolean)
  {
    this.mPenetrateTouch = paramBoolean;
  }
  
  public void setStretchable(boolean paramBoolean)
  {
    if (this.mStretchable != paramBoolean)
    {
      this.mStretchable = paramBoolean;
      requestLayout();
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    super.setVerticalSpacing(paramInt);
    this.mVerticalSpacing = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.ExtendGridView
 * JD-Core Version:    0.7.0.1
 */