package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class FadingHorizontalScrollView
  extends HorizontalScrollView
{
  private int avN = 1;
  
  public FadingHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FadingHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FadingHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected float getRightFadingEdgeStrength()
  {
    float f = 0.0F;
    if (this.avN != 1) {
      f = super.getRightFadingEdgeStrength();
    }
    return f;
  }
  
  public void setFadingMode(int paramInt)
  {
    this.avN = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.FadingHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */