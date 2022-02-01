package com.tencent.token.ui;

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
import com.tencent.token.utils.l;
import java.util.Random;

class d
  extends View
{
  public static int a = 40;
  public static int b = 70;
  public static int c = 86;
  public static int d = 100;
  private static float e = 15.0F;
  private float A = 0.0F;
  private float B = 0.0F;
  private ImageView C;
  private ImageView D;
  private boolean E = false;
  private int F = 0;
  private int G = 0;
  private Runnable H = new Runnable()
  {
    public void run()
    {
      d.this.a();
      d.b(d.this).postDelayed(d.a(d.this), 50L);
    }
  };
  private Animation I;
  private Animation J;
  private LinearInterpolator K = new LinearInterpolator();
  private RectF L = new RectF();
  private Rect M = new Rect();
  private Random N = new Random();
  private Handler O = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      postDelayed(d.a(d.this), 50L);
    }
  };
  private final float f = 15.0F;
  private final int g = 0;
  private Paint h;
  private Paint i;
  private Paint j;
  private float k;
  private float l;
  private float m;
  private Context n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v;
  private float w;
  private float x;
  private float y;
  private int z = 0;
  
  public d(Context paramContext, ImageView paramImageView1, ImageView paramImageView2)
  {
    super(paramContext);
    this.n = paramContext;
    this.C = paramImageView1;
    this.D = paramImageView2;
    this.h = new Paint();
    this.h.setColor(this.n.getResources().getColor(2131492926));
    this.h.setAntiAlias(true);
    this.h.setStrokeWidth(3.0F);
    this.h.setStyle(Paint.Style.STROKE);
    this.i = new Paint();
    this.i.setColor(this.n.getResources().getColor(2131492926));
    this.i.setAntiAlias(true);
    this.i.setStrokeWidth(3.0F);
    this.i.setStyle(Paint.Style.STROKE);
    this.j = new Paint();
    this.j.setColor(this.n.getResources().getColor(2131492926));
    this.j.setAntiAlias(true);
    this.j.setStrokeWidth(1.0F);
    this.j.setStyle(Paint.Style.FILL);
    this.m = (BitmapFactory.decodeResource(getResources(), 2130837646).getWidth() / 2);
    this.I = AnimationUtils.loadAnimation(this.n, 2131034126);
    this.J = AnimationUtils.loadAnimation(this.n, 2131034125);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    if (this.z < paramInt)
    {
      this.z = (this.N.nextInt(5) + 1 + this.z);
      if (this.z > paramInt) {
        this.z = paramInt;
      }
    }
    String str = this.z + "%";
    this.j.setTextAlign(Paint.Align.CENTER);
    this.j.setTextSize(45.0F);
    this.j.getTextBounds(str, 0, str.length(), this.M);
    paramInt = this.M.bottom;
    int i1 = this.M.top;
    float f1 = this.t;
    float f2 = this.u;
    paramCanvas.drawText(str, f1, (paramInt - i1) / 2 + f2, this.j);
  }
  
  public void a()
  {
    postInvalidate();
  }
  
  public void b()
  {
    this.C.clearAnimation();
    this.D.clearAnimation();
    this.C.setVisibility(4);
    this.D.setVisibility(4);
    this.z = 0;
    this.E = false;
    this.F = 0;
    this.G = 0;
    this.r = 0.0F;
    this.o = this.k;
    this.q = this.k;
    this.p = (this.l / 2.0F);
    this.s = (this.l / 2.0F);
    this.w = 0.0F;
    this.v = 180.0F;
    this.x = 0.0F;
    this.y = 0.0F;
  }
  
  public void c()
  {
    b();
    removeCallbacks(this.H);
  }
  
  public void d()
  {
    postDelayed(this.H, 50L);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (l.a()) {
      this.F += 3;
    }
    for (;;)
    {
      if (this.F > c) {
        this.F = c;
      }
      a(paramCanvas, this.F);
      if (this.q <= this.k / 2.0F + this.m) {
        break;
      }
      this.q -= e;
      this.r += e;
      if (this.q < this.k / 2.0F + this.m) {
        this.q = (this.k / 2.0F + this.m);
      }
      if (this.r > this.k / 2.0F - this.m) {
        this.r = (this.k / 2.0F - this.m);
      }
      paramCanvas.drawLine(this.k, this.l / 2.0F, this.q, this.l / 2.0F, this.i);
      paramCanvas.drawLine(0.0F, this.l / 2.0F, this.r, this.l / 2.0F, this.h);
      return;
      this.G += 1;
      if (this.G % 4 == 0) {
        this.F += 1;
      }
    }
    paramCanvas.drawLine(this.k, this.l / 2.0F, this.q, this.l / 2.0F, this.i);
    paramCanvas.drawLine(0.0F, this.l / 2.0F, this.r, this.l / 2.0F, this.h);
    if (this.y > -90.0F)
    {
      this.y -= 15.0F;
      this.x -= 15.0F;
      if (this.y < -90.0F)
      {
        this.y = -90.0F;
        this.x = -90.0F;
      }
    }
    for (;;)
    {
      paramCanvas.drawArc(this.L, this.w, this.y, false, this.i);
      paramCanvas.drawArc(this.L, this.v, this.x, false, this.h);
      return;
      this.C.setVisibility(0);
      this.D.setVisibility(0);
      this.y -= 15.0F;
      this.x -= 15.0F;
      if (this.y < -180.0F)
      {
        this.y = -180.0F;
        this.x = -180.0F;
      }
      if (!this.E)
      {
        this.D.setVisibility(0);
        this.C.setVisibility(0);
        this.I.setInterpolator(this.K);
        this.C.startAnimation(this.I);
        this.J.setInterpolator(this.K);
        this.D.startAnimation(this.J);
        this.E = true;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.l = getMeasuredHeight();
    this.k = getMeasuredWidth();
    this.t = (this.k / 2.0F);
    this.u = (this.l / 2.0F);
    this.r = 0.0F;
    this.o = this.k;
    this.q = this.k;
    this.p = (this.l / 2.0F);
    this.s = (this.l / 2.0F);
    this.w = 0.0F;
    this.v = 180.0F;
    this.x = 0.0F;
    this.y = 0.0F;
    this.L.left = (this.t - this.m);
    this.L.top = (this.u - this.m);
    this.L.right = (this.t + this.m);
    this.L.bottom = (this.u + this.m);
    e = (this.t - this.m) / 6.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.d
 * JD-Core Version:    0.7.0.1
 */