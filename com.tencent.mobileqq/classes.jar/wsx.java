import com.tencent.mobileqq.activity.contacts.fragment.FriendFragment;
import com.tencent.mobileqq.app.MessageObserver;

public class wsx
  extends MessageObserver
{
  private wsx(FriendFragment paramFriendFragment) {}
  
  protected void f()
  {
    if (FriendFragment.b(this.a)) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsx
 * JD-Core Version:    0.7.0.1
 */