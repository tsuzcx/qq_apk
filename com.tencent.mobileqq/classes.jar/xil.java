import Wallet.RspWalletConfig;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class xil
  implements BusinessObserver
{
  public xil(QWalletConfigManager paramQWalletConfigManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 17)
    {
      if (!paramBoolean) {}
      try
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("QWalletConfigManager", 2, "setConfigSession fail get rsp:");
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      paramBundle = (RspWalletConfig)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel())
      {
        QLog.d("QWalletConfigManager", 2, "setConfigSession RspWalletConfig|" + paramBundle);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xil
 * JD-Core Version:    0.7.0.1
 */