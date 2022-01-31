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
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.jni.LiveRectInfo;
import com.tencent.token.global.e;
import com.tencent.token.ui.IndexActivity;

public class FaceView
  extends View
{
  public static float a;
  public static float b;
  public static float c;
  public static float d;
  private float A;
  private float B;
  private boolean C = true;
  private int D;
  private int E;
  private int F;
  private float G;
  private float H;
  private float I;
  private float J;
  private float K;
  private float L;
  private Bitmap M;
  private Bitmap N;
  private Bitmap O;
  private Bitmap P;
  private Bitmap Q;
  private Bitmap R;
  private Bitmap S;
  private int T = 0;
  private Rect U = new Rect();
  private int V = 50;
  private int W = 0;
  private final int X = 10;
  private float e;
  private int f;
  private int g;
  private int h = 0;
  private Bitmap i;
  private Rect j;
  private long k;
  private Context l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v;
  private float w;
  private Paint x;
  private PorterDuffXfermode y = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  private float z;
  
  public FaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.l = paramContext;
    this.D = this.l.getResources().getColor(2131165325);
    this.E = -1;
    paramAttributeSet = new BitmapFactory.Options();
    paramAttributeSet.inSampleSize = 2;
    this.i = BitmapFactory.decodeResource(paramContext.getResources(), 2130837607, paramAttributeSet);
    this.M = BitmapFactory.decodeResource(paramContext.getResources(), 2130837707, null);
    this.O = BitmapFactory.decodeResource(paramContext.getResources(), 2130837706, null);
    this.N = BitmapFactory.decodeResource(paramContext.getResources(), 2130837876, null);
    this.P = BitmapFactory.decodeResource(paramContext.getResources(), 2130837875, null);
    this.K = this.M.getWidth();
    this.L = this.M.getHeight();
    this.e = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.f = paramContext.widthPixels;
    this.g = (paramContext.heightPixels - IndexActivity.S_STATUS_HEIGHT);
    e.c("changescreenWidth=" + this.f + ",screenHeight=" + this.g + ",scale=" + this.e);
    this.r = (this.f / 2);
    this.s = ((this.g - 40.0F * this.e) / 2.0F);
    this.m = (145.0F * this.e);
    this.n = this.m;
    this.o = (this.n + 60.0F * this.e);
    this.p = (this.m - 2.5F * this.e);
    this.z = (5.0F * this.e);
    this.A = (1.7F * this.e);
    this.q = (28.0F * this.e);
    this.B = (2.6F * this.e);
    this.t = this.r;
    this.u = this.s;
    a = (this.r - this.m) / this.f;
    b = (this.s - this.m) / this.g;
    c = this.m * 2.0F / this.f;
    d = this.m * 2.0F / this.g;
    this.x = new Paint();
    this.x.setAntiAlias(true);
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setColor(-1);
    this.x.setTextSize(18.0F * this.e);
    this.x.setTextAlign(Paint.Align.CENTER);
  }
  
  public final float a()
  {
    return this.s;
  }
  
  public final void a(int paramInt)
  {
    this.V = 50;
    this.W = 0;
    this.F = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.U.right = (this.U.left + this.S.getWidth());
      this.U.bottom = (this.U.top + this.S.getHeight());
      return;
      this.v = this.r;
      this.w = (this.s - this.m);
      this.S = BitmapFactory.decodeResource(this.l.getResources(), 2130837532, null);
      this.U.left = ((int)(this.r - this.S.getWidth() / 2));
      this.U.top = ((int)(this.s - this.m / 2.0F - this.S.getHeight() / 2));
      continue;
      this.v = this.r;
      this.w = (this.s + this.m);
      this.S = BitmapFactory.decodeResource(this.l.getResources(), 2130837533, null);
      this.U.left = ((int)(this.r - this.S.getWidth() / 2));
      this.U.top = ((int)(this.s + this.m / 2.0F - this.S.getHeight() / 2));
      continue;
      this.v = (this.r - this.m);
      this.w = this.s;
      this.S = BitmapFactory.decodeResource(this.l.getResources(), 2130837534, null);
      this.U.left = ((int)(this.r - this.m / 2.0F - this.S.getWidth() / 2));
      this.U.top = ((int)(this.s - this.S.getHeight() / 2));
      continue;
      this.v = (this.r + this.m);
      this.w = this.s;
      this.S = BitmapFactory.decodeResource(this.l.getResources(), 2130837535, null);
      this.U.left = ((int)(this.r + this.m / 2.0F - this.S.getWidth() / 2));
      this.U.top = ((int)(this.s - this.S.getHeight() / 2));
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    e.c("changescreenwidth=" + paramInt1 + ", screenheight=" + paramInt2 + ", titleheight=" + IndexActivity.S_STATUS_HEIGHT);
    if (paramInt2 != this.g)
    {
      this.f = paramInt1;
      this.g = paramInt2;
      this.r = (this.f / 2);
      this.s = ((int)((this.g - 40.0F * this.e) / 2.0F));
      a = (this.r - this.m) / this.f;
      b = (this.s - this.m) / this.g;
      c = this.m * 2.0F / this.f;
      d = this.m * 2.0F / this.g;
      paramInt1 = 1;
      this.t = this.r;
      this.u = this.s;
    }
    for (;;)
    {
      if ((this.j == null) || (paramInt1 != 0))
      {
        this.j = new Rect(0, 0, this.f, this.g);
        invalidate();
      }
      return;
      paramInt1 = 0;
    }
  }
  
  public final void a(LiveRectInfo paramLiveRectInfo, int paramInt1, int paramInt2)
  {
    this.G = (paramLiveRectInfo.x() * this.f / paramInt1 - this.e * 5.0F);
    this.H = (paramLiveRectInfo.y() * this.g / paramInt2 - this.e * 5.0F);
    this.I = (paramLiveRectInfo.width() * this.f / paramInt1 + this.e * 10.0F);
    this.J = (paramLiveRectInfo.height() * this.g / paramInt2 + this.e * 10.0F);
    this.h = 5;
    invalidate();
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      this.i = BitmapFactory.decodeResource(this.l.getResources(), 2130837608, localOptions);
    }
    this.C = false;
    if (paramBoolean1)
    {
      this.E = this.l.getResources().getColor(2131165326);
      this.D = this.E;
      if (paramBoolean2)
      {
        this.Q = BitmapFactory.decodeResource(this.l.getResources(), 2130837934, null);
        this.R = BitmapFactory.decodeResource(this.l.getResources(), 2130837935, null);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.Q = BitmapFactory.decodeResource(this.l.getResources(), 2130837581, null);
      this.R = BitmapFactory.decodeResource(this.l.getResources(), 2130837580, null);
      continue;
      this.E = this.l.getResources().getColor(2131165325);
      this.D = this.E;
      if (paramBoolean2)
      {
        this.Q = BitmapFactory.decodeResource(this.l.getResources(), 2130837934, null);
        this.R = BitmapFactory.decodeResource(this.l.getResources(), 2130837935, null);
      }
      else
      {
        this.Q = BitmapFactory.decodeResource(this.l.getResources(), 2130837577, null);
        this.R = BitmapFactory.decodeResource(this.l.getResources(), 2130837580, null);
      }
    }
  }
  
  public final int b()
  {
    return this.h;
  }
  
  public final void b(int paramInt)
  {
    if ((paramInt == 0) || (this.T == paramInt) || (this.W < 10)) {
      return;
    }
    this.T = paramInt;
    switch (this.F)
    {
    }
    for (;;)
    {
      this.h = 8;
      invalidate();
      return;
      this.u = (this.s - this.m * this.T / 21.0F);
      continue;
      this.u = (this.s + this.m * this.T / 21.0F);
      continue;
      this.t = (this.r - this.m * this.T / 21.0F);
      continue;
      this.t = (this.r + this.m * this.T / 21.0F);
    }
  }
  
  public final void c()
  {
    this.t = this.r;
    this.u = this.s;
  }
  
  public final void c(int paramInt)
  {
    if (this.h == paramInt) {
      return;
    }
    this.h = paramInt;
    this.k = 0L;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.j == null) {
      return;
    }
    this.x.setAlpha(255);
    paramCanvas.drawBitmap(this.i, null, this.j, this.x);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setXfermode(this.y);
    this.x.setColor(0);
    paramCanvas.drawCircle(this.r, this.s, this.m, this.x);
    this.x.setXfermode(null);
    float f1;
    float f2;
    float f3;
    float f4;
    switch (this.h)
    {
    case 1: 
    case 2: 
    default: 
      return;
    case 0: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.z);
      this.x.setColor(this.E);
      paramCanvas.drawCircle(this.r, this.s, this.m, this.x);
      this.x.setAlpha(128);
      this.x.setStrokeWidth(this.A);
      paramCanvas.drawCircle(this.r, this.s, this.n, this.x);
      this.x.setAlpha(51);
      paramCanvas.drawCircle(this.r, this.s, this.o, this.x);
      this.n += 5.0F * this.e;
      this.o += 5.0F * this.e;
      if (this.n + this.s >= this.g)
      {
        this.n = this.m;
        this.o = (this.n + 60.0F * this.e);
      }
      invalidate();
      return;
    case 3: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.z);
      this.x.setColor(this.D);
      paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
      return;
    case 4: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.z);
      this.x.setColor(this.D);
      paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
      return;
    case 5: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.z);
      this.x.setColor(this.D);
      this.x.setAlpha(255);
      paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
      paramCanvas.drawBitmap(this.M, this.G, this.H, this.x);
      paramCanvas.drawBitmap(this.N, this.G + this.I - this.K, this.H, this.x);
      paramCanvas.drawBitmap(this.O, this.G, this.H + this.J - this.L, this.x);
      paramCanvas.drawBitmap(this.P, this.G + this.I - this.K, this.H + this.J - this.L, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setColor(-1);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(100);
      f1 = this.G;
      f2 = this.K;
      f3 = this.H;
      f4 = this.G;
      float f5 = this.I;
      float f6 = this.K;
      float f7 = this.H;
      paramCanvas.drawRect(f2 + f1, f3, f4 + f5 - f6, this.A + f7, this.x);
      f1 = this.G;
      f2 = this.H;
      f3 = this.L;
      f4 = this.G;
      paramCanvas.drawRect(f1, f3 + f2, this.A + f4, this.H + this.J - this.L, this.x);
      f1 = this.G;
      f2 = this.I;
      f3 = this.A;
      f4 = this.H;
      f5 = this.L;
      f6 = this.G;
      paramCanvas.drawRect(f1 + f2 - f3, f5 + f4, this.I + f6, this.H + this.J - this.L, this.x);
      f1 = this.G;
      f2 = this.K;
      f3 = this.H;
      f4 = this.J;
      f5 = this.A;
      f6 = this.G;
      f7 = this.I;
      float f8 = this.K;
      float f9 = this.H;
      paramCanvas.drawRect(f2 + f1, f3 + f4 - f5, f6 + f7 - f8, this.J + f9, this.x);
      return;
    case 6: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.z);
      this.x.setColor(this.D);
      paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
      return;
    case 7: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.z);
      this.x.setColor(this.D);
      paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(128);
      this.x.setColor(this.D);
      this.x.setStrokeWidth(this.B);
      paramCanvas.drawCircle(this.t, this.u, this.q, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(70);
      paramCanvas.drawCircle(this.t, this.u, this.q, this.x);
      this.x.setColor(-1);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(128);
      this.x.setStrokeWidth(this.B);
      paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(70);
      paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
      this.x.setAlpha(255);
      paramCanvas.drawBitmap(this.Q, this.v - this.Q.getWidth() / 2, this.w - this.Q.getHeight() / 2, this.x);
      this.V += 100;
      this.V %= 255;
      this.W += 1;
      if (this.W < 10)
      {
        this.x.setAlpha(this.V);
        paramCanvas.drawBitmap(this.S, this.U.left, this.U.top, this.x);
        invalidate();
        return;
      }
      this.V = 255;
      this.x.setAlpha(this.V);
      paramCanvas.drawBitmap(this.S, this.U.left, this.U.top, this.x);
      return;
    case 8: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.z);
      this.x.setColor(this.D);
      paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
      switch (this.F)
      {
      }
      for (;;)
      {
        this.x.setColor(-1);
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setAlpha(128);
        this.x.setStrokeWidth(this.B);
        paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
        this.x.setStyle(Paint.Style.FILL);
        this.x.setStrokeWidth(1.0F);
        this.x.setAlpha(70);
        paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
        this.x.setAlpha(255);
        paramCanvas.drawBitmap(this.Q, this.v - this.Q.getWidth() / 2, this.w - this.Q.getHeight() / 2, this.x);
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setAlpha(128);
        this.x.setColor(this.D);
        this.x.setStrokeWidth(this.B);
        paramCanvas.drawCircle(this.t, this.u, this.q, this.x);
        this.x.setStyle(Paint.Style.FILL);
        this.x.setStrokeWidth(1.0F);
        this.x.setAlpha(70);
        paramCanvas.drawCircle(this.t, this.u, this.q, this.x);
        return;
        if (this.u - this.q > this.U.top)
        {
          paramCanvas.drawBitmap(this.S, this.U.left, this.U.top, this.x);
          this.x.setStyle(Paint.Style.FILL);
          this.x.setXfermode(this.y);
          this.x.setColor(0);
          paramCanvas.drawRect(this.U.left, this.u - this.q, this.U.right, this.U.bottom, this.x);
          this.x.setXfermode(null);
          continue;
          if (this.u + this.q < this.U.bottom)
          {
            paramCanvas.drawBitmap(this.S, this.U.left, this.U.top, this.x);
            this.x.setStyle(Paint.Style.FILL);
            this.x.setXfermode(this.y);
            this.x.setColor(0);
            f1 = this.U.left;
            f2 = this.U.top;
            f3 = this.U.right;
            f4 = this.u;
            paramCanvas.drawRect(f1, f2, f3, this.q + f4, this.x);
            this.x.setXfermode(null);
            continue;
            if (this.t - this.q > this.U.left)
            {
              paramCanvas.drawBitmap(this.S, this.U.left, this.U.top, this.x);
              this.x.setStyle(Paint.Style.FILL);
              this.x.setXfermode(this.y);
              this.x.setColor(0);
              paramCanvas.drawRect(this.t - this.q, this.U.top, this.U.right, this.U.bottom, this.x);
              this.x.setXfermode(null);
              continue;
              if (this.t + this.q < this.U.right)
              {
                paramCanvas.drawBitmap(this.S, this.U.left, this.U.top, this.x);
                this.x.setStyle(Paint.Style.FILL);
                this.x.setXfermode(this.y);
                this.x.setColor(0);
                f1 = this.U.left;
                f2 = this.U.top;
                f3 = this.t;
                paramCanvas.drawRect(f1, f2, this.q + f3, this.U.bottom, this.x);
                this.x.setXfermode(null);
              }
            }
          }
        }
      }
    }
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.z);
    this.x.setColor(this.D);
    paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
    this.x.setColor(this.D);
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setAlpha(70);
    this.x.setStrokeWidth(this.B);
    paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setStrokeWidth(1.0F);
    this.x.setAlpha(255);
    paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
    this.x.setAlpha(255);
    paramCanvas.drawBitmap(this.R, this.v - this.R.getWidth() / 2, this.w - this.R.getHeight() / 2, this.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FaceView
 * JD-Core Version:    0.7.0.1
 */