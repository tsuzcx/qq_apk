import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class bpl
  implements View.OnClickListener
{
  public bpl(TroopRequestActivity paramTroopRequestActivity, TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int k = 1;
    int m = 1;
    int j = 1;
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.getString(2131362916), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.getTitleBarHeight());
    }
    String str2;
    label386:
    label593:
    do
    {
      do
      {
        String str1;
        int n;
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
                    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.getIntent().getExtras().getBoolean("is_unread");
                    str2 = TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_code.get() + "";
                    str1 = "0";
                    n = TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_msg_type.get();
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.jdField_a_of_type_Boolean) {
                      str1 = "1";
                    }
                    if (paramView != TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity)) {
                      break;
                    }
                    if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p) != null) {}
                    while (TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_msg_type.get() == 80)
                    {
                      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.getActivity(), TroopManageActivity.class);
                      paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p);
                      paramView.putExtra("key_is_need_update_Group_info", true);
                      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.startActivity(paramView);
                      return;
                      TroopRemindSettingManager.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app);
                    }
                  } while (!TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, 1));
                  TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).b(2131363381);
                  TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).show();
                  if (n == 1)
                  {
                    i = j;
                    if (TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity) != null)
                    {
                      if ("".equals(TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity))) {
                        i = j;
                      }
                    }
                    else {
                      if (i == 0) {
                        break label386;
                      }
                    }
                    for (paramView = "1";; paramView = "0")
                    {
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, str2, str1, paramView, "1");
                      return;
                      i = 0;
                      break;
                    }
                  }
                } while (n != 2);
                j = TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_inviter_role.get();
                if ((j == 2) || (j == 3)) {
                  i = 0;
                }
                if (i != 0) {}
                for (paramView = "0";; paramView = "1")
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, str2, str1, paramView, "1");
                  return;
                }
                if (paramView != TroopRequestActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity)) {
                  break;
                }
              } while (!TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, 0));
              TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).b(2131363381);
              TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).show();
              if (n == 1)
              {
                i = k;
                if (TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity) != null)
                {
                  if ("".equals(TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity))) {
                    i = k;
                  }
                }
                else {
                  if (i == 0) {
                    break label593;
                  }
                }
                for (paramView = "1";; paramView = "0")
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, str2, str1, paramView, "1");
                  return;
                  i = 0;
                  break;
                }
              }
            } while (n != 2);
            j = TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_inviter_role.get();
            if (j != 2)
            {
              i = m;
              if (j != 3) {}
            }
            else
            {
              i = 0;
            }
            if (i != 0) {}
            for (paramView = "0";; paramView = "1")
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, str2, str1, paramView, "1");
              return;
            }
            if (paramView != TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity)) {
              break;
            }
          } while (!TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, 2));
          TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).b(2131363381);
          TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).show();
          if (n == 1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "ignore_ask", 0, 0, str2, str1, "", "");
            return;
          }
        } while (n != 2);
        i = TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_inviter_role.get();
        if ((i == 2) || (i == 3))
        {
          i = 0;
          if (i == 0) {
            break label838;
          }
        }
        for (paramView = "0";; paramView = "1")
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "ignore_invite", 0, 0, str2, str1, paramView, "");
          return;
          i = 1;
          break;
        }
      } while (paramView != this.jdField_a_of_type_AndroidWidgetTextView);
      if (TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_msg_type.get() == 80)
      {
        paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p, 5);
        TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.getActivity(), paramView);
        return;
      }
      if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p) != null) {}
      for (;;)
      {
        if (((TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_msg_type.get() == 11) && (TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.sub_type.get() == 3)) || (TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_msg_type.get() == 7))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {}
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p);
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.e();
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 8388736);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "again_join", 0, 0, str2, "", "", "");
            return;
            TroopRemindSettingManager.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app);
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.systemmsg.TroopRequestActivity", 2, paramView.toString());
              }
            }
          }
        }
      }
    } while ((TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.group_msg_type.get() != 10) || (TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).msg.sub_type.get() != 3));
    label838:
    TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).b(2131363381);
    TroopRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity).show();
    paramView = new ArrayList();
    paramView.add(TroopRequestActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity));
    if ((paramView.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p.length() > 0)) {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app.a(17)).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.p, paramView, "");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "again_invite", 0, 0, str2, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bpl
 * JD-Core Version:    0.7.0.1
 */