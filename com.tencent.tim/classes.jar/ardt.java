import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class ardt
  implements ardq.a<oidb_0x8ed.RspBody>
{
  ardt(ardq paramardq, ardq.a parama1, HotChatInfo paramHotChatInfo, long paramLong, int paramInt1, int paramInt2, ardq.a parama2) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (this.b != null) {
      this.b.v(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)this.d.app.getManager(60);
    List localList = paramRspBody.dX();
    if (localList != null) {
      localList.remove(this.g);
    }
    paramRspBody.b(this.g, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
    ajry.a().cB(this.val$uin);
    ajrb.c(this.d.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(anaz.gQ()));
    if ((this.g.troopUin != null) && (!this.g.troopUin.equals("0"))) {
      this.d.app.b().N(this.g.troopUin, 1);
    }
    this.d.b(this.dkX, this.dkY, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardt
 * JD-Core Version:    0.7.0.1
 */