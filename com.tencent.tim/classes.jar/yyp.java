import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;

public class yyp
  extends RecyclerView.OnScrollListener
{
  public yyp(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.mCurrentScrollState = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
      }
    }
    if (this.a.d != null)
    {
      if (paramInt == 0) {
        break label73;
      }
      this.a.d.edu();
      this.a.d.pause();
    }
    label73:
    while (!this.a.d.isPausing()) {
      return;
    }
    this.a.d.resume();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyp
 * JD-Core Version:    0.7.0.1
 */