package com.tencent.mobileqq.qzoneplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;

class Exo2MediaPlayer$8
  implements MediaPlayerInterface.OnInfoListener
{
  Exo2MediaPlayer$8(Exo2MediaPlayer paramExo2MediaPlayer, IMediaPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2)
  {
    return this.val$onInfoListener.onInfo(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.8
 * JD-Core Version:    0.7.0.1
 */