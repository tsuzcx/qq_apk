package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.qphone.base.util.QLog;

class AIOEmotionFragment$9
  implements Runnable
{
  AIOEmotionFragment$9(AIOEmotionFragment paramAIOEmotionFragment, String paramString1, String paramString2, int paramInt, AudioPlayerBase paramAudioPlayerBase) {}
  
  public void run()
  {
    if (this.bEL.equalsIgnoreCase(this.val$path))
    {
      float f = this.aIx / this.a.getDuration();
      if (f > 0.0F)
      {
        QLog.i("AIOEmotionFragment", 2, "AudioPlayer on onProgressChanged, playPosition = " + f);
        this.this$0.d.setProgress(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.9
 * JD-Core Version:    0.7.0.1
 */