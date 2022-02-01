import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment.a;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class yrb
  implements AbsListView.e
{
  public yrb(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a) != null)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        NewFriendVerifyBlockedListFragment.a(this.a).ckT();
      }
    }
    else {
      return;
    }
    NewFriendVerifyBlockedListFragment.a(this.a).ckU();
    NewFriendVerifyBlockedListFragment.a(this.a).ckV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrb
 * JD-Core Version:    0.7.0.1
 */