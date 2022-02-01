package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;

public final class ank
  extends anf
{
  private final aoh g;
  
  ank(asw paramasw, ani paramani)
  {
    super(paramasw, paramani);
    this.g = new aoh(paramasw, this, new and(paramani.c, paramani.a));
    paramasw = this.g;
    paramani = Collections.emptyList();
    Collections.emptyList();
    paramasw.a(paramani);
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
 * Qualified Name:     com.tencent.token.ank
 * JD-Core Version:    0.7.0.1
 */