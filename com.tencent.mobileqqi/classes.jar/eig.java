import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

public class eig
  implements MsgTabUnreadListener
{
  public eig(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback...");
    }
    if ((this.a.a == null) || (this.a.a.b == null)) {}
    QQAppInterface localQQAppInterface;
    NewFriendManager localNewFriendManager;
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQAppInterface = this.a.a.b;
      localNewFriendManager = (NewFriendManager)localQQAppInterface.getManager(32);
      i = 0;
      if (localQQAppInterface.a().b(AppConstants.R, 4000)) {
        i = localNewFriendManager.a();
      }
      localQQMessageFacade = localQQAppInterface.a();
    } while (localQQMessageFacade == null);
    i += localQQMessageFacade.f();
    this.a.a(32, 16, Integer.valueOf(i));
    Intent localIntent = new Intent("com.tencent.qqi.syncQQMessage");
    localQQAppInterface.a().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback.msgNum.." + i);
    }
    int i = localNewFriendManager.a(1);
    BadgeUtils.d(localQQAppInterface.a(), i + localQQMessageFacade.f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eig
 * JD-Core Version:    0.7.0.1
 */