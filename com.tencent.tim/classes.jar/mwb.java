import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.l;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class mwb
  implements View.OnLayoutChangeListener
{
  public mwb(VideoFeedsRecommendFragment.l paraml) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    VideoFeedsRecommendFragment.a(this.a.this$0).removeOnLayoutChangeListener(this);
    VideoFeedsRecommendFragment.a(this.a.this$0).EK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwb
 * JD-Core Version:    0.7.0.1
 */