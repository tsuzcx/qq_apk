import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;

public class paa
  extends RecyclerView.OnScrollListener
{
  public paa(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("qcircle_follow_tab_page", false);
      return;
    }
    txn.a().startMonitorScene("qcircle_follow_tab_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     paa
 * JD-Core Version:    0.7.0.1
 */