import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class txh
  extends RecyclerView.OnScrollListener
{
  txh(txe paramtxe) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((txe.a(this.a) != null) && ((txe.a(this.a).getLayoutManager() instanceof LinearLayoutManager)))
    {
      if (paramInt2 > 0)
      {
        paramInt1 = ((LinearLayoutManager)txe.a(this.a).getLayoutManager()).findLastVisibleItemPosition();
        paramInt2 = txe.a(this.a).getLayoutManager().getItemCount();
        if (paramInt1 >= paramInt2 - 2) {
          txe.a(this.a);
        }
        if ((paramInt1 == paramInt2 - 1) && (txe.a(this.a).a().a())) {
          txe.b(this.a);
        }
        txe.a(this.a, paramInt1);
      }
      return;
    }
    paramInt1 = ((LinearLayoutManager)txe.a(this.a).getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    if (txe.a(this.a) == 0) {
      txe.b(this.a);
    }
    txe.a(this.a, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txh
 * JD-Core Version:    0.7.0.1
 */