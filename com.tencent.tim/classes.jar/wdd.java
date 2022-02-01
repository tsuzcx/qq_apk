import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class wdd
  implements yxe.a
{
  public wdd(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(paramInt, 128)) && (TroopInfo.hasPayPrivilege(paramInt, 512)))
    {
      i = 1;
      if (i == 0) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "onTroopPrivilege payTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt);
      }
      yxe.bm(this.this$0, paramString);
      yxe.bj(this.this$0.app);
      this.this$0.ath();
      anot.a(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "pay_troop", "", "", "");
    }
    label126:
    do
    {
      do
      {
        do
        {
          return;
          i = 0;
          break;
          if (((this.this$0.a.msg.group_msg_type.get() != 11) || (this.this$0.a.msg.sub_type.get() != 3)) && (this.this$0.a.msg.group_msg_type.get() != 7)) {
            break label250;
          }
        } while (this.this$0.e == null);
        try
        {
          long l = Long.parseLong(this.this$0.aKI);
          this.this$0.atg();
          this.this$0.e.aA(l, 8390784);
          return;
        }
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, paramString.toString());
      return;
      this.this$0.atg();
      TroopRequestActivity.a(this.this$0, 1);
    } while (this.this$0.a.msg.group_msg_type.get() != 2);
    label250:
    anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString, "", "0", "0");
    anot.a(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop", "", "", "");
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    this.this$0.ath();
    paramStructMsg = this.this$0;
    if (paramInt1 == 72) {}
    for (paramInt1 = 2131690280;; paramInt1 = 2131690279)
    {
      QQToast.a(paramStructMsg, paramInt1, 1).show();
      anot.a(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "err", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.TroopRequestActivity", 2, "NotificationView onTroopPrivilege network! error rspTroopUin = " + paramString1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wdd
 * JD-Core Version:    0.7.0.1
 */