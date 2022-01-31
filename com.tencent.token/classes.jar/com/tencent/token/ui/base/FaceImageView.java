package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.token.global.e;

public class FaceImageView
  extends View
{
  private static int n = 100;
  Bitmap a;
  Bitmap b;
  Bitmap c;
  Bitmap d;
  Bitmap e;
  Bitmap f;
  Bitmap g;
  Paint h = new Paint();
  private float i;
  private int j;
  private int k;
  private int l;
  private Rect m;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private RectF t;
  private long u;
  private Context v;
  private boolean w = false;
  
  public FaceImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setColor(-1);
    this.h.setTextSize(18.0F * this.i);
    this.h.setTextAlign(Paint.Align.CENTER);
    this.v = paramContext;
    paramAttributeSet = new BitmapFactory.Options();
    paramAttributeSet.inSampleSize = 2;
    this.a = BitmapFactory.decodeResource(paramContext.getResources(), 2130837605, paramAttributeSet);
    this.b = BitmapFactory.decodeResource(paramContext.getResources(), 2130837612);
    this.i = paramContext.getResources().getDisplayMetrics().density;
    paramAttributeSet = paramContext.getResources().getDisplayMetrics();
    this.j = paramAttributeSet.heightPixels;
    this.k = paramAttributeSet.widthPixels;
    e.c("msg.arg1 screenWidth=" + this.j + ",screenHeight=" + this.k);
    this.q = (140.0F * this.i);
    this.r = (320.0F * this.i);
    this.c = BitmapFactory.decodeResource(paramContext.getResources(), 2130837616);
    this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2130837632);
    this.g = BitmapFactory.decodeResource(paramContext.getResources(), 2130837634);
    this.e = BitmapFactory.decodeResource(paramContext.getResources(), 2130837633);
    this.f = BitmapFactory.decodeResource(paramContext.getResources(), 2130837635);
    this.t = new RectF();
    e.c("FaceImageView scale=" + this.i);
    this.p = (this.r / n);
  }
  
  public final void a()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 2;
    this.a = BitmapFactory.decodeResource(this.v.getResources(), 2130837617, localOptions);
    this.b = BitmapFactory.decodeResource(this.v.getResources(), 2130837613);
    invalidate();
  }
  
  public final void a(int paramInt)
  {
    if (this.l == paramInt) {
      return;
    }
    this.l = paramInt;
    this.u = 0L;
    invalidate();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.q = (paramInt2 * 420 / 1920);
    this.r = (paramInt2 * 930 / 1920);
    e.a("msg.arg1 set size beginY=" + this.q + ", width=" + paramInt1 + ", height=" + paramInt2);
    if (paramInt2 != this.k) {}
    for (this.w = true;; this.w = false)
    {
      this.j = paramInt1;
      this.k = paramInt2;
      this.p = (this.r / n);
      if ((this.m == null) || (this.w))
      {
        e.c("msg.arg1 width=" + this.j + ", height=" + this.k);
        this.m = new Rect(0, 0, this.j, this.k);
      }
      return;
    }
  }
  
  public final int b()
  {
    return this.l;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.m == null) {
      return;
    }
    paramCanvas.drawBitmap(this.a, null, this.m, this.h);
    float f1;
    if (this.l == 0)
    {
      paramCanvas.drawBitmap(this.c, (this.j - this.c.getWidth()) / 2, this.k - this.i * 130.0F, this.h);
      f1 = this.o % n * this.p + this.q;
      if (f1 - this.b.getHeight() <= 0.0F)
      {
        f1 = this.q;
        paramCanvas.drawBitmap(this.b, 0.0F, f1, this.h);
        this.o += 1.0F;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      f1 -= this.b.getHeight();
      break;
      if (this.l == 1)
      {
        paramCanvas.drawBitmap(this.d, (this.j - this.d.getWidth()) / 2, this.k - this.i * 130.0F, this.h);
      }
      else if (this.l == 2)
      {
        if (this.u == 0L) {
          this.u = SystemClock.elapsedRealtime();
        }
        if (SystemClock.elapsedRealtime() - this.u > 10000L)
        {
          paramCanvas.drawBitmap(this.g, (this.j - this.g.getWidth()) / 2, this.k - this.i * 130.0F, this.h);
        }
        else
        {
          this.t.set((this.j - this.e.getWidth()) / 2, this.k - this.i * 130.0F, (this.j - this.e.getWidth()) / 2 + this.e.getWidth() - 15.0F * this.i + this.s / 20.0F % 3.0F * 6.0F * this.i, this.k - this.i * 130.0F + this.e.getHeight());
          paramCanvas.save();
          paramCanvas.clipRect(this.t);
          paramCanvas.drawBitmap(this.e, (this.j - this.e.getWidth()) / 2, this.k - this.i * 130.0F, this.h);
          paramCanvas.restore();
          this.s += 1.0F;
        }
      }
      else if (this.l == 3)
      {
        paramCanvas.drawBitmap(this.f, (this.j - this.f.getWidth()) / 2, this.k - this.i * 130.0F, this.h);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FaceImageView
 * JD-Core Version:    0.7.0.1
 */