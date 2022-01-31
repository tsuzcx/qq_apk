import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class zew
  implements WerewolvesHandler.Callback
{
  public zew(HotChatHandler paramHotChatHandler) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      paramRspBody = paramRspBody.string_invite_id.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramRspBody))
      {
        com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.a = paramRspBody;
        GameRoomAVController.a().a(0, paramRspBody, 0L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zew
 * JD-Core Version:    0.7.0.1
 */