import com.tencent.av.service.AVPbInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.util.QLog;

class ancg
  implements iuq.a
{
  ancg(ancf paramancf, byte[] paramArrayOfByte, long paramLong1, MessageHandler paramMessageHandler, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean) {}
  
  public void a(iuq paramiuq)
  {
    AVPbInfo localAVPbInfo = paramiuq.a(this.fw);
    if (localAVPbInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("decodeC2CMsgPkg_QCall", 2, "ret, bindId:" + localAVPbInfo.bindId + ", bindIdType:" + localAVPbInfo.bindIdType + ", phoneNum:" + localAVPbInfo.phoneNum);
      }
      if (!imm.isSupportSharpAudio()) {
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "Discard video message cause device not support");
        }
      }
    }
    for (;;)
    {
      paramiuq.dT();
      return;
      if (this.akB >= 60L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "Discard video message because of time out " + this.akB + " s");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "===========handleSharpVideoMessageResp 1234========");
        }
        this.b.a(this.akC, this.fw, this.eQ, (int)this.Wc, this.cEQ);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "ret, decode failed!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ancg
 * JD-Core Version:    0.7.0.1
 */