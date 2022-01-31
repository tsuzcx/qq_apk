import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.qphone.base.util.QLog;

public class zdg
  implements Runnable
{
  public zdg(MessageHandler paramMessageHandler, QNotificationManager paramQNotificationManager) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "IPADonline time expired cancel now");
      }
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel("Q.msg.MessageHandler_IpadOnlineNotifition", MessageHandler.h);
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.MessageHandler", 2, "IPADonline thread Interrupt");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdg
 * JD-Core Version:    0.7.0.1
 */