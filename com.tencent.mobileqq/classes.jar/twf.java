import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment;

public class twf
  extends RecyclerView.OnScrollListener
{
  public twf(QCircleFolderRcmdTabFragment paramQCircleFolderRcmdTabFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      abqw.a().a("qcircle_all_push_tab_page", false);
      return;
    }
    abqw.a().a("qcircle_all_push_tab_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twf
 * JD-Core Version:    0.7.0.1
 */