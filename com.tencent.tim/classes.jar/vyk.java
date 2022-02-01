import android.os.Bundle;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import tencent.im.oidb.cmd0x72d.cmd0x72d.RspBody;

public class vyk
  extends jnm.d
{
  public vyk(TroopAssistantActivity paramTroopAssistantActivity, aizp paramaizp) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    try
    {
      this.a.m(this.this$0.app, 0L);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    paramBundle = new cmd0x72d.RspBody();
    paramBundle.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = paramBundle.rpt_uint64_groupcode.get();
    if (paramBundle.opt_uint32_ret_code.get() == 0)
    {
      this.a.m(this.this$0.app, paramBundle.opt_uint64_timestamp.get());
      if ((paramArrayOfByte.size() > 0) && (this.this$0.a != null))
      {
        this.this$0.rk = paramArrayOfByte;
        this.this$0.a.cS(paramArrayOfByte);
        return;
      }
      TroopAssistantActivity.a(this.this$0);
      return;
    }
    this.a.m(this.this$0.app, 0L);
    TroopAssistantActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyk
 * JD-Core Version:    0.7.0.1
 */