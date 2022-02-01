package com.tencent.ttpic.videoshelf.model.player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;

class PagShelfPlayer$1
  implements MediaPlayer.OnCompletionListener
{
  PagShelfPlayer$1(PagShelfPlayer paramPagShelfPlayer) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    TTPTLogger.i("PagShelfPlayer", "音频播放完毕");
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.stop();
      PagShelfPlayer.access$202(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer.1
 * JD-Core Version:    0.7.0.1
 */