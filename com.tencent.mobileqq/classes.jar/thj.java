import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class thj
  extends FriendListObserver
{
  public thj(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     thj
 * JD-Core Version:    0.7.0.1
 */