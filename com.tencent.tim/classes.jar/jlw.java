import android.opengl.GLES20;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class jlw
{
  int aBq = -1;
  int aBr = -1;
  int aBs = 0;
  byte[] bh = null;
  byte[] bi = null;
  int[] cV = new int[1];
  int[] cW = new int[1];
  ByteBuffer j = null;
  QQAVImageFilter mFilter = null;
  int mHeight = 0;
  int mWidth = 0;
  
  public jlw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.bh = paramArrayOfByte;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.aBs = (paramInt1 * paramInt2 * 3);
    this.j = ByteBuffer.allocate(this.aBs);
    this.bi = new byte[this.mWidth * this.mHeight * 4];
    GLES20.glGenTextures(this.cV.length, this.cV, 0);
    GLES20.glGenTextures(this.cW.length, this.cW, 0);
    this.aBq = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.cV[0]);
    this.aBr = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.cW[0]);
    this.mFilter = new jlx();
    this.mFilter.init();
    this.mFilter.setQQAVEffectID("filter-test");
    if (QLog.isColorLevel()) {
      QLog.d("FilterProcess", 2, "mBeforeTextureId:" + this.cV[0] + "\nmBeforeTextureFbo:" + this.aBq + "\nmAfterTextureId:" + this.cW[0] + "\nmAfterTextureFbo:" + this.aBr);
    }
  }
  
  jlw.a a(QQAVImageFilter paramQQAVImageFilter, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramQQAVImageFilter != null)
    {
      paramQQAVImageFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
      paramQQAVImageFilter.onDraw2(paramInt2, paramInt3);
      return new jlw.a(paramInt3, paramInt4);
    }
    return new jlw.a(paramInt1, paramInt2);
  }
  
  void axO()
  {
    if ((this.j == null) || (this.bh == null)) {
      return;
    }
    this.j.position(0);
    this.j.put(this.bh, 0, this.aBs);
    this.j.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.cV[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6407, this.mWidth, this.mHeight, 0, 6407, 5121, this.j);
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, paramInt4, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public long bV()
  {
    if ((this.bh == null) || (this.bh.length == 0)) {
      return -1L;
    }
    if (this.mFilter == null) {
      return -2L;
    }
    if ((this.cV[0] == 0) || (this.cW[0] == 0)) {
      return -3L;
    }
    long l = System.nanoTime();
    int i = 0;
    while (i < 70)
    {
      axO();
      b(a(this.mFilter, this.aBq, this.cV[0], this.aBr, this.cW[0]).arB, this.mWidth, this.mHeight, 6408, this.bi);
      i += 1;
    }
    return (System.nanoTime() - l) / 1000L / 1000L;
  }
  
  public void destroy()
  {
    if (this.j != null)
    {
      this.j.clear();
      this.j = null;
    }
    this.bi = null;
    GLES20.glDeleteFramebuffers(2, new int[] { this.aBq, this.aBr }, 0);
    GLES20.glDeleteTextures(this.cV.length, this.cV, 0);
    GLES20.glDeleteTextures(this.cW.length, this.cW, 0);
    if (this.mFilter != null)
    {
      this.mFilter.destroy();
      this.mFilter = null;
    }
  }
  
  class a
  {
    int arB;
    int textureId;
    
    a(int paramInt1, int paramInt2)
    {
      this.arB = paramInt1;
      this.textureId = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlw
 * JD-Core Version:    0.7.0.1
 */