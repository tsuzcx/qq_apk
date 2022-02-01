import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class mwa
  implements View.OnLayoutChangeListener
{
  private int aVq;
  
  public mwa(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment, Configuration paramConfiguration) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((VideoFeedsRecommendFragment.a(this.this$0).getHeight() != this.aVq) && (VideoFeedsRecommendFragment.a(this.this$0) != null) && (VideoFeedsRecommendFragment.a(this.this$0) != null))
    {
      VideoFeedsRecommendFragment.a(this.this$0).a(VideoFeedsRecommendFragment.a(this.this$0), VideoFeedsRecommendFragment.a(this.this$0));
      VideoFeedsRecommendFragment.a(this.this$0).aTo();
      VideoFeedsRecommendFragment.a(this.this$0).aSg();
      if ((VideoFeedsRecommendFragment.a(this.this$0).El()) && (VideoFeedsRecommendFragment.a(this.this$0) != null)) {
        VideoFeedsRecommendFragment.a(this.this$0).a.nX(true);
      }
      if (VideoFeedsRecommendFragment.a(this.this$0) != null) {
        VideoFeedsRecommendFragment.a(this.this$0).onConfigurationChanged(this.b);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendFragment", 2, "onConfigurationChanged onLayoutChange: " + Arrays.toString(muj.c(this.this$0.getActivity())));
      }
    }
    for (;;)
    {
      this.aVq = VideoFeedsRecommendFragment.a(this.this$0).getHeight();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendFragment", 2, "onConfigurationChanged onLayoutChange: screen size unchanged " + Arrays.toString(muj.c(this.this$0.getActivity())));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwa
 * JD-Core Version:    0.7.0.1
 */