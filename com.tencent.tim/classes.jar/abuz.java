import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class abuz
  implements BusinessObserver
{
  abuz(abuy paramabuy, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    this.a.a(this.b, paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloSSOConfig", 2, "checkRequestSendSSO, type:" + paramInt + "isSuccess:" + paramBoolean + "onReceive use:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuz
 * JD-Core Version:    0.7.0.1
 */