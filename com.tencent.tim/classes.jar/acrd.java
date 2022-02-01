import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class acrd
  implements tnv.a
{
  acrd(acrc paramacrc, String paramString, FMTransC2CMsgInfo paramFMTransC2CMsgInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = acrc.a(this.jdField_a_of_type_Acrc).createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.Lw);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.extraData.putLong("uniseq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.uniseq);
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putString("uuid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.uuid);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.busiType);
    localToServiceMsg.extraData.putString("toUin", this.Lw);
    localToServiceMsg.extraData.putLong("queueSeq", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.queueSeq);
    localToServiceMsg.extraData.putLong("sessionid", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.sessionId);
    localToServiceMsg.extraData.putInt("random", anbk.ac(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgUid));
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgSeq));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.czk);
    anbn localanbn = new anbn();
    localanbn.dEY = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.subCmd;
    localanbn.msg = this.cV;
    msg_svc.PbSendMsgReq localPbSendMsgReq = anbh.a(acrc.a(this.jdField_a_of_type_Acrc), 13, this.Lw, localanbn, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgSeq, anbk.ac(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.msgUid));
    acrc.a(this.jdField_a_of_type_Acrc, localPbSendMsgReq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo);
    acrc.a(this.jdField_a_of_type_Acrc, localPbSendMsgReq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo, localanbn);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.entity != null) {
      localToServiceMsg.extraData.putLong("tmpSessionType", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.entity.tmpSessionType);
    }
    localToServiceMsg.putWupBuffer(localPbSendMsgReq.toByteArray());
    localToServiceMsg.extraData.putLong(agie.class.getName(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFMTransC2CMsgInfo.observerSeq);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrd
 * JD-Core Version:    0.7.0.1
 */