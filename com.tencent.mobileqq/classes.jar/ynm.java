import android.util.Log;
import com.tencent.mobileqq.apollo.GLTextureView;
import com.tencent.mobileqq.apollo.GLTextureView.EGLContextFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class ynm
  implements GLTextureView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  private ynm(GLTextureView paramGLTextureView) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    arrayOfInt[1] = GLTextureView.access$200(this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (GLTextureView.access$200(this.jdField_a_of_type_ComTencentMobileqqApolloGLTextureView) != 0) {}
    for (;;)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      arrayOfInt = null;
    }
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      yno.a("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ynm
 * JD-Core Version:    0.7.0.1
 */