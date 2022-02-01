package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import atau.a;

public class ScaleFitXYFrameLayout
  extends FrameLayout
{
  private Context mContext;
  private float mHeightWeight = 1.0F;
  private float mWidthWeight = 1.0F;
  
  public ScaleFitXYFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramContext = this.mContext.obtainStyledAttributes(paramAttributeSet, atau.a.rV);
    this.mWidthWeight = paramContext.getFloat(1, 1.0F);
    this.mHeightWeight = paramContext.getFloat(0, 1.0F);
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    View.MeasureSpec.getSize(paramInt2);
    if (this.mWidthWeight == 1.0F) {
      if (i != 0)
      {
        k = (int)(j * this.mHeightWeight);
        setMeasuredDimension(j, k);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(j, i);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(k, paramInt1);
        measureChildren(paramInt2, paramInt1);
      }
    }
    while (this.mHeightWeight != 1.0F) {
      for (;;)
      {
        int k;
        return;
        setMeasuredDimension(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, i);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, paramInt1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.ScaleFitXYFrameLayout
 * JD-Core Version:    0.7.0.1
 */