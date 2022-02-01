package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;
import android.util.Log;
import anii;
import com.tencent.qphone.base.util.QLog;

@TargetApi(17)
public class OffScreenInputSurface
{
  static final int[] nF = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 };
  static final int[] nG = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12339, 1, 12344 };
  private EGLContext c = EGL14.EGL_NO_CONTEXT;
  private EGLContext mEGLContext;
  private EGLDisplay mEGLDisplay;
  private EGLSurface mEGLSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public OffScreenInputSurface(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.c = paramEGLContext;
    buU();
  }
  
  public static int a(EGLContext paramEGLContext)
  {
    return 0;
  }
  
  static EGLContext b()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return EGL14.EGL_NO_CONTEXT;
    }
    return null;
  }
  
  public int JR()
  {
    return a(this.c);
  }
  
  public boolean a(EGLContext paramEGLContext)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramEGLContext.equals(this.c);
    }
    return paramEGLContext == this.c;
  }
  
  public boolean axV()
  {
    return EGL14.eglGetCurrentContext().equals(this.mEGLContext);
  }
  
  public boolean axW()
  {
    return this.c == b();
  }
  
  void buU()
  {
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    int[] arrayOfInt1 = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, arrayOfInt1, 0, arrayOfInt1, 1))
    {
      this.mEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    arrayOfInt1 = nF;
    boolean bool = anii.isFoundProductManufacturer(anii.KEY_BLACK_EGL_MAKECURRENT_ERR_3009);
    if (bool) {
      arrayOfInt1 = nG;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OffScreenInputSurface", 2, "OffScreenInputSurface[eglSetup] isBlack=" + bool);
    }
    if (!EGL14.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt2, 0)) {
      throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    }
    this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, arrayOfEGLConfig[0], this.c, new int[] { 12440, 2, 12344 }, 0);
    fX("eglCreateContext", 1);
    if (this.mEGLContext == null) {
      throw new EGLCreateContextException("null context");
    }
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, arrayOfEGLConfig[0], new int[] { 12375, i, 12374, j, 12376, 1, 12344 }, 0);
    fX("eglCreateWindowSurface", 2);
    if (this.mEGLSurface == null) {
      throw new EGLCreatePbufferSurfaceException("surface was null");
    }
  }
  
  void fX(String paramString, int paramInt)
  {
    int j = 0;
    int i = 12288;
    for (;;)
    {
      int k = EGL14.eglGetError();
      if (k == 12288) {
        break;
      }
      Log.e("OffScreenInputSurface", paramString + ": EGL error: 0x" + Integer.toHexString(k));
      i = k;
      j = 1;
    }
    if (j != 0)
    {
      if (paramInt == 1)
      {
        release();
        throw new EGLCreateContextException("EGL error encountered (see log)" + i);
      }
      if (paramInt == 2)
      {
        release();
        throw new EGLCreatePbufferSurfaceException("EGL error encountered (see log)" + i);
      }
      throw new RuntimeException("EGL error encountered (see log)" + i);
    }
  }
  
  public void makeCurrent()
  {
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext)) {
      throw new EGLMakeCurrentException("eglMakeCurrent failed " + EGL14.eglGetError());
    }
  }
  
  public void release()
  {
    if (EGL14.eglGetCurrentContext().equals(this.mEGLContext)) {
      EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
    }
    if ((this.mEGLSurface != null) && (this.mEGLSurface != EGL14.EGL_NO_SURFACE)) {
      EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
    }
    if ((this.mEGLContext != null) && (this.mEGLContext != EGL14.EGL_NO_CONTEXT)) {
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    }
    EGL14.eglReleaseThread();
    if (this.mEGLDisplay != null)
    {
      EGL14.eglTerminate(this.mEGLDisplay);
      this.mEGLDisplay = null;
    }
    this.mEGLDisplay = null;
    this.mEGLContext = null;
    this.mEGLSurface = null;
    this.c = EGL14.EGL_NO_CONTEXT;
  }
  
  public static class EGLCreateContextException
    extends RuntimeException
  {
    private static final long serialVersionUID = -7034897190745766936L;
    
    public EGLCreateContextException(String paramString)
    {
      super();
    }
  }
  
  public static class EGLCreatePbufferSurfaceException
    extends RuntimeException
  {
    private static final long serialVersionUID = -7034897190745766935L;
    
    public EGLCreatePbufferSurfaceException(String paramString)
    {
      super();
    }
  }
  
  public static class EGLMakeCurrentException
    extends RuntimeException
  {
    private static final long serialVersionUID = -7034897190745766937L;
    
    public EGLMakeCurrentException(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface
 * JD-Core Version:    0.7.0.1
 */