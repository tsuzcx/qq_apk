import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdad.cmd0xdad.RspBody;

class aptg
  extends jnm.c
{
  aptg(apsz paramapsz, apsy paramapsy, sne paramsne) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0xdad. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.a);
      }
      if (this.a != null)
      {
        if (paramArrayOfByte != null) {
          paramBundle = new cmd0xdad.RspBody();
        }
      }
      else {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = paramBundle.errmsg.get();
          this.a.aU(paramInt, paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0xdad. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
          }
          this.a.onError(-1, "InvalidProtocolBufferMicroException");
          return;
        }
      }
      this.a.onError(paramInt, "sso request error or callback is null.");
      return;
    }
    cmd0xdad.RspBody localRspBody;
    try
    {
      localRspBody = new cmd0xdad.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      paramInt = (int)localRspBody.retcode.get();
      if ((paramInt == 0) && (paramBundle != null))
      {
        this.a.yH(this.d.bxW);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
      }
      this.a.onError(-1, "InvalidProtocolBufferMicroException");
      return;
    }
    paramArrayOfByte = localRspBody.errmsg.get();
    this.a.aU(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptg
 * JD-Core Version:    0.7.0.1
 */