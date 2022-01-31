package com.tencent.open.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;

public class MaxHeightScrollView
  extends ScrollView
{
  protected int a = 2147483647;
  
  public MaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a == 2147483647) {}
    View localView;
    do
    {
      do
      {
        return;
        if (getMeasuredHeight() > this.a) {
          setMeasuredDimension(getMeasuredWidth(), this.a);
        }
      } while (getChildCount() <= 0);
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    } while (localView.getMeasuredHeight() >= paramInt2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.widget.MaxHeightScrollView
 * JD-Core Version:    0.7.0.1
 */