import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.list.QCirclePublicListFragment;

public class tyv
  extends RecyclerView.OnScrollListener
{
  public tyv(QCirclePublicListFragment paramQCirclePublicListFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      abvl.a().a(this.a.a.getDropFrameMonitorTag(), false);
      return;
    }
    abvl.a().a(this.a.a.getDropFrameMonitorTag());
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyv
 * JD-Core Version:    0.7.0.1
 */