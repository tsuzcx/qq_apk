package com.tencent.token.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.token.utils.w;

public class bi
  extends Drawable
{
  private static int g = 50;
  private Paint a = new Paint();
  private Bitmap b;
  private Bitmap c;
  private Bitmap d;
  private int e;
  private int f;
  private int h;
  private Rect i;
  private Rect j;
  private Rect k;
  private Rect l;
  private int m;
  private int n;
  private int o;
  private PaintFlagsDrawFilter p;
  private boolean q = false;
  
  public bi(Context paramContext, boolean paramBoolean)
  {
    this.q = paramBoolean;
    if (paramBoolean)
    {
      this.b = BitmapFactory.decodeResource(paramContext.getResources(), 2130837890);
      this.c = BitmapFactory.decodeResource(paramContext.getResources(), 2130837881);
      this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2130837793);
    }
    for (;;)
    {
      this.p = new PaintFlagsDrawFilter(0, 3);
      return;
      this.b = BitmapFactory.decodeResource(paramContext.getResources(), 2130837884);
      this.c = BitmapFactory.decodeResource(paramContext.getResources(), 2130837880);
      this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2130837792);
      this.m = w.a(paramContext, 0.0F);
      this.n = w.a(paramContext, 4.0F);
      this.o = w.a(paramContext, 30.0F);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        i1 = this.h % g * this.e;
        if (this.h % g == g - 1) {
          i1 = this.l.height();
        }
        this.a.setAntiAlias(true);
        paramCanvas.setDrawFilter(this.p);
        paramCanvas.drawBitmap(this.c, null, this.l, this.a);
        paramCanvas.save();
        this.j.set(0, 0, this.k.width(), this.l.top + i1);
        paramCanvas.clipRect(this.j);
        this.a.setAlpha(255);
        paramCanvas.drawBitmap(this.b, null, this.l, this.a);
        if (i1 - this.d.getHeight() > 0) {
          continue;
        }
        if (this.q) {
          continue;
        }
        this.i.set(this.l.left, i2 + this.l.top, this.l.right, i1 + this.l.top + this.n);
        if (this.h % g <= g / 2) {
          continue;
        }
        i1 = this.h;
        i2 = g;
        int i3 = this.f;
        this.a.setAlpha(255 - (i1 % i2 * i3 & 0xFF));
        paramCanvas.drawBitmap(this.d, null, this.i, this.a);
        paramCanvas.restore();
        this.h += 1;
      }
      catch (Exception paramCanvas)
      {
        int i1;
        continue;
      }
      invalidateSelf();
      return;
      i2 = i1 - this.d.getHeight() + this.n;
      continue;
      this.i.set(this.l.left, i2 + this.l.top, this.l.right, i1 + this.l.top + this.n);
      continue;
      this.a.setAlpha(255);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = new Rect(0, 0, this.k.width(), this.d.getHeight());
    this.j = new Rect(0, 0, this.k.width(), this.k.height());
    paramInt1 = this.k.width() - this.m;
    paramInt2 = this.k.height() - this.m;
    this.l = new Rect((this.k.width() - paramInt1) / 2, (this.k.height() - paramInt2) / 2, paramInt1 + (this.k.width() - paramInt1) / 2, paramInt2 + (this.k.height() - paramInt2) / 2);
    this.e = (this.l.height() / g);
    this.f = (255 / (g / 2));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.bi
 * JD-Core Version:    0.7.0.1
 */