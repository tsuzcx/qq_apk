import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class mwf
  extends RecyclerView.OnScrollListener
{
  public mwf(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = this.d;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      VideoFeedsRecyclerView.a(paramRecyclerView, bool);
      return;
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwf
 * JD-Core Version:    0.7.0.1
 */