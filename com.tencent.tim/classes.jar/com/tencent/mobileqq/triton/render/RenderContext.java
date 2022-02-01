package com.tencent.mobileqq.triton.render;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.view.Surface;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.render.c.b;
import com.tencent.mobileqq.triton.render.c.c;
import com.tencent.mobileqq.triton.render.c.d;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.touch.TouchEventManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JNIModule
public class RenderContext
{
  private ArrayList<a> a;
  private TTEngine b;
  private Context c;
  private boolean d;
  private int e;
  private int f;
  private int g;
  private int h;
  private float i;
  private a j;
  private volatile TouchEventManager k;
  
  public RenderContext(TTEngine paramTTEngine, Context paramContext)
  {
    this.b = paramTTEngine;
    this.c = paramContext.getApplicationContext();
    this.d = a(this.c);
    this.a = new ArrayList();
    TTLog.b("RenderContext", "initialize:" + this);
  }
  
  private boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        m = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
        if (m < 196608) {
          continue;
        }
        m = 1;
      }
      catch (Exception paramContext)
      {
        TTLog.b("RenderContext", "get support ES3 error! " + paramContext.getMessage());
        int m = 0;
        continue;
      }
      if ((!this.b.l().enableOpengles3()) || (m == 0)) {
        break label84;
      }
      return true;
      m = 0;
    }
    label84:
    return false;
  }
  
  @TTNativeCall
  private void onRenderContextInit()
  {
    this.b.a(0);
  }
  
  @TTNativeCall
  private void onSwapBuffer()
  {
    if (this.b.m() == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.m().d().iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a();
      }
    }
  }
  
  public <T extends a> T a(Class<T> paramClass)
  {
    if (paramClass != null)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (paramClass.isInstance(locala)) {
          return locala;
        }
      }
    }
    return null;
  }
  
  public a a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat)
  {
    a(paramInt1, paramInt2, paramFloat);
    this.k = new TouchEventManager(this.b, paramFloat);
    this.j = new a(paramActivity, this);
    a(new b(this.b, this.j, this.c));
    a(new com.tencent.mobileqq.triton.render.c.a(this.b));
    a(new c(this.b));
    a(new d(this.b));
    return this.j;
  }
  
  public void a()
  {
    com.tencent.mobileqq.triton.jni.a.d(this, this.b.k());
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramFloat;
  }
  
  public void a(Surface paramSurface)
  {
    long l = this.b.k();
    boolean bool = this.d;
    float f1 = this.g;
    float f2 = this.i;
    com.tencent.mobileqq.triton.jni.a.a(this, l, paramSurface, bool, (int)(f1 / f2), (int)(this.h / f2), f2);
  }
  
  public void a(a parama)
  {
    this.a.add(parama);
  }
  
  public int b()
  {
    return this.f;
  }
  
  public void b(Surface paramSurface)
  {
    com.tencent.mobileqq.triton.jni.a.a(this, this.b.k(), paramSurface);
  }
  
  public int c()
  {
    return this.e;
  }
  
  public List<a> d()
  {
    return this.a;
  }
  
  public TouchEventManager e()
  {
    return this.k;
  }
  
  public void f()
  {
    com.tencent.mobileqq.triton.jni.a.a(this, this.b.k());
    this.a.clear();
    this.j = null;
    if (this.k != null)
    {
      this.k.c();
      this.k = null;
    }
    this.c = null;
  }
  
  public native void nExit(long paramLong);
  
  public native void nInitRenderContext(long paramLong, Surface paramSurface, boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat);
  
  public native void nOnPause(long paramLong);
  
  public native void nOnResume(long paramLong);
  
  public native void nSurfaceChanged(long paramLong, Surface paramSurface);
  
  public native void nSurfaceDestroyed(long paramLong);
  
  public native void nUpdateRenderContext(long paramLong);
  
  @TTNativeCall
  public void setFixedSize(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    TTLog.c("RenderContext", "setFixedSize mCanvasWidth=" + paramInt1 + ", mCanvasHeight=" + paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.RenderContext
 * JD-Core Version:    0.7.0.1
 */