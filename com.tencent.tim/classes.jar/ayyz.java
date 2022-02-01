import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ayyz
{
  GaussianBlurFilter a;
  int awu;
  int awv;
  GaussianBlurFilterCompose b;
  int eNr;
  int eNs;
  int eNt;
  float[] ej;
  float[] ek;
  float[] el;
  RenderBuffer m;
  RenderBuffer mRenderBuffer;
  TextureRender mTextureRender;
  
  public ayyz(int paramInt)
  {
    this.eNr = paramInt;
    this.ek = b(this.eNr);
  }
  
  private void ab(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTextureRender = new TextureRender();
    this.b = new GaussianBlurFilterCompose();
    if (this.eNr % 180 != 0)
    {
      this.b.init(paramInt2, paramInt1);
      this.m = new RenderBuffer(paramInt2, paramInt1, 33984);
      this.ej = GPUBaseFilter.caculateCenterCropMvpMatrix(paramInt2, paramInt1, paramInt3, paramInt4);
    }
    for (this.el = GPUBaseFilter.caculateFitCenterMvpMatrix(paramInt2, paramInt1, paramInt3, paramInt4);; this.el = GPUBaseFilter.caculateFitCenterMvpMatrix(paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.a = this.b.getFilter();
      this.mRenderBuffer = new RenderBuffer(paramInt3, paramInt4, 33984);
      return;
      this.b.init(paramInt1, paramInt2);
      this.m = new RenderBuffer(paramInt1, paramInt2, 33984);
      this.ej = GPUBaseFilter.caculateCenterCropMvpMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  private float[] b(float paramFloat)
  {
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.rotateM(arrayOfFloat, 0, paramFloat, 0.0F, 0.0F, 1.0F);
    return arrayOfFloat;
  }
  
  public void ac(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.awu = paramInt1;
    this.awv = paramInt2;
    this.eNs = paramInt3;
    this.eNt = paramInt4;
    ab(this.awu, this.awv, this.eNs, this.eNt);
  }
  
  public int mh(int paramInt)
  {
    int i = paramInt;
    if (this.eNr != 0)
    {
      this.m.bind();
      this.mTextureRender.drawTexture(3553, paramInt, null, this.ek);
      this.m.unbind();
      i = this.m.getTexId();
    }
    if ((this.a != null) && (this.a.isInitSucc())) {
      this.b.drawTexture(i);
    }
    this.mRenderBuffer.bind();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if ((this.a != null) && (this.a.isInitSucc()))
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.75F);
      this.mTextureRender.drawTexture(3553, this.b.getTextureId(), null, this.ej);
      GLES20.glDisable(3042);
    }
    for (;;)
    {
      this.mTextureRender.drawTexture(3553, i, null, this.el);
      this.mRenderBuffer.unbind();
      return this.mRenderBuffer.getTexId();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.1F);
      this.mTextureRender.drawTexture(3553, i, null, this.ej);
      GLES20.glDisable(3042);
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if ((this.eNs != paramInt1) || (this.eNt != paramInt2))
    {
      this.eNs = paramInt1;
      this.eNt = paramInt2;
      ab(this.awu, this.awv, this.eNs, this.eNt);
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
    if (this.b != null) {
      this.b.destroy();
    }
    if (this.mTextureRender != null) {
      this.mTextureRender.release();
    }
    if (this.m != null) {
      this.m.destroy();
    }
    if (this.mRenderBuffer != null) {
      this.mRenderBuffer.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyz
 * JD-Core Version:    0.7.0.1
 */