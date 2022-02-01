import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DeleteFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;

public abstract class zrq
  extends nmf
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    b(paramInt, paramArrayOfByte, paramBundle);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2);
  
  protected void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, paramBundle, "", amtj.a(2131714387));
      return;
    }
    oidb_0x6d6.RspBody localRspBody = new oidb_0x6d6.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d6.DeleteFileRspBody)localRspBody.delete_file_rsp.get();
      if (!paramArrayOfByte.int32_ret_code.has()) {
        break label133;
      }
      if (paramArrayOfByte.int32_ret_code.get() == 0)
      {
        a(true, 0, paramBundle, paramArrayOfByte.str_ret_msg.get(), paramArrayOfByte.str_client_wording.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, -1, paramBundle, "", amtj.a(2131714383));
      return;
    }
    a(false, paramArrayOfByte.int32_ret_code.get(), paramBundle, paramArrayOfByte.str_ret_msg.get(), paramArrayOfByte.str_client_wording.get());
    return;
    label133:
    a(false, -1, paramBundle, "", amtj.a(2131714391));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zrq
 * JD-Core Version:    0.7.0.1
 */