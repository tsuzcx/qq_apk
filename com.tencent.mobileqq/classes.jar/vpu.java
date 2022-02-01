import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.qphone.base.util.QLog;

public class vpu
  extends RecyclerView.OnScrollListener
{
  public vpu(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      adlb.a().a("qcircle_personal_detail_page", false);
      return;
    }
    adlb.a().a("qcircle_personal_detail_page");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    QCirclePersonalDetailFragment.a(this.a, paramInt2);
    if ((paramRecyclerView.getLayoutManager() instanceof aacf))
    {
      int[] arrayOfInt = ((aacf)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPositions(null);
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        paramInt2 = arrayOfInt[0];
        if (!this.a.a().a().a().b()) {
          break label171;
        }
      }
    }
    label171:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt2 == paramInt1)
      {
        QLog.i("QCirclePersonalDetailFragment", 1, "onScrolled headView completeVisible");
        QCirclePersonalDetailFragment.a(this.a);
      }
      paramRecyclerView = ((aacf)paramRecyclerView.getLayoutManager()).findFirstVisibleItemPositions(null);
      if (paramRecyclerView != null) {
        QCirclePersonalDetailFragment.b(this.a, paramRecyclerView[0]);
      }
      if ((paramRecyclerView != null) && (paramRecyclerView.length > 0) && (this.a.a().a().a().b()) && (paramRecyclerView[0] == 0))
      {
        QLog.i("QCirclePersonalDetailFragment", 1, "onScrolled refreshItem visible");
        QCirclePersonalDetailFragment.a(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpu
 * JD-Core Version:    0.7.0.1
 */