package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public final class ce
  extends Drawable
{
  private int[] a;
  private int[] b;
  private Bitmap[] c = new Bitmap[3];
  private String[] d = new String[3];
  private Bitmap e;
  private float f;
  private float g = 36.0F;
  private float h = 22.0F;
  private Paint i = new Paint();
  private int j;
  private int k;
  private int l;
  private RectF m = new RectF();
  private float n;
  private float o;
  
  public ce(Context paramContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.a = paramArrayOfInt1;
    this.b = paramArrayOfInt2;
    this.c[0] = BitmapFactory.decodeResource(paramContext.getResources(), 2130837684);
    this.c[1] = BitmapFactory.decodeResource(paramContext.getResources(), 2130837683);
    this.c[2] = BitmapFactory.decodeResource(paramContext.getResources(), 2130837694);
    this.e = BitmapFactory.decodeResource(paramContext.getResources(), 2130837685);
    this.d[0] = paramContext.getResources().getString(2131362464);
    this.d[1] = paramContext.getResources().getString(2131362465);
    this.d[2] = paramContext.getResources().getString(2131362466);
    this.f = paramContext.getResources().getDisplayMetrics().density;
    this.j = paramContext.getResources().getColor(2131165194);
    this.l = paramContext.getResources().getColor(2131165192);
    this.k = paramContext.getResources().getColor(2131165294);
    this.g *= this.f;
    this.h *= this.f;
    this.n = (this.g * 3.0F * 2.0F + this.h * 2.0F);
    this.o = (this.g * 2.0F + 10.0F * this.f + 13.0F * this.f + this.e.getHeight() - 20.0F * this.f);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int i1 = 0;
    while (i1 < this.a.length)
    {
      this.i.setColor(this.k);
      this.i.setStyle(Paint.Style.STROKE);
      this.i.setStrokeWidth(1.5F * this.f);
      this.i.setAntiAlias(true);
      paramCanvas.drawCircle(this.m.left + this.g + this.g * 2.0F * i1 + this.h * i1, this.m.centerY(), this.g, this.i);
      paramCanvas.drawBitmap(this.c[(this.a[i1] - 1)], this.m.left + this.g - this.c[(this.a[i1] - 1)].getWidth() / 2 + this.g * 2.0F * i1 + this.h * i1, this.m.centerY() - this.c[(this.a[i1] - 1)].getHeight() / 2, null);
      paramCanvas.drawBitmap(this.e, this.m.left + this.g - this.e.getWidth() / 2 + this.g * 2.0F * i1 + this.h * i1, this.m.centerY() - this.e.getHeight() - this.f * 20.0F, null);
      this.i.reset();
      this.i.setAntiAlias(true);
      this.i.setColor(this.j);
      this.i.setTextSize(this.f * 17.0F);
      this.i.setTypeface(Typeface.DEFAULT_BOLD);
      this.i.setTextAlign(Paint.Align.LEFT);
      float f1 = this.i.measureText(String.valueOf(this.b[i1]));
      float f2 = this.i.measureText("次");
      paramCanvas.drawText(String.valueOf(this.b[i1]), this.m.left + this.g - (f1 + f2) / 2.0F + this.g * 2.0F * i1 + this.h * i1, this.m.centerY() - this.e.getHeight() - this.f * 17.0F / 2.0F + 5.0F * this.f, this.i);
      this.i.reset();
      this.i.setAntiAlias(true);
      this.i.setColor(this.j);
      this.i.setTextSize(this.f * 13.0F);
      this.i.setTypeface(Typeface.DEFAULT_BOLD);
      this.i.setTextAlign(Paint.Align.LEFT);
      paramCanvas.drawText("次", f1 + (this.m.left + this.g - (f2 + f1) / 2.0F) + this.g * 2.0F * i1 + this.h * i1, this.m.centerY() - this.e.getHeight() - this.f * 13.0F / 2.0F + this.f * 2.0F, this.i);
      this.i.reset();
      this.i.setAntiAlias(true);
      this.i.setColor(this.l);
      this.i.setTextSize(this.f * 13.0F);
      this.i.setTextAlign(Paint.Align.LEFT);
      f1 = this.i.measureText(this.d[(this.a[i1] - 1)]);
      paramCanvas.drawText(this.d[(this.a[i1] - 1)], this.m.left + this.g - f1 / 2.0F + this.g * 2.0F * i1 + this.h * i1, this.m.centerY() + this.g + this.f * 20.0F, this.i);
      i1 += 1;
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
    this.m.set((getBounds().width() - this.n) / 2.0F, (getBounds().height() - this.o) / 2.0F, (getBounds().width() - this.n) / 2.0F + this.n, (getBounds().height() - this.o) / 2.0F + this.o);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ce
 * JD-Core Version:    0.7.0.1
 */