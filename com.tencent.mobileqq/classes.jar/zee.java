import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class zee
  implements Runnable
{
  public zee(FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    FriendsManager.a(this.a);
    ((FriendListHandler)FriendsManager.a(this.a).a(1)).a(103, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zee
 * JD-Core Version:    0.7.0.1
 */