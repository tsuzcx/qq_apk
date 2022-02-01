import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yxk
  implements yxe.a
{
  public yxk(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(paramInt, 128)) && (TroopInfo.hasPayPrivilege(paramInt, 512)))
    {
      i = 1;
      if (i == 0) {
        break label155;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "onTroopPrivilege payTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt);
      }
      yxe.bm(this.this$0.P, paramString);
      yxe.bj(this.this$0.app);
      if ((this.this$0.J != null) && (this.this$0.J.isShowing())) {
        this.this$0.J.dismiss();
      }
      anot.a(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "pay_troop", "", "", "");
    }
    label155:
    do
    {
      return;
      i = 0;
      break;
      paramStructMsg = yxe.a(paramString);
      if (paramStructMsg == null) {
        break label293;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "onTroopPrivilege normalTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt + ", sendSystemMsgAction-----");
      }
      TroopNotifyAndRecommendView.a(this.this$0, 1, (structmsg.StructMsg)paramStructMsg.get());
    } while (paramStructMsg.msg.group_msg_type.get() != 2);
    anot.a(this.this$0.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString, "", "0", "0");
    anot.a(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop", "", "", "");
    return;
    label293:
    if (QLog.isColorLevel()) {
      QLog.e("TroopNotifyAndRecommendView", 2, "NotificationView onTroopPrivilege cache error--------------");
    }
    anot.a(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop_error", "", "", "");
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.this$0.J != null) && (this.this$0.J.isShowing())) {
      this.this$0.J.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopNotifyAndRecommendView", 2, "NotificationView onTroopPrivilege network! error rspTroopUin = " + paramString1);
    }
    paramString1 = this.this$0.P;
    if (paramInt1 == 72) {}
    for (paramInt1 = 2131690280;; paramInt1 = 2131690279)
    {
      QQToast.a(paramString1, paramInt1, 1).show();
      anot.a(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "err", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxk
 * JD-Core Version:    0.7.0.1
 */