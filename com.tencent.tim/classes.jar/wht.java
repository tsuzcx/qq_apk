import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class wht
  implements BusinessObserver
{
  public wht(QQNotifySettingBaseFragment paramQQNotifySettingBaseFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 2002)
    {
      if (paramBoolean) {}
      try
      {
        QQNotifySettingBaseFragment.a(this.a).post(new QQNotifySettingBaseFragment.2.1(this, paramBundle));
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e(QQNotifySettingBaseFragment.access$100(), 1, QLog.getStackTraceString(paramBundle));
      }
      this.a.bn(3, "system error");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wht
 * JD-Core Version:    0.7.0.1
 */