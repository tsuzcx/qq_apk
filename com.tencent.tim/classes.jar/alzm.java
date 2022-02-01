import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.FlowDecodeException;
import com.tencent.ttpic.openapi.filter.TextureRender;
import javax.microedition.khronos.egl.EGLContext;

public class alzm
  extends FlowDecodeScreenSurfaceBase
  implements alzp, SurfaceTexture.OnFrameAvailableListener
{
  private alzq a;
  private boolean mFrameAvailable;
  private final Object mFrameSyncObject = new Object();
  private float[] mSTMatrix = new float[16];
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private TextureRender mTextureRender;
  private int textureId;
  
  public alzm(EGLContext paramEGLContext, int paramInt1, int paramInt2)
    throws FlowDecodeScreenSurfaceBase.FlowDecodeException
  {
    super(paramEGLContext, paramInt1, paramInt2);
    start();
    this.mTextureRender = new TextureRender();
    this.textureId = alzr.createTexture(36197);
    this.mSurfaceTexture = new SurfaceTexture(this.textureId);
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.a = new alzq(paramInt1, paramInt2);
    Matrix.setIdentityM(this.mSTMatrix, 0);
  }
  
  public void a(@NonNull alzg paramalzg, boolean paramBoolean)
  {
    synchronized (this.mFrameSyncObject)
    {
      for (;;)
      {
        paramBoolean = this.mFrameAvailable;
        if (!paramBoolean) {
          try
          {
            this.mFrameSyncObject.wait();
            if (!this.mFrameAvailable) {
              throw new RuntimeException("frame wait timed out");
            }
          }
          catch (InterruptedException paramalzg)
          {
            throw new RuntimeException(paramalzg);
          }
        }
      }
    }
    alzr.checkGlError("before updateTexImage");
    this.mSurfaceTexture.updateTexImage();
    this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
    paramalzg.dq = ((float[])this.mSTMatrix.clone());
    this.a.Ug(paramalzg.getTextureId());
    this.mTextureRender.drawTexture(36197, this.textureId, null, null);
    this.a.unbind();
    this.mFrameAvailable = false;
  }
  
  public void awaitNewImage()
  {
    ram.d("FlowEdit_FlowDecodeScreenSurface", "awaitNewImage");
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    ram.d("FlowEdit_FlowDecodeScreenSurface", "onFrameAvailable");
    synchronized (this.mFrameSyncObject)
    {
      if (this.mFrameAvailable) {
        ram.w("FlowEdit_FlowDecodeScreenSurface", "mFrameAvailable already set, frame could be dropped");
      }
      this.mFrameAvailable = true;
      this.mFrameSyncObject.notifyAll();
      return;
    }
  }
  
  public void release()
  {
    super.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzm
 * JD-Core Version:    0.7.0.1
 */