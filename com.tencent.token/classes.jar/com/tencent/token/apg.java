package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;

public final class apg
  extends apb
{
  private final aqd g;
  
  apg(auv paramauv, ape paramape)
  {
    super(paramauv, paramape);
    this.g = new aqd(paramauv, this, new aoz(paramape.c, paramape.a));
    paramauv = this.g;
    paramape = Collections.emptyList();
    Collections.emptyList();
    paramauv.a(paramape);
  }
  
  public final void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    this.g.a(paramRectF, this.a);
  }
  
  public final void a(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.g.a(paramString1, paramString2, paramColorFilter);
  }
  
  final void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.g.a(paramCanvas, paramMatrix, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apg
 * JD-Core Version:    0.7.0.1
 */