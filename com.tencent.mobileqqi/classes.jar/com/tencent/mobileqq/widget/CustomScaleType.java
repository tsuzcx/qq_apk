package com.tencent.mobileqq.widget;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

public enum CustomScaleType
  implements AnyScaleTypeImageView.DisplayRuleDef
{
  CENTER_SMALL_SCALE_BIG_RULE;
  
  public abstract Matrix getMatrix(Drawable paramDrawable, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomScaleType
 * JD-Core Version:    0.7.0.1
 */