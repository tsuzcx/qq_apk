import Wallet.RedInfoSyncRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class xmk
  implements BusinessObserver
{
  public xmk(QWalletRedManager paramQWalletRedManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "redInfoSyncReq onReceive" + paramBoolean);
    }
    StringBuilder localStringBuilder;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = (RedInfoSyncRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("RedInfoSyncRsp|");
        if (paramBundle == null) {
          break label97;
        }
      }
    }
    label97:
    for (paramBundle = Integer.valueOf(paramBundle.result);; paramBundle = "")
    {
      QLog.d("QWalletRedManager", 2, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmk
 * JD-Core Version:    0.7.0.1
 */