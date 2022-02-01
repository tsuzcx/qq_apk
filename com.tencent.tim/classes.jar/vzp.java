import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.List;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.GbarInfo;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.RspBody;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.RspInfo;

public class vzp
  extends jnm.d
{
  public vzp(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    for (;;)
    {
      return;
      try
      {
        paramBundle = new oidb_cmd0x6f6.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = paramBundle.rpt_msg_rsp_info.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          paramArrayOfByte = (oidb_cmd0x6f6.RspInfo)paramArrayOfByte.get(0);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_result.get() == 0))
          {
            this.this$0.a.tribeId = paramArrayOfByte.stgbarinfo.uint32_bid.get();
            this.this$0.Hf = this.this$0.a.tribeId;
            this.this$0.a.tribeName = paramArrayOfByte.stgbarinfo.str_name.get().toStringUtf8();
            this.this$0.handler.sendEmptyMessage(7);
            return;
          }
        }
      }
      catch (Exception paramArrayOfByte) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzp
 * JD-Core Version:    0.7.0.1
 */