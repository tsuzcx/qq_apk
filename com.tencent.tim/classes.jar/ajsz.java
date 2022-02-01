import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class ajsz
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajsz(GameRoomInviteActivity paramGameRoomInviteActivity, ardq paramardq) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      GameRoomInviteActivity localGameRoomInviteActivity = this.this$0;
      if ((!paramRspBody.uint64_leader_uin.has()) || (paramRspBody.uint64_leader_uin.get() == this.this$0.app.getLongAccountUin())) {}
      for (boolean bool = true;; bool = false)
      {
        localGameRoomInviteActivity.j(bool, paramRspBody.string_invite_id.get().toStringUtf8(), null, acfp.m(2131706805));
        return;
      }
    }
    this.c.b(this.this$0.dkT, this.this$0.dkU, new ajta(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsz
 * JD-Core Version:    0.7.0.1
 */