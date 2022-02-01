import android.text.TextUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class ajsv
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajsv(GameRoomInviteActivity paramGameRoomInviteActivity, boolean paramBoolean) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      this.this$0.OG = paramRspBody.string_invite_id.get().toStringUtf8();
      GameRoomInviteActivity.bSp = this.this$0.OG;
      this.this$0.init(false);
      return;
    }
    paramRspBody = this.this$0;
    GameRoomInviteActivity.bSp = null;
    paramRspBody.OG = null;
    this.this$0.ni = true;
    if (this.cqd)
    {
      this.this$0.dzb();
      return;
    }
    this.this$0.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsv
 * JD-Core Version:    0.7.0.1
 */