package com.tencent.token.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.token.cx;
import com.tencent.token.ui.IndexActivity;

public class CodeCircleView
  extends View
{
  private Paint a = new Paint();
  private Paint b;
  private Paint c;
  private int d;
  private int e;
  private float f = 82.0F * IndexActivity.S_DENSITY;
  private float g = 3.0F * IndexActivity.S_DENSITY;
  private float h = 4.0F * IndexActivity.S_DENSITY;
  private float i = 50.0F * IndexActivity.S_DENSITY;
  private int j = (int)(this.f * 2.0F * 1.1F);
  private int k = -14249741;
  private int l = -11773966;
  private int m = -1776412;
  private int n = -13421773;
  private int[] o = { this.k, this.l };
  private RectF p;
  private SweepGradient q;
  private Matrix r;
  private long s;
  private int t;
  private int u;
  private float v;
  private int w;
  private int x;
  private String y;
  
  public CodeCircleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CodeCircleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(this.g);
    this.c = new Paint();
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setAntiAlias(true);
    this.c.setStrokeWidth(this.h);
    this.b = new Paint();
    this.b.setStyle(Paint.Style.FILL);
    this.b.setAntiAlias(true);
    this.b.setColor(this.n);
    this.b.setTextSize(this.i);
    this.r = new Matrix();
  }
  
  private int a(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824) {
      return paramInt;
    }
    int i2 = this.j;
    if (i1 == -2147483648) {
      return Math.min(i2, paramInt);
    }
    return i2;
  }
  
  public int a(String paramString, Paint paramPaint)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.height();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.p, 270.0F, 360.0F, false, this.a);
    this.s = (System.currentTimeMillis() + cx.c().q());
    this.t = ((int)(this.s / 1000L) % 30);
    this.u = ((int)(this.s % 1000L));
    this.c.setColor(this.m);
    this.v = ((this.t * 1000 + this.u) * 360 / 30000);
    paramCanvas.drawArc(this.p, 270.0F, this.v, false, this.c);
    this.y = cx.c().p();
    this.w = ((int)(this.d / 2.0F - this.b.measureText(this.y) / 2.0F));
    this.x = ((int)(this.e / 2.0F + a(this.y, this.b) / 2.0F));
    paramCanvas.drawText(this.y, this.w, this.x, this.b);
    postInvalidate();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), a(paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = getMeasuredHeight();
    this.e = getMeasuredHeight();
    Log.d("CodeCircleView", "CodeCircleView--mWidth:" + this.d + "--mHeight:" + this.e);
    this.p = new RectF(this.d / 2 - this.f, this.e / 2 - this.f, this.d / 2 + this.f, this.e / 2 + this.f);
    this.q = new SweepGradient(this.d / 2, this.e / 2, this.o, null);
    this.r.preRotate(270.0F, this.d / 2, this.e / 2);
    this.q.setLocalMatrix(this.r);
    this.a.setShader(this.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.CodeCircleView
 * JD-Core Version:    0.7.0.1
 */