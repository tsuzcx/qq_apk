import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.BaseMessageProcessor.RequestBuilder;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

public class czz
  implements BaseMessageProcessor.RequestBuilder
{
  public czz(OfflineFileMessageProcessor paramOfflineFileMessageProcessor, String paramString, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor.a.a("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.extraData.putLong("uniseq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.uniseq);
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putString("uuid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.uuid);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.busiType);
    localToServiceMsg.extraData.putString("toUin", this.jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putLong("queueSeq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.queueSeq);
    localToServiceMsg.extraData.putLong("sessionid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.sessionId);
    localToServiceMsg.extraData.putInt("random", MessageUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgUid));
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgSeq));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.jdField_a_of_type_Int);
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.subCmd;
    localTransMsgContext.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localToServiceMsg.putWupBuffer(MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOfflineFileMessageProcessor.a, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int, this.c, localTransMsgContext, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgSeq, MessageUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgUid)).toByteArray());
    localToServiceMsg.extraData.putLong(FileTransferObserver.class.getName(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.observerSeq);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     czz
 * JD-Core Version:    0.7.0.1
 */