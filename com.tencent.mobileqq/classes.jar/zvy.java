import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class zvy
  implements Runnable
{
  public zvy(ActivateFriendsManager paramActivateFriendsManager) {}
  
  public void run()
  {
    long l = ActivateFriendsManager.a(this.a).getLong("key_last_birth_msg_stamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + l);
    }
    if (MessageCache.a() - l > 259200L)
    {
      ActivateFriendsManager.a(this.a).removeCallbacks(ActivateFriendsManager.a(this.a));
      this.a.a = ActivateFriendsManager.b(this.a);
      ActivateFriendServlet.a(ActivateFriendsManager.a(this.a), false, true, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zvy
 * JD-Core Version:    0.7.0.1
 */