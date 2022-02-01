import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class ardr
  implements ardq.a<oidb_0x8ed.RspBody>
{
  ardr(ardq paramardq, ardq.a parama, HotChatInfo paramHotChatInfo) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (this.a != null) {
      this.a.v(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)this.d.app.getManager(60);
    List localList = paramRspBody.dX();
    if (localList != null) {
      localList.remove(this.f);
    }
    paramRspBody.b(this.f, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardr
 * JD-Core Version:    0.7.0.1
 */