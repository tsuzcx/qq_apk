import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class vzy
  implements yxe.a
{
  public vzy(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    if ((TroopInfo.hasPayPrivilege(paramInt, 128)) && (TroopInfo.hasPayPrivilege(paramInt, 512))) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInviteStatusFragment", 2, "onTroopPrivilege payTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt);
      }
      yxe.bm(this.this$0.mActivity, paramString);
      yxe.bj(this.this$0.mApp);
      if ((this.this$0.J != null) && (this.this$0.J.isShowing())) {
        this.this$0.J.dismiss();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "onTroopPrivilege normalTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt + ", sendSystemMsgAction-----");
    }
    TroopInviteStatusFragment.a(this.this$0, 2);
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.this$0.J != null) && (this.this$0.J.isShowing())) {
      this.this$0.J.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopInviteStatusFragment", 2, "NotificationView onTroopPrivilege network! error rspTroopUin = " + paramString1);
    }
    paramString1 = this.this$0.mActivity;
    if (paramInt1 == 72) {}
    for (paramInt1 = 2131690280;; paramInt1 = 2131690279)
    {
      QQToast.a(paramString1, paramInt1, 1).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzy
 * JD-Core Version:    0.7.0.1
 */