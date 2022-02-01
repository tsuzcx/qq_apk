package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;

class PlayTextureView$5$1
  implements Runnable
{
  PlayTextureView$5$1(PlayTextureView.5 param5) {}
  
  public void run()
  {
    this.this$1.this$0.setVisibility(8);
    if (PlayTextureView.access$400(this.this$1.this$0) != null) {
      PlayTextureView.access$400(this.this$1.this$0).onError(this.this$1.val$errorCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.5.1
 * JD-Core Version:    0.7.0.1
 */