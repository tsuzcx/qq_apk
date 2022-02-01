import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class ajtj
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajtj(GameRoomTransActivity paramGameRoomTransActivity, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      String str = paramRspBody.string_invite_id.get().toStringUtf8();
      this.a.dialog = ajtk.a(this.a, str, paramRspBody.uint32_max_member_num.get(), this.adk);
      this.a.dialog.setOnDismissListener(this.a.j);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "invitedId empty");
    }
    paramRspBody = new Intent(this.a, GameRoomInviteActivity.class);
    paramRspBody.putExtra("roomNum", this.dkX);
    paramRspBody.putExtra("zoneId", this.dkY);
    paramRspBody.putExtra("gc", this.adk);
    this.a.startActivity(paramRspBody);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtj
 * JD-Core Version:    0.7.0.1
 */