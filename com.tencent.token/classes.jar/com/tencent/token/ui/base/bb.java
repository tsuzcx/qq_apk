package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public final class bb
  extends Drawable
{
  private Paint a = new Paint();
  private int b;
  private float c = 42.0F;
  private float d = 123.0F;
  private float e = 20.0F;
  private float f;
  private float g;
  private float h;
  private RectF i = new RectF();
  private RectF j = new RectF();
  private float k;
  private int l;
  private int m;
  private int n;
  private String[] o;
  private int[] p;
  
  public bb(Context paramContext, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfString == null) || (paramArrayOfInt.length != paramArrayOfString.length)) {
      return;
    }
    this.o = paramArrayOfString;
    this.p = paramArrayOfInt;
    this.b = this.p.length;
    if (this.b > 5) {
      throw new RuntimeException();
    }
    paramArrayOfString = this.p;
    int i4 = paramArrayOfString.length;
    int i2 = 0;
    int i1 = 0;
    if (i2 < i4)
    {
      int i3 = paramArrayOfString[i2];
      if (i3 <= i1) {
        break label335;
      }
      i1 = i3;
    }
    label335:
    for (;;)
    {
      i2 += 1;
      break;
      this.l = paramContext.getResources().getColor(2131165282);
      this.m = paramContext.getResources().getColor(2131165293);
      this.n = paramContext.getResources().getColor(2131165192);
      this.k = paramContext.getResources().getDisplayMetrics().density;
      this.h = (this.d * 0.6F / i1 * this.k);
      this.f = ((this.c * this.b + this.e * (this.b - 1)) * this.k);
      this.g = ((this.d + 8.0F + 12.0F) * this.k);
      this.c *= this.k;
      this.d *= this.k;
      this.e *= this.k;
      this.j.set(0.0F, 0.0F, this.f, this.g);
      return;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i1 = 0;
    if (i1 < this.b)
    {
      this.a.reset();
      this.a.setColor(this.l);
      this.a.setAntiAlias(true);
      this.j.set(this.i.left + this.c * i1 + this.e * i1, this.i.top, this.i.left + this.c + this.c * i1 + this.e * i1, this.i.top + this.d);
      paramCanvas.drawRoundRect(this.j, 10.0F, 10.0F, this.a);
      this.a.setColor(this.m);
      this.j.set(this.i.left + this.c * i1 + this.e * i1, this.i.top + (this.d - this.h * this.p[i1]), this.i.left + this.c + this.c * i1 + this.e * i1, this.i.top + this.d);
      paramCanvas.drawRoundRect(this.j, 10.0F, 10.0F, this.a);
      this.a.setTextSize(16.0F * this.k);
      float f1 = this.a.measureText(String.valueOf(this.p[i1]));
      int i2 = this.p[i1];
      float f2 = this.i.left;
      float f3 = this.c;
      float f4 = i1;
      float f5 = this.e;
      float f6 = i1;
      float f7 = (this.c - f1) / 2.0F;
      float f8 = this.i.top;
      paramCanvas.drawText(String.valueOf(i2), f2 + f3 * f4 + f5 * f6 + f7, this.d - this.h * this.p[i1] - f1 - 10.0F + f8, this.a);
      this.a.setTextSize(11.0F * this.k);
      f1 = this.a.measureText(this.o[i1]);
      this.a.setColor(this.n);
      String str;
      if ((this.o[i1] != null) && (this.o[i1].length() > 4))
      {
        str = this.o[i1].substring(0, 4);
        f1 = this.a.measureText(str);
        f2 = this.i.left;
        f3 = this.c;
        f4 = i1;
        f5 = this.e;
        f6 = i1;
        paramCanvas.drawText(str, (this.c - f1) / 2.0F + (f2 + f3 * f4 + f5 * f6), this.i.bottom, this.a);
        str = this.o[i1].substring(4, this.o[i1].length());
        f1 = this.a.measureText(str);
        f2 = this.i.left;
        f3 = this.c;
        f4 = i1;
        f5 = this.e;
        f6 = i1;
        paramCanvas.drawText(str, (this.c - f1) / 2.0F + (f2 + f3 * f4 + f5 * f6), this.i.bottom + this.a.descent() - this.a.ascent(), this.a);
      }
      for (;;)
      {
        i1 += 1;
        break;
        str = this.o[i1];
        f2 = this.i.left;
        f3 = this.c;
        f4 = i1;
        f5 = this.e;
        f6 = i1;
        paramCanvas.drawText(str, (this.c - f1) / 2.0F + (f2 + f3 * f4 + f5 * f6), this.i.bottom + 8.0F, this.a);
      }
    }
    paramCanvas.restore();
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i.set((getBounds().width() - this.f) / 2.0F, (getBounds().height() - this.g) / 2.0F, (getBounds().width() - this.f) / 2.0F + this.f, (getBounds().height() - this.g) / 2.0F + this.g);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bb
 * JD-Core Version:    0.7.0.1
 */