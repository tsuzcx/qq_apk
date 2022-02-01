package com.tencent.token;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

final class apd
  extends apb
{
  private final Paint g = new Paint(3);
  private final Rect h = new Rect();
  private final Rect i = new Rect();
  private final float j;
  
  apd(auv paramauv, ape paramape, float paramFloat)
  {
    super(paramauv, paramape);
    this.j = paramFloat;
  }
  
  private Bitmap c()
  {
    String str = this.c.g;
    return this.b.a(str);
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    paramMatrix = c();
    if (paramMatrix != null)
    {
      paramRectF.set(paramRectF.left, paramRectF.top, Math.min(paramRectF.right, paramMatrix.getWidth()), Math.min(paramRectF.bottom, paramMatrix.getHeight()));
      this.a.mapRect(paramRectF);
    }
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.g.setColorFilter(paramColorFilter);
  }
  
  public final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    Bitmap localBitmap = c();
    if (localBitmap == null) {
      return;
    }
    this.g.setAlpha(paramInt);
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    this.h.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    this.i.set(0, 0, (int)(localBitmap.getWidth() * this.j), (int)(localBitmap.getHeight() * this.j));
    paramCanvas.drawBitmap(localBitmap, this.h, this.i, this.g);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apd
 * JD-Core Version:    0.7.0.1
 */