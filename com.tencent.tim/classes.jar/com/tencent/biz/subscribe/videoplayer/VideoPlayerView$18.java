package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import sqn;

class VideoPlayerView$18
  implements Runnable
{
  VideoPlayerView$18(VideoPlayerView paramVideoPlayerView) {}
  
  public void run()
  {
    VideoPlayerView.a(this.this$0, 10);
    if (this.this$0.a() != null)
    {
      VideoPlayerView.k(this.this$0);
      VideoPlayerView.e(this.this$0);
      VideoPlayerView.a(this.this$0, true);
    }
    if (!VideoPlayerView.d(this.this$0)) {
      if (VideoPlayerView.a(this.this$0) != null)
      {
        if (!this.this$0.MK()) {
          break label128;
        }
        VideoPlayerView.a(this.this$0).byU();
      }
    }
    for (;;)
    {
      if (VideoPlayerView.e(this.this$0) != null) {
        VideoPlayerView.e(this.this$0).setVisibility(8);
      }
      if (VideoPlayerView.a(this.this$0) != null) {
        VideoPlayerView.a(this.this$0).onVideoComplete(false);
      }
      return;
      label128:
      if ((VideoPlayerView.a(this.this$0).show()) && (this.this$0.Z != null))
      {
        this.this$0.Z.setBackgroundResource(2131165395);
        this.this$0.Z.setImageDrawable(null);
        this.this$0.Z.setVisibility(0);
        if (VideoPlayerView.a(this.this$0) != null)
        {
          sqn.c(VideoPlayerView.a(this.this$0).poster.id.get(), "auth_video", "finish_exp", 0, 0, new String[] { "", "", VideoPlayerView.a(this.this$0).poster.nick.get(), VideoPlayerView.a(this.this$0).title.get() });
          continue;
          VideoPlayerView.f(this.this$0);
          this.this$0.replay();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView.18
 * JD-Core Version:    0.7.0.1
 */