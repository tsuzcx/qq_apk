package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import hfi;

public class PuzzleAvatarUtil
{
  public static Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap, Bitmap paramBitmap, float paramFloat)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length <= 0)) {
      return null;
    }
    Bitmap[] arrayOfBitmap = new Bitmap[paramArrayOfBitmap.length];
    int j = 0;
    int i = 0;
    while (i < paramArrayOfBitmap.length)
    {
      k = j;
      if (paramArrayOfBitmap[i] != null)
      {
        arrayOfBitmap[j] = paramArrayOfBitmap[i];
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j < 1) {
      return null;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    float f = paramInt / 100.0F;
    int k = 0;
    RectF localRectF = new RectF();
    Rect localRect = new Rect();
    hfi[] arrayOfhfi = new hfi[j];
    i = 0;
    while (i < j)
    {
      arrayOfhfi[i] = new hfi(null);
      i += 1;
    }
    Bitmap localBitmap2 = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    localCanvas.drawARGB(0, 0, 0, 0);
    if (j == 1)
    {
      arrayOfhfi[0].jdField_a_of_type_Float = 0.0F;
      arrayOfhfi[0].jdField_a_of_type_Int = 0;
      arrayOfhfi[0].b = 0;
      arrayOfhfi[0].jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      i = 0;
      while ((i < j) && (j <= 6))
      {
        Bitmap localBitmap1 = arrayOfBitmap[i];
        paramArrayOfBitmap = localBitmap1;
        if (!arrayOfhfi[i].jdField_a_of_type_Boolean) {
          paramArrayOfBitmap = a(localBitmap1, paramBitmap, arrayOfhfi[i].jdField_a_of_type_Float, paramFloat);
        }
        if (paramArrayOfBitmap != null)
        {
          localRectF.set(arrayOfhfi[i].jdField_a_of_type_Int, arrayOfhfi[i].b, arrayOfhfi[i].jdField_a_of_type_Int + paramInt, arrayOfhfi[i].b + paramInt);
          localRect.set(0, 0, paramArrayOfBitmap.getWidth(), paramArrayOfBitmap.getHeight());
          localCanvas.drawBitmap(paramArrayOfBitmap, localRect, localRectF, localPaint);
        }
        i += 1;
      }
      if (j == 2)
      {
        i = (int)(60.0F * f + 0.5F);
        arrayOfhfi[0].jdField_a_of_type_Float = 0.0F;
        arrayOfhfi[0].jdField_a_of_type_Int = 0;
        arrayOfhfi[0].b = 0;
        arrayOfhfi[1].jdField_a_of_type_Float = 0.0F;
        arrayOfhfi[1].jdField_a_of_type_Int = (paramInt - i);
        arrayOfhfi[1].b = (paramInt - i);
        arrayOfhfi[1].jdField_a_of_type_Boolean = true;
        paramInt = i;
      }
      else if (j == 3)
      {
        i = (int)(52.0F * f + 0.5F);
        arrayOfhfi[0].jdField_a_of_type_Float = 75.0F;
        arrayOfhfi[0].jdField_a_of_type_Int = ((paramInt - i) / 2);
        arrayOfhfi[0].b = ((int)(2.0F * f));
        arrayOfhfi[1].jdField_a_of_type_Float = -165.0F;
        arrayOfhfi[1].jdField_a_of_type_Int = (paramInt - i);
        arrayOfhfi[1].b = (paramInt - i - (int)(2.0F * f));
        arrayOfhfi[2].jdField_a_of_type_Float = -45.0F;
        arrayOfhfi[2].jdField_a_of_type_Int = 0;
        arrayOfhfi[2].b = (paramInt - i - (int)(f * 2.0F));
        paramInt = i;
      }
      else if (j == 4)
      {
        i = (int)(52.0F * f + 0.5F);
        arrayOfhfi[0].jdField_a_of_type_Float = 135.0F;
        arrayOfhfi[0].jdField_a_of_type_Int = (paramInt - i);
        arrayOfhfi[0].b = 0;
        arrayOfhfi[1].jdField_a_of_type_Float = -135.0F;
        arrayOfhfi[1].jdField_a_of_type_Int = (paramInt - i);
        arrayOfhfi[1].b = (paramInt - i);
        arrayOfhfi[2].jdField_a_of_type_Float = -45.0F;
        arrayOfhfi[2].jdField_a_of_type_Int = 0;
        arrayOfhfi[2].b = (paramInt - i);
        arrayOfhfi[3].jdField_a_of_type_Float = 45.0F;
        arrayOfhfi[3].jdField_a_of_type_Int = 0;
        arrayOfhfi[3].b = 0;
        paramInt = i;
      }
      else if (j == 5)
      {
        i = (int)(40.0F * f + 0.5F);
        arrayOfhfi[0].jdField_a_of_type_Float = 170.0F;
        arrayOfhfi[0].jdField_a_of_type_Int = (paramInt - i);
        arrayOfhfi[0].b = ((int)(24.0F * f + 0.5F));
        arrayOfhfi[1].jdField_a_of_type_Float = -115.0F;
        arrayOfhfi[1].jdField_a_of_type_Int = (paramInt - i - (int)(12.0F * f + 0.5F));
        arrayOfhfi[1].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        arrayOfhfi[2].jdField_a_of_type_Float = -40.0F;
        arrayOfhfi[2].jdField_a_of_type_Int = ((int)(12.0F * f + 0.5F));
        arrayOfhfi[2].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        arrayOfhfi[3].jdField_a_of_type_Float = 25.0F;
        arrayOfhfi[3].jdField_a_of_type_Int = 0;
        arrayOfhfi[3].b = ((int)(24.0F * f + 0.5F));
        arrayOfhfi[4].jdField_a_of_type_Float = 100.0F;
        arrayOfhfi[4].jdField_a_of_type_Int = ((int)(30.0F * f + 0.5F));
        arrayOfhfi[4].b = ((int)(f * 2.0F + 0.5F));
        paramInt = i;
      }
      else
      {
        i = k;
        if (j >= 6)
        {
          i = (int)(36.0F * f + 0.5F);
          arrayOfhfi[0].jdField_a_of_type_Float = 135.0F;
          arrayOfhfi[0].b = ((int)(2.0F * f + 0.5F));
          arrayOfhfi[0].jdField_a_of_type_Int = (paramInt - i - (int)(15.0F * f + 0.5F));
          arrayOfhfi[1].jdField_a_of_type_Float = 200.0F;
          arrayOfhfi[1].b = ((int)(32.0F * f + 0.5F));
          arrayOfhfi[1].jdField_a_of_type_Int = (paramInt - i);
          arrayOfhfi[2].jdField_a_of_type_Float = -110.0F;
          arrayOfhfi[2].b = (paramInt - i - (int)(2.0F * f + 0.5F));
          arrayOfhfi[2].jdField_a_of_type_Int = (paramInt - i - (int)(15.0F * f + 0.5F));
          arrayOfhfi[3].jdField_a_of_type_Float = -45.0F;
          arrayOfhfi[3].b = (paramInt - i - (int)(2.0F * f + 0.5F));
          arrayOfhfi[3].jdField_a_of_type_Int = ((int)(15.0F * f + 0.5F));
          arrayOfhfi[4].jdField_a_of_type_Float = 20.0F;
          arrayOfhfi[4].b = ((int)(32.0F * f + 0.5F));
          arrayOfhfi[4].jdField_a_of_type_Int = 0;
          arrayOfhfi[5].jdField_a_of_type_Float = 75.0F;
          arrayOfhfi[5].b = ((int)(2.0F * f + 0.5F));
          arrayOfhfi[5].jdField_a_of_type_Int = ((int)(f * 15.0F + 0.5F));
        }
        paramInt = i;
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat1, float paramFloat2)
  {
    float f = paramFloat2;
    if (paramFloat2 < 1.5F) {
      f = 1.5F;
    }
    int j = Math.max(paramBitmap1.getWidth(), paramBitmap1.getHeight());
    int i = Math.max(paramBitmap2.getWidth(), paramBitmap2.getHeight());
    j = (int)(Math.max(j, i) * f);
    Bitmap localBitmap = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setDither(true);
    paramFloat2 = j / i;
    Object localObject = new Matrix();
    if (paramFloat1 != 0.0F) {
      ((Matrix)localObject).setRotate(paramFloat1, paramBitmap2.getWidth() / 2.0F, paramBitmap2.getHeight() / 2.0F);
    }
    ((Matrix)localObject).postScale(paramFloat2, paramFloat2);
    localCanvas.drawBitmap(paramBitmap2, (Matrix)localObject, localPaint);
    paramBitmap2 = new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
    localObject = new RectF(0.0F, 0.0F, j, j);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap1, paramBitmap2, (RectF)localObject, localPaint);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.PuzzleAvatarUtil
 * JD-Core Version:    0.7.0.1
 */