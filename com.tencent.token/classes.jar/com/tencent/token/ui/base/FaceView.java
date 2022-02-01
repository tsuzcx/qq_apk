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
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.xv;
import com.tencent.token.yv;

public class FaceView
  extends View
{
  public static float j;
  public static float k;
  public static float l;
  public static float m;
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
  public float a;
  private int aa = 0;
  private final int ab = 10;
  private boolean ac = false;
  private Bitmap ad;
  public int b;
  public int c;
  public Rect d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  private int n = 0;
  private Bitmap o;
  private long p;
  private Context q;
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
    this.q = paramContext;
    this.E = this.q.getResources().getColor(2130968656);
    this.F = -1;
    paramAttributeSet = new BitmapFactory.Options();
    paramAttributeSet.inSampleSize = 2;
    this.o = BitmapFactory.decodeResource(paramContext.getResources(), 2131099840, paramAttributeSet);
    this.N = BitmapFactory.decodeResource(paramContext.getResources(), 2131099938, null);
    this.P = BitmapFactory.decodeResource(paramContext.getResources(), 2131099937, null);
    this.O = BitmapFactory.decodeResource(paramContext.getResources(), 2131100099, null);
    this.Q = BitmapFactory.decodeResource(paramContext.getResources(), 2131100098, null);
    this.L = this.N.getWidth();
    this.M = this.N.getHeight();
    this.a = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.b = paramContext.widthPixels;
    this.c = (paramContext.heightPixels - IndexActivity.S_STATUS_HEIGHT);
    paramContext = new StringBuilder("changescreenWidth=");
    paramContext.append(this.b);
    paramContext.append(",screenHeight=");
    paramContext.append(this.c);
    paramContext.append(",scale=");
    paramContext.append(this.a);
    xv.c(paramContext.toString());
    this.d = new Rect(0, 0, this.b, this.c);
    int i1 = this.b;
    this.f = (i1 / 2);
    int i2 = this.c;
    float f1 = i2;
    float f2 = this.a;
    this.g = ((f1 - 40.0F * f2) / 2.0F);
    this.e = (145.0F * f2);
    f1 = this.e;
    this.r = f1;
    this.s = (this.r + 60.0F * f2);
    this.t = (f1 - 2.5F * f2);
    this.A = (5.0F * f2);
    this.B = (1.7F * f2);
    this.u = (28.0F * f2);
    this.C = (f2 * 2.6F);
    f2 = this.f;
    this.h = f2;
    float f3 = this.g;
    this.i = f3;
    j = (f2 - f1) / i1;
    k = (f3 - f1) / i2;
    l = f1 * 2.0F / i1;
    m = f1 * 2.0F / i2;
    this.x = new Paint();
    this.x.setAntiAlias(true);
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setColor(-1);
    this.x.setTextSize(this.a * 18.0F);
    this.x.setTextAlign(Paint.Align.CENTER);
  }
  
  public final void a(LiveRectInfo paramLiveRectInfo, int paramInt1, int paramInt2)
  {
    this.H = (paramLiveRectInfo.x() * this.b / paramInt1 - this.a * 5.0F);
    this.I = (paramLiveRectInfo.y() * this.c / paramInt2 - this.a * 5.0F);
    this.J = (paramLiveRectInfo.width() * this.b / paramInt1 + this.a * 10.0F);
    this.K = (paramLiveRectInfo.height() * this.c / paramInt2 + this.a * 10.0F);
    this.n = 5;
    invalidate();
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      this.o = BitmapFactory.decodeResource(this.q.getResources(), 2131099841, localOptions);
    }
    this.D = false;
    if (paramBoolean1)
    {
      this.F = this.q.getResources().getColor(2130968657);
      this.E = this.F;
      if (paramBoolean2)
      {
        this.R = BitmapFactory.decodeResource(this.q.getResources(), 2131100152, null);
        this.S = BitmapFactory.decodeResource(this.q.getResources(), 2131100153, null);
      }
      else
      {
        this.R = BitmapFactory.decodeResource(this.q.getResources(), 2131099810, null);
        this.S = BitmapFactory.decodeResource(this.q.getResources(), 2131099809, null);
      }
    }
    else
    {
      this.F = this.q.getResources().getColor(2130968656);
      this.E = this.F;
      if (paramBoolean2)
      {
        this.R = BitmapFactory.decodeResource(this.q.getResources(), 2131100152, null);
        this.S = BitmapFactory.decodeResource(this.q.getResources(), 2131100153, null);
      }
      else
      {
        this.R = BitmapFactory.decodeResource(this.q.getResources(), 2131099806, null);
        this.S = BitmapFactory.decodeResource(this.q.getResources(), 2131099809, null);
      }
    }
    invalidate();
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
    return this.f;
  }
  
  public float getCenterY()
  {
    return this.g;
  }
  
  public int getStatus()
  {
    return this.n;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d == null)
    {
      xv.a("rect=null");
      return;
    }
    this.x.setAlpha(255);
    Bitmap localBitmap = this.ad;
    if (localBitmap != null)
    {
      paramCanvas.drawBitmap(localBitmap, null, this.d, this.x);
      paramCanvas.saveLayer(0.0F, 0.0F, this.b, this.c, null, 31);
    }
    if (this.ac)
    {
      this.x.setColor(-1);
      this.x.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.d, this.x);
    }
    else
    {
      paramCanvas.drawBitmap(this.o, null, this.d, this.x);
    }
    this.x.setStyle(Paint.Style.FILL);
    this.x.setXfermode(this.y);
    this.x.setColor(0);
    paramCanvas.drawCircle(this.f, this.g, this.e, this.x);
    this.x.setXfermode(null);
    float f3;
    float f4;
    switch (this.n)
    {
    case 2: 
    default: 
      return;
    case 9: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.A);
      this.x.setColor(this.E);
      paramCanvas.drawCircle(this.f, this.g, this.t, this.x);
      this.x.setColor(this.E);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(70);
      this.x.setStrokeWidth(this.C);
      paramCanvas.drawCircle(this.v, this.w, this.u, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(255);
      paramCanvas.drawCircle(this.v, this.w, this.u, this.x);
      this.x.setAlpha(255);
      localBitmap = this.S;
      paramCanvas.drawBitmap(localBitmap, this.v - localBitmap.getWidth() / 2, this.w - this.S.getHeight() / 2, this.x);
      return;
    case 8: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.A);
      this.x.setColor(this.E);
      paramCanvas.drawCircle(this.f, this.g, this.t, this.x);
      switch (this.G)
      {
      default: 
        break;
      case 4: 
        if (this.h + this.u < this.V.right)
        {
          paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
          this.x.setStyle(Paint.Style.FILL);
          this.x.setXfermode(this.y);
          this.x.setColor(0);
          f1 = this.V.left;
          f2 = this.V.top;
          f3 = this.h;
          paramCanvas.drawRect(f1, f2, this.u + f3, this.V.bottom, this.x);
          this.x.setXfermode(null);
        }
        break;
      case 3: 
        if (this.h - this.u > this.V.left)
        {
          paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
          this.x.setStyle(Paint.Style.FILL);
          this.x.setXfermode(this.y);
          this.x.setColor(0);
          paramCanvas.drawRect(this.h - this.u, this.V.top, this.V.right, this.V.bottom, this.x);
          this.x.setXfermode(null);
        }
        break;
      case 2: 
        if (this.i + this.u < this.V.bottom)
        {
          paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
          this.x.setStyle(Paint.Style.FILL);
          this.x.setXfermode(this.y);
          this.x.setColor(0);
          f1 = this.V.left;
          f2 = this.V.top;
          f3 = this.V.right;
          f4 = this.i;
          paramCanvas.drawRect(f1, f2, f3, this.u + f4, this.x);
          this.x.setXfermode(null);
        }
        break;
      case 1: 
        if (this.i - this.u > this.V.top)
        {
          paramCanvas.drawBitmap(this.T, this.V.left, this.V.top, this.x);
          this.x.setStyle(Paint.Style.FILL);
          this.x.setXfermode(this.y);
          this.x.setColor(0);
          paramCanvas.drawRect(this.V.left, this.i - this.u, this.V.right, this.V.bottom, this.x);
          this.x.setXfermode(null);
        }
        break;
      }
      this.x.setColor(-1);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(128);
      this.x.setStrokeWidth(this.C);
      paramCanvas.drawCircle(this.v, this.w, this.u, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(70);
      paramCanvas.drawCircle(this.v, this.w, this.u, this.x);
      this.x.setAlpha(255);
      localBitmap = this.R;
      paramCanvas.drawBitmap(localBitmap, this.v - localBitmap.getWidth() / 2, this.w - this.R.getHeight() / 2, this.x);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(128);
      this.x.setColor(this.E);
      this.x.setStrokeWidth(this.C);
      paramCanvas.drawCircle(this.h, this.i, this.u, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(70);
      paramCanvas.drawCircle(this.h, this.i, this.u, this.x);
      return;
    case 7: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.A);
      this.x.setColor(this.E);
      paramCanvas.drawCircle(this.f, this.g, this.t, this.x);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(128);
      this.x.setColor(this.E);
      this.x.setStrokeWidth(this.C);
      paramCanvas.drawCircle(this.h, this.i, this.u, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(70);
      paramCanvas.drawCircle(this.h, this.i, this.u, this.x);
      this.x.setColor(-1);
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setAlpha(128);
      this.x.setStrokeWidth(this.C);
      paramCanvas.drawCircle(this.v, this.w, this.u, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(70);
      paramCanvas.drawCircle(this.v, this.w, this.u, this.x);
      this.x.setAlpha(255);
      localBitmap = this.R;
      paramCanvas.drawBitmap(localBitmap, this.v - localBitmap.getWidth() / 2, this.w - this.R.getHeight() / 2, this.x);
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
    case 6: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.A);
      this.x.setColor(this.E);
      paramCanvas.drawCircle(this.f, this.g, this.t, this.x);
      return;
    case 5: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.A);
      this.x.setColor(this.E);
      this.x.setAlpha(255);
      paramCanvas.drawCircle(this.f, this.g, this.t, this.x);
      paramCanvas.drawBitmap(this.N, this.H, this.I, this.x);
      paramCanvas.drawBitmap(this.O, this.H + this.J - this.L, this.I, this.x);
      paramCanvas.drawBitmap(this.P, this.H, this.I + this.K - this.M, this.x);
      paramCanvas.drawBitmap(this.Q, this.H + this.J - this.L, this.I + this.K - this.M, this.x);
      this.x.setStyle(Paint.Style.FILL);
      this.x.setColor(-1);
      this.x.setStrokeWidth(1.0F);
      this.x.setAlpha(100);
      f1 = this.H;
      f2 = this.L;
      f3 = this.I;
      paramCanvas.drawRect(f1 + f2, f3, f1 + this.J - f2, f3 + this.B, this.x);
      f1 = this.H;
      f2 = this.I;
      f3 = this.M;
      paramCanvas.drawRect(f1, f2 + f3, this.B + f1, f2 + this.K - f3, this.x);
      f1 = this.H;
      f2 = this.J;
      f3 = this.B;
      f4 = this.I;
      float f5 = this.M;
      paramCanvas.drawRect(f1 + f2 - f3, f4 + f5, f1 + f2, f4 + this.K - f5, this.x);
      f1 = this.H;
      f2 = this.L;
      f3 = this.I;
      f4 = this.K;
      paramCanvas.drawRect(f1 + f2, f3 + f4 - this.B, f1 + this.J - f2, f4 + f3, this.x);
      return;
    case 4: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.A);
      this.x.setColor(this.E);
      paramCanvas.drawCircle(this.f, this.g, this.t, this.x);
      return;
    case 3: 
      this.x.setStyle(Paint.Style.STROKE);
      this.x.setStrokeWidth(this.A);
      this.x.setColor(this.E);
      paramCanvas.drawCircle(this.f, this.g, this.t, this.x);
      return;
    case 1: 
      return;
    }
    this.x.setStyle(Paint.Style.STROKE);
    this.x.setStrokeWidth(this.A);
    this.x.setColor(this.F);
    paramCanvas.drawCircle(this.f, this.g, this.e, this.x);
    this.x.setAlpha(128);
    this.x.setStrokeWidth(this.B);
    paramCanvas.drawCircle(this.f, this.g, this.r, this.x);
    this.x.setAlpha(51);
    paramCanvas.drawCircle(this.f, this.g, this.s, this.x);
    float f1 = this.r;
    float f2 = this.a;
    this.r = (f1 + f2 * 5.0F);
    this.s += 5.0F * f2;
    if (this.r + this.g >= this.c)
    {
      this.r = this.e;
      this.s = (this.r + f2 * 60.0F);
    }
    invalidate();
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
    if (this.n == paramInt) {
      return;
    }
    this.n = paramInt;
    this.p = 0L;
    invalidate();
  }
  
  public void setVryMoveDistance(int paramInt)
  {
    if ((paramInt != 0) && (this.U != paramInt))
    {
      if (this.aa < 10) {
        return;
      }
      this.U = paramInt;
      switch (this.G)
      {
      default: 
        break;
      case 4: 
        this.h = (this.f + this.e * this.U / yv.k);
        break;
      case 3: 
        this.h = (this.f - this.e * this.U / yv.k);
        break;
      case 2: 
        this.i = (this.g + this.e * this.U / yv.k);
        break;
      case 1: 
        this.i = (this.g - this.e * this.U / yv.k);
      }
      this.n = 8;
      invalidate();
      return;
    }
  }
  
  public void setVryNodDirection(int paramInt)
  {
    this.W = 50;
    this.aa = 0;
    this.G = paramInt;
    switch (paramInt)
    {
    default: 
      break;
    case 4: 
      this.v = (this.f + this.e);
      this.w = this.g;
      this.T = BitmapFactory.decodeResource(this.q.getResources(), 2131099759, null);
      this.V.left = ((int)(this.f + this.e / 2.0F - this.T.getWidth() / 2));
      this.V.top = ((int)(this.g - this.T.getHeight() / 2));
      break;
    case 3: 
      this.v = (this.f - this.e);
      this.w = this.g;
      this.T = BitmapFactory.decodeResource(this.q.getResources(), 2131099758, null);
      this.V.left = ((int)(this.f - this.e / 2.0F - this.T.getWidth() / 2));
      this.V.top = ((int)(this.g - this.T.getHeight() / 2));
      break;
    case 2: 
      this.v = this.f;
      this.w = (this.g + this.e);
      this.T = BitmapFactory.decodeResource(this.q.getResources(), 2131099757, null);
      this.V.left = ((int)(this.f - this.T.getWidth() / 2));
      this.V.top = ((int)(this.g + this.e / 2.0F - this.T.getHeight() / 2));
      break;
    case 1: 
      this.v = this.f;
      this.w = (this.g - this.e);
      this.T = BitmapFactory.decodeResource(this.q.getResources(), 2131099756, null);
      this.V.left = ((int)(this.f - this.T.getWidth() / 2));
      this.V.top = ((int)(this.g - this.e / 2.0F - this.T.getHeight() / 2));
    }
    if (this.T != null)
    {
      Rect localRect = this.V;
      localRect.right = (localRect.left + this.T.getWidth());
      localRect = this.V;
      localRect.bottom = (localRect.top + this.T.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FaceView
 * JD-Core Version:    0.7.0.1
 */