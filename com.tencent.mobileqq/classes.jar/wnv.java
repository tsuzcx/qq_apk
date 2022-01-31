import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.CallTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class wnv
  implements CallTabUnreadListener
{
  public wnv(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback...");
    }
    if ((this.a.a == null) || (this.a.a.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.a.app;
    int i = QCallFacade.a(localQQAppInterface);
    this.a.a(36, 16, Integer.valueOf(i));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.getApp().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("MainAssistObserver通话tab, callUnReadCount[%s]", new Object[] { Integer.valueOf(i) }));
    }
    localQQAppInterface.C();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnv
 * JD-Core Version:    0.7.0.1
 */