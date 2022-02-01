package com.tencent.mobileqq.hiboom;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class SquareRelativeLayout
  extends RelativeLayout
{
  private boolean ciY;
  
  public SquareRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public SquareRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SquareRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public SquareRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.ciY)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt2, paramInt2);
    paramInt1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public void setCloseSquare(boolean paramBoolean)
  {
    this.ciY = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.SquareRelativeLayout
 * JD-Core Version:    0.7.0.1
 */