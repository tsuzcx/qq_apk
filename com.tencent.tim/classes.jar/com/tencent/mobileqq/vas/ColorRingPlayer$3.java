package com.tencent.mobileqq.vas;

import android.media.MediaPlayer;
import android.os.Handler;
import aqpt;

public class ColorRingPlayer$3
  implements Runnable
{
  public ColorRingPlayer$3(aqpt paramaqpt) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject1 = this.this$0.lock;
      boolean bool = false;
      try
      {
        if (this.this$0.mediaPlayer != null) {
          bool = this.this$0.mediaPlayer.isPlaying();
        }
        if ((this.this$0.mediaPlayer == null) || (!bool)) {
          break;
        }
        int i = this.this$0.mediaPlayer.getDuration();
        int j = this.this$0.mediaPlayer.getCurrentPosition();
        this.this$0.handler.post(new ColorRingPlayer.3.1(this, j, i));
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          this.this$0.mediaPlayer = null;
          this.this$0.mediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingPlayer.3
 * JD-Core Version:    0.7.0.1
 */