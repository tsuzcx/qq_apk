package com.tencent.mobileqq.activity.aio;

import android.hardware.SensorManager;

class AudioSenorManager$2
  implements Runnable
{
  AudioSenorManager$2(AudioSenorManager paramAudioSenorManager) {}
  
  public void run()
  {
    AudioSenorManager.a(this.this$0).unregisterListener(AudioSenorManager.a(this.this$0));
    AudioSenorManager.a(this.this$0).unregisterListener(AudioSenorManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioSenorManager.2
 * JD-Core Version:    0.7.0.1
 */