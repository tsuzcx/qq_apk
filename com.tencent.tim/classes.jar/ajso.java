import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.a;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.b;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class ajso
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajso(GameRoomInviteActivity paramGameRoomInviteActivity, GameRoomInviteActivity.a parama) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody != null))
    {
      paramRspBody = this.a;
      if (!this.a.isPrepared)
      {
        bool = true;
        paramRspBody.isPrepared = bool;
        this.this$0.refreshUI();
        this.this$0.a.notifyDataSetChanged();
      }
    }
    while (paramRspBody == null) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    this.this$0.a(paramInt, paramRspBody, acfp.m(2131706834));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajso
 * JD-Core Version:    0.7.0.1
 */