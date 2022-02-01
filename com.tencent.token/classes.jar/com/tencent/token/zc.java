package com.tencent.token;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public final class zc
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
  
  public zc(Context paramContext, boolean paramBoolean)
  {
    this.q = paramBoolean;
    if (paramBoolean)
    {
      this.b = BitmapFactory.decodeResource(paramContext.getResources(), 2131100040);
      this.c = BitmapFactory.decodeResource(paramContext.getResources(), 2131100031);
      this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2131099940);
    }
    else
    {
      this.b = BitmapFactory.decodeResource(paramContext.getResources(), 2131100034);
      this.c = BitmapFactory.decodeResource(paramContext.getResources(), 2131100030);
      this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2131099939);
      this.m = aao.a(paramContext, 0.0F);
      this.n = aao.a(paramContext, 4.0F);
      this.o = aao.a(paramContext, 30.0F);
    }
    this.p = new PaintFlagsDrawFilter(0, 3);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    try
    {
      int i1 = this.h % g * this.e;
      if (this.h % g == g - 1) {
        i1 = this.l.height();
      }
      this.a.setAntiAlias(true);
      paramCanvas.setDrawFilter(this.p);
      paramCanvas.drawBitmap(this.c, null, this.l, this.a);
      paramCanvas.save();
      Rect localRect = this.j;
      int i3 = this.k.width();
      int i4 = this.l.top;
      int i2 = 0;
      localRect.set(0, 0, i3, i4 + i1);
      paramCanvas.clipRect(this.j);
      this.a.setAlpha(255);
      paramCanvas.drawBitmap(this.b, null, this.l, this.a);
      if (i1 - this.d.getHeight() > 0) {
        i2 = i1 - this.d.getHeight() + this.n;
      }
      this.i.set(this.l.left, this.l.top + i2, this.l.right, this.l.top + i1 + this.n);
      if (this.h % g > g / 2)
      {
        i1 = this.h;
        i2 = g;
        i3 = this.f;
        this.a.setAlpha(255 - (i1 % i2 * i3 & 0xFF));
      }
      else
      {
        this.a.setAlpha(255);
      }
      paramCanvas.drawBitmap(this.d, null, this.i, this.a);
      paramCanvas.restore();
      this.h += 1;
    }
    catch (Exception paramCanvas)
    {
      label321:
      break label321;
    }
    invalidateSelf();
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = new Rect(0, 0, this.k.width(), this.d.getHeight());
    this.j = new Rect(0, 0, this.k.width(), this.k.height());
    paramInt1 = this.k.width() - this.m;
    paramInt2 = this.k.height() - this.m;
    this.l = new Rect((this.k.width() - paramInt1) / 2, (this.k.height() - paramInt2) / 2, (this.k.width() - paramInt1) / 2 + paramInt1, (this.k.height() - paramInt2) / 2 + paramInt2);
    paramInt1 = this.l.height();
    paramInt2 = g;
    this.e = (paramInt1 / paramInt2);
    this.f = (255 / (paramInt2 / 2));
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zc
 * JD-Core Version:    0.7.0.1
 */