import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.a;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class apvj
  implements aptw.a
{
  public apvj(TroopAIORobotLayout paramTroopAIORobotLayout, int paramInt, String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.a parama) {}
  
  public void a(int paramInt, cmd0x934.RspBody paramRspBody)
  {
    boolean bool = true;
    if (paramInt == 0)
    {
      aptw localaptw = RobotPanelLayoutBase.a();
      if (localaptw == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
        }
        return;
      }
      paramInt = paramRspBody.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("TroopAIORobotLayout", 2, "initData->reqPanelList oldVer:" + this.dCe + " newVer:" + paramInt);
      }
      if ((this.dCe != paramInt) && (paramRspBody.robot_uin.get() == Long.parseLong(this.bfz)))
      {
        this.b.cov = this.Uf;
        this.b.cro = this.bfz;
        this.b.crF = this.val$nickname;
        localaptw.a(this.Uf, this.bfz, paramRspBody);
        paramRspBody = this.b.a(paramRspBody);
        if ((paramRspBody != null) && (paramRspBody.size() > 0))
        {
          this.b.yW(false);
          this.b.Y(paramRspBody, true);
          if (this.b.getItemCount() > 0) {
            TroopAIORobotLayout.a(this.b, this.b.cov, this.b.cro, this.b.crF, localaptw, true);
          }
          paramRspBody = this.a;
          if (this.b.getItemCount() <= 0) {
            break label468;
          }
        }
      }
      for (;;)
      {
        paramRspBody.af(bool, this.b.cro);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopAIORobotLayout", 2, "listDatas is null in new version");
        break;
        if (this.b.getItemCount() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAIORobotLayout", 2, "item count == 0");
          }
          byte[] arrayOfByte = localaptw.i(this.Uf, this.bfz);
          if (arrayOfByte != null) {
            for (;;)
            {
              try
              {
                paramRspBody.mergeFrom(arrayOfByte);
                paramRspBody = this.b.a(paramRspBody);
                if ((paramRspBody == null) || (paramRspBody.size() <= 0)) {
                  break label424;
                }
                this.b.yW(false);
                this.b.Y(paramRspBody, true);
                this.b.cov = this.Uf;
                this.b.cro = this.bfz;
                this.b.crF = this.val$nickname;
              }
              catch (InvalidProtocolBufferMicroException paramRspBody) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("TroopAIORobotLayout", 2, paramRspBody.getMessage());
              break;
              label424:
              if (QLog.isColorLevel()) {
                QLog.d("TroopAIORobotLayout", 2, "listDatas is null");
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopAIORobotLayout", 2, "data is null");
          break;
        }
        this.b.update();
        break;
        label468:
        bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAIORobotLayout", 2, "initData->reqPanelList: errorCode = " + paramInt);
    }
    this.a.af(false, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvj
 * JD-Core Version:    0.7.0.1
 */