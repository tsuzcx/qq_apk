import android.opengl.GLSurfaceView.EGLContextFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class bia
  implements GLSurfaceView.EGLContextFactory
{
  private static int a = 12440;
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    try
    {
      int i = a;
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
      return paramEGL10;
    }
    catch (Exception paramEGL10) {}
    return null;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bia
 * JD-Core Version:    0.7.0.1
 */