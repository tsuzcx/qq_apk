import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class yks
  implements BusinessObserver
{
  private Handler mHandler;
  
  yks(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("ErrorCode");
    String str1 = paramBundle.getString("UniqueKey");
    if (QLog.isColorLevel()) {
      QLog.d("ZhituObserver", 2, ykm.u(str1, "onReceive", "observer onReceive with code: " + paramInt));
    }
    String str2 = ykm.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).pE();
    if (!str2.equals(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituObserver", 2, ykm.u(str1, "onReceive", "response with " + str1 + " but the last one is " + str2 + ", skip."));
      }
    }
    while (this.mHandler == null) {
      return;
    }
    paramBundle = this.mHandler.obtainMessage(2, paramBundle);
    this.mHandler.sendMessage(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yks
 * JD-Core Version:    0.7.0.1
 */