package com.tencent.map.sdk.a;

import android.annotation.TargetApi;
import android.opengl.GLUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public final class pl
  extends Thread
{
  private static int d = 60;
  private static long p = 1500L;
  private WeakReference<pn> a;
  private AtomicBoolean b = new AtomicBoolean(true);
  private AtomicBoolean c = new AtomicBoolean(false);
  private byte[] e = new byte[0];
  private WeakReference<Object> f;
  private volatile boolean g = false;
  private EGLConfig h = null;
  private EGL10 i;
  private EGLDisplay j = EGL10.EGL_NO_DISPLAY;
  private EGLContext k = EGL10.EGL_NO_CONTEXT;
  private EGLSurface l = EGL10.EGL_NO_SURFACE;
  private GL m;
  private volatile long n = 0L;
  private boolean o = false;
  
  public pl(Object paramObject, pn parampn)
  {
    this.f = new WeakReference(paramObject);
    this.a = new WeakReference(parampn);
  }
  
  @TargetApi(14)
  private void e()
  {
    while (this.b.get())
    {
      f();
      try
      {
        if (this.f == null) {
          break;
        }
        if (this.f.get() == null) {
          return;
        }
        this.l = this.i.eglCreateWindowSurface(this.j, this.h, this.f.get(), null);
        if (this.l != EGL10.EGL_NO_SURFACE) {
          break label136;
        }
        Log.e("tencentmap_glthread", "eglCreateWindowSurface failed,errorDetail:" + GLUtils.getEGLErrorString(this.i.eglGetError()));
      }
      catch (Throwable localThrowable)
      {
        Log.e("tencentmap_glthread", "updateSurface failed,errorDetail:" + Log.getStackTraceString(localThrowable));
      }
      continue;
      label136:
      if (this.i.eglMakeCurrent(this.j, this.l, this.l, this.k)) {
        break;
      }
      Log.e("tencentmap_glthread", "eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.i.eglGetError()));
    }
  }
  
  private void f()
  {
    if ((this.l == null) || (this.l == EGL10.EGL_NO_SURFACE)) {
      return;
    }
    this.i.eglDestroySurface(this.j, this.l);
    this.l = EGL10.EGL_NO_SURFACE;
  }
  
  public final void a()
  {
    this.c.set(true);
    synchronized (this.e)
    {
      this.e.notifyAll();
      return;
    }
  }
  
  public final void a(Object paramObject)
  {
    this.f = new WeakReference(paramObject);
    this.g = true;
  }
  
  public final void b()
  {
    this.c.set(false);
    synchronized (this.e)
    {
      this.e.notifyAll();
      return;
    }
  }
  
  public final void c()
  {
    this.b.set(false);
    this.c.set(false);
    synchronized (this.e)
    {
      this.e.notifyAll();
      interrupt();
      return;
    }
  }
  
  public final void d()
  {
    this.o = true;
    this.n = System.currentTimeMillis();
  }
  
  public final void run()
  {
    super.run();
    if (this.b.get()) {}
    label230:
    Object localObject6;
    label687:
    do
    {
      for (;;)
      {
        try
        {
          if (this.f != null)
          {
            ??? = this.f.get();
            if (??? != null) {}
          }
          else
          {
            if (!this.b.get()) {
              break label845;
            }
            try
            {
              synchronized (this.e)
              {
                if (!this.c.get()) {
                  break label687;
                }
                this.e.wait();
              }
              if (this.b.get()) {
                continue;
              }
            }
            catch (Throwable localThrowable1) {}
            if ((localThrowable1 instanceof InterruptedException)) {
              continue;
            }
            Log.e("tencentmap_glthread", "TextureGLRenderThread Render Exception:" + Log.getStackTraceString(localThrowable1));
            continue;
          }
          Object localObject2 = this.f.get();
          this.i = ((EGL10)EGLContext.getEGL());
          this.j = this.i.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
          if (this.j != EGL10.EGL_NO_DISPLAY) {
            break label230;
          }
          Log.e("tencentmap_glthread", "eglGetdisplay failed,mEglDisplay == EGL10.EGL_NO_DISPLAY,errorDetail:" + GLUtils.getEGLErrorString(this.i.eglGetError()));
        }
        catch (Throwable localThrowable2)
        {
          Log.e("tencentmap_glthread", "initializeGLContext failed,errorDetail:" + Log.getStackTraceString(localThrowable2));
        }
        break;
        localObject6 = new int[2];
        if (!this.i.eglInitialize(this.j, (int[])localObject6))
        {
          Log.e("tencentmap_glthread", "eglInitialize failed,errorDetail:" + GLUtils.getEGLErrorString(this.i.eglGetError()));
          break;
        }
        localObject6 = new int[1];
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
        if (!this.i.eglChooseConfig(this.j, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12352, 4, 12344 }, arrayOfEGLConfig, 1, (int[])localObject6))
        {
          Log.e("tencentmap_glthread", "eglChooseConfig failed,errorDetail:" + GLUtils.getEGLErrorString(this.i.eglGetError()));
          break;
        }
        this.h = arrayOfEGLConfig[0];
        this.l = this.i.eglCreateWindowSurface(this.j, this.h, localThrowable2, null);
        if (this.l == EGL10.EGL_NO_SURFACE)
        {
          Log.e("tencentmap_glthread", "eglCreateWindowSurface failed,mEglSurface == EGL10.EGL_NO_SURFACE,errorDetail:" + GLUtils.getEGLErrorString(this.i.eglGetError()));
          break;
        }
        this.k = this.i.eglCreateContext(this.j, arrayOfEGLConfig[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
        if (this.k == EGL10.EGL_NO_CONTEXT)
        {
          Log.e("tencentmap_glthread", "eglCreateContext failed,mEglContext == EGL10.EGL_NO_CONTEXT,errorDetail:" + GLUtils.getEGLErrorString(this.i.eglGetError()));
          break;
        }
        if (!this.i.eglMakeCurrent(this.j, this.l, this.l, this.k))
        {
          Log.e("tencentmap_glthread", "eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.i.eglGetError()));
          break;
        }
        this.m = this.k.getGL();
      }
      if (this.g)
      {
        e();
        this.o = true;
        this.g = false;
        d();
      }
    } while ((this.a == null) || (this.a.get() == null));
    pn localpn = (pn)this.a.get();
    if ((this.o) && (System.currentTimeMillis() - this.n < p)) {
      if (localpn != null) {
        localpn.t();
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((localpn != null) && (localpn.a((GL10)this.m))) {
          this.i.eglSwapBuffers(this.j, this.l);
        }
        try
        {
          wait(1000 / d);
          break;
        }
        finally {}
      }
      this.o = false;
      this.n = 0L;
    }
    label845:
    Object localObject4;
    if ((this.a != null) && (this.a.get() != null))
    {
      localObject6 = (pn)this.a.get();
      localObject4 = new byte[1];
      ((pn)localObject6).a((byte[])localObject4);
    }
    for (;;)
    {
      try
      {
        localObject4.wait(1000L);
        ((pn)localObject6).r();
        this.a = null;
        f();
        if ((this.k == null) || (this.k == EGL10.EGL_NO_CONTEXT))
        {
          if (this.j != null) {
            localObject4 = EGL10.EGL_NO_DISPLAY;
          }
          this.i.eglTerminate(this.j);
          this.j = EGL10.EGL_NO_DISPLAY;
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        or.b(Log.getStackTraceString(localInterruptedException));
        Thread.currentThread().interrupt();
        continue;
      }
      finally {}
      this.i.eglDestroyContext(this.j, this.k);
      this.k = EGL10.EGL_NO_CONTEXT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pl
 * JD-Core Version:    0.7.0.1
 */