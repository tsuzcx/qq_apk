package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import java.util.Random;

public final class xs
  extends View
{
  public static int a = 40;
  public static int b = 70;
  public static int c = 86;
  public static int d = 100;
  private static float w = 15.0F;
  private Paint A;
  private Paint B;
  private float C;
  private Context D;
  private float E;
  private float F;
  private float G = 0.0F;
  private float H = 0.0F;
  private Animation I;
  private Animation J;
  private LinearInterpolator K = new LinearInterpolator();
  private RectF L = new RectF();
  private Rect M = new Rect();
  private Random N = new Random();
  private Handler O = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what != 0) {
        return;
      }
      postDelayed(xs.a(xs.this), 50L);
    }
  };
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public int p = 0;
  public ImageView q;
  public ImageView r;
  public boolean s = false;
  public int t = 0;
  public int u = 0;
  public Runnable v = new Runnable()
  {
    public final void run()
    {
      xs.this.postInvalidate();
      xs.b(xs.this).postDelayed(xs.a(xs.this), 50L);
    }
  };
  private final float x = 15.0F;
  private final int y = 0;
  private Paint z;
  
  public xs(Context paramContext, ImageView paramImageView1, ImageView paramImageView2)
  {
    super(paramContext);
    this.D = paramContext;
    this.q = paramImageView1;
    this.r = paramImageView2;
    this.z = new Paint();
    this.z.setColor(this.D.getResources().getColor(2130968658));
    this.z.setAntiAlias(true);
    this.z.setStrokeWidth(3.0F);
    this.z.setStyle(Paint.Style.STROKE);
    this.A = new Paint();
    this.A.setColor(this.D.getResources().getColor(2130968658));
    this.A.setAntiAlias(true);
    this.A.setStrokeWidth(3.0F);
    this.A.setStyle(Paint.Style.STROKE);
    this.B = new Paint();
    this.B.setColor(this.D.getResources().getColor(2130968658));
    this.B.setAntiAlias(true);
    this.B.setStrokeWidth(1.0F);
    this.B.setStyle(Paint.Style.FILL);
    this.C = (BitmapFactory.decodeResource(getResources(), 2131099792).getWidth() / 2);
    this.I = AnimationUtils.loadAnimation(this.D, 2130771982);
    this.J = AnimationUtils.loadAnimation(this.D, 2130771981);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (aac.a())
    {
      this.t += 3;
    }
    else
    {
      this.u += 1;
      if (this.u % 4 == 0) {
        this.t += 1;
      }
    }
    int i1 = this.t;
    int i2 = c;
    if (i1 > i2) {
      this.t = i2;
    }
    i1 = this.t;
    if (this.p < i1)
    {
      i2 = this.N.nextInt(5);
      this.p += i2 + 1;
      if (this.p > i1) {
        this.p = i1;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    this.B.setTextAlign(Paint.Align.CENTER);
    this.B.setTextSize(45.0F);
    this.B.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.M);
    i1 = this.M.bottom;
    i2 = this.M.top;
    paramCanvas.drawText((String)localObject, this.E, this.F + (i1 - i2) / 2, this.B);
    float f1 = this.i;
    float f2 = this.e;
    float f4 = f2 / 2.0F;
    float f3 = this.C;
    if (f1 > f4 + f3)
    {
      f4 = w;
      this.i = (f1 - f4);
      this.j += f4;
      if (this.i < f2 / 2.0F + f3) {
        this.i = (f2 / 2.0F + f3);
      }
      f1 = this.j;
      f2 = this.e;
      f3 = f2 / 2.0F;
      f4 = this.C;
      if (f1 > f3 - f4) {
        this.j = (f2 / 2.0F - f4);
      }
      f1 = this.e;
      f2 = this.f;
      paramCanvas.drawLine(f1, f2 / 2.0F, this.i, f2 / 2.0F, this.A);
      f1 = this.f;
      paramCanvas.drawLine(0.0F, f1 / 2.0F, this.j, f1 / 2.0F, this.z);
      return;
    }
    f3 = this.f;
    paramCanvas.drawLine(f2, f3 / 2.0F, f1, f3 / 2.0F, this.A);
    f1 = this.f;
    paramCanvas.drawLine(0.0F, f1 / 2.0F, this.j, f1 / 2.0F, this.z);
    f1 = this.o;
    if (f1 > -90.0F)
    {
      this.o = (f1 - 15.0F);
      this.n -= 15.0F;
      if (this.o < -90.0F)
      {
        this.o = -90.0F;
        this.n = -90.0F;
      }
    }
    else
    {
      this.q.setVisibility(0);
      this.r.setVisibility(0);
      this.o -= 15.0F;
      this.n -= 15.0F;
      if (this.o < -180.0F)
      {
        this.o = -180.0F;
        this.n = -180.0F;
      }
      if (!this.s)
      {
        this.r.setVisibility(0);
        this.q.setVisibility(0);
        this.I.setInterpolator(this.K);
        this.q.startAnimation(this.I);
        this.J.setInterpolator(this.K);
        this.r.startAnimation(this.J);
        this.s = true;
      }
    }
    paramCanvas.drawArc(this.L, this.m, this.o, false, this.A);
    paramCanvas.drawArc(this.L, this.l, this.n, false, this.z);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.f = getMeasuredHeight();
    this.e = getMeasuredWidth();
    float f1 = this.e;
    this.E = (f1 / 2.0F);
    float f2 = this.f;
    this.F = (f2 / 2.0F);
    this.j = 0.0F;
    this.g = f1;
    this.i = f1;
    this.h = (f2 / 2.0F);
    this.k = (f2 / 2.0F);
    this.m = 0.0F;
    this.l = 180.0F;
    this.n = 0.0F;
    this.o = 0.0F;
    RectF localRectF = this.L;
    f1 = this.E;
    f2 = this.C;
    localRectF.left = (f1 - f2);
    float f3 = this.F;
    localRectF.top = (f3 - f2);
    localRectF.right = (f1 + f2);
    localRectF.bottom = (f3 + f2);
    w = (f1 - f2) / 6.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xs
 * JD-Core Version:    0.7.0.1
 */