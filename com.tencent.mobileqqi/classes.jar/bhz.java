import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class bhz
  implements GLSurfaceView.EGLConfigChooser
{
  private static int[] b;
  private static int g = 4;
  protected int a;
  protected int[] a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  
  static
  {
    jdField_b_of_type_ArrayOfInt = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, g, 12344 };
  }
  
  public bhz(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[1];
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.jdField_a_of_type_ArrayOfInt)) {
      paramInt2 = this.jdField_a_of_type_ArrayOfInt[0];
    }
    return paramInt2;
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    if (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
      if ((k < this.e) || (m < this.f)) {}
      int n;
      int i1;
      do
      {
        i += 1;
        break;
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
        n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
        i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
      } while ((k != this.jdField_a_of_type_Int) || (m != this.jdField_b_of_type_Int) || (n != this.c) || (i1 != this.d));
      return localEGLConfig;
    }
    return null;
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, jdField_b_of_type_ArrayOfInt, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0) {
      return null;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, jdField_b_of_type_ArrayOfInt, arrayOfEGLConfig, i, arrayOfInt);
    return a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhz
 * JD-Core Version:    0.7.0.1
 */