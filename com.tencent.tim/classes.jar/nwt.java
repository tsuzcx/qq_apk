import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout.b;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView;

public class nwt
  implements VideoFeedsGestureLayout.b
{
  public nwt(ViolaVideoView paramViolaVideoView) {}
  
  public long cV()
  {
    return ViolaVideoView.a(this.this$0).getCurrentPosition();
  }
  
  public long getVideoDuration()
  {
    return ViolaVideoView.a(this.this$0).getDuration();
  }
  
  public void seekTo(int paramInt)
  {
    ViolaVideoView.a(this.this$0).seekTo(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwt
 * JD-Core Version:    0.7.0.1
 */