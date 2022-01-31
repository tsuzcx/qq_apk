import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.ConfigInfo;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.red.QWRedConfig;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class xgp
  implements Runnable
{
  public xgp(QWalletRedManager paramQWalletRedManager) {}
  
  public void run()
  {
    Object localObject = (QWalletConfigManager)QWalletRedManager.a(this.a).getManager(244);
    if (localObject != null)
    {
      ((QWalletConfigManager)localObject).a("redPoint", this.a);
      localObject = ((QWalletConfigManager)localObject).a("redPoint");
      QWalletRedManager.a(this.a).parseConfig((QWalletConfig.ConfigInfo)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "synDataFromMoggy" + QWalletRedManager.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgp
 * JD-Core Version:    0.7.0.1
 */