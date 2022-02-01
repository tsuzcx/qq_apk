package com.tencent.mobileqq.apollo;

import abiw;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import mqq.os.MqqHandler;

@TargetApi(14)
public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final int DEBUG_CHECK_GL_ERROR = 1;
  public static final int DEBUG_LOG_GL_CALLS = 2;
  private static final boolean LOG_ATTACH_DETACH = false;
  private static final boolean LOG_EGL = false;
  private static final boolean LOG_PAUSE_RESUME = false;
  private static final boolean LOG_RENDERER = false;
  private static final boolean LOG_RENDERER_DRAW_FRAME = false;
  private static final boolean LOG_SURFACE = false;
  private static final boolean LOG_THREADS = false;
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final String TAG = "GLTextureView";
  private static int sGLESVersion;
  private static final i sGLThreadManager = new i(null);
  private static int sThreadName;
  private boolean mCreateContextFailed;
  private int mDebugFlags;
  private boolean mDestroyOnAsync;
  private boolean mDetached;
  protected boolean mDisableCreateRenderThread;
  private e mEGLConfigChooser;
  private int mEGLContextClientVersion;
  private f mEGLContextFactory;
  private g mEGLWindowSurfaceFactory;
  private Runnable mForceSetAlphaTask = new GLTextureView.4(this);
  protected GLThread mGLThread;
  private j mGLWrapper;
  private boolean mPreserveEGLContextOnPause;
  private GLSurfaceView.Renderer mRenderer;
  private boolean mSurfaceHadDraw;
  int mSurfaceHeight = 0;
  private boolean mSurfaceTextureAvailable;
  int mSurfaceWidth = 0;
  private final WeakReference<GLTextureView> mThisWeakRef = new WeakReference(this);
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public static void checkGLVersion()
  {
    if (sGLESVersion == 0) {
      ThreadManagerV2.excute(new GLTextureView.1(), 16, null, false);
    }
  }
  
  private void checkRenderThreadState()
  {
    if (this.mGLThread != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  @SuppressLint({"UseValueOf"})
  public static Integer getInt(Context paramContext, String paramString, int paramInt)
    throws IllegalArgumentException
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (Integer)paramContext.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { new String(paramString), new Integer(paramInt) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return Integer.valueOf(paramInt);
  }
  
  @TargetApi(14)
  private float getViewAlpha()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return getAlpha();
    }
    return 1.0F;
  }
  
  private void init()
  {
    if (sGLESVersion == 0) {
      sGLESVersion = getInt(getContext(), "ro.opengles.version", 0).intValue();
    }
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new abiw(this));
    setViewAlpha(0.0F);
  }
  
  @TargetApi(14)
  private void setViewAlpha(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      setAlpha(paramFloat);
    }
  }
  
  public void checkSetAlpha()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, "TextureView mSurfaceHadDraw:" + this.mSurfaceHadDraw + ",alpha:" + getViewAlpha());
    }
    if ((this.mSurfaceTextureAvailable) && (this.mSurfaceHadDraw))
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        ThreadManager.getUIHandler().post(new GLTextureView.5(this));
      }
    }
    else {
      return;
    }
    setViewAlpha(1.0F);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.mGLThread != null) {
        this.mGLThread.requestExitAndWait();
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
    return this.mDebugFlags;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    return this.mGLThread.getRenderMode();
  }
  
  public String getRenderThreadName()
  {
    return "GLTexture_";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    int i;
    if ((this.mDetached) && (this.mRenderer != null))
    {
      if (this.mGLThread == null) {
        break label236;
      }
      i = this.mGLThread.getRenderMode();
      if ((this instanceof ApolloTextureView)) {
        if (((ApolloTextureView)this).mIsReAttach)
        {
          if ((this.mRenderer instanceof ApolloRender))
          {
            ((ApolloRender)this.mRenderer).queueDestroy();
            QLog.e("GLTextureView", 1, "onAttachedToWindow re_attach GLThread need destroy mDisableCreateRenderThread: " + this.mDisableCreateRenderThread);
          }
        }
        else {
          QLog.i("GLTextureView", 1, "onAttachedToWindow re_attach but new GLThread mDisableCreateRenderThread: " + this.mDisableCreateRenderThread);
        }
      }
    }
    for (;;)
    {
      if (!this.mDisableCreateRenderThread)
      {
        this.mGLThread = new GLThread(this.mThisWeakRef, getRenderThreadName());
        this.mGLThread.setName(this.mGLThread.getName() + "_" + this.mGLThread.getId());
        if (i != 1) {
          this.mGLThread.setRenderMode(i);
        }
        this.mGLThread.start();
      }
      for (;;)
      {
        this.mDetached = false;
        return;
        QLog.e("GLTextureView", 1, "onAttachedToWindow mDisableCreateRenderThread true");
      }
      label236:
      i = 1;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mGLThread != null) {
      this.mGLThread.requestExitAndWait();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    this.mGLThread.onPause();
  }
  
  public void onResume()
  {
    this.mGLThread.onResume();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mSurfaceTextureAvailable = true;
    this.mSurfaceHadDraw = false;
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
    Log.d("GLTextureView", "onSurfaceTextureAvailable");
    long l = System.currentTimeMillis();
    surfaceCreated(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureAvailable surfaceCreated use:" + (System.currentTimeMillis() - l));
    }
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
    removeCallbacks(this.mForceSetAlphaTask);
    postDelayed(this.mForceSetAlphaTask, 250L);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureAvailable surfaceChanged use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTextureAvailable = false;
    this.mSurfaceHadDraw = false;
    Log.d("GLTextureView", "onSurfaceTextureDestroyed");
    surfaceDestroyed(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureDestroyed");
    }
    removeCallbacks(this.mForceSetAlphaTask);
    setViewAlpha(0.0F);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    Log.d("GLTextureView", "onSurfaceTextureSizeChanged");
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureSizeChanged surfaceChanged use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void queueEvent(Runnable paramRunnable)
  {
    this.mGLThread.queueEvent(paramRunnable);
  }
  
  public void requestRender()
  {
    this.mGLThread.requestRender();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setDestroyOnAsync(boolean paramBoolean)
  {
    this.mDestroyOnAsync = paramBoolean;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(e parame)
  {
    checkRenderThreadState();
    this.mEGLConfigChooser = parame;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new l(paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
  }
  
  public void setEGLContextFactory(f paramf)
  {
    checkRenderThreadState();
    this.mEGLContextFactory = paramf;
  }
  
  public void setEGLWindowSurfaceFactory(g paramg)
  {
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramg;
  }
  
  public void setGLWrapper(j paramj)
  {
    this.mGLWrapper = paramj;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mGLThread.setRenderMode(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null) {
      this.mEGLConfigChooser = new l(true);
    }
    if (this.mEGLContextFactory == null) {
      this.mEGLContextFactory = new c(null);
    }
    if (this.mEGLWindowSurfaceFactory == null) {
      this.mEGLWindowSurfaceFactory = new d(null);
    }
    this.mRenderer = paramRenderer;
    this.mGLThread = new GLThread(this.mThisWeakRef, getRenderThreadName());
    this.mGLThread.setName(this.mGLThread.getName() + "_" + this.mGLThread.getId());
    this.mGLThread.start();
  }
  
  public void surfaceChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    if ((this.mSurfaceWidth != paramInt2) || (this.mSurfaceHeight != paramInt3))
    {
      this.mSurfaceWidth = paramInt2;
      this.mSurfaceHeight = paramInt3;
      this.mSurfaceHadDraw = false;
      this.mGLThread.onWindowResize(paramInt2, paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, " surfaceChanged, onWindowResize");
      }
    }
    checkSetAlpha();
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " surfaceChanged, w:" + paramInt2 + ",h:" + paramInt3 + " use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void surfaceCreated(SurfaceTexture paramSurfaceTexture)
  {
    this.mGLThread.surfaceCreated();
  }
  
  public void surfaceDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mDestroyOnAsync)
    {
      GLThread.a(this.mGLThread, false);
      ThreadManagerV2.postImmediately(new GLTextureView.3(this), null, false);
      return;
    }
    this.mGLThread.surfaceDestroyed();
  }
  
  static class GLThread
    extends Thread
  {
    private GLTextureView.h a;
    private ArrayList<Runnable> mEventQueue = new ArrayList();
    private boolean mExited;
    private boolean mFinishedCreatingEglSurface;
    private WeakReference<GLTextureView> mGLTextureViewWeakRef;
    private boolean mHasSurface;
    private boolean mHaveEglContext;
    private boolean mHaveEglSurface;
    private int mHeight = 0;
    private boolean mPaused;
    private boolean mRenderComplete;
    private int mRenderMode = 1;
    private boolean mRequestPaused;
    private boolean mRequestRender = true;
    private boolean mShouldExit;
    private boolean mShouldReleaseEglContext;
    private boolean mSizeChanged = true;
    private boolean mSurfaceIsBad;
    private boolean mWaitingForSurface;
    private int mWidth = 0;
    
    GLThread(WeakReference<GLTextureView> paramWeakReference, String paramString)
    {
      super();
      this.mGLTextureViewWeakRef = paramWeakReference;
    }
    
    /* Error */
    private void guardedRun()
      throws InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: new 100	com/tencent/mobileqq/apollo/GLTextureView$h
      //   4: dup
      //   5: aload_0
      //   6: getfield 84	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 103	com/tencent/mobileqq/apollo/GLTextureView$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 105	com/tencent/mobileqq/apollo/GLTextureView$GLThread:a	Lcom/tencent/mobileqq/apollo/GLTextureView$h;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 107	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglContext	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 109	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglSurface	Z
      //   25: iconst_0
      //   26: istore 10
      //   28: aconst_null
      //   29: astore 22
      //   31: iconst_0
      //   32: istore_1
      //   33: iconst_0
      //   34: istore_3
      //   35: iconst_0
      //   36: istore 5
      //   38: iconst_0
      //   39: istore 6
      //   41: iconst_0
      //   42: istore 7
      //   44: iconst_0
      //   45: istore 8
      //   47: iconst_0
      //   48: istore 9
      //   50: aconst_null
      //   51: astore 21
      //   53: iconst_0
      //   54: istore_2
      //   55: iconst_0
      //   56: istore 4
      //   58: invokestatic 115	java/lang/System:currentTimeMillis	()J
      //   61: pop2
      //   62: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   65: astore 23
      //   67: aload 23
      //   69: monitorenter
      //   70: iload 10
      //   72: istore 11
      //   74: iload 7
      //   76: istore 10
      //   78: iload 4
      //   80: istore 14
      //   82: aload_0
      //   83: getfield 121	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mShouldExit	Z
      //   86: ifeq +34 -> 120
      //   89: aload 23
      //   91: monitorexit
      //   92: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   95: astore 21
      //   97: aload 21
      //   99: monitorenter
      //   100: aload_0
      //   101: invokespecial 124	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   104: aload_0
      //   105: invokespecial 127	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglContextLocked	()V
      //   108: aload 21
      //   110: monitorexit
      //   111: return
      //   112: astore 22
      //   114: aload 21
      //   116: monitorexit
      //   117: aload 22
      //   119: athrow
      //   120: aload_0
      //   121: getfield 72	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   124: invokevirtual 130	java/util/ArrayList:isEmpty	()Z
      //   127: ifne +93 -> 220
      //   130: aload_0
      //   131: getfield 72	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   134: iconst_0
      //   135: invokevirtual 134	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   138: checkcast 136	java/lang/Runnable
      //   141: astore 21
      //   143: iload 10
      //   145: istore 7
      //   147: iload 6
      //   149: istore 12
      //   151: iload_1
      //   152: istore 4
      //   154: iload 11
      //   156: istore 10
      //   158: iload 7
      //   160: istore 6
      //   162: iload 12
      //   164: istore 7
      //   166: iload_2
      //   167: istore_1
      //   168: iload 14
      //   170: istore_2
      //   171: aload 23
      //   173: monitorexit
      //   174: aload 21
      //   176: ifnull +708 -> 884
      //   179: aload 21
      //   181: invokeinterface 139 1 0
      //   186: iload 6
      //   188: istore 11
      //   190: aconst_null
      //   191: astore 21
      //   193: iload_1
      //   194: istore 12
      //   196: iload_2
      //   197: istore 6
      //   199: iload 4
      //   201: istore_1
      //   202: iload 12
      //   204: istore_2
      //   205: iload 6
      //   207: istore 4
      //   209: iload 7
      //   211: istore 6
      //   213: iload 11
      //   215: istore 7
      //   217: goto -159 -> 58
      //   220: aload_0
      //   221: getfield 141	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mPaused	Z
      //   224: aload_0
      //   225: getfield 143	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mRequestPaused	Z
      //   228: if_icmpeq +1149 -> 1377
      //   231: aload_0
      //   232: getfield 143	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mRequestPaused	Z
      //   235: istore 19
      //   237: aload_0
      //   238: aload_0
      //   239: getfield 143	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mRequestPaused	Z
      //   242: putfield 141	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mPaused	Z
      //   245: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   248: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   251: iload_3
      //   252: istore 4
      //   254: aload_0
      //   255: getfield 150	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mShouldReleaseEglContext	Z
      //   258: ifeq +19 -> 277
      //   261: aload_0
      //   262: invokespecial 124	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   265: aload_0
      //   266: invokespecial 127	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglContextLocked	()V
      //   269: aload_0
      //   270: iconst_0
      //   271: putfield 150	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mShouldReleaseEglContext	Z
      //   274: iconst_1
      //   275: istore 4
      //   277: iload 10
      //   279: istore 7
      //   281: iload 10
      //   283: ifeq +14 -> 297
      //   286: aload_0
      //   287: invokespecial 124	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   290: aload_0
      //   291: invokespecial 127	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglContextLocked	()V
      //   294: iconst_0
      //   295: istore 7
      //   297: iload 19
      //   299: ifeq +14 -> 313
      //   302: aload_0
      //   303: getfield 109	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglSurface	Z
      //   306: ifeq +7 -> 313
      //   309: aload_0
      //   310: invokespecial 124	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   313: iload 19
      //   315: ifeq +48 -> 363
      //   318: aload_0
      //   319: getfield 107	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglContext	Z
      //   322: ifeq +41 -> 363
      //   325: aload_0
      //   326: getfield 84	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   329: invokevirtual 156	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   332: checkcast 6	com/tencent/mobileqq/apollo/GLTextureView
      //   335: astore 24
      //   337: aload 24
      //   339: ifnonnull +346 -> 685
      //   342: iconst_0
      //   343: istore 20
      //   345: iload 20
      //   347: ifeq +12 -> 359
      //   350: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   353: invokevirtual 161	com/tencent/mobileqq/apollo/GLTextureView$i:shouldReleaseEGLContextWhenPausing	()Z
      //   356: ifeq +7 -> 363
      //   359: aload_0
      //   360: invokespecial 127	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglContextLocked	()V
      //   363: iload 19
      //   365: ifeq +19 -> 384
      //   368: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   371: invokevirtual 164	com/tencent/mobileqq/apollo/GLTextureView$i:shouldTerminateEGLWhenPausing	()Z
      //   374: ifeq +10 -> 384
      //   377: aload_0
      //   378: getfield 105	com/tencent/mobileqq/apollo/GLTextureView$GLThread:a	Lcom/tencent/mobileqq/apollo/GLTextureView$h;
      //   381: invokevirtual 167	com/tencent/mobileqq/apollo/GLTextureView$h:finish	()V
      //   384: aload_0
      //   385: getfield 90	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHasSurface	Z
      //   388: ifne +71 -> 459
      //   391: aload_0
      //   392: getfield 169	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mWaitingForSurface	Z
      //   395: ifne +64 -> 459
      //   398: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   401: ifeq +31 -> 432
      //   404: ldc 176
      //   406: iconst_2
      //   407: new 44	java/lang/StringBuilder
      //   410: dup
      //   411: invokespecial 47	java/lang/StringBuilder:<init>	()V
      //   414: ldc 178
      //   416: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   419: aload_0
      //   420: invokevirtual 181	com/tencent/mobileqq/apollo/GLTextureView$GLThread:getId	()J
      //   423: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   426: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   429: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   432: aload_0
      //   433: getfield 109	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglSurface	Z
      //   436: ifeq +7 -> 443
      //   439: aload_0
      //   440: invokespecial 124	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   443: aload_0
      //   444: iconst_1
      //   445: putfield 169	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mWaitingForSurface	Z
      //   448: aload_0
      //   449: iconst_0
      //   450: putfield 190	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   453: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   456: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   459: aload_0
      //   460: getfield 90	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHasSurface	Z
      //   463: ifeq +21 -> 484
      //   466: aload_0
      //   467: getfield 169	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mWaitingForSurface	Z
      //   470: ifeq +14 -> 484
      //   473: aload_0
      //   474: iconst_0
      //   475: putfield 169	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mWaitingForSurface	Z
      //   478: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   481: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   484: iload 14
      //   486: istore 12
      //   488: iload 5
      //   490: istore 13
      //   492: iload 14
      //   494: ifeq +20 -> 514
      //   497: iconst_0
      //   498: istore 13
      //   500: iconst_0
      //   501: istore 12
      //   503: aload_0
      //   504: iconst_1
      //   505: putfield 192	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mRenderComplete	Z
      //   508: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   511: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   514: iload 4
      //   516: istore_3
      //   517: iload 6
      //   519: istore 15
      //   521: iload 8
      //   523: istore 16
      //   525: iload 9
      //   527: istore 17
      //   529: iload 11
      //   531: istore 18
      //   533: aload_0
      //   534: invokespecial 195	com/tencent/mobileqq/apollo/GLTextureView$GLThread:readyToDraw	()Z
      //   537: ifeq +310 -> 847
      //   540: iload 4
      //   542: istore_3
      //   543: iload 11
      //   545: istore 10
      //   547: aload_0
      //   548: getfield 107	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglContext	Z
      //   551: ifne +14 -> 565
      //   554: iload 4
      //   556: ifeq +139 -> 695
      //   559: iconst_0
      //   560: istore_3
      //   561: iload 11
      //   563: istore 10
      //   565: aload_0
      //   566: getfield 107	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglContext	Z
      //   569: ifeq +797 -> 1366
      //   572: aload_0
      //   573: getfield 109	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglSurface	Z
      //   576: ifne +790 -> 1366
      //   579: aload_0
      //   580: iconst_1
      //   581: putfield 109	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglSurface	Z
      //   584: iconst_1
      //   585: istore 9
      //   587: iconst_1
      //   588: istore 5
      //   590: iconst_1
      //   591: istore 4
      //   593: aload_0
      //   594: getfield 109	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglSurface	Z
      //   597: ifeq +789 -> 1386
      //   600: aload_0
      //   601: getfield 74	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mSizeChanged	Z
      //   604: ifeq +745 -> 1349
      //   607: iconst_1
      //   608: istore_2
      //   609: aload_0
      //   610: getfield 76	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mWidth	I
      //   613: istore 6
      //   615: aload_0
      //   616: getfield 78	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHeight	I
      //   619: istore_1
      //   620: iconst_1
      //   621: istore 8
      //   623: iconst_1
      //   624: istore 5
      //   626: aload_0
      //   627: iconst_0
      //   628: putfield 74	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mSizeChanged	Z
      //   631: aload_0
      //   632: iconst_0
      //   633: putfield 80	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mRequestRender	Z
      //   636: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   639: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   642: iload 4
      //   644: istore 11
      //   646: iload 12
      //   648: istore 4
      //   650: iload 6
      //   652: istore 12
      //   654: iload 7
      //   656: istore 6
      //   658: iload_2
      //   659: istore 7
      //   661: iload 5
      //   663: istore 9
      //   665: iload 4
      //   667: istore_2
      //   668: iload_1
      //   669: istore 4
      //   671: iload 12
      //   673: istore_1
      //   674: iload 8
      //   676: istore 5
      //   678: iload 11
      //   680: istore 8
      //   682: goto -511 -> 171
      //   685: aload 24
      //   687: invokestatic 199	com/tencent/mobileqq/apollo/GLTextureView:access$1300	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
      //   690: istore 20
      //   692: goto -347 -> 345
      //   695: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   698: aload_0
      //   699: invokevirtual 202	com/tencent/mobileqq/apollo/GLTextureView$i:a	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)Z
      //   702: istore 19
      //   704: iload 4
      //   706: istore_3
      //   707: iload 11
      //   709: istore 10
      //   711: iload 19
      //   713: ifeq -148 -> 565
      //   716: aload_0
      //   717: getfield 105	com/tencent/mobileqq/apollo/GLTextureView$GLThread:a	Lcom/tencent/mobileqq/apollo/GLTextureView$h;
      //   720: invokevirtual 205	com/tencent/mobileqq/apollo/GLTextureView$h:start	()V
      //   723: aload_0
      //   724: getfield 84	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   727: invokevirtual 156	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   730: checkcast 6	com/tencent/mobileqq/apollo/GLTextureView
      //   733: astore 24
      //   735: aload 24
      //   737: ifnull +90 -> 827
      //   740: aload 24
      //   742: invokestatic 208	com/tencent/mobileqq/apollo/GLTextureView:access$700	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
      //   745: istore 19
      //   747: iload 19
      //   749: ifeq +78 -> 827
      //   752: aload 23
      //   754: monitorexit
      //   755: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   758: astore 21
      //   760: aload 21
      //   762: monitorenter
      //   763: aload_0
      //   764: invokespecial 124	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   767: aload_0
      //   768: invokespecial 127	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglContextLocked	()V
      //   771: aload 21
      //   773: monitorexit
      //   774: return
      //   775: astore 22
      //   777: aload 21
      //   779: monitorexit
      //   780: aload 22
      //   782: athrow
      //   783: astore 21
      //   785: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   788: aload_0
      //   789: invokevirtual 211	com/tencent/mobileqq/apollo/GLTextureView$i:b	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)V
      //   792: aload 21
      //   794: athrow
      //   795: astore 21
      //   797: aload 23
      //   799: monitorexit
      //   800: aload 21
      //   802: athrow
      //   803: astore 22
      //   805: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   808: astore 21
      //   810: aload 21
      //   812: monitorenter
      //   813: aload_0
      //   814: invokespecial 124	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   817: aload_0
      //   818: invokespecial 127	com/tencent/mobileqq/apollo/GLTextureView$GLThread:stopEglContextLocked	()V
      //   821: aload 21
      //   823: monitorexit
      //   824: aload 22
      //   826: athrow
      //   827: aload_0
      //   828: iconst_1
      //   829: putfield 107	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mHaveEglContext	Z
      //   832: iconst_1
      //   833: istore 10
      //   835: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   838: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   841: iload 4
      //   843: istore_3
      //   844: goto -279 -> 565
      //   847: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   850: invokevirtual 214	java/lang/Object:wait	()V
      //   853: iload 12
      //   855: istore 14
      //   857: iload 13
      //   859: istore 5
      //   861: iload 15
      //   863: istore 6
      //   865: iload 7
      //   867: istore 10
      //   869: iload 16
      //   871: istore 8
      //   873: iload 17
      //   875: istore 9
      //   877: iload 18
      //   879: istore 11
      //   881: goto -799 -> 82
      //   884: iload 9
      //   886: ifeq +460 -> 1346
      //   889: aload_0
      //   890: getfield 105	com/tencent/mobileqq/apollo/GLTextureView$GLThread:a	Lcom/tencent/mobileqq/apollo/GLTextureView$h;
      //   893: invokevirtual 217	com/tencent/mobileqq/apollo/GLTextureView$h:createSurface	()Z
      //   896: ifeq +359 -> 1255
      //   899: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   902: astore 23
      //   904: aload 23
      //   906: monitorenter
      //   907: aload_0
      //   908: iconst_1
      //   909: putfield 219	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mFinishedCreatingEglSurface	Z
      //   912: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   915: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   918: aload 23
      //   920: monitorexit
      //   921: iconst_0
      //   922: istore 9
      //   924: iload 8
      //   926: ifeq +417 -> 1343
      //   929: aload_0
      //   930: getfield 105	com/tencent/mobileqq/apollo/GLTextureView$GLThread:a	Lcom/tencent/mobileqq/apollo/GLTextureView$h;
      //   933: invokevirtual 223	com/tencent/mobileqq/apollo/GLTextureView$h:createGL	()Ljavax/microedition/khronos/opengles/GL;
      //   936: checkcast 225	javax/microedition/khronos/opengles/GL10
      //   939: astore 22
      //   941: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   944: aload 22
      //   946: invokevirtual 229	com/tencent/mobileqq/apollo/GLTextureView$i:checkGLDriver	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   949: iconst_0
      //   950: istore 8
      //   952: iload 10
      //   954: istore 11
      //   956: iload 10
      //   958: ifeq +42 -> 1000
      //   961: aload_0
      //   962: getfield 84	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   965: invokevirtual 156	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   968: checkcast 6	com/tencent/mobileqq/apollo/GLTextureView
      //   971: astore 23
      //   973: aload 23
      //   975: ifnull +430 -> 1405
      //   978: aload 23
      //   980: invokestatic 233	com/tencent/mobileqq/apollo/GLTextureView:access$1400	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   983: aload 22
      //   985: aload_0
      //   986: getfield 105	com/tencent/mobileqq/apollo/GLTextureView$GLThread:a	Lcom/tencent/mobileqq/apollo/GLTextureView$h;
      //   989: getfield 237	com/tencent/mobileqq/apollo/GLTextureView$h:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   992: invokeinterface 243 3 0
      //   997: goto +408 -> 1405
      //   1000: iload 7
      //   1002: istore 10
      //   1004: iload 7
      //   1006: ifeq +52 -> 1058
      //   1009: aload_0
      //   1010: getfield 84	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1013: invokevirtual 156	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1016: checkcast 6	com/tencent/mobileqq/apollo/GLTextureView
      //   1019: astore 23
      //   1021: aload 23
      //   1023: ifnull +388 -> 1411
      //   1026: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1029: ifeq +11 -> 1040
      //   1032: ldc 176
      //   1034: iconst_2
      //   1035: ldc 245
      //   1037: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1040: aload 23
      //   1042: invokestatic 233	com/tencent/mobileqq/apollo/GLTextureView:access$1400	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   1045: aload 22
      //   1047: iload_1
      //   1048: iload 4
      //   1050: invokeinterface 249 4 0
      //   1055: goto +356 -> 1411
      //   1058: invokestatic 115	java/lang/System:currentTimeMillis	()J
      //   1061: pop2
      //   1062: aload_0
      //   1063: getfield 84	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1066: invokevirtual 156	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1069: checkcast 6	com/tencent/mobileqq/apollo/GLTextureView
      //   1072: astore 23
      //   1074: aload 23
      //   1076: ifnull +50 -> 1126
      //   1079: aload 23
      //   1081: invokestatic 233	com/tencent/mobileqq/apollo/GLTextureView:access$1400	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   1084: aload 22
      //   1086: invokeinterface 252 2 0
      //   1091: aload 23
      //   1093: invokestatic 255	com/tencent/mobileqq/apollo/GLTextureView:access$1500	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
      //   1096: ifne +30 -> 1126
      //   1099: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1102: ifeq +12 -> 1114
      //   1105: ldc 176
      //   1107: iconst_2
      //   1108: ldc_w 257
      //   1111: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1114: aload 23
      //   1116: iconst_1
      //   1117: invokestatic 261	com/tencent/mobileqq/apollo/GLTextureView:access$1502	(Lcom/tencent/mobileqq/apollo/GLTextureView;Z)Z
      //   1120: pop
      //   1121: aload 23
      //   1123: invokevirtual 264	com/tencent/mobileqq/apollo/GLTextureView:checkSetAlpha	()V
      //   1126: invokestatic 115	java/lang/System:currentTimeMillis	()J
      //   1129: pop2
      //   1130: aload_0
      //   1131: getfield 105	com/tencent/mobileqq/apollo/GLTextureView$GLThread:a	Lcom/tencent/mobileqq/apollo/GLTextureView$h;
      //   1134: invokevirtual 267	com/tencent/mobileqq/apollo/GLTextureView$h:swap	()I
      //   1137: istore 12
      //   1139: invokestatic 115	java/lang/System:currentTimeMillis	()J
      //   1142: pop2
      //   1143: iload 6
      //   1145: istore 7
      //   1147: iload 12
      //   1149: lookupswitch	default:+268->1417, 12288:+64->1213, 12302:+172->1321
      //   1177: aconst_null
      //   1178: fconst_1
      //   1179: ldc_w 270
      //   1182: iload 12
      //   1184: invokestatic 274	com/tencent/mobileqq/apollo/GLTextureView$h:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1187: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   1190: astore 23
      //   1192: aload 23
      //   1194: monitorenter
      //   1195: aload_0
      //   1196: iconst_1
      //   1197: putfield 190	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   1200: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   1203: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1206: aload 23
      //   1208: monitorexit
      //   1209: iload 6
      //   1211: istore 7
      //   1213: iload 5
      //   1215: ifeq +168 -> 1383
      //   1218: iconst_1
      //   1219: istore_2
      //   1220: iload_1
      //   1221: istore 12
      //   1223: iload_2
      //   1224: istore 6
      //   1226: iload 4
      //   1228: istore_1
      //   1229: iload 12
      //   1231: istore_2
      //   1232: iload 6
      //   1234: istore 4
      //   1236: iload 10
      //   1238: istore 6
      //   1240: iload 11
      //   1242: istore 10
      //   1244: goto -1186 -> 58
      //   1247: astore 21
      //   1249: aload 23
      //   1251: monitorexit
      //   1252: aload 21
      //   1254: athrow
      //   1255: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   1258: astore 23
      //   1260: aload 23
      //   1262: monitorenter
      //   1263: aload_0
      //   1264: iconst_1
      //   1265: putfield 219	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mFinishedCreatingEglSurface	Z
      //   1268: aload_0
      //   1269: iconst_1
      //   1270: putfield 190	com/tencent/mobileqq/apollo/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   1273: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   1276: invokevirtual 148	java/lang/Object:notifyAll	()V
      //   1279: aload 23
      //   1281: monitorexit
      //   1282: iload 6
      //   1284: istore 11
      //   1286: iload_1
      //   1287: istore 12
      //   1289: iload_2
      //   1290: istore 6
      //   1292: iload 4
      //   1294: istore_1
      //   1295: iload 12
      //   1297: istore_2
      //   1298: iload 6
      //   1300: istore 4
      //   1302: iload 7
      //   1304: istore 6
      //   1306: iload 11
      //   1308: istore 7
      //   1310: goto -1252 -> 58
      //   1313: astore 21
      //   1315: aload 23
      //   1317: monitorexit
      //   1318: aload 21
      //   1320: athrow
      //   1321: iconst_1
      //   1322: istore 7
      //   1324: goto -111 -> 1213
      //   1327: astore 21
      //   1329: aload 23
      //   1331: monitorexit
      //   1332: aload 21
      //   1334: athrow
      //   1335: astore 22
      //   1337: aload 21
      //   1339: monitorexit
      //   1340: aload 22
      //   1342: athrow
      //   1343: goto -391 -> 952
      //   1346: goto -422 -> 924
      //   1349: iload 13
      //   1351: istore 8
      //   1353: iload_2
      //   1354: istore 6
      //   1356: iload 5
      //   1358: istore_2
      //   1359: iload 9
      //   1361: istore 5
      //   1363: goto -732 -> 631
      //   1366: iload 6
      //   1368: istore 5
      //   1370: iload 8
      //   1372: istore 4
      //   1374: goto -781 -> 593
      //   1377: iconst_0
      //   1378: istore 19
      //   1380: goto -1129 -> 251
      //   1383: goto -163 -> 1220
      //   1386: iload 5
      //   1388: istore 15
      //   1390: iload 4
      //   1392: istore 16
      //   1394: iload 9
      //   1396: istore 17
      //   1398: iload 10
      //   1400: istore 18
      //   1402: goto -555 -> 847
      //   1405: iconst_0
      //   1406: istore 11
      //   1408: goto -408 -> 1000
      //   1411: iconst_0
      //   1412: istore 10
      //   1414: goto -356 -> 1058
      //   1417: goto -241 -> 1176
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1420	0	this	GLThread
      //   32	1263	1	i	int
      //   54	1305	2	j	int
      //   34	810	3	k	int
      //   56	1335	4	m	int
      //   36	1351	5	n	int
      //   39	1328	6	i1	int
      //   42	1281	7	i2	int
      //   45	1326	8	i3	int
      //   48	1347	9	i4	int
      //   26	1387	10	i5	int
      //   72	1335	11	i6	int
      //   149	1147	12	i7	int
      //   490	860	13	i8	int
      //   80	776	14	i9	int
      //   519	870	15	i10	int
      //   523	870	16	i11	int
      //   527	870	17	i12	int
      //   531	870	18	i13	int
      //   235	1144	19	bool1	boolean
      //   343	348	20	bool2	boolean
      //   51	727	21	localObject1	Object
      //   783	10	21	localRuntimeException	RuntimeException
      //   795	6	21	localObject2	Object
      //   808	14	21	locali	GLTextureView.i
      //   1247	6	21	localObject3	Object
      //   1313	6	21	localObject4	Object
      //   1327	11	21	localObject5	Object
      //   29	1	22	localObject6	Object
      //   112	6	22	localObject7	Object
      //   775	6	22	localObject8	Object
      //   803	22	22	localObject9	Object
      //   939	146	22	localGL10	javax.microedition.khronos.opengles.GL10
      //   1335	6	22	localObject10	Object
      //   335	406	24	localGLTextureView	GLTextureView
      // Exception table:
      //   from	to	target	type
      //   100	111	112	finally
      //   114	117	112	finally
      //   763	774	775	finally
      //   777	780	775	finally
      //   716	735	783	java/lang/RuntimeException
      //   740	747	783	java/lang/RuntimeException
      //   82	92	795	finally
      //   120	143	795	finally
      //   171	174	795	finally
      //   220	251	795	finally
      //   254	274	795	finally
      //   286	294	795	finally
      //   302	313	795	finally
      //   318	337	795	finally
      //   350	359	795	finally
      //   359	363	795	finally
      //   368	384	795	finally
      //   384	432	795	finally
      //   432	443	795	finally
      //   443	459	795	finally
      //   459	484	795	finally
      //   503	514	795	finally
      //   533	540	795	finally
      //   547	554	795	finally
      //   565	584	795	finally
      //   593	607	795	finally
      //   609	620	795	finally
      //   626	631	795	finally
      //   631	642	795	finally
      //   685	692	795	finally
      //   695	704	795	finally
      //   716	735	795	finally
      //   740	747	795	finally
      //   752	755	795	finally
      //   785	795	795	finally
      //   797	800	795	finally
      //   827	832	795	finally
      //   835	841	795	finally
      //   847	853	795	finally
      //   58	70	803	finally
      //   179	186	803	finally
      //   800	803	803	finally
      //   889	907	803	finally
      //   929	949	803	finally
      //   961	973	803	finally
      //   978	997	803	finally
      //   1009	1021	803	finally
      //   1026	1040	803	finally
      //   1040	1055	803	finally
      //   1058	1074	803	finally
      //   1079	1114	803	finally
      //   1114	1126	803	finally
      //   1126	1143	803	finally
      //   1176	1195	803	finally
      //   1252	1255	803	finally
      //   1255	1263	803	finally
      //   1318	1321	803	finally
      //   1332	1335	803	finally
      //   907	921	1247	finally
      //   1249	1252	1247	finally
      //   1263	1282	1313	finally
      //   1315	1318	1313	finally
      //   1195	1209	1327	finally
      //   1329	1332	1327	finally
      //   813	824	1335	finally
      //   1337	1340	1335	finally
    }
    
    private boolean readyToDraw()
    {
      return (!this.mPaused) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mRequestRender) || (this.mRenderMode == 1));
    }
    
    private void stopEglContextLocked()
    {
      if (this.mHaveEglContext)
      {
        this.a.finish();
        this.mHaveEglContext = false;
        GLTextureView.sGLThreadManager.b(this);
      }
    }
    
    private void stopEglSurfaceLocked()
    {
      if (this.mHaveEglSurface)
      {
        this.mHaveEglSurface = false;
        this.a.destroySurface();
      }
    }
    
    public int getRenderMode()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        int i = this.mRenderMode;
        return i;
      }
    }
    
    public void onPause()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mRequestPaused = true;
        GLTextureView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if (!this.mExited)
          {
            boolean bool = this.mPaused;
            if (!bool) {
              try
              {
                GLTextureView.sGLThreadManager.wait();
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
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mRequestPaused = false;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        GLTextureView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (this.mPaused))
          {
            boolean bool = this.mRenderComplete;
            if (!bool) {
              try
              {
                GLTextureView.sGLThreadManager.wait();
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
    
    public void onWindowResize(int paramInt1, int paramInt2)
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        this.mSizeChanged = true;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void queueEvent(Runnable paramRunnable)
    {
      if (paramRunnable == null) {
        throw new IllegalArgumentException("r must not be null");
      }
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mEventQueue.remove(paramRunnable);
        this.mEventQueue.add(paramRunnable);
        if (this.mEventQueue.size() > 100) {
          QLog.e("GLTextureView", 1, new Object[] { "GLThread runable queueList size is > 100, last r:", paramRunnable });
        }
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void requestExitAndWait()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mShouldExit = true;
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void requestReleaseEglContextLocked()
    {
      this.mShouldReleaseEglContext = true;
      GLTextureView.sGLThreadManager.notifyAll();
    }
    
    public void requestRender()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mRequestRender = true;
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 317	com/tencent/mobileqq/apollo/GLTextureView$GLThread:guardedRun	()V
      //   4: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   7: aload_0
      //   8: invokevirtual 319	com/tencent/mobileqq/apollo/GLTextureView$i:a	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)V
      //   11: return
      //   12: astore_1
      //   13: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   16: aload_0
      //   17: invokevirtual 319	com/tencent/mobileqq/apollo/GLTextureView$i:a	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)V
      //   20: return
      //   21: astore_1
      //   22: invokestatic 119	com/tencent/mobileqq/apollo/GLTextureView:access$1200	()Lcom/tencent/mobileqq/apollo/GLTextureView$i;
      //   25: aload_0
      //   26: invokevirtual 319	com/tencent/mobileqq/apollo/GLTextureView$i:a	(Lcom/tencent/mobileqq/apollo/GLTextureView$GLThread;)V
      //   29: aload_1
      //   30: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	GLThread
      //   12	1	1	localInterruptedException	InterruptedException
      //   21	9	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	4	12	java/lang/InterruptedException
      //   0	4	21	finally
    }
    
    public void setRenderMode(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1)) {
        throw new IllegalArgumentException("renderMode");
      }
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mRenderMode = paramInt;
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void surfaceCreated()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mHasSurface = true;
        this.mFinishedCreatingEglSurface = false;
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void surfaceDestroyed()
    {
      synchronized (GLTextureView.sGLThreadManager)
      {
        this.mHasSurface = false;
        GLTextureView.sGLThreadManager.notifyAll();
        return;
      }
    }
  }
  
  abstract class a
    implements GLTextureView.e
  {
    protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);
    
    public a(int[] paramArrayOfInt) {}
    
    private int[] filterConfigSpec(int[] paramArrayOfInt)
    {
      if ((GLTextureView.this.mEGLContextClientVersion != 2) && (GLTextureView.this.mEGLContextClientVersion != 3)) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
      arrayOfInt[(i - 1)] = 12352;
      if (GLTextureView.this.mEGLContextClientVersion == 2) {
        arrayOfInt[i] = 4;
      }
      for (;;)
      {
        arrayOfInt[(i + 1)] = 12344;
        return arrayOfInt;
        arrayOfInt[i] = 64;
      }
    }
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mConfigSpec, arrayOfEGLConfig, i, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      paramEGL10 = chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null) {
        throw new IllegalArgumentException("No config chosen");
      }
      return paramEGL10;
    }
    
    abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
  }
  
  class b
    extends GLTextureView.a
  {
    protected int mAlphaSize;
    protected int mBlueSize;
    protected int mDepthSize;
    protected int mGreenSize;
    protected int mRedSize;
    protected int mStencilSize;
    private int[] mValue = new int[1];
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      super(new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 });
      this.mRedSize = paramInt1;
      this.mGreenSize = paramInt2;
      this.mBlueSize = paramInt3;
      this.mAlphaSize = paramInt4;
      this.mDepthSize = paramInt5;
      this.mStencilSize = paramInt6;
    }
    
    private int findConfigAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
    {
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.mValue)) {
        paramInt2 = this.mValue[0];
      }
      return paramInt2;
    }
    
    public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
        int m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
        if ((k >= this.mDepthSize) && (m >= this.mStencilSize))
        {
          k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
          m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
          int n = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
          int i1 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
          if ((k == this.mRedSize) && (m == this.mGreenSize) && (n == this.mBlueSize) && (i1 == this.mAlphaSize)) {
            return localEGLConfig;
          }
        }
        i += 1;
      }
      return null;
    }
  }
  
  class c
    implements GLTextureView.f
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    
    private c() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
      arrayOfInt[1] = GLTextureView.this.mEGLContextClientVersion;
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (GLTextureView.this.mEGLContextClientVersion != 0) {}
      for (;;)
      {
        return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        arrayOfInt = null;
      }
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
        GLTextureView.h.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
      }
    }
  }
  
  static class d
    implements GLTextureView.g
  {
    public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (Throwable paramEGL10)
      {
        Log.e("GLTextureView", "eglCreateWindowSurface", paramEGL10);
      }
      return null;
    }
    
    public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  public static abstract interface e
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface f
  {
    public abstract EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface g
  {
    public abstract EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  static class h
  {
    EGL10 mEgl;
    EGLConfig mEglConfig;
    EGLContext mEglContext;
    EGLDisplay mEglDisplay;
    EGLSurface mEglSurface;
    private WeakReference<GLTextureView> mGLTextureViewWeakRef;
    
    public h(WeakReference<GLTextureView> paramWeakReference)
    {
      this.mGLTextureViewWeakRef = paramWeakReference;
    }
    
    private void destroySurfaceImp()
    {
      if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
      {
        this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
        if (localGLTextureView != null) {
          localGLTextureView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
        }
        this.mEglSurface = null;
      }
    }
    
    public static String formatEglError(String paramString, int paramInt)
    {
      return paramString + " failed: " + getErrorString(paramInt);
    }
    
    public static String getErrorString(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return getHex(paramInt);
      case 12288: 
        return "EGL_SUCCESS";
      case 12289: 
        return "EGL_NOT_INITIALIZED";
      case 12290: 
        return "EGL_BAD_ACCESS";
      case 12291: 
        return "EGL_BAD_ALLOC";
      case 12292: 
        return "EGL_BAD_ATTRIBUTE";
      case 12293: 
        return "EGL_BAD_CONFIG";
      case 12294: 
        return "EGL_BAD_CONTEXT";
      case 12295: 
        return "EGL_BAD_CURRENT_SURFACE";
      case 12296: 
        return "EGL_BAD_DISPLAY";
      case 12297: 
        return "EGL_BAD_MATCH";
      case 12298: 
        return "EGL_BAD_NATIVE_PIXMAP";
      case 12299: 
        return "EGL_BAD_NATIVE_WINDOW";
      case 12300: 
        return "EGL_BAD_PARAMETER";
      case 12301: 
        return "EGL_BAD_SURFACE";
      }
      return "EGL_CONTEXT_LOST";
    }
    
    private static String getHex(int paramInt)
    {
      return "0x" + Integer.toHexString(paramInt);
    }
    
    public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
    {
      Log.w(paramString1, formatEglError(paramString2, paramInt));
    }
    
    private void throwEglException(String paramString)
    {
      throwEglException(paramString, this.mEgl.eglGetError());
    }
    
    public static void throwEglException(String paramString, int paramInt)
    {
      throw new RuntimeException(formatEglError(paramString, paramInt));
    }
    
    GL createGL()
    {
      GL localGL2 = this.mEglContext.getGL();
      GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
      Object localObject = localGL2;
      GL localGL1;
      int i;
      if (localGLTextureView != null)
      {
        localGL1 = localGL2;
        if (localGLTextureView.mGLWrapper != null) {
          localGL1 = localGLTextureView.mGLWrapper.wrap(localGL2);
        }
        localObject = localGL1;
        if ((localGLTextureView.mDebugFlags & 0x3) != 0)
        {
          i = 0;
          if ((localGLTextureView.mDebugFlags & 0x1) != 0) {
            i = 1;
          }
          if ((localGLTextureView.mDebugFlags & 0x2) == 0) {
            break label106;
          }
        }
      }
      label106:
      for (localObject = new GLTextureView.k();; localObject = null)
      {
        localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
        return localObject;
      }
    }
    
    public boolean createSurface()
    {
      if (this.mEgl == null) {
        throw new RuntimeException("egl not initialized");
      }
      if (this.mEglDisplay == null) {
        throw new RuntimeException("eglDisplay not initialized");
      }
      if (this.mEglConfig == null) {
        throw new RuntimeException("mEglConfig not initialized");
      }
      destroySurfaceImp();
      GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
      if ((localGLTextureView != null) && (localGLTextureView.getSurfaceTexture() != null)) {}
      for (this.mEglSurface = localGLTextureView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, localGLTextureView.getSurfaceTexture()); (this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE); this.mEglSurface = null)
      {
        if (this.mEgl.eglGetError() == 12299) {
          Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        }
        return false;
      }
      if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
      {
        logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
        return false;
      }
      return true;
    }
    
    public void destroySurface()
    {
      destroySurfaceImp();
    }
    
    public void finish()
    {
      if (this.mEglContext != null)
      {
        GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
        if (localGLTextureView != null) {
          localGLTextureView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
        }
        this.mEglContext = null;
      }
      if (this.mEglDisplay != null)
      {
        this.mEgl.eglTerminate(this.mEglDisplay);
        this.mEglDisplay = null;
      }
    }
    
    public void start()
    {
      this.mEgl = ((EGL10)EGLContext.getEGL());
      this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
        throw new RuntimeException("eglGetDisplay failed");
      }
      Object localObject = new int[2];
      if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject)) {
        throw new RuntimeException("eglInitialize failed");
      }
      localObject = (GLTextureView)this.mGLTextureViewWeakRef.get();
      if (localObject == null)
      {
        this.mEglConfig = null;
        this.mEglContext = null;
      }
      for (;;)
      {
        if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
        {
          this.mEglContext = null;
          if (localObject != null) {
            GLTextureView.access$702((GLTextureView)localObject, true);
          }
        }
        try
        {
          throwEglException("createContext");
          this.mEglSurface = null;
          return;
          this.mEglConfig = ((GLTextureView)localObject).mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
          this.mEglContext = ((GLTextureView)localObject).mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("GLTextureView", 1, localException, new Object[0]);
          }
        }
      }
    }
    
    public int swap()
    {
      if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
        return this.mEgl.eglGetError();
      }
      return 12288;
    }
  }
  
  static class i
  {
    private static String TAG = "GLThreadManager";
    private GLTextureView.GLThread a;
    private boolean mGLESDriverCheckComplete;
    private int mGLESVersion;
    private boolean mGLESVersionCheckComplete;
    private boolean mLimitedGLESContexts;
    private boolean mMultipleGLESContextsAllowed;
    
    private void checkGLESVersion()
    {
      if (!this.mGLESVersionCheckComplete)
      {
        this.mGLESVersion = GLTextureView.sGLESVersion;
        if (this.mGLESVersion >= 131072) {
          this.mMultipleGLESContextsAllowed = true;
        }
        this.mGLESVersionCheckComplete = true;
      }
    }
    
    public void a(GLTextureView.GLThread paramGLThread)
    {
      try
      {
        GLTextureView.GLThread.b(paramGLThread, true);
        if (this.a == paramGLThread) {
          this.a = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
    
    public boolean a(GLTextureView.GLThread paramGLThread)
    {
      if ((this.a == paramGLThread) || (this.a == null))
      {
        this.a = paramGLThread;
        notifyAll();
      }
      do
      {
        return true;
        checkGLESVersion();
      } while (this.mMultipleGLESContextsAllowed);
      if (this.a != null) {
        this.a.requestReleaseEglContextLocked();
      }
      return false;
    }
    
    public void b(GLTextureView.GLThread paramGLThread)
    {
      if (this.a == paramGLThread) {
        this.a = null;
      }
      notifyAll();
    }
    
    /* Error */
    public void checkGLDriver(javax.microedition.khronos.opengles.GL10 paramGL10)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 64	com/tencent/mobileqq/apollo/GLTextureView$i:mGLESDriverCheckComplete	Z
      //   8: ifne +65 -> 73
      //   11: aload_0
      //   12: invokespecial 57	com/tencent/mobileqq/apollo/GLTextureView$i:checkGLESVersion	()V
      //   15: aload_1
      //   16: sipush 7937
      //   19: invokeinterface 70 2 0
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 39	com/tencent/mobileqq/apollo/GLTextureView$i:mGLESVersion	I
      //   29: ldc 40
      //   31: if_icmpge +23 -> 54
      //   34: aload_1
      //   35: ldc 72
      //   37: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   40: ifne +36 -> 76
      //   43: iconst_1
      //   44: istore_2
      //   45: aload_0
      //   46: iload_2
      //   47: putfield 42	com/tencent/mobileqq/apollo/GLTextureView$i:mMultipleGLESContextsAllowed	Z
      //   50: aload_0
      //   51: invokevirtual 54	java/lang/Object:notifyAll	()V
      //   54: aload_0
      //   55: getfield 42	com/tencent/mobileqq/apollo/GLTextureView$i:mMultipleGLESContextsAllowed	Z
      //   58: ifne +23 -> 81
      //   61: iload_3
      //   62: istore_2
      //   63: aload_0
      //   64: iload_2
      //   65: putfield 80	com/tencent/mobileqq/apollo/GLTextureView$i:mLimitedGLESContexts	Z
      //   68: aload_0
      //   69: iconst_1
      //   70: putfield 64	com/tencent/mobileqq/apollo/GLTextureView$i:mGLESDriverCheckComplete	Z
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
      //   0	91	0	this	i
      //   0	91	1	paramGL10	javax.microedition.khronos.opengles.GL10
      //   44	39	2	bool1	boolean
      //   1	61	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	43	86	finally
      //   45	54	86	finally
      //   54	61	86	finally
      //   63	73	86	finally
    }
    
    public boolean shouldReleaseEGLContextWhenPausing()
    {
      try
      {
        boolean bool = this.mLimitedGLESContexts;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public boolean shouldTerminateEGLWhenPausing()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial 57	com/tencent/mobileqq/apollo/GLTextureView$i:checkGLESVersion	()V
      //   6: aload_0
      //   7: getfield 42	com/tencent/mobileqq/apollo/GLTextureView$i:mMultipleGLESContextsAllowed	Z
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
      //   0	31	0	this	i
      //   10	13	1	bool	boolean
      //   26	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	11	26	finally
    }
  }
  
  public static abstract interface j
  {
    public abstract GL wrap(GL paramGL);
  }
  
  static class k
    extends Writer
  {
    private StringBuilder mBuilder = new StringBuilder();
    
    private void flushBuilder()
    {
      if (this.mBuilder.length() > 0)
      {
        Log.v("GLTextureView", this.mBuilder.toString());
        this.mBuilder.delete(0, this.mBuilder.length());
      }
    }
    
    public void close()
    {
      flushBuilder();
    }
    
    public void flush()
    {
      flushBuilder();
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      int i = 0;
      if (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          flushBuilder();
        }
        for (;;)
        {
          i += 1;
          break;
          this.mBuilder.append(c);
        }
      }
    }
  }
  
  class l
    extends GLTextureView.b
  {
    public l(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.GLTextureView
 * JD-Core Version:    0.7.0.1
 */