import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
public class anlg
  implements SurfaceTexture.OnFrameAvailableListener
{
  anlh a;
  EGL10 mEGL;
  EGLContext mEGLContext;
  EGLDisplay mEGLDisplay;
  EGLSurface mEGLSurface;
  boolean mFrameAvailable;
  Object mFrameSyncObject = new Object();
  public Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  
  public anlg()
  {
    setup();
  }
  
  @SuppressLint({"NewApi"})
  public void awaitNewImage()
  {
    synchronized (this.mFrameSyncObject)
    {
      for (;;)
      {
        boolean bool = this.mFrameAvailable;
        if (!bool) {
          try
          {
            this.mFrameSyncObject.wait(5000L);
            if (!this.mFrameAvailable) {
              throw new RuntimeException("Surface frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    this.mFrameAvailable = false;
    this.a.checkGlError("before updateTexImage");
    this.mSurfaceTexture.updateTexImage();
  }
  
  public void drawImage()
  {
    this.a.drawFrame(this.mSurfaceTexture);
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.mFrameSyncObject)
    {
      if (this.mFrameAvailable) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.mFrameAvailable = true;
    this.mFrameSyncObject.notifyAll();
  }
  
  public void release()
  {
    if (this.mEGL != null)
    {
      if (this.mEGL.eglGetCurrentContext().equals(this.mEGLContext)) {
        this.mEGL.eglMakeCurrent(this.mEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      }
      this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
      this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    }
    this.mSurface.release();
    this.mEGLDisplay = null;
    this.mEGLContext = null;
    this.mEGLSurface = null;
    this.mEGL = null;
    this.a = null;
    this.mSurface = null;
    this.mSurfaceTexture = null;
  }
  
  void setup()
  {
    this.a = new anlh();
    this.a.surfaceCreated();
    this.mSurfaceTexture = new SurfaceTexture(this.a.getTextureId());
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mSurface = new Surface(this.mSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlg
 * JD-Core Version:    0.7.0.1
 */