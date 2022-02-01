import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.qphone.base.util.QLog;

class vdx
  extends RecyclerView.OnScrollListener
{
  vdx(vdt paramvdt) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      adcd.a().a("qcircle_tag_page", false);
      return;
    }
    adcd.a().a("qcircle_tag_page");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    vdt.a(this.a, paramInt2);
    if ((paramRecyclerView.getLayoutManager() instanceof zyj))
    {
      int[] arrayOfInt = ((zyj)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPositions(null);
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
        QLog.i("QCircleTagPageBodyPart", 1, "onScrolled headView completeVisible");
        vdt.a(this.a);
      }
      paramRecyclerView = ((zyj)paramRecyclerView.getLayoutManager()).findFirstVisibleItemPositions(null);
      if ((paramRecyclerView != null) && (paramRecyclerView.length > 0) && (this.a.a().a().b()) && (paramRecyclerView[0] == 0))
      {
        QLog.i("QCircleTagPageBodyPart", 1, "onScrolled refreshItem visible");
        vdt.a(this.a);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdx
 * JD-Core Version:    0.7.0.1
 */