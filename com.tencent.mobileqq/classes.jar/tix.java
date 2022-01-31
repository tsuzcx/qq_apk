import android.os.Bundle;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class tix
  implements BusinessObserver
{
  public tix(QQSettingMe paramQQSettingMe) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      QLog.i("SSOHttpUtils", 2, "PublicAccount RefreshStepsObserver onReceive");
      ThreadManager.post(new tiy(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tix
 * JD-Core Version:    0.7.0.1
 */