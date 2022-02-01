package com.tencent.mobileqq.vas;

import android.media.MediaPlayer;
import android.widget.ProgressBar;
import aqpt;

class ColorRingPlayer$3$1
  implements Runnable
{
  ColorRingPlayer$3$1(ColorRingPlayer.3 param3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.a.this$0.mediaPlayer != null) {
        bool1 = this.a.this$0.mediaPlayer.isPlaying();
      }
      if ((this.a.this$0.mediaPlayer != null) && (bool1)) {
        this.a.this$0.mPlayProgress.setProgress(this.ebw * 100 / this.val$duration);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        this.a.this$0.mediaPlayer = null;
        this.a.this$0.mediaPlayer = new MediaPlayer();
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingPlayer.3.1
 * JD-Core Version:    0.7.0.1
 */