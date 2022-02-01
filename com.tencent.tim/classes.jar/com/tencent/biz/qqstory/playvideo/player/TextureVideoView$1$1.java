package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import qlf;
import qmc;

public class TextureVideoView$1$1
  implements Runnable
{
  public TextureVideoView$1$1(qlf paramqlf, qmc paramqmc) {}
  
  public void run()
  {
    this.a.a.mVideoWidth = this.b.getVideoWidth();
    this.a.a.mVideoHeight = this.b.getVideoHeight();
    if ((this.a.a.mVideoWidth != 0) && (this.a.a.mVideoHeight != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.a.a.getSurfaceTexture().setDefaultBufferSize(this.a.a.mVideoWidth, this.a.a.mVideoHeight);
      }
      this.a.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */