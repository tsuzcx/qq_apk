import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class enr
  implements BaseMessageProcessor.RequestBuilder
{
  public enr(TroopMessageProcessor paramTroopMessageProcessor, long paramLong1, long paramLong2) {}
  
  public ToServiceMsg a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "<ReadReport><S>_Group_gprUin:" + this.jdField_a_of_type_Long + " lastReadSeq:" + this.b);
    }
    ToServiceMsg localToServiceMsg = TroopMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor).a("MessageSvc.GroupMsgReadConfirm");
    localToServiceMsg.extraData.putLong("groupuin", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putLong("lastReadSeq", this.b);
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     enr
 * JD-Core Version:    0.7.0.1
 */