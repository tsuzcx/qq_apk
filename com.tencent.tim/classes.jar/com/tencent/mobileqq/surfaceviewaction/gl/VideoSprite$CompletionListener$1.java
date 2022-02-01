package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;

class VideoSprite$CompletionListener$1
  implements Runnable
{
  VideoSprite$CompletionListener$1(VideoSprite.a parama, VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    try
    {
      if (this.b.mMediaPlayer != null) {
        this.b.mMediaPlayer.start();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "onCompletion: " + QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.CompletionListener.1
 * JD-Core Version:    0.7.0.1
 */