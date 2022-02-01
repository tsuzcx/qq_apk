package com.tencent.mobileqq.qzoneplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;

class Exo2MediaPlayer$7
  implements MediaPlayerInterface.OnErrorListener
{
  Exo2MediaPlayer$7(Exo2MediaPlayer paramExo2MediaPlayer, IMediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2)
  {
    return this.val$onErrorListener.onError(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.player.Exo2MediaPlayer.7
 * JD-Core Version:    0.7.0.1
 */