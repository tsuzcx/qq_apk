import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.GiftBagInfo;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.Player;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.RspBody;

class apte
  extends jnm.c
{
  apte(apsz paramapsz, apsy paramapsy, String paramString1, String paramString2) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null) || (this.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6c2. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.a);
      }
      if (this.a != null) {
        this.a.onError(paramInt, "sso request error or callback is null.");
      }
      return;
    }
    oidb_0x6c2.RspBody localRspBody;
    try
    {
      localRspBody = new oidb_0x6c2.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      paramInt = localRspBody.uint32_result.get();
      if ((paramInt != 0) || (paramBundle == null)) {
        break label357;
      }
      paramInt = paramBundle.getInt("subCmd");
      if ((paramInt == 0) && (localRspBody.msg_gift_bag_info.has()))
      {
        paramBundle = (oidb_0x6c2.GiftBagInfo)localRspBody.msg_gift_bag_info.get();
        paramArrayOfByte = null;
        if (localRspBody.msg_winner.has()) {
          paramArrayOfByte = (oidb_0x6c2.Player)localRspBody.msg_winner.get();
        }
        paramBundle = new TroopGiftBagInfo(paramBundle, paramArrayOfByte);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte = this.Uf + "_" + this.crd;
          this.b.iT.put(paramArrayOfByte, paramBundle);
          this.b.a(paramBundle);
        }
        this.a.a(paramBundle);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6c2. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
      }
      this.a.onError(-1, "InvalidProtocolBufferMicroException");
      return;
    }
    if ((paramInt == 1) && (localRspBody.int32_player.has()))
    {
      paramInt = localRspBody.int32_player.get();
      this.a.Xa(paramInt);
      return;
    }
    this.a.onError(-1, "Invalid RspData. subCmd:" + paramInt);
    return;
    label357:
    paramArrayOfByte = localRspBody.bytes_errmsg.get().toStringUtf8();
    this.a.onError(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apte
 * JD-Core Version:    0.7.0.1
 */