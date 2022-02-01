package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import atau.a;

public class VideoViewGroup
  extends FrameLayout
{
  private boolean asG = true;
  private float mHeightWeight;
  private float mWidthWeight;
  
  public VideoViewGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getResizeScale(paramAttributeSet);
  }
  
  private void getResizeScale(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.sI);
    this.mWidthWeight = paramAttributeSet.getFloat(1, 0.0F);
    this.mHeightWeight = paramAttributeSet.getFloat(0, 0.0F);
    paramAttributeSet.recycle();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    View.MeasureSpec.getMode(paramInt1);
    View.MeasureSpec.getMode(paramInt2);
    if (this.asG)
    {
      if ((this.mWidthWeight == 1.0F) && (this.mHeightWeight != 1.0F))
      {
        paramInt2 = (int)(i * this.mHeightWeight);
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        setMeasuredDimension(i, paramInt2);
        return;
      }
      if ((this.mWidthWeight != 1.0F) && (this.mHeightWeight == 1.0F))
      {
        i = (int)(j * this.mWidthWeight);
        super.onMeasure(paramInt1, paramInt2);
        setMeasuredDimension(i, j);
        return;
      }
      if ((this.mWidthWeight == 1.0F) && (this.mHeightWeight == 1.0F))
      {
        paramInt2 = (int)(i * this.mHeightWeight);
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        setMeasuredDimension(i, paramInt2);
        return;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void pL(boolean paramBoolean)
  {
    this.asG = paramBoolean;
    requestLayout();
  }
  
  public void setCustomSize(float paramFloat1, float paramFloat2)
  {
    this.mWidthWeight = paramFloat1;
    this.mHeightWeight = paramFloat2;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup
 * JD-Core Version:    0.7.0.1
 */