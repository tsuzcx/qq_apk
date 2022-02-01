package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public final class anl
  extends anf
{
  private final RectF g = new RectF();
  private final Paint h = new Paint();
  private final ani i;
  
  anl(asw paramasw, ani paramani)
  {
    super(paramasw, paramani);
    this.i = paramani;
    this.h.setAlpha(0);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setColor(paramani.l);
  }
  
  private void a(Matrix paramMatrix)
  {
    this.g.set(0.0F, 0.0F, this.i.j, this.i.k);
    paramMatrix.mapRect(this.g);
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    a(this.a);
    paramRectF.set(this.g);
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.h.setColorFilter(paramColorFilter);
  }
  
  public final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    int j = Color.alpha(this.i.l);
    if (j == 0) {
      return;
    }
    paramInt = (int)(paramInt / 255.0F * (j / 255.0F * ((Integer)this.f.a.a()).intValue() / 100.0F) * 255.0F);
    a(paramMatrix);
    this.h.setAlpha(paramInt);
    if (paramInt > 0) {
      paramCanvas.drawRect(this.g, this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.anl
 * JD-Core Version:    0.7.0.1
 */