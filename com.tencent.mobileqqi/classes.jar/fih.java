import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class fih
  extends SendMessageHandler.SendMessageRunnable
{
  public fih(MessageHandler paramMessageHandler, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<ReadReport><S>_Group_gprUin:" + this.jdField_a_of_type_Long + " lastReadSeq:" + this.b + " reqSeq:" + this.c);
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.GroupMsgReadConfirm");
    localToServiceMsg.extraData.putLong("groupuin", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putLong("lastReadSeq", this.b);
    localToServiceMsg.extraData.putLong("timeOut", this.e);
    localToServiceMsg.extraData.putLong("startTime", this.d);
    localToServiceMsg.extraData.putInt("retryIndex", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putLong("msgSeq", this.c);
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.setTimeout(this.e);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fih
 * JD-Core Version:    0.7.0.1
 */