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
      if (paramAnonymousMessage.what != 0) {
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
    this.h.setColor(this.n.getResources().getColor(2130968658));
    this.h.setAntiAlias(true);
    this.h.setStrokeWidth(3.0F);
    this.h.setStyle(Paint.Style.STROKE);
    this.i = new Paint();
    this.i.setColor(this.n.getResources().getColor(2130968658));
    this.i.setAntiAlias(true);
    this.i.setStrokeWidth(3.0F);
    this.i.setStyle(Paint.Style.STROKE);
    this.j = new Paint();
    this.j.setColor(this.n.getResources().getColor(2130968658));
    this.j.setAntiAlias(true);
    this.j.setStrokeWidth(1.0F);
    this.j.setStyle(Paint.Style.FILL);
    this.m = (BitmapFactory.decodeResource(getResources(), 2131099791).getWidth() / 2);
    this.I = AnimationUtils.loadAnimation(this.n, 2130771982);
    this.J = AnimationUtils.loadAnimation(this.n, 2130771981);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    if (this.z < paramInt)
    {
      i1 = this.N.nextInt(5);
      this.z += i1 + 1;
      if (this.z > paramInt) {
        this.z = paramInt;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.z);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    this.j.setTextAlign(Paint.Align.CENTER);
    this.j.setTextSize(45.0F);
    this.j.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.M);
    paramInt = this.M.bottom;
    int i1 = this.M.top;
    paramCanvas.drawText((String)localObject, this.t, this.u + (paramInt - i1) / 2, this.j);
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
    float f1 = this.k;
    this.o = f1;
    this.q = f1;
    f1 = this.l;
    this.p = (f1 / 2.0F);
    this.s = (f1 / 2.0F);
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
    if (l.a())
    {
      this.F += 3;
    }
    else
    {
      this.G += 1;
      if (this.G % 4 == 0) {
        this.F += 1;
      }
    }
    int i1 = this.F;
    int i2 = c;
    if (i1 > i2) {
      this.F = i2;
    }
    a(paramCanvas, this.F);
    float f1 = this.q;
    float f2 = this.k;
    float f4 = f2 / 2.0F;
    float f3 = this.m;
    if (f1 > f4 + f3)
    {
      f4 = e;
      this.q = (f1 - f4);
      this.r += f4;
      if (this.q < f2 / 2.0F + f3) {
        this.q = (f2 / 2.0F + f3);
      }
      f1 = this.r;
      f2 = this.k;
      f3 = f2 / 2.0F;
      f4 = this.m;
      if (f1 > f3 - f4) {
        this.r = (f2 / 2.0F - f4);
      }
      f1 = this.k;
      f2 = this.l;
      paramCanvas.drawLine(f1, f2 / 2.0F, this.q, f2 / 2.0F, this.i);
      f1 = this.l;
      paramCanvas.drawLine(0.0F, f1 / 2.0F, this.r, f1 / 2.0F, this.h);
      return;
    }
    f3 = this.l;
    paramCanvas.drawLine(f2, f3 / 2.0F, f1, f3 / 2.0F, this.i);
    f1 = this.l;
    paramCanvas.drawLine(0.0F, f1 / 2.0F, this.r, f1 / 2.0F, this.h);
    f1 = this.y;
    if (f1 > -90.0F)
    {
      this.y = (f1 - 15.0F);
      this.x -= 15.0F;
      if (this.y < -90.0F)
      {
        this.y = -90.0F;
        this.x = -90.0F;
      }
    }
    else
    {
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
    paramCanvas.drawArc(this.L, this.w, this.y, false, this.i);
    paramCanvas.drawArc(this.L, this.v, this.x, false, this.h);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.l = getMeasuredHeight();
    this.k = getMeasuredWidth();
    float f1 = this.k;
    this.t = (f1 / 2.0F);
    float f2 = this.l;
    this.u = (f2 / 2.0F);
    this.r = 0.0F;
    this.o = f1;
    this.q = f1;
    this.p = (f2 / 2.0F);
    this.s = (f2 / 2.0F);
    this.w = 0.0F;
    this.v = 180.0F;
    this.x = 0.0F;
    this.y = 0.0F;
    RectF localRectF = this.L;
    f1 = this.t;
    f2 = this.m;
    localRectF.left = (f1 - f2);
    float f3 = this.u;
    localRectF.top = (f3 - f2);
    localRectF.right = (f1 + f2);
    localRectF.bottom = (f3 + f2);
    e = (f1 - f2) / 6.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.d
 * JD-Core Version:    0.7.0.1
 */