import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

public class fji
  implements fiv
{
  public fji(OfflineFileMessageProcessor paramOfflineFileMessageProcessor, String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putByte("sendType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", 1025);
    localToServiceMsg.extraData.putString("toUin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("sessionid", this.jdField_a_of_type_Long);
    localToServiceMsg.extraData.putInt("random", this.jdField_a_of_type_Int);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.jdField_b_of_type_Long));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 9);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.jdField_b_of_type_Int);
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    localTransMsgContext.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localToServiceMsg.putWupBuffer(MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 9, this.jdField_a_of_type_JavaLangString, localTransMsgContext, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int).toByteArray());
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fji
 * JD-Core Version:    0.7.0.1
 */