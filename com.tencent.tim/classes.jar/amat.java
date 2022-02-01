import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class amat
  implements GLSurfaceView.Renderer
{
  private amac jdField_a_of_type_Amac;
  private amad jdField_a_of_type_Amad;
  private int dBm;
  private int dBn;
  private Bitmap mBitmap;
  private GPUBaseFilter mGPU2DFilter;
  
  public Bitmap a(Bitmap paramBitmap, GPUBaseFilter paramGPUBaseFilter)
  {
    this.mBitmap = paramBitmap;
    this.mGPU2DFilter = paramGPUBaseFilter;
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramBitmap.getWidth(), paramBitmap.getHeight());
    onDrawFrame(null);
    onDrawFrame(null);
    paramGPUBaseFilter = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
    GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramGPUBaseFilter);
    paramGPUBaseFilter = paramGPUBaseFilter.array();
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramGPUBaseFilter));
    return paramBitmap;
  }
  
  public void destory()
  {
    if (this.jdField_a_of_type_Amad != null)
    {
      this.jdField_a_of_type_Amad.releaseEglSurface();
      this.jdField_a_of_type_Amad = null;
    }
    if (this.jdField_a_of_type_Amac != null)
    {
      this.jdField_a_of_type_Amac.release();
      this.jdField_a_of_type_Amac = null;
    }
  }
  
  @TargetApi(17)
  public void init(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_Amac = new amac(EGL14.eglGetCurrentContext(), 1);
    }
    this.jdField_a_of_type_Amad = new amad(this.jdField_a_of_type_Amac);
    this.jdField_a_of_type_Amad.createOffscreenSurface(paramInt1, paramInt2);
    this.jdField_a_of_type_Amad.makeCurrent();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16640);
    if (this.mBitmap.getWidth() % 2 == 1)
    {
      paramGL10 = Bitmap.createBitmap(this.mBitmap.getWidth() + 1, this.mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramGL10);
      ((Canvas)localObject).drawARGB(0, 0, 0, 0);
      ((Canvas)localObject).drawBitmap(this.mBitmap, 0.0F, 0.0F, null);
      this.dBm = 1;
      if (paramGL10 != null) {
        break label144;
      }
    }
    label144:
    for (Object localObject = this.mBitmap;; localObject = paramGL10)
    {
      this.dBn = GlUtil.createTexture(3553, (Bitmap)localObject);
      if ((paramGL10 != null) && (!paramGL10.isRecycled())) {
        paramGL10.recycle();
      }
      paramGL10 = new float[16];
      Matrix.setIdentityM(paramGL10, 0);
      this.mGPU2DFilter.drawTexture(this.dBn, null, paramGL10);
      return;
      this.dBm = 0;
      paramGL10 = null;
      break;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glUseProgram(this.mGPU2DFilter.getProgram());
    this.mGPU2DFilter.onOutputSizeChanged(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amat
 * JD-Core Version:    0.7.0.1
 */