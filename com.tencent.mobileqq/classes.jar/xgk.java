import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.app.QQAppInterface;

public final class xgk
  implements Runnable
{
  public xgk(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QWalletPushManager.a(this.a)) {
      QWalletPushManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgk
 * JD-Core Version:    0.7.0.1
 */