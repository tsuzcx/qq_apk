import android.app.NotificationManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.util.QLog;

public class fdr
  implements Runnable
{
  public fdr(MessageHandler paramMessageHandler, NotificationManager paramNotificationManager) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "PConline time expired cancel now");
      }
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(MessageHandler.bO);
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, false);
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, null);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "PConline thread Interrupt");
      }
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdr
 * JD-Core Version:    0.7.0.1
 */