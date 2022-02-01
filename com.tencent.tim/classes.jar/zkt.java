import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver.8.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class zkt
  implements achv
{
  zkt(zju paramzju) {}
  
  public void Fo(int paramInt)
  {
    if ((this.this$0.a == null) || (this.this$0.a.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.this$0.a.app;
    this.this$0.f(32, 16, Integer.valueOf(paramInt));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.getApp().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("MainAssistObserver消息tab, nUnreadCount[%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    lcm.a().qE(paramInt);
  }
  
  public void aL(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, String.format("onRefresh, needReGetUnread[%s], nUnReadCount[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((!paramBoolean) && (paramInt >= 0))
    {
      Fo(paramInt);
      return;
    }
    ThreadManager.executeOnSubThread(new MainAssistObserver.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkt
 * JD-Core Version:    0.7.0.1
 */