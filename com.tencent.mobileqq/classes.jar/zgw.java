import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class zgw
  implements Runnable
{
  public zgw(MessageHandler paramMessageHandler, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MsgSend", 4, "delay notify: " + MessageHandler.d);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(8022, true, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zgw
 * JD-Core Version:    0.7.0.1
 */