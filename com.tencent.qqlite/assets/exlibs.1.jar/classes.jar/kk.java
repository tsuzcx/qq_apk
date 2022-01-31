import android.os.Bundle;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class kk
  implements BusinessObserver
{
  public kk(TroopRedTouchHandler paramTroopRedTouchHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "getRedPointInfo success");
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label56;
      }
      TroopRedTouchHandler.a(this.a.a, paramBundle);
      this.a.a(105, true, null);
    }
    label56:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("SplashActivity", 2, "getRedPointInfo success data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kk
 * JD-Core Version:    0.7.0.1
 */