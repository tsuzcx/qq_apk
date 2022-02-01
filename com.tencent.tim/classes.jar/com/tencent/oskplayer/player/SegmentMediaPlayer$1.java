package com.tencent.oskplayer.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import tv.danmaku.ijk.media.player.IMediaPlayer;

class SegmentMediaPlayer$1
  extends Handler
{
  SegmentMediaPlayer$1(SegmentMediaPlayer paramSegmentMediaPlayer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (SegmentMediaPlayer.access$000(this.this$0)) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      SegmentMediaPlayer.access$100(this.this$0);
      return;
    case 1: 
      SegmentMediaPlayer.access$200(this.this$0, (IMediaPlayer)paramMessage.obj);
      return;
    }
    SegmentMediaPlayer.access$300(this.this$0, ((Long)paramMessage.obj).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.SegmentMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */