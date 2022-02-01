import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.RspBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.SendFlowerRsp;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ThrowFlowerRsp;

class apta
  extends jnm.c
{
  apta(apsz paramapsz, apsy paramapsy) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.a);
      }
      if (this.a != null)
      {
        if (paramArrayOfByte != null) {
          paramBundle = new oidb_0x6b6.RspBody();
        }
      }
      else {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = paramBundle.bytes_error_notify.get().toStringUtf8();
          this.a.aU(paramInt, paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
          }
          this.a.onError(-1, "InvalidProtocolBufferMicroException");
          return;
        }
      }
      this.a.onError(paramInt, "sso request error or callback is null.");
      return;
    }
    oidb_0x6b6.RspBody localRspBody;
    try
    {
      localRspBody = new oidb_0x6b6.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      paramInt = localRspBody.int32_ret.get();
      if ((paramInt != 0) || (paramBundle == null)) {
        break label354;
      }
      paramInt = paramBundle.getInt("subCmd");
      if (localRspBody.msg_send_flower.has())
      {
        paramArrayOfByte = (oidb_0x6b6.SendFlowerRsp)localRspBody.msg_send_flower.get();
        this.a.yH(paramArrayOfByte.uint32_product_id.get());
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
    if (localRspBody.msg_throw_flower.has())
    {
      paramArrayOfByte = (oidb_0x6b6.ThrowFlowerRsp)localRspBody.msg_throw_flower.get();
      this.a.yI(paramArrayOfByte.uint32_product_id.get());
      return;
    }
    this.a.onError(-1, "Invalid RspData. subCmd:" + paramInt);
    return;
    label354:
    paramArrayOfByte = localRspBody.bytes_error_notify.get().toStringUtf8();
    this.a.aU(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apta
 * JD-Core Version:    0.7.0.1
 */