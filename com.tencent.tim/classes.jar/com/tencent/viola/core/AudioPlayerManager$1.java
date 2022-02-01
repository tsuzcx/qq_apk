package com.tencent.viola.core;

import android.media.MediaPlayer;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.viola.utils.ViolaLogUtils;

class AudioPlayerManager$1
  implements Runnable
{
  AudioPlayerManager$1(AudioPlayerManager paramAudioPlayerManager) {}
  
  public void run()
  {
    AudioPlayerManager.AudioManagerListener localAudioManagerListener = (AudioPlayerManager.AudioManagerListener)AudioPlayerManager.access$100(this.this$0).get(AudioPlayerManager.access$000(this.this$0));
    int i = ((Integer)AudioPlayerManager.access$200(this.this$0).get(AudioPlayerManager.access$000(this.this$0), Integer.valueOf(1000))).intValue();
    if ((localAudioManagerListener != null) && (AudioPlayerManager.access$300(this.this$0).isPlaying()))
    {
      localAudioManagerListener.playTimeChange(AudioPlayerManager.access$300(this.this$0).getCurrentPosition(), AudioPlayerManager.access$300(this.this$0).getDuration());
      AudioPlayerManager.access$400(this.this$0).postDelayed(this, i);
    }
    ViolaLogUtils.d("AudioPlayerManager", "timerChange,data:" + AudioPlayerManager.access$500(this.this$0) + ",currentDuration:" + AudioPlayerManager.access$300(this.this$0).getCurrentPosition() + ",totalDuration:" + AudioPlayerManager.access$300(this.this$0).getDuration() + ",isPlaying:" + AudioPlayerManager.access$300(this.this$0).isPlaying());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.AudioPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */