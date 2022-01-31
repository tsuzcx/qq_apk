import com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import java.lang.ref.WeakReference;

public class xsg
  implements Runnable
{
  public xsg(AudioTranslator paramAudioTranslator) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      if (AudioTranslator.a(this.a) != null)
      {
        AudioCapture localAudioCapture = (AudioCapture)AudioTranslator.a(this.a).get();
        if (localAudioCapture != null)
        {
          localAudioCapture.a(false);
          localAudioCapture.c();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsg
 * JD-Core Version:    0.7.0.1
 */