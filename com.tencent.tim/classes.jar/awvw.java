import android.opengl.GLSurfaceView.EGLContextFactory;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class awvw
  implements GLSurfaceView.EGLContextFactory
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  public awvw(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.EGL_CONTEXT_CLIENT_VERSION;
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    axiy.e("AECameraGLSurfaceView", "[EGLContext] createContext finish");
    return paramEGL10;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (paramEGLDisplay == null) {
      axiy.e("AECameraGLSurfaceView", "EGLDisplay is null.");
    }
    AECameraGLSurfaceView.a(this.this$0);
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    axiy.e("AECameraGLSurfaceView", "[EGLContext] destroyContext finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvw
 * JD-Core Version:    0.7.0.1
 */