package com.tencent.mobileqq.activity.richmedia.subtitles;

import aath;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import java.lang.ref.WeakReference;

public class AudioTranslator$4
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) != null)
      {
        AudioCapture localAudioCapture = (AudioCapture)aath.a(this.this$0).get();
        if (localAudioCapture != null)
        {
          localAudioCapture.Oi(false);
          localAudioCapture.resume();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator.4
 * JD-Core Version:    0.7.0.1
 */