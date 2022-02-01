import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class ayyk
  extends ayyj
{
  private amak a;
  private amaq c;
  
  public void a(DecodeConfig paramDecodeConfig, amae paramamae, amal paramamal, ayyj.a parama)
  {
    try
    {
      this.c = new amaq(this, paramamae.outputFilePath, paramamal);
      paramamae.a = this.c;
      this.a = new amak(paramDecodeConfig, this.c);
      super.a(paramDecodeConfig, paramamae, paramamal, parama);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Mp4ReEncoderWithAudio", 1, "startEncode,", localException);
      }
    }
  }
  
  public boolean isFinished()
  {
    boolean bool2 = this.b.isFinished();
    if ((this.a == null) || (this.a.isFinished())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoderWithAudio", 2, new Object[] { "startEncode,", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool1) });
      }
      if ((!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void onDecodeFinish()
  {
    super.onDecodeFinish();
    try
    {
      if (this.a != null) {
        this.a.stopRecording();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    super.onFrameAvailable(paramSurfaceTexture);
    if (this.a != null) {
      this.a.avd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyk
 * JD-Core Version:    0.7.0.1
 */