import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;

public class xcp
  implements Runnable
{
  public xcp(QWalletConfig paramQWalletConfig) {}
  
  public void run()
  {
    QWalletTools.a(this.a, QWalletConfig.access$000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcp
 * JD-Core Version:    0.7.0.1
 */