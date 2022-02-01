package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import alzn;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import ram;

public class FlowDecodeScreenSurfaceBase
{
  private FlowDecodeScreenSurfaceBase.c.a jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$c$a = new alzn(this);
  private c jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$c;
  private EGLContext b;
  private int mEGLContextClientVersion = 2;
  protected int mHeight;
  protected int mWidth;
  
  protected FlowDecodeScreenSurfaceBase(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    if (paramEGLContext == null) {
      throw new IllegalArgumentException("eglContext should not be null");
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("both width and height should not be less than 0");
    }
    this.b = paramEGLContext;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void release()
  {
    ram.d("FlowEdit_FlowDecodeScreenSurfaceBase", "release: ");
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$c.dLL();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$c.finish();
  }
  
  public void start()
    throws FlowDecodeScreenSurfaceBase.FlowDecodeException
  {
    ram.d("FlowEdit_FlowDecodeScreenSurfaceBase", "start: ");
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$c = new c(new WeakReference(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$c$a));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$c.start();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase$c.bh(this.mWidth, this.mHeight);
  }
  
  public static class FlowDecodeException
    extends Exception
  {
    public FlowDecodeException() {}
    
    public FlowDecodeException(String paramString)
    {
      super();
    }
    
    public FlowDecodeException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  abstract class a
    implements GLSurfaceView.EGLConfigChooser
  {
    protected int[] mConfigSpec = filterConfigSpec(paramArrayOfInt);
    
    public a(int[] paramArrayOfInt) {}
    
    private int[] filterConfigSpec(int[] paramArrayOfInt)
    {
      if ((FlowDecodeScreenSurfaceBase.a(FlowDecodeScreenSurfaceBase.this) != 2) && (FlowDecodeScreenSurfaceBase.a(FlowDecodeScreenSurfaceBase.this) != 3)) {
        return paramArrayOfInt;
      }
      int i = paramArrayOfInt.length;
      int[] arrayOfInt = new int[i + 2];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
      arrayOfInt[(i - 1)] = 12352;
      if (FlowDecodeScreenSurfaceBase.a(FlowDecodeScreenSurfaceBase.this) == 2) {
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
    extends FlowDecodeScreenSurfaceBase.a
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
  
  public static class c
  {
    EGL10 mEgl;
    EGLConfig mEglConfig;
    EGLContext mEglContext;
    EGLDisplay mEglDisplay;
    EGLSurface mEglSurface;
    private WeakReference<a> mGLSurfaceViewWeakRef;
    
    public c(WeakReference<a> paramWeakReference)
    {
      this.mGLSurfaceViewWeakRef = paramWeakReference;
    }
    
    public static String formatEglError(String paramString, int paramInt)
    {
      return paramString + " failed: " + paramInt;
    }
    
    public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
    {
      ram.w(paramString1, formatEglError(paramString2, paramInt));
    }
    
    private void throwEglException(String paramString)
    {
      throwEglException(paramString, this.mEgl.eglGetError());
    }
    
    public static void throwEglException(String paramString, int paramInt)
    {
      paramString = formatEglError(paramString, paramInt);
      ram.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString);
      throw new RuntimeException(paramString);
    }
    
    public boolean bh(int paramInt1, int paramInt2)
    {
      this.mEglSurface = this.mEgl.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
      if ((this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE))
      {
        if (this.mEgl.eglGetError() == 12299) {
          ram.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
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
    
    public void dLL()
    {
      if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
      {
        this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
        this.mEglSurface = null;
      }
    }
    
    public void finish()
    {
      ram.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
      if (this.mEglContext != null)
      {
        a locala = (a)this.mGLSurfaceViewWeakRef.get();
        if (locala != null) {
          locala.a().destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
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
      throws FlowDecodeScreenSurfaceBase.FlowDecodeException
    {
      ram.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
      this.mEgl = ((EGL10)EGLContext.getEGL());
      this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
        throw new RuntimeException("eglGetDisplay failed");
      }
      Object localObject = new int[2];
      if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject)) {
        throw new RuntimeException("eglInitialize failed");
      }
      localObject = (a)this.mGLSurfaceViewWeakRef.get();
      if (localObject == null)
      {
        this.mEglConfig = null;
        this.mEglContext = null;
      }
      for (;;)
      {
        if ((this.mEglContext != null) && (this.mEglContext != EGL10.EGL_NO_CONTEXT)) {
          break label289;
        }
        this.mEglContext = null;
        if (this.mEgl.eglGetError() == 12294)
        {
          throw new FlowDecodeScreenSurfaceBase.FlowDecodeException(formatEglError("createContext", 12294));
          this.mEglConfig = ((a)localObject).a().chooseConfig(this.mEgl, this.mEglDisplay);
          ram.b("FlowEdit_FlowDecodeScreenSurfaceBase", "chooseConfig %s", this.mEglConfig);
          try
          {
            this.mEglContext = ((a)localObject).a().createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
            ram.b("FlowEdit_FlowDecodeScreenSurfaceBase", "createContext %s", this.mEglContext);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            ram.d("FlowEdit_FlowDecodeScreenSurfaceBase", localIllegalArgumentException, "createContext", new Object[0]);
            throw new FlowDecodeScreenSurfaceBase.FlowDecodeException("createContext failed", localIllegalArgumentException);
          }
        }
      }
      throwEglException("createContext");
      label289:
      ram.w("EglHelper", "createContext " + this.mEglContext + " tid=" + Thread.currentThread().getId());
      this.mEglSurface = null;
    }
    
    public static abstract interface a
    {
      public abstract GLSurfaceView.EGLConfigChooser a();
      
      public abstract GLSurfaceView.EGLContextFactory a();
    }
  }
  
  public class d
    extends FlowDecodeScreenSurfaceBase.b
  {
    public d(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase
 * JD-Core Version:    0.7.0.1
 */