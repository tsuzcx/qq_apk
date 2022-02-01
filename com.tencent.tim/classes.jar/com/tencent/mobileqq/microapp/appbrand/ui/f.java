package com.tencent.mobileqq.microapp.appbrand.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;

public final class f
{
  Object a;
  a b;
  
  private f(int paramInt, Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInt >= 14) {
      this.b = new d();
    }
    for (;;)
    {
      this.a = this.b.a(paramContext, paramInterpolator);
      return;
      if (paramInt >= 9) {
        this.b = new c();
      } else {
        this.b = new b();
      }
    }
  }
  
  f(Context paramContext, Interpolator paramInterpolator)
  {
    this(Build.VERSION.SDK_INT, paramContext, paramInterpolator);
  }
  
  public static int a(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrX();
  }
  
  public static f a(Context paramContext, Interpolator paramInterpolator)
  {
    return new f(paramContext, paramInterpolator);
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public static int b(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrY();
  }
  
  public static Object b(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      return new OverScroller(paramContext, paramInterpolator);
    }
    return new OverScroller(paramContext);
  }
  
  public static boolean c(Object paramObject)
  {
    return ((OverScroller)paramObject).computeScrollOffset();
  }
  
  public static void d(Object paramObject)
  {
    ((OverScroller)paramObject).abortAnimation();
  }
  
  public static int e(Object paramObject)
  {
    return ((OverScroller)paramObject).getFinalX();
  }
  
  public static int f(Object paramObject)
  {
    return ((OverScroller)paramObject).getFinalY();
  }
  
  public int a()
  {
    return this.b.a(this.a);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int b()
  {
    return this.b.b(this.a);
  }
  
  public int c()
  {
    return this.b.e(this.a);
  }
  
  public int d()
  {
    return this.b.f(this.a);
  }
  
  public boolean e()
  {
    return this.b.c(this.a);
  }
  
  public void f()
  {
    this.b.d(this.a);
  }
  
  static abstract interface a
  {
    public abstract int a(Object paramObject);
    
    public abstract Object a(Context paramContext, Interpolator paramInterpolator);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract int b(Object paramObject);
    
    public abstract boolean c(Object paramObject);
    
    public abstract void d(Object paramObject);
    
    public abstract int e(Object paramObject);
    
    public abstract int f(Object paramObject);
  }
  
  static final class b
    implements f.a
  {
    public int a(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrX();
    }
    
    public Object a(Context paramContext, Interpolator paramInterpolator)
    {
      if (paramInterpolator != null) {
        return new Scroller(paramContext, paramInterpolator);
      }
      return new Scroller(paramContext);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public int b(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrY();
    }
    
    public boolean c(Object paramObject)
    {
      return ((Scroller)paramObject).computeScrollOffset();
    }
    
    public void d(Object paramObject)
    {
      ((Scroller)paramObject).abortAnimation();
    }
    
    public int e(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalX();
    }
    
    public int f(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalY();
    }
  }
  
  static class c
    implements f.a
  {
    public int a(Object paramObject)
    {
      return f.a(paramObject);
    }
    
    public Object a(Context paramContext, Interpolator paramInterpolator)
    {
      return f.b(paramContext, paramInterpolator);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      f.a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public int b(Object paramObject)
    {
      return f.b(paramObject);
    }
    
    public boolean c(Object paramObject)
    {
      return f.c(paramObject);
    }
    
    public void d(Object paramObject)
    {
      f.d(paramObject);
    }
    
    public int e(Object paramObject)
    {
      return f.e(paramObject);
    }
    
    public int f(Object paramObject)
    {
      return f.f(paramObject);
    }
  }
  
  static final class d
    extends f.c
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.f
 * JD-Core Version:    0.7.0.1
 */