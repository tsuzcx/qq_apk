package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnVideoSizeChangedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;

class Exo2MediaPlayer$6
  implements MediaPlayerInterface.OnVideoSizeChangedListener
{
  Exo2MediaPlayer$6(Exo2MediaPlayer paramExo2MediaPlayer, IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {}
  
  public void onVideoSizeChanged(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2)
  {
    this.val$onVideoSizeChangedListener.onVideoSizeChanged(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.Exo2MediaPlayer.6
 * JD-Core Version:    0.7.0.1
 */