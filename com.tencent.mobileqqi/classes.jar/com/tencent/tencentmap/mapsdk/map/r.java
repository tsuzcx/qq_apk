package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import java.lang.reflect.Method;

final class r
{
  private static final float p = (float)Math.cos(0.001745329278001762D);
  GestureDetector a = null;
  boolean b = true;
  boolean c = true;
  boolean d = true;
  boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private int h;
  private PointF i = new PointF();
  private PointF j = new PointF();
  private PointF k = new PointF();
  private PointF l = new PointF();
  private n m = null;
  private a n = null;
  private long o = 0L;
  private Method q;
  private Method r;
  
  public r(Context paramContext) {}
  
  private void a(PointF paramPointF1, PointF paramPointF2, MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.q == null)
      {
        this.q = MotionEvent.class.getMethod("getX", new Class[] { Integer.TYPE });
        this.r = MotionEvent.class.getMethod("getY", new Class[] { Integer.TYPE });
      }
      float f1 = ((Float)this.q.invoke(paramMotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
      float f2 = ((Float)this.q.invoke(paramMotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
      float f3 = ((Float)this.r.invoke(paramMotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
      float f4 = ((Float)this.r.invoke(paramMotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
      paramPointF1.set(f1, f3);
      paramPointF2.set(f2, f4);
      return;
    }
    catch (Exception paramPointF1) {}
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    float f1 = this.m.a.e() / 3.0F;
    float f2 = this.m.a.f() / 3.0F;
    return (Math.abs(paramFloat1 - this.m.a.e() / 2) < f1) && (Math.abs(paramFloat2 - this.m.a.f() / 2) < f2);
  }
  
  public final void a(n paramn)
  {
    this.m = paramn;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          if (this.f) {
            this.a.onTouchEvent(paramMotionEvent);
          }
          return true;
          this.o = 0L;
          this.f = true;
        }
        this.o = System.currentTimeMillis();
        this.g = true;
        this.h = 0;
        this.f = false;
        a(this.k, this.l, paramMotionEvent);
        return true;
        if (this.c == true)
        {
          long l1 = System.currentTimeMillis() - this.o;
          if ((this.h == 0) && (l1 > 0L) && (l1 < 200L))
          {
            float f1 = this.k.x;
            f1 = this.l.x;
            f1 = this.k.y;
            f1 = this.l.y;
          }
        }
      } while (!this.g);
      this.m.a.b(false);
      this.g = false;
      return true;
    } while (!this.g);
    a(this.i, this.j, paramMotionEvent);
    double d3 = this.i.x - this.k.x;
    double d4 = this.i.y - this.k.y;
    double d5 = this.j.x - this.l.x;
    double d6 = this.j.y - this.l.y;
    double d1;
    if ((this.d == true) && ((this.h == 0) || (this.h == 1))) {
      if (this.h == 0)
      {
        d1 = 24.0D;
        if (((Math.abs(d3) <= d1) && (Math.abs(d4) <= d1) && (Math.abs(d5) <= d1) && (Math.abs(d6) <= d1)) || (d4 * d6 <= 0.0D) || (Math.abs(d4) <= Math.abs(d3) * 1.2D) || (Math.abs(d6) <= Math.abs(d5) * 1.2D)) {
          break label490;
        }
        this.h = 1;
        this.k.set(this.i.x, this.i.y);
        this.l.set(this.j.x, this.j.y);
      }
    }
    label772:
    label1103:
    for (;;)
    {
      return true;
      d1 = 8.0D;
      break;
      label490:
      double d9 = this.l.x - this.k.x;
      double d10 = this.l.y - this.k.y;
      double d11 = this.j.x - this.i.x;
      double d12 = this.j.y - this.i.y;
      double d7 = Math.sqrt(d9 * d9 + d10 * d10);
      double d8 = Math.sqrt(d11 * d11 + d12 * d12);
      double d2;
      if ((this.e == true) && ((this.h == 0) || (this.h == 2)) && (d7 * d8 > 0.0D))
      {
        d1 = (d9 * d11 + d10 * d12) / (d7 * d8);
        if (Math.abs(d1) < p)
        {
          d2 = Math.acos(d1) * 180.0D / 3.141592653589793D;
          d1 = d2;
          if (d9 * d12 - d10 * d11 < 0.0D) {
            d1 = -d2;
          }
          if (this.h == 0) {}
          for (d2 = 13.0D;; d2 = 1.0D)
          {
            if (Math.abs(d1) <= d2) {
              break label772;
            }
            this.h = 2;
            this.k.set(this.i.x, this.i.y);
            this.l.set(this.j.x, this.j.y);
            break;
          }
        }
      }
      if ((this.c == true) && ((this.h == 0) || (this.h == 3)) && (d7 > 0.0D))
      {
        d2 = d8 / d7;
        if (this.h == 0) {}
        for (d1 = 0.1D;; d1 = 0.05D)
        {
          if (Math.abs(d2 - 1.0D) <= d1) {
            break label982;
          }
          this.h = 3;
          this.m.a.a(d2);
          if ((!a(this.k.x, this.k.y)) && (!a(this.l.x, this.l.y))) {
            a((this.k.x + this.l.x) / 2.0F, (this.k.y + this.l.y) / 2.0F);
          }
          this.k.set(this.i.x, this.i.y);
          this.l.set(this.j.x, this.j.y);
          break;
        }
      }
      label982:
      if ((this.h == 0) || (this.h == 4))
      {
        if (this.h == 0) {}
        for (d1 = 80.0D;; d1 = 8.0D)
        {
          if ((Math.abs(d3) <= d1) && (Math.abs(d4) <= d1) && (Math.abs(d5) <= d1) && (Math.abs(d6) <= d1)) {
            break label1103;
          }
          this.h = 4;
          this.k.set(this.i.x, this.i.y);
          this.l.set(this.j.x, this.j.y);
          break;
        }
      }
    }
  }
  
  final class a
    implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
  {
    a() {}
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      r.a(r.this).e.a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      return true;
    }
    
    public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      if (r.a(r.this).e != null) {
        r.a(r.this).e.a();
      }
      return true;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (r.a(r.this).e != null) {
        r.a(r.this).e.a((int)-paramFloat1 * 1 / 150, (int)-paramFloat2 * 1 / 150);
      }
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      if ((r.a(r.this) == null) || (r.a(r.this).b == null)) {}
      while (!r.a(r.this).b.c(paramMotionEvent)) {
        return;
      }
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      float f3 = r.a(r.this).a.b();
      float f2 = paramFloat1;
      float f1 = paramFloat2;
      if (f3 != 0.0F)
      {
        f2 = paramFloat1 / f3;
        f1 = paramFloat2 / f3;
      }
      r.a(r.this).d.scrollBy(f2, f1);
      r.a(r.this).c().a().invalidate();
      return true;
    }
    
    public final void onShowPress(MotionEvent paramMotionEvent) {}
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      boolean bool = r.a(r.this).b.b(paramMotionEvent);
      if (!bool)
      {
        paramMotionEvent = r.a(r.this).c.k.fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        r.a(r.this).b.a(paramMotionEvent);
      }
      return bool;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.r
 * JD-Core Version:    0.7.0.1
 */