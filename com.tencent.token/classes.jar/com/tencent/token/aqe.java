package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;

public final class aqe
  extends apz
{
  private final arb g;
  
  aqe(avt paramavt, aqc paramaqc)
  {
    super(paramavt, paramaqc);
    this.g = new arb(paramavt, this, new apx(paramaqc.c, paramaqc.a));
    paramavt = this.g;
    paramaqc = Collections.emptyList();
    Collections.emptyList();
    paramavt.a(paramaqc);
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
 * Qualified Name:     com.tencent.token.aqe
 * JD-Core Version:    0.7.0.1
 */