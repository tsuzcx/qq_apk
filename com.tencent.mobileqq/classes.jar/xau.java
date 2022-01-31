import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.app.QQAppInterface;

public final class xau
  implements Runnable
{
  public xau(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QWalletPushManager.a(this.a)) {
      QWalletPushManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xau
 * JD-Core Version:    0.7.0.1
 */