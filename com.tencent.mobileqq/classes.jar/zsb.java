import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import tencent.im.cs.group_file_common.group_file_common.FeedsResult;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.RspBody;

public abstract class zsb
  extends nmf
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    b(paramInt, paramArrayOfByte, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle);
  
  protected void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int j = 102;
    if (paramInt != 0)
    {
      a(false, paramInt, "", 102, 0, paramBundle);
      return;
    }
    Object localObject = new oidb_0x6d9.RspBody();
    int k;
    try
    {
      ((oidb_0x6d9.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((oidb_0x6d9.RspBody)localObject).feeds_info_rsp.has())
      {
        a(false, paramInt, "", 102, 0, paramBundle);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        a(false, paramInt, "", 102, 0, paramBundle);
      }
      localObject = (oidb_0x6d9.FeedsRspBody)((oidb_0x6d9.RspBody)localObject).feeds_info_rsp.get();
      if (!((oidb_0x6d9.FeedsRspBody)localObject).int32_ret_code.has())
      {
        a(false, paramInt, "", 102, 0, paramBundle);
        return;
      }
      k = ((oidb_0x6d9.FeedsRspBody)localObject).int32_ret_code.get();
      paramArrayOfByte = ((oidb_0x6d9.FeedsRspBody)localObject).str_client_wording.get();
      i = j;
      if (!((oidb_0x6d9.FeedsRspBody)localObject).rpt_feeds_result_list.has()) {
        break label236;
      }
    }
    localObject = (group_file_common.FeedsResult)((oidb_0x6d9.FeedsRspBody)localObject).rpt_feeds_result_list.get().get(0);
    int i = j;
    if (localObject != null)
    {
      paramInt = j;
      if (((group_file_common.FeedsResult)localObject).uint32_bus_id.has()) {
        paramInt = ((group_file_common.FeedsResult)localObject).uint32_bus_id.get();
      }
      i = paramInt;
      if (!((group_file_common.FeedsResult)localObject).uint32_dead_time.has()) {}
    }
    for (i = ((group_file_common.FeedsResult)localObject).uint32_dead_time.get();; i = j)
    {
      a(true, k, paramArrayOfByte, paramInt, i, paramBundle);
      return;
      label236:
      j = 0;
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsb
 * JD-Core Version:    0.7.0.1
 */