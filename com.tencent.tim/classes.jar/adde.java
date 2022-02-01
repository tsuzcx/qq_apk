import android.opengl.GLSurfaceView;
import com.tencent.qphone.base.util.QLog;

public final class adde
{
  public static adcy a(adda paramadda, addc paramaddc, GLSurfaceView paramGLSurfaceView)
  {
    if (paramaddc == null) {
      return null;
    }
    switch (paramaddc.cCE)
    {
    default: 
      return null;
    case 0: 
      paramadda = new addl(paramadda, (addm)paramaddc);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_3D here " + paramaddc.toString());
      return paramadda;
    case 2: 
    case 3: 
      paramadda = new addt(paramadda, (addv)paramaddc);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_NORAML_2D_VIDEO here" + paramaddc.toString());
      return paramadda;
    case 4: 
      paramadda = new addw(paramadda, (addy)paramaddc);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_ONLINE_VIDEO here" + paramaddc.toString());
      return paramadda;
    case 5: 
      paramadda = new adds(paramadda, (addr)paramaddc);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_MULTI_ANIM here" + paramaddc.toString());
      return paramadda;
    case 100: 
      paramadda = new addp(paramadda, (addq)paramaddc, paramGLSurfaceView);
      QLog.d("ARRenderableConstructorFactoty", 1, "generate AR_BINHAI_3D here" + paramaddc.toString());
      return paramadda;
    }
    return new addg(paramadda, (addi)paramaddc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adde
 * JD-Core Version:    0.7.0.1
 */