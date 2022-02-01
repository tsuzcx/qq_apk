package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

public class CustomDrawable1
  extends AnimationDrawable
{
  private int eft;
  private int efu;
  private int efv;
  private int efw;
  private Rect r;
  
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
      i = this.eft;
      if (paramInt1 != paramInt2) {
        break label115;
      }
      j = this.efu;
      if (paramInt1 <= 1) {
        break label124;
      }
      this.r.left = (a(paramInt1 - 1, paramInt2).right + 5);
      localRect = this.r;
      if (paramInt1 != paramInt2) {
        break label135;
      }
    }
    label135:
    for (paramInt1 = k;; paramInt1 = (this.efu - this.efw) / 2)
    {
      localRect.top = paramInt1;
      this.r.right = (i + this.r.left);
      this.r.bottom = (j + this.r.top);
      return this.r;
      i = this.efv;
      break;
      label115:
      j = this.efw;
      break label24;
      label124:
      this.r.left = 0;
      break label49;
    }
  }
  
  private void a(int paramInt, Canvas paramCanvas, Paint paramPaint)
  {
    paramPaint.setColor(16777215);
    paramPaint.setAlpha((int)(i(1, paramInt) * 255.0F));
    paramCanvas.drawRect(a(1, paramInt), paramPaint);
    paramPaint.setAlpha((int)(i(2, paramInt) * 255.0F));
    paramCanvas.drawRect(a(2, paramInt), paramPaint);
    paramPaint.setAlpha((int)(i(3, paramInt) * 255.0F));
    paramCanvas.drawRect(a(3, paramInt), paramPaint);
    paramPaint.setAlpha((int)(i(4, paramInt) * 255.0F));
    paramCanvas.drawRect(a(4, paramInt), paramPaint);
  }
  
  private float i(int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return 0.9F;
    }
    if (paramInt1 > 1) {
      return i(paramInt1 - 1, paramInt2) + 0.2F;
    }
    return 0.3F;
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
    return this.efu;
  }
  
  public int getIntrinsicWidth()
  {
    return this.eft + this.efv * 3 + 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomDrawable1
 * JD-Core Version:    0.7.0.1
 */