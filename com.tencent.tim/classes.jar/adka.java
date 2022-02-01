import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class adka
{
  private int[] frameBuffer;
  private int[] ky;
  private int mHeight;
  private int mWidth;
  
  private void init(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("width & height should > 0!");
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    if (this.frameBuffer != null)
    {
      GLES20.glDeleteFramebuffers(1, this.frameBuffer, 0);
      this.frameBuffer = null;
    }
    if (this.ky != null)
    {
      GLES20.glDeleteTextures(1, this.ky, 0);
      this.ky = null;
    }
    this.frameBuffer = new int[1];
    this.ky = new int[1];
    GLES20.glGenFramebuffers(1, this.frameBuffer, 0);
    GLES20.glGenTextures(1, this.ky, 0);
    GLES20.glBindTexture(3553, this.ky[0]);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindFramebuffer(36160, this.frameBuffer[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.ky[0], 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void bind(int paramInt1, int paramInt2)
  {
    if ((this.frameBuffer == null) || (this.ky == null) || (paramInt1 != this.mWidth) || (paramInt2 != this.mHeight))
    {
      long l = System.currentTimeMillis();
      init(paramInt1, paramInt2);
      QLog.i("Keying_FrameBuffer", 2, " init need " + (System.currentTimeMillis() - l));
    }
    GLES20.glBindFramebuffer(36160, this.frameBuffer[0]);
  }
  
  public void destroy()
  {
    if (this.ky != null)
    {
      GLES20.glDeleteTextures(this.ky.length, this.ky, 0);
      this.ky = null;
    }
    if (this.frameBuffer != null)
    {
      GLES20.glDeleteFramebuffers(this.frameBuffer.length, this.frameBuffer, 0);
      this.frameBuffer = null;
    }
  }
  
  public int getFrameBufferTextureId()
  {
    int i = 0;
    if (this.ky != null) {
      i = this.ky[0];
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adka
 * JD-Core Version:    0.7.0.1
 */