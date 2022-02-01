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
import com.tencent.token.xj;

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
    this.h.setTextSize(this.i * 18.0F);
    this.h.setTextAlign(Paint.Align.CENTER);
    this.v = paramContext;
    paramAttributeSet = new BitmapFactory.Options();
    paramAttributeSet.inSampleSize = 2;
    this.a = BitmapFactory.decodeResource(paramContext.getResources(), 2131099838, paramAttributeSet);
    this.b = BitmapFactory.decodeResource(paramContext.getResources(), 2131099844);
    this.i = paramContext.getResources().getDisplayMetrics().density;
    paramAttributeSet = paramContext.getResources().getDisplayMetrics();
    this.j = paramAttributeSet.heightPixels;
    this.k = paramAttributeSet.widthPixels;
    paramAttributeSet = new StringBuilder("msg.arg1 screenWidth=");
    paramAttributeSet.append(this.j);
    paramAttributeSet.append(",screenHeight=");
    paramAttributeSet.append(this.k);
    xj.c(paramAttributeSet.toString());
    float f1 = this.i;
    this.q = (140.0F * f1);
    this.r = (f1 * 320.0F);
    this.c = BitmapFactory.decodeResource(paramContext.getResources(), 2131099850);
    this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2131099864);
    this.g = BitmapFactory.decodeResource(paramContext.getResources(), 2131099866);
    this.e = BitmapFactory.decodeResource(paramContext.getResources(), 2131099865);
    this.f = BitmapFactory.decodeResource(paramContext.getResources(), 2131099867);
    this.t = new RectF();
    paramContext = new StringBuilder("FaceImageView scale=");
    paramContext.append(this.i);
    xj.c(paramContext.toString());
    this.p = (this.r / n);
  }
  
  public int getStatus()
  {
    return this.l;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.m;
    if (localObject == null) {
      return;
    }
    paramCanvas.drawBitmap(this.a, null, (Rect)localObject, this.h);
    int i1 = this.l;
    float f1;
    if (i1 == 0)
    {
      localObject = this.c;
      paramCanvas.drawBitmap((Bitmap)localObject, (this.j - ((Bitmap)localObject).getWidth()) / 2, this.k - this.i * 130.0F, this.h);
      f1 = this.o % n * this.p + this.q;
      if (f1 - this.b.getHeight() <= 0.0F) {
        f1 = this.q;
      } else {
        f1 -= this.b.getHeight();
      }
      paramCanvas.drawBitmap(this.b, 0.0F, f1, this.h);
      this.o += 1.0F;
    }
    else if (i1 == 1)
    {
      localObject = this.d;
      paramCanvas.drawBitmap((Bitmap)localObject, (this.j - ((Bitmap)localObject).getWidth()) / 2, this.k - this.i * 130.0F, this.h);
    }
    else if (i1 == 2)
    {
      if (this.u == 0L) {
        this.u = SystemClock.elapsedRealtime();
      }
      if (SystemClock.elapsedRealtime() - this.u > 10000L)
      {
        localObject = this.g;
        paramCanvas.drawBitmap((Bitmap)localObject, (this.j - ((Bitmap)localObject).getWidth()) / 2, this.k - this.i * 130.0F, this.h);
      }
      else
      {
        localObject = this.t;
        f1 = (this.j - this.e.getWidth()) / 2;
        float f2 = this.k;
        float f3 = this.i;
        float f4 = (this.j - this.e.getWidth()) / 2 + this.e.getWidth();
        float f5 = this.i;
        ((RectF)localObject).set(f1, f2 - f3 * 130.0F, f4 - 15.0F * f5 + this.s / 20.0F % 3.0F * 6.0F * f5, this.k - f5 * 130.0F + this.e.getHeight());
        paramCanvas.save();
        paramCanvas.clipRect(this.t);
        localObject = this.e;
        paramCanvas.drawBitmap((Bitmap)localObject, (this.j - ((Bitmap)localObject).getWidth()) / 2, this.k - this.i * 130.0F, this.h);
        paramCanvas.restore();
        this.s += 1.0F;
      }
    }
    else if (i1 == 3)
    {
      localObject = this.f;
      paramCanvas.drawBitmap((Bitmap)localObject, (this.j - ((Bitmap)localObject).getWidth()) / 2, this.k - this.i * 130.0F, this.h);
    }
    invalidate();
  }
  
  public void setStatus(int paramInt)
  {
    if (this.l == paramInt) {
      return;
    }
    this.l = paramInt;
    this.u = 0L;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FaceImageView
 * JD-Core Version:    0.7.0.1
 */