import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class ajsg
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajsg(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      GameRoomInviteActivity localGameRoomInviteActivity = this.this$0;
      String str = paramRspBody.string_invite_id.get().toStringUtf8();
      localGameRoomInviteActivity.OG = str;
      GameRoomInviteActivity.bSp = str;
      this.this$0.mOwnerUin = paramRspBody.uint64_leader_uin.get();
      this.this$0.dzd();
      aqmj.a(this.this$0, this.this$0.app.getCurrentAccountUin(), true, System.currentTimeMillis());
      if ((this.this$0.adj > 0L) && (this.this$0.cpZ)) {
        GameRoomInviteActivity.a(this.this$0, "" + this.this$0.adj, 1);
      }
      return;
    }
    this.this$0.a(paramInt, paramRspBody, (String)GameRoomInviteActivity.cY.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsg
 * JD-Core Version:    0.7.0.1
 */