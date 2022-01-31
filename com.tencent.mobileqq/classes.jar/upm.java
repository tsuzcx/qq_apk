import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;

public class upm
  implements Runnable
{
  public upm(CustomizeStrategyFactory paramCustomizeStrategyFactory) {}
  
  public void run()
  {
    synchronized (CustomizeStrategyFactory.a(this.a))
    {
      if (!CustomizeStrategyFactory.a(this.a))
      {
        QQAppInterface localQQAppInterface = QWalletTools.a();
        if (localQQAppInterface != null) {
          this.a.a = ((QWalletConfigManager)localQQAppInterface.getManager(244));
        }
        if (this.a.a != null) {
          this.a.a.a("redPack", this.a);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upm
 * JD-Core Version:    0.7.0.1
 */