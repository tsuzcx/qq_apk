import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa48.oidb_0xa48.RspBody;
import tencent.im.oidb.cmd0xa48.oidb_0xa48.SendItem;
import tencent.im.oidb.cmd0xa48.oidb_0xa48.SendListRsp;

class apti
  extends jnm.c
{
  apti(apsz paramapsz, apsy paramapsy) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int j = 0;
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "requestGiftMemberList. onResult error=" + paramInt + " data=" + paramArrayOfByte);
      }
      this.a.onError(paramInt, "");
      return;
    }
    paramBundle = new oidb_0xa48.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new long[paramBundle.msg_send_list_rsp.rpt_today_birth.size()];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        paramArrayOfByte[i] = ((oidb_0xa48.SendItem)paramBundle.msg_send_list_rsp.rpt_today_birth.get(i)).uint64_uin.get();
        i += 1;
      }
      long[] arrayOfLong1 = new long[paramBundle.msg_send_list_rsp.rpt_send_gift.size()];
      i = 0;
      while (i < arrayOfLong1.length)
      {
        arrayOfLong1[i] = ((oidb_0xa48.SendItem)paramBundle.msg_send_list_rsp.rpt_send_gift.get(i)).uint64_uin.get();
        i += 1;
      }
      long[] arrayOfLong2 = new long[paramBundle.msg_send_list_rsp.rpt_recv_gift.size()];
      i = j;
      while (i < arrayOfLong2.length)
      {
        arrayOfLong2[i] = ((oidb_0xa48.SendItem)paramBundle.msg_send_list_rsp.rpt_recv_gift.get(i)).uint64_uin.get();
        i += 1;
      }
      this.a.a(paramArrayOfByte, arrayOfLong1, arrayOfLong2);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "requestGiftMemberList. error=" + QLog.getStackTraceString(paramArrayOfByte));
      }
      this.a.onError(paramInt, "InvalidProtocolBufferMicroException");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apti
 * JD-Core Version:    0.7.0.1
 */