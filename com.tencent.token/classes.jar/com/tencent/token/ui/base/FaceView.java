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
import com.tencent.token.global.h;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.gx;

public class FaceView
  extends View
{
  public static float a;
  public static float b;
  public static float c;
  public static float d;
  private float A;
  private float B;
  private float C;
  private boolean D = true;
  private int E;
  private int F;
  private int G;
  private float H;
  private float I;
  private float J;
  private float K;
  private float L;
  private float M;
  private Bitmap N;
  private Bitmap O;
  private Bitmap P;
  private Bitmap Q;
  private Bitmap R;
  private Bitmap S;
  private Bitmap T;
  private int U = 0;
  private Rect V = new Rect();
  private int W = 50;
  private int aa = 0;
  private final int ab = 10;
  private boolean ac = false;
  private Bitmap ad;
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
  private PorterDuffXfermode z = new PorterDuffXfermode(PorterDuff.Mode.DST);
  
  public FaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.l = paramContext;
    this.E = this.l.getResources().getColor(2131492923);
    this.F = -1;
    paramAttributeSet = new BitmapFactory.Options();
    paramAttributeSet.inSampleSize = 2;
    this.i = BitmapFactory.decodeResource(paramContext.getResources(), 2130837693, paramAttributeSet);
    this.N = BitmapFactory.decodeResource(paramContext.getResources(), 2130837786, null);
    this.P = BitmapFactory.decodeResource(paramContext.getResources(), 2130837785, null);
    this.O = BitmapFactory.decodeResource(paramContext.getResources(), 2130837942, null);
    this.Q = BitmapFactory.decodeResource(paramContext.getResources(), 2130837941, null);
    this.L = this.N.getWidth();
    this.M = this.N.getHeight();
    this.e = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.f = paramContext.widthPixels;
    this.g = (paramContext.heightPixels - IndexActivity.S_STATUS_HEIGHT);
    h.c("changescreenWidth=" + this.f + ",screenHeight=" + this.g + ",scale=" + this.e);
    this.j = new Rect(0, 0, this.f, this.g);
    this.r = (this.f / 2);
    this.s = ((this.g - 40.0F * this.e) / 2.0F);
    this.m = (145.0F * this.e);
    this.n = this.m;
    this.o = (this.n + 60.0F * this.e);
    this.p = (this.m - 2.5F * this.e);
    this.A = (5.0F * this.e);
    this.B = (1.7F * this.e);
    this.q = (28.0F * this.e);
    this.C = (2.6F * this.e);
    this.t = this.r;
    this.u = this.s;
    a = (this.r - this.m) / this.f;
    b = (this.s - this.m) / this.g;
    c = this.m * 2.0F / this.f;
    d = this.m * 2.0F / this.g;
    this.x = new Paint();
    b();
  }
  
  private void b()
  {
    this.x.setAntiAlias(true);
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setColor(-1);
    this.x.setTextSize(18.0F * this.e);
    this.x.setTextAlign(Paint.Align.CENTER);
  }
  
  public void a()
  {
    this.t = this.r;
    this.u = this.s;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    h.c("changescreenwidth=" + paramInt1 + ", screenheight=" + paramInt2 + ", titleheight=" + IndexActivity.S_STATUS_HEIGHT);
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
  
  public void a(LiveRectInfo paramLiveRectInfo, int paramInt1, int paramInt2)
  {
    this.H = (paramLiveRectInfo.x() * this.f / paramInt1 - this.e * 5.0F);
    this.I = (paramLiveRectInfo.y() * this.g / paramInt2 - this.e * 5.0F);
    this.J = (paramLiveRectInfo.width() * this.f / paramInt1 + this.e * 10.0F);
    this.K = (paramLiveRectInfo.height() * this.g / paramInt2 + this.e * 10.0F);
    this.h = 5;
    invalidate();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      this.i = BitmapFactory.decodeResource(this.l.getResources(), 2130837694, localOptions);
    }
    this.D = false;
    if (paramBoolean1)
    {
      this.F = this.l.getResources().getColor(2131492924);
      this.E = this.F;
      if (paramBoolean2)
      {
        this.R = BitmapFactory.decodeResource(this.l.getResources(), 2130837994, null);
        this.S = BitmapFactory.decodeResource(this.l.getResources(), 2130837995, null);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.R = BitmapFactory.decodeResource(this.l.getResources(), 2130837663, null);
      this.S = BitmapFactory.decodeResource(this.l.getResources(), 2130837662, null);
      continue;
      this.F = this.l.getResources().getColor(2131492923);
      this.E = this.F;
      if (paramBoolean2)
      {
        this.R = BitmapFactory.decodeResource(this.l.getResources(), 2130837994, null);
        this.S = BitmapFactory.decodeResource(this.l.getResources(), 2130837995, null);
      }
      else
      {
        this.R = BitmapFactory.decodeResource(this.l.getResources(), 2130837659, null);
        this.S = BitmapFactory.decodeResource(this.l.getResources(), 2130837662, null);
      }
    }
  }
  
  public boolean getBrightMode()
  {
    return this.ac;
  }
  
  public int getBrightModeIntValue()
  {
    if (this.ac) {
      return 1;
    }
    return 0;
  }
  
  public float getCenterX()
  {
    return this.r;
  }
  
  public float getCenterY()
  {
    return this.s;
  }
  
  public int getStatus()
  {
    return this.h;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.j == null)
    {
      h.a("rect=null");
      return;
    }
    this.x.setAlpha(255);
    if (this.ad != null)
    {
      paramCanvas.drawBitmap(this.ad, null, this.j, this.x);
      paramCanvas.saveLayer(0.0F, 0.0F, this.f, this.g, null, 31);
    }
    if (this.ac)
    {
      this.x.setColor(-1);
      this.x.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.j, this.x);
    }
    for (;;)
    {
      this.x.setStyle(Paint.Style.FILL);
      this.x.setXfermode(this.y);
      this.x.setColor(0);
      paramCanvas.drawCircle(this.r, this.s, this.m, this.x);
      this.x.setXfermode(null);
      switch (this.h)
      {
      case 1: 
      case 2: 
      default: 
        return;
      case 0: 
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setStrokeWidth(this.A);
        this.x.setColor(this.F);
        paramCanvas.drawCircle(this.r, this.s, this.m, this.x);
        this.x.setAlpha(128);
        this.x.setStrokeWidth(this.B);
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
        paramCanvas.drawBitmap(this.i, null, this.j, this.x);
      }
    }
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.A);
    this.x.setColor(this.E);
    paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
    return;
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.A);
    this.x.setColor(this.E);
    paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
    return;
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.A);
    this.x.setColor(this.E);
    this.x.setAlpha(255);
    paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
    paramCanvas.drawBitmap(this.N, this.H, this.I, this.x);
    paramCanvas.drawBitmap(this.O, this.H + this.J - this.L, this.I, this.x);
    paramCanvas.drawBitmap(this.P, this.H, this.I + this.K - this.M, this.x);
    paramCanvas.drawBitmap(this.Q, this.H + this.J - this.L, this.I + this.K - this.M, this.x);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setColor(-1);
    this.x.setStrokeWidth(1.0F);
    this.x.setAlpha(100);
    float f1 = this.H;
    float f2 = this.L;
    float f3 = this.I;
    float f4 = this.H;
    float f5 = this.J;
    float f6 = this.L;
    float f7 = this.I;
    paramCanvas.drawRect(f2 + f1, f3, f4 + f5 - f6, this.B + f7, this.x);
    f1 = this.H;
    f2 = this.I;
    f3 = this.M;
    f4 = this.H;
    paramCanvas.drawRect(f1, f3 + f2, this.B + f4, this.I + this.K - this.M, this.x);
    f1 = this.H;
    f2 = this.J;
    f3 = this.B;
    f4 = this.I;
    f5 = this.M;
    f6 = this.H;
    paramCanvas.drawRect(f1 + f2 - f3, f5 + f4, this.J + f6, this.I + this.K - this.M, this.x);
    f1 = this.H;
    f2 = this.L;
    f3 = this.I;
    f4 = this.K;
    f5 = this.B;
    f6 = this.H;
    f7 = this.J;
    float f8 = this.L;
    float f9 = this.I;
    paramCanvas.drawRect(f2 + f1, f3 + f4 - f5, f6 + f7 - f8, this.K + f9, this.x);
    return;
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.A);
    this.x.setColor(this.E);
    paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
    return;
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.A);
    this.x.setColor(this.E);
    paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setAlpha(128);
    this.x.setColor(this.E);
    this.x.setStrokeWidth(this.C);
    paramCanvas.drawCircle(this.t, this.u, this.q, this.x);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setStrokeWidth(1.0F);
    this.x.setAlpha(70);
    paramCanvas.drawCircle(this.t, this.u, this.q, this.x);
    this.x.setColor(-1);
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setAlpha(128);
    this.x.setStrokeWidth(this.C);
    paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setStrokeWidth(1.0F);
    this.x.setAlpha(70);
    paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
    this.x.setAlpha(255);
    paramCanvas.drawBitmap(this.R, this.v - this.R.getWidth() / 2, this.w - this.R.getHeight() / 2, this.x);
    this.W += 100;
    this.W %= 255;
    this.aa += 1;
    if (this.aa < 10)
    {
      this.x.setAlpha(this.W);
      paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
      invalidate();
      return;
    }
    this.W = 255;
    this.x.setAlpha(this.W);
    paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
    return;
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.A);
    this.x.setColor(this.E);
    paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
    switch (this.G)
    {
    }
    for (;;)
    {
      this.x.setColor(-1);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(128);
      this.x.setStrokeWidth(this.C);
      paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(70);
      paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
      this.x.setAlpha(255);
      paramCanvas.drawBitmap(this.R, this.v - this.R.getWidth() / 2, this.w - this.R.getHeight() / 2, this.x);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(128);
      this.x.setColor(this.E);
      this.x.setStrokeWidth(this.C);
      paramCanvas.drawCircle(this.t, this.u, this.q, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(70);
      paramCanvas.drawCircle(this.t, this.u, this.q, this.x);
      return;
      if (this.u - this.q > this.V.top)
      {
        paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
        this.x.setStyle(Paint.Style.FILL);
        this.x.setXfermode(this.y);
        this.x.setColor(0);
        paramCanvas.drawRect(this.V.left, this.u - this.q, this.V.right, this.V.bottom, this.x);
        this.x.setXfermode(null);
        continue;
        if (this.u + this.q < this.V.bottom)
        {
          paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
          this.x.setStyle(Paint.Style.FILL);
          this.x.setXfermode(this.y);
          this.x.setColor(0);
          f1 = this.V.left;
          f2 = this.V.top;
          f3 = this.V.right;
          f4 = this.u;
          paramCanvas.drawRect(f1, f2, f3, this.q + f4, this.x);
          this.x.setXfermode(null);
          continue;
          if (this.t - this.q > this.V.left)
          {
            paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
            this.x.setStyle(Paint.Style.FILL);
            this.x.setXfermode(this.y);
            this.x.setColor(0);
            paramCanvas.drawRect(this.t - this.q, this.V.top, this.V.right, this.V.bottom, this.x);
            this.x.setXfermode(null);
            continue;
            if (this.t + this.q < this.V.right)
            {
              paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
              this.x.setStyle(Paint.Style.FILL);
              this.x.setXfermode(this.y);
              this.x.setColor(0);
              f1 = this.V.left;
              f2 = this.V.top;
              f3 = this.t;
              paramCanvas.drawRect(f1, f2, this.q + f3, this.V.bottom, this.x);
              this.x.setXfermode(null);
            }
          }
        }
      }
    }
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.A);
    this.x.setColor(this.E);
    paramCanvas.drawCircle(this.r, this.s, this.p, this.x);
    this.x.setColor(this.E);
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setAlpha(70);
    this.x.setStrokeWidth(this.C);
    paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setStrokeWidth(1.0F);
    this.x.setAlpha(255);
    paramCanvas.drawCircle(this.v, this.w, this.q, this.x);
    this.x.setAlpha(255);
    paramCanvas.drawBitmap(this.S, this.v - this.S.getWidth() / 2, this.w - this.S.getHeight() / 2, this.x);
  }
  
  public void setBeautyBitmap(Bitmap paramBitmap)
  {
    this.ad = paramBitmap;
  }
  
  public void setBrightMode(boolean paramBoolean)
  {
    this.ac = paramBoolean;
  }
  
  public void setStatus(int paramInt)
  {
    if (this.h == paramInt) {
      return;
    }
    this.h = paramInt;
    this.k = 0L;
    invalidate();
  }
  
  public void setVryMoveDistance(int paramInt)
  {
    if ((paramInt == 0) || (this.U == paramInt) || (this.aa < 10)) {
      return;
    }
    this.U = paramInt;
    switch (this.G)
    {
    }
    for (;;)
    {
      this.h = 8;
      invalidate();
      return;
      this.u = (this.s - this.m * this.U / gx.h);
      continue;
      this.u = (this.s + this.m * this.U / gx.h);
      continue;
      this.t = (this.r - this.m * this.U / gx.h);
      continue;
      this.t = (this.r + this.m * this.U / gx.h);
    }
  }
  
  public void setVryNodDirection(int paramInt)
  {
    this.W = 50;
    this.aa = 0;
    this.G = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.T != null)
      {
        this.V.right = (this.V.left + this.T.getWidth());
        this.V.bottom = (this.V.top + this.T.getHeight());
      }
      return;
      this.v = this.r;
      this.w = (this.s - this.m);
      this.T = BitmapFactory.decodeResource(this.l.getResources(), 2130837611, null);
      this.V.left = ((int)(this.r - this.T.getWidth() / 2));
      this.V.top = ((int)(this.s - this.m / 2.0F - this.T.getHeight() / 2));
      continue;
      this.v = this.r;
      this.w = (this.s + this.m);
      this.T = BitmapFactory.decodeResource(this.l.getResources(), 2130837612, null);
      this.V.left = ((int)(this.r - this.T.getWidth() / 2));
      this.V.top = ((int)(this.s + this.m / 2.0F - this.T.getHeight() / 2));
      continue;
      this.v = (this.r - this.m);
      this.w = this.s;
      this.T = BitmapFactory.decodeResource(this.l.getResources(), 2130837613, null);
      this.V.left = ((int)(this.r - this.m / 2.0F - this.T.getWidth() / 2));
      this.V.top = ((int)(this.s - this.T.getHeight() / 2));
      continue;
      this.v = (this.r + this.m);
      this.w = this.s;
      this.T = BitmapFactory.decodeResource(this.l.getResources(), 2130837614, null);
      this.V.left = ((int)(this.r + this.m / 2.0F - this.T.getWidth() / 2));
      this.V.top = ((int)(this.s - this.T.getHeight() / 2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FaceView
 * JD-Core Version:    0.7.0.1
 */