import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class zkw
  implements Runnable
{
  public zkw(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QQAppInterface.k(this.a).unregisterReceiver(QQAppInterface.a(this.a));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkw
 * JD-Core Version:    0.7.0.1
 */