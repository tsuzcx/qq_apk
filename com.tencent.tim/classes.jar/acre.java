import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class acre
  implements tnv.a
{
  acre(acrc paramacrc, String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = acrc.b(this.a).createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putString("uin", this.Lw);
    localToServiceMsg.extraData.putByte("cmd", (byte)0);
    localToServiceMsg.extraData.putByte("keyType", (byte)0);
    localToServiceMsg.extraData.putByte("sendType", (byte)0);
    localToServiceMsg.extraData.putInt("busiType", 1025);
    localToServiceMsg.extraData.putString("toUin", this.Lw);
    localToServiceMsg.extraData.putLong("sessionid", this.Rm);
    localToServiceMsg.extraData.putInt("random", this.czl);
    localToServiceMsg.extraData.putLong("msgsize", 0L);
    localToServiceMsg.addAttribute("_tag_LOGSTR", String.valueOf(this.Rn));
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 9);
    localToServiceMsg.extraData.putInt("transC2CCmd", this.czk);
    anbn localanbn = new anbn();
    localanbn.dEY = this.czk;
    localanbn.msg = this.cV;
    localToServiceMsg.putWupBuffer(anbh.a(acrc.b(this.a), 9, this.Lw, localanbn, this.Rn, this.czl).toByteArray());
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acre
 * JD-Core Version:    0.7.0.1
 */