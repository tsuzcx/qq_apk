import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.main.QCircleAggregationFragment;

public class voa
  extends RecyclerView.OnScrollListener
{
  public voa(QCircleAggregationFragment paramQCircleAggregationFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      adlb.a().a("qcircle_follow_tab_page", false);
      return;
    }
    adlb.a().a("qcircle_follow_tab_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voa
 * JD-Core Version:    0.7.0.1
 */