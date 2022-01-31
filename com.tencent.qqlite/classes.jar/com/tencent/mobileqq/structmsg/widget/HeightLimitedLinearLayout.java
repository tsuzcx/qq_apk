package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

public class HeightLimitedLinearLayout
  extends LinearLayout
{
  protected int a = -1;
  
  public HeightLimitedLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeightLimitedLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredHeight();
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if ((this.a > 0) && (paramInt2 > this.a))
    {
      setMeasuredDimension(paramInt1, this.a);
      return;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout
 * JD-Core Version:    0.7.0.1
 */