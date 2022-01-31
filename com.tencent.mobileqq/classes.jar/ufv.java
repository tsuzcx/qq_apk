import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.qphone.base.util.QLog;

public class ufv
  extends ActivateFriendsObserver
{
  public ufv(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "onReceiveBirthDayPushUpdate");
    }
    ActivateFriendActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ufv
 * JD-Core Version:    0.7.0.1
 */