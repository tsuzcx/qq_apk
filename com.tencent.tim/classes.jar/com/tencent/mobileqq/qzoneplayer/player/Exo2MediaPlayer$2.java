package com.tencent.mobileqq.qzoneplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;

class Exo2MediaPlayer$2
  implements MediaPlayerInterface.OnPreparedListener
{
  Exo2MediaPlayer$2(Exo2MediaPlayer paramExo2MediaPlayer, IMediaPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared(MediaPlayerInterface paramMediaPlayerInterface)
  {
    this.val$onPreparedListener.onPrepared(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */