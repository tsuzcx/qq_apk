import android.opengl.GLES20;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class adjz
{
  int cHM = 0;
  FloatBuffer i;
  FloatBuffer mVertexBuffer;
  
  public adjz(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    d(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = (float)(paramFloat2 / (paramFloat4 * 3.141592653589793D) * 360.0D);
    float f2 = paramFloat1 * (paramFloat4 / 2.0F);
    float f3 = paramFloat1 * paramFloat3;
    int i2 = (int)(f1 / 1.0F);
    float f4 = f1 / 1.0F;
    this.cHM = (i2 * 3 * 4);
    Object localObject = new float[this.cHM * 4];
    float[] arrayOfFloat = new float[this.cHM * 4];
    QLog.i("AREngine_CylinderSide", 1, "initVertexData. w = " + paramFloat2 + ", h = " + f3 + ", d = " + paramFloat4 + ", angleLen = " + f1 + ", angdegSpan = " + 1.0F + ", ni = " + i2 + ", nf = " + f4);
    int i1 = 0;
    int n = 0;
    int m = 0;
    int k = 1;
    int j = 0;
    if ((Build.MODEL.equalsIgnoreCase("MI-ONE Plus")) || (Build.MODEL.equalsIgnoreCase("M040")))
    {
      k = 0;
      j = 1;
    }
    for (paramFloat1 = 0.0F; Math.ceil(paramFloat1) < f1; paramFloat1 += 1.0F)
    {
      double d3 = Math.toRadians(paramFloat1);
      double d2 = Math.toRadians(paramFloat1 + 1.0F);
      paramFloat3 = m + 1;
      paramFloat2 = paramFloat3;
      double d1 = d2;
      if (f1 - i2 * 1.0F > 0.01D)
      {
        paramFloat2 = paramFloat3;
        d1 = d2;
        if (m == i2)
        {
          d1 = Math.toRadians(f1 - i2 * 1.0F + paramFloat1);
          paramFloat2 = m + (f1 - i2 * 1.0F) / 1.0F;
          QLog.i("AREngine_CylinderSide", 1, "initVertexData. angrad = " + 180.0D * d3 / 3.141592653589793D + ", angradNext = " + 180.0D * d1 / 3.141592653589793D + ", k = " + m + ", kNext = " + paramFloat2);
        }
      }
      int i3 = i1 + 1;
      localObject[i1] = ((float)(f2 * Math.cos(d3)));
      i1 = i3 + 1;
      localObject[i3] = ((float)(f2 * Math.sin(d3)));
      i3 = i1 + 1;
      localObject[i1] = 0.0F;
      i1 = i3 + 1;
      localObject[i3] = 0.0F;
      i3 = n + 1;
      arrayOfFloat[n] = (m / f4);
      n = i3 + 1;
      arrayOfFloat[i3] = j;
      i3 = n + 1;
      arrayOfFloat[n] = 0.0F;
      n = i3 + 1;
      arrayOfFloat[i3] = 1.0F;
      i3 = i1 + 1;
      localObject[i1] = ((float)(f2 * Math.cos(d1)));
      i1 = i3 + 1;
      localObject[i3] = ((float)(f2 * Math.sin(d1)));
      i3 = i1 + 1;
      localObject[i1] = f3;
      i1 = i3 + 1;
      localObject[i3] = 0.0F;
      i3 = n + 1;
      arrayOfFloat[n] = (paramFloat2 / f4);
      n = i3 + 1;
      arrayOfFloat[i3] = k;
      i3 = n + 1;
      arrayOfFloat[n] = 0.0F;
      n = i3 + 1;
      arrayOfFloat[i3] = 1.0F;
      i3 = i1 + 1;
      localObject[i1] = ((float)(f2 * Math.cos(d3)));
      i1 = i3 + 1;
      localObject[i3] = ((float)(f2 * Math.sin(d3)));
      i3 = i1 + 1;
      localObject[i1] = f3;
      i1 = i3 + 1;
      localObject[i3] = 0.0F;
      i3 = n + 1;
      arrayOfFloat[n] = (m / f4);
      n = i3 + 1;
      arrayOfFloat[i3] = k;
      i3 = n + 1;
      arrayOfFloat[n] = 0.0F;
      n = i3 + 1;
      arrayOfFloat[i3] = 1.0F;
      i3 = i1 + 1;
      localObject[i1] = ((float)(f2 * Math.cos(d3)));
      i1 = i3 + 1;
      d2 = f2;
      localObject[i3] = ((float)(Math.sin(d3) * d2));
      i3 = i1 + 1;
      localObject[i1] = 0.0F;
      i1 = i3 + 1;
      localObject[i3] = 0.0F;
      i3 = n + 1;
      arrayOfFloat[n] = (m / f4);
      n = i3 + 1;
      arrayOfFloat[i3] = j;
      i3 = n + 1;
      arrayOfFloat[n] = 0.0F;
      n = i3 + 1;
      arrayOfFloat[i3] = 1.0F;
      i3 = i1 + 1;
      localObject[i1] = ((float)(f2 * Math.cos(d1)));
      i1 = i3 + 1;
      localObject[i3] = ((float)(f2 * Math.sin(d1)));
      i3 = i1 + 1;
      localObject[i1] = 0.0F;
      i1 = i3 + 1;
      localObject[i3] = 0.0F;
      i3 = n + 1;
      arrayOfFloat[n] = (paramFloat2 / f4);
      n = i3 + 1;
      arrayOfFloat[i3] = j;
      i3 = n + 1;
      arrayOfFloat[n] = 0.0F;
      n = i3 + 1;
      arrayOfFloat[i3] = 1.0F;
      i3 = i1 + 1;
      localObject[i1] = ((float)(f2 * Math.cos(d1)));
      i1 = i3 + 1;
      d2 = f2;
      localObject[i3] = ((float)(Math.sin(d1) * d2));
      i3 = i1 + 1;
      localObject[i1] = f3;
      i1 = i3 + 1;
      localObject[i3] = 0.0F;
      i3 = n + 1;
      arrayOfFloat[n] = (paramFloat2 / f4);
      n = i3 + 1;
      arrayOfFloat[i3] = k;
      i3 = n + 1;
      arrayOfFloat[n] = 0.0F;
      n = i3 + 1;
      arrayOfFloat[i3] = 1.0F;
      m += 1;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localObject.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put((float[])localObject);
    this.mVertexBuffer.position(0);
    localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.i = ((ByteBuffer)localObject).asFloatBuffer();
    this.i.put(arrayOfFloat);
    this.i.position(0);
  }
  
  public void hx(int paramInt1, int paramInt2)
  {
    GLES20.glVertexAttribPointer(paramInt1, 3, 5126, false, 16, this.mVertexBuffer);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 16, this.i);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glEnableVertexAttribArray(paramInt2);
    GLES20.glDrawArrays(4, 0, this.cHM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjz
 * JD-Core Version:    0.7.0.1
 */