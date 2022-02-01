package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.utils.LogUtil;

class PlayTextureView$4$2
  implements Runnable
{
  PlayTextureView$4$2(PlayTextureView.4 param4) {}
  
  public void run()
  {
    PlayTextureView.access$1802(this.this$1.this$0, false);
    if (PlayTextureView.access$1900(this.this$1.this$0) != null)
    {
      LogUtil.v(PlayTextureView.access$000(this.this$1.this$0), "==============stopping need play file again");
      this.this$1.this$0.playFile(PlayTextureView.access$1900(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.4.2
 * JD-Core Version:    0.7.0.1
 */