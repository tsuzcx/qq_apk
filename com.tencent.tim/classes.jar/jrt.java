import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class jrt
  implements BusinessObserver
{
  jrt(QQAppInterface paramQQAppInterface, jrs.a parama) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        jrs.b(this.val$app, paramBundle, this.a);
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
    }
    this.a.onFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrt
 * JD-Core Version:    0.7.0.1
 */