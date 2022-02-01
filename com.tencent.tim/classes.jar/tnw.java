import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

class tnw
  implements tnv.a
{
  tnw(tnv paramtnv, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.this$0.a.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
    localToServiceMsg.putWupBuffer(this.a.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tnw
 * JD-Core Version:    0.7.0.1
 */