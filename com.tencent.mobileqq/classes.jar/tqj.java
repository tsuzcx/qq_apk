import android.content.IntentFilter;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class tqj
  implements Runnable
{
  public tqj(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    try
    {
      QNotificationManager localQNotificationManager = new QNotificationManager(this.a);
      localQNotificationManager.cancel("SplashActivity", 120);
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.a.app.getManager(9);
      if (localQZoneManagerImp != null) {
        localQZoneManagerImp.a(1, 0);
      }
      localQNotificationManager.cancel("SplashActivity", 121);
      localQNotificationManager.cancel("SplashActivity", 122);
      localQNotificationManager.cancel("SplashActivity", 123);
      localQNotificationManager.cancel("SplashActivity", 129);
      localQNotificationManager.cancel("SplashActivity", 144);
      localQNotificationManager.cancel("SplashActivity", 193);
      localQNotificationManager.cancel("SplashActivity", 194);
      localQNotificationManager.cancel("SplashActivity", 211);
      SplashActivity.a(this.a, new tqk(this));
      this.a.registerReceiver(SplashActivity.a(this.a), new IntentFilter("before_account_change"));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tqj
 * JD-Core Version:    0.7.0.1
 */