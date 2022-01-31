import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qphone.base.util.QLog;

public class wgl
  implements Runnable
{
  public wgl(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.a.a.a(20);
    String str = this.a.a().a;
    if (!TextUtils.isEmpty(str)) {
      localTroopHandler.q(str);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Q.aio.TroopChatPie", 2, "mGetOnlineMemberTipsRunnable, getSessionInfo().curFriendUin == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgl
 * JD-Core Version:    0.7.0.1
 */