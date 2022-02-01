package com.tencent.open.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import aqcx;

public class MaxHeightScrollView
  extends ScrollView
{
  private int mMaxHeight = 2147483647;
  
  public MaxHeightScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    emD();
  }
  
  private void emD()
  {
    this.mMaxHeight = (getScreenHeight(getContext()) - aqcx.dip2px(getContext(), 56.0F));
  }
  
  private int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = paramInt2;
    if (View.MeasureSpec.getSize(paramInt2) > this.mMaxHeight)
    {
      i = paramInt2;
      if (j != 0) {
        i = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, j);
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.widget.MaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */