import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.c;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class alzo
  implements GLSurfaceView.EGLContextFactory
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  alzo(alzn paramalzn) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt[1] = FlowDecodeScreenSurfaceBase.a(this.a.a);
    arrayOfInt[2] = 12344;
    ram.w("FlowEdit_FlowDecodeScreenSurfaceBase", "createContext, display=%s, config=%s, shaContext=%s", new Object[] { paramEGLDisplay, paramEGLConfig, FlowDecodeScreenSurfaceBase.a(this.a.a) });
    EGLContext localEGLContext = FlowDecodeScreenSurfaceBase.a(this.a.a);
    if (FlowDecodeScreenSurfaceBase.a(this.a.a) != 0) {}
    for (;;)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      arrayOfInt = null;
    }
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      ram.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      ram.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
      FlowDecodeScreenSurfaceBase.c.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzo
 * JD-Core Version:    0.7.0.1
 */