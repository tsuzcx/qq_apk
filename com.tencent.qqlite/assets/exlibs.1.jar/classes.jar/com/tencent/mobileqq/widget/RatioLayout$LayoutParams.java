package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class RatioLayout$LayoutParams
  extends ViewGroup.LayoutParams
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public RatioLayout$LayoutParams(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2, 0.0F, 0.0F, paramFloat1, paramFloat2);
  }
  
  public RatioLayout$LayoutParams(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramInt1, paramInt2);
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.a = paramFloat3;
    this.b = paramFloat4;
  }
  
  public RatioLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RatioLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RatioLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */