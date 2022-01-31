import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.app.FriendListObserver;

public class woc
  extends FriendListObserver
{
  public woc(PublicAccountFragment paramPublicAccountFragment) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     woc
 * JD-Core Version:    0.7.0.1
 */