import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.TroopRequestRefuseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ucv
  implements View.OnClickListener
{
  public ucv(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if ((!NetworkUtil.d(this.a)) && ((paramView != this.a.jdField_b_of_type_AndroidWidgetButton) || ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 22)))) {
      QQToast.a(this.a, this.a.getString(2131433213), 0).b(this.a.getTitleBarHeight());
    }
    String str2;
    label400:
    label597:
    label864:
    do
    {
      do
      {
        String str1;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    this.a.jdField_a_of_type_Boolean = this.a.getIntent().getExtras().getBoolean("is_unread");
                    str2 = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                    str1 = "0";
                    i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
                    if (this.a.jdField_a_of_type_Boolean) {
                      str1 = "1";
                    }
                    if (paramView != this.a.jdField_a_of_type_AndroidWidgetButton) {
                      break;
                    }
                    if (((TroopManager)this.a.app.getManager(51)).a(this.a.jdField_a_of_type_JavaLangString) != null) {}
                    while (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
                    {
                      QLog.e("Q.systemmsg.TroopRequestActivity", 1, "TroopProxyActivity 已在725下架");
                      return;
                      TroopRemindSettingManager.a().b(this.a.jdField_a_of_type_JavaLangString, this.a.app);
                    }
                    if (i == 2)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "doCheckPayTroopReq start: " + str2);
                      }
                      this.a.h();
                      TroopRequestActivity.a(this.a, this.a.app, str2, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback);
                      i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
                      if ((i != 2) && (i != 3))
                      {
                        i = 1;
                        if (i == 0) {
                          break label400;
                        }
                      }
                      for (paramView = "0";; paramView = "1")
                      {
                        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, str2, str1, paramView, "1");
                        return;
                        i = 0;
                        break;
                      }
                    }
                    if (i == 82)
                    {
                      this.a.h();
                      TroopRequestActivity.a(this.a, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
                      ReportController.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "focus_invite", 0, 0, "", "", "", this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
                      return;
                    }
                  } while (!TroopRequestActivity.a(this.a, 1));
                  this.a.h();
                } while (i != 1);
                if ((this.a.q == null) || ("".equals(this.a.q)))
                {
                  i = 1;
                  if (i == 0) {
                    break label597;
                  }
                }
                for (paramView = "1";; paramView = "0")
                {
                  ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, str2, str1, paramView, "1");
                  return;
                  i = 0;
                  break;
                }
                if (paramView != this.a.jdField_b_of_type_AndroidWidgetButton) {
                  break;
                }
                if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 22))
                {
                  paramView = new Intent(this.a, TroopRequestRefuseActivity.class);
                  this.a.startActivityForResult(paramView, 1005);
                  ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask_has_reason", 0, 0, str2, str1, "", "1");
                  return;
                }
              } while (!TroopRequestActivity.a(this.a, 0));
              this.a.h();
              if (i == 1)
              {
                if ((this.a.q == null) || ("".equals(this.a.q)))
                {
                  i = 1;
                  if (i == 0) {
                    break label783;
                  }
                }
                for (paramView = "1";; paramView = "0")
                {
                  ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, str2, str1, paramView, "1");
                  return;
                  i = 0;
                  break;
                }
              }
            } while (i != 2);
            i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
            if ((i != 2) && (i != 3))
            {
              i = 1;
              if (i == 0) {
                break label864;
              }
            }
            for (paramView = "0";; paramView = "1")
            {
              ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, str2, str1, paramView, "1");
              return;
              i = 0;
              break;
            }
            if (paramView != this.a.rightViewText) {
              break;
            }
            if (this.a.jdField_b_of_type_Int == 82)
            {
              if (TroopRequestActivity.a(this.a, 0)) {
                this.a.h();
              }
              ReportController.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "ignore_invite", 0, 0, "", "", "", this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
            }
          } while (!TroopRequestActivity.a(this.a, 2));
          this.a.h();
          if (i == 1)
          {
            ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "ignore_ask", 0, 0, str2, str1, "", "");
            return;
          }
        } while (i != 2);
        int i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
        if ((i != 2) && (i != 3))
        {
          i = 1;
          if (i == 0) {
            break label1098;
          }
        }
        for (paramView = "0";; paramView = "1")
        {
          ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "ignore_invite", 0, 0, str2, str1, paramView, "");
          return;
          i = 0;
          break;
        }
      } while (paramView != this.a.d);
      if (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
      {
        paramView = TroopInfoActivity.a(this.a.jdField_a_of_type_JavaLangString, 5);
        TroopInfoActivity.a(this.a.getActivity(), paramView);
        return;
      }
      if (((TroopManager)this.a.app.getManager(51)).a(this.a.jdField_a_of_type_JavaLangString) != null) {}
      while (((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 11) && (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 3)) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 7))
      {
        this.a.h();
        TroopRequestActivity.a(this.a, this.a.app, str2, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback);
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "again_join", 0, 0, str2, "", "", "");
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "refuse_retry", "req_pay_troop_getPrivilege", 0, 0, "", "", "", "");
        return;
        TroopRemindSettingManager.a().b(this.a.jdField_a_of_type_JavaLangString, this.a.app);
      }
    } while ((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 10) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 3));
    label783:
    label1098:
    this.a.h();
    paramView = new ArrayList();
    paramView.add(TroopRequestActivity.a(this.a));
    if ((paramView.size() > 0) && (this.a.jdField_a_of_type_JavaLangString.length() > 0)) {
      ((TroopHandler)this.a.app.a(20)).a(this.a.jdField_a_of_type_JavaLangString, paramView, "");
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "again_invite", 0, 0, str2, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucv
 * JD-Core Version:    0.7.0.1
 */