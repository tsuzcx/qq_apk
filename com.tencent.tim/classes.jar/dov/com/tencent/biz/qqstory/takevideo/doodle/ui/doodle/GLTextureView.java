package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import aymn;
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

@TargetApi(14)
public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static final i jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$i = new i(null);
  private static int sGLESVersion;
  private GLThread jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread;
  private e jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$e;
  private f jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$f;
  private g jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$g;
  private j jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$j;
  private Runnable mCheckAlphaTask = new GLTextureView.2(this);
  private int mDebugFlags;
  private boolean mDetached;
  private int mEGLContextClientVersion;
  private boolean mPreserveEGLContextOnPause;
  private GLSurfaceView.Renderer mRenderer;
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
  
  private void checkRenderThreadState()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread != null) {
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
    sGLESVersion = getInt(getContext(), "ro.opengles.version", 0).intValue();
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new aymn(this));
  }
  
  @TargetApi(14)
  private void setViewAlpha(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      setAlpha(paramFloat);
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, "TextureView setAlpha,alpha:" + paramFloat);
      }
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.requestExitAndWait();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mDetached) && (this.mRenderer != null)) {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread == null) {
        break label74;
      }
    }
    label74:
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.getRenderMode();; i = 1)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread = new GLThread(this.mThisWeakRef);
      if (i != 1) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.setRenderMode(i);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.start();
      this.mDetached = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.requestExitAndWait();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mSurfaceTextureAvailable = true;
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
    Log.d("GLTextureView", "onSurfaceTextureAvailable");
    long l = System.currentTimeMillis();
    surfaceCreated(paramSurfaceTexture);
    postDelayed(this.mCheckAlphaTask, 250L);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureAvailable surfaceCreated use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTextureAvailable = false;
    Log.d("GLTextureView", "onSurfaceTextureDestroyed");
    surfaceDestroyed(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureDestroyed");
    }
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
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.queueEvent(paramRunnable);
  }
  
  public void requestRender()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.requestRender();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(e parame)
  {
    checkRenderThreadState();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$e = parame;
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
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$f = paramf;
  }
  
  public void setEGLWindowSurfaceFactory(g paramg)
  {
    checkRenderThreadState();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$g = paramg;
  }
  
  public void setGLWrapper(j paramj)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$j = paramj;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.setRenderMode(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$e == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$e = new l(true);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$f == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$f = new c(null);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$g == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$g = new d(null);
    }
    this.mRenderer = paramRenderer;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread = new GLThread(this.mThisWeakRef);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.start();
  }
  
  public void surfaceChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    if ((this.mSurfaceWidth != paramInt2) || (this.mSurfaceHeight != paramInt3))
    {
      this.mSurfaceWidth = paramInt2;
      this.mSurfaceHeight = paramInt3;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.onWindowResize(paramInt2, paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, " surfaceChanged, onWindowResize");
      }
    }
    removeCallbacks(this.mCheckAlphaTask);
    if ((this.mSurfaceTextureAvailable) && (getViewAlpha() != 1.0F)) {
      setViewAlpha(1.0F);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " surfaceChanged, w:" + paramInt2 + ",h:" + paramInt3 + " use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void surfaceCreated(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.surfaceCreated();
  }
  
  public void surfaceDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.surfaceDestroyed();
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
    private boolean mLogPrinted;
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
    
    GLThread(WeakReference<GLTextureView> paramWeakReference)
    {
      this.mGLTextureViewWeakRef = paramWeakReference;
    }
    
    /* Error */
    private void guardedRun()
      throws InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: new 70	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h
      //   4: dup
      //   5: aload_0
      //   6: getfield 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   9: invokespecial 72	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   12: putfield 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h;
      //   15: aload_0
      //   16: iconst_0
      //   17: putfield 76	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglContext	Z
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglSurface	Z
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
      //   58: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   61: astore 23
      //   63: aload 23
      //   65: monitorenter
      //   66: iload 10
      //   68: istore 11
      //   70: iload 7
      //   72: istore 10
      //   74: iload 4
      //   76: istore 14
      //   78: aload_0
      //   79: getfield 83	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mShouldExit	Z
      //   82: ifeq +34 -> 116
      //   85: aload 23
      //   87: monitorexit
      //   88: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   91: astore 21
      //   93: aload 21
      //   95: monitorenter
      //   96: aload_0
      //   97: invokespecial 86	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   100: aload_0
      //   101: invokespecial 89	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglContextLocked	()V
      //   104: aload 21
      //   106: monitorexit
      //   107: return
      //   108: astore 22
      //   110: aload 21
      //   112: monitorexit
      //   113: aload 22
      //   115: athrow
      //   116: aload_0
      //   117: getfield 45	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   120: invokevirtual 93	java/util/ArrayList:isEmpty	()Z
      //   123: ifne +93 -> 216
      //   126: aload_0
      //   127: getfield 45	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mEventQueue	Ljava/util/ArrayList;
      //   130: iconst_0
      //   131: invokevirtual 97	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   134: checkcast 99	java/lang/Runnable
      //   137: astore 21
      //   139: iload 10
      //   141: istore 7
      //   143: iload 6
      //   145: istore 12
      //   147: iload_1
      //   148: istore 4
      //   150: iload 11
      //   152: istore 10
      //   154: iload 7
      //   156: istore 6
      //   158: iload 12
      //   160: istore 7
      //   162: iload_2
      //   163: istore_1
      //   164: iload 14
      //   166: istore_2
      //   167: aload 23
      //   169: monitorexit
      //   170: aload 21
      //   172: ifnull +648 -> 820
      //   175: aload 21
      //   177: invokeinterface 102 1 0
      //   182: iload 6
      //   184: istore 11
      //   186: aconst_null
      //   187: astore 21
      //   189: iload_1
      //   190: istore 12
      //   192: iload_2
      //   193: istore 6
      //   195: iload 4
      //   197: istore_1
      //   198: iload 12
      //   200: istore_2
      //   201: iload 6
      //   203: istore 4
      //   205: iload 7
      //   207: istore 6
      //   209: iload 11
      //   211: istore 7
      //   213: goto -155 -> 58
      //   216: aload_0
      //   217: getfield 104	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mPaused	Z
      //   220: aload_0
      //   221: getfield 106	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mRequestPaused	Z
      //   224: if_icmpeq +1055 -> 1279
      //   227: aload_0
      //   228: getfield 106	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mRequestPaused	Z
      //   231: istore 19
      //   233: aload_0
      //   234: aload_0
      //   235: getfield 106	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mRequestPaused	Z
      //   238: putfield 104	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mPaused	Z
      //   241: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   244: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   247: iload_3
      //   248: istore 4
      //   250: aload_0
      //   251: getfield 113	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mShouldReleaseEglContext	Z
      //   254: ifeq +19 -> 273
      //   257: aload_0
      //   258: invokespecial 86	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   261: aload_0
      //   262: invokespecial 89	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglContextLocked	()V
      //   265: aload_0
      //   266: iconst_0
      //   267: putfield 113	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mShouldReleaseEglContext	Z
      //   270: iconst_1
      //   271: istore 4
      //   273: iload 10
      //   275: istore 7
      //   277: iload 10
      //   279: ifeq +14 -> 293
      //   282: aload_0
      //   283: invokespecial 86	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   286: aload_0
      //   287: invokespecial 89	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglContextLocked	()V
      //   290: iconst_0
      //   291: istore 7
      //   293: iload 19
      //   295: ifeq +14 -> 309
      //   298: aload_0
      //   299: getfield 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglSurface	Z
      //   302: ifeq +7 -> 309
      //   305: aload_0
      //   306: invokespecial 86	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   309: iload 19
      //   311: ifeq +48 -> 359
      //   314: aload_0
      //   315: getfield 76	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglContext	Z
      //   318: ifeq +41 -> 359
      //   321: aload_0
      //   322: getfield 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   325: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   328: checkcast 6	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
      //   331: astore 24
      //   333: aload 24
      //   335: ifnonnull +346 -> 681
      //   338: iconst_0
      //   339: istore 20
      //   341: iload 20
      //   343: ifeq +12 -> 355
      //   346: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   349: invokevirtual 124	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:shouldReleaseEGLContextWhenPausing	()Z
      //   352: ifeq +7 -> 359
      //   355: aload_0
      //   356: invokespecial 89	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglContextLocked	()V
      //   359: iload 19
      //   361: ifeq +19 -> 380
      //   364: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   367: invokevirtual 127	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:shouldTerminateEGLWhenPausing	()Z
      //   370: ifeq +10 -> 380
      //   373: aload_0
      //   374: getfield 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h;
      //   377: invokevirtual 130	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h:finish	()V
      //   380: aload_0
      //   381: getfield 132	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHasSurface	Z
      //   384: ifne +71 -> 455
      //   387: aload_0
      //   388: getfield 134	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mWaitingForSurface	Z
      //   391: ifne +64 -> 455
      //   394: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   397: ifeq +31 -> 428
      //   400: ldc 141
      //   402: iconst_2
      //   403: new 143	java/lang/StringBuilder
      //   406: dup
      //   407: invokespecial 144	java/lang/StringBuilder:<init>	()V
      //   410: ldc 146
      //   412: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   415: aload_0
      //   416: invokevirtual 154	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:getId	()J
      //   419: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   422: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   425: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   428: aload_0
      //   429: getfield 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglSurface	Z
      //   432: ifeq +7 -> 439
      //   435: aload_0
      //   436: invokespecial 86	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   439: aload_0
      //   440: iconst_1
      //   441: putfield 134	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mWaitingForSurface	Z
      //   444: aload_0
      //   445: iconst_0
      //   446: putfield 167	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   449: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   452: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   455: aload_0
      //   456: getfield 132	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHasSurface	Z
      //   459: ifeq +21 -> 480
      //   462: aload_0
      //   463: getfield 134	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mWaitingForSurface	Z
      //   466: ifeq +14 -> 480
      //   469: aload_0
      //   470: iconst_0
      //   471: putfield 134	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mWaitingForSurface	Z
      //   474: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   477: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   480: iload 14
      //   482: istore 12
      //   484: iload 5
      //   486: istore 13
      //   488: iload 14
      //   490: ifeq +20 -> 510
      //   493: iconst_0
      //   494: istore 13
      //   496: iconst_0
      //   497: istore 12
      //   499: aload_0
      //   500: iconst_1
      //   501: putfield 169	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mRenderComplete	Z
      //   504: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   507: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   510: iload 4
      //   512: istore_3
      //   513: iload 6
      //   515: istore 15
      //   517: iload 8
      //   519: istore 16
      //   521: iload 9
      //   523: istore 17
      //   525: iload 11
      //   527: istore 18
      //   529: aload_0
      //   530: invokespecial 172	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:readyToDraw	()Z
      //   533: ifeq +250 -> 783
      //   536: iload 4
      //   538: istore_3
      //   539: iload 11
      //   541: istore 10
      //   543: aload_0
      //   544: getfield 76	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglContext	Z
      //   547: ifne +14 -> 561
      //   550: iload 4
      //   552: ifeq +139 -> 691
      //   555: iconst_0
      //   556: istore_3
      //   557: iload 11
      //   559: istore 10
      //   561: aload_0
      //   562: getfield 76	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglContext	Z
      //   565: ifeq +703 -> 1268
      //   568: aload_0
      //   569: getfield 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglSurface	Z
      //   572: ifne +696 -> 1268
      //   575: aload_0
      //   576: iconst_1
      //   577: putfield 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglSurface	Z
      //   580: iconst_1
      //   581: istore 9
      //   583: iconst_1
      //   584: istore 5
      //   586: iconst_1
      //   587: istore 4
      //   589: aload_0
      //   590: getfield 78	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglSurface	Z
      //   593: ifeq +695 -> 1288
      //   596: aload_0
      //   597: getfield 47	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mSizeChanged	Z
      //   600: ifeq +651 -> 1251
      //   603: iconst_1
      //   604: istore_2
      //   605: aload_0
      //   606: getfield 49	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mWidth	I
      //   609: istore 6
      //   611: aload_0
      //   612: getfield 51	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHeight	I
      //   615: istore_1
      //   616: iconst_1
      //   617: istore 8
      //   619: iconst_1
      //   620: istore 5
      //   622: aload_0
      //   623: iconst_0
      //   624: putfield 47	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mSizeChanged	Z
      //   627: aload_0
      //   628: iconst_0
      //   629: putfield 53	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mRequestRender	Z
      //   632: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   635: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   638: iload 4
      //   640: istore 11
      //   642: iload 12
      //   644: istore 4
      //   646: iload 6
      //   648: istore 12
      //   650: iload 7
      //   652: istore 6
      //   654: iload_2
      //   655: istore 7
      //   657: iload 5
      //   659: istore 9
      //   661: iload 4
      //   663: istore_2
      //   664: iload_1
      //   665: istore 4
      //   667: iload 12
      //   669: istore_1
      //   670: iload 8
      //   672: istore 5
      //   674: iload 11
      //   676: istore 8
      //   678: goto -511 -> 167
      //   681: aload 24
      //   683: invokestatic 175	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Z
      //   686: istore 20
      //   688: goto -347 -> 341
      //   691: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   694: aload_0
      //   695: invokevirtual 178	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)Z
      //   698: istore 19
      //   700: iload 4
      //   702: istore_3
      //   703: iload 11
      //   705: istore 10
      //   707: iload 19
      //   709: ifeq -148 -> 561
      //   712: aload_0
      //   713: getfield 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h;
      //   716: invokevirtual 181	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h:start	()V
      //   719: aload_0
      //   720: iconst_1
      //   721: putfield 76	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mHaveEglContext	Z
      //   724: iconst_1
      //   725: istore 10
      //   727: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   730: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   733: iload 4
      //   735: istore_3
      //   736: goto -175 -> 561
      //   739: astore 21
      //   741: aload 23
      //   743: monitorexit
      //   744: aload 21
      //   746: athrow
      //   747: astore 22
      //   749: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   752: astore 21
      //   754: aload 21
      //   756: monitorenter
      //   757: aload_0
      //   758: invokespecial 86	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglSurfaceLocked	()V
      //   761: aload_0
      //   762: invokespecial 89	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:stopEglContextLocked	()V
      //   765: aload 21
      //   767: monitorexit
      //   768: aload 22
      //   770: athrow
      //   771: astore 21
      //   773: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   776: aload_0
      //   777: invokevirtual 185	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:b	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
      //   780: aload 21
      //   782: athrow
      //   783: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   786: invokevirtual 188	java/lang/Object:wait	()V
      //   789: iload 12
      //   791: istore 14
      //   793: iload 13
      //   795: istore 5
      //   797: iload 15
      //   799: istore 6
      //   801: iload 7
      //   803: istore 10
      //   805: iload 16
      //   807: istore 8
      //   809: iload 17
      //   811: istore 9
      //   813: iload 18
      //   815: istore 11
      //   817: goto -739 -> 78
      //   820: iload 9
      //   822: ifeq +426 -> 1248
      //   825: aload_0
      //   826: getfield 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h;
      //   829: invokevirtual 191	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h:createSurface	()Z
      //   832: ifeq +325 -> 1157
      //   835: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   838: astore 23
      //   840: aload 23
      //   842: monitorenter
      //   843: aload_0
      //   844: iconst_1
      //   845: putfield 193	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mFinishedCreatingEglSurface	Z
      //   848: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   851: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   854: aload 23
      //   856: monitorexit
      //   857: iconst_0
      //   858: istore 9
      //   860: iload 8
      //   862: ifeq +383 -> 1245
      //   865: aload_0
      //   866: getfield 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h;
      //   869: invokevirtual 197	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h:createGL	()Ljavax/microedition/khronos/opengles/GL;
      //   872: checkcast 199	javax/microedition/khronos/opengles/GL10
      //   875: astore 22
      //   877: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   880: aload 22
      //   882: invokevirtual 203	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:checkGLDriver	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   885: iconst_0
      //   886: istore 8
      //   888: iload 10
      //   890: istore 11
      //   892: iload 10
      //   894: ifeq +50 -> 944
      //   897: aload_0
      //   898: getfield 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   901: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   904: checkcast 6	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
      //   907: astore 23
      //   909: aload 23
      //   911: ifnull +396 -> 1307
      //   914: aload 23
      //   916: invokestatic 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   919: ifnull +388 -> 1307
      //   922: aload 23
      //   924: invokestatic 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   927: aload 22
      //   929: aload_0
      //   930: getfield 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h;
      //   933: getfield 210	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   936: invokeinterface 216 3 0
      //   941: goto +366 -> 1307
      //   944: iload 7
      //   946: istore 10
      //   948: iload 7
      //   950: ifeq +46 -> 996
      //   953: aload_0
      //   954: getfield 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   957: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   960: checkcast 6	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
      //   963: astore 23
      //   965: aload 23
      //   967: ifnull +346 -> 1313
      //   970: aload 23
      //   972: invokestatic 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   975: ifnull +338 -> 1313
      //   978: aload 23
      //   980: invokestatic 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   983: aload 22
      //   985: iload_1
      //   986: iload 4
      //   988: invokeinterface 220 4 0
      //   993: goto +320 -> 1313
      //   996: aload_0
      //   997: getfield 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mGLTextureViewWeakRef	Ljava/lang/ref/WeakReference;
      //   1000: invokevirtual 119	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1003: checkcast 6	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView
      //   1006: astore 23
      //   1008: aload 23
      //   1010: ifnull +28 -> 1038
      //   1013: aload 23
      //   1015: invokestatic 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   1018: ifnull +20 -> 1038
      //   1021: aload 22
      //   1023: ifnull +15 -> 1038
      //   1026: aload 23
      //   1028: invokestatic 206	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   1031: aload 22
      //   1033: invokeinterface 223 2 0
      //   1038: aload_0
      //   1039: getfield 74	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:a	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h;
      //   1042: invokevirtual 227	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h:swap	()I
      //   1045: istore 12
      //   1047: iload 6
      //   1049: istore 7
      //   1051: iload 12
      //   1053: lookupswitch	default:+266->1319, 12288:+62->1115, 12302:+170->1223
      //   1081: <illegal opcode>
      //   1082: ldc 230
      //   1084: iload 12
      //   1086: invokestatic 234	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$h:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
      //   1089: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   1092: astore 23
      //   1094: aload 23
      //   1096: monitorenter
      //   1097: aload_0
      //   1098: iconst_1
      //   1099: putfield 167	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   1102: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   1105: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   1108: aload 23
      //   1110: monitorexit
      //   1111: iload 6
      //   1113: istore 7
      //   1115: iload 5
      //   1117: ifeq +168 -> 1285
      //   1120: iconst_1
      //   1121: istore_2
      //   1122: iload_1
      //   1123: istore 12
      //   1125: iload_2
      //   1126: istore 6
      //   1128: iload 4
      //   1130: istore_1
      //   1131: iload 12
      //   1133: istore_2
      //   1134: iload 6
      //   1136: istore 4
      //   1138: iload 10
      //   1140: istore 6
      //   1142: iload 11
      //   1144: istore 10
      //   1146: goto -1088 -> 58
      //   1149: astore 21
      //   1151: aload 23
      //   1153: monitorexit
      //   1154: aload 21
      //   1156: athrow
      //   1157: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   1160: astore 23
      //   1162: aload 23
      //   1164: monitorenter
      //   1165: aload_0
      //   1166: iconst_1
      //   1167: putfield 193	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mFinishedCreatingEglSurface	Z
      //   1170: aload_0
      //   1171: iconst_1
      //   1172: putfield 167	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:mSurfaceIsBad	Z
      //   1175: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   1178: invokevirtual 111	java/lang/Object:notifyAll	()V
      //   1181: aload 23
      //   1183: monitorexit
      //   1184: iload 6
      //   1186: istore 11
      //   1188: iload_1
      //   1189: istore 12
      //   1191: iload_2
      //   1192: istore 6
      //   1194: iload 4
      //   1196: istore_1
      //   1197: iload 12
      //   1199: istore_2
      //   1200: iload 6
      //   1202: istore 4
      //   1204: iload 7
      //   1206: istore 6
      //   1208: iload 11
      //   1210: istore 7
      //   1212: goto -1154 -> 58
      //   1215: astore 21
      //   1217: aload 23
      //   1219: monitorexit
      //   1220: aload 21
      //   1222: athrow
      //   1223: iconst_1
      //   1224: istore 7
      //   1226: goto -111 -> 1115
      //   1229: astore 21
      //   1231: aload 23
      //   1233: monitorexit
      //   1234: aload 21
      //   1236: athrow
      //   1237: astore 22
      //   1239: aload 21
      //   1241: monitorexit
      //   1242: aload 22
      //   1244: athrow
      //   1245: goto -357 -> 888
      //   1248: goto -388 -> 860
      //   1251: iload 13
      //   1253: istore 8
      //   1255: iload_2
      //   1256: istore 6
      //   1258: iload 5
      //   1260: istore_2
      //   1261: iload 9
      //   1263: istore 5
      //   1265: goto -638 -> 627
      //   1268: iload 6
      //   1270: istore 5
      //   1272: iload 8
      //   1274: istore 4
      //   1276: goto -687 -> 589
      //   1279: iconst_0
      //   1280: istore 19
      //   1282: goto -1035 -> 247
      //   1285: goto -163 -> 1122
      //   1288: iload 5
      //   1290: istore 15
      //   1292: iload 4
      //   1294: istore 16
      //   1296: iload 9
      //   1298: istore 17
      //   1300: iload 10
      //   1302: istore 18
      //   1304: goto -521 -> 783
      //   1307: iconst_0
      //   1308: istore 11
      //   1310: goto -366 -> 944
      //   1313: iconst_0
      //   1314: istore 10
      //   1316: goto -320 -> 996
      //   1319: goto -239 -> 1080
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1322	0	this	GLThread
      //   32	1165	1	i	int
      //   54	1207	2	j	int
      //   34	702	3	k	int
      //   56	1237	4	m	int
      //   36	1253	5	n	int
      //   39	1230	6	i1	int
      //   42	1183	7	i2	int
      //   45	1228	8	i3	int
      //   48	1249	9	i4	int
      //   26	1289	10	i5	int
      //   68	1241	11	i6	int
      //   145	1053	12	i7	int
      //   486	766	13	i8	int
      //   76	716	14	i9	int
      //   515	776	15	i10	int
      //   519	776	16	i11	int
      //   523	776	17	i12	int
      //   527	776	18	i13	int
      //   231	1050	19	bool1	boolean
      //   339	348	20	bool2	boolean
      //   51	137	21	localObject1	Object
      //   739	6	21	localObject2	Object
      //   752	14	21	locali	GLTextureView.i
      //   771	10	21	localRuntimeException	RuntimeException
      //   1149	6	21	localObject3	Object
      //   1215	6	21	localObject4	Object
      //   1229	11	21	localObject5	Object
      //   29	1	22	localObject6	Object
      //   108	6	22	localObject7	Object
      //   747	22	22	localObject8	Object
      //   875	157	22	localGL10	javax.microedition.khronos.opengles.GL10
      //   1237	6	22	localObject9	Object
      //   331	351	24	localGLTextureView	GLTextureView
      // Exception table:
      //   from	to	target	type
      //   96	107	108	finally
      //   110	113	108	finally
      //   78	88	739	finally
      //   116	139	739	finally
      //   167	170	739	finally
      //   216	247	739	finally
      //   250	270	739	finally
      //   282	290	739	finally
      //   298	309	739	finally
      //   314	333	739	finally
      //   346	355	739	finally
      //   355	359	739	finally
      //   364	380	739	finally
      //   380	428	739	finally
      //   428	439	739	finally
      //   439	455	739	finally
      //   455	480	739	finally
      //   499	510	739	finally
      //   529	536	739	finally
      //   543	550	739	finally
      //   561	580	739	finally
      //   589	603	739	finally
      //   605	616	739	finally
      //   622	627	739	finally
      //   627	638	739	finally
      //   681	688	739	finally
      //   691	700	739	finally
      //   712	719	739	finally
      //   719	724	739	finally
      //   727	733	739	finally
      //   741	744	739	finally
      //   773	783	739	finally
      //   783	789	739	finally
      //   58	66	747	finally
      //   175	182	747	finally
      //   744	747	747	finally
      //   825	843	747	finally
      //   865	885	747	finally
      //   897	909	747	finally
      //   914	941	747	finally
      //   953	965	747	finally
      //   970	993	747	finally
      //   996	1008	747	finally
      //   1013	1021	747	finally
      //   1026	1038	747	finally
      //   1038	1047	747	finally
      //   1080	1097	747	finally
      //   1154	1157	747	finally
      //   1157	1165	747	finally
      //   1220	1223	747	finally
      //   1234	1237	747	finally
      //   712	719	771	java/lang/RuntimeException
      //   843	857	1149	finally
      //   1151	1154	1149	finally
      //   1165	1184	1215	finally
      //   1217	1220	1215	finally
      //   1097	1111	1229	finally
      //   1231	1234	1229	finally
      //   757	768	1237	finally
      //   1239	1242	1237	finally
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
        GLTextureView.a().b(this);
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
    
    public boolean ableToDraw()
    {
      return (this.mHaveEglContext) && (this.mHaveEglSurface) && (readyToDraw());
    }
    
    public int getRenderMode()
    {
      synchronized ()
      {
        int i = this.mRenderMode;
        return i;
      }
    }
    
    public void onWindowResize(int paramInt1, int paramInt2)
    {
      synchronized ()
      {
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
        this.mSizeChanged = true;
        this.mRequestRender = true;
        this.mRenderComplete = false;
        GLTextureView.a().notifyAll();
        for (;;)
        {
          if ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete))
          {
            boolean bool = ableToDraw();
            if (bool) {
              try
              {
                GLTextureView.a().wait();
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
      synchronized (GLTextureView.a())
      {
        this.mEventQueue.add(paramRunnable);
        GLTextureView.a().notifyAll();
        return;
      }
    }
    
    public void requestExitAndWait()
    {
      synchronized ()
      {
        this.mShouldExit = true;
        GLTextureView.a().notifyAll();
        for (;;)
        {
          boolean bool = this.mExited;
          if (!bool) {
            try
            {
              GLTextureView.a().wait();
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
      GLTextureView.a().notifyAll();
    }
    
    public void requestRender()
    {
      synchronized ()
      {
        this.mRequestRender = true;
        GLTextureView.a().notifyAll();
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: new 143	java/lang/StringBuilder
      //   4: dup
      //   5: invokespecial 144	java/lang/StringBuilder:<init>	()V
      //   8: ldc_w 269
      //   11: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   14: aload_0
      //   15: invokevirtual 154	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:getId	()J
      //   18: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   21: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   24: invokevirtual 272	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:setName	(Ljava/lang/String;)V
      //   27: aload_0
      //   28: invokespecial 274	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread:guardedRun	()V
      //   31: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   34: aload_0
      //   35: invokevirtual 276	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
      //   38: return
      //   39: astore_1
      //   40: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   43: aload_0
      //   44: invokevirtual 276	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
      //   47: return
      //   48: astore_1
      //   49: invokestatic 81	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i;
      //   52: aload_0
      //   53: invokevirtual 276	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:a	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$GLThread;)V
      //   56: aload_1
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	GLThread
      //   39	1	1	localInterruptedException	InterruptedException
      //   48	9	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   27	31	39	java/lang/InterruptedException
      //   27	31	48	finally
    }
    
    public void setRenderMode(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 1)) {
        throw new IllegalArgumentException("renderMode");
      }
      synchronized (GLTextureView.a())
      {
        this.mRenderMode = paramInt;
        GLTextureView.a().notifyAll();
        return;
      }
    }
    
    public void surfaceCreated()
    {
      synchronized ()
      {
        this.mHasSurface = true;
        this.mFinishedCreatingEglSurface = false;
        GLTextureView.a().notifyAll();
        for (;;)
        {
          if ((this.mWaitingForSurface) && (!this.mFinishedCreatingEglSurface))
          {
            boolean bool = this.mExited;
            if (!bool) {
              try
              {
                GLTextureView.a().wait();
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
      synchronized ()
      {
        this.mHasSurface = false;
        GLTextureView.a().notifyAll();
        for (;;)
        {
          if ((!this.mWaitingForSurface) && (!this.mExited))
          {
            if ((!this.mLogPrinted) && (QLog.isColorLevel()))
            {
              this.mLogPrinted = true;
              QLog.d("GLTextureView", 2, "mWaitingForSurface " + this.mWaitingForSurface + " mExited " + this.mExited);
            }
            try
            {
              GLTextureView.a().wait();
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
    implements GLTextureView.e
  {
    protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);
    
    public a(int[] paramArrayOfInt) {}
    
    private int[] filterConfigSpec(int[] paramArrayOfInt)
    {
      if ((GLTextureView.a(GLTextureView.this) != 2) && (GLTextureView.a(GLTextureView.this) != 3)) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
      arrayOfInt[(i - 1)] = 12352;
      if (GLTextureView.a(GLTextureView.this) == 2) {
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
      arrayOfInt[1] = GLTextureView.a(GLTextureView.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (GLTextureView.a(GLTextureView.this) != 0) {}
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
      catch (IllegalArgumentException paramEGL10)
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
          GLTextureView.a(localGLTextureView).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
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
        if (GLTextureView.a(localGLTextureView) != null) {
          localGL1 = GLTextureView.a(localGLTextureView).wrap(localGL2);
        }
        localObject = localGL1;
        if ((GLTextureView.b(localGLTextureView) & 0x3) != 0)
        {
          i = 0;
          if ((GLTextureView.b(localGLTextureView) & 0x1) != 0) {
            i = 1;
          }
          if ((GLTextureView.b(localGLTextureView) & 0x2) == 0) {
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
      if (localGLTextureView != null) {}
      for (this.mEglSurface = GLTextureView.a(localGLTextureView).createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, localGLTextureView.getSurfaceTexture()); (this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE); this.mEglSurface = null)
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
          GLTextureView.a(localGLTextureView).destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
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
      if (localObject == null) {
        this.mEglConfig = null;
      }
      for (this.mEglContext = null;; this.mEglContext = GLTextureView.a((GLTextureView)localObject).createContext(this.mEgl, this.mEglDisplay, this.mEglConfig))
      {
        if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
        {
          this.mEglContext = null;
          throwEglException("createContext");
        }
        this.mEglSurface = null;
        return;
        this.mEglConfig = GLTextureView.a((GLTextureView)localObject).chooseConfig(this.mEgl, this.mEglDisplay);
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
    private GLTextureView.GLThread b;
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
        GLTextureView.GLThread.a(paramGLThread, true);
        if (this.b == paramGLThread) {
          this.b = null;
        }
        notifyAll();
        return;
      }
      finally {}
    }
    
    public boolean a(GLTextureView.GLThread paramGLThread)
    {
      if ((this.b == paramGLThread) || (this.b == null))
      {
        this.b = paramGLThread;
        notifyAll();
      }
      do
      {
        return true;
        checkGLESVersion();
      } while (this.mMultipleGLESContextsAllowed);
      if (this.b != null) {
        this.b.requestReleaseEglContextLocked();
      }
      return false;
    }
    
    public void b(GLTextureView.GLThread paramGLThread)
    {
      if (this.b == paramGLThread) {
        this.b = null;
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
      //   5: getfield 64	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:mGLESDriverCheckComplete	Z
      //   8: ifne +65 -> 73
      //   11: aload_0
      //   12: invokespecial 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:checkGLESVersion	()V
      //   15: aload_1
      //   16: sipush 7937
      //   19: invokeinterface 70 2 0
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 39	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:mGLESVersion	I
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
      //   47: putfield 42	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:mMultipleGLESContextsAllowed	Z
      //   50: aload_0
      //   51: invokevirtual 54	java/lang/Object:notifyAll	()V
      //   54: aload_0
      //   55: getfield 42	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:mMultipleGLESContextsAllowed	Z
      //   58: ifne +23 -> 81
      //   61: iload_3
      //   62: istore_2
      //   63: aload_0
      //   64: iload_2
      //   65: putfield 80	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:mLimitedGLESContexts	Z
      //   68: aload_0
      //   69: iconst_1
      //   70: putfield 64	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:mGLESDriverCheckComplete	Z
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
      //   3: invokespecial 57	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:checkGLESVersion	()V
      //   6: aload_0
      //   7: getfield 42	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/GLTextureView$i:mMultipleGLESContextsAllowed	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView
 * JD-Core Version:    0.7.0.1
 */