import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import msf.msgsvc.msg_svc.PbSendMsgReq;

public class fdo
  extends SendMessageHandler.SendMessageRunnable
{
  public fdo(MessageHandler paramMessageHandler, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, BusinessObserver paramBusinessObserver) {}
  
  public void run()
  {
    MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgReq, this.e, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdo
 * JD-Core Version:    0.7.0.1
 */