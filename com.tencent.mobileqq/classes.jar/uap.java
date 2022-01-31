import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.RspBody;

class uap
  extends ProtoUtils.TroopProtocolObserver
{
  uap(uao paramuao) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramBundle = new oidb_cmd0x74f.RspBody();
          paramBundle.mergeFrom(paramArrayOfByte);
          if ((paramBundle.uint32_ret_code.get() == 0) && (paramBundle.bool_display_entrance.get()))
          {
            TroopMemberListActivity.a(this.a.a, paramBundle.range.get());
            TroopMemberListActivity.c(this.a.a);
            TroopMemberListActivity.a(this.a.a, paramBundle.uint64_next_pull_time.get());
            return;
          }
        }
        catch (Exception paramArrayOfByte) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemberListActivityget_troop_member", 2, "initListView, get0x74f：failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uap
 * JD-Core Version:    0.7.0.1
 */