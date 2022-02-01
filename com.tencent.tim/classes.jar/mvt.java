import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class mvt
  implements TopGestureLayout.OnGestureListener
{
  public mvt(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void flingLToR()
  {
    if ((VideoFeedsPlayActivity.a(this.this$0) != null) && (VideoFeedsPlayActivity.a(this.this$0).BT())) {
      return;
    }
    VideoFeedsPlayActivity.a(this.this$0, true);
    this.this$0.aSO();
  }
  
  public void flingRToL()
  {
    if (VideoFeedsPlayActivity.a(this.this$0) != null) {
      VideoFeedsPlayActivity.a(this.this$0).EH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvt
 * JD-Core Version:    0.7.0.1
 */