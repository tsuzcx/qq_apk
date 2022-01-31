import com.tencent.mobileqq.activity.qwallet.red.QWRedConfig;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;

public class xdj
  implements Runnable
{
  public xdj(QWRedConfig paramQWRedConfig) {}
  
  public void run()
  {
    synchronized (QWRedConfig.access$000(this.a))
    {
      QWalletTools.a(this.a, QWRedConfig.access$100(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdj
 * JD-Core Version:    0.7.0.1
 */