import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment;

public class pae
  extends RecyclerView.OnScrollListener
{
  public pae(QCircleFolderRcmdTabFragment paramQCircleFolderRcmdTabFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("qcircle_all_push_tab_page", false);
      return;
    }
    txn.a().startMonitorScene("qcircle_all_push_tab_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pae
 * JD-Core Version:    0.7.0.1
 */