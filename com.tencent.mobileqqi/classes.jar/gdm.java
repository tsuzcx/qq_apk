import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.newfriend.TroopSystemMessage;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class gdm
  implements View.OnClickListener
{
  public gdm(TroopSystemMessage paramTroopSystemMessage) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(TroopSystemMessage.a(this.a).getApplication())) {
      return;
    }
    int i = TroopSystemMessage.a(this.a).structMsg.msg.group_inviter_role.get();
    int j = ((structmsg.SystemMsgAction)TroopSystemMessage.a(this.a).structMsg.msg.actions.get(0)).action_info.type.get();
    if (j == 11) {
      ReportController.b(TroopSystemMessage.a(this.a), "P_CliOper", "Grp_contacts", "", "Grp_ask", "Admin_Clk_oneblue_agree", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.b = false;
      if (((i == 2) || (i == 3)) && (j == 11)) {
        this.a.b = true;
      }
      TroopSystemMessage.a(this.a).a(this.a.a);
      TroopSystemMessage.a(this.a).a().a().c();
      ((FriendListHandler)TroopSystemMessage.a(this.a).a(1)).a(String.valueOf(TroopSystemMessage.a(this.a).structMsg.req_uin.get()));
      TroopSystemMessage.a(this.a, 0, (structmsg.StructMsg)TroopSystemMessage.a(this.a).structMsg.get());
      return;
      if (j == 12) {
        ReportController.b(TroopSystemMessage.a(this.a), "P_CliOper", "Grp_contacts", "", "Grp_ask", "Admin_Clk_oneblue_refuse", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gdm
 * JD-Core Version:    0.7.0.1
 */