package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.log.TPBaseLogger;

class TPSystemMediaPlayer$4
  implements Runnable
{
  TPSystemMediaPlayer$4(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void run()
  {
    if (TPSystemMediaPlayer.access$400(this.this$0) == TPSystemMediaPlayer.PlayerState.PREPARING)
    {
      TPSystemMediaPlayer.access$900(this.this$0).error("startCheckPrepareTimeoutTimer, post error");
      TPSystemMediaPlayer.access$402(this.this$0, TPSystemMediaPlayer.PlayerState.ERROR);
      TPSystemMediaPlayer.access$1000(this.this$0);
      TPSystemMediaPlayer.access$1100(this.this$0);
      ITPPlayerBaseListener.IOnErrorListener localIOnErrorListener = TPSystemMediaPlayer.access$1200(this.this$0);
      if (localIOnErrorListener != null) {
        localIOnErrorListener.onError(2001, TPSystemMediaPlayer.access$700(-110), 0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */