import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;

public class voc
  extends RecyclerView.OnScrollListener
{
  public voc(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
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
 * Qualified Name:     voc
 * JD-Core Version:    0.7.0.1
 */