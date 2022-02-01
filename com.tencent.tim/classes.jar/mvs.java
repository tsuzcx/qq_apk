import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat;

public class mvs
  implements RIJRedPacketManager.f
{
  public mvs(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void lJ(boolean paramBoolean)
  {
    VideoFeedsPlayActivity.a(this.this$0, paramBoolean);
    if (VideoFeedsPlayActivity.a(this.this$0) != null)
    {
      if (VideoFeedsPlayActivity.a(this.this$0))
      {
        VideoFeedsPlayActivity.a(this.this$0);
        if ((VideoFeedsPlayActivity.a(this.this$0) != null) && (VideoFeedsPlayActivity.a(this.this$0).a() != null) && (VideoFeedsPlayActivity.a(this.this$0).a().isPlaying()))
        {
          VideoInfo localVideoInfo = VideoFeedsPlayActivity.a(this.this$0).g();
          this.this$0.E(localVideoInfo.Wz, VideoFeedsPlayActivity.a(this.this$0).a().getVideoDuration());
        }
        VideoFeedsPlayActivity.b(this.this$0);
      }
    }
    else {
      return;
    }
    VideoFeedsPlayActivity.a(this.this$0).setVisibility(8);
    VideoFeedsPlayActivity.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvs
 * JD-Core Version:    0.7.0.1
 */