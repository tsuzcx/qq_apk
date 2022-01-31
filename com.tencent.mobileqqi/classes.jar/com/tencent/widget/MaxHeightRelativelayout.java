package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class MaxHeightRelativelayout
  extends RelativeLayout
{
  private int a = 2147483647;
  
  public MaxHeightRelativelayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MaxHeightRelativelayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public MaxHeightRelativelayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = paramInt2;
    if (View.MeasureSpec.getSize(paramInt2) > this.a)
    {
      i = paramInt2;
      if (j != 0) {
        i = View.MeasureSpec.makeMeasureSpec(this.a, j);
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
    if (this.a < getMeasuredHeight()) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.MaxHeightRelativelayout
 * JD-Core Version:    0.7.0.1
 */