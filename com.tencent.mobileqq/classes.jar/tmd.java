import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class tmd
  extends FriendListObserver
{
  public tmd(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmd
 * JD-Core Version:    0.7.0.1
 */