package com.tencent.mobileqq.richmedia.capture.audio;

import allc;
import android.media.AudioRecord;
import com.tencent.qphone.base.util.QLog;

class AudioCapture$2
  implements Runnable
{
  AudioCapture$2(AudioCapture paramAudioCapture) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.a != null) {
        return;
      }
      AudioCapture.a(this.this$0);
      this.this$0.a = new AudioRecord(AudioCapture.a(this.this$0), AudioCapture.b(this.this$0), AudioCapture.c(this.this$0), AudioCapture.d(this.this$0), this.this$0.dyt);
      try
      {
        allc.a(this.this$0.a);
        this.this$0.Oi(true);
        if (AudioCapture.a(this.this$0) != null) {
          AudioCapture.a(this.this$0).dKe();
        }
        if (this.this$0.a.getState() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "openMic,audio state" + this.this$0.a.getState());
          }
          if (AudioCapture.a(this.this$0) != null)
          {
            AudioCapture.a(this.this$0).Tx(-4);
            return;
          }
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QLog.e("AudioCapture", 2, localIllegalStateException, new Object[0]);
      }
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        this.this$0.a.release();
        if (AudioCapture.a(this.this$0) != null)
        {
          AudioCapture.a(this.this$0).Tx(-4);
          return;
          localException1 = localException1;
          QLog.e("AudioCapture", 2, localException1, new Object[0]);
          if (AudioCapture.a(this.this$0) != null)
          {
            AudioCapture.a(this.this$0).Tx(-4);
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.2
 * JD-Core Version:    0.7.0.1
 */