package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;

class VideoSprite$3
  implements Runnable
{
  VideoSprite$3(VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    if ((this.this$0.mIsPrepared) && (this.this$0.mMediaPlayer != null) && (!this.this$0.mMediaPlayer.isPlaying())) {
      this.this$0.mMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.3
 * JD-Core Version:    0.7.0.1
 */