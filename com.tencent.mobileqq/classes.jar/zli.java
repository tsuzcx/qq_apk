import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.qphone.base.util.QLog;

public class zli
  implements Runnable
{
  public zli(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QNotificationManager localQNotificationManager = new QNotificationManager(QQAppInterface.e(this.a));
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 121);
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 122);
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 123);
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 129);
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 135);
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 140);
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 144);
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 193);
      localQNotificationManager.cancel("QQAppInterface_removeNotification", 211);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "removeNotification");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("notification", 2, "removeNotification", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zli
 * JD-Core Version:    0.7.0.1
 */