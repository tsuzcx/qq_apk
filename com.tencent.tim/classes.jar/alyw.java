import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder;
import com.tencent.ttpic.video.AEDecoder;

public class alyw
  implements alzd, SurfaceTexture.OnFrameAvailableListener, AEDecoder
{
  private final int DECODE = 2;
  private final int ERROR = 6;
  private final int FINISH = 5;
  private final int INIT = 1;
  private alza jdField_a_of_type_Alza;
  private SurfaceTextureFilter jdField_a_of_type_ComTencentFilterSurfaceTextureFilter;
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder = new HWVideoDecoder();
  private final int dAI = 3;
  private final int dAJ = 4;
  private int dAK;
  private int dAL;
  private Frame frame = new Frame();
  private int height = -1;
  private final Object lock = new Object();
  private float[] matrix = new float[16];
  private int status = 1;
  private int width = -1;
  
  public alyw(String paramString)
  {
    this.jdField_a_of_type_Alza = new alza(paramString, 0, false, false);
  }
  
  private void dLF()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.dAL = arrayOfInt[0];
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter = new SurfaceTextureFilter();
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.apply();
  }
  
  private void dLG()
  {
    GLES20.glDeleteTextures(1, new int[] { this.dAL }, 0);
    this.frame.clear();
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.clearGLSLSelf();
  }
  
  public void fp(long paramLong)
    throws InterruptedException
  {
    synchronized (this.lock)
    {
      if (this.status != 2) {
        this.lock.wait();
      }
    }
    this.status = 3;
    this.lock.notifyAll();
  }
  
  public int getNextFrameTexture()
  {
    int i = -1;
    try
    {
      synchronized (this.lock)
      {
        if ((this.status == 4) || (this.status == 5) || (this.status == 6)) {
          break label152;
        }
        this.lock.wait();
      }
      if (this.status != 4) {}
    }
    catch (InterruptedException localInterruptedException) {}
    label152:
    for (;;)
    {
      if ((this.width == -1) || (this.height == -1))
      {
        this.width = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.getWidth();
        this.height = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.getHeight();
      }
      this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.updateMatrix(this.matrix);
      this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.RenderProcess(this.dAL, this.width, this.height, this.dAK, 0.0D, this.frame);
      this.status = 2;
      this.lock.notifyAll();
      i = 0;
      return i;
    }
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    this.status = 6;
    this.lock.notifyAll();
  }
  
  public void onDecodeFinish()
  {
    this.status = 5;
    this.lock.notifyAll();
  }
  
  public void onDecodeRepeat() {}
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart() {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture.updateTexImage();
    paramSurfaceTexture.getTransformMatrix(this.matrix);
    this.status = 4;
    this.lock.notifyAll();
  }
  
  public void release()
  {
    dLG();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.stopDecode();
  }
  
  public void setTexture(int paramInt)
  {
    dLF();
    this.dAK = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a(this.jdField_a_of_type_Alza, this.dAL, this, this);
    this.status = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyw
 * JD-Core Version:    0.7.0.1
 */