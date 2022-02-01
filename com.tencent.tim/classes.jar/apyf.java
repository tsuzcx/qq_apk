import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

class apyf
  extends apsy
{
  apyf(apxr paramapxr, MessageForDeliverGiftTips paramMessageForDeliverGiftTips) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInteractGiftAnimationController", 2, "checkInteract: errorCode = " + paramInt);
    }
    this.a.interactState = paramRspBody.uint32_play_state.get();
    this.a.alreadyPlayMicroseconds = paramRspBody.uint64_already_pay_microseconds.get();
    this.a.playTotalMicroseconds = paramRspBody.uint64_play_total_microseconds.get();
    if ((this.a.interactState == 2) && (paramRspBody.msg_finish_info.has()))
    {
      paramRspBody = (oidb_0x962.FinishInfo)paramRspBody.msg_finish_info.get();
      this.a.interactText = paramRspBody.bytes_text.get().toStringUtf8();
      this.a.participateNum = paramRspBody.uint32_participate_num.get();
      this.a.interactFirstUin = paramRspBody.uint64_first_uin.get();
      this.a.interactFirstNickname = paramRspBody.bytes_first_nick_name.get().toStringUtf8();
      this.a.interacEndtUrl = paramRspBody.bytes_url.get().toStringUtf8();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyf
 * JD-Core Version:    0.7.0.1
 */