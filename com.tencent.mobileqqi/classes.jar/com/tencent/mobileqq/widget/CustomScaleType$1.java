package com.tencent.mobileqq.widget;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

 enum CustomScaleType$1
{
  CustomScaleType$1()
  {
    super(str, i, null);
  }
  
  public Matrix getMatrix(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f2;
    if ((i <= paramInt1) || (j <= paramInt2))
    {
      f2 = paramInt1 - i;
      f1 = paramInt2 - j;
      if (f1 < 0.0F) {}
      for (f1 *= 0.1F;; f1 *= 0.5F)
      {
        localMatrix.postTranslate((int)(f2 * 0.5F + 0.5F), (int)(f1 + 0.5F));
        return localMatrix;
      }
    }
    float f3;
    if (i * paramInt2 > paramInt1 * j)
    {
      f3 = paramInt2 / j;
      f2 = (paramInt1 - i * f3) * 0.5F;
    }
    for (;;)
    {
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
      break;
      f3 = paramInt1 / i;
      f1 = (paramInt2 - j) * f3;
      if (f1 < 0.0F)
      {
        f2 = 0.0F;
        f1 *= 0.1F;
      }
      else
      {
        f2 = 0.0F;
        f1 *= 0.5F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomScaleType.1
 * JD-Core Version:    0.7.0.1
 */