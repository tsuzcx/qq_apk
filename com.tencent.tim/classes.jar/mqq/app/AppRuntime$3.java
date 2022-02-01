package mqq.app;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class AppRuntime$3
  implements Runnable
{
  AppRuntime$3(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    long l1 = 0L;
    if (MainService.isDebugVersion) {
      l1 = SystemClock.uptimeMillis();
    }
    this.val$observer.onReceive(this.val$type, this.val$isSuccess, this.val$data);
    if ((MainService.isDebugVersion) && (MsfServiceSdk.get() != null)) {}
    try
    {
      long l2 = SystemClock.uptimeMillis();
      QLog.d("mqq", 2, "mqq_notifyOB cost:" + (l2 - l1));
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.AppRuntime.3
 * JD-Core Version:    0.7.0.1
 */