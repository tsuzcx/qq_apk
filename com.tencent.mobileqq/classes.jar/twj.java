import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;

public class twj
  extends RecyclerView.OnScrollListener
{
  public twj(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      abqw.a().a("qcircle_personal_detail_page", false);
      return;
    }
    abqw.a().a("qcircle_personal_detail_page");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    QCirclePersonalDetailFragment.a(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twj
 * JD-Core Version:    0.7.0.1
 */