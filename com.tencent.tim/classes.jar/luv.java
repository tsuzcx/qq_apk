import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;

public class luv
  extends RecyclerView.OnScrollListener
{
  public luv(PTSFragment paramPTSFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("list_kandian_daily_new", false);
      return;
    }
    txn.a().startMonitorScene("list_kandian_daily_new");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     luv
 * JD-Core Version:    0.7.0.1
 */