import android.opengl.GLES20;

public class alzq
{
  private int dAR;
  private int frameBufferId;
  private int height;
  private int width;
  
  public alzq(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.frameBufferId = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    unbind();
  }
  
  public void Ug(int paramInt)
  {
    if (paramInt < 0)
    {
      ram.w("AvEditor.FrameBuffer", "invalid textureId " + paramInt);
      return;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = alzr.o(1)[0];
    }
    GLES20.glActiveTexture(33984);
    alzr.Uh(i);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
    GLES20.glViewport(0, 0, this.width, this.height);
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
    GLES20.glClear(16384);
    this.dAR = i;
  }
  
  public void destroy()
  {
    GLES20.glDeleteFramebuffers(1, new int[] { this.frameBufferId }, 0);
  }
  
  public void unbind()
  {
    GLES20.glBindFramebuffer(36160, 0);
    alzr.Uh(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzq
 * JD-Core Version:    0.7.0.1
 */