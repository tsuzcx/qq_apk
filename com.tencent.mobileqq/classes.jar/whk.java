import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter.ViewHolder;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class whk
  implements View.OnClickListener
{
  public whk(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    if (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
    {
      paramView = TroopInfoActivity.a(String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), paramView);
      return;
    }
    if (!NetworkUtil.d(this.a.a()))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131433196), 0).b(this.a.a());
      return;
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(String.valueOf(localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    NotificationView.a(this.a, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localViewHolder.c);
    String str2 = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str3 = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    int i;
    label265:
    String str1;
    if (localViewHolder.b < this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.jdField_a_of_type_Int)
    {
      paramView = "1";
      i = localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label419;
      }
      i = 0;
      if (i == 0) {
        break label424;
      }
      str1 = "0";
      label272:
      if ((str2 != null) && (!"".equals(str2))) {
        break label738;
      }
      if (localViewHolder.jdField_a_of_type_Int != 82) {
        break label430;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "focus_notice", 0, 0, "", "", "", localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      NotificationView.a(this.a, localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
    }
    for (;;)
    {
      NotificationView.b(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434436);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
      paramView = "0";
      break;
      label419:
      i = 1;
      break label265;
      label424:
      str1 = "1";
      break label272;
      label430:
      if (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback);
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "req_pay_troop_getPrivilege", 0, 0, "", "", "", "");
      }
      else
      {
        NotificationView.a(this.a, 1, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
        if ((localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
          ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str3, localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        }
        if (localViewHolder.jdField_a_of_type_Int == 1)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, str3, paramView, "1", "0");
        }
        else if (localViewHolder.jdField_a_of_type_Int == 2)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, str3, paramView, str1, "0");
          continue;
          label738:
          NotificationView.a(this.a, 0, (structmsg.StructMsg)localViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if (localViewHolder.jdField_a_of_type_Int == 1) {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, str3, paramView, "0", "0");
          } else if (localViewHolder.jdField_a_of_type_Int == 2) {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, str3, paramView, str1, "0");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     whk
 * JD-Core Version:    0.7.0.1
 */