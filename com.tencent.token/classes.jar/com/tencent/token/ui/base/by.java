package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
import com.tencent.token.global.h;
import java.lang.reflect.Field;

public class by
  extends View
{
  Bitmap a = null;
  Bitmap b = null;
  PointF c = new PointF();
  ColorMatrixColorFilter d;
  Matrix e;
  float[] f = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  float g = (float)Math.hypot(this.k, this.l);
  Paint h;
  Scroller i;
  public bz j;
  private int k = 480;
  private int l = 800;
  private int m = 0;
  private int n = 0;
  private Paint o;
  private boolean p;
  private boolean q;
  private Rect r;
  private int s;
  private int t;
  private int u;
  
  public by(Context paramContext, bz parambz, int paramInt1, int paramInt2)
  {
    super(paramContext);
    setViewRect(new Rect(0, 0, paramInt1, paramInt2));
    this.j = parambz;
    this.m = this.k;
    this.n = this.l;
    this.c.x = (this.m - 0.09F);
    this.c.y = (this.n - 0.09F);
    this.h = new Paint();
    this.h.setStyle(Paint.Style.FILL);
    paramContext = new ColorMatrix();
    paramContext.set(new float[] { 0.7F, 0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.7F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F, 0.7F, 0.0F, 90.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F });
    this.d = new ColorMatrixColorFilter(paramContext);
    this.e = new Matrix();
    this.i = new Scroller(getContext(), new AccelerateInterpolator());
    this.o = new Paint();
    this.o.setShadowLayer(15.0F, 0.0F, 0.0F, -1073741824);
    try
    {
      paramContext = Class.forName("com.android.internal.R$dimen");
      parambz = paramContext.newInstance();
      paramInt1 = Integer.parseInt(paramContext.getField("status_bar_height").get(parambz).toString());
      this.u = getResources().getDimensionPixelSize(paramInt1);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      this.u = ((int)getResources().getDimension(2131296371));
    }
  }
  
  public void a()
  {
    this.m = this.k;
    this.n = this.l;
    this.c.x = (this.m - 0.09F);
    this.c.y = (this.n - 0.09F);
    this.p = false;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.j != null) {
      this.j.onNextPage(true);
    }
    if (this.a != null) {
      this.a.recycle();
    }
    this.a = paramBitmap;
    postInvalidate();
  }
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this.a = paramBitmap1;
    this.b = paramBitmap2;
  }
  
  public void b()
  {
    if (!this.i.isFinished())
    {
      this.i.abortAnimation();
      if (this.j != null) {
        this.j.onNextPage(this.q);
      }
      if (this.a != null) {
        this.a.recycle();
      }
      this.a = this.b;
      this.b = null;
      a();
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (this.j != null) {
      this.j.onNextPage(false);
    }
    if (this.a != null) {
      this.a.recycle();
    }
    this.a = paramBitmap;
    postInvalidate();
  }
  
  public void c()
  {
    h.b("PageCurlView Do Clean");
    if (this.b != null) {
      this.b.recycle();
    }
    this.b = null;
    if (this.a != null) {
      this.a.recycle();
    }
    this.a = null;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.i.computeScrollOffset())
    {
      f1 = this.i.getCurrX();
      f2 = this.i.getCurrY();
      this.c.x = f1;
      this.c.y = f2;
      postInvalidate();
    }
    while (!this.p)
    {
      float f1;
      float f2;
      return;
    }
    if (this.j != null) {
      this.j.onNextPage(this.q);
    }
    if (this.a != null) {
      this.a.recycle();
    }
    this.a = this.b;
    this.b = null;
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    c();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.s == 0) || (this.t == 0))
    {
      this.s = ((this.r.width() - this.a.getWidth()) / 2);
      this.t = ((this.r.height() - this.u - this.a.getHeight()) / 2);
    }
    if ((this.a != null) && (!this.a.isRecycled())) {
      paramCanvas.drawBitmap(this.a, this.s, this.t, null);
    }
    this.j.onDrawDots(paramCanvas, true);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setViewRect(Rect paramRect)
  {
    this.r = paramRect;
    this.k = paramRect.width();
    this.l = paramRect.height();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.by
 * JD-Core Version:    0.7.0.1
 */