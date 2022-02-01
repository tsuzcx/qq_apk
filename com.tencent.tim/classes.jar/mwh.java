import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class mwh
  implements View.OnLayoutChangeListener
{
  public mwh(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.d.removeOnLayoutChangeListener(this);
    if (VideoFeedsRecyclerView.a(this.d) != null) {
      VideoFeedsRecyclerView.a(this.d).offsetToTargetPosition(VideoFeedsRecyclerView.a(this.d).itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwh
 * JD-Core Version:    0.7.0.1
 */