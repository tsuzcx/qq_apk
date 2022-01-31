import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class xdd
  implements Runnable
{
  public xdd(QWalletIPCModule paramQWalletIPCModule, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ((QWalletConfigManager)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getManager(244)).a(1L, new xde(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdd
 * JD-Core Version:    0.7.0.1
 */