import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;

public class wqq
  extends QZoneObserver
{
  public wqq(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "inform onGetQZoneFeedCountFin");
      }
      if ((this.a.a != null) && (this.a.a.app != null)) {}
    }
    else
    {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.a.app;
    if (!GuardManager.a.a()) {
      ThreadManager.post(new wqr(this, localQQAppInterface), 8, null, false);
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqq
 * JD-Core Version:    0.7.0.1
 */