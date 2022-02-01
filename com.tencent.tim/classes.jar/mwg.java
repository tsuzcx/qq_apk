import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class mwg
  implements View.OnLayoutChangeListener
{
  public mwg(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.d.removeOnLayoutChangeListener(this);
    if ((VideoFeedsRecyclerView.a(this.d) != null) && (VideoFeedsRecyclerView.a(this.d)))
    {
      paramInt1 = 0;
      if (VideoFeedsRecyclerView.a(this.d) != 0) {
        break label228;
      }
    }
    label227:
    label228:
    label244:
    do
    {
      paramInt1 = (int)(this.d.getHeight() * 0.3D);
      break label227;
      paramView = VideoFeedsRecyclerView.a(this.d).getLayoutParams();
      paramView.height = paramInt1;
      VideoFeedsRecyclerView.a(this.d).setLayoutParams(paramView);
      if (VideoFeedsRecyclerView.a(this.d) == 0)
      {
        paramView = this.d.getLayoutManager().findViewByPosition(1);
        if ((paramView != null) && (paramView.getHeight() > 0) && (VideoFeedsRecyclerView.b(this.d)))
        {
          paramInt1 = paramView.getHeight();
          paramInt1 = (int)(this.d.getHeight() / 2.0F - paramInt1 / 2.0F);
          VideoFeedsRecyclerView.a(this.d, paramInt1);
          if ((!VideoFeedsRecyclerView.a(this.d).snapToTargetPosition(1)) || (VideoFeedsRecyclerView.a(this.d).getCurrentPosition() == 1)) {
            break label244;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if ((paramInt1 == 0) && (VideoFeedsRecyclerView.a(this.d) != null) && (VideoFeedsRecyclerView.a(this.d).getCurrentPosition() != 1)) {
            this.d.onPagerChanged(this.d.getChildViewHolder(paramView));
          }
          return;
          if (VideoFeedsRecyclerView.a(this.d) != 1) {
            break;
          }
          paramInt1 = 0;
          break;
        }
      }
    } while (VideoFeedsRecyclerView.a(this.d) != 1);
    VideoFeedsRecyclerView.a(this.d, VideoFeedsRecyclerView.b(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwg
 * JD-Core Version:    0.7.0.1
 */