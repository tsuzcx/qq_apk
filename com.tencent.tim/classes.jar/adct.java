import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class adct
{
  private amad jdField_a_of_type_Amad;
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.mEgl.eglGetCurrentSurface(12377);
  private EGL10 mEgl = (EGL10)EGLContext.getEGL();
  private EGLContext mEglContext = this.mEgl.eglGetCurrentContext();
  private EGLDisplay mEglDisplay = this.mEgl.eglGetCurrentDisplay();
  
  public adct(amac paramamac, Surface paramSurface)
  {
    this.jdField_a_of_type_Amad = new amad(paramamac);
    this.jdField_a_of_type_Amad.createWindowSurface(paramSurface);
  }
  
  public void cQm()
  {
    this.mEgl.eglMakeCurrent(this.mEglDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.mEglContext);
  }
  
  public void cQn()
  {
    this.jdField_a_of_type_Amad.makeCurrent();
  }
  
  public void cQo()
  {
    this.jdField_a_of_type_Amad.swapBuffers();
  }
  
  public void cQp()
  {
    if (this.jdField_a_of_type_Amad != null)
    {
      this.jdField_a_of_type_Amad.releaseEglSurface();
      this.jdField_a_of_type_Amad = null;
    }
  }
  
  public void iC(long paramLong)
  {
    this.jdField_a_of_type_Amad.setPresentationTime(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adct
 * JD-Core Version:    0.7.0.1
 */