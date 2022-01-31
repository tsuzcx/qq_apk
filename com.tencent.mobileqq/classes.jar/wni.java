import com.tencent.mobileqq.activity.contacts.fragment.FriendFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;

public class wni
  implements Runnable
{
  public wni(FriendFragment paramFriendFragment) {}
  
  public void run()
  {
    ((QzoneContactsFeedManager)this.a.a.getManager(90)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wni
 * JD-Core Version:    0.7.0.1
 */