package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;

public class HorizontalLabelLayout
  extends ViewGroup
{
  public int ety = 12;
  private int mStyle = 0;
  private int[] mTempIntArray;
  
  public HorizontalLabelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FrameLayout.LayoutParams;
  }
  
  protected FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new FrameLayout.LayoutParams(-2, -2, 16);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new FrameLayout.LayoutParams(paramLayoutParams);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new FrameLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i5 = getChildCount();
    int i6 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
    int i7 = getPaddingLeft();
    int i8 = getPaddingTop();
    int i9 = i6 / 2;
    paramInt3 = 0;
    paramInt2 = 0;
    int k;
    int i;
    int j;
    label101:
    View localView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i2;
    int i1;
    int n;
    int m;
    if (((this.mTempIntArray == null) && (i5 > 0)) || ((this.mTempIntArray != null) && (this.mTempIntArray.length < i5)))
    {
      this.mTempIntArray = new int[i5];
      paramInt4 = 0;
      k = 0;
      i = 0;
      j = 0;
      paramInt1 = paramInt3;
      paramInt3 = j;
      if (k >= i5) {
        break label502;
      }
      localView = getChildAt(k);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      i2 = paramInt4;
      i1 = i;
      n = paramInt2;
      m = paramInt3;
      j = paramInt1;
      if (localView.getVisibility() != 8)
      {
        j = localView.getMeasuredWidth();
        n = localView.getMeasuredHeight();
        j = localMarginLayoutParams.leftMargin + j + localMarginLayoutParams.rightMargin;
        i1 = localMarginLayoutParams.topMargin;
        i2 = localMarginLayoutParams.bottomMargin;
        if (this.mStyle != 1) {
          break label405;
        }
        if (i != 0) {
          break label389;
        }
        paramInt1 = Math.max(i9, j);
        label219:
        if (i + paramInt1 <= i6) {
          break label1043;
        }
        this.mTempIntArray[paramInt2] = paramInt4;
        j = 0;
        paramInt3 += paramInt4;
        paramInt4 = paramInt2 + 1;
        i = 0;
        paramInt2 = j;
      }
    }
    for (;;)
    {
      j = i + paramInt1;
      i = paramInt1;
      paramInt1 = j;
      j = paramInt2;
      i2 = Math.max(j, i1 + n + i2);
      j = i;
      m = paramInt3;
      n = paramInt4;
      i1 = paramInt1;
      if ((k == i5 - 1) && (n < this.mTempIntArray.length)) {
        this.mTempIntArray[n] = i2;
      }
      k += 1;
      paramInt4 = i2;
      i = i1;
      paramInt2 = n;
      paramInt3 = m;
      paramInt1 = j;
      break label101;
      if (this.mTempIntArray == null) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.mTempIntArray.length)
      {
        this.mTempIntArray[paramInt1] = 0;
        paramInt1 += 1;
      }
      break;
      label389:
      paramInt1 = Math.max(i9, this.ety + j);
      break label219;
      label405:
      if ((i + j > i6) && (i + j - localMarginLayoutParams.rightMargin <= i6)) {
        j -= localMarginLayoutParams.rightMargin;
      }
      for (;;)
      {
        m = paramInt1;
        paramInt1 = j + i;
        j = paramInt4;
        paramInt4 = paramInt2;
        i = m;
        break;
        if (i + j > i6)
        {
          paramInt3 += paramInt4;
          this.mTempIntArray[paramInt2] = paramInt4;
          paramInt2 += 1;
          paramInt4 = 0;
          i = 0;
          continue;
          label502:
          i1 = 0;
          i = 0;
          i2 = 0;
          paramInt3 = 0;
          m = 0;
          k = paramInt1;
          int i4;
          int i10;
          label625:
          int i3;
          if (i2 < i5)
          {
            localView = getChildAt(i2);
            localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
            if (localView.getVisibility() == 8) {
              break label1027;
            }
            int i11 = localView.getMeasuredWidth();
            int i12 = localView.getMeasuredHeight();
            i4 = localMarginLayoutParams.leftMargin + i11 + localMarginLayoutParams.rightMargin;
            paramInt1 = localMarginLayoutParams.topMargin;
            i10 = localMarginLayoutParams.bottomMargin + (paramInt1 + i12);
            if (this.mStyle == 1) {
              if (paramInt3 == 0)
              {
                k = Math.max(i9, i4);
                i3 = i4;
                j = i1;
                n = paramInt3;
                paramInt1 = i;
                paramInt4 = k;
                paramInt2 = m;
                if (paramInt3 + k > i6)
                {
                  paramInt2 = m + i1;
                  j = 0;
                  paramInt1 = i + 1;
                  n = 0;
                  paramInt4 = k;
                  i3 = i4;
                }
                label682:
                m = localMarginLayoutParams.leftMargin + (i7 + n);
                i = i8 + paramInt2 + localMarginLayoutParams.topMargin;
                if (((localMarginLayoutParams instanceof FrameLayout.LayoutParams)) && (paramInt1 < this.mTempIntArray.length))
                {
                  k = ((FrameLayout.LayoutParams)localMarginLayoutParams).gravity;
                  paramInt3 = k;
                  if (k == -1) {
                    paramInt3 = 16;
                  }
                }
                switch (paramInt3 & 0x70)
                {
                default: 
                  paramInt3 = i;
                  label784:
                  localView.layout(m, paramInt3, m + i11, paramInt3 + i12);
                  if (this.mStyle == 1)
                  {
                    paramInt3 = n + paramInt4;
                    label818:
                    i1 = Math.max(j, i10);
                  }
                  break;
                }
              }
            }
          }
          for (;;)
          {
            i2 += 1;
            i = paramInt1;
            k = paramInt4;
            m = paramInt2;
            break;
            k = Math.max(i9, this.ety + i4);
            break label625;
            if ((paramInt3 + i4 > i6) && (paramInt3 + i4 - localMarginLayoutParams.rightMargin <= i6))
            {
              i3 = i4 - localMarginLayoutParams.rightMargin;
              j = i1;
              n = paramInt3;
              paramInt1 = i;
              paramInt4 = k;
              paramInt2 = m;
              break label682;
            }
            i3 = i4;
            j = i1;
            n = paramInt3;
            paramInt1 = i;
            paramInt4 = k;
            paramInt2 = m;
            if (paramInt3 + i4 <= i6) {
              break label682;
            }
            paramInt2 = m + i1;
            j = 0;
            paramInt1 = i + 1;
            n = 0;
            i3 = i4;
            paramInt4 = k;
            break label682;
            paramInt3 = (this.mTempIntArray[paramInt1] - i10) / 2 + i;
            break label784;
            paramInt3 = this.mTempIntArray[paramInt1] - i10 + i;
            break label784;
            paramInt3 = n + i3;
            break label818;
            return;
            label1027:
            paramInt1 = i;
            paramInt4 = k;
            paramInt2 = m;
          }
        }
      }
      label1043:
      j = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = j;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i7 = getChildCount();
    int i8 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i9 = i8 / 2;
    int j = 0;
    int m = 0;
    int k = 0;
    int i = 0;
    int i3 = 0;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int i6;
    if (i3 < i7)
    {
      View localView = getChildAt(i3);
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      if (localView.getVisibility() == 8) {
        break label471;
      }
      measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      n = localView.getMeasuredWidth();
      int i10 = localView.getMeasuredHeight();
      i6 = n + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i11 = localMarginLayoutParams.topMargin;
      int i12 = localMarginLayoutParams.bottomMargin;
      if (this.mStyle == 1) {
        if (j == 0)
        {
          n = Math.max(i9, i6);
          label153:
          if (j + n <= i8) {
            break label452;
          }
          j = Math.max(k, j);
          i += m;
          k = 0;
          m = 0;
          label183:
          m += n;
          n = Math.max(k, i10 + i11 + i12);
          k = m;
        }
      }
    }
    for (;;)
    {
      i3 += 1;
      m = j;
      j = k;
      k = m;
      m = n;
      break;
      n = Math.max(i9, i6 + this.ety);
      break label153;
      int i4;
      int i5;
      int i2;
      if ((j + i6 > i8) && (j + i6 - localMarginLayoutParams.rightMargin <= i8))
      {
        i4 = i6 - localMarginLayoutParams.rightMargin;
        i5 = j;
        i2 = m;
        i1 = k;
        n = i;
      }
      for (;;)
      {
        j = i1;
        m = i4 + i5;
        i = n;
        k = i2;
        break;
        i4 = i6;
        n = i;
        i1 = k;
        i2 = m;
        i5 = j;
        if (j + i6 > i8)
        {
          i1 = Math.max(k, j);
          n = i + m;
          i2 = 0;
          i5 = 0;
          i4 = i6;
        }
      }
      j = Math.max(k, j);
      k = getPaddingLeft();
      n = getPaddingRight();
      i = Math.max(i + m + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(j + (k + n), getSuggestedMinimumWidth()), paramInt1), resolveSize(i, paramInt2));
      return;
      label452:
      int i1 = j;
      j = k;
      k = m;
      m = i1;
      break label183;
      label471:
      n = j;
      j = k;
      k = n;
      n = m;
    }
  }
  
  public void setStyle(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mStyle = 1;
      this.ety = ((int)(getContext().getResources().getDisplayMetrics().density * 6.0F));
      return;
    }
    this.mStyle = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.HorizontalLabelLayout
 * JD-Core Version:    0.7.0.1
 */