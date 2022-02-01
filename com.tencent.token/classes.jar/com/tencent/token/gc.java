package com.tencent.token;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class gc
  implements View.OnTouchListener
{
  private static final int r = ;
  final a a = new a();
  final View b;
  boolean c;
  boolean d;
  boolean e;
  private final Interpolator f = new AccelerateInterpolator();
  private Runnable g;
  private float[] h = { 0.0F, 0.0F };
  private float[] i = { 3.4028235E+38F, 3.4028235E+38F };
  private int j;
  private int k;
  private float[] l = { 0.0F, 0.0F };
  private float[] m = { 0.0F, 0.0F };
  private float[] n = { 3.4028235E+38F, 3.4028235E+38F };
  private boolean o;
  private boolean p;
  private boolean q;
  
  public gc(View paramView)
  {
    this.b = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i1 = (int)(paramView.density * 1575.0F + 0.5F);
    int i2 = (int)(paramView.density * 315.0F + 0.5F);
    float f1 = i1;
    paramView = this.n;
    f1 /= 1000.0F;
    paramView[0] = f1;
    paramView[1] = f1;
    f1 = i2;
    paramView = this.m;
    f1 /= 1000.0F;
    paramView[0] = f1;
    paramView[1] = f1;
    this.j = 1;
    paramView = this.i;
    paramView[0] = 3.4028235E+38F;
    paramView[1] = 3.4028235E+38F;
    paramView = this.h;
    paramView[0] = 0.2F;
    paramView[1] = 0.2F;
    paramView = this.l;
    paramView[0] = 0.001F;
    paramView[1] = 0.001F;
    this.k = r;
    paramView = this.a;
    paramView.a = 500;
    paramView.b = 500;
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {
      return 0.0F;
    }
    int i1 = this.j;
    switch (i1)
    {
    default: 
      return 0.0F;
    case 2: 
      if (paramFloat1 < 0.0F) {
        return paramFloat1 / -paramFloat2;
      }
      break;
    case 0: 
    case 1: 
      if (paramFloat1 < paramFloat2)
      {
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
        if ((this.e) && (i1 == 1)) {
          return 1.0F;
        }
      }
      break;
    }
    return 0.0F;
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = a(paramFloat1 * paramFloat2, 0.0F, paramFloat3);
    paramFloat3 = a(paramFloat4, paramFloat1);
    paramFloat1 = a(paramFloat2 - paramFloat4, paramFloat1) - paramFloat3;
    if (paramFloat1 < 0.0F)
    {
      paramFloat1 = -this.f.getInterpolation(-paramFloat1);
    }
    else
    {
      if (paramFloat1 <= 0.0F) {
        break label76;
      }
      paramFloat1 = this.f.getInterpolation(paramFloat1);
    }
    return a(paramFloat1, -1.0F, 1.0F);
    label76:
    return 0.0F;
  }
  
  private float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = a(this.h[paramInt], paramFloat2, this.i[paramInt], paramFloat1);
    if (paramFloat1 == 0.0F) {
      return 0.0F;
    }
    float f2 = this.l[paramInt];
    paramFloat2 = this.m[paramInt];
    float f1 = this.n[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return a(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -a(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  private void b()
  {
    if (this.c)
    {
      this.e = false;
      return;
    }
    this.a.a();
  }
  
  public final gc a(boolean paramBoolean)
  {
    if ((this.p) && (!paramBoolean)) {
      b();
    }
    this.p = paramBoolean;
    return this;
  }
  
  public abstract void a(int paramInt);
  
  final boolean a()
  {
    a locala = this.a;
    int i1 = locala.c();
    locala.b();
    return (i1 != 0) && (b(i1));
  }
  
  public abstract boolean b(int paramInt);
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.p) {
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      break;
    case 1: 
    case 3: 
      b();
      break;
    case 0: 
      this.d = true;
      this.o = false;
    case 2: 
      float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), this.b.getWidth());
      float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), this.b.getHeight());
      paramView = this.a;
      paramView.c = f1;
      paramView.d = f2;
      if ((!this.e) && (a()))
      {
        if (this.g == null) {
          this.g = new b();
        }
        this.e = true;
        this.c = true;
        if (!this.o)
        {
          int i1 = this.k;
          if (i1 > 0)
          {
            fo.a(this.b, this.g, i1);
            break label214;
          }
        }
        this.g.run();
        label214:
        this.o = true;
      }
      break;
    }
    return (this.q) && (this.e);
  }
  
  static final class a
  {
    int a;
    int b;
    float c;
    float d;
    long e = -9223372036854775808L;
    long f = 0L;
    int g = 0;
    int h = 0;
    long i = -1L;
    float j;
    int k;
    
    final float a(long paramLong)
    {
      if (paramLong < this.e) {
        return 0.0F;
      }
      long l = this.i;
      if ((l >= 0L) && (paramLong >= l))
      {
        float f1 = this.j;
        return 1.0F - f1 + f1 * gc.a((float)(paramLong - l) / this.k, 0.0F, 1.0F);
      }
      return gc.a((float)(paramLong - this.e) / this.a, 0.0F, 1.0F) * 0.5F;
    }
    
    public final void a()
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.k = gc.a((int)(l - this.e), this.b);
      this.j = a(l);
      this.i = l;
    }
    
    public final int b()
    {
      float f1 = this.c;
      return (int)(f1 / Math.abs(f1));
    }
    
    public final int c()
    {
      float f1 = this.d;
      return (int)(f1 / Math.abs(f1));
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      if (!gc.this.e) {
        return;
      }
      if (gc.this.c)
      {
        localObject = gc.this;
        ((gc)localObject).c = false;
        localObject = ((gc)localObject).a;
        ((gc.a)localObject).e = AnimationUtils.currentAnimationTimeMillis();
        ((gc.a)localObject).i = -1L;
        ((gc.a)localObject).f = ((gc.a)localObject).e;
        ((gc.a)localObject).j = 0.5F;
        ((gc.a)localObject).g = 0;
        ((gc.a)localObject).h = 0;
      }
      Object localObject = gc.this.a;
      int i;
      if ((((gc.a)localObject).i > 0L) && (AnimationUtils.currentAnimationTimeMillis() > ((gc.a)localObject).i + ((gc.a)localObject).k)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) && (gc.this.a()))
      {
        long l1;
        if (gc.this.d)
        {
          gc localgc = gc.this;
          localgc.d = false;
          l1 = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
          localgc.b.onTouchEvent(localMotionEvent);
          localMotionEvent.recycle();
        }
        if (((gc.a)localObject).f != 0L)
        {
          l1 = AnimationUtils.currentAnimationTimeMillis();
          float f = ((gc.a)localObject).a(l1);
          long l2 = ((gc.a)localObject).f;
          ((gc.a)localObject).f = l1;
          f = (float)(l1 - l2) * (-4.0F * f * f + f * 4.0F);
          ((gc.a)localObject).g = ((int)(((gc.a)localObject).c * f));
          ((gc.a)localObject).h = ((int)(f * ((gc.a)localObject).d));
          i = ((gc.a)localObject).h;
          gc.this.a(i);
          fo.a(gc.this.b, this);
          return;
        }
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      gc.this.e = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gc
 * JD-Core Version:    0.7.0.1
 */