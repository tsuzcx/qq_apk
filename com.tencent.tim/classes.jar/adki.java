import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class adki
{
  public static final float[] bZ = { -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final short[] e = { 0, 1, 2, 2, 3, 0 };
  private ShortBuffer a;
  public float[] bX;
  public short[] d;
  private FloatBuffer mVertexBuffer;
  
  public adki()
  {
    this.bX = bZ;
    this.d = e;
    api();
  }
  
  public adki(float[] paramArrayOfFloat, short[] paramArrayOfShort)
  {
    this.bX = paramArrayOfFloat;
    this.d = paramArrayOfShort;
    api();
  }
  
  private void api()
  {
    this.mVertexBuffer = ByteBuffer.allocateDirect(this.bX.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVertexBuffer.put(this.bX).position(0);
    this.a = ByteBuffer.allocateDirect(this.d.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
    this.a.put(this.d).position(0);
  }
  
  public void draw()
  {
    GLES20.glDrawElements(4, 6, 5123, this.a);
  }
  
  public void hy(int paramInt1, int paramInt2)
  {
    GLES20.glEnableVertexAttribArray(paramInt1);
    adkg.checkGlError("glEnableVertexAttribArray aPositionHandle");
    GLES20.glEnableVertexAttribArray(paramInt2);
    adkg.checkGlError("glEnableVertexAttribArray aTextureCoordHandle");
    this.mVertexBuffer.position(0);
    GLES20.glVertexAttribPointer(paramInt1, 3, 5126, false, 20, this.mVertexBuffer);
    this.mVertexBuffer.position(3);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 20, this.mVertexBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adki
 * JD-Core Version:    0.7.0.1
 */