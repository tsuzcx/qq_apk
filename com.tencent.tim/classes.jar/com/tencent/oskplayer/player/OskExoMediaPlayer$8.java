package com.tencent.oskplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;

class OskExoMediaPlayer$8
  implements MediaPlayerInterface.OnInfoListener
{
  OskExoMediaPlayer$8(OskExoMediaPlayer paramOskExoMediaPlayer, IMediaPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(MediaPlayerInterface paramMediaPlayerInterface, int paramInt1, int paramInt2)
  {
    return this.val$listener.onInfo(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.OskExoMediaPlayer.8
 * JD-Core Version:    0.7.0.1
 */