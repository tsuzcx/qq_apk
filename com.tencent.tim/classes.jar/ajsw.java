import android.text.TextUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class ajsw
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajsw(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      this.this$0.OG = paramRspBody.string_invite_id.get().toStringUtf8();
      GameRoomInviteActivity.bSp = this.this$0.OG;
    }
    for (;;)
    {
      this.this$0.init(true);
      return;
      paramRspBody = this.this$0;
      GameRoomInviteActivity.bSp = null;
      paramRspBody.OG = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsw
 * JD-Core Version:    0.7.0.1
 */