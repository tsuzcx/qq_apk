import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.view.RendererUtils;

public class awwj
  extends awwi
{
  private RenderBuffer e;
  private RenderBuffer j;
  private TextureRender textureRender;
  
  private void aX(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.e == null) {
        this.e = new RenderBuffer(this.previewWidth, this.previewHeight, 33984);
      }
      this.e.bind();
      Object localObject = new float[16];
      Matrix.setIdentityM((float[])localObject, 0);
      Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
      this.textureRender.drawTexture(3553, paramInt1, null, (float[])localObject);
      this.e.unbind();
      localObject = RendererUtils.saveTexture(this.e.getTexId(), paramInt2, paramInt3);
      if (this.a != null) {
        this.a.ao((Bitmap)localObject);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.a == null) {}
      this.a.onCaptureError(103);
    }
  }
  
  public void XP(boolean paramBoolean) {}
  
  public int[] b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.cameraWidth == 0) || (this.cameraHeight == 0)) {
      return this.textures;
    }
    paramBoolean = this.cAv;
    if (this.j == null) {
      this.j = new RenderBuffer(this.cameraWidth, this.cameraHeight, 33984);
    }
    this.j.bind();
    int i = this.previewWidth;
    int k = (int)(this.previewWidth / this.mViewAspectRatio);
    float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.cameraWidth, this.cameraHeight, i, k);
    this.textureRender.drawTexture(36197, this.eDv, this.mTransformMatrix, arrayOfFloat);
    this.j.unbind();
    int m = this.j.getTexId();
    br(m, paramInt1, paramInt2);
    if (paramBoolean)
    {
      aX(m, i, k);
      this.cAv = false;
    }
    this.textures[0] = m;
    this.textures[1] = m;
    return this.textures;
  }
  
  public void br(float paramFloat) {}
  
  protected void br(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    this.textureRender.drawTexture(3553, paramInt1, null, null);
    GLES20.glDisable(3042);
  }
  
  public void eGP()
  {
    this.textureRender = new TextureRender();
  }
  
  public void eGU()
  {
    if (this.textureRender != null) {
      this.textureRender.release();
    }
    if (this.j != null) {
      this.j.destroy();
    }
    if (this.e != null) {
      this.e.destroy();
    }
    if (this.h != null) {
      this.h.setOnFrameAvailableListener(null);
    }
  }
  
  public void eGW() {}
  
  public void g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super.g(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwj
 * JD-Core Version:    0.7.0.1
 */