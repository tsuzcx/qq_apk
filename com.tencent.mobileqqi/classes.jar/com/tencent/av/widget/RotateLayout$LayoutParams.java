package com.tencent.av.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqqi.R.styleable;

public class RotateLayout$LayoutParams
  extends ViewGroup.LayoutParams
{
  public int a;
  
  public RotateLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public RotateLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.T).getInt(0, 0);
  }
  
  public RotateLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.widget.RotateLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */