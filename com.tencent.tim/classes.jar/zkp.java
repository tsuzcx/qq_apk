import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver.4.1;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class zkp
  extends akln
{
  zkp(zju paramzju) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "inform onGetQZoneFeedCountFin");
      }
      if ((this.this$0.a != null) && (this.this$0.a.app != null)) {}
    }
    else
    {
      return;
    }
    QQAppInterface localQQAppInterface = this.this$0.a.app;
    if ((GuardManager.a != null) && (!GuardManager.a.aaj())) {
      ThreadManager.post(new MainAssistObserver.4.1(this, localQQAppInterface), 8, null, false);
    }
    this.this$0.cpK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkp
 * JD-Core Version:    0.7.0.1
 */