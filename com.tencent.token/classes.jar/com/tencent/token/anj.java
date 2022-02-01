package com.tencent.token;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;

public final class anj
  extends ane
{
  private final aog g;
  
  anj(asv paramasv, anh paramanh)
  {
    super(paramasv, paramanh);
    this.g = new aog(paramasv, this, new anc(paramanh.c, paramanh.a));
    paramasv = this.g;
    paramanh = Collections.emptyList();
    Collections.emptyList();
    paramasv.a(paramanh);
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
 * Qualified Name:     com.tencent.token.anj
 * JD-Core Version:    0.7.0.1
 */