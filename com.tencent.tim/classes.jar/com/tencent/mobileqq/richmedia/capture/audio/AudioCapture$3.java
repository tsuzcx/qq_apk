package com.tencent.mobileqq.richmedia.capture.audio;

import android.media.AudioRecord;
import com.tencent.qphone.base.util.QLog;

class AudioCapture$3
  implements Runnable
{
  AudioCapture$3(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    AudioCapture.a(this.this$0, false);
    if (AudioCapture.a(this.this$0) != null)
    {
      AudioCapture.a(this.this$0).isRecording = false;
      AudioCapture.a(this.this$0).czQ = true;
      AudioCapture.a(this.this$0).interrupt();
    }
    try
    {
      AudioCapture.a(this.this$0).join();
    }
    catch (InterruptedException localException1)
    {
      try
      {
        if (AudioCapture.a(this.this$0) != null) {
          AudioCapture.a(this.this$0).dKf();
        }
        this.this$0.a.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.this$0.a.release();
            this.this$0.a = null;
            return;
            localInterruptedException = localInterruptedException;
            localInterruptedException.printStackTrace();
            continue;
            localException1 = localException1;
            QLog.e("AudioCapture", 2, localException1, new Object[0]);
            if (AudioCapture.a(this.this$0) != null) {
              AudioCapture.a(this.this$0).Tx(-5);
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.e("AudioCapture", 2, localException2, new Object[0]);
            if (AudioCapture.a(this.this$0) != null) {
              AudioCapture.a(this.this$0).Tx(-5);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.3
 * JD-Core Version:    0.7.0.1
 */