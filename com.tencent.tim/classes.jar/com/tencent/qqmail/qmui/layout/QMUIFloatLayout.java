package com.tencent.qqmail.qmui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.androidqqmail.R.styleable;

public class QMUIFloatLayout
  extends ViewGroup
{
  private int mChildHorizontalSpacing;
  private int mChildVerticalSpacing;
  private int mGravity;
  private int[] mItemNumberInEachLine;
  private int[] mWidthSumInEachLine;
  
  public QMUIFloatLayout(Context paramContext)
  {
    super(paramContext);
    this.mChildHorizontalSpacing = 0;
    this.mChildVerticalSpacing = 0;
    this.mGravity = 0;
  }
  
  public QMUIFloatLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QMUIFloatlayout);
    this.mChildHorizontalSpacing = paramContext.getDimensionPixelSize(R.styleable.QMUIFloatlayout_childHorizontalSpacing, 0);
    this.mChildVerticalSpacing = paramContext.getDimensionPixelSize(R.styleable.QMUIFloatlayout_childVerticalSpacing, 0);
    this.mGravity = paramContext.getInteger(R.styleable.QMUIFloatlayout_qmiui_gravity, 3);
    paramContext.recycle();
  }
  
  public QMUIFloatLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void layoutWithGravityCenterHorizontal(int paramInt)
  {
    getPaddingLeft();
    int k = getPaddingTop();
    int i = 0;
    int j = 0;
    for (;;)
    {
      if ((j >= this.mItemNumberInEachLine.length) || (this.mItemNumberInEachLine[j] == 0)) {
        return;
      }
      int n = (paramInt - this.mWidthSumInEachLine[j]) / 2;
      int i1 = 0;
      int m = i;
      if (m < this.mItemNumberInEachLine[j] + i)
      {
        View localView = getChildAt(m);
        if (localView.getVisibility() == 8) {}
        for (;;)
        {
          m += 1;
          break;
          int i2 = localView.getMeasuredWidth();
          int i3 = localView.getMeasuredHeight();
          localView.layout(n, k, n + i2, k + i3);
          i1 = Math.max(i1, i3);
          n += this.mChildHorizontalSpacing + i2;
        }
      }
      k += this.mChildVerticalSpacing + i1;
      i += this.mItemNumberInEachLine[j];
      j += 1;
    }
  }
  
  private void layoutWithGravityLeft(int paramInt)
  {
    int j = getPaddingLeft();
    int i = getPaddingTop();
    int i3 = getChildCount();
    int n = 0;
    int k = 0;
    if (n < i3)
    {
      View localView = getChildAt(n);
      int m;
      if (localView.getVisibility() == 8) {
        m = k;
      }
      for (;;)
      {
        n += 1;
        k = m;
        break;
        int i4 = localView.getMeasuredWidth();
        int i5 = localView.getMeasuredHeight();
        int i2 = Math.max(k, i5);
        m = i2;
        k = i;
        int i1 = j;
        if (j + i4 > getPaddingLeft() + paramInt)
        {
          i1 = getPaddingLeft();
          k = i2 + this.mChildVerticalSpacing + i;
          m = 0;
        }
        localView.layout(i1, k, i1 + i4, i5 + k);
        j = i1 + (this.mChildHorizontalSpacing + i4);
        i = k;
      }
    }
  }
  
  public int getGravity()
  {
    switch (this.mGravity)
    {
    default: 
      return 3;
    }
    return 1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
    if (getGravity() == 1)
    {
      layoutWithGravityCenterHorizontal(paramInt1);
      return;
    }
    layoutWithGravityLeft(paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int m = 0;
    int i6 = getChildCount();
    this.mItemNumberInEachLine = new int[i6];
    this.mWidthSumInEachLine = new int[i6];
    int j;
    int k;
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if (i == 1073741824)
    {
      j = getPaddingLeft();
      i = getPaddingTop();
      int i8 = getPaddingLeft();
      int i9 = getPaddingRight();
      k = 0;
      int i1 = 0;
      if (i1 < i6)
      {
        localObject = getChildAt(i1);
        if (((View)localObject).getVisibility() == 8) {}
        for (;;)
        {
          i1 += 1;
          break;
          localLayoutParams = ((View)localObject).getLayoutParams();
          ((View)localObject).measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localLayoutParams.height));
          int i10 = ((View)localObject).getMeasuredWidth();
          int i5 = Math.max(m, ((View)localObject).getMeasuredHeight());
          int n = i;
          int i2 = j;
          m = k;
          if (j + i10 > getPaddingLeft() + (i3 - i8 - i9))
          {
            localObject = this.mWidthSumInEachLine;
            localObject[k] -= this.mChildHorizontalSpacing;
            m = k + 1;
            i2 = getPaddingLeft();
            n = i + (this.mChildVerticalSpacing + i5);
          }
          localObject = this.mItemNumberInEachLine;
          localObject[m] += 1;
          localObject = this.mWidthSumInEachLine;
          localObject[m] += this.mChildHorizontalSpacing + i10;
          j = i2 + (this.mChildHorizontalSpacing + i10);
          i = n;
          k = m;
          m = i5;
        }
      }
      if ((this.mWidthSumInEachLine.length > 0) && (this.mWidthSumInEachLine[k] > 0))
      {
        localObject = this.mWidthSumInEachLine;
        localObject[k] -= this.mChildHorizontalSpacing;
      }
      if (i7 == 0)
      {
        paramInt1 = i + m + getPaddingBottom();
        paramInt2 = i3;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      if (i7 == -2147483648)
      {
        paramInt1 = Math.min(i + m + getPaddingBottom(), i4);
        break;
      }
      paramInt1 = i4;
      break;
      i = getPaddingLeft();
      k = getPaddingRight();
      j = 0;
      m = i + k;
      k = 0;
      i = 0;
      if (i < i6)
      {
        localObject = getChildAt(i);
        if (((View)localObject).getVisibility() == 8) {}
        for (;;)
        {
          i += 1;
          break;
          localLayoutParams = ((View)localObject).getLayoutParams();
          ((View)localObject).measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localLayoutParams.height));
          m += ((View)localObject).getMeasuredWidth();
          k = Math.max(k, ((View)localObject).getMeasuredHeight());
          j += 1;
        }
      }
      paramInt2 = m + (j - 1) * this.mChildHorizontalSpacing;
      paramInt1 = getPaddingTop() + k + getPaddingBottom();
      this.mItemNumberInEachLine[0] = i6;
      this.mWidthSumInEachLine[0] = paramInt2;
    }
  }
  
  public void setChildHorizontalSpacing(int paramInt)
  {
    this.mChildHorizontalSpacing = paramInt;
    invalidate();
  }
  
  public void setChildVerticalSpacing(int paramInt)
  {
    this.mChildVerticalSpacing = paramInt;
    invalidate();
  }
  
  public void setGravity(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.mGravity = 3;
      return;
    }
    this.mGravity = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.layout.QMUIFloatLayout
 * JD-Core Version:    0.7.0.1
 */