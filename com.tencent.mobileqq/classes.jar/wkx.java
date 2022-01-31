import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.app.FriendListObserver;

public class wkx
  extends FriendListObserver
{
  public wkx(PublicAccountFragment paramPublicAccountFragment) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wkx
 * JD-Core Version:    0.7.0.1
 */