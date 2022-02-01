package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnBufferingUpdateListener;

class DefaultMediaPlayer$3
  implements MediaPlayer.OnBufferingUpdateListener
{
  DefaultMediaPlayer$3(DefaultMediaPlayer paramDefaultMediaPlayer, IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.val$listener.onBufferingUpdate(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.3
 * JD-Core Version:    0.7.0.1
 */