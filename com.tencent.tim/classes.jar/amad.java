import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.tencent.qphone.base.util.QLog;

@TargetApi(17)
public class amad
{
  protected amac a;
  private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
  
  public amad(amac paramamac)
  {
    this.a = paramamac;
  }
  
  public void createOffscreenSurface(int paramInt1, int paramInt2)
  {
    if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.mEGLSurface = this.a.createOffscreenSurface(paramInt1, paramInt2);
  }
  
  public void createWindowSurface(Object paramObject)
  {
    if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.mEGLSurface = this.a.createWindowSurface(paramObject);
  }
  
  public void makeCurrent()
  {
    this.a.makeCurrent(this.mEGLSurface);
  }
  
  public void releaseEglSurface()
  {
    this.a.releaseSurface(this.mEGLSurface);
    this.mEGLSurface = EGL14.EGL_NO_SURFACE;
  }
  
  public void setPresentationTime(long paramLong)
  {
    this.a.setPresentationTime(this.mEGLSurface, paramLong);
  }
  
  public boolean swapBuffers()
  {
    boolean bool = this.a.swapBuffers(this.mEGLSurface);
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d("EglSurfaceBase", 2, "WARNING: swapBuffers() failed");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amad
 * JD-Core Version:    0.7.0.1
 */