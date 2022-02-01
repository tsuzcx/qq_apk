package com.tencent.map.sdk.a;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class pv
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  static final j a = new j((byte)0);
  i b;
  private final WeakReference<pv> c = new WeakReference(this);
  private m d;
  private boolean e;
  private e f;
  private f g;
  private g h;
  private k i;
  private int j;
  private int k;
  private boolean l;
  
  public pv(Context paramContext)
  {
    super(paramContext);
    getHolder().addCallback(this);
  }
  
  private void b()
  {
    if (this.b != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.b != null) {
        this.b.c();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.j;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.l;
  }
  
  public int getRenderMode()
  {
    return this.b.b();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.e) && (this.d != null)) {
      if (this.b == null) {
        break label74;
      }
    }
    label74:
    for (int m = this.b.b();; m = 1)
    {
      this.b = new i(this.c);
      if (m != 1) {
        this.b.a(m);
      }
      this.b.start();
      this.e = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.b != null) {
      this.b.c();
    }
    this.e = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    i locali = this.b;
    synchronized (a)
    {
      locali.b = true;
      a.notifyAll();
      for (;;)
      {
        if (!locali.a)
        {
          boolean bool = locali.c;
          if (!bool) {
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    i locali = this.b;
    synchronized (a)
    {
      locali.b = false;
      locali.l = true;
      locali.m = false;
      a.notifyAll();
      for (;;)
      {
        if ((!locali.a) && (locali.c))
        {
          boolean bool = locali.m;
          if (!bool) {
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setEGLConfigChooser(e parame)
  {
    b();
    this.f = parame;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new n(paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    b();
    this.k = paramInt;
  }
  
  public void setEGLContextFactory(f paramf)
  {
    b();
    this.g = paramf;
  }
  
  public void setEGLWindowSurfaceFactory(g paramg)
  {
    b();
    this.h = paramg;
  }
  
  public void setGLWrapper(k paramk)
  {
    this.i = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setRenderer(m paramm)
  {
    b();
    if (this.f == null) {
      this.f = new n(true);
    }
    if (this.g == null) {
      this.g = new c((byte)0);
    }
    if (this.h == null) {
      this.h = new d((byte)0);
    }
    this.d = paramm;
    this.b = new i(this.c);
    this.b.start();
  }
  
  public void surfaceChanged(SurfaceHolder arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    i locali = this.b;
    for (;;)
    {
      synchronized (a)
      {
        locali.j = paramInt2;
        locali.k = paramInt3;
        locali.n = true;
        locali.l = true;
        locali.m = false;
        a.notifyAll();
        if ((locali.a) || (locali.c) || (locali.m)) {
          break;
        }
        if ((locali.f) && (locali.g))
        {
          boolean bool = locali.a();
          if (bool)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break;
            }
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      paramInt1 = 0;
    }
  }
  
  public void surfaceCreated(SurfaceHolder arg1)
  {
    i locali = this.b;
    synchronized (a)
    {
      locali.d = true;
      locali.h = false;
      a.notifyAll();
      for (;;)
      {
        if ((locali.e) && (!locali.h))
        {
          boolean bool = locali.a;
          if (!bool) {
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    i locali = this.b;
    synchronized (a)
    {
      locali.d = false;
      a.notifyAll();
      for (;;)
      {
        if (!locali.e)
        {
          boolean bool = locali.a;
          if (!bool) {
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  abstract class a
    implements pv.e
  {
    protected int[] a;
    
    public a(int[] paramArrayOfInt)
    {
      if (pv.a(pv.this) != 2) {}
      for (;;)
      {
        this.a = paramArrayOfInt;
        return;
        this$1 = new int[15];
        System.arraycopy(paramArrayOfInt, 0, pv.this, 0, 12);
        pv.this[12] = 12352;
        pv.this[13] = 4;
        pv.this[14] = 12344;
        paramArrayOfInt = pv.this;
      }
    }
    
    public final EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.a, arrayOfEGLConfig, i, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null) {
        throw new IllegalArgumentException("No config chosen");
      }
      return paramEGL10;
    }
    
    abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
  }
  
  class b
    extends pv.a
  {
    protected int c = 8;
    protected int d = 8;
    protected int e = 8;
    protected int f;
    protected int g;
    protected int h;
    private int[] j = new int[1];
    
    public b(int paramInt1, int paramInt2)
    {
      super(new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, paramInt1, 12325, paramInt2, 12326, 0, 12344 });
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = 0;
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
    {
      int k = 0;
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.j)) {
        k = this.j[0];
      }
      return k;
    }
    
    public final EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int m = paramArrayOfEGLConfig.length;
      int k = 0;
      while (k < m)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[k];
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
        if ((n >= this.g) && (i1 >= this.h))
        {
          n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int i2 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i3 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          if ((n == this.c) && (i1 == this.d) && (i2 == this.e) && (i3 == this.f)) {
            return localEGLConfig;
          }
        }
        k += 1;
      }
      return null;
    }
  }
  
  final class c
    implements pv.f
  {
    private int b = 12440;
    
    private c() {}
    
    public final EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.b;
      arrayOfInt[1] = pv.a(pv.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (pv.a(pv.this) != 0) {}
      for (;;)
      {
        return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        arrayOfInt = null;
      }
    }
    
    public final void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
        paramEGL10.eglGetError();
        pv.h.a("eglDestroyContex");
      }
    }
  }
  
  static final class d
    implements pv.g
  {
    public final EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        Log.e("GLSurfaceView", "eglCreateWindowSurface", paramEGL10);
        return null;
      }
      catch (OutOfMemoryError paramEGL10) {}
      return null;
    }
    
    public final void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  public static abstract interface e
  {
    public abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface f
  {
    public abstract EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface g
  {
    public abstract EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  static final class h
  {
    WeakReference<pv> a;
    EGL10 b;
    EGLDisplay c;
    EGLSurface d;
    EGLConfig e;
    EGLContext f;
    
    public h(WeakReference<pv> paramWeakReference)
    {
      this.a = paramWeakReference;
    }
    
    public static void a(String paramString)
    {
      throw new RuntimeException(b(paramString));
    }
    
    public static void a(String paramString1, String paramString2)
    {
      Log.w(paramString1, b(paramString2));
    }
    
    private static String b(String paramString)
    {
      return paramString + " failed: ";
    }
    
    final void a()
    {
      if ((this.d != null) && (this.d != EGL10.EGL_NO_SURFACE))
      {
        Object localObject = this.b;
        EGLDisplay localEGLDisplay = this.c;
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        localObject = (pv)this.a.get();
        if (localObject != null) {
          pv.d((pv)localObject).a(this.b, this.c, this.d);
        }
        this.d = null;
      }
    }
    
    public final void b()
    {
      if (this.f != null)
      {
        pv localpv = (pv)this.a.get();
        if (localpv != null) {
          pv.c(localpv).a(this.b, this.c, this.f);
        }
        this.f = null;
      }
      if (this.c != null)
      {
        this.b.eglTerminate(this.c);
        this.c = null;
      }
    }
  }
  
  static final class i
    extends Thread
  {
    boolean a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    int j = 0;
    int k = 0;
    boolean l = true;
    boolean m;
    boolean n = true;
    private boolean o;
    private boolean p;
    private int q = 1;
    private ArrayList<Runnable> r = new ArrayList();
    private pv.h s;
    private WeakReference<pv> t;
    
    i(WeakReference<pv> paramWeakReference)
    {
      this.t = paramWeakReference;
    }
    
    private void d()
    {
      if (this.g)
      {
        this.g = false;
        this.s.a();
      }
    }
    
    private void e()
    {
      if (this.f)
      {
        this.s.b();
        this.f = false;
        pv.a().c(this);
      }
    }
    
    /* Error */
    private void f()
      throws InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: new 67	com/tencent/map/sdk/a/pv$h
      //   4: dup
      //   5: aload_0
      //   6: getfield 55	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 89	com/tencent/map/sdk/a/pv$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 65	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 71	com/tencent/map/sdk/a/pv$i:f	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 63	com/tencent/map/sdk/a/pv$i:g	Z
      //   25: iconst_0
      //   26: istore_3
      //   27: iconst_0
      //   28: istore 4
      //   30: aconst_null
      //   31: astore 20
      //   33: aconst_null
      //   34: astore 19
      //   36: iconst_0
      //   37: istore 8
      //   39: iconst_0
      //   40: istore 5
      //   42: iconst_0
      //   43: istore_2
      //   44: iconst_0
      //   45: istore 7
      //   47: iconst_0
      //   48: istore 9
      //   50: iconst_0
      //   51: istore_1
      //   52: iconst_0
      //   53: istore 6
      //   55: iconst_0
      //   56: istore 10
      //   58: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   61: astore 21
      //   63: aload 21
      //   65: monitorenter
      //   66: iload 5
      //   68: istore 12
      //   70: aload_0
      //   71: getfield 91	com/tencent/map/sdk/a/pv$i:o	Z
      //   74: ifeq +57 -> 131
      //   77: aload_0
      //   78: getfield 55	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
      //   81: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   84: checkcast 6	com/tencent/map/sdk/a/pv
      //   87: astore 19
      //   89: aload 19
      //   91: ifnull +9 -> 100
      //   94: aload 19
      //   96: invokestatic 100	com/tencent/map/sdk/a/pv:g	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$m;
      //   99: pop
      //   100: aload 21
      //   102: monitorexit
      //   103: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   106: astore 19
      //   108: aload 19
      //   110: monitorenter
      //   111: aload_0
      //   112: invokespecial 102	com/tencent/map/sdk/a/pv$i:d	()V
      //   115: aload_0
      //   116: invokespecial 104	com/tencent/map/sdk/a/pv$i:e	()V
      //   119: aload 19
      //   121: monitorexit
      //   122: return
      //   123: astore 20
      //   125: aload 19
      //   127: monitorexit
      //   128: aload 20
      //   130: athrow
      //   131: aload_0
      //   132: getfield 43	com/tencent/map/sdk/a/pv$i:r	Ljava/util/ArrayList;
      //   135: invokevirtual 108	java/util/ArrayList:isEmpty	()Z
      //   138: ifne +113 -> 251
      //   141: aload_0
      //   142: getfield 43	com/tencent/map/sdk/a/pv$i:r	Ljava/util/ArrayList;
      //   145: iconst_0
      //   146: invokevirtual 112	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   149: checkcast 114	java/lang/Runnable
      //   152: astore 19
      //   154: iload 4
      //   156: istore 11
      //   158: iload 10
      //   160: istore 5
      //   162: iload 6
      //   164: istore 4
      //   166: iload_3
      //   167: istore 10
      //   169: iload 12
      //   171: istore_3
      //   172: iload 7
      //   174: istore 6
      //   176: iload 10
      //   178: istore 7
      //   180: iload 8
      //   182: istore 10
      //   184: iload 11
      //   186: istore 8
      //   188: aload 21
      //   190: monitorexit
      //   191: aload 19
      //   193: ifnull +868 -> 1061
      //   196: aload 19
      //   198: invokeinterface 117 1 0
      //   203: iload 8
      //   205: istore 11
      //   207: aconst_null
      //   208: astore 19
      //   210: iload 10
      //   212: istore 8
      //   214: iload_3
      //   215: istore 10
      //   217: iload 6
      //   219: istore 12
      //   221: iload 4
      //   223: istore 6
      //   225: iload 5
      //   227: istore 13
      //   229: iload 7
      //   231: istore_3
      //   232: iload 11
      //   234: istore 4
      //   236: iload 10
      //   238: istore 5
      //   240: iload 12
      //   242: istore 7
      //   244: iload 13
      //   246: istore 10
      //   248: goto -190 -> 58
      //   251: aload_0
      //   252: getfield 119	com/tencent/map/sdk/a/pv$i:c	Z
      //   255: aload_0
      //   256: getfield 121	com/tencent/map/sdk/a/pv$i:b	Z
      //   259: if_icmpeq +1665 -> 1924
      //   262: aload_0
      //   263: getfield 121	com/tencent/map/sdk/a/pv$i:b	Z
      //   266: istore 17
      //   268: aload_0
      //   269: aload_0
      //   270: getfield 121	com/tencent/map/sdk/a/pv$i:b	Z
      //   273: putfield 119	com/tencent/map/sdk/a/pv$i:c	Z
      //   276: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   279: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   282: iload_3
      //   283: istore 5
      //   285: aload_0
      //   286: getfield 128	com/tencent/map/sdk/a/pv$i:i	Z
      //   289: ifeq +19 -> 308
      //   292: aload_0
      //   293: invokespecial 102	com/tencent/map/sdk/a/pv$i:d	()V
      //   296: aload_0
      //   297: invokespecial 104	com/tencent/map/sdk/a/pv$i:e	()V
      //   300: aload_0
      //   301: iconst_0
      //   302: putfield 128	com/tencent/map/sdk/a/pv$i:i	Z
      //   305: iconst_1
      //   306: istore 5
      //   308: iload 7
      //   310: istore 11
      //   312: iload 7
      //   314: ifeq +14 -> 328
      //   317: aload_0
      //   318: invokespecial 102	com/tencent/map/sdk/a/pv$i:d	()V
      //   321: aload_0
      //   322: invokespecial 104	com/tencent/map/sdk/a/pv$i:e	()V
      //   325: iconst_0
      //   326: istore 11
      //   328: iload 17
      //   330: ifeq +14 -> 344
      //   333: aload_0
      //   334: getfield 63	com/tencent/map/sdk/a/pv$i:g	Z
      //   337: ifeq +7 -> 344
      //   340: aload_0
      //   341: invokespecial 102	com/tencent/map/sdk/a/pv$i:d	()V
      //   344: iload 17
      //   346: ifeq +48 -> 394
      //   349: aload_0
      //   350: getfield 71	com/tencent/map/sdk/a/pv$i:f	Z
      //   353: ifeq +41 -> 394
      //   356: aload_0
      //   357: getfield 55	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
      //   360: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   363: checkcast 6	com/tencent/map/sdk/a/pv
      //   366: astore 22
      //   368: aload 22
      //   370: ifnonnull +310 -> 680
      //   373: iconst_0
      //   374: istore 18
      //   376: iload 18
      //   378: ifeq +12 -> 390
      //   381: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   384: invokevirtual 130	com/tencent/map/sdk/a/pv$j:a	()Z
      //   387: ifeq +7 -> 394
      //   390: aload_0
      //   391: invokespecial 104	com/tencent/map/sdk/a/pv$i:e	()V
      //   394: iload 17
      //   396: ifeq +19 -> 415
      //   399: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   402: invokevirtual 132	com/tencent/map/sdk/a/pv$j:b	()Z
      //   405: ifeq +10 -> 415
      //   408: aload_0
      //   409: getfield 65	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
      //   412: invokevirtual 73	com/tencent/map/sdk/a/pv$h:b	()V
      //   415: aload_0
      //   416: getfield 134	com/tencent/map/sdk/a/pv$i:d	Z
      //   419: ifne +37 -> 456
      //   422: aload_0
      //   423: getfield 136	com/tencent/map/sdk/a/pv$i:e	Z
      //   426: ifne +30 -> 456
      //   429: aload_0
      //   430: getfield 63	com/tencent/map/sdk/a/pv$i:g	Z
      //   433: ifeq +7 -> 440
      //   436: aload_0
      //   437: invokespecial 102	com/tencent/map/sdk/a/pv$i:d	()V
      //   440: aload_0
      //   441: iconst_1
      //   442: putfield 136	com/tencent/map/sdk/a/pv$i:e	Z
      //   445: aload_0
      //   446: iconst_0
      //   447: putfield 138	com/tencent/map/sdk/a/pv$i:p	Z
      //   450: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   453: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   456: aload_0
      //   457: getfield 134	com/tencent/map/sdk/a/pv$i:d	Z
      //   460: ifeq +21 -> 481
      //   463: aload_0
      //   464: getfield 136	com/tencent/map/sdk/a/pv$i:e	Z
      //   467: ifeq +14 -> 481
      //   470: aload_0
      //   471: iconst_0
      //   472: putfield 136	com/tencent/map/sdk/a/pv$i:e	Z
      //   475: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   478: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   481: iload 4
      //   483: istore 7
      //   485: iload 4
      //   487: ifeq +20 -> 507
      //   490: iconst_0
      //   491: istore 12
      //   493: iconst_0
      //   494: istore 7
      //   496: aload_0
      //   497: iconst_1
      //   498: putfield 140	com/tencent/map/sdk/a/pv$i:m	Z
      //   501: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   504: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   507: iload 5
      //   509: istore_3
      //   510: iload 6
      //   512: istore 16
      //   514: iload 8
      //   516: istore 15
      //   518: iload 9
      //   520: istore 14
      //   522: iload 10
      //   524: istore 13
      //   526: aload_0
      //   527: invokevirtual 141	com/tencent/map/sdk/a/pv$i:a	()Z
      //   530: ifeq +498 -> 1028
      //   533: iload 5
      //   535: istore_3
      //   536: iload 10
      //   538: istore 4
      //   540: aload_0
      //   541: getfield 71	com/tencent/map/sdk/a/pv$i:f	Z
      //   544: ifne +14 -> 558
      //   547: iload 5
      //   549: ifeq +141 -> 690
      //   552: iconst_0
      //   553: istore_3
      //   554: iload 10
      //   556: istore 4
      //   558: aload_0
      //   559: getfield 71	com/tencent/map/sdk/a/pv$i:f	Z
      //   562: ifeq +1355 -> 1917
      //   565: aload_0
      //   566: getfield 63	com/tencent/map/sdk/a/pv$i:g	Z
      //   569: ifne +1348 -> 1917
      //   572: aload_0
      //   573: iconst_1
      //   574: putfield 63	com/tencent/map/sdk/a/pv$i:g	Z
      //   577: iconst_1
      //   578: istore 9
      //   580: iconst_1
      //   581: istore 6
      //   583: iconst_1
      //   584: istore 5
      //   586: aload_0
      //   587: getfield 63	com/tencent/map/sdk/a/pv$i:g	Z
      //   590: ifeq +422 -> 1012
      //   593: aload_0
      //   594: getfield 45	com/tencent/map/sdk/a/pv$i:n	Z
      //   597: ifeq +1297 -> 1894
      //   600: iconst_1
      //   601: istore 8
      //   603: aload_0
      //   604: getfield 47	com/tencent/map/sdk/a/pv$i:j	I
      //   607: istore 6
      //   609: aload_0
      //   610: getfield 49	com/tencent/map/sdk/a/pv$i:k	I
      //   613: istore_2
      //   614: iconst_1
      //   615: istore 9
      //   617: iconst_1
      //   618: istore_1
      //   619: aload_0
      //   620: iconst_0
      //   621: putfield 45	com/tencent/map/sdk/a/pv$i:n	Z
      //   624: aload_0
      //   625: iconst_0
      //   626: putfield 51	com/tencent/map/sdk/a/pv$i:l	Z
      //   629: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   632: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   635: iload 9
      //   637: istore 13
      //   639: iload 4
      //   641: istore 12
      //   643: iload 8
      //   645: istore 4
      //   647: iload 7
      //   649: istore 8
      //   651: iload_1
      //   652: istore 9
      //   654: iload 5
      //   656: istore 10
      //   658: iload_2
      //   659: istore_1
      //   660: iload 6
      //   662: istore_2
      //   663: iload_3
      //   664: istore 7
      //   666: iload 13
      //   668: istore_3
      //   669: iload 11
      //   671: istore 6
      //   673: iload 12
      //   675: istore 5
      //   677: goto -489 -> 188
      //   680: aload 22
      //   682: invokestatic 144	com/tencent/map/sdk/a/pv:h	(Lcom/tencent/map/sdk/a/pv;)Z
      //   685: istore 18
      //   687: goto -311 -> 376
      //   690: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   693: aload_0
      //   694: invokevirtual 146	com/tencent/map/sdk/a/pv$j:b	(Lcom/tencent/map/sdk/a/pv$i;)Z
      //   697: istore 17
      //   699: iload 5
      //   701: istore_3
      //   702: iload 10
      //   704: istore 4
      //   706: iload 17
      //   708: ifeq -150 -> 558
      //   711: aload_0
      //   712: getfield 65	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
      //   715: astore 22
      //   717: aload 22
      //   719: invokestatic 152	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
      //   722: checkcast 154	javax/microedition/khronos/egl/EGL10
      //   725: putfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   728: aload 22
      //   730: aload 22
      //   732: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   735: getstatic 161	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
      //   738: invokeinterface 165 2 0
      //   743: putfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   746: aload 22
      //   748: getfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   751: getstatic 171	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   754: if_acmpne +85 -> 839
      //   757: new 87	java/lang/RuntimeException
      //   760: dup
      //   761: ldc 173
      //   763: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   766: athrow
      //   767: astore 22
      //   769: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   772: aload_0
      //   773: invokevirtual 81	com/tencent/map/sdk/a/pv$j:c	(Lcom/tencent/map/sdk/a/pv$i;)V
      //   776: aload_0
      //   777: iconst_1
      //   778: putfield 71	com/tencent/map/sdk/a/pv$i:f	Z
      //   781: iconst_1
      //   782: istore 4
      //   784: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   787: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   790: iload 5
      //   792: istore_3
      //   793: goto -235 -> 558
      //   796: astore 19
      //   798: aload 21
      //   800: monitorexit
      //   801: aload 19
      //   803: athrow
      //   804: astore 19
      //   806: aload 19
      //   808: invokevirtual 179	java/lang/Exception:printStackTrace	()V
      //   811: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   814: astore 19
      //   816: aload 19
      //   818: monitorenter
      //   819: aload_0
      //   820: invokespecial 102	com/tencent/map/sdk/a/pv$i:d	()V
      //   823: aload_0
      //   824: invokespecial 104	com/tencent/map/sdk/a/pv$i:e	()V
      //   827: aload 19
      //   829: monitorexit
      //   830: return
      //   831: astore 20
      //   833: aload 19
      //   835: monitorexit
      //   836: aload 20
      //   838: athrow
      //   839: iconst_2
      //   840: newarray int
      //   842: astore 23
      //   844: aload 22
      //   846: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   849: aload 22
      //   851: getfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   854: aload 23
      //   856: invokeinterface 183 3 0
      //   861: ifne +13 -> 874
      //   864: new 87	java/lang/RuntimeException
      //   867: dup
      //   868: ldc 185
      //   870: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   873: athrow
      //   874: aload 22
      //   876: getfield 187	com/tencent/map/sdk/a/pv$h:a	Ljava/lang/ref/WeakReference;
      //   879: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   882: checkcast 6	com/tencent/map/sdk/a/pv
      //   885: astore 23
      //   887: aload 23
      //   889: ifnonnull +65 -> 954
      //   892: aload 22
      //   894: aconst_null
      //   895: putfield 190	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   898: aload 22
      //   900: aconst_null
      //   901: putfield 193	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   904: aload 22
      //   906: getfield 193	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   909: ifnull +14 -> 923
      //   912: aload 22
      //   914: getfield 193	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   917: getstatic 196	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
      //   920: if_acmpne +25 -> 945
      //   923: aload 22
      //   925: aconst_null
      //   926: putfield 193	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   929: aload 22
      //   931: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   934: invokeinterface 200 1 0
      //   939: pop
      //   940: ldc 202
      //   942: invokestatic 204	com/tencent/map/sdk/a/pv$h:a	(Ljava/lang/String;)V
      //   945: aload 22
      //   947: aconst_null
      //   948: putfield 207	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   951: goto -175 -> 776
      //   954: aload 22
      //   956: aload 23
      //   958: invokestatic 210	com/tencent/map/sdk/a/pv:b	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$e;
      //   961: aload 22
      //   963: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   966: aload 22
      //   968: getfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   971: invokeinterface 215 3 0
      //   976: putfield 190	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   979: aload 22
      //   981: aload 23
      //   983: invokestatic 218	com/tencent/map/sdk/a/pv:c	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$f;
      //   986: aload 22
      //   988: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   991: aload 22
      //   993: getfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   996: aload 22
      //   998: getfield 190	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1001: invokeinterface 223 4 0
      //   1006: putfield 193	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1009: goto -105 -> 904
      //   1012: iload 4
      //   1014: istore 13
      //   1016: iload 9
      //   1018: istore 14
      //   1020: iload 5
      //   1022: istore 15
      //   1024: iload 6
      //   1026: istore 16
      //   1028: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1031: invokevirtual 226	java/lang/Object:wait	()V
      //   1034: iload 7
      //   1036: istore 4
      //   1038: iload 16
      //   1040: istore 6
      //   1042: iload 11
      //   1044: istore 7
      //   1046: iload 15
      //   1048: istore 8
      //   1050: iload 14
      //   1052: istore 9
      //   1054: iload 13
      //   1056: istore 10
      //   1058: goto -988 -> 70
      //   1061: iload 9
      //   1063: ifeq +828 -> 1891
      //   1066: aload_0
      //   1067: getfield 65	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
      //   1070: astore 21
      //   1072: aload 21
      //   1074: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1077: ifnonnull +37 -> 1114
      //   1080: new 87	java/lang/RuntimeException
      //   1083: dup
      //   1084: ldc 228
      //   1086: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1089: athrow
      //   1090: astore 20
      //   1092: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1095: astore 19
      //   1097: aload 19
      //   1099: monitorenter
      //   1100: aload_0
      //   1101: invokespecial 102	com/tencent/map/sdk/a/pv$i:d	()V
      //   1104: aload_0
      //   1105: invokespecial 104	com/tencent/map/sdk/a/pv$i:e	()V
      //   1108: aload 19
      //   1110: monitorexit
      //   1111: aload 20
      //   1113: athrow
      //   1114: aload 21
      //   1116: getfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1119: ifnonnull +13 -> 1132
      //   1122: new 87	java/lang/RuntimeException
      //   1125: dup
      //   1126: ldc 230
      //   1128: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1131: athrow
      //   1132: aload 21
      //   1134: getfield 190	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1137: ifnonnull +13 -> 1150
      //   1140: new 87	java/lang/RuntimeException
      //   1143: dup
      //   1144: ldc 232
      //   1146: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1149: athrow
      //   1150: aload 21
      //   1152: invokevirtual 69	com/tencent/map/sdk/a/pv$h:a	()V
      //   1155: aload 21
      //   1157: getfield 187	com/tencent/map/sdk/a/pv$h:a	Ljava/lang/ref/WeakReference;
      //   1160: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1163: checkcast 6	com/tencent/map/sdk/a/pv
      //   1166: astore 22
      //   1168: aload 22
      //   1170: ifnull +509 -> 1679
      //   1173: aload 21
      //   1175: aload 22
      //   1177: invokestatic 235	com/tencent/map/sdk/a/pv:d	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$g;
      //   1180: aload 21
      //   1182: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1185: aload 21
      //   1187: getfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1190: aload 21
      //   1192: getfield 190	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1195: aload 22
      //   1197: invokevirtual 239	com/tencent/map/sdk/a/pv:getHolder	()Landroid/view/SurfaceHolder;
      //   1200: invokeinterface 244 5 0
      //   1205: putfield 207	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1208: aload 21
      //   1210: getfield 207	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1213: ifnull +14 -> 1227
      //   1216: aload 21
      //   1218: getfield 207	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1221: getstatic 247	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1224: if_acmpne +464 -> 1688
      //   1227: aload 21
      //   1229: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1232: invokeinterface 200 1 0
      //   1237: sipush 12299
      //   1240: if_icmpne +703 -> 1943
      //   1243: ldc 249
      //   1245: ldc 251
      //   1247: invokestatic 256	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   1250: pop
      //   1251: goto +692 -> 1943
      //   1254: iload 11
      //   1256: ifeq +505 -> 1761
      //   1259: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1262: astore 21
      //   1264: aload 21
      //   1266: monitorenter
      //   1267: aload_0
      //   1268: iconst_1
      //   1269: putfield 258	com/tencent/map/sdk/a/pv$i:h	Z
      //   1272: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1275: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   1278: aload 21
      //   1280: monitorexit
      //   1281: iconst_0
      //   1282: istore 9
      //   1284: iload 10
      //   1286: ifeq +598 -> 1884
      //   1289: aload_0
      //   1290: getfield 65	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
      //   1293: astore 21
      //   1295: aload 21
      //   1297: getfield 193	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1300: invokevirtual 262	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1303: astore 20
      //   1305: aload 21
      //   1307: getfield 187	com/tencent/map/sdk/a/pv$h:a	Ljava/lang/ref/WeakReference;
      //   1310: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1313: checkcast 6	com/tencent/map/sdk/a/pv
      //   1316: astore 22
      //   1318: aload 20
      //   1320: astore 21
      //   1322: aload 22
      //   1324: ifnull +553 -> 1877
      //   1327: aload 22
      //   1329: invokestatic 265	com/tencent/map/sdk/a/pv:e	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$k;
      //   1332: ifnull +15 -> 1347
      //   1335: aload 22
      //   1337: invokestatic 265	com/tencent/map/sdk/a/pv:e	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$k;
      //   1340: invokeinterface 269 1 0
      //   1345: astore 20
      //   1347: aload 20
      //   1349: astore 21
      //   1351: aload 22
      //   1353: invokestatic 272	com/tencent/map/sdk/a/pv:f	(Lcom/tencent/map/sdk/a/pv;)I
      //   1356: iconst_3
      //   1357: iand
      //   1358: ifeq +519 -> 1877
      //   1361: iconst_0
      //   1362: istore 10
      //   1364: aload 22
      //   1366: invokestatic 272	com/tencent/map/sdk/a/pv:f	(Lcom/tencent/map/sdk/a/pv;)I
      //   1369: iconst_1
      //   1370: iand
      //   1371: ifeq +6 -> 1377
      //   1374: iconst_1
      //   1375: istore 10
      //   1377: aload 22
      //   1379: invokestatic 272	com/tencent/map/sdk/a/pv:f	(Lcom/tencent/map/sdk/a/pv;)I
      //   1382: iconst_2
      //   1383: iand
      //   1384: ifeq +487 -> 1871
      //   1387: new 274	com/tencent/map/sdk/a/pv$l
      //   1390: dup
      //   1391: invokespecial 275	com/tencent/map/sdk/a/pv$l:<init>	()V
      //   1394: astore 21
      //   1396: aload 20
      //   1398: iload 10
      //   1400: aload 21
      //   1402: invokestatic 281	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
      //   1405: astore 20
      //   1407: aload 20
      //   1409: checkcast 283	javax/microedition/khronos/opengles/GL10
      //   1412: astore 20
      //   1414: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1417: aload 20
      //   1419: invokevirtual 286	com/tencent/map/sdk/a/pv$j:a	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   1422: iconst_0
      //   1423: istore 11
      //   1425: iload 5
      //   1427: istore 10
      //   1429: iload 5
      //   1431: ifeq +42 -> 1473
      //   1434: aload_0
      //   1435: getfield 55	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
      //   1438: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1441: checkcast 6	com/tencent/map/sdk/a/pv
      //   1444: astore 21
      //   1446: aload 21
      //   1448: ifnull +501 -> 1949
      //   1451: aload 21
      //   1453: invokestatic 100	com/tencent/map/sdk/a/pv:g	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$m;
      //   1456: aload 20
      //   1458: aload_0
      //   1459: getfield 65	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
      //   1462: getfield 190	com/tencent/map/sdk/a/pv$h:e	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1465: invokeinterface 291 3 0
      //   1470: goto +479 -> 1949
      //   1473: iload 4
      //   1475: istore 5
      //   1477: iload 4
      //   1479: ifeq +37 -> 1516
      //   1482: aload_0
      //   1483: getfield 55	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
      //   1486: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1489: checkcast 6	com/tencent/map/sdk/a/pv
      //   1492: astore 21
      //   1494: aload 21
      //   1496: ifnull +459 -> 1955
      //   1499: aload 21
      //   1501: invokestatic 100	com/tencent/map/sdk/a/pv:g	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$m;
      //   1504: aload 20
      //   1506: iload_2
      //   1507: iload_1
      //   1508: invokeinterface 294 4 0
      //   1513: goto +442 -> 1955
      //   1516: aload_0
      //   1517: getfield 55	com/tencent/map/sdk/a/pv$i:t	Ljava/lang/ref/WeakReference;
      //   1520: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1523: checkcast 6	com/tencent/map/sdk/a/pv
      //   1526: astore 21
      //   1528: aload 21
      //   1530: ifnull +407 -> 1937
      //   1533: aload 21
      //   1535: invokestatic 100	com/tencent/map/sdk/a/pv:g	(Lcom/tencent/map/sdk/a/pv;)Lcom/tencent/map/sdk/a/pv$m;
      //   1538: aload 20
      //   1540: invokeinterface 297 2 0
      //   1545: istore 17
      //   1547: iload 6
      //   1549: istore 4
      //   1551: iload 17
      //   1553: ifeq +82 -> 1635
      //   1556: aload_0
      //   1557: getfield 65	com/tencent/map/sdk/a/pv$i:s	Lcom/tencent/map/sdk/a/pv$h;
      //   1560: astore 21
      //   1562: aload 21
      //   1564: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1567: aload 21
      //   1569: getfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1572: aload 21
      //   1574: getfield 207	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1577: invokeinterface 301 3 0
      //   1582: ifne +259 -> 1841
      //   1585: aload 21
      //   1587: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1590: invokeinterface 200 1 0
      //   1595: istore 12
      //   1597: goto +364 -> 1961
      //   1600: ldc_w 303
      //   1603: ldc_w 304
      //   1606: invokestatic 307	com/tencent/map/sdk/a/pv$h:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1609: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1612: astore 21
      //   1614: aload 21
      //   1616: monitorenter
      //   1617: aload_0
      //   1618: iconst_1
      //   1619: putfield 138	com/tencent/map/sdk/a/pv$i:p	Z
      //   1622: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1625: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   1628: aload 21
      //   1630: monitorexit
      //   1631: iload 6
      //   1633: istore 4
      //   1635: iload_3
      //   1636: ifeq +294 -> 1930
      //   1639: iconst_1
      //   1640: istore 6
      //   1642: iload_3
      //   1643: istore 12
      //   1645: iload 11
      //   1647: istore 8
      //   1649: iload 5
      //   1651: istore 11
      //   1653: iload 4
      //   1655: istore 13
      //   1657: iload 6
      //   1659: istore 4
      //   1661: iload 7
      //   1663: istore_3
      //   1664: iload 12
      //   1666: istore 5
      //   1668: iload 11
      //   1670: istore 6
      //   1672: iload 13
      //   1674: istore 7
      //   1676: goto -1618 -> 58
      //   1679: aload 21
      //   1681: aconst_null
      //   1682: putfield 207	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1685: goto -477 -> 1208
      //   1688: aload 21
      //   1690: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1693: aload 21
      //   1695: getfield 168	com/tencent/map/sdk/a/pv$h:c	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1698: aload 21
      //   1700: getfield 207	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1703: aload 21
      //   1705: getfield 207	com/tencent/map/sdk/a/pv$h:d	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1708: aload 21
      //   1710: getfield 193	com/tencent/map/sdk/a/pv$h:f	Ljavax/microedition/khronos/egl/EGLContext;
      //   1713: invokeinterface 311 5 0
      //   1718: ifne +29 -> 1747
      //   1721: aload 21
      //   1723: getfield 157	com/tencent/map/sdk/a/pv$h:b	Ljavax/microedition/khronos/egl/EGL10;
      //   1726: invokeinterface 200 1 0
      //   1731: pop
      //   1732: ldc_w 313
      //   1735: ldc_w 314
      //   1738: invokestatic 307	com/tencent/map/sdk/a/pv$h:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   1741: iconst_0
      //   1742: istore 11
      //   1744: goto -490 -> 1254
      //   1747: iconst_1
      //   1748: istore 11
      //   1750: goto -496 -> 1254
      //   1753: astore 19
      //   1755: aload 21
      //   1757: monitorexit
      //   1758: aload 19
      //   1760: athrow
      //   1761: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1764: astore 21
      //   1766: aload 21
      //   1768: monitorenter
      //   1769: aload_0
      //   1770: iconst_1
      //   1771: putfield 258	com/tencent/map/sdk/a/pv$i:h	Z
      //   1774: aload_0
      //   1775: iconst_1
      //   1776: putfield 138	com/tencent/map/sdk/a/pv$i:p	Z
      //   1779: invokestatic 76	com/tencent/map/sdk/a/pv:a	()Lcom/tencent/map/sdk/a/pv$j;
      //   1782: invokevirtual 126	java/lang/Object:notifyAll	()V
      //   1785: aload 21
      //   1787: monitorexit
      //   1788: iload 8
      //   1790: istore 11
      //   1792: iload 10
      //   1794: istore 8
      //   1796: iload_3
      //   1797: istore 10
      //   1799: iload 6
      //   1801: istore 12
      //   1803: iload 4
      //   1805: istore 6
      //   1807: iload 5
      //   1809: istore 13
      //   1811: iload 7
      //   1813: istore_3
      //   1814: iload 11
      //   1816: istore 4
      //   1818: iload 10
      //   1820: istore 5
      //   1822: iload 12
      //   1824: istore 7
      //   1826: iload 13
      //   1828: istore 10
      //   1830: goto -1772 -> 58
      //   1833: astore 19
      //   1835: aload 21
      //   1837: monitorexit
      //   1838: aload 19
      //   1840: athrow
      //   1841: sipush 12288
      //   1844: istore 12
      //   1846: goto +115 -> 1961
      //   1849: iconst_1
      //   1850: istore 4
      //   1852: goto -217 -> 1635
      //   1855: astore 19
      //   1857: aload 21
      //   1859: monitorexit
      //   1860: aload 19
      //   1862: athrow
      //   1863: astore 20
      //   1865: aload 19
      //   1867: monitorexit
      //   1868: aload 20
      //   1870: athrow
      //   1871: aconst_null
      //   1872: astore 21
      //   1874: goto -478 -> 1396
      //   1877: aload 21
      //   1879: astore 20
      //   1881: goto -474 -> 1407
      //   1884: iload 10
      //   1886: istore 11
      //   1888: goto -463 -> 1425
      //   1891: goto -607 -> 1284
      //   1894: iload 9
      //   1896: istore 10
      //   1898: iload 12
      //   1900: istore 9
      //   1902: iload 6
      //   1904: istore 8
      //   1906: iload_2
      //   1907: istore 6
      //   1909: iload_1
      //   1910: istore_2
      //   1911: iload 10
      //   1913: istore_1
      //   1914: goto -1290 -> 624
      //   1917: iload 8
      //   1919: istore 5
      //   1921: goto -1335 -> 586
      //   1924: iconst_0
      //   1925: istore 17
      //   1927: goto -1645 -> 282
      //   1930: iload 8
      //   1932: istore 6
      //   1934: goto -292 -> 1642
      //   1937: iconst_0
      //   1938: istore 17
      //   1940: goto -393 -> 1547
      //   1943: iconst_0
      //   1944: istore 11
      //   1946: goto -692 -> 1254
      //   1949: iconst_0
      //   1950: istore 10
      //   1952: goto -479 -> 1473
      //   1955: iconst_0
      //   1956: istore 5
      //   1958: goto -442 -> 1516
      //   1961: iload 6
      //   1963: istore 4
      //   1965: iload 12
      //   1967: lookupswitch	default:+25->1992, 12288:+-332->1635, 12302:+-118->1849
      //   1993: impdep1
      //   1994: ishl
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1995	0	this	i
      //   51	1863	1	i1	int
      //   43	1868	2	i2	int
      //   26	1788	3	i3	int
      //   28	1936	4	i4	int
      //   40	1917	5	i5	int
      //   53	1909	6	i6	int
      //   45	1780	7	i7	int
      //   37	1894	8	i8	int
      //   48	1853	9	i9	int
      //   56	1895	10	i10	int
      //   156	1789	11	i11	int
      //   68	1898	12	i12	int
      //   227	1600	13	i13	int
      //   520	531	14	i14	int
      //   516	531	15	i15	int
      //   512	527	16	i16	int
      //   266	1673	17	bool1	boolean
      //   374	312	18	bool2	boolean
      //   34	175	19	localObject1	Object
      //   796	6	19	localObject2	Object
      //   804	3	19	localException	java.lang.Exception
      //   814	295	19	localj	pv.j
      //   1753	6	19	localObject3	Object
      //   1833	6	19	localObject4	Object
      //   1855	11	19	localObject5	Object
      //   31	1	20	localObject6	Object
      //   123	6	20	localObject7	Object
      //   831	6	20	localObject8	Object
      //   1090	22	20	localObject9	Object
      //   1303	236	20	localObject10	Object
      //   1863	6	20	localObject11	Object
      //   1879	1	20	localObject12	Object
      //   366	381	22	localObject14	Object
      //   767	230	22	localRuntimeException	RuntimeException
      //   1166	212	22	localpv	pv
      //   842	140	23	localObject15	Object
      // Exception table:
      //   from	to	target	type
      //   111	122	123	finally
      //   125	128	123	finally
      //   711	767	767	java/lang/RuntimeException
      //   839	874	767	java/lang/RuntimeException
      //   874	887	767	java/lang/RuntimeException
      //   892	904	767	java/lang/RuntimeException
      //   904	923	767	java/lang/RuntimeException
      //   923	945	767	java/lang/RuntimeException
      //   945	951	767	java/lang/RuntimeException
      //   954	1009	767	java/lang/RuntimeException
      //   70	89	796	finally
      //   94	100	796	finally
      //   100	103	796	finally
      //   131	154	796	finally
      //   188	191	796	finally
      //   251	282	796	finally
      //   285	305	796	finally
      //   317	325	796	finally
      //   333	344	796	finally
      //   349	368	796	finally
      //   381	390	796	finally
      //   390	394	796	finally
      //   399	415	796	finally
      //   415	440	796	finally
      //   440	456	796	finally
      //   456	481	796	finally
      //   496	507	796	finally
      //   526	533	796	finally
      //   540	547	796	finally
      //   558	577	796	finally
      //   586	600	796	finally
      //   603	614	796	finally
      //   619	624	796	finally
      //   624	635	796	finally
      //   680	687	796	finally
      //   690	699	796	finally
      //   711	767	796	finally
      //   769	776	796	finally
      //   776	781	796	finally
      //   784	790	796	finally
      //   798	801	796	finally
      //   839	874	796	finally
      //   874	887	796	finally
      //   892	904	796	finally
      //   904	923	796	finally
      //   923	945	796	finally
      //   945	951	796	finally
      //   954	1009	796	finally
      //   1028	1034	796	finally
      //   58	66	804	java/lang/Exception
      //   196	203	804	java/lang/Exception
      //   801	804	804	java/lang/Exception
      //   1066	1090	804	java/lang/Exception
      //   1114	1132	804	java/lang/Exception
      //   1132	1150	804	java/lang/Exception
      //   1150	1168	804	java/lang/Exception
      //   1173	1208	804	java/lang/Exception
      //   1208	1227	804	java/lang/Exception
      //   1227	1251	804	java/lang/Exception
      //   1259	1267	804	java/lang/Exception
      //   1289	1318	804	java/lang/Exception
      //   1327	1347	804	java/lang/Exception
      //   1351	1361	804	java/lang/Exception
      //   1364	1374	804	java/lang/Exception
      //   1377	1396	804	java/lang/Exception
      //   1396	1407	804	java/lang/Exception
      //   1407	1422	804	java/lang/Exception
      //   1434	1446	804	java/lang/Exception
      //   1451	1470	804	java/lang/Exception
      //   1482	1494	804	java/lang/Exception
      //   1499	1513	804	java/lang/Exception
      //   1516	1528	804	java/lang/Exception
      //   1533	1547	804	java/lang/Exception
      //   1556	1597	804	java/lang/Exception
      //   1600	1617	804	java/lang/Exception
      //   1679	1685	804	java/lang/Exception
      //   1688	1741	804	java/lang/Exception
      //   1758	1761	804	java/lang/Exception
      //   1761	1769	804	java/lang/Exception
      //   1838	1841	804	java/lang/Exception
      //   1860	1863	804	java/lang/Exception
      //   819	830	831	finally
      //   833	836	831	finally
      //   58	66	1090	finally
      //   196	203	1090	finally
      //   801	804	1090	finally
      //   806	811	1090	finally
      //   1066	1090	1090	finally
      //   1114	1132	1090	finally
      //   1132	1150	1090	finally
      //   1150	1168	1090	finally
      //   1173	1208	1090	finally
      //   1208	1227	1090	finally
      //   1227	1251	1090	finally
      //   1259	1267	1090	finally
      //   1289	1318	1090	finally
      //   1327	1347	1090	finally
      //   1351	1361	1090	finally
      //   1364	1374	1090	finally
      //   1377	1396	1090	finally
      //   1396	1407	1090	finally
      //   1407	1422	1090	finally
      //   1434	1446	1090	finally
      //   1451	1470	1090	finally
      //   1482	1494	1090	finally
      //   1499	1513	1090	finally
      //   1516	1528	1090	finally
      //   1533	1547	1090	finally
      //   1556	1597	1090	finally
      //   1600	1617	1090	finally
      //   1679	1685	1090	finally
      //   1688	1741	1090	finally
      //   1758	1761	1090	finally
      //   1761	1769	1090	finally
      //   1838	1841	1090	finally
      //   1860	1863	1090	finally
      //   1267	1281	1753	finally
      //   1755	1758	1753	finally
      //   1769	1788	1833	finally
      //   1835	1838	1833	finally
      //   1617	1631	1855	finally
      //   1857	1860	1855	finally
      //   1100	1111	1863	finally
      //   1865	1868	1863	finally
    }
    
    public final void a(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1)) {
        throw new IllegalArgumentException("renderMode");
      }
      synchronized (pv.a())
      {
        this.q = paramInt;
        pv.a().notifyAll();
        return;
      }
    }
    
    final boolean a()
    {
      return (!this.c) && (this.d) && (!this.p) && (this.j > 0) && (this.k > 0) && ((this.l) || (this.q == 1));
    }
    
    public final int b()
    {
      synchronized ()
      {
        int i1 = this.q;
        return i1;
      }
    }
    
    public final void c()
    {
      synchronized ()
      {
        this.o = true;
        pv.a().notifyAll();
        for (;;)
        {
          boolean bool = this.a;
          if (!bool) {
            try
            {
              pv.a().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    
    public final void run()
    {
      setName("GLThread " + getId());
      try
      {
        f();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return;
      }
      finally
      {
        pv.a().a(this);
      }
    }
  }
  
  static final class j
  {
    private static String a = "GLThreadManager";
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private pv.i g;
    
    private void c()
    {
      if (!this.b)
      {
        this.c = 131072;
        if (this.c >= 131072) {
          this.e = true;
        }
        this.b = true;
      }
    }
    
    public final void a(pv.i parami)
    {
      try
      {
        pv.i.a(parami);
        if (this.g == parami) {
          this.g = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
    
    /* Error */
    public final void a(GL10 paramGL10)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 51	com/tencent/map/sdk/a/pv$j:d	Z
      //   8: ifne +65 -> 73
      //   11: aload_0
      //   12: invokespecial 53	com/tencent/map/sdk/a/pv$j:c	()V
      //   15: aload_1
      //   16: sipush 7937
      //   19: invokeinterface 59 2 0
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 35	com/tencent/map/sdk/a/pv$j:c	I
      //   29: ldc 33
      //   31: if_icmpge +23 -> 54
      //   34: aload_1
      //   35: ldc 61
      //   37: invokevirtual 67	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   40: ifne +36 -> 76
      //   43: iconst_1
      //   44: istore_2
      //   45: aload_0
      //   46: iload_2
      //   47: putfield 37	com/tencent/map/sdk/a/pv$j:e	Z
      //   50: aload_0
      //   51: invokevirtual 48	java/lang/Object:notifyAll	()V
      //   54: aload_0
      //   55: getfield 37	com/tencent/map/sdk/a/pv$j:e	Z
      //   58: ifne +23 -> 81
      //   61: iload_3
      //   62: istore_2
      //   63: aload_0
      //   64: iload_2
      //   65: putfield 69	com/tencent/map/sdk/a/pv$j:f	Z
      //   68: aload_0
      //   69: iconst_1
      //   70: putfield 51	com/tencent/map/sdk/a/pv$j:d	Z
      //   73: aload_0
      //   74: monitorexit
      //   75: return
      //   76: iconst_0
      //   77: istore_2
      //   78: goto -33 -> 45
      //   81: iconst_0
      //   82: istore_2
      //   83: goto -20 -> 63
      //   86: astore_1
      //   87: aload_0
      //   88: monitorexit
      //   89: aload_1
      //   90: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	j
      //   0	91	1	paramGL10	GL10
      //   44	39	2	bool1	boolean
      //   1	61	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	43	86	finally
      //   45	54	86	finally
      //   54	61	86	finally
      //   63	73	86	finally
    }
    
    public final boolean a()
    {
      try
      {
        boolean bool = this.f;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public final boolean b()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 53	com/tencent/map/sdk/a/pv$j:c	()V
      //   6: aload_0
      //   7: getfield 37	com/tencent/map/sdk/a/pv$j:e	Z
      //   10: istore_1
      //   11: iload_1
      //   12: ifne +9 -> 21
      //   15: iconst_1
      //   16: istore_1
      //   17: aload_0
      //   18: monitorexit
      //   19: iload_1
      //   20: ireturn
      //   21: iconst_0
      //   22: istore_1
      //   23: goto -6 -> 17
      //   26: astore_2
      //   27: aload_0
      //   28: monitorexit
      //   29: aload_2
      //   30: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	j
      //   10	13	1	bool	boolean
      //   26	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	11	26	finally
    }
    
    public final boolean b(pv.i arg1)
    {
      boolean bool = true;
      for (;;)
      {
        try
        {
          if ((this.g == ???) || (this.g == null))
          {
            this.g = ???;
            notifyAll();
            return bool;
          }
          c();
          if (!this.e)
          {
            if (this.g != null)
            {
              pv.i locali = this.g;
              synchronized (pv.a())
              {
                locali.i = true;
                pv.a().notifyAll();
              }
            }
            bool = false;
          }
        }
        finally {}
      }
    }
    
    public final void c(pv.i parami)
    {
      try
      {
        if (this.g == parami) {
          this.g = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
  }
  
  public static abstract interface k
  {
    public abstract GL a();
  }
  
  static final class l
    extends Writer
  {
    private StringBuilder a = new StringBuilder();
    
    private void a()
    {
      if (this.a.length() > 0)
      {
        Log.v("GLSurfaceView", this.a.toString());
        this.a.delete(0, this.a.length());
      }
    }
    
    public final void close()
    {
      a();
    }
    
    public final void flush()
    {
      a();
    }
    
    public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      int i = 0;
      if (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          a();
        }
        for (;;)
        {
          i += 1;
          break;
          this.a.append(c);
        }
      }
    }
  }
  
  public static abstract interface m
  {
    public abstract void a(GL10 paramGL10, int paramInt1, int paramInt2);
    
    public abstract void a(GL10 paramGL10, EGLConfig paramEGLConfig);
    
    public abstract boolean a(GL10 paramGL10);
  }
  
  final class n
    extends pv.b
  {
    public n(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv
 * JD-Core Version:    0.7.0.1
 */