package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class RatioLayout
  extends ViewGroup
{
  boolean dbp = false;
  
  public RatioLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RatioLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RatioLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void F(View paramView, int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    LayoutParams localLayoutParams;
    if ((paramView != null) && (paramView.getParent() == this))
    {
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams == null) {
        break label100;
      }
      f2 = localLayoutParams.xS;
    }
    label100:
    for (float f1 = localLayoutParams.xT;; f1 = 0.0F)
    {
      int j = paramView.getWidth();
      int i = paramView.getHeight();
      j = (int)(f2 * j);
      i = (int)(f1 * i);
      paramView.offsetLeftAndRight(paramInt1 - j - paramView.getLeft());
      paramView.offsetTopAndBottom(paramInt2 - i - paramView.getTop());
      return;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void g(View paramView, float paramFloat1, float paramFloat2)
  {
    F(paramView, (int)(getWidth() * paramFloat1), (int)(getHeight() * paramFloat2));
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2, 0.0F, 0.0F);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt3 = localView.getMeasuredWidth();
        paramInt4 = localView.getMeasuredHeight();
        int i = this.mPaddingLeft + (int)(localLayoutParams.x * getMeasuredWidth()) - (int)(localLayoutParams.xS * paramInt3);
        int j = this.mPaddingTop + (int)(localLayoutParams.y * getMeasuredHeight()) - (int)(localLayoutParams.xT * paramInt4);
        localView.layout(i, j, paramInt3 + i, paramInt4 + j);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = getChildCount();
    if (this.dbp)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    measureChildren(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int k = 0;
    int j = 0;
    int i = 0;
    int m;
    if (k < n)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 8) {
        break label258;
      }
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      m = localView.getMeasuredWidth();
      int i3 = localView.getMeasuredHeight();
      int i6 = (int)(localLayoutParams.x * i1);
      int i7 = (int)(localLayoutParams.xS * m);
      int i4 = (int)(localLayoutParams.y * i2);
      int i5 = (int)(localLayoutParams.xT * i3);
      m = Math.max(j, m + (i6 - i7));
      j = Math.max(i, i3 + (i4 - i5));
      i = m;
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      k = this.mPaddingLeft;
      m = this.mPaddingRight;
      i = Math.max(this.mPaddingTop + this.mPaddingBottom + i, getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(k + m + j, getSuggestedMinimumWidth()), paramInt1), resolveSize(i, paramInt2));
      return;
      label258:
      m = i;
      i = j;
      j = m;
    }
  }
  
  public void setSkipMeasure(boolean paramBoolean)
  {
    this.dbp = paramBoolean;
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public float x;
    public float xS;
    public float xT;
    public float y;
    
    public LayoutParams(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      this(paramInt1, paramInt2, 0.0F, 0.0F, paramFloat1, paramFloat2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      super(paramInt2);
      this.xS = paramFloat1;
      this.xT = paramFloat2;
      this.x = paramFloat3;
      this.y = paramFloat4;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RatioLayout
 * JD-Core Version:    0.7.0.1
 */