import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.CreateFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RspBody;

public abstract class wlp
  extends mmn
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, null);
      return;
    }
    paramBundle = new oidb_0x6d7.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d7.CreateFolderRspBody)paramBundle.create_folder_rsp.get();
      if (!paramArrayOfByte.int32_ret_code.has()) {
        break label104;
      }
      if (paramArrayOfByte.int32_ret_code.get() == 0)
      {
        a(true, 0, new ayoq((group_file_common.FolderInfo)paramArrayOfByte.folder_info.get()));
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
    label104:
    a(false, -1, null);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, ayoq paramayoq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wlp
 * JD-Core Version:    0.7.0.1
 */