import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

public class znu
  extends SendMessageHandler.SendMessageRunnable
{
  public znu(MessageHandler paramMessageHandler, msg_svc.PbSendMsgReq paramPbSendMsgReq, int paramInt, long paramLong) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.PbReceiptRead", null);
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgReq.toByteArray());
    localToServiceMsg.extraData.putLong("msgSeq", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putInt("msgtype", 2);
    localToServiceMsg.extraData.putString("uin", Long.toString(this.jdField_a_of_type_Long));
    localToServiceMsg.extraData.putLong("timeOut", this.c);
    localToServiceMsg.extraData.putInt("retryIndex", this.b);
    localToServiceMsg.setTimeout(this.c);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znu
 * JD-Core Version:    0.7.0.1
 */