import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;

public class fkb
  implements fiw
{
  public fkb(SystemMessageProcessor paramSystemMessageProcessor, long paramLong1, long paramLong2, structmsg.ReqSystemMsgRead paramReqSystemMsgRead) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageSystemMessageProcessor.a.a("ProfileService.Pb.ReqSystemMsgRead");
    localToServiceMsg.extraData.putLong("latestFriendSeq", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putLong("latestGroupSeq", this.b);
    localToServiceMsg.extraData.putLong("type", 1L);
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$ReqSystemMsgRead.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fkb
 * JD-Core Version:    0.7.0.1
 */