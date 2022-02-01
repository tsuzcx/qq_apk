import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.b;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class van
  implements AbsListView.e
{
  public van(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    FriendProfileCardActivity.a(this.this$0, paramInt1);
    if (this.this$0.a != null) {
      this.this$0.a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.this$0.mScrollState != paramInt) {
      this.this$0.mScrollState = paramInt;
    }
    switch (paramInt)
    {
    default: 
      txn.a().startMonitorScene("vas_profilecard_list");
    }
    for (;;)
    {
      if (FriendProfileCardActivity.a(this.this$0) != null) {
        FriendProfileCardActivity.a(this.this$0).AT(paramInt);
      }
      if (this.this$0.a != null) {
        this.this$0.a.onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      txn.a().stopMonitorScene("vas_profilecard_list", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     van
 * JD-Core Version:    0.7.0.1
 */