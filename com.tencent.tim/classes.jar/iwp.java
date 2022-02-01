import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class iwp
{
  private int auV = -1;
  private int[] cF = new int[3];
  private int[] cG = new int[1];
  private ByteBuffer e;
  private int mHeight;
  private FloatBuffer mVertexBuffer;
  private int mWidth;
  
  public iwp()
  {
    apc();
  }
  
  private void apc()
  {
    if (this.mVertexBuffer != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-0.5F + 0.0F);
    arrayOfFloat[1] = (-0.5F + 0.0F);
    arrayOfFloat[2] = (0.5F + 0.0F);
    arrayOfFloat[3] = (-0.5F + 0.0F);
    arrayOfFloat[4] = (-0.5F + 0.0F);
    arrayOfFloat[5] = (0.5F + 0.0F);
    arrayOfFloat[6] = (0.5F + 0.0F);
    arrayOfFloat[7] = (0.5F + 0.0F);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mVertexBuffer = localByteBuffer.asFloatBuffer();
    this.mVertexBuffer.put(arrayOfFloat);
    this.mVertexBuffer.position(0);
  }
  
  private void bS(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || ((this.mWidth == paramInt1) && (this.mHeight == paramInt2))) {
      return;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    if (this.e != null) {
      this.e.clear();
    }
    this.e = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
    if (this.auV != -1)
    {
      GLES20.glDeleteFramebuffers(0, new int[] { this.auV }, 0);
      this.auV = -1;
    }
    this.auV = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.cG[0]);
    apc();
  }
  
  private void c(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < this.mWidth * this.mHeight * 3 / 2) || (this.e == null) || (this.e.capacity() < this.mWidth * this.mHeight * 3 / 2)) {
      return;
    }
    this.e.position(0);
    this.e.put(paramArrayOfByte, 0, this.mWidth * this.mHeight);
    this.e.position(0);
    GLES20.glBindFramebuffer(36160, 0);
    ipn.enableBlending(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.cF[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, this.mWidth, this.mHeight, 0, 6409, 5121, this.e);
    this.e.position(0);
    this.e.put(paramArrayOfByte, this.mWidth * this.mHeight, this.mWidth * this.mHeight / 2);
    this.e.position(0);
    iqi[] arrayOfiqi;
    if (paramInt1 == 0)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.cF[1]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, this.mWidth / 2, this.mHeight / 2, 0, 6409, 5121, this.e);
      this.e.position(0);
      this.e.put(paramArrayOfByte, this.mWidth * this.mHeight + this.mWidth * this.mHeight / 4, this.mWidth * this.mHeight / 4);
      this.e.position(0);
      GLES20.glActiveTexture(33986);
      GLES20.glBindTexture(3553, this.cF[2]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, this.mWidth / 2, this.mHeight / 2, 0, 6409, 5121, this.e);
      GLES20.glBindFramebuffer(36160, this.auV);
      GLES20.glViewport(0, 0, this.mHeight, this.mWidth);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      paramArrayOfByte = iqg.a(1);
      arrayOfiqi = paramArrayOfByte.a();
      GLES20.glUseProgram(paramArrayOfByte.getId());
      GLES20.glUniform1f(arrayOfiqi[2].handle, 1.0F);
      GLES20.glUniform1f(arrayOfiqi[7].handle, this.mWidth);
      GLES20.glUniform1f(arrayOfiqi[8].handle, this.mHeight);
      GLES20.glUniformMatrix4fv(arrayOfiqi[9].handle, 1, false, YUVTexture.ab, 0);
      GLES20.glUniform1i(arrayOfiqi[10].handle, paramInt1);
      GLES20.glUniform1i(arrayOfiqi[11].handle, 0);
      GLES20.glDisable(3042);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.cF[0]);
      GLES20.glUniform1i(arrayOfiqi[4].handle, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.cF[1]);
      GLES20.glUniform1i(arrayOfiqi[5].handle, 1);
      if (paramInt1 == 0)
      {
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.cF[2]);
        GLES20.glUniform1i(arrayOfiqi[6].handle, 2);
      }
      if (paramInt2 % 4 != 1) {
        break label925;
      }
      GLES20.glUniformMatrix4fv(arrayOfiqi[1].handle, 1, false, AVGLUtils.matrixVRotate90, 0);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(arrayOfiqi[3].handle, 1, false, AVGLUtils.matrix, 0);
      GLES20.glVertexAttribPointer(arrayOfiqi[0].handle, 2, 5126, false, 8, this.mVertexBuffer);
      GLES20.glEnableVertexAttribArray(arrayOfiqi[0].handle);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(arrayOfiqi[0].handle);
      GLES20.glBindFramebuffer(36160, 0);
      return;
      if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3)) {
        break;
      }
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.cF[1]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6410, this.mWidth / 2, this.mHeight / 2, 0, 6410, 5121, this.e);
      break;
      label925:
      GLES20.glUniformMatrix4fv(arrayOfiqi[1].handle, 1, false, AVGLUtils.matrixVRotate270, 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchFaceYUVRender", 2, "WL_DEBUG onDrawFrame width = " + paramInt1 + ", height = " + paramInt2 + ", frameFormat = " + paramInt3 + ", data.length = " + paramArrayOfByte.length + ", inFrameAngle = " + paramInt4);
      }
      bS(paramInt1, paramInt2);
      c(paramInt3, paramArrayOfByte, paramInt4);
    }
  }
  
  public void akO()
  {
    GLES20.glGenTextures(this.cG.length, this.cG, 0);
    GLES20.glGenTextures(this.cF.length, this.cF, 0);
  }
  
  int lL()
  {
    return this.cG[0];
  }
  
  public void onPause()
  {
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.auV != -1)
    {
      GLES20.glDeleteFramebuffers(0, new int[] { this.auV }, 0);
      this.auV = -1;
    }
    this.mWidth = 0;
    this.mHeight = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwp
 * JD-Core Version:    0.7.0.1
 */