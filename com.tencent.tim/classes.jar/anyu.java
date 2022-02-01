import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class anyu
  extends anyt
  implements anxy<SpriteGLView>
{
  protected anyv a;
  protected anya b;
  protected ShortBuffer d;
  private final float[] dt = { 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F };
  protected final float[] du = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  protected FloatBuffer l;
  protected final short[] m = { 0, 1, 2, 3, 4, 5 };
  protected FloatBuffer mVertexBuffer;
  protected float[] modelMatrix = new float[16];
  
  public anyu()
  {
    this.jdField_b_of_type_Anya = new anya(0.0F, 0.0F);
    ckj();
  }
  
  public anyu(SpriteGLView paramSpriteGLView)
  {
    this.jdField_b_of_type_Anya = new anya(0.0F, 0.0F);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    ckj();
  }
  
  public anyu(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_b_of_type_Anya = new anya(0.0F, 0.0F);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.a = new anyv(paramSpriteGLView, paramBitmap);
    init();
    ckj();
  }
  
  public anyv a()
  {
    return this.a;
  }
  
  public void a(anyv paramanyv)
  {
    this.a = paramanyv;
    init();
  }
  
  public void a(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.a = new anyv(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, paramBitmap);
    init();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    super.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramArrayOfFloat);
    if (this.a == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) {
      GLES20.glUseProgram(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.program);
    }
    GLES20.glBindTexture(3553, getTextureId());
    GLES20.glEnableVertexAttribArray(paramInt3);
    GLES20.glVertexAttribPointer(paramInt3, 3, 5126, false, 0, this.mVertexBuffer);
    GLES20.glEnableVertexAttribArray(paramInt4);
    GLES20.glVertexAttribPointer(paramInt4, 2, 5126, false, 0, this.l);
    Matrix.setIdentityM(this.modelMatrix, 0);
    Matrix.translateM(this.modelMatrix, 0, 0.0F, 0.0F, -1.0E-004F);
    a(this.jdField_b_of_type_Anya);
    float f2 = paramInt1 / paramInt2;
    float f3 = paramInt1 / this.width / (this.scale * bv());
    float f4 = (2.0F * this.jdField_b_of_type_Anya.x * bv() - paramInt1) / paramInt2;
    if ((this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) && (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.cKJ)) {}
    for (float f1 = (-paramInt2 + 2.0F * this.jdField_b_of_type_Anya.y * bv()) / paramInt2;; f1 = (paramInt2 - 2.0F * this.jdField_b_of_type_Anya.y * bv()) / paramInt2)
    {
      Matrix.translateM(this.modelMatrix, 0, f4, f1, 0.0F);
      Matrix.rotateM(this.modelMatrix, 0, -this.rotate, 0.0F, 0.0F, 1.0F);
      Matrix.scaleM(this.modelMatrix, 0, f2 / f3, f2 / f3 * (this.height / this.width), 1.0F);
      float[] arrayOfFloat = new float[16];
      Matrix.multiplyMM(arrayOfFloat, 0, paramArrayOfFloat, 0, this.modelMatrix, 0);
      GLES20.glUniformMatrix4fv(paramInt5, 1, false, arrayOfFloat, 0);
      GLES20.glUniform1i(paramInt6, 0);
      GLES20.glUniform1f(paramInt7, this.opacity * Ky() / 255.0F / 255.0F);
      GLES20.glDrawElements(4, this.m.length, 5123, this.d);
      GLES20.glDisableVertexAttribArray(paramInt3);
      GLES20.glDisableVertexAttribArray(paramInt4);
      return;
    }
  }
  
  protected void ckj()
  {
    this.mVertexBuffer = ByteBuffer.allocateDirect(this.dt.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.dt);
    this.mVertexBuffer.position(0);
    this.d = ByteBuffer.allocateDirect(this.m.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(this.m);
    this.d.position(0);
    this.l = ByteBuffer.allocateDirect(this.du.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.du);
    this.l.position(0);
  }
  
  protected void dTS()
  {
    super.dTS();
    if (this.a != null) {
      this.a.isLoaded = false;
    }
  }
  
  public int getHeight()
  {
    if ((this.a == null) || (this.a.bitmap == null) || (this.a.bitmap.isRecycled())) {
      return (int)this.height;
    }
    return this.a.bitmap.getHeight();
  }
  
  public int getTextureId()
  {
    this.a.load();
    return this.a.textureId;
  }
  
  public int getWidth()
  {
    if ((this.a == null) || (this.a.bitmap == null) || (this.a.bitmap.isRecycled())) {
      return (int)this.width;
    }
    return this.a.bitmap.getWidth();
  }
  
  protected void init()
  {
    if ((this.a == null) || (this.a.bitmap == null)) {
      return;
    }
    this.width = this.a.bitmap.getWidth();
    this.height = this.a.bitmap.getHeight();
  }
  
  public void release()
  {
    if (this.a != null) {
      this.a.release();
    }
  }
  
  public void setPosition(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyu
 * JD-Core Version:    0.7.0.1
 */