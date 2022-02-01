package com.tencent.token;

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
import java.lang.reflect.Field;

public final class yq
  extends View
{
  public Bitmap a = null;
  public Bitmap b = null;
  PointF c = new PointF();
  ColorMatrixColorFilter d;
  Matrix e;
  float[] f = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  float g = (float)Math.hypot(this.l, this.m);
  Paint h;
  public Scroller i;
  public boolean j;
  public a k;
  private int l = 480;
  private int m = 800;
  private int n = 0;
  private int o = 0;
  private Paint p;
  private boolean q;
  private Rect r;
  private int s;
  private int t;
  private int u;
  
  public yq(Context paramContext, a parama, int paramInt1, int paramInt2)
  {
    super(paramContext);
    setViewRect(new Rect(0, 0, paramInt1, paramInt2));
    this.k = parama;
    this.n = this.l;
    this.o = this.m;
    paramContext = this.c;
    paramContext.x = (this.n - 0.09F);
    paramContext.y = (this.o - 0.09F);
    this.h = new Paint();
    this.h.setStyle(Paint.Style.FILL);
    paramContext = new ColorMatrix();
    paramContext.set(new float[] { 0.7F, 0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.7F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F, 0.7F, 0.0F, 90.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F });
    this.d = new ColorMatrixColorFilter(paramContext);
    this.e = new Matrix();
    this.i = new Scroller(getContext(), new AccelerateInterpolator());
    this.p = new Paint();
    this.p.setShadowLayer(15.0F, 0.0F, 0.0F, -1073741824);
    try
    {
      paramContext = Class.forName("com.android.internal.R$dimen");
      parama = paramContext.newInstance();
      paramInt1 = Integer.parseInt(paramContext.getField("status_bar_height").get(parama).toString());
      this.u = getResources().getDimensionPixelSize(paramInt1);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      this.u = ((int)getResources().getDimension(2131034200));
    }
  }
  
  public final void a()
  {
    this.n = this.l;
    this.o = this.m;
    PointF localPointF = this.c;
    localPointF.x = (this.n - 0.09F);
    localPointF.y = (this.o - 0.09F);
    this.q = false;
  }
  
  public final void a(Bitmap paramBitmap)
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((a)localObject).onNextPage(true);
    }
    localObject = this.a;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    this.a = paramBitmap;
    postInvalidate();
  }
  
  public final void b()
  {
    xa.b("PageCurlView Do Clean");
    Bitmap localBitmap = this.b;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.b = null;
    localBitmap = this.a;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.a = null;
  }
  
  public final void b(Bitmap paramBitmap)
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((a)localObject).onNextPage(false);
    }
    localObject = this.a;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    this.a = paramBitmap;
    postInvalidate();
  }
  
  public final void computeScroll()
  {
    super.computeScroll();
    Object localObject;
    if (this.i.computeScrollOffset())
    {
      float f1 = this.i.getCurrX();
      float f2 = this.i.getCurrY();
      localObject = this.c;
      ((PointF)localObject).x = f1;
      ((PointF)localObject).y = f2;
      postInvalidate();
      return;
    }
    if (this.q)
    {
      localObject = this.k;
      if (localObject != null) {
        ((a)localObject).onNextPage(this.j);
      }
      localObject = this.a;
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      this.a = this.b;
      this.b = null;
      a();
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    b();
    super.onDetachedFromWindow();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    if ((this.s == 0) || (this.t == 0))
    {
      this.s = ((this.r.width() - this.a.getWidth()) / 2);
      this.t = ((this.r.height() - this.u - this.a.getHeight()) / 2);
    }
    Bitmap localBitmap = this.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.a, this.s, this.t, null);
    }
    this.k.onDrawDots(paramCanvas, true);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setViewRect(Rect paramRect)
  {
    this.r = paramRect;
    this.l = paramRect.width();
    this.m = paramRect.height();
  }
  
  public static abstract interface a
  {
    public abstract void onDrawDots(Canvas paramCanvas, boolean paramBoolean);
    
    public abstract void onNextPage(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yq
 * JD-Core Version:    0.7.0.1
 */