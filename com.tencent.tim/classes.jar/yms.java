import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.c;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class yms
  implements AbsListView.e
{
  private int bZY;
  private int lastVisibleItem;
  
  public yms(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bZY = this.this$0.a.getCount();
    this.lastVisibleItem = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.this$0.mIsLoading) || (this.this$0.bnB) || (this.bZY <= 0)) {}
    while ((paramInt != 0) || (this.bZY > this.lastVisibleItem)) {
      return;
    }
    this.this$0.Ei(21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yms
 * JD-Core Version:    0.7.0.1
 */