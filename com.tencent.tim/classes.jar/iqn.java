import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.utils.AVGLUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class iqn
{
  private static int NOINITID = -1;
  private static iqn a;
  boolean TX = true;
  private int arW = NOINITID;
  private int arX = NOINITID;
  private int arY = NOINITID;
  private int frameBufferId = NOINITID;
  private int height;
  private FloatBuffer mVertexBuffer;
  private int width;
  
  public static iqn a()
  {
    if (a == null) {
      a = new iqn();
    }
    return a;
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
  
  private void apt()
  {
    if (this.arY == NOINITID)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.arY = arrayOfInt[0];
    }
    this.arX = e(this.width, this.height, this.arY);
  }
  
  private void apu()
  {
    if (this.arW == NOINITID)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.arW = arrayOfInt[0];
    }
    this.frameBufferId = initFrameBuffer(this.width, this.height, this.arW);
  }
  
  private int e(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.arX;
    if (this.arX == NOINITID)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
      GLES20.glBindFramebuffer(36160, 0);
      return i;
    }
  }
  
  private int initFrameBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.frameBufferId;
    if (this.frameBufferId == NOINITID)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
      GLES20.glBindFramebuffer(36160, 0);
      return i;
    }
  }
  
  public void a(ipm paramipm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.TX)
    {
      paramipm = iqg.a(0);
      GLES20.glUseProgram(paramipm.getId());
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.arY);
      GLES20.glUniform1i(paramipm.a()[4].handle, 0);
      GLES20.glUniform1f(paramipm.a()[2].handle, 1.0F);
    }
  }
  
  public void a(ipm paramipm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat, int paramInt8, int paramInt9)
  {
    if ((this.width != paramInt1 * 2) || (this.frameBufferId == NOINITID))
    {
      this.width = (paramInt1 * 2);
      this.height = (paramInt2 * 2);
      apu();
      apt();
      apc();
    }
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    GLES20.glViewport(0, 0, this.width, this.height);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    TextureProgram localTextureProgram = iqg.a(2);
    iqi[] arrayOfiqi = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.getId());
    GLES20.glUniform1f(localTextureProgram.a()[7].handle, paramInt1);
    GLES20.glUniform1f(localTextureProgram.a()[8].handle, paramInt2);
    GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].handle, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.a()[10].handle, paramInt8);
    GLES20.glUniform1i(localTextureProgram.a()[11].handle, paramInt9);
    ipn.enableBlending(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt5);
    GLES20.glUniform1i(arrayOfiqi[4].handle, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramInt6);
    GLES20.glUniform1i(arrayOfiqi[5].handle, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, paramInt7);
    GLES20.glUniform1i(arrayOfiqi[6].handle, 2);
    GLES20.glUniform1f(arrayOfiqi[2].handle, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfiqi[1].handle, 1, false, AVGLUtils.matrixV, 0);
    GLES20.glUniformMatrix4fv(arrayOfiqi[3].handle, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfiqi[0].handle, 2, 5126, false, 8, this.mVertexBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfiqi[0].handle);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOfiqi[0].handle);
    GLES20.glBindFramebuffer(36160, this.arX);
    GLES20.glViewport(0, 0, this.width, this.height);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    localTextureProgram = iqg.a(3);
    arrayOfiqi = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.getId());
    GLES20.glUniform1f(localTextureProgram.a()[7].handle, paramInt1);
    GLES20.glUniform1f(localTextureProgram.a()[8].handle, paramInt2);
    GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].handle, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.a()[10].handle, paramInt8);
    GLES20.glUniform1i(localTextureProgram.a()[11].handle, paramInt9);
    ipn.enableBlending(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.arW);
    GLES20.glUniform1i(arrayOfiqi[4].handle, 0);
    GLES20.glUniform1f(arrayOfiqi[2].handle, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfiqi[1].handle, 1, false, AVGLUtils.matrixV, 0);
    GLES20.glUniformMatrix4fv(arrayOfiqi[3].handle, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfiqi[0].handle, 2, 5126, false, 8, this.mVertexBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfiqi[0].handle);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOfiqi[0].handle);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    a(paramipm, paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
  
  public void release()
  {
    if (this.frameBufferId != NOINITID)
    {
      GLES20.glDeleteFramebuffers(2, new int[] { this.frameBufferId, this.arX }, 0);
      GLES20.glDeleteTextures(2, new int[] { this.arW, this.arY }, 0);
    }
    this.frameBufferId = NOINITID;
    this.arW = NOINITID;
    this.arX = NOINITID;
    this.arY = NOINITID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqn
 * JD-Core Version:    0.7.0.1
 */