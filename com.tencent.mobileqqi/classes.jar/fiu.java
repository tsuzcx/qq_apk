import android.os.Bundle;
import com.tencent.mobileqq.app.message.BaseMessageProcessor;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class fiu
  extends SendMessageHandler.SendMessageRunnable
{
  public fiu(BaseMessageProcessor paramBaseMessageProcessor, fiv paramfiv, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_Fiv.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "prepareRetryRunnable cmd=" + localToServiceMsg.getServiceCmd() + ",reqSeq=" + this.jdField_a_of_type_Long);
    }
    localToServiceMsg.extraData.putLong("timeOut", this.e);
    localToServiceMsg.extraData.putLong("startTime", this.jdField_b_of_type_Long);
    localToServiceMsg.extraData.putInt("retryIndex", this.jdField_a_of_type_Int);
    localToServiceMsg.setTimeout(this.e);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageProcessor.a(localToServiceMsg, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fiu
 * JD-Core Version:    0.7.0.1
 */