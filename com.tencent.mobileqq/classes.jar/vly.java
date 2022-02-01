import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;

public class vly
  extends RecyclerView.OnScrollListener
{
  public vly(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      adcd.a().a("qcircle_follow_tab_page", false);
      return;
    }
    adcd.a().a("qcircle_follow_tab_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vly
 * JD-Core Version:    0.7.0.1
 */