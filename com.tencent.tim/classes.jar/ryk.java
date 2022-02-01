import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.richframework.part.list.base.PublicListFragment;

public class ryk
  extends RecyclerView.OnScrollListener
{
  public ryk(PublicListFragment paramPublicListFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene(this.a.b.getDropFrameMonitorTag(), false);
      return;
    }
    txn.a().startMonitorScene(this.a.b.getDropFrameMonitorTag());
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryk
 * JD-Core Version:    0.7.0.1
 */