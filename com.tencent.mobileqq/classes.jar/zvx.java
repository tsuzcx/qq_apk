import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.qphone.base.util.QLog;

public class zvx
  implements Runnable
{
  public zvx(ActivateFriendsManager paramActivateFriendsManager) {}
  
  public void run()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.a(this.a)) > ActivateFriendsManager.b(this.a))
    {
      bool1 = true;
      if (Math.abs(System.currentTimeMillis() - ActivateFriendsManager.c(this.a)) <= ActivateFriendsManager.d(this.a)) {
        break label168;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "checkRunnable | lastBirthdayCheckInStamp = " + ActivateFriendsManager.a(this.a) + " | checkBirthdayInterval = " + ActivateFriendsManager.b(this.a) + " | lastMemorialCheckInStamp = " + ActivateFriendsManager.c(this.a) + " | checkMemorialInterval = " + ActivateFriendsManager.d(this.a) + " | isBirthday = " + bool1 + " | isMemorial = " + bool2);
      }
      if ((bool1) || (bool2)) {
        break label173;
      }
      return;
      bool1 = false;
      break;
      label168:
      bool2 = false;
    }
    label173:
    ActivateFriendServlet.a(ActivateFriendsManager.a(this.a), bool1, bool2);
    this.a.a = ActivateFriendsManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zvx
 * JD-Core Version:    0.7.0.1
 */