package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import atau.a;

public class FixWidthRatioRelativeLayout
  extends RelativeLayout
{
  private float dw = 1.0F;
  
  public FixWidthRatioRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FixWidthRatioRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramAttributeSet);
  }
  
  public FixWidthRatioRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramAttributeSet);
  }
  
  public FixWidthRatioRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    b(paramAttributeSet);
  }
  
  private void b(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.qv);
    this.dw = (paramAttributeSet.getInteger(1, 1) / paramAttributeSet.getInteger(0, 1));
    paramAttributeSet.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) / this.dw), 1073741824));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.FixWidthRatioRelativeLayout
 * JD-Core Version:    0.7.0.1
 */