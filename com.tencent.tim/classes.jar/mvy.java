import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.d;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.1.1;

public class mvy
  implements mrp.a
{
  public mvy(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void aRG()
  {
    if ((VideoFeedsRecommendFragment.a(this.this$0)) && (VideoFeedsRecommendFragment.a(this.this$0) != null) && (VideoFeedsRecommendFragment.a(this.this$0).a != null) && (VideoFeedsRecommendFragment.a(this.this$0).a.d != null) && (VideoFeedsRecommendFragment.a(this.this$0).a.d.b != null) && (VideoFeedsRecommendFragment.a(this.this$0) != null)) {
      if ((knc.e(VideoFeedsRecommendFragment.a(this.this$0).a.d.b)) && (!VideoFeedsRecommendFragment.a(this.this$0).dU(VideoFeedsRecommendFragment.a(this.this$0).aUv)))
      {
        localVideoInfo = VideoFeedsRecommendFragment.a(this.this$0).a(VideoFeedsRecommendFragment.a(this.this$0).aUv);
        if (localVideoInfo != null)
        {
          i = VideoFeedsRecommendFragment.a(this.this$0).getAdapterPosition() - 1;
          j = VideoFeedsRecommendFragment.a(this.this$0).aUv;
          VideoFeedsRecommendFragment.a(this.this$0).a(i, j, localVideoInfo);
          kmw.c(this.this$0.getActivity(), 50, true);
        }
      }
    }
    while ((VideoFeedsRecommendFragment.a(this.this$0) == null) || (VideoFeedsRecommendFragment.a(this.this$0) == null))
    {
      VideoInfo localVideoInfo;
      int i;
      int j;
      VideoFeedsRecommendFragment.a(this.this$0).postDelayed(new VideoFeedsRecommendFragment.1.1(this, i + 1), 0L);
      do
      {
        return;
      } while (VideoFeedsRecommendFragment.a(this.this$0) == null);
      VideoFeedsRecommendFragment.a(this.this$0).restart();
      return;
    }
    VideoFeedsRecommendFragment.a(this.this$0).r(VideoFeedsRecommendFragment.a(this.this$0).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvy
 * JD-Core Version:    0.7.0.1
 */