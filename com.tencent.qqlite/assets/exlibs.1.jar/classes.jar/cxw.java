import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.AccostMessageProcessor;
import com.tencent.mobileqq.app.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class cxw
  implements BaseMessageProcessor.RequestBuilder
{
  public cxw(AccostMessageProcessor paramAccostMessageProcessor, byte[] paramArrayOfByte, int paramInt) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageAccostMessageProcessor.a.a("MessageSvc.GetMsgV4");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "--->getC2CMessage cChannel: 4vCookies: " + this.jdField_a_of_type_ArrayOfByte + ",cSyncFlag:" + this.jdField_a_of_type_Int);
    }
    localToServiceMsg.extraData.putByte("cChannel", (byte)4);
    localToServiceMsg.extraData.putByteArray("vCookies", this.jdField_a_of_type_ArrayOfByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putByte("onlineSyncFlag", (byte)1);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cxw
 * JD-Core Version:    0.7.0.1
 */