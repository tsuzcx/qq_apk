package com.tencent.qg.sdk;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
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

public class QGJavaScriptView
  extends SurfaceView
  implements SurfaceHolder.Callback2
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
  private static final String TAG = "EJJavaScriptView";
  protected static final GLThreadManager sGLThreadManager = new GLThreadManager(null);
  protected int mDebugFlags;
  protected boolean mDetached;
  protected EGLConfigChooser mEGLConfigChooser;
  protected int mEGLContextClientVersion;
  protected EGLContextFactory mEGLContextFactory;
  protected EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  protected GLThread mGLThread;
  protected GLWrapper mGLWrapper;
  protected boolean mPreserveEGLContextOnPause;
  protected Renderer mRenderer;
  protected final WeakReference<QGJavaScriptView> mThisWeakRef = new WeakReference(this);
  protected EGLConfig sharedEGLConfig = null;
  protected EGLContext sharedEGLContext = null;
  
  public QGJavaScriptView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QGJavaScriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void checkRenderThreadState()
  {
    if (this.mGLThread != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  public static String getErrorString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0x" + Integer.toHexString(paramInt);
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
  
  private void init()
  {
    getHolder().addCallback(this);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.mGLThread != null)
      {
        Log.e("EJJavaScriptView", "finalize");
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mDetached) && (this.mRenderer != null)) {
      if (this.mGLThread == null) {
        break label74;
      }
    }
    label74:
    for (int i = this.mGLThread.getRenderMode();; i = 1)
    {
      this.mGLThread = new GLThread(this.mThisWeakRef);
      if (i != 1) {
        this.mGLThread.setRenderMode(i);
      }
      this.mGLThread.start();
      this.mDetached = false;
      return;
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
  
  public int presentRenderbuffer()
  {
    return this.mGLThread.swap();
  }
  
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
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new ComponentSizeChooser(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(EGLConfigChooser paramEGLConfigChooser)
  {
    checkRenderThreadState();
    this.mEGLConfigChooser = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new SimpleEGLConfigChooser(paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
  }
  
  public void setEGLContextFactory(EGLContextFactory paramEGLContextFactory)
  {
    checkRenderThreadState();
    this.mEGLContextFactory = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
  }
  
  public void setGLWrapper(GLWrapper paramGLWrapper)
  {
    this.mGLWrapper = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mGLThread.setRenderMode(paramInt);
  }
  
  public void setRenderer(Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null) {
      this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
    }
    if (this.mEGLContextFactory == null) {
      this.mEGLContextFactory = new DefaultContextFactory(null);
    }
    if (this.mEGLWindowSurfaceFactory == null) {
      this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory(null);
    }
    this.mRenderer = paramRenderer;
    this.mGLThread = new GLThread(this.mThisWeakRef);
    this.mGLThread.start();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGLThread.onWindowResize(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.surfaceCreated();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.surfaceDestroyed();
  }
  
  @Deprecated
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeededAsync(SurfaceHolder paramSurfaceHolder, Runnable paramRunnable)
  {
    if (this.mGLThread != null) {
      this.mGLThread.requestRenderAndNotify(paramRunnable);
    }
  }
  
  abstract class BaseConfigChooser
    implements QGJavaScriptView.EGLConfigChooser
  {
    protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);
    
    public BaseConfigChooser(int[] paramArrayOfInt) {}
    
    private int[] filterConfigSpec(int[] paramArrayOfInt)
    {
      if ((QGJavaScriptView.this.mEGLContextClientVersion != 2) && (QGJavaScriptView.this.mEGLContextClientVersion != 3)) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
      arrayOfInt[(i - 1)] = 12352;
      if (QGJavaScriptView.this.mEGLContextClientVersion == 2) {
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
  
  class ComponentSizeChooser
    extends QGJavaScriptView.BaseConfigChooser
  {
    protected int mAlphaSize;
    protected int mBlueSize;
    protected int mDepthSize;
    protected int mGreenSize;
    protected int mRedSize;
    protected int mStencilSize;
    private int[] mValue = new int[1];
    
    public ComponentSizeChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
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
  
  class DefaultContextFactory
    implements QGJavaScriptView.EGLContextFactory
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    
    private DefaultContextFactory() {}
    
    public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      int[] arrayOfInt1 = new int[3];
      arrayOfInt1[0] = this.EGL_CONTEXT_CLIENT_VERSION;
      arrayOfInt1[1] = QGJavaScriptView.this.mEGLContextClientVersion;
      arrayOfInt1[2] = 12344;
      Object localObject;
      EGLContext localEGLContext;
      label59:
      int[] arrayOfInt2;
      if (QGJavaScriptView.this.sharedEGLConfig == null)
      {
        localObject = paramEGLConfig;
        if (QGJavaScriptView.this.sharedEGLContext != null) {
          break label163;
        }
        localEGLContext = EGL10.EGL_NO_CONTEXT;
        if (QGJavaScriptView.this.mEGLContextClientVersion == 0) {
          break label175;
        }
        arrayOfInt2 = arrayOfInt1;
        label73:
        localObject = paramEGL10.eglCreateContext(paramEGLDisplay, (EGLConfig)localObject, localEGLContext, arrayOfInt2);
        if (((EGL10)EGLContext.getEGL()).eglGetError() != 12294) {
          break label198;
        }
        QGJavaScriptView.this.sharedEGLContext = null;
        if (QGJavaScriptView.this.sharedEGLConfig != null) {
          break label181;
        }
        label123:
        localObject = EGL10.EGL_NO_CONTEXT;
        if (QGJavaScriptView.this.mEGLContextClientVersion == 0) {
          break label192;
        }
      }
      for (;;)
      {
        return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, (EGLContext)localObject, arrayOfInt1);
        localObject = QGJavaScriptView.this.sharedEGLConfig;
        break;
        label163:
        localEGLContext = QGJavaScriptView.this.sharedEGLContext;
        break label59;
        label175:
        arrayOfInt2 = null;
        break label73;
        label181:
        paramEGLConfig = QGJavaScriptView.this.sharedEGLConfig;
        break label123;
        label192:
        arrayOfInt1 = null;
      }
      label198:
      return localObject;
    }
    
    public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
        QGJavaScriptView.EglHelper.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
      }
    }
  }
  
  static class DefaultWindowSurfaceFactory
    implements QGJavaScriptView.EGLWindowSurfaceFactory
  {
    public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        Log.e("EJJavaScriptView", "eglCreateWindowSurface", paramEGL10);
      }
      return null;
    }
    
    public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    }
  }
  
  public static abstract interface EGLConfigChooser
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface EGLContextFactory
  {
    public abstract EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface EGLWindowSurfaceFactory
  {
    public abstract EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  static class EglHelper
  {
    EGL10 mEgl;
    EGLConfig mEglConfig;
    EGLContext mEglContext;
    EGLDisplay mEglDisplay;
    EGLSurface mEglSurface;
    private WeakReference<QGJavaScriptView> mGLSurfaceViewWeakRef;
    
    public EglHelper(WeakReference<QGJavaScriptView> paramWeakReference)
    {
      this.mGLSurfaceViewWeakRef = paramWeakReference;
    }
    
    private void destroySurfaceImp()
    {
      if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
      {
        this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        QGJavaScriptView localQGJavaScriptView = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
        if (localQGJavaScriptView != null) {
          localQGJavaScriptView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
        }
        this.mEglSurface = null;
      }
    }
    
    public static String formatEglError(String paramString, int paramInt)
    {
      return paramString + " failed: " + QGJavaScriptView.getErrorString(paramInt);
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
      QGJavaScriptView localQGJavaScriptView = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
      Object localObject = localGL2;
      GL localGL1;
      int i;
      if (localQGJavaScriptView != null)
      {
        localGL1 = localGL2;
        if (localQGJavaScriptView.mGLWrapper != null) {
          localGL1 = localQGJavaScriptView.mGLWrapper.wrap(localGL2);
        }
        localObject = localGL1;
        if ((localQGJavaScriptView.mDebugFlags & 0x3) != 0)
        {
          i = 0;
          if ((localQGJavaScriptView.mDebugFlags & 0x1) != 0) {
            i = 1;
          }
          if ((localQGJavaScriptView.mDebugFlags & 0x2) == 0) {
            break label106;
          }
        }
      }
      label106:
      for (localObject = new QGJavaScriptView.LogWriter();; localObject = null)
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
      QGJavaScriptView localQGJavaScriptView = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
      if (localQGJavaScriptView != null) {}
      for (this.mEglSurface = localQGJavaScriptView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, localQGJavaScriptView.getHolder()); (this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE); this.mEglSurface = null)
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
        QGJavaScriptView localQGJavaScriptView = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
        if (localQGJavaScriptView != null) {
          localQGJavaScriptView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
        }
        this.mEglContext = null;
      }
      if (this.mEglDisplay != null)
      {
        this.mEgl.eglTerminate(this.mEglDisplay);
        this.mEglDisplay = null;
      }
    }
    
    public int getError()
    {
      return this.mEgl.eglGetError();
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
      localObject = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
      if (localObject == null) {
        this.mEglConfig = null;
      }
      for (this.mEglContext = null;; this.mEglContext = ((QGJavaScriptView)localObject).mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig))
      {
        if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
        {
          this.mEglContext = null;
          throwEglException("createContext");
        }
        this.mEglSurface = null;
        return;
        this.mEglConfig = ((QGJavaScriptView)localObject).mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
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
  
  static class GLThread
    extends Thread
  {
    private QGJavaScriptView.EglHelper mEglHelper;
    private ArrayList<Runnable> mEventQueue = new ArrayList();
    private boolean mExited;
    private Runnable mFinishDrawingRunnable = null;
    private boolean mFinishedCreatingEglSurface;
    private WeakReference<QGJavaScriptView> mGLSurfaceViewWeakRef;
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
    private boolean mWantRenderNotification = false;
    private int mWidth = 0;
    
    GLThread(WeakReference<QGJavaScriptView> paramWeakReference)
    {
      this.mGLSurfaceViewWeakRef = paramWeakReference;
    }
    
    /* Error */
    private void guardedRun()
      throws InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: new 77	com/tencent/qg/sdk/QGJavaScriptView$EglHelper
      //   4: dup
      //   5: aload_0
      //   6: getfield 63	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 79	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 81	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 83	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 85	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
      //   25: aload_0
      //   26: iconst_0
      //   27: putfield 61	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWantRenderNotification	Z
      //   30: iconst_0
      //   31: istore 10
      //   33: aconst_null
      //   34: astore 22
      //   36: iconst_0
      //   37: istore_2
      //   38: iconst_0
      //   39: istore 5
      //   41: aconst_null
      //   42: astore 21
      //   44: iconst_0
      //   45: istore_3
      //   46: iconst_0
      //   47: istore_1
      //   48: aconst_null
      //   49: astore 20
      //   51: iconst_0
      //   52: istore 4
      //   54: iconst_0
      //   55: istore 6
      //   57: iconst_0
      //   58: istore 7
      //   60: iconst_0
      //   61: istore 8
      //   63: iconst_0
      //   64: istore 9
      //   66: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   69: astore 24
      //   71: aload 24
      //   73: monitorenter
      //   74: iload 10
      //   76: istore 11
      //   78: iload 9
      //   80: istore 12
      //   82: iload 8
      //   84: istore 9
      //   86: iload 7
      //   88: istore 10
      //   90: iload 6
      //   92: istore 8
      //   94: iload 5
      //   96: istore 13
      //   98: aload_0
      //   99: getfield 91	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mShouldExit	Z
      //   102: ifeq +63 -> 165
      //   105: aload_0
      //   106: getfield 63	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   109: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   112: checkcast 6	com/tencent/qg/sdk/QGJavaScriptView
      //   115: astore 20
      //   117: aload 20
      //   119: ifnull +15 -> 134
      //   122: aload 20
      //   124: getfield 101	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
      //   127: aload 22
      //   129: invokeinterface 107 2 0
      //   134: aload 24
      //   136: monitorexit
      //   137: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   140: astore 20
      //   142: aload 20
      //   144: monitorenter
      //   145: aload_0
      //   146: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
      //   149: aload_0
      //   150: invokespecial 113	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
      //   153: aload 20
      //   155: monitorexit
      //   156: return
      //   157: astore 21
      //   159: aload 20
      //   161: monitorexit
      //   162: aload 21
      //   164: athrow
      //   165: aload_0
      //   166: getfield 47	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   169: invokevirtual 117	java/util/ArrayList:isEmpty	()Z
      //   172: ifne +125 -> 297
      //   175: aload_0
      //   176: getfield 47	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   179: iconst_0
      //   180: invokevirtual 121	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   183: checkcast 123	java/lang/Runnable
      //   186: astore 23
      //   188: iload_1
      //   189: istore 5
      //   191: iload_3
      //   192: istore_1
      //   193: aload 21
      //   195: astore 20
      //   197: iload 13
      //   199: istore 7
      //   201: iload_2
      //   202: istore_3
      //   203: iload 10
      //   205: istore 6
      //   207: iload 4
      //   209: istore_2
      //   210: aload 23
      //   212: astore 21
      //   214: iload 11
      //   216: istore 10
      //   218: iload 5
      //   220: istore 4
      //   222: iload 12
      //   224: istore 5
      //   226: aload 24
      //   228: monitorexit
      //   229: aload 21
      //   231: ifnull +763 -> 994
      //   234: aload 21
      //   236: invokeinterface 126 1 0
      //   241: iload_1
      //   242: istore 13
      //   244: iload 4
      //   246: istore_1
      //   247: aconst_null
      //   248: astore 23
      //   250: iload_2
      //   251: istore 4
      //   253: iload 6
      //   255: istore 11
      //   257: iload 5
      //   259: istore 12
      //   261: aload 20
      //   263: astore 21
      //   265: aload 23
      //   267: astore 20
      //   269: iload_3
      //   270: istore_2
      //   271: iload 13
      //   273: istore_3
      //   274: iload 7
      //   276: istore 5
      //   278: iload 8
      //   280: istore 6
      //   282: iload 11
      //   284: istore 7
      //   286: iload 9
      //   288: istore 8
      //   290: iload 12
      //   292: istore 9
      //   294: goto -228 -> 66
      //   297: iconst_0
      //   298: istore 19
      //   300: aload_0
      //   301: getfield 128	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mPaused	Z
      //   304: aload_0
      //   305: getfield 130	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRequestPaused	Z
      //   308: if_icmpeq +52 -> 360
      //   311: aload_0
      //   312: getfield 130	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRequestPaused	Z
      //   315: istore 19
      //   317: aload_0
      //   318: aload_0
      //   319: getfield 130	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRequestPaused	Z
      //   322: putfield 128	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mPaused	Z
      //   325: aload_0
      //   326: getfield 63	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   329: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   332: checkcast 6	com/tencent/qg/sdk/QGJavaScriptView
      //   335: astore 23
      //   337: aload 23
      //   339: ifnull +15 -> 354
      //   342: aload 23
      //   344: getfield 101	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
      //   347: aload 22
      //   349: invokeinterface 133 2 0
      //   354: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   357: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   360: iload 4
      //   362: istore 5
      //   364: aload_0
      //   365: getfield 140	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mShouldReleaseEglContext	Z
      //   368: ifeq +19 -> 387
      //   371: aload_0
      //   372: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
      //   375: aload_0
      //   376: invokespecial 113	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
      //   379: aload_0
      //   380: iconst_0
      //   381: putfield 140	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mShouldReleaseEglContext	Z
      //   384: iconst_1
      //   385: istore 5
      //   387: iload 10
      //   389: istore 7
      //   391: iload 10
      //   393: ifeq +14 -> 407
      //   396: aload_0
      //   397: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
      //   400: aload_0
      //   401: invokespecial 113	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
      //   404: iconst_0
      //   405: istore 7
      //   407: iload 19
      //   409: ifeq +14 -> 423
      //   412: aload_0
      //   413: getfield 85	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
      //   416: ifeq +7 -> 423
      //   419: aload_0
      //   420: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
      //   423: iload 19
      //   425: ifeq +39 -> 464
      //   428: aload_0
      //   429: getfield 83	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
      //   432: ifeq +32 -> 464
      //   435: aload_0
      //   436: getfield 63	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   439: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   442: checkcast 6	com/tencent/qg/sdk/QGJavaScriptView
      //   445: astore 23
      //   447: aload 23
      //   449: ifnonnull +355 -> 804
      //   452: iconst_0
      //   453: istore 19
      //   455: iload 19
      //   457: ifne +7 -> 464
      //   460: aload_0
      //   461: invokespecial 113	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
      //   464: aload_0
      //   465: getfield 142	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHasSurface	Z
      //   468: ifne +38 -> 506
      //   471: aload_0
      //   472: getfield 144	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWaitingForSurface	Z
      //   475: ifne +31 -> 506
      //   478: aload_0
      //   479: getfield 85	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
      //   482: ifeq +8 -> 490
      //   485: aload_0
      //   486: iconst_0
      //   487: putfield 85	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
      //   490: aload_0
      //   491: iconst_1
      //   492: putfield 144	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWaitingForSurface	Z
      //   495: aload_0
      //   496: iconst_0
      //   497: putfield 146	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSurfaceIsBad	Z
      //   500: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   503: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   506: aload_0
      //   507: getfield 142	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHasSurface	Z
      //   510: ifeq +21 -> 531
      //   513: aload_0
      //   514: getfield 144	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWaitingForSurface	Z
      //   517: ifeq +14 -> 531
      //   520: aload_0
      //   521: iconst_0
      //   522: putfield 144	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWaitingForSurface	Z
      //   525: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   528: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   531: iload 13
      //   533: istore 6
      //   535: iload 13
      //   537: ifeq +22 -> 559
      //   540: aload_0
      //   541: iconst_0
      //   542: putfield 61	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWantRenderNotification	Z
      //   545: iconst_0
      //   546: istore 6
      //   548: aload_0
      //   549: iconst_1
      //   550: putfield 148	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRenderComplete	Z
      //   553: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   556: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   559: aload_0
      //   560: getfield 51	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
      //   563: ifnull +1012 -> 1575
      //   566: aload_0
      //   567: getfield 51	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
      //   570: astore 21
      //   572: aload_0
      //   573: aconst_null
      //   574: putfield 51	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
      //   577: aload_0
      //   578: invokespecial 151	com/tencent/qg/sdk/QGJavaScriptView$GLThread:readyToDraw	()Z
      //   581: ifeq +305 -> 886
      //   584: iload 5
      //   586: istore 4
      //   588: iload 11
      //   590: istore 10
      //   592: aload_0
      //   593: getfield 83	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
      //   596: ifne +15 -> 611
      //   599: iload 5
      //   601: ifeq +213 -> 814
      //   604: iconst_0
      //   605: istore 4
      //   607: iload 11
      //   609: istore 10
      //   611: iload 8
      //   613: istore 13
      //   615: iload 9
      //   617: istore 5
      //   619: iload 12
      //   621: istore 11
      //   623: aload_0
      //   624: getfield 83	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
      //   627: ifeq +36 -> 663
      //   630: iload 8
      //   632: istore 13
      //   634: iload 9
      //   636: istore 5
      //   638: iload 12
      //   640: istore 11
      //   642: aload_0
      //   643: getfield 85	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
      //   646: ifne +17 -> 663
      //   649: aload_0
      //   650: iconst_1
      //   651: putfield 85	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
      //   654: iconst_1
      //   655: istore 11
      //   657: iconst_1
      //   658: istore 5
      //   660: iconst_1
      //   661: istore 13
      //   663: aload 21
      //   665: astore 23
      //   667: iload 4
      //   669: istore 14
      //   671: iload 13
      //   673: istore 18
      //   675: iload 5
      //   677: istore 15
      //   679: iload 11
      //   681: istore 16
      //   683: iload 10
      //   685: istore 17
      //   687: aload_0
      //   688: getfield 85	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
      //   691: ifeq +262 -> 953
      //   694: aload_0
      //   695: getfield 49	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSizeChanged	Z
      //   698: ifeq +874 -> 1572
      //   701: iconst_1
      //   702: istore 13
      //   704: aload_0
      //   705: getfield 53	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWidth	I
      //   708: istore_3
      //   709: aload_0
      //   710: getfield 55	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHeight	I
      //   713: istore_2
      //   714: aload_0
      //   715: iconst_1
      //   716: putfield 61	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWantRenderNotification	Z
      //   719: iconst_1
      //   720: istore 11
      //   722: aload_0
      //   723: iconst_0
      //   724: putfield 49	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSizeChanged	Z
      //   727: aload_0
      //   728: iconst_0
      //   729: putfield 57	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRequestRender	Z
      //   732: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   735: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   738: aload_0
      //   739: getfield 61	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWantRenderNotification	Z
      //   742: ifeq +773 -> 1515
      //   745: iload_3
      //   746: istore_1
      //   747: iconst_1
      //   748: istore 14
      //   750: iload 11
      //   752: istore_3
      //   753: iload 5
      //   755: istore 9
      //   757: iload 7
      //   759: istore 11
      //   761: iload 13
      //   763: istore 8
      //   765: iload 4
      //   767: istore 12
      //   769: aload 20
      //   771: astore 23
      //   773: iload_3
      //   774: istore 5
      //   776: iload 6
      //   778: istore 7
      //   780: iload 14
      //   782: istore 4
      //   784: aload 21
      //   786: astore 20
      //   788: aload 23
      //   790: astore 21
      //   792: iload_2
      //   793: istore_3
      //   794: iload 12
      //   796: istore_2
      //   797: iload 11
      //   799: istore 6
      //   801: goto -575 -> 226
      //   804: aload 23
      //   806: getfield 154	com/tencent/qg/sdk/QGJavaScriptView:mPreserveEGLContextOnPause	Z
      //   809: istore 19
      //   811: goto -356 -> 455
      //   814: aload_0
      //   815: getfield 81	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
      //   818: invokevirtual 157	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:start	()V
      //   821: aload_0
      //   822: iconst_1
      //   823: putfield 83	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
      //   826: iconst_1
      //   827: istore 10
      //   829: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   832: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   835: iload 5
      //   837: istore 4
      //   839: goto -228 -> 611
      //   842: astore 20
      //   844: aload 24
      //   846: monitorexit
      //   847: aload 20
      //   849: athrow
      //   850: astore 21
      //   852: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   855: astore 20
      //   857: aload 20
      //   859: monitorenter
      //   860: aload_0
      //   861: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
      //   864: aload_0
      //   865: invokespecial 113	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
      //   868: aload 20
      //   870: monitorexit
      //   871: aload 21
      //   873: athrow
      //   874: astore 20
      //   876: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   879: aload_0
      //   880: invokevirtual 163	com/tencent/qg/sdk/QGJavaScriptView$GLThreadManager:releaseEglContextLocked	(Lcom/tencent/qg/sdk/QGJavaScriptView$GLThread;)V
      //   883: aload 20
      //   885: athrow
      //   886: aload 21
      //   888: astore 23
      //   890: iload 5
      //   892: istore 14
      //   894: iload 8
      //   896: istore 18
      //   898: iload 9
      //   900: istore 15
      //   902: iload 12
      //   904: istore 16
      //   906: iload 11
      //   908: istore 17
      //   910: aload 21
      //   912: ifnull +41 -> 953
      //   915: ldc 165
      //   917: ldc 167
      //   919: invokestatic 173	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   922: pop
      //   923: aload 21
      //   925: invokeinterface 126 1 0
      //   930: aconst_null
      //   931: astore 23
      //   933: iload 11
      //   935: istore 17
      //   937: iload 12
      //   939: istore 16
      //   941: iload 9
      //   943: istore 15
      //   945: iload 8
      //   947: istore 18
      //   949: iload 5
      //   951: istore 14
      //   953: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   956: invokevirtual 176	java/lang/Object:wait	()V
      //   959: aload 23
      //   961: astore 21
      //   963: iload 14
      //   965: istore 4
      //   967: iload 6
      //   969: istore 13
      //   971: iload 18
      //   973: istore 8
      //   975: iload 7
      //   977: istore 10
      //   979: iload 15
      //   981: istore 9
      //   983: iload 16
      //   985: istore 12
      //   987: iload 17
      //   989: istore 11
      //   991: goto -893 -> 98
      //   994: iload 5
      //   996: ifeq +516 -> 1512
      //   999: aload_0
      //   1000: getfield 81	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
      //   1003: invokevirtual 179	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:createSurface	()Z
      //   1006: ifeq +365 -> 1371
      //   1009: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   1012: astore 23
      //   1014: aload 23
      //   1016: monitorenter
      //   1017: aload_0
      //   1018: iconst_1
      //   1019: putfield 181	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishedCreatingEglSurface	Z
      //   1022: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   1025: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   1028: aload 23
      //   1030: monitorexit
      //   1031: iconst_0
      //   1032: istore 5
      //   1034: iload 9
      //   1036: ifeq +473 -> 1509
      //   1039: aload_0
      //   1040: getfield 81	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
      //   1043: invokevirtual 185	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:createGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1046: checkcast 187	javax/microedition/khronos/opengles/GL10
      //   1049: astore 22
      //   1051: iconst_0
      //   1052: istore 9
      //   1054: iload 10
      //   1056: istore 11
      //   1058: iload 10
      //   1060: ifeq +50 -> 1110
      //   1063: aload_0
      //   1064: getfield 63	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1067: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1070: checkcast 6	com/tencent/qg/sdk/QGJavaScriptView
      //   1073: astore 23
      //   1075: aload 23
      //   1077: ifnull +508 -> 1585
      //   1080: ldc 189
      //   1082: invokestatic 195	android/os/Trace:beginSection	(Ljava/lang/String;)V
      //   1085: aload 23
      //   1087: getfield 101	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
      //   1090: aload 22
      //   1092: aload_0
      //   1093: getfield 81	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
      //   1096: getfield 199	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1099: invokeinterface 203 3 0
      //   1104: invokestatic 206	android/os/Trace:endSection	()V
      //   1107: goto +478 -> 1585
      //   1110: iload 8
      //   1112: istore 10
      //   1114: iload 8
      //   1116: ifeq +45 -> 1161
      //   1119: aload_0
      //   1120: getfield 63	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1123: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1126: checkcast 6	com/tencent/qg/sdk/QGJavaScriptView
      //   1129: astore 23
      //   1131: aload 23
      //   1133: ifnull +458 -> 1591
      //   1136: ldc 208
      //   1138: invokestatic 195	android/os/Trace:beginSection	(Ljava/lang/String;)V
      //   1141: aload 23
      //   1143: getfield 101	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
      //   1146: aload 22
      //   1148: iload_1
      //   1149: iload_3
      //   1150: invokeinterface 212 4 0
      //   1155: invokestatic 206	android/os/Trace:endSection	()V
      //   1158: goto +433 -> 1591
      //   1161: aload_0
      //   1162: getfield 63	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1165: invokevirtual 97	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1168: checkcast 6	com/tencent/qg/sdk/QGJavaScriptView
      //   1171: astore 24
      //   1173: aload 20
      //   1175: astore 23
      //   1177: aload 24
      //   1179: ifnull +42 -> 1221
      //   1182: ldc 214
      //   1184: invokestatic 195	android/os/Trace:beginSection	(Ljava/lang/String;)V
      //   1187: aload 24
      //   1189: getfield 101	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
      //   1192: aload 22
      //   1194: invokeinterface 217 2 0
      //   1199: aload 20
      //   1201: astore 23
      //   1203: aload 20
      //   1205: ifnull +13 -> 1218
      //   1208: aload 20
      //   1210: invokeinterface 126 1 0
      //   1215: aconst_null
      //   1216: astore 23
      //   1218: invokestatic 206	android/os/Trace:endSection	()V
      //   1221: aload_0
      //   1222: getfield 81	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
      //   1225: invokevirtual 221	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:getError	()I
      //   1228: istore 12
      //   1230: iload 6
      //   1232: istore 8
      //   1234: iload 12
      //   1236: lookupswitch	default:+361->1597, 12288:+63->1299, 12302:+251->1487
      //   1265: <illegal opcode>
      //   1266: ldc 224
      //   1268: iload 12
      //   1270: invokestatic 228	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1273: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   1276: astore 20
      //   1278: aload 20
      //   1280: monitorenter
      //   1281: aload_0
      //   1282: iconst_1
      //   1283: putfield 146	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSurfaceIsBad	Z
      //   1286: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   1289: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   1292: aload 20
      //   1294: monitorexit
      //   1295: iload 6
      //   1297: istore 8
      //   1299: iload 4
      //   1301: ifeq +277 -> 1578
      //   1304: iconst_1
      //   1305: istore 6
      //   1307: iconst_0
      //   1308: istore 4
      //   1310: aload 21
      //   1312: astore 20
      //   1314: iload_2
      //   1315: istore 12
      //   1317: iload 8
      //   1319: istore 7
      //   1321: iload 9
      //   1323: istore 8
      //   1325: iload 5
      //   1327: istore 9
      //   1329: iload_3
      //   1330: istore_2
      //   1331: iload 6
      //   1333: istore 5
      //   1335: iload 4
      //   1337: istore 6
      //   1339: aload 23
      //   1341: astore 21
      //   1343: iload_1
      //   1344: istore_3
      //   1345: iload 12
      //   1347: istore 4
      //   1349: iload 6
      //   1351: istore_1
      //   1352: iload 10
      //   1354: istore 6
      //   1356: iload 11
      //   1358: istore 10
      //   1360: goto -1294 -> 66
      //   1363: astore 20
      //   1365: aload 23
      //   1367: monitorexit
      //   1368: aload 20
      //   1370: athrow
      //   1371: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   1374: astore 23
      //   1376: aload 23
      //   1378: monitorenter
      //   1379: aload_0
      //   1380: iconst_1
      //   1381: putfield 181	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishedCreatingEglSurface	Z
      //   1384: aload_0
      //   1385: iconst_1
      //   1386: putfield 146	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSurfaceIsBad	Z
      //   1389: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   1392: invokevirtual 138	java/lang/Object:notifyAll	()V
      //   1395: aload 23
      //   1397: monitorexit
      //   1398: iload_1
      //   1399: istore 13
      //   1401: iload 4
      //   1403: istore_1
      //   1404: aload 21
      //   1406: astore 23
      //   1408: iload_2
      //   1409: istore 4
      //   1411: iload 6
      //   1413: istore 11
      //   1415: iload 5
      //   1417: istore 12
      //   1419: aload 20
      //   1421: astore 21
      //   1423: aload 23
      //   1425: astore 20
      //   1427: iload_3
      //   1428: istore_2
      //   1429: iload 13
      //   1431: istore_3
      //   1432: iload 7
      //   1434: istore 5
      //   1436: iload 8
      //   1438: istore 6
      //   1440: iload 11
      //   1442: istore 7
      //   1444: iload 9
      //   1446: istore 8
      //   1448: iload 12
      //   1450: istore 9
      //   1452: goto -1386 -> 66
      //   1455: astore 20
      //   1457: aload 23
      //   1459: monitorexit
      //   1460: aload 20
      //   1462: athrow
      //   1463: astore 20
      //   1465: invokestatic 206	android/os/Trace:endSection	()V
      //   1468: aload 20
      //   1470: athrow
      //   1471: astore 20
      //   1473: invokestatic 206	android/os/Trace:endSection	()V
      //   1476: aload 20
      //   1478: athrow
      //   1479: astore 20
      //   1481: invokestatic 206	android/os/Trace:endSection	()V
      //   1484: aload 20
      //   1486: athrow
      //   1487: iconst_1
      //   1488: istore 8
      //   1490: goto -191 -> 1299
      //   1493: astore 21
      //   1495: aload 20
      //   1497: monitorexit
      //   1498: aload 21
      //   1500: athrow
      //   1501: astore 21
      //   1503: aload 20
      //   1505: monitorexit
      //   1506: aload 21
      //   1508: athrow
      //   1509: goto -455 -> 1054
      //   1512: goto -478 -> 1034
      //   1515: iload 11
      //   1517: istore 14
      //   1519: iload 5
      //   1521: istore 9
      //   1523: iload 7
      //   1525: istore 11
      //   1527: iload 13
      //   1529: istore 8
      //   1531: iload 4
      //   1533: istore 12
      //   1535: aload 20
      //   1537: astore 23
      //   1539: iload_1
      //   1540: istore 4
      //   1542: iload_3
      //   1543: istore_1
      //   1544: iload 14
      //   1546: istore 5
      //   1548: iload 6
      //   1550: istore 7
      //   1552: aload 21
      //   1554: astore 20
      //   1556: aload 23
      //   1558: astore 21
      //   1560: iload_2
      //   1561: istore_3
      //   1562: iload 12
      //   1564: istore_2
      //   1565: iload 11
      //   1567: istore 6
      //   1569: goto -1343 -> 226
      //   1572: goto -845 -> 727
      //   1575: goto -998 -> 577
      //   1578: iload 7
      //   1580: istore 6
      //   1582: goto -272 -> 1310
      //   1585: iconst_0
      //   1586: istore 11
      //   1588: goto -478 -> 1110
      //   1591: iconst_0
      //   1592: istore 10
      //   1594: goto -433 -> 1161
      //   1597: goto -333 -> 1264
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1600	0	this	GLThread
      //   47	1497	1	i	int
      //   37	1528	2	j	int
      //   45	1517	3	k	int
      //   52	1489	4	m	int
      //   39	1508	5	n	int
      //   55	1526	6	i1	int
      //   58	1521	7	i2	int
      //   61	1469	8	i3	int
      //   64	1458	9	i4	int
      //   31	1562	10	i5	int
      //   76	1511	11	i6	int
      //   80	1483	12	i7	int
      //   96	1432	13	i8	int
      //   669	876	14	i9	int
      //   677	303	15	i10	int
      //   681	303	16	i11	int
      //   685	303	17	i12	int
      //   673	299	18	i13	int
      //   298	512	19	bool	boolean
      //   49	738	20	localObject1	Object
      //   842	6	20	localObject2	Object
      //   855	14	20	localGLThreadManager	QGJavaScriptView.GLThreadManager
      //   874	335	20	localRuntimeException	RuntimeException
      //   1363	57	20	localObject4	Object
      //   1425	1	20	localObject5	Object
      //   1455	6	20	localObject6	Object
      //   1463	6	20	localObject7	Object
      //   1471	6	20	localObject8	Object
      //   1479	57	20	localObject9	Object
      //   1554	1	20	localObject10	Object
      //   42	1	21	localObject11	Object
      //   157	37	21	localObject12	Object
      //   212	579	21	localObject13	Object
      //   850	74	21	localObject14	Object
      //   961	461	21	localObject15	Object
      //   1493	6	21	localObject16	Object
      //   1501	52	21	localObject17	Object
      //   1558	1	21	localObject18	Object
      //   34	1159	22	localGL10	GL10
      //   69	1119	24	localObject20	Object
      // Exception table:
      //   from	to	target	type
      //   145	156	157	finally
      //   159	162	157	finally
      //   98	117	842	finally
      //   122	134	842	finally
      //   134	137	842	finally
      //   165	188	842	finally
      //   226	229	842	finally
      //   300	337	842	finally
      //   342	354	842	finally
      //   354	360	842	finally
      //   364	384	842	finally
      //   396	404	842	finally
      //   412	423	842	finally
      //   428	447	842	finally
      //   460	464	842	finally
      //   464	490	842	finally
      //   490	506	842	finally
      //   506	531	842	finally
      //   540	545	842	finally
      //   548	559	842	finally
      //   559	577	842	finally
      //   577	584	842	finally
      //   592	599	842	finally
      //   623	630	842	finally
      //   642	654	842	finally
      //   687	701	842	finally
      //   704	719	842	finally
      //   722	727	842	finally
      //   727	745	842	finally
      //   804	811	842	finally
      //   814	821	842	finally
      //   821	826	842	finally
      //   829	835	842	finally
      //   844	847	842	finally
      //   876	886	842	finally
      //   915	930	842	finally
      //   953	959	842	finally
      //   66	74	850	finally
      //   234	241	850	finally
      //   847	850	850	finally
      //   999	1017	850	finally
      //   1039	1051	850	finally
      //   1063	1075	850	finally
      //   1104	1107	850	finally
      //   1119	1131	850	finally
      //   1155	1158	850	finally
      //   1161	1173	850	finally
      //   1218	1221	850	finally
      //   1221	1230	850	finally
      //   1264	1281	850	finally
      //   1368	1371	850	finally
      //   1371	1379	850	finally
      //   1460	1463	850	finally
      //   1465	1471	850	finally
      //   1473	1479	850	finally
      //   1481	1487	850	finally
      //   1498	1501	850	finally
      //   814	821	874	java/lang/RuntimeException
      //   1017	1031	1363	finally
      //   1365	1368	1363	finally
      //   1379	1398	1455	finally
      //   1457	1460	1455	finally
      //   1080	1104	1463	finally
      //   1136	1155	1471	finally
      //   1182	1199	1479	finally
      //   1208	1215	1479	finally
      //   1281	1295	1493	finally
      //   1495	1498	1493	finally
      //   860	871	1501	finally
      //   1503	1506	1501	finally
    }
    
    private boolean readyToDraw()
    {
      return (!this.mPaused) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mRequestRender) || (this.mRenderMode == 1));
    }
    
    private void stopEglContextLocked()
    {
      if (this.mHaveEglContext)
      {
        this.mEglHelper.finish();
        this.mHaveEglContext = false;
        QGJavaScriptView.sGLThreadManager.releaseEglContextLocked(this);
      }
    }
    
    private void stopEglSurfaceLocked()
    {
      if (this.mHaveEglSurface)
      {
        this.mHaveEglSurface = false;
        this.mEglHelper.destroySurface();
      }
    }
    
    public boolean ableToDraw()
    {
      return (this.mHaveEglContext) && (this.mHaveEglSurface) && (readyToDraw());
    }
    
    public int getRenderMode()
    {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        int i = this.mRenderMode;
        return i;
      }
    }
    
    public void onPause()
    {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mRequestPaused = true;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if (!this.mExited)
          {
            boolean bool = this.mPaused;
            if (!bool) {
              try
              {
                QGJavaScriptView.sGLThreadManager.wait();
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
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mRequestPaused = false;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (this.mPaused))
          {
            boolean bool = this.mRenderComplete;
            if (!bool) {
              try
              {
                QGJavaScriptView.sGLThreadManager.wait();
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
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        this.mSizeChanged = true;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        if (Thread.currentThread() == this) {
          return;
        }
        QGJavaScriptView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete))
          {
            boolean bool = ableToDraw();
            if (bool) {
              try
              {
                QGJavaScriptView.sGLThreadManager.wait();
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
    
    public void queueEvent(Runnable paramRunnable)
    {
      if (paramRunnable == null) {
        throw new IllegalArgumentException("r must not be null");
      }
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mEventQueue.add(paramRunnable);
        QGJavaScriptView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void requestExitAndWait()
    {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mShouldExit = true;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        for (;;)
        {
          boolean bool = this.mExited;
          if (!bool) {
            try
            {
              QGJavaScriptView.sGLThreadManager.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    
    public void requestReleaseEglContextLocked()
    {
      this.mShouldReleaseEglContext = true;
      QGJavaScriptView.sGLThreadManager.notifyAll();
    }
    
    public void requestRender()
    {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mRequestRender = true;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void requestRenderAndNotify(Runnable paramRunnable)
    {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        if (Thread.currentThread() == this) {
          return;
        }
        this.mWantRenderNotification = true;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        this.mFinishDrawingRunnable = paramRunnable;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: new 268	java/lang/StringBuilder
      //   4: dup
      //   5: invokespecial 269	java/lang/StringBuilder:<init>	()V
      //   8: ldc_w 271
      //   11: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   14: aload_0
      //   15: invokevirtual 279	com/tencent/qg/sdk/QGJavaScriptView$GLThread:getId	()J
      //   18: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   21: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   24: invokevirtual 289	com/tencent/qg/sdk/QGJavaScriptView$GLThread:setName	(Ljava/lang/String;)V
      //   27: bipush 236
      //   29: invokestatic 295	android/os/Process:setThreadPriority	(I)V
      //   32: aload_0
      //   33: invokespecial 297	com/tencent/qg/sdk/QGJavaScriptView$GLThread:guardedRun	()V
      //   36: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   39: aload_0
      //   40: invokevirtual 300	com/tencent/qg/sdk/QGJavaScriptView$GLThreadManager:threadExiting	(Lcom/tencent/qg/sdk/QGJavaScriptView$GLThread;)V
      //   43: return
      //   44: astore_1
      //   45: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   48: aload_0
      //   49: invokevirtual 300	com/tencent/qg/sdk/QGJavaScriptView$GLThreadManager:threadExiting	(Lcom/tencent/qg/sdk/QGJavaScriptView$GLThread;)V
      //   52: return
      //   53: astore_1
      //   54: getstatic 89	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
      //   57: aload_0
      //   58: invokevirtual 300	com/tencent/qg/sdk/QGJavaScriptView$GLThreadManager:threadExiting	(Lcom/tencent/qg/sdk/QGJavaScriptView$GLThread;)V
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	GLThread
      //   44	1	1	localInterruptedException	InterruptedException
      //   53	9	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   32	36	44	java/lang/InterruptedException
      //   32	36	53	finally
    }
    
    public void setRenderMode(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1)) {
        throw new IllegalArgumentException("renderMode");
      }
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mRenderMode = paramInt;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        return;
      }
    }
    
    public void surfaceCreated()
    {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mHasSurface = true;
        this.mFinishedCreatingEglSurface = false;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if ((this.mWaitingForSurface) && (!this.mFinishedCreatingEglSurface))
          {
            boolean bool = this.mExited;
            if (!bool) {
              try
              {
                QGJavaScriptView.sGLThreadManager.wait();
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
    
    public void surfaceDestroyed()
    {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mHasSurface = false;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        for (;;)
        {
          if (!this.mWaitingForSurface)
          {
            boolean bool = this.mExited;
            if (!bool) {
              try
              {
                QGJavaScriptView.sGLThreadManager.wait();
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
    
    public int swap()
    {
      return this.mEglHelper.swap();
    }
  }
  
  static class GLThreadManager
  {
    private static String TAG = "GLThreadManager";
    
    public void releaseEglContextLocked(QGJavaScriptView.GLThread paramGLThread)
    {
      notifyAll();
    }
    
    public void threadExiting(QGJavaScriptView.GLThread paramGLThread)
    {
      try
      {
        QGJavaScriptView.GLThread.access$202(paramGLThread, true);
        notifyAll();
        return;
      }
      finally
      {
        paramGLThread = finally;
        throw paramGLThread;
      }
    }
  }
  
  public static abstract interface GLWrapper
  {
    public abstract GL wrap(GL paramGL);
  }
  
  static class LogWriter
    extends Writer
  {
    private StringBuilder mBuilder = new StringBuilder();
    
    private void flushBuilder()
    {
      if (this.mBuilder.length() > 0)
      {
        Log.v("GLSurfaceView", this.mBuilder.toString());
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
  
  public static abstract interface Renderer
  {
    public abstract void onDrawFrame(GL10 paramGL10);
    
    public abstract void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2);
    
    public abstract void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig);
    
    public abstract void onSurfaceDestroy(GL10 paramGL10);
    
    public abstract void onSurfacePause(GL10 paramGL10);
  }
  
  class SimpleEGLConfigChooser
    extends QGJavaScriptView.ComponentSizeChooser
  {
    public SimpleEGLConfigChooser(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView
 * JD-Core Version:    0.7.0.1
 */