import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import android.view.Surface;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class axfm
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private static final String TAG = axfm.class.getSimpleName();
  private float Eb;
  private float Ec;
  private axfl jdField_a_of_type_Axfl = new axfl();
  private SpaceFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = new SpaceFilter();
  private int eEL;
  private AtomicBoolean eM = new AtomicBoolean(false);
  private final GLSurfaceView jdField_f_of_type_AndroidOpenglGLSurfaceView;
  private BaseFilter jdField_f_of_type_ComTencentFilterBaseFilter = new SurfaceTextureFilter();
  private Frame m = new Frame();
  private MediaPlayer player;
  private SurfaceTexture surfaceTexture;
  private final float[] transformMatrix = new float[16];
  private Frame viewFrame = new Frame();
  
  public axfm(GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_f_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
  }
  
  private void b(Frame paramFrame)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.RenderProcess(paramFrame.getTextureId(), (int)this.Eb, (int)this.Ec, 0, 0.0D, this.viewFrame);
    GLES20.glDisable(3042);
  }
  
  private void eJj()
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    this.eEL = localObject[0];
    this.surfaceTexture = new SurfaceTexture(this.eEL);
    this.surfaceTexture.setOnFrameAvailableListener(this);
    localObject = new Surface(this.surfaceTexture);
    this.player.setSurface((Surface)localObject);
    this.player.prepareAsync();
  }
  
  private void eJk()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.eEL;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.surfaceTexture.release();
  }
  
  private void eJl()
  {
    this.jdField_f_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_f_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.apply();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_Axfl.initial();
  }
  
  public void clear()
  {
    this.jdField_f_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.ClearGLSL();
    this.m.clear();
    this.viewFrame.clear();
    eJk();
    this.jdField_a_of_type_Axfl.clear();
  }
  
  public void d(MediaPlayer paramMediaPlayer)
  {
    this.player = paramMediaPlayer;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.eM.compareAndSet(true, false))
    {
      this.surfaceTexture.updateTexImage();
      this.surfaceTexture.getTransformMatrix(this.transformMatrix);
      this.jdField_f_of_type_ComTencentFilterBaseFilter.updateMatrix(this.transformMatrix);
      this.jdField_f_of_type_ComTencentFilterBaseFilter.RenderProcess(this.eEL, (int)(2.0F * this.Eb), (int)this.Ec, -1, 0.0D, this.m);
    }
    if (GLES20.glIsTexture(this.m.getTextureId()))
    {
      b(this.jdField_a_of_type_Axfl.a(this.m, (int)this.Eb, (int)this.Ec));
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glClear(16384);
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.eM.set(true);
      this.jdField_f_of_type_AndroidOpenglGLSurfaceView.requestRender();
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Log.d(TAG, "onSurfaceChanged width = " + paramInt1 + "  height = " + paramInt2);
    this.Eb = paramInt1;
    this.Ec = paramInt2;
    this.jdField_a_of_type_Axfl.onSurfaceChanged(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.eM.set(false);
    eJj();
    eJl();
  }
  
  public void setFrameRenderCallback(axfl.a parama)
  {
    if (this.jdField_a_of_type_Axfl != null) {
      this.jdField_a_of_type_Axfl.setFrameRenderCallback(parama);
    }
  }
  
  public void setNeedComposeAlpha(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axfl != null) {
      this.jdField_a_of_type_Axfl.setNeedComposeAlpha(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfm
 * JD-Core Version:    0.7.0.1
 */