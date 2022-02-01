import android.opengl.GLSurfaceView.EGLContextFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class alzh
  implements GLSurfaceView.EGLContextFactory
{
  private static int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private EGLContext mEGLContext;
  
  public EGLContext a()
  {
    ram.w("FlowEdit_EditorEGLContextFactory", "getEGLContext, %s", new Object[] { this.mEGLContext });
    return this.mEGLContext;
  }
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = EGL_CONTEXT_CLIENT_VERSION;
    this.mEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    ram.w("FlowEdit_EditorEGLContextFactory", "createContext %s", new Object[] { this.mEGLContext });
    return this.mEGLContext;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, this.mEGLContext)) {
      ram.e("FlowEdit_EditorEGLContextFactory", "EditorEGLContextDisplay, display: " + paramEGLDisplay + " context: " + paramEGLContext);
    }
    ram.w("FlowEdit_EditorEGLContextFactory", "destroyContext, %s", new Object[] { this.mEGLContext });
    this.mEGLContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzh
 * JD-Core Version:    0.7.0.1
 */