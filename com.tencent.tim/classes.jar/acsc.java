import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class acsc
  implements tnv.a
{
  acsc(acsb paramacsb, MessageRecord paramMessageRecord, boolean paramBoolean, msg_svc.PbSendMsgReq paramPbSendMsgReq) {}
  
  public ToServiceMsg a()
  {
    long l = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = acsb.a(this.this$0).createToServiceMsg("MessageSvc.PbMultiMsgSend");
    localToServiceMsg.extraData.putLong("uniseq", this.a.uniseq);
    localToServiceMsg.extraData.putInt("msgtype", this.a.msgtype);
    localToServiceMsg.extraData.putBoolean(anbb.ccQ, this.bJX);
    localToServiceMsg.extraData.putLong("key_msg_info_time_start", l);
    localToServiceMsg.putWupBuffer(this.b.toByteArray());
    localToServiceMsg.setTimeout(15000L);
    localToServiceMsg.setEnableFastResend(true);
    if (QLog.isColorLevel())
    {
      int i = anbk.ab(this.a.msgUid);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, "sendBlessMsg,  mr_uniseq:" + this.a.uniseq + " msgSeq:" + this.a.msgseq + " mr_shMsgseq:" + this.a.shmsgseq + " mr_msgUid:" + this.a.msgUid + " random:" + i + " isRedBagVideo:" + this.bJX);
    }
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsc
 * JD-Core Version:    0.7.0.1
 */