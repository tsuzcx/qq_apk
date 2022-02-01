package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.androidqqmail.R.styleable;

public class FloatLayout
  extends ViewGroup
{
  protected int[] childSpaces;
  private int mHeight;
  
  public FloatLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FloatLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.childSpaces = new int[] { 0, 0, 0, 0 };
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatLayout);
    this.childSpaces[0] = paramContext.getDimensionPixelSize(R.styleable.FloatLayout_child_space_left, this.childSpaces[0]);
    this.childSpaces[1] = paramContext.getDimensionPixelSize(R.styleable.FloatLayout_child_space_top, this.childSpaces[1]);
    this.childSpaces[2] = paramContext.getDimensionPixelSize(R.styleable.FloatLayout_child_space_right, this.childSpaces[2]);
    this.childSpaces[3] = paramContext.getDimensionPixelSize(R.styleable.FloatLayout_child_space_bottom, this.childSpaces[3]);
    paramContext.recycle();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    int j = 0;
    while (j < getChildCount())
    {
      View localView = getChildAt(j);
      int i = paramInt2;
      int k = paramInt4;
      if (localView.getVisibility() != 8)
      {
        int m = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        i = paramInt2;
        k = paramInt4;
        if (paramInt4 + m + this.childSpaces[0] > paramInt3 - paramInt1)
        {
          k = getPaddingLeft() + this.childSpaces[0];
          i = paramInt2 + this.mHeight;
        }
        localView.layout(k, i, k + m, n + i);
        k += this.childSpaces[2] + m;
      }
      j += 1;
      paramInt2 = i;
      paramInt4 = k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mHeight = 0;
    int i3 = getChildCount();
    int i2 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i1 = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    int i = getPaddingLeft();
    paramInt1 = getPaddingTop();
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (int k = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);; k = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      int m = 0;
      while (m < i3)
      {
        View localView = getChildAt(m);
        int j = paramInt1;
        int n = i;
        if (localView.getVisibility() != 8)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i2, -2147483648), k);
          int i4 = localView.getMeasuredWidth();
          this.mHeight = Math.max(this.mHeight, localView.getMeasuredHeight() + this.childSpaces[1] + this.childSpaces[3]);
          j = paramInt1;
          n = i;
          if (i + i4 > i2)
          {
            n = getPaddingLeft();
            j = paramInt1 + this.mHeight;
          }
          n += i4;
        }
        m += 1;
        paramInt1 = j;
        i = n;
      }
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      paramInt1 = this.mHeight + paramInt1;
    }
    for (;;)
    {
      setMeasuredDimension(i2, paramInt1);
      return;
      if ((View.MeasureSpec.getMode(paramInt2) == -2147483648) && (this.mHeight + paramInt1 < i1)) {
        paramInt1 = this.mHeight + paramInt1;
      } else {
        paramInt1 = i1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FloatLayout
 * JD-Core Version:    0.7.0.1
 */