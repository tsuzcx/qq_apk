package com.tencent.av.ui.beauty;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;

public class PanelViewPage
  extends ViewPager
{
  private boolean Za = true;
  private int ayL;
  
  public PanelViewPage(Context paramContext)
  {
    super(paramContext);
  }
  
  public PanelViewPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.Za) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int i;
    if ((j == 0) && (this.ayL > 0)) {
      i = View.MeasureSpec.makeMeasureSpec(this.ayL, 1073741824);
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      return;
      i = paramInt1;
      if (j == 1073741824)
      {
        i = paramInt1;
        if (k > 0)
        {
          this.ayL = k;
          i = paramInt1;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.Za) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setIsPagingEnabled(boolean paramBoolean)
  {
    this.Za = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.PanelViewPage
 * JD-Core Version:    0.7.0.1
 */