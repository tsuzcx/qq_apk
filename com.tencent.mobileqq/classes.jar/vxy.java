import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.Callback;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class vxy
  implements TroopRobotManager.Callback
{
  public vxy(TroopChatPie paramTroopChatPie) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    QQToast.a(this.a.a, 1, "操作失败" + "", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxy
 * JD-Core Version:    0.7.0.1
 */