import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.C2CMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class zzc
  implements Runnable
{
  public zzc(C2CMessageManager paramC2CMessageManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getLogColorContent());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageManager.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zzc
 * JD-Core Version:    0.7.0.1
 */