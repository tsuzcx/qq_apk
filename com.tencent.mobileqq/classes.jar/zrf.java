import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class zrf
  extends SendMessageHandler.SendMessageRunnable
{
  public zrf(UncommonMessageProcessor paramUncommonMessageProcessor, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.setTimeout(this.c);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putInt("retryIndex", this.b);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putLong("timeOut", this.c);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageUncommonMessageProcessor.a.c(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrf
 * JD-Core Version:    0.7.0.1
 */