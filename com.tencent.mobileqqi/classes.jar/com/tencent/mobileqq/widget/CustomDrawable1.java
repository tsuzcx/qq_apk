package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

public class CustomDrawable1
  extends AnimationDrawable
{
  private static final int e = 5;
  private int jdField_a_of_type_Int = 7;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private int b = 7;
  private int c = 5;
  private int d = 5;
  
  public CustomDrawable1(Context paramContext)
  {
    setOneShot(false);
    setVisible(true, true);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * f));
    this.b = ((int)(this.b * f));
    this.c = ((int)(this.c * f));
    this.d = ((int)(f * this.d));
  }
  
  private float a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return 0.9F;
    }
    if (paramInt1 > 1) {
      return a(paramInt1 - 1, paramInt2) + 0.2F;
    }
    return 0.3F;
  }
  
  private Rect a(int paramInt1, int paramInt2)
  {
    int k = 0;
    int i;
    int j;
    label24:
    label49:
    Rect localRect;
    if (paramInt1 == paramInt2)
    {
      i = this.jdField_a_of_type_Int;
      if (paramInt1 != paramInt2) {
        break label115;
      }
      j = this.b;
      if (paramInt1 <= 1) {
        break label124;
      }
      this.jdField_a_of_type_AndroidGraphicsRect.left = (a(paramInt1 - 1, paramInt2).right + 5);
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      if (paramInt1 != paramInt2) {
        break label135;
      }
    }
    label135:
    for (paramInt1 = k;; paramInt1 = (this.b - this.d) / 2)
    {
      localRect.top = paramInt1;
      this.jdField_a_of_type_AndroidGraphicsRect.right = (i + this.jdField_a_of_type_AndroidGraphicsRect.left);
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (j + this.jdField_a_of_type_AndroidGraphicsRect.top);
      return this.jdField_a_of_type_AndroidGraphicsRect;
      i = this.c;
      break;
      label115:
      j = this.d;
      break label24;
      label124:
      this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
      break label49;
    }
  }
  
  private void a(int paramInt, Canvas paramCanvas, Paint paramPaint)
  {
    paramPaint.setColor(16777215);
    paramPaint.setAlpha((int)(a(1, paramInt) * 255.0F));
    paramCanvas.drawRect(a(1, paramInt), paramPaint);
    paramPaint.setAlpha((int)(a(2, paramInt) * 255.0F));
    paramCanvas.drawRect(a(2, paramInt), paramPaint);
    paramPaint.setAlpha((int)(a(3, paramInt) * 255.0F));
    paramCanvas.drawRect(a(3, paramInt), paramPaint);
    paramPaint.setAlpha((int)(a(4, paramInt) * 255.0F));
    paramCanvas.drawRect(a(4, paramInt), paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (getNumberOfFrames() == 0)
    {
      Paint localPaint = new Paint();
      int i = 1;
      while (i <= 4)
      {
        Bitmap localBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        a(i, new Canvas(localBitmap), localPaint);
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
        addFrame(new BitmapDrawable(localBitmap), 200);
        i += 1;
      }
    }
    super.draw(paramCanvas);
    start();
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int + this.c * 3 + 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomDrawable1
 * JD-Core Version:    0.7.0.1
 */