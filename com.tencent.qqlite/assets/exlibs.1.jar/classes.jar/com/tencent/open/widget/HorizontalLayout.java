package com.tencent.open.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class HorizontalLayout
  extends ViewGroup
{
  protected static final int a = 0;
  protected static final int b = 0;
  protected int c;
  protected int d;
  
  static
  {
    if (!HorizontalLayout.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public HorizontalLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = super.getPaddingLeft();
    paramInt4 = super.getPaddingTop();
    paramInt1 = 0;
    while (paramInt1 < super.getChildCount())
    {
      View localView = super.getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        localView.layout(paramInt2, paramInt4, paramInt2 + paramInt3, localView.getMeasuredHeight() + paramInt4);
        paramInt3 = paramInt2 + (paramInt3 + 0);
      }
      paramInt1 += 1;
      paramInt2 = paramInt3;
    }
    this.d = paramInt2;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((!a) && (View.MeasureSpec.getMode(paramInt1) == 0)) {
      throw new AssertionError();
    }
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    int m = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int i3 = super.getChildCount();
    int i = super.getPaddingLeft();
    int i4 = super.getPaddingTop();
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(m, -2147483648);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.c = 0;
      int j = 0;
      while (j < i3)
      {
        View localView = super.getChildAt(j);
        int k = i;
        if (localView.getVisibility() != 8)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(n - i1 - i2, -2147483648), paramInt1);
          k = localView.getMeasuredWidth();
          this.c = Math.max(this.c, localView.getMeasuredHeight() + 0);
          k = i + (k + 0);
        }
        j += 1;
        i = k;
      }
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      paramInt1 = this.c + i4;
    }
    for (;;)
    {
      super.setMeasuredDimension(i, paramInt1 + 5);
      return;
      if ((View.MeasureSpec.getMode(paramInt2) == -2147483648) && (this.c + i4 < m)) {
        paramInt1 = this.c + i4;
      } else {
        paramInt1 = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.widget.HorizontalLayout
 * JD-Core Version:    0.7.0.1
 */