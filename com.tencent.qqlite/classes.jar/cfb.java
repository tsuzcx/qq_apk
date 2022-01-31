import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;

public class cfb
  extends QZoneObserver
{
  public cfb(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
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
      QZoneHelper.a(localQQAppInterface);
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cfb
 * JD-Core Version:    0.7.0.1
 */