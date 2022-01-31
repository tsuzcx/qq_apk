import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public class ctu
  extends SendMessageHandler.SendMessageRunnable
{
  public ctu(MessageHandler paramMessageHandler, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("PbMessageSvc.PbMsgReadedReport");
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbMsgReadedReportReq.toByteArray());
    localToServiceMsg.extraData.putLong("timeOut", this.c);
    localToServiceMsg.extraData.putLong("startTime", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putInt("retryIndex", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putLong("msgSeq", this.b);
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.setTimeout(this.c);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ctu
 * JD-Core Version:    0.7.0.1
 */