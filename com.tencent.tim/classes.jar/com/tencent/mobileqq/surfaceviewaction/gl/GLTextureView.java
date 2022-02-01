package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private List<a> GM = Collections.synchronizedList(new ArrayList());
  private RenderThreadRunnable jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable;
  private GL10 jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10;
  private List<Runnable> aU = new LinkedList();
  private boolean cKG;
  private int dNw = 16;
  private Object eZ = new Object();
  private EGL10 mEgl;
  private EGLConfig mEglConfig;
  private EGLContext mEglContext;
  private EGLDisplay mEglDisplay;
  private EGLSurface mEglSurface;
  private volatile boolean mIsPause;
  private GLSurfaceView.Renderer mRenderer;
  private SurfaceTexture mSurface;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    initialize(paramContext);
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize(paramContext);
  }
  
  private void a(GLSurfaceView.Renderer paramRenderer)
  {
    if (paramRenderer != null) {}
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable != null) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable.mIsRunning))
      {
        paramRenderer.onSurfaceCreated(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10, this.mEglConfig);
        paramRenderer.onSurfaceChanged(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10, this.mSurfaceWidth, this.mSurfaceHeight);
      }
      return;
    }
    finally
    {
      paramRenderer = finally;
      throw paramRenderer;
    }
  }
  
  private boolean azp()
  {
    return this.mRenderer == null;
  }
  
  private void dTP()
  {
    int i = this.mEgl.eglGetError();
    if ((i != 12288) && (QLog.isColorLevel())) {
      QLog.e("GLTextureView", 2, "EGL error = 0x" + Integer.toHexString(i));
    }
  }
  
  private void dTQ()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10 != null)
    {
      i = this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10.glGetError();
      if ((i != 0) && (QLog.isColorLevel())) {
        QLog.e("GLTextureView", 2, "GL error = 0x" + Integer.toHexString(i));
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
    }
    QLog.e("GLTextureView", 2, "mGl == null");
  }
  
  private void dTR()
  {
    this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
    this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
    this.mEglContext = EGL10.EGL_NO_CONTEXT;
    this.mEglSurface = EGL10.EGL_NO_SURFACE;
  }
  
  private void drawFrame()
  {
    try
    {
      if (this.mRenderer != null) {
        this.mRenderer.onDrawFrame(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10);
      }
      if ((!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) && (QLog.isColorLevel())) {
        QLog.e("GLTextureView", 2, "cannot swap buffers!");
      }
      return;
    }
    finally {}
  }
  
  private void initGL()
  {
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    int[] arrayOfInt = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, arrayOfInt)) {
      throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    arrayOfInt = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    this.mEglConfig = null;
    if (!this.mEgl.eglChooseConfig(this.mEglDisplay, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 }, arrayOfEGLConfig, 1, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    if (arrayOfInt[0] > 0) {
      this.mEglConfig = arrayOfEGLConfig[0];
    }
    if (this.mEglConfig == null) {
      throw new RuntimeException("eglConfig not initialized");
    }
    this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, this.mEglConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    dTP();
    this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, this.mSurface, null);
    dTP();
    if ((this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE))
    {
      int i = this.mEgl.eglGetError();
      if (i == 12299)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GLTextureView", 2, "eglCreateWindowSurface returned EGL10.EGL_BAD_NATIVE_WINDOW");
        }
        return;
      }
      throw new RuntimeException("eglCreateWindowSurface failed " + GLUtils.getEGLErrorString(i));
    }
    if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
      throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    dTP();
    this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10 = ((GL10)this.mEglContext.getGL());
    dTP();
  }
  
  private void initialize(Context paramContext)
  {
    setOpaque(false);
    setSurfaceTextureListener(this);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, "Starting GLTextureView thread");
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable = new RenderThreadRunnable(null);
    this.mSurface = paramSurfaceTexture;
    setDimensions(paramInt1, paramInt2);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable, 10, null, true);
  }
  
  public void a(a parama)
  {
    this.GM.add(parama);
  }
  
  public void b(a parama)
  {
    this.GM.remove(parama);
  }
  
  public void dTO()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, "Stopping and joining GLTextureView");
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable.mIsRunning = false;
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable = null;
        return;
      }
      finally {}
    }
  }
  
  public boolean isPause()
  {
    return this.mIsPause;
  }
  
  public void onPause()
  {
    this.mIsPause = true;
  }
  
  public void onResume()
  {
    this.mIsPause = false;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("GLTextureView", 1, "onSurfaceTextureAvailable");
    a(paramSurfaceTexture, paramInt1, paramInt2);
    setAlpha(0.0F);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    QLog.i("GLTextureView", 1, "onSurfaceTextureDestroyed");
    dTO();
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("GLTextureView", 1, "onSurfaceTextureSizeChanged");
    setDimensions(paramInt1, paramInt2);
    if (this.mRenderer != null) {
      this.mRenderer.onSurfaceChanged(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void queueEvent(Runnable paramRunnable)
  {
    synchronized (this.eZ)
    {
      this.aU.add(paramRunnable);
      return;
    }
  }
  
  public void setDimensions(int paramInt1, int paramInt2)
  {
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
  }
  
  public void setFps(int paramInt)
  {
    this.dNw = ((int)(1.0F / paramInt * 1000.0F));
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    this.mRenderer = paramRenderer;
    this.cKG = true;
  }
  
  class RenderThreadRunnable
    implements Runnable
  {
    public boolean mIsRunning;
    
    private RenderThreadRunnable() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   5: ifeq +11 -> 16
      //   8: ldc 37
      //   10: iconst_2
      //   11: ldc 39
      //   13: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   16: ldc 8
      //   18: monitorenter
      //   19: aload_0
      //   20: iconst_1
      //   21: putfield 45	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:mIsRunning	Z
      //   24: ldc 8
      //   26: monitorexit
      //   27: aload_0
      //   28: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   31: iconst_1
      //   32: invokestatic 49	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Z)Z
      //   35: pop
      //   36: aload_0
      //   37: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   40: invokestatic 51	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
      //   43: aload_0
      //   44: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   47: invokestatic 54	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
      //   50: iconst_0
      //   51: istore_1
      //   52: iload_1
      //   53: aload_0
      //   54: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   57: invokestatic 57	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   60: invokeinterface 63 1 0
      //   65: if_icmpge +73 -> 138
      //   68: aload_0
      //   69: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   72: invokestatic 57	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   75: iload_1
      //   76: invokeinterface 67 2 0
      //   81: checkcast 69	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$a
      //   84: invokeinterface 72 1 0
      //   89: iload_1
      //   90: iconst_1
      //   91: iadd
      //   92: istore_1
      //   93: goto -41 -> 52
      //   96: astore 7
      //   98: ldc 8
      //   100: monitorexit
      //   101: aload 7
      //   103: athrow
      //   104: astore 7
      //   106: ldc 37
      //   108: iconst_2
      //   109: new 74	java/lang/StringBuilder
      //   112: dup
      //   113: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   116: ldc 77
      //   118: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   121: aload 7
      //   123: invokestatic 85	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   126: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   129: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   132: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   135: goto -92 -> 43
      //   138: aload_0
      //   139: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   142: new 94	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable$1
      //   145: dup
      //   146: aload_0
      //   147: invokespecial 97	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable$1:<init>	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable;)V
      //   150: invokevirtual 101	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:post	(Ljava/lang/Runnable;)Z
      //   153: pop
      //   154: invokestatic 107	java/lang/System:currentTimeMillis	()J
      //   157: lstore_3
      //   158: aload_0
      //   159: getfield 45	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:mIsRunning	Z
      //   162: ifeq +303 -> 465
      //   165: aload_0
      //   166: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   169: invokestatic 110	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   172: ifnonnull +17 -> 189
      //   175: ldc2_w 111
      //   178: invokestatic 118	java/lang/Thread:sleep	(J)V
      //   181: goto -16 -> 165
      //   184: astore 7
      //   186: goto -21 -> 165
      //   189: aload_0
      //   190: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   193: invokestatic 121	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
      //   196: ifeq +26 -> 222
      //   199: aload_0
      //   200: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   203: aload_0
      //   204: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   207: invokestatic 110	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
      //   210: invokestatic 124	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Landroid/opengl/GLSurfaceView$Renderer;)V
      //   213: aload_0
      //   214: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   217: iconst_0
      //   218: invokestatic 49	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Z)Z
      //   221: pop
      //   222: aload_0
      //   223: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   226: invokestatic 126	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
      //   229: ifne +376 -> 605
      //   232: invokestatic 107	java/lang/System:currentTimeMillis	()J
      //   235: lstore_3
      //   236: aload_0
      //   237: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   240: invokestatic 129	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/lang/Object;
      //   243: astore 7
      //   245: aload 7
      //   247: monitorenter
      //   248: iconst_0
      //   249: istore_1
      //   250: iload_1
      //   251: aload_0
      //   252: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   255: invokestatic 131	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   258: invokeinterface 63 1 0
      //   263: if_icmpge +31 -> 294
      //   266: aload_0
      //   267: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   270: invokestatic 131	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   273: iload_1
      //   274: invokeinterface 67 2 0
      //   279: checkcast 6	java/lang/Runnable
      //   282: invokeinterface 133 1 0
      //   287: iload_1
      //   288: iconst_1
      //   289: iadd
      //   290: istore_1
      //   291: goto -41 -> 250
      //   294: aload_0
      //   295: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   298: invokestatic 131	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   301: invokeinterface 136 1 0
      //   306: aload 7
      //   308: monitorexit
      //   309: ldc 8
      //   311: monitorenter
      //   312: aload_0
      //   313: getfield 45	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:mIsRunning	Z
      //   316: ifeq +20 -> 336
      //   319: aload_0
      //   320: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   323: invokestatic 139	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
      //   326: ifne +10 -> 336
      //   329: aload_0
      //   330: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   333: invokestatic 141	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
      //   336: ldc 8
      //   338: monitorexit
      //   339: aload_0
      //   340: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   343: invokestatic 126	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
      //   346: ifne +13 -> 359
      //   349: aload_0
      //   350: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   353: invokestatic 139	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
      //   356: ifeq +68 -> 424
      //   359: ldc2_w 111
      //   362: invokestatic 118	java/lang/Thread:sleep	(J)V
      //   365: goto -207 -> 158
      //   368: astore 8
      //   370: aload 7
      //   372: monitorexit
      //   373: aload 8
      //   375: athrow
      //   376: astore 7
      //   378: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   381: ifeq -45 -> 336
      //   384: ldc 37
      //   386: iconst_2
      //   387: new 74	java/lang/StringBuilder
      //   390: dup
      //   391: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   394: ldc 143
      //   396: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   399: aload 7
      //   401: invokestatic 85	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   404: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   410: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   413: goto -77 -> 336
      //   416: astore 7
      //   418: ldc 8
      //   420: monitorexit
      //   421: aload 7
      //   423: athrow
      //   424: invokestatic 107	java/lang/System:currentTimeMillis	()J
      //   427: lstore 5
      //   429: ldc2_w 144
      //   432: aload_0
      //   433: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   436: invokestatic 148	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)I
      //   439: i2l
      //   440: lload 5
      //   442: lload_3
      //   443: lsub
      //   444: lsub
      //   445: invokestatic 154	java/lang/Math:max	(JJ)J
      //   448: invokestatic 118	java/lang/Thread:sleep	(J)V
      //   451: lload 5
      //   453: lstore_3
      //   454: goto -296 -> 158
      //   457: astore 7
      //   459: lload 5
      //   461: lstore_3
      //   462: goto -304 -> 158
      //   465: aload_0
      //   466: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   469: invokestatic 129	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/lang/Object;
      //   472: astore 7
      //   474: aload 7
      //   476: monitorenter
      //   477: iconst_0
      //   478: istore_1
      //   479: iload_1
      //   480: aload_0
      //   481: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   484: invokestatic 131	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   487: invokeinterface 63 1 0
      //   492: if_icmpge +31 -> 523
      //   495: aload_0
      //   496: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   499: invokestatic 131	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   502: iload_1
      //   503: invokeinterface 67 2 0
      //   508: checkcast 6	java/lang/Runnable
      //   511: invokeinterface 133 1 0
      //   516: iload_1
      //   517: iconst_1
      //   518: iadd
      //   519: istore_1
      //   520: goto -41 -> 479
      //   523: aload_0
      //   524: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   527: invokestatic 131	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   530: invokeinterface 136 1 0
      //   535: aload 7
      //   537: monitorexit
      //   538: aload_0
      //   539: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   542: invokestatic 156	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:d	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
      //   545: iload_2
      //   546: istore_1
      //   547: iload_1
      //   548: aload_0
      //   549: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   552: invokestatic 57	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   555: invokeinterface 63 1 0
      //   560: if_icmpge +39 -> 599
      //   563: aload_0
      //   564: getfield 17	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
      //   567: invokestatic 57	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
      //   570: iload_1
      //   571: invokeinterface 67 2 0
      //   576: checkcast 69	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$a
      //   579: invokeinterface 159 1 0
      //   584: iload_1
      //   585: iconst_1
      //   586: iadd
      //   587: istore_1
      //   588: goto -41 -> 547
      //   591: astore 8
      //   593: aload 7
      //   595: monitorexit
      //   596: aload 8
      //   598: athrow
      //   599: return
      //   600: astore 7
      //   602: goto -444 -> 158
      //   605: goto -266 -> 339
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	608	0	this	RenderThreadRunnable
      //   51	537	1	i	int
      //   1	545	2	j	int
      //   157	305	3	l1	long
      //   427	33	5	l2	long
      //   96	6	7	localObject1	Object
      //   104	18	7	localException1	java.lang.Exception
      //   184	1	7	localInterruptedException1	java.lang.InterruptedException
      //   243	128	7	localObject2	Object
      //   376	24	7	localException2	java.lang.Exception
      //   416	6	7	localObject3	Object
      //   457	1	7	localInterruptedException2	java.lang.InterruptedException
      //   472	122	7	localObject4	Object
      //   600	1	7	localInterruptedException3	java.lang.InterruptedException
      //   368	6	8	localObject5	Object
      //   591	6	8	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   19	27	96	finally
      //   98	101	96	finally
      //   36	43	104	java/lang/Exception
      //   175	181	184	java/lang/InterruptedException
      //   250	287	368	finally
      //   294	309	368	finally
      //   370	373	368	finally
      //   312	336	376	java/lang/Exception
      //   312	336	416	finally
      //   336	339	416	finally
      //   378	413	416	finally
      //   418	421	416	finally
      //   429	451	457	java/lang/InterruptedException
      //   479	516	591	finally
      //   523	538	591	finally
      //   593	596	591	finally
      //   339	359	600	java/lang/InterruptedException
      //   359	365	600	java/lang/InterruptedException
      //   424	429	600	java/lang/InterruptedException
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCreate();
    
    public abstract void onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView
 * JD-Core Version:    0.7.0.1
 */