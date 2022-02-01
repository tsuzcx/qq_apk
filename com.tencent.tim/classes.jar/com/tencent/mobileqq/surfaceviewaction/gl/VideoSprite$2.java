package com.tencent.mobileqq.surfaceviewaction.gl;

import android.media.MediaPlayer;
import anyo.a;
import anyw;
import com.tencent.qphone.base.util.QLog;

public class VideoSprite$2
  implements Runnable
{
  VideoSprite$2(VideoSprite paramVideoSprite, String paramString, int paramInt) {}
  
  public void run()
  {
    if (((this.this$0.mFilePath == null) || (!this.this$0.mFilePath.equals(this.val$filePath)) || (!this.this$0.mIsPrepared)) && (this.this$0.mMediaPlayer != null))
    {
      this.this$0.mMediaPlayer.stop();
      this.this$0.mMediaPlayer.reset();
    }
    try
    {
      this.this$0.mMediaPlayer.setDataSource(this.val$filePath);
      this.this$0.mMediaPlayer.prepare();
      this.this$0.mWidth = this.this$0.mMediaPlayer.getVideoWidth();
      this.this$0.mHeight = this.this$0.mMediaPlayer.getVideoHeight();
      this.this$0.mMediaPlayer.setOnSeekCompleteListener(new anyw(this));
      this.this$0.mMediaPlayer.seekTo(this.dNB);
      this.this$0.mFilePath = this.val$filePath;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException));
        }
        if (this.this$0.e != null) {
          this.this$0.e.byj();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.2
 * JD-Core Version:    0.7.0.1
 */