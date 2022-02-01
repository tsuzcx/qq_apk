import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public class avww
  extends avwv
{
  public avww(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public int PK()
  {
    return 3;
  }
  
  protected void eCc()
  {
    this.rotateY = 90.0F;
  }
  
  protected void eCd()
  {
    Object localObject = awcp.a().eF();
    if ((localObject == null) || (((ArrayList)localObject).size() != 2)) {}
    do
    {
      return;
      float[] arrayOfFloat = (float[])((ArrayList)localObject).get(0);
      if (arrayOfFloat != null)
      {
        this.vertexSize = (arrayOfFloat.length / 3);
        this.vertexBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.vertexBuffer.put(arrayOfFloat);
        this.vertexBuffer.position(0);
      }
      localObject = (float[])((ArrayList)localObject).get(1);
    } while (localObject == null);
    this.textureBuffer = ByteBuffer.allocateDirect(localObject.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.textureBuffer.put((float[])localObject);
    this.textureBuffer.position(0);
  }
  
  public void eCe()
  {
    if (this.rotateX > 90.0F) {
      this.rotateX = 90.0F;
    }
    for (;;)
    {
      if (this.mScale != 0.0F)
      {
        float f = (float)(Math.toDegrees(Math.atan(this.mScale)) * 2.0D);
        if (Build.VERSION.SDK_INT >= 14) {
          Matrix.perspectiveM(this.dR, 0, f, this.mQ, 1.0F, 500.0F);
        }
        Matrix.translateM(this.dR, 0, 0.0F, 0.0F, -2.0F);
      }
      Matrix.rotateM(this.modelMatrix, 0, -this.rotateX, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.modelMatrix, 0, -this.rotateY, 0.0F, 1.0F, 0.0F);
      Matrix.rotateM(this.modelMatrix, 0, 0.0F, 0.0F, 0.0F, 1.0F);
      if (this.a != null) {
        this.a.a((int)this.Ds, -this.rotateX, -this.rotateY, this.mScale);
      }
      return;
      if (this.rotateX < -90.0F) {
        this.rotateX = -90.0F;
      }
    }
  }
  
  public void eCf()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.textureId);
    GLES20.glUniformMatrix4fv(this.eyX, 1, false, h(), 0);
    GLES20.glDrawArrays(4, 0, PL());
  }
  
  public int getTextureType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avww
 * JD-Core Version:    0.7.0.1
 */