import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class tyf
  extends RecyclerView.OnScrollListener
{
  tyf(txz paramtxz) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((txz.a(this.a) != null) && ((txz.a(this.a).getLayoutManager() instanceof LinearLayoutManager)))
    {
      if (paramInt2 > 0)
      {
        paramInt1 = ((LinearLayoutManager)txz.a(this.a).getLayoutManager()).findLastVisibleItemPosition();
        paramInt2 = txz.a(this.a).getLayoutManager().getItemCount();
        if (paramInt1 >= paramInt2 - 2) {
          txz.b(this.a);
        }
        if ((paramInt1 == paramInt2 - 1) && (txz.a(this.a).a().a())) {
          txz.c(this.a);
        }
        txz.a(this.a, paramInt1);
      }
      return;
    }
    paramInt1 = ((LinearLayoutManager)txz.a(this.a).getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    if (txz.a(this.a) == 0) {
      txz.c(this.a);
    }
    txz.a(this.a, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */