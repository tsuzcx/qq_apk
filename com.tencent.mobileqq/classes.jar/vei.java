import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.qphone.base.util.QLog;

class vei
  extends RecyclerView.OnScrollListener
{
  vei(vee paramvee) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      adlb.a().a("qcircle_polymerization_page", false);
      return;
    }
    adlb.a().a("qcircle_polymerization_page");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    vee.a(this.a, paramInt2);
    if ((paramRecyclerView.getLayoutManager() instanceof aacf))
    {
      int[] arrayOfInt = ((aacf)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPositions(null);
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        paramInt2 = arrayOfInt[0];
        if (!this.a.a().a().b()) {
          break label151;
        }
      }
    }
    label151:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt2 == paramInt1)
      {
        QLog.i("BlockPart", 1, "onScrolled headView completeVisible");
        vee.a(this.a);
      }
      paramRecyclerView = ((aacf)paramRecyclerView.getLayoutManager()).findFirstVisibleItemPositions(null);
      if ((paramRecyclerView != null) && (paramRecyclerView.length > 0) && (this.a.a().a().b()) && (paramRecyclerView[0] == 0))
      {
        QLog.i("BlockPart", 1, "onScrolled refreshItem visible");
        vee.a(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vei
 * JD-Core Version:    0.7.0.1
 */