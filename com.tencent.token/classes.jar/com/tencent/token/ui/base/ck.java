package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.token.ui.IndexActivity;

public final class ck
  extends Drawable
{
  private Paint a = new Paint();
  private int[] b;
  private int[] c;
  private int d;
  private int[] e = new int[5];
  private int f;
  private int g;
  private int h;
  private Rect i;
  private String[] j;
  
  public ck(Context paramContext, int[] paramArrayOfInt, String[] paramArrayOfString, int paramInt)
  {
    this.b = paramArrayOfInt;
    this.d = paramInt;
    paramInt = 2131165284;
    int k = 0;
    while (k < this.e.length)
    {
      this.e[k] = paramContext.getResources().getColor(paramInt);
      k += 1;
      paramInt += 1;
    }
    this.f = paramContext.getResources().getColor(2131165289);
    this.g = paramContext.getResources().getColor(2131165205);
    this.h = paramContext.getResources().getColor(2131165184);
    if (paramArrayOfInt != null)
    {
      this.b = new int[paramArrayOfInt.length];
      this.c = new int[paramArrayOfInt.length];
      paramInt = 0;
      while (paramInt < this.b.length)
      {
        this.b[paramInt] = paramArrayOfInt[paramInt];
        paramInt += 1;
      }
      a();
      if (paramArrayOfInt.length == 3)
      {
        this.e[1] = paramContext.getResources().getColor(2131165286);
        this.e[2] = paramContext.getResources().getColor(2131165288);
      }
      if (paramArrayOfInt.length == 1) {
        this.e[0] = paramContext.getResources().getColor(2131165286);
      }
      if (paramArrayOfInt.length == 2)
      {
        this.e[0] = paramContext.getResources().getColor(2131165286);
        this.e[1] = paramContext.getResources().getColor(2131165288);
      }
    }
    if (paramArrayOfString != null)
    {
      this.j = new String[paramArrayOfString.length];
      paramInt = m;
      while (paramInt < this.j.length)
      {
        this.j[paramInt] = paramArrayOfString[paramInt];
        paramInt += 1;
      }
    }
  }
  
  private void a()
  {
    int k = 0;
    int m = 0;
    while (k < this.c.length - 1)
    {
      this.c[k] = (this.b[k] * 36 / 10 - 2);
      if (this.c[k] < 0) {
        this.c[k] = 2;
      }
      m += this.c[k] + 2;
      k += 1;
    }
    this.c[(this.c.length - 1)] = (360 - m - 2);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((this.b == null) || (this.j == null) || (this.b.length > 5) || (this.b.length != this.j.length)) {
      return;
    }
    float f2 = IndexActivity.S_DENSITY / 3.0F;
    int n = this.i.width() / 2;
    int i1 = this.i.height() / 2 - (int)(70.0F * f2);
    int k = (int)(240.0F * f2);
    RectF localRectF = new RectF(n - k, i1 - k, n + k, k + i1);
    this.a.reset();
    this.a.setStyle(Paint.Style.FILL);
    this.a.setTextAlign(Paint.Align.CENTER);
    this.a.setTextSize(45.0F * f2);
    this.a.setAntiAlias(true);
    Paint.FontMetrics localFontMetrics = this.a.getFontMetrics();
    int i2 = (int)((localFontMetrics.descent - localFontMetrics.ascent) / 2.0F - localFontMetrics.descent);
    int m = 0;
    k = 270;
    int i4;
    int i3;
    if (m < this.c.length)
    {
      this.a.setColor(this.e[m]);
      if (this.c[m] + k > 360)
      {
        paramCanvas.drawArc(localRectF, k, 360 - k, true, this.a);
        paramCanvas.drawArc(localRectF, 0.0F, this.c[m] + k - 360, true, this.a);
      }
      for (;;)
      {
        i4 = (int)(280.0F * f2);
        double d2 = Math.toRadians(360 - (this.c[m] / 2 + k) % 360);
        double d1 = Math.sin(d2);
        d2 = Math.cos(d2);
        double d3 = n;
        i3 = (int)(d2 * i4 + d3);
        i4 = (int)(i1 - d1 * i4);
        paramCanvas.drawText("" + this.b[m] + "%", i3, i4 + i2, this.a);
        i3 = this.c[m];
        m += 1;
        k = (i3 + k + 2) % 360;
        break;
        paramCanvas.drawArc(localRectF, k, this.c[m], true, this.a);
      }
    }
    k = (int)(170.0F * f2);
    localRectF = new RectF(n - k, i1 - k, n + k, k + i1);
    this.a.setColor(this.h);
    this.a.setAntiAlias(true);
    paramCanvas.drawArc(localRectF, 0.0F, 360.0F, true, this.a);
    this.a.reset();
    this.a.setAntiAlias(true);
    this.a.setTextSize(35.0F * f2);
    this.a.setTextAlign(Paint.Align.LEFT);
    float f1 = 0.0F;
    k = 0;
    while (k < this.j.length)
    {
      f1 += this.a.measureText(this.j[k]);
      k += 1;
    }
    f1 = this.j.length * 36 * f2 + (this.j.length - 1) * 40 * f2 + f1;
    if (f1 >= this.i.width() * 4 / 5)
    {
      f1 = 0.0F;
      k = 0;
      while (k < this.j.length - 1)
      {
        f1 += this.a.measureText(this.j[k]);
        k += 1;
      }
      float f3 = (this.j.length - 1) * 36;
      float f4 = (this.j.length - 2) * 40;
      m = (int)((this.i.width() - (f3 * f2 + f4 * f2 + f1)) / 2.0F);
      i2 = (int)(this.a.getFontMetrics().descent - this.a.getFontMetrics().ascent);
      k = 0;
      while (k < this.j.length - 1)
      {
        this.a.setColor(this.e[k]);
        i3 = (int)(i1 + 332.0F * f2);
        paramCanvas.drawRect(new RectF(m, i3, m + 20.0F * f2, i3 + 20.0F * f2), this.a);
        m = (int)(m + 36.0F * f2);
        i4 = i2 / 2;
        this.a.setColor(this.g);
        paramCanvas.drawText(this.j[k], m, i3 + i4, this.a);
        m = (int)(m + (this.a.measureText(this.j[k]) + 40.0F * f2));
        k += 1;
      }
      f1 = this.a.measureText(this.j[(this.j.length - 1)]);
      m = (int)((this.i.width() - (f1 + 36.0F * f2)) / 2.0F);
      k = (int)(i1 + 332.0F * f2 + i2 + this.a.getFontMetrics().descent);
      this.a.setColor(this.e[(this.j.length - 1)]);
      paramCanvas.drawRect(new RectF(m, k, m + 20.0F * f2, k + 20.0F * f2), this.a);
      m = (int)(m + 36.0F * f2);
      i2 /= 2;
      this.a.setColor(this.g);
      paramCanvas.drawText(this.j[(this.j.length - 1)], m, k + i2, this.a);
    }
    for (;;)
    {
      this.a.reset();
      this.a.setAntiAlias(true);
      this.a.setTextSize(35.0F * f2);
      this.a.setColor(this.f);
      this.a.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText("近三个月共消费", n, i1 - this.a.getFontMetrics().descent, this.a);
      this.a.setTextSize(90.0F * f2);
      this.a.setColor(this.g);
      this.a.setTextAlign(Paint.Align.LEFT);
      k = (int)this.a.measureText("" + this.d);
      f1 = this.a.getFontMetrics().ascent;
      paramCanvas.drawText("" + this.d, n - k * 3 / 4, i1 - f1, this.a);
      this.a.setTextSize(50.0F * f2);
      paramCanvas.drawText("Q币", k / 4 + n, i1 - f1 * 5.0F / 6.0F, this.a);
      return;
      m = (int)((this.i.width() - f1) / 2.0F);
      i2 = (int)(this.a.getFontMetrics().descent - this.a.getFontMetrics().ascent);
      k = 0;
      while (k < this.j.length)
      {
        this.a.setColor(this.e[k]);
        i3 = (int)(i1 + 332.0F * f2);
        paramCanvas.drawRect(new RectF(m, i3, m + 20.0F * f2, i3 + 20.0F * f2), this.a);
        m = (int)(m + 36.0F * f2);
        i4 = i2 / 2;
        this.a.setColor(this.g);
        paramCanvas.drawText(this.j[k], m, i3 + i4, this.a);
        m = (int)(m + (this.a.measureText(this.j[k]) + 40.0F * f2));
        k += 1;
      }
    }
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ck
 * JD-Core Version:    0.7.0.1
 */