import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;

public abstract class xaw
  extends mxj
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, null);
      return;
    }
    paramBundle = new oidb_0x6d6.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d6.MoveFileRspBody)paramBundle.move_file_rsp.get();
      if (!paramArrayOfByte.int32_ret_code.has()) {
        break label94;
      }
      if (paramArrayOfByte.int32_ret_code.get() == 0)
      {
        a(true, 0, paramArrayOfByte.str_parent_folder_id.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, -1, null);
      return;
    }
    a(false, paramArrayOfByte.int32_ret_code.get(), null);
    return;
    label94:
    a(false, -1, null);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xaw
 * JD-Core Version:    0.7.0.1
 */