package com.tencent.av.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import atau.a;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import iow;
import ipm;
import ipn;
import iqg;
import iqk;
import iqq;
import iqs;
import iqt;
import iqu;
import irc;
import iwo;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import mqq.os.MqqHandler;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static int asd;
  private final String TAG = "GLRootView_" + this.mSeq;
  private boolean Ue;
  boolean Uf = false;
  protected iqt a;
  private iwo a;
  final int ase = 20;
  int asf = 0;
  private ipm b;
  private boolean mFirstDraw = true;
  private int mFlags = 2;
  private boolean mInDownState;
  long mLastRenderTime = 0L;
  private final ReentrantLock mRenderLock = new ReentrantLock();
  private volatile boolean mRenderRequested;
  private Runnable mRequestRenderOnAnimationFrame = new GLRootView.1(this);
  final long mSeq = AudioHelper.hG();
  
  public GLRootView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GLRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "GLRootView, 构造");
    }
    boolean bool1 = bool2;
    if (!Build.MODEL.equalsIgnoreCase("MI 9")) {
      if (!Build.MODEL.equalsIgnoreCase("MI 9 Transparent Edition")) {
        break label162;
      }
    }
    label162:
    for (bool1 = bool2;; bool1 = false)
    {
      this.Ue = bool1;
      CameraUtils.a(paramContext);
      GraphicRenderMgr.loadSo();
      if (!isInEditMode()) {
        break;
      }
      return;
    }
    this.mFlags |= 0x1;
    setBackgroundDrawable(null);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qD, 0, 0);
      if (paramAttributeSet == null) {}
    }
    try
    {
      this.Uf = paramAttributeSet.getBoolean(0, false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "GLRootView e = " + localException);
        }
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    setEGLContextClientVersion(irc.getGLVersion(paramContext));
    if (this.Uf)
    {
      setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      getHolder().setFormat(-3);
    }
    for (;;)
    {
      setRenderer(this);
      if (!iow.uW()) {
        break;
      }
      this.jdField_a_of_type_Iwo = new iwo();
      return;
      if (irc.USE_888_PIXEL_FORMAT)
      {
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        getHolder().setFormat(3);
      }
      else
      {
        setEGLConfigChooser(5, 6, 5, 0, 0, 0);
        getHolder().setFormat(4);
      }
    }
  }
  
  private void layoutContentPane()
  {
    this.mFlags &= 0xFFFFFFFD;
    int i = getWidth();
    int j = getHeight();
    if ((this.jdField_a_of_type_Iqt != null) && (i != 0) && (j != 0)) {
      this.jdField_a_of_type_Iqt.layout(0, 0, i, j);
    }
  }
  
  public iwo a()
  {
    return this.jdField_a_of_type_Iwo;
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Iqt != null) && ((this.jdField_a_of_type_Iqt instanceof VideoLayerUI)) && (((VideoLayerUI)this.jdField_a_of_type_Iqt).dispatchHoverEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  /* Error */
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 243	com/tencent/av/opengl/ui/GLRootView:isEnabled	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_1
    //   10: invokevirtual 248	android/view/MotionEvent:getAction	()I
    //   13: istore_2
    //   14: iload_2
    //   15: iconst_3
    //   16: if_icmpeq +8 -> 24
    //   19: iload_2
    //   20: iconst_1
    //   21: if_icmpne +68 -> 89
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 250	com/tencent/av/opengl/ui/GLRootView:mInDownState	Z
    //   29: aload_0
    //   30: getfield 49	com/tencent/av/opengl/ui/GLRootView:mRenderLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   33: ldc2_w 251
    //   36: getstatic 258	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   39: invokevirtual 262	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: ifeq +88 -> 132
    //   47: aload_0
    //   48: getfield 223	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Iqt	Liqt;
    //   51: ifnull +51 -> 102
    //   54: aload_0
    //   55: getfield 223	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Iqt	Liqt;
    //   58: aload_1
    //   59: invokevirtual 264	iqt:dispatchTouchEvent	(Landroid/view/MotionEvent;)Z
    //   62: ifeq +40 -> 102
    //   65: iconst_1
    //   66: istore_3
    //   67: iload_2
    //   68: ifne +12 -> 80
    //   71: iload_3
    //   72: ifeq +8 -> 80
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 250	com/tencent/av/opengl/ui/GLRootView:mInDownState	Z
    //   80: aload_0
    //   81: getfield 49	com/tencent/av/opengl/ui/GLRootView:mRenderLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   84: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   87: iload_3
    //   88: ireturn
    //   89: aload_0
    //   90: getfield 250	com/tencent/av/opengl/ui/GLRootView:mInDownState	Z
    //   93: ifne -64 -> 29
    //   96: iload_2
    //   97: ifeq -68 -> 29
    //   100: iconst_0
    //   101: ireturn
    //   102: iconst_0
    //   103: istore_3
    //   104: goto -37 -> 67
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 49	com/tencent/av/opengl/ui/GLRootView:mRenderLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   112: invokevirtual 267	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 92	com/tencent/av/opengl/ui/GLRootView:TAG	Ljava/lang/String;
    //   122: iconst_1
    //   123: ldc_w 269
    //   126: aload_1
    //   127: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: iconst_0
    //   131: ireturn
    //   132: aload_0
    //   133: getfield 92	com/tencent/av/opengl/ui/GLRootView:TAG	Ljava/lang/String;
    //   136: iconst_1
    //   137: ldc_w 269
    //   140: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: iconst_0
    //   144: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	GLRootView
    //   0	145	1	paramMotionEvent	MotionEvent
    //   13	84	2	i	int
    //   42	62	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   47	65	107	finally
    //   75	80	107	finally
    //   29	43	117	java/lang/InterruptedException
    //   80	87	117	java/lang/InterruptedException
    //   108	117	117	java/lang/InterruptedException
    //   132	143	117	java/lang/InterruptedException
  }
  
  /* Error */
  protected void finalize()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: invokestatic 280	iqg:clear	()V
    //   3: aload_0
    //   4: invokespecial 282	android/opengl/GLSurfaceView:finalize	()V
    //   7: invokestatic 98	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   10: ifeq +14 -> 24
    //   13: aload_0
    //   14: getfield 92	com/tencent/av/opengl/ui/GLRootView:TAG	Ljava/lang/String;
    //   17: iconst_1
    //   18: ldc_w 284
    //   21: invokestatic 104	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: invokespecial 282	android/opengl/GLSurfaceView:finalize	()V
    //   30: goto -23 -> 7
    //   33: astore_1
    //   34: aload_0
    //   35: invokespecial 282	android/opengl/GLSurfaceView:finalize	()V
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	GLRootView
    //   25	1	1	localException	Exception
    //   33	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	3	25	java/lang/Exception
    //   0	3	33	finally
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.Ue)
    {
      this.mRenderLock.lock();
      if (asd != 1)
      {
        this.mRenderLock.unlock();
        QLog.e(this.TAG, 1, "onDrawFrame failed. sCreatedSurfaceCnt = " + asd);
        this.mRenderRequested = false;
        requestRender();
        return;
      }
      this.mRenderLock.unlock();
    }
    SystemClock.elapsedRealtime();
    iqs.update();
    if (this.Uf) {}
    for (float f = 0.0F;; f = 1.0F)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, f);
      GLES20.glClear(16640);
      this.mRenderLock.lock();
      label144:
      try
      {
        if (this.asf > 0) {
          this.asf -= 1;
        }
      }
      finally {}
      try
      {
        onDrawFrameLocked(paramGL10);
      }
      catch (Exception paramGL10)
      {
        this.mRenderRequested = false;
        if (!QLog.isColorLevel()) {
          break label314;
        }
        QLog.e(this.TAG, 2, "WL_DEBUG onDrawFrame e = " + paramGL10);
        StackTraceElement[] arrayOfStackTraceElement = paramGL10.getStackTrace();
        int j = arrayOfStackTraceElement.length;
        paramGL10 = "";
        int i = 0;
        while (i < j)
        {
          paramGL10 = paramGL10 + "WL_DEBUG onDrawFrame ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
          i += 1;
        }
        QLog.e(this.TAG, 2, paramGL10);
        this.mRenderLock.unlock();
        break label144;
      }
      finally
      {
        this.mRenderLock.unlock();
      }
      if ((this.mFirstDraw) && (this.jdField_a_of_type_Iqt != null))
      {
        this.mFirstDraw = false;
        this.jdField_a_of_type_Iqt.onFirstDraw();
      }
      this.mLastRenderTime = SystemClock.elapsedRealtime();
      return;
    }
  }
  
  protected void onDrawFrameLocked(GL10 paramGL10)
  {
    this.b.deleteRecycledResources();
    iqq.resetUploadLimit();
    this.mRenderRequested = false;
    if ((this.mFlags & 0x2) != 0) {
      layoutContentPane();
    }
    if (this.jdField_a_of_type_Iqt != null) {
      this.jdField_a_of_type_Iqt.d(this.b);
    }
    for (;;)
    {
      if (iqq.uploadLimitReached()) {
        requestRender();
      }
      return;
      this.b.clearBuffer();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      requestLayoutContentPane();
    }
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Iqt instanceof iqu)) {
      queueEvent(new GLRootView.2(this));
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mRenderRequested = false;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "onSurfaceChanged: " + paramInt1 + "x" + paramInt2 + ", gl10: " + paramGL10.toString());
    }
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      QLog.d(this.TAG, 1, "onSurfaceChanged: error system callback - width or height is Zero value");
    }
    Process.setThreadPriority(-4);
    this.b.setSize(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = (GL11)paramGL10;
    this.mRenderLock.lock();
    try
    {
      this.b = new ipn();
      iqk.invalidateAllTextures();
      if (this.jdField_a_of_type_Iwo != null) {
        this.jdField_a_of_type_Iwo.akO();
      }
      if ((this.jdField_a_of_type_Iqt != null) && ((this.jdField_a_of_type_Iqt instanceof iqu))) {
        ((iqu)this.jdField_a_of_type_Iqt).apA();
      }
      this.mRenderLock.unlock();
      iqg.clear();
      setRenderMode(0);
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  public void requestLayoutContentPane()
  {
    this.mRenderLock.lock();
    try
    {
      if (this.jdField_a_of_type_Iqt != null)
      {
        i = this.mFlags;
        if ((i & 0x2) == 0) {}
      }
      else
      {
        return;
      }
      int i = this.mFlags;
      if ((i & 0x1) == 0) {
        return;
      }
      this.mFlags |= 0x2;
      requestRender();
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void requestRender()
  {
    if (this.mRenderRequested) {
      return;
    }
    this.mRenderRequested = true;
    long l = SystemClock.elapsedRealtime() - this.mLastRenderTime;
    if ((l > 0L) && (l < 20L))
    {
      try
      {
        if (this.asf >= 2) {
          return;
        }
      }
      finally {}
      this.asf += 1;
      super.postDelayed(this.mRequestRenderOnAnimationFrame, 20L - l);
      return;
    }
    ThreadManager.getUIHandler().post(this.mRequestRenderOnAnimationFrame);
  }
  
  public void setContentPane(iqt paramiqt)
  {
    if (this.jdField_a_of_type_Iqt == paramiqt) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Iqt != null)
      {
        if (this.mInDownState)
        {
          long l = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.jdField_a_of_type_Iqt.dispatchTouchEvent(localMotionEvent);
          localMotionEvent.recycle();
          this.mInDownState = false;
        }
        this.jdField_a_of_type_Iqt.detachFromRoot();
        iqk.yieldAllTextures();
      }
      this.jdField_a_of_type_Iqt = paramiqt;
    } while (paramiqt == null);
    paramiqt.b(this);
    requestLayoutContentPane();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.Ue)
    {
      this.mRenderLock.lock();
      asd += 1;
      this.mRenderLock.unlock();
    }
    QLog.i(this.TAG, 1, "STest. surfaceCreated. sCreatedSurfaceCnt = " + asd);
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.Ue)
    {
      this.mRenderLock.lock();
      asd -= 1;
      this.mRenderLock.unlock();
    }
    QLog.i(this.TAG, 1, "STest. surfaceDestroyed. sCreatedSurfaceCnt = " + asd);
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */