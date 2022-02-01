import android.os.Handler;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import tencent.im.oidb.cmd0x79a.oidb_0x79a.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class vzo
  implements jrs.a
{
  public vzo(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a(oidb_0x79a.RspBody paramRspBody)
  {
    oidb_0x88d.GroupInfo localGroupInfo = paramRspBody.info;
    this.this$0.stopTitleProgress();
    this.this$0.a.tribeStatus = paramRspBody.uint32_tribe_status.get();
    this.this$0.a.modifyCount = paramRspBody.uint32_modify_countdown.get();
    int j = 0;
    int i;
    if (4 != this.this$0.a.troopTypeExt)
    {
      i = j;
      if (3 != this.this$0.a.troopTypeExt) {}
    }
    else
    {
      i = j;
      if (localGroupInfo != null) {
        if (4 != localGroupInfo.uint32_group_type_flag.get())
        {
          i = j;
          if (3 != localGroupInfo.uint32_group_type_flag.get()) {}
        }
        else
        {
          this.this$0.a(localGroupInfo);
          i = 1;
        }
      }
    }
    if ((this.this$0.a.tribeStatus == 1) || (this.this$0.a.tribeStatus == 2) || (this.this$0.a.tribeStatus == 3))
    {
      this.this$0.a.tribeId = paramRspBody.uint64_tribe_id.get();
      this.this$0.Hf = this.this$0.a.tribeId;
      this.this$0.a.tribeName = paramRspBody.str_tribe_name.get();
      if (i == 0) {
        this.this$0.a(localGroupInfo);
      }
      this.this$0.handler.sendEmptyMessage(7);
      return;
    }
    if ((this.this$0.b.dwAppPrivilegeFlag & 0x4000) != 0L)
    {
      TroopInfoActivity.h(this.this$0);
      return;
    }
    this.this$0.handler.sendEmptyMessage(8);
  }
  
  public void onFailed()
  {
    this.this$0.stopTitleProgress();
    if ((this.this$0.b.dwAppPrivilegeFlag & 0x4000) != 0L) {
      TroopInfoActivity.h(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzo
 * JD-Core Version:    0.7.0.1
 */