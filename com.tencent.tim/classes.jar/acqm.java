import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class acqm
  implements tnv.a
{
  acqm(acql paramacql, byte[] paramArrayOfByte, int paramInt) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = acql.a(this.a).createToServiceMsg("MessageSvc.GetMsgV4");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "--->getC2CMessage cChannel: 4vCookies: " + this.cU + ",cSyncFlag:" + this.czg);
    }
    localToServiceMsg.extraData.putByte("cChannel", (byte)4);
    localToServiceMsg.extraData.putByteArray("vCookies", this.cU);
    localToServiceMsg.extraData.putInt("cSyncFlag", this.czg);
    localToServiceMsg.extraData.putByte("onlineSyncFlag", (byte)1);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqm
 * JD-Core Version:    0.7.0.1
 */