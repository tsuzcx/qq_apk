import android.content.Context;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.ttpic.openapi.initializer.Voice2TextInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class azaj
{
  private static String WX_VOICE_RECOGNIZER_APPID = "wx7d02f7e92ea2884d";
  private AudioCapture a;
  private boolean dCk;
  
  public void a(Context paramContext, AudioCapture paramAudioCapture)
  {
    this.dCk = true;
    this.dCk = true;
    FeatureManager.Features.VOICE_TO_TEXT.init();
    this.a = paramAudioCapture;
    VoiceTextRecognizer.setWxVoiceRecognizerAppid(WX_VOICE_RECOGNIZER_APPID);
    VoiceTextRecognizer.getInstance().init(paramContext, false);
    VoiceTextRecognizer.getInstance().setVRErrorListener(new azak(this));
    VoiceTextRecognizer.getInstance().start();
    paramAudioCapture.Oj(true);
    paramAudioCapture.dJY();
  }
  
  public void eUC()
  {
    if (this.dCk)
    {
      this.dCk = false;
      this.a.Oj(false);
      this.a.pause();
      VoiceTextRecognizer.getInstance().destroy();
    }
  }
  
  public void o(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((this.dCk) && (paramInt2 > 0))
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
      localByteArrayOutputStream = new ByteArrayOutputStream(Math.max((int)Math.ceil(paramInt2 * 16000 / this.a.getSampleRate()), 1));
    }
    try
    {
      new rqz(paramArrayOfByte, localByteArrayOutputStream, this.a.getSampleRate(), 16000, 2, 2, 1, paramInt2, 0.0D, 0, true);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(arrayOfByte, arrayOfByte.length);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramArrayOfByte.close();
          localByteArrayOutputStream.close();
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azaj
 * JD-Core Version:    0.7.0.1
 */