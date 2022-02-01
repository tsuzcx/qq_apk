package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

public class CoverView
  extends TextView
{
  public int a;
  
  public CoverView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt3);
    localGradientDrawable.setCornerRadius(paramFloat);
    if (paramInt1 > 0) {
      localGradientDrawable.setStroke(paramInt1, paramInt2);
    }
    setBackgroundDrawable(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.CoverView
 * JD-Core Version:    0.7.0.1
 */