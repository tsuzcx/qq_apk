import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class zpd
  implements Runnable
{
  public zpd(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getLogColorContent() + " holdFlag: " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a.a().e(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a();
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a.a().e(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L - (l1 - l2));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a.a().e(null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a.a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, UncommonMessageProcessor.e, UncommonMessageProcessor.n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zpd
 * JD-Core Version:    0.7.0.1
 */