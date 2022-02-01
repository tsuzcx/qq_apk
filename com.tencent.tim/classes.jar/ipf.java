import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import javax.microedition.khronos.egl.EGL10;

public class ipf
{
  private EGL10 mEGL10;
  private javax.microedition.khronos.egl.EGLContext mEGL10Context;
  private javax.microedition.khronos.egl.EGLDisplay mEGL10Display;
  private javax.microedition.khronos.egl.EGLSurface mEGL10Surface;
  private android.opengl.EGLContext mEGL14Context;
  private android.opengl.EGLDisplay mEGL14Display;
  private android.opengl.EGLSurface mEGL14Surface;
  
  private void createEGL10Context()
  {
    this.mEGL10 = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.mEGL10Display = this.mEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject = new int[2];
    this.mEGL10.eglInitialize(this.mEGL10Display, (int[])localObject);
    localObject = new javax.microedition.khronos.egl.EGLConfig[1];
    int[] arrayOfInt = new int[1];
    this.mEGL10.eglChooseConfig(this.mEGL10Display, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject, 1, arrayOfInt);
    if (arrayOfInt[0] == 0) {
      igd.aL("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject = localObject[0];
    this.mEGL10Surface = this.mEGL10.eglCreatePbufferSurface(this.mEGL10Display, (javax.microedition.khronos.egl.EGLConfig)localObject, new int[] { 12375, 64, 12374, 64, 12344 });
    this.mEGL10Context = this.mEGL10.eglCreateContext(this.mEGL10Display, (javax.microedition.khronos.egl.EGLConfig)localObject, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    this.mEGL10.eglMakeCurrent(this.mEGL10Display, this.mEGL10Surface, this.mEGL10Surface, this.mEGL10Context);
  }
  
  @SuppressLint({"NewApi"})
  private void createEGL14Context()
  {
    this.mEGL14Display = EGL14.eglGetDisplay(0);
    Object localObject = new int[2];
    EGL14.eglInitialize(this.mEGL14Display, (int[])localObject, 0, (int[])localObject, 1);
    localObject = new android.opengl.EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGL14.eglChooseConfig(this.mEGL14Display, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (android.opengl.EGLConfig[])localObject, 0, 1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0) {
      igd.aJ("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject = localObject[0];
    this.mEGL14Surface = EGL14.eglCreatePbufferSurface(this.mEGL14Display, (android.opengl.EGLConfig)localObject, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.mEGL14Context = EGL14.eglCreateContext(this.mEGL14Display, (android.opengl.EGLConfig)localObject, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    EGL14.eglMakeCurrent(this.mEGL14Display, this.mEGL14Surface, this.mEGL14Surface, this.mEGL14Context);
  }
  
  private void destroyEGL10Context()
  {
    if ((this.mEGL10 != null) && (this.mEGL10Display != null) && (this.mEGL10Surface != null) && (this.mEGL10Context != null))
    {
      this.mEGL10.eglMakeCurrent(this.mEGL10Display, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.mEGL10.eglDestroySurface(this.mEGL10Display, this.mEGL10Surface);
      this.mEGL10.eglDestroyContext(this.mEGL10Display, this.mEGL10Context);
      this.mEGL10.eglTerminate(this.mEGL10Display);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void destroyEGL14Context()
  {
    if ((this.mEGL14Display != null) && (this.mEGL14Surface != null) && (this.mEGL14Context != null))
    {
      EGL14.eglMakeCurrent(this.mEGL14Display, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.mEGL14Display, this.mEGL14Surface);
      EGL14.eglDestroyContext(this.mEGL14Display, this.mEGL14Context);
      EGL14.eglTerminate(this.mEGL14Display);
    }
  }
  
  void init()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      createEGL14Context();
      return;
    }
    createEGL10Context();
  }
  
  public void release()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      destroyEGL14Context();
      return;
    }
    destroyEGL10Context();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipf
 * JD-Core Version:    0.7.0.1
 */