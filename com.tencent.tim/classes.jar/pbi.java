import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

class pbi
  extends RecyclerView.OnScrollListener
{
  pbi(pbc parampbc) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((pbc.a(this.this$0) != null) && ((pbc.a(this.this$0).getLayoutManager() instanceof LinearLayoutManager)))
    {
      if (paramInt2 > 0)
      {
        paramInt1 = ((LinearLayoutManager)pbc.a(this.this$0).getLayoutManager()).findLastVisibleItemPosition();
        paramInt2 = pbc.a(this.this$0).getLayoutManager().getItemCount();
        if (paramInt1 >= paramInt2 - 2) {
          pbc.c(this.this$0);
        }
        if ((paramInt1 == paramInt2 - 1) && (pbc.a(this.this$0).getLoadInfo().isFinish())) {
          pbc.d(this.this$0);
        }
        pbc.a(this.this$0, paramInt1);
      }
      return;
    }
    paramInt1 = ((LinearLayoutManager)pbc.a(this.this$0).getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    if (pbc.a(this.this$0) == 0) {
      pbc.d(this.this$0);
    }
    pbc.a(this.this$0, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbi
 * JD-Core Version:    0.7.0.1
 */