import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.robotchat.RobotChatPanelLayout;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class amio
  implements aptw.a
{
  public amio(RobotChatPanelLayout paramRobotChatPanelLayout, long paramLong, int paramInt, String paramString, RobotPanelLayoutBase.a parama) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 0)
    {
      if (RobotChatPanelLayout.a(this.b) == null) {
        if (QLog.isColorLevel()) {
          QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
        }
      }
      do
      {
        return;
        if (paramRspBody.robot_uin.get() == this.aiK) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("RobotChatPanelLayout", 2, "data not match :" + this.aiK);
      return;
      paramInt = paramRspBody.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("RobotChatPanelLayout", 2, "initData->reqPanelList oldVer:" + this.dCe + " newVer:" + paramInt);
      }
      if (this.dCe != paramInt)
      {
        RobotChatPanelLayout.b(this.b).a("1", this.bfz, paramRspBody);
        paramRspBody = RobotChatPanelLayout.a(this.b, paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.b.yW(false);
          this.b.Y(paramRspBody, true);
          paramRspBody = this.a;
          if (this.b.getItemCount() <= 0) {
            break label297;
          }
        }
      }
      for (;;)
      {
        paramRspBody.af(bool1, this.bfz);
        return;
        this.b.yW(true);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RobotChatPanelLayout", 2, "listDatas is null in new version");
        break;
        if (this.b.getItemCount() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RobotChatPanelLayout", 2, "item count == 0");
          }
          RobotChatPanelLayout.a(this.b, this.bfz);
          break;
        }
        this.b.update();
        break;
        label297:
        bool1 = false;
      }
    }
    RobotChatPanelLayout.a(this.b, this.bfz);
    if (this.b.getItemCount() > 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.a.af(bool1, this.bfz);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "initData->reqPanelList: errorCode = " + paramInt + " hasdata:" + bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amio
 * JD-Core Version:    0.7.0.1
 */