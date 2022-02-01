import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class avwu
  extends avwv
{
  public static float Dr;
  private float Dq = 55.207924F;
  
  public avwu(boolean paramBoolean)
  {
    super(paramBoolean);
    if (paramBoolean) {
      this.eyZ = 36;
    }
    this.rotateY = Dr;
  }
  
  public int PK()
  {
    return 3;
  }
  
  protected void eCc()
  {
    if ((this.imageWidth != 0) && (this.imageHeight != 0)) {}
    for (this.Ds = (360 - (6 - (int)(this.imageWidth / this.imageHeight + 0.1F)) * 40);; this.Ds = 360.0F)
    {
      if (this.Ds > 360.0F) {
        this.Ds = 360.0F;
      }
      Dr = this.Ds / 2.0F;
      this.rotateY = Dr;
      return;
    }
  }
  
  protected void eCd()
  {
    this.mScale = 0.5228754F;
    ArrayList localArrayList = awcp.a().a(this.Ds, false);
    if (this.dpj) {}
    for (Object localObject = awcp.a().a(this.Ds, true);; localObject = null)
    {
      if ((localArrayList == null) || (localArrayList.size() != 2)) {}
      float[] arrayOfFloat1;
      do
      {
        return;
        float[] arrayOfFloat2 = (float[])localArrayList.get(0);
        int i = arrayOfFloat2.length;
        arrayOfFloat1 = arrayOfFloat2;
        if (localObject != null)
        {
          float[] arrayOfFloat3 = (float[])((ArrayList)localObject).get(0);
          arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat3.length + i);
          System.arraycopy(arrayOfFloat3, 0, arrayOfFloat1, i, arrayOfFloat3.length);
        }
        if (arrayOfFloat1 != null)
        {
          this.vertexSize = (i / 3);
          this.vertexBuffer = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          this.vertexBuffer.put(arrayOfFloat1);
          this.vertexBuffer.position(0);
        }
        arrayOfFloat2 = (float[])localArrayList.get(1);
        i = arrayOfFloat2.length;
        arrayOfFloat1 = arrayOfFloat2;
        if (localObject != null)
        {
          localObject = (float[])((ArrayList)localObject).get(1);
          arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, localObject.length + i);
          System.arraycopy(localObject, 0, arrayOfFloat1, i, localObject.length);
        }
      } while (arrayOfFloat1 == null);
      this.textureBuffer = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.textureBuffer.put(arrayOfFloat1);
      this.textureBuffer.position(0);
      return;
    }
  }
  
  public void eCe()
  {
    if (this.mScale != 0.0F)
    {
      if (this.mScale > 0.5228754F) {
        this.mScale = 0.5228754F;
      }
      float f = (float)(Math.toDegrees(Math.atan(this.mScale)) * 2.0D);
      this.Dq = ((int)((55.207924F - f) * 0.5D));
      if (Build.VERSION.SDK_INT >= 14) {
        Matrix.perspectiveM(this.dR, 0, f, this.mQ, 1.0F, 500.0F);
      }
      Matrix.translateM(this.dR, 0, 0.0F, 0.0F, -2.0F);
    }
    int i;
    if (this.rotateX > this.Dq)
    {
      this.rotateX = this.Dq;
      if (Dr == 180.0F) {
        break label337;
      }
      if (this.showType != 1) {
        break label312;
      }
      i = 44;
      label133:
      if (this.rotateY <= this.Ds - i) {
        break label318;
      }
      this.rotateY = (this.Ds - i);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Avwp != null)
      {
        this.jdField_a_of_type_Avwp.bo(this.mScale);
        this.jdField_a_of_type_Avwp.r(this.rotateX, this.rotateY);
      }
      Matrix.rotateM(this.modelMatrix, 0, -this.rotateX, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.modelMatrix, 0, -this.rotateY, 0.0F, 1.0F, 0.0F);
      Matrix.rotateM(this.modelMatrix, 0, 0.0F, 0.0F, 0.0F, 1.0F);
      if ((this.jdField_a_of_type_Avwv$a != null) && (this.mScale != 1.0F)) {
        this.jdField_a_of_type_Avwv$a.a((int)this.Ds - i, -this.rotateX, -this.rotateY, this.mScale);
      }
      return;
      if (this.rotateX >= -this.Dq) {
        break;
      }
      this.rotateX = (-this.Dq);
      break;
      label312:
      i = 17;
      break label133;
      label318:
      if (this.rotateY < i) {
        this.rotateY = i;
      }
      continue;
      label337:
      i = 0;
    }
  }
  
  public void eCf()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.textureId);
    GLES20.glUniformMatrix4fv(this.eyX, 1, false, h(), 0);
    GLES20.glDrawArrays(4, 0, PL());
    if (this.b != null)
    {
      int i = 0;
      while (i < this.b.size())
      {
        avwz localavwz = (avwz)this.b.valueAt(i);
        int j = localavwz.PN();
        if (j > 0)
        {
          GLES20.glBindTexture(3553, j);
          j = PL();
          GLES20.glDrawArrays(4, ((int)(this.Ds / 10.0F) - 1 - localavwz.PO()) * 6 + j, 6);
        }
        i += 1;
      }
    }
  }
  
  public int getTextureType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwu
 * JD-Core Version:    0.7.0.1
 */