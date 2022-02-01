package com.google.android.exoplayer2.ext.mediaplayer;

import com.google.android.exoplayer2.ExoPlayer;

class ExoMediaPlayer$2
  implements Runnable
{
  ExoMediaPlayer$2(ExoMediaPlayer paramExoMediaPlayer, long paramLong) {}
  
  public void run()
  {
    if (ExoMediaPlayer.access$700(this.this$0) != null) {
      ExoMediaPlayer.access$700(this.this$0).seekTo(this.val$pos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */