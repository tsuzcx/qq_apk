package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdaptiveLayout
  extends ViewGroup
{
  private int dfU;
  private int eeP;
  private int eeQ;
  private int eeR;
  private int mGravity;
  private int mOrientation;
  private Map<Integer, a> oC = new HashMap();
  
  public AdaptiveLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdaptiveLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdaptiveLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject = this.oC.keySet().toArray();
    Arrays.sort(arrayOfObject);
    int i6 = getChildCount();
    int i3 = 0;
    int j = this.mPaddingTop;
    int i7 = arrayOfObject.length;
    int i8 = arrayOfObject.length;
    int i1 = 0;
    Object localObject;
    int i2;
    if (i1 < i8)
    {
      localObject = arrayOfObject[i1];
      i2 = ((Integer)localObject).intValue();
      if (i2 <= i6) {
        break label557;
      }
      i2 = i6;
    }
    label166:
    label557:
    for (;;)
    {
      localObject = (a)this.oC.get(localObject);
      int i = this.eeP;
      int m = this.eeQ;
      int n;
      int k;
      switch (this.mGravity & 0x7)
      {
      default: 
        n = this.mPaddingLeft;
        k = i;
        i = n;
        switch (this.mGravity & 0x70)
        {
        }
        break;
      }
      int i4;
      for (;;)
      {
        i4 = this.mPaddingTop;
        n = m;
        m = i4;
        for (;;)
        {
          for (i4 = i; i3 < i2; i4 = i5)
          {
            View localView = getChildAt(i3);
            i5 = i4;
            if (localView.getVisibility() != 8)
            {
              i5 = (((a)localObject).h - localView.getMeasuredHeight()) / 2 + (m + j);
              localView.layout(i4, i5, localView.getMeasuredWidth() + i4, localView.getMeasuredHeight() + i5);
              i5 = i4 + (localView.getMeasuredWidth() + k);
            }
            i3 += 1;
          }
          n = this.mPaddingLeft;
          i4 = ((a)localObject).w;
          k = i;
          i = n + paramInt3 - paramInt1 - i4;
          break label166;
          n = this.mPaddingLeft;
          i4 = (paramInt3 - paramInt1 - ((a)localObject).w) / 2;
          k = i;
          i = n + i4;
          break label166;
          i = i2 - i3;
          i = (paramInt3 - paramInt1 - (((a)localObject).w - this.eeP * (i - 1))) / i;
          break;
          i4 = this.mPaddingTop;
          int i5 = this.dfU;
          n = m;
          m = i4 + paramInt4 - paramInt2 - i5;
          continue;
          i4 = this.mPaddingTop;
          i5 = (paramInt4 - paramInt2 - this.dfU) / 2;
          n = m;
          m = i4 + i5;
        }
        m = (paramInt4 - paramInt2 - (this.dfU - this.eeQ * (i7 - 1))) / i7;
      }
      if (i != i4) {}
      for (i = ((a)localObject).h + n + j;; i = j)
      {
        i1 += 1;
        j = i;
        break;
        return;
      }
    }
  }
  
  private void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  private void measureHorizontal(int paramInt1, int paramInt2)
  {
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int m = this.mPaddingLeft;
    int n = this.mPaddingRight;
    int i9 = getChildCount();
    this.oC.clear();
    measureChildren(paramInt1, paramInt2);
    int i = 0;
    int j = 0;
    int k = 0;
    m += n;
    int i4 = 0;
    if (i4 < i9)
    {
      View localView = getChildAt(i4);
      n = i;
      i1 = j;
      int i2 = k;
      int i3 = m;
      if (localView.getVisibility() != 8)
      {
        if (i8 == 0) {
          break label291;
        }
        n = i;
        i1 = j;
        i2 = k;
        i3 = m;
        if (i4 > 0)
        {
          n = i;
          i1 = j;
          i2 = k;
          i3 = m;
          if (localView.getMeasuredWidth() + m > i6)
          {
            m -= this.eeP;
            i1 = Math.max(j, m);
            n = i + (this.eeQ + k);
            this.oC.put(Integer.valueOf(i4), new a(m, k));
            i = this.mPaddingLeft;
            i3 = this.mPaddingRight + i;
            i2 = 0;
          }
        }
        i3 += localView.getMeasuredWidth() + this.eeP;
        i2 = Math.max(i2, localView.getMeasuredHeight());
      }
      for (;;)
      {
        i4 += 1;
        i = n;
        j = i1;
        k = i2;
        m = i3;
        break;
        label291:
        i3 = m + (localView.getMeasuredWidth() + this.eeP);
        i2 = Math.max(k, localView.getMeasuredHeight());
        n = i;
        i1 = j;
      }
    }
    n = i;
    int i1 = j;
    if (m != 0)
    {
      m -= this.eeP;
      i1 = Math.max(j, m);
      n = i + k;
      this.oC.put(Integer.valueOf(i4), new a(m, k));
    }
    this.eeR = i1;
    this.dfU = n;
    switch (i8)
    {
    default: 
      switch (i7)
      {
      }
      break;
    }
    for (;;)
    {
      i = Math.max(i1, getSuggestedMinimumWidth());
      j = Math.max(n, getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(i, paramInt1), resolveSize(j, paramInt2));
      return;
      i1 = i6;
      break;
      i1 = Math.min(i1 + this.mPaddingLeft + this.mPaddingTop, i6);
      break;
      n = i5;
      continue;
      n = Math.min(n + this.mPaddingTop + this.mPaddingBottom, i5);
    }
  }
  
  private void measureVertical(int paramInt1, int paramInt2) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOrientation == 1)
    {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void setGap(int paramInt1, int paramInt2)
  {
    this.eeP = paramInt1;
    this.eeQ = paramInt2;
  }
  
  public void setGravity(int paramInt)
  {
    this.mGravity = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  class a
  {
    public int h;
    public int w;
    
    public a(int paramInt1, int paramInt2)
    {
      this.w = paramInt1;
      this.h = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AdaptiveLayout
 * JD-Core Version:    0.7.0.1
 */