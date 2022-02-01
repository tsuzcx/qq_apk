import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.ARMapHongBaoListView;

class pwf
  extends RecyclerView.OnScrollListener
{
  boolean aCt = false;
  
  pwf(pvz parampvz) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    if (paramInt == 0)
    {
      if ((paramRecyclerView.findLastCompletelyVisibleItemPosition() == paramRecyclerView.getItemCount() - 1) && (this.aCt)) {
        this.this$0.a.bng();
      }
      return;
    }
    pvz.a(this.this$0);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {}
    for (this.aCt = true;; this.aCt = false)
    {
      if (this.this$0.mListView.isDirty()) {
        this.this$0.mListView.invalidate();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwf
 * JD-Core Version:    0.7.0.1
 */