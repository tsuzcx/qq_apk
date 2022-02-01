import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

public final class alzl
  implements alzp, SurfaceTexture.OnFrameAvailableListener
{
  private alzq jdField_a_of_type_Alzq;
  private amac jdField_a_of_type_Amac;
  private amad jdField_a_of_type_Amad;
  private boolean mFrameAvailable;
  private final Object mFrameSyncObject = new Object();
  private int mHeight;
  private float[] mSTMatrix = new float[16];
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  private TextureRender mTextureRender;
  private int mWidth;
  private int textureId;
  
  public alzl(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.jdField_a_of_type_Amac = new amac(paramEGLContext, 1);
    this.jdField_a_of_type_Amad = new amad(this.jdField_a_of_type_Amac);
    this.jdField_a_of_type_Amad.createOffscreenSurface(paramInt1, paramInt2);
    this.jdField_a_of_type_Amad.makeCurrent();
    this.mTextureRender = new TextureRender();
    this.textureId = alzr.createTexture(36197);
    this.mSurfaceTexture = new SurfaceTexture(this.textureId);
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mSurface = new Surface(this.mSurfaceTexture);
    this.jdField_a_of_type_Alzq = new alzq(this.mWidth, this.mHeight);
    Matrix.setIdentityM(this.mSTMatrix, 0);
  }
  
  public void a(@NonNull alzg paramalzg, boolean paramBoolean)
  {
    this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
    paramalzg.dq = ((float[])this.mSTMatrix.clone());
    this.jdField_a_of_type_Alzq.Ug(paramalzg.getTextureId());
    this.mTextureRender.drawTexture(36197, this.textureId, null, null);
    this.jdField_a_of_type_Alzq.unbind();
  }
  
  public void awaitNewImage()
  {
    synchronized (this.mFrameSyncObject)
    {
      for (;;)
      {
        boolean bool = this.mFrameAvailable;
        if (!bool) {
          try
          {
            this.mFrameSyncObject.wait();
            if (!this.mFrameAvailable) {
              throw new RuntimeException("frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
    }
    this.mFrameAvailable = false;
    alzr.checkGlError("before updateTexImage");
    this.mSurfaceTexture.updateTexImage();
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.mFrameSyncObject)
    {
      if (this.mFrameAvailable) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.mFrameAvailable = true;
    this.mFrameSyncObject.notifyAll();
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_Amac != null)
    {
      this.jdField_a_of_type_Amac.release();
      this.jdField_a_of_type_Amac = null;
    }
    if (this.jdField_a_of_type_Amad != null)
    {
      this.jdField_a_of_type_Amad.releaseEglSurface();
      this.jdField_a_of_type_Amad = null;
    }
    this.mSurface.release();
    this.mSurfaceTexture.release();
    this.jdField_a_of_type_Alzq.destroy();
    this.jdField_a_of_type_Alzq = null;
    this.mTextureRender = null;
    this.mSurface = null;
    this.mSurfaceTexture = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzl
 * JD-Core Version:    0.7.0.1
 */