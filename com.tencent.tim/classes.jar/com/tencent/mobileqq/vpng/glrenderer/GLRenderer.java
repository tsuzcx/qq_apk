package com.tencent.mobileqq.vpng.glrenderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.util.Iterator;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class GLRenderer
{
  private RenderThreadThread a;
  private LinkedList<Runnable> ap = new LinkedList();
  protected int edA;
  protected int edB;
  private final Object fA = new Object();
  private Runnable hU;
  private EGL10 mEgl;
  private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
  private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
  private EGLSurface mEglSurface = EGL10.EGL_NO_SURFACE;
  protected boolean mIsPause;
  protected SurfaceTexture mSurface;
  
  protected GLRenderer(int paramInt1, int paramInt2)
  {
    this.edA = paramInt1;
    this.edB = paramInt2;
  }
  
  private void egj()
  {
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
    }
    int[] arrayOfInt = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, arrayOfInt)) {
      throw new RuntimeException("EGL error " + this.mEgl.eglGetError());
    }
    arrayOfInt = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    EGL10 localEGL10 = this.mEgl;
    EGLDisplay localEGLDisplay = this.mEglDisplay;
    int i = arrayOfEGLConfig.length;
    if (!localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344 }, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new RuntimeException("EGL error " + this.mEgl.eglGetError());
    }
    arrayOfInt = arrayOfEGLConfig[0];
    this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    if (this.mEglContext == EGL10.EGL_NO_CONTEXT) {
      throw new RuntimeException("EGL error " + this.mEgl.eglGetError());
    }
    i = this.edA;
    int j = this.edB;
    if (this.mSurface != null) {}
    for (this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, arrayOfInt, this.mSurface, null);; this.mEglSurface = this.mEgl.eglCreatePbufferSurface(this.mEglDisplay, arrayOfInt, new int[] { 12375, i, 12374, j, 12344 }))
    {
      this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext);
      return;
    }
  }
  
  private void egk()
  {
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
    this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
    this.mEglContext = EGL10.EGL_NO_CONTEXT;
    this.mEglDisplay = EGL10.EGL_NO_DISPLAY;
  }
  
  private void render()
  {
    this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext);
    GLES20.glViewport(0, 0, this.edA, this.edB);
    onDrawFrame();
    this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
    egm();
  }
  
  protected void as(Runnable paramRunnable)
  {
    this.hU = paramRunnable;
  }
  
  public void bAH()
  {
    if ((this.a == null) || (!RenderThreadThread.a(this.a)))
    {
      this.a = new RenderThreadThread(null);
      this.a.start();
    }
  }
  
  public abstract void egl();
  
  public abstract void egm();
  
  public void f(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurface = paramSurfaceTexture;
    bAH();
  }
  
  public void kr(int paramInt1, int paramInt2)
  {
    this.edA = paramInt1;
    this.edB = paramInt2;
  }
  
  public abstract void onDestroy();
  
  public abstract void onDrawFrame();
  
  public void release()
  {
    stopRender();
  }
  
  public void stopRender()
  {
    if (this.a != null)
    {
      RenderThreadThread.a(this.a, false);
      this.a = null;
    }
  }
  
  class RenderThreadThread
    extends Thread
  {
    private boolean mIsRunning = true;
    
    private RenderThreadThread()
    {
      setName("GLRenderer-" + getId());
    }
    
    public void run()
    {
      GLRenderer.a(GLRenderer.this);
      GLRenderer.this.egl();
      while (this.mIsRunning)
      {
        long l;
        try
        {
          l = System.currentTimeMillis();
          synchronized (GLRenderer.a(GLRenderer.this))
          {
            Iterator localIterator = GLRenderer.a(GLRenderer.this).iterator();
            if (localIterator.hasNext()) {
              ((Runnable)localIterator.next()).run();
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        GLRenderer.a(GLRenderer.this).clear();
        if (!GLRenderer.this.mIsPause) {
          GLRenderer.b(GLRenderer.this);
        }
        sleep(Math.max(0L, 33L - (System.currentTimeMillis() - l)));
      }
      if (GLRenderer.a(GLRenderer.this) != null)
      {
        GLRenderer.a(GLRenderer.this).run();
        GLRenderer.a(GLRenderer.this, null);
      }
      GLRenderer.this.onDestroy();
      GLRenderer.c(GLRenderer.this);
      GLRenderer.a(GLRenderer.this).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.GLRenderer
 * JD-Core Version:    0.7.0.1
 */