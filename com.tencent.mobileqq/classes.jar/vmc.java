import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment;

public class vmc
  extends RecyclerView.OnScrollListener
{
  public vmc(QCircleFolderRcmdTabFragment paramQCircleFolderRcmdTabFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      adcd.a().a("qcircle_all_push_tab_page", false);
      return;
    }
    adcd.a().a("qcircle_all_push_tab_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmc
 * JD-Core Version:    0.7.0.1
 */