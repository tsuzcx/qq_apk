import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

public class amap
{
  private Frame[] copyFrame = new Frame[3];
  private volatile int dBi;
  private volatile int dBj;
  private int height;
  private GPUBaseFilter mGPU2DFilter;
  private int[] mW = new int[3];
  private int width;
  
  public void bz(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.dBi += paramInt;
        return;
      }
      finally {}
      this.dBj += paramInt;
    }
  }
  
  public void destroy()
  {
    int i = 0;
    this.dBi = 0;
    this.dBj = 0;
    if (this.mGPU2DFilter != null) {
      this.mGPU2DFilter.destroy();
    }
    GLES20.glDeleteTextures(this.mW.length, this.mW, 0);
    while (i < 3)
    {
      if (this.copyFrame[i] != null) {
        this.copyFrame[i].clear();
      }
      i += 1;
    }
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    int i = 0;
    this.mGPU2DFilter = new GPUBaseFilter();
    this.mGPU2DFilter.init();
    GLES20.glGenTextures(this.mW.length, this.mW, 0);
    while (i < 3)
    {
      this.copyFrame[i] = new Frame();
      i += 1;
    }
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public boolean la(int paramInt)
  {
    if (Math.min(1, 3 - (this.dBi - this.dBj)) == 1)
    {
      int i = this.dBi % 3;
      this.copyFrame[i].bindFrame(this.mW[i], this.width, this.height, 1.0D);
      GlUtil.checkGlError("bindFrame");
      this.mGPU2DFilter.drawTexture(paramInt, null, null);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glFinish();
      bz(true, 1);
      return true;
    }
    return false;
  }
  
  public int readBuffer()
  {
    if (Math.min(1, this.dBi - this.dBj) == 1)
    {
      int i = this.dBj;
      return this.mW[(i % 3)];
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amap
 * JD-Core Version:    0.7.0.1
 */