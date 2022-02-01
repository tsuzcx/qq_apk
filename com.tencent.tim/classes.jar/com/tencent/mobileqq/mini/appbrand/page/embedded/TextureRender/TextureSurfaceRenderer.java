package com.tencent.mobileqq.mini.appbrand.page.embedded.TextureRender;

import android.opengl.GLUtils;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class TextureSurfaceRenderer
  implements Runnable
{
  private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final String TAG = "miniapp-embedded";
  private EGL10 egl;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private int fpsIntervalTime = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_embeedded_video_fps_interval_time", 32);
  private int frames;
  protected int height;
  private long lastFpsOutput;
  protected Handler mHandler;
  private boolean pause;
  private boolean running;
  private Surface surface;
  protected int width;
  
  public TextureSurfaceRenderer(Surface paramSurface, int paramInt1, int paramInt2, Handler paramHandler)
  {
    this.surface = paramSurface;
    this.width = paramInt1;
    this.height = paramInt2;
    this.running = true;
    this.mHandler = paramHandler;
    new Thread(this).start();
  }
  
  private EGLConfig chooseEglConfig()
  {
    int[] arrayOfInt1 = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = getConfig();
    if (!this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt2, arrayOfEGLConfig, 1, arrayOfInt1)) {
      throw new IllegalArgumentException("Failed to choose config: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
    }
    if (arrayOfInt1[0] > 0) {
      return arrayOfEGLConfig[0];
    }
    return null;
  }
  
  private EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  private void deinitGL()
  {
    try
    {
      this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
      this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
      this.egl.eglTerminate(this.eglDisplay);
      QLog.d("miniapp-embedded", 1, "OpenGL deinit OK.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-embedded", 1, "deinitGL error, ", localThrowable);
    }
  }
  
  private int[] getConfig()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  private void initGL()
  {
    do
    {
      try
      {
        this.egl = ((EGL10)EGLContext.getEGL());
        this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        Object localObject = new int[2];
        this.egl.eglInitialize(this.eglDisplay, (int[])localObject);
        localObject = chooseEglConfig();
        this.eglContext = createContext(this.egl, this.eglDisplay, (EGLConfig)localObject);
        this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, (EGLConfig)localObject, this.surface, null);
        if ((this.eglSurface == null) || (this.eglSurface == EGL10.EGL_NO_SURFACE)) {
          throw new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-embedded", 1, "initGL error.", localThrowable);
        return;
      }
    } while (this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext));
    throw new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
  }
  
  private void pingFps()
  {
    if (this.lastFpsOutput == 0L) {
      this.lastFpsOutput = System.currentTimeMillis();
    }
    this.frames += 1;
    if (System.currentTimeMillis() - this.lastFpsOutput > 1000L)
    {
      this.lastFpsOutput = System.currentTimeMillis();
      this.frames = 0;
    }
  }
  
  protected abstract void deinitGLComponents();
  
  protected abstract boolean draw();
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    this.running = false;
  }
  
  protected abstract void initGLComponents();
  
  public void onPause()
  {
    this.running = false;
  }
  
  public void pauseRender()
  {
    this.pause = true;
  }
  
  public void resumeRender()
  {
    this.pause = false;
  }
  
  public void run()
  {
    try
    {
      initGL();
      initGLComponents();
      QLog.d("miniapp-embedded", 1, "OpenGL init OK.");
      while (this.running) {
        if (!this.pause)
        {
          long l1 = System.currentTimeMillis();
          pingFps();
          if (draw()) {
            this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
          }
          long l2 = this.fpsIntervalTime;
          long l3 = System.currentTimeMillis();
          l1 = l2 - (l3 - l1);
          if (l1 > 0L) {
            try
            {
              Thread.sleep(l1);
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
      }
      deinitGLComponents();
      deinitGL();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-embedded", 1, "TextureSurfaceRenderer run error,", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.TextureRender.TextureSurfaceRenderer
 * JD-Core Version:    0.7.0.1
 */