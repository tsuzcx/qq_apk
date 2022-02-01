package com.tencent.biz.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class MultiLineLayout
  extends ViewGroup
{
  public static boolean aMo = true;
  private int byw;
  private float density;
  private int mHeight;
  private int mWidth;
  private int showLine = -1;
  int space;
  
  public MultiLineLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiLineLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MultiLineLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.space = ((int)(5.0F * this.density));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = 0;
    paramInt2 = 0;
    int k = getChildCount();
    label28:
    View localView;
    int m;
    int i;
    if (k > 0)
    {
      paramInt1 = 1;
      this.byw = paramInt1;
      paramInt4 = 0;
      paramInt1 = 0;
      if (paramInt4 >= k) {
        break label289;
      }
      localView = getChildAt(paramInt4);
      if (((this.showLine != -1) && (this.byw > this.showLine)) || (localView.getVisibility() == 8)) {
        break label271;
      }
      localView.setVisibility(0);
      m = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
      int j = paramInt3 + m + this.space;
      if (j > this.mWidth) {
        break label184;
      }
      localView.layout(paramInt3, paramInt1, m + paramInt3, paramInt1 + i);
      i = (int)Math.max(paramInt2, i + 5.0F * this.density);
      paramInt3 = j;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      i = paramInt4 + 1;
      paramInt4 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = i;
      break label28;
      paramInt1 = 0;
      break;
      label184:
      this.byw += 1;
      if ((this.showLine == -1) || (this.byw <= this.showLine))
      {
        paramInt1 += paramInt2;
        localView.layout(0, paramInt1, m, paramInt1 + i);
      }
      for (;;)
      {
        paramInt3 = this.space + m;
        i = (int)(i + 5.0F * this.density);
        paramInt2 = paramInt1;
        paramInt1 = i;
        break;
        localView.setVisibility(8);
      }
      label271:
      localView.setVisibility(8);
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    label289:
    if (this.mHeight == 0)
    {
      this.mHeight = (paramInt1 + paramInt2);
      return;
    }
    this.mHeight = (paramInt1 + paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    this.mWidth = View.MeasureSpec.getSize(paramInt1);
    measureChildren(paramInt1, paramInt2);
    int i1 = getChildCount();
    int k;
    int j;
    int i;
    label48:
    View localView;
    if (i1 > 0)
    {
      paramInt1 = 1;
      this.byw = paramInt1;
      k = 0;
      j = 0;
      paramInt1 = 0;
      i = 0;
      paramInt2 = m;
      if (k >= i1) {
        break label249;
      }
      localView = getChildAt(k);
      if (localView.getVisibility() != 8) {
        break label111;
      }
      m = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
      i = m;
    }
    label111:
    int n;
    for (;;)
    {
      m = k + 1;
      k = i;
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = k;
      k = m;
      break label48;
      paramInt1 = 0;
      break;
      m = localView.getMeasuredHeight();
      if ((this.showLine != -1) && (this.byw > this.showLine)) {
        break label249;
      }
      n = localView.getMeasuredWidth();
      paramInt2 = this.space + (i + n);
      if (paramInt2 > this.mWidth) {
        break label192;
      }
      j = (int)Math.max(j, m + 5.0F * this.density);
      i = paramInt1;
      paramInt1 += m;
    }
    label192:
    this.byw += 1;
    if ((this.showLine == -1) || (this.byw <= this.showLine)) {
      paramInt1 += j;
    }
    for (paramInt2 = paramInt1;; paramInt2 = paramInt1)
    {
      n = this.space + n;
      j = m;
      i = paramInt2;
      paramInt2 = n;
      break;
      label249:
      setMeasuredDimension(this.mWidth, paramInt2);
      return;
    }
  }
  
  public void setShowLine(int paramInt)
  {
    this.showLine = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.ui.MultiLineLayout
 * JD-Core Version:    0.7.0.1
 */