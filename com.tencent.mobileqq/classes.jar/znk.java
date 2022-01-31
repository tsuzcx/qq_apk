import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

public class znk
  extends SendMessageHandler.SendMessageRunnable
{
  public znk(MessageHandler paramMessageHandler, msg_svc.PbSendMsgReq paramPbSendMsgReq, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "sendReceiptMessageRead.prepareRetryRunnable: " + this.c + " / " + this.b);
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.PbReceiptRead", null);
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgReq.toByteArray());
    localToServiceMsg.extraData.putLong("msgSeq", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putInt("msgtype", 1);
    localToServiceMsg.extraData.putString("uin", Long.toString(this.jdField_a_of_type_Long));
    localToServiceMsg.extraData.putLong("timeOut", this.c);
    localToServiceMsg.extraData.putInt("retryIndex", this.b);
    localToServiceMsg.setTimeout(this.c);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znk
 * JD-Core Version:    0.7.0.1
 */