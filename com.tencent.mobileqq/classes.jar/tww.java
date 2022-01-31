import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment;

public class tww
  extends RecyclerView.OnScrollListener
{
  public tww(QCircleFolderRcmdTabFragment paramQCircleFolderRcmdTabFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      abvl.a().a("qcircle_all_push_tab_page", false);
      return;
    }
    abvl.a().a("qcircle_all_push_tab_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tww
 * JD-Core Version:    0.7.0.1
 */