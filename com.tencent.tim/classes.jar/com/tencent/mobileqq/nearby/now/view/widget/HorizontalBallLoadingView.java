package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import atau.a;
import jll;

public class HorizontalBallLoadingView
  extends MetaballView
{
  private float mScale;
  
  public HorizontalBallLoadingView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalBallLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalBallLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int GJ()
  {
    return (int)(jll.dp2px(getContext(), 10.0F) * this.mScale);
  }
  
  protected void d(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.pH);
    this.mScale = paramContext.getFloat(0, 1.0F);
    paramContext.recycle();
  }
  
  protected int getRadius()
  {
    return (int)(jll.dp2px(getContext(), 6.0F) * this.mScale);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView
 * JD-Core Version:    0.7.0.1
 */