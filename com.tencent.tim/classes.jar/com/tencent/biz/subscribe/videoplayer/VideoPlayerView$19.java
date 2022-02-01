package com.tencent.biz.subscribe.videoplayer;

import acfp;
import com.tencent.mobileqq.widget.QQToast;
import sqn;

class VideoPlayerView$19
  implements Runnable
{
  VideoPlayerView$19(VideoPlayerView paramVideoPlayerView, int paramInt) {}
  
  public void run()
  {
    VideoPlayerView.a(this.this$0, 9);
    VideoPlayerView.b(this.this$0, false);
    sqn.n("subscribe_account_video_play", sqn.ay(sqn.a(this.bwR, 0L, VideoPlayerView.a(this.this$0), 0L)));
    if (!VideoPlayerView.j(this.this$0)) {
      QQToast.a(this.this$0.getContext(), 1, acfp.m(2131716430), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.19
 * JD-Core Version:    0.7.0.1
 */