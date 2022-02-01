import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;

public class yyb
  extends RecyclerView.OnScrollListener
{
  public yyb(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.this$0.mCurrentScrollState = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition() + 1 == TroopSuspiciousFragment.a(this.this$0).getItemCount())) {
        TroopSuspiciousFragment.a(this.this$0);
      }
    }
    if (this.this$0.d != null)
    {
      if (paramInt == 0) {
        break label94;
      }
      this.this$0.d.edu();
      this.this$0.d.pause();
    }
    label94:
    while (!this.this$0.d.isPausing()) {
      return;
    }
    this.this$0.d.resume();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyb
 * JD-Core Version:    0.7.0.1
 */