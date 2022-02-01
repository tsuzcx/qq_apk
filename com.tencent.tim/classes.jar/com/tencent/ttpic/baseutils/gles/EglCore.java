package com.tencent.ttpic.baseutils.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;

@TargetApi(17)
public final class EglCore
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  public static final int FLAG_RECORDABLE = 1;
  public static final int FLAG_TRY_GLES3 = 2;
  private static final String TAG = EglCore.class.getSimpleName();
  private EGLConfig mEGLConfig = null;
  private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
  private int mGlVersion = -1;
  private final Throwable throwableForStackTrace = new Throwable();
  
  public EglCore()
  {
    this(null, 0);
  }
  
  public EglCore(EGLContext paramEGLContext, int paramInt)
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("EGL already set up");
    }
    EGLContext localEGLContext1 = paramEGLContext;
    if (paramEGLContext == null) {
      localEGLContext1 = EGL14.EGL_NO_CONTEXT;
    }
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    paramEGLContext = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, paramEGLContext, 0, paramEGLContext, 1))
    {
      this.mEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    if ((paramInt & 0x2) != 0)
    {
      paramEGLContext = getConfig(paramInt, 3);
      if (paramEGLContext != null)
      {
        EGLContext localEGLContext2 = EGL14.eglCreateContext(this.mEGLDisplay, paramEGLContext, localEGLContext1, new int[] { 12440, 3, 12344 }, 0);
        if (EGL14.eglGetError() == 12288)
        {
          this.mEGLConfig = paramEGLContext;
          this.mEGLContext = localEGLContext2;
          this.mGlVersion = 3;
        }
      }
    }
    if (this.mEGLContext == EGL14.EGL_NO_CONTEXT)
    {
      paramEGLContext = getConfig(paramInt, 2);
      if (paramEGLContext == null) {
        throw new RuntimeException("Unable to find a suitable EGLConfig");
      }
      localEGLContext1 = EGL14.eglCreateContext(this.mEGLDisplay, paramEGLContext, localEGLContext1, new int[] { 12440, 2, 12344 }, 0);
      checkEglError("eglCreateContext");
      this.mEGLConfig = paramEGLContext;
      this.mEGLContext = localEGLContext1;
      this.mGlVersion = 2;
    }
    paramEGLContext = new int[1];
    EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, paramEGLContext, 0);
    LogUtils.d(TAG, "EGLContext created, client version " + paramEGLContext[0]);
  }
  
  private void checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288) {
      LogUtils.e(TAG, paramString + ": EGL error: 0x" + Integer.toHexString(i));
    }
  }
  
  private EGLConfig getConfig(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 3) {}
    for (int i = 68;; i = 4)
    {
      int[] arrayOfInt1 = new int[13];
      arrayOfInt1[0] = 12324;
      arrayOfInt1[1] = 8;
      arrayOfInt1[2] = 12323;
      arrayOfInt1[3] = 8;
      arrayOfInt1[4] = 12322;
      arrayOfInt1[5] = 8;
      arrayOfInt1[6] = 12321;
      arrayOfInt1[7] = 8;
      arrayOfInt1[8] = 12352;
      arrayOfInt1[9] = i;
      arrayOfInt1[10] = 12344;
      arrayOfInt1[11] = 0;
      arrayOfInt1[12] = 12344;
      if ((paramInt1 & 0x1) != 0)
      {
        arrayOfInt1[(arrayOfInt1.length - 3)] = 12610;
        arrayOfInt1[(arrayOfInt1.length - 2)] = 1;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt2 = new int[1];
      if (!EGL14.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt2, 0))
      {
        LogUtils.w(TAG, "unable to find RGB8888 / " + paramInt2 + " EGLConfig");
        return null;
      }
      return arrayOfEGLConfig[0];
    }
  }
  
  public static void logCurrent(String paramString)
  {
    EGLDisplay localEGLDisplay = EGL14.eglGetCurrentDisplay();
    EGLContext localEGLContext = EGL14.eglGetCurrentContext();
    EGLSurface localEGLSurface = EGL14.eglGetCurrentSurface(12377);
    LogUtils.i(TAG, "Current EGL (" + paramString + "): display=" + localEGLDisplay + ", context=" + localEGLContext + ", surface=" + localEGLSurface);
  }
  
  public EGLSurface createOffscreenSurface(int paramInt1, int paramInt2)
  {
    EGLSurface localEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    checkEglError("eglCreatePbufferSurface");
    if (localEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
    return localEGLSurface;
  }
  
  public EGLSurface createWindowSurface(Object paramObject)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture))) {
      throw new RuntimeException("invalid surface: " + paramObject);
    }
    paramObject = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, paramObject, new int[] { 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    if (paramObject == null) {
      throw new RuntimeException("surface was null");
    }
    return paramObject;
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
      {
        ReportUtil.report("WARNING: EglCore was not explicitly released -- state may be leaked, stackTrace: " + Log.getStackTraceString(this.throwableForStackTrace));
        release();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public EGLContext getEGLContext()
  {
    return this.mEGLContext;
  }
  
  public int getGlVersion()
  {
    return this.mGlVersion;
  }
  
  public boolean isCurrent(EGLSurface paramEGLSurface)
  {
    return (this.mEGLContext.equals(EGL14.eglGetCurrentContext())) && (paramEGLSurface.equals(EGL14.eglGetCurrentSurface(12377)));
  }
  
  public void makeCurrent(EGLSurface paramEGLSurface)
  {
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      LogUtils.d(TAG, "NOTE: makeCurrent w/o display");
    }
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface, paramEGLSurface, this.mEGLContext)) {
      LogUtils.e(TAG, "eglMakeCurrent failed");
    }
  }
  
  public void makeCurrent(EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2)
  {
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      LogUtils.d(TAG, "NOTE: makeCurrent w/o display");
    }
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface1, paramEGLSurface2, this.mEGLContext)) {
      throw new RuntimeException("eglMakeCurrent(draw,read) failed");
    }
  }
  
  public void makeNothingCurrent()
  {
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public String queryString(int paramInt)
  {
    return EGL14.eglQueryString(this.mEGLDisplay, paramInt);
  }
  
  public int querySurface(EGLSurface paramEGLSurface, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.mEGLDisplay, paramEGLSurface, paramInt, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public void release()
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
        return;
      }
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLConfig = null;
  }
  
  public void releaseSurface(EGLSurface paramEGLSurface)
  {
    EGL14.eglDestroySurface(this.mEGLDisplay, paramEGLSurface);
  }
  
  @TargetApi(18)
  public void setPresentationTime(EGLSurface paramEGLSurface, long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, paramEGLSurface, paramLong);
  }
  
  public boolean swapBuffers(EGLSurface paramEGLSurface)
  {
    return EGL14.eglSwapBuffers(this.mEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.gles.EglCore
 * JD-Core Version:    0.7.0.1
 */