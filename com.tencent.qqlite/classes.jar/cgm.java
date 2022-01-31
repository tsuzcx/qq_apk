import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

public class cgm
  implements MsgTabUnreadListener
{
  public cgm(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback...");
    }
    if ((this.a.a == null) || (this.a.a.app == null)) {}
    QQAppInterface localQQAppInterface;
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQAppInterface = this.a.a.app;
      localQQMessageFacade = localQQAppInterface.a();
    } while (localQQMessageFacade == null);
    int i = localQQMessageFacade.e();
    this.a.a(32, 16, Integer.valueOf(i));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.a().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback.msgNum.." + i);
    }
    BadgeUtils.a(localQQAppInterface.a(), localQQMessageFacade.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgm
 * JD-Core Version:    0.7.0.1
 */