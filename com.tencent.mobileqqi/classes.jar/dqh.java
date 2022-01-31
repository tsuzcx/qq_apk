import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.TroopMemberGagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dqh
  implements ActionSheet.OnButtonClickListener
{
  public dqh(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.g()) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.B == 1) {
        switch (paramInt)
        {
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e), false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_def", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e), true);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
        continue;
        Object localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.B == 2)
        {
          if (paramInt == 0) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.p == 3)
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, TroopDisbandActivity.class);
              paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c);
              paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_JavaLangString);
              paramView.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d);
              paramView.putExtra("leftViewText", 2131561804);
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivityForResult(paramView, 4);
            }
            else
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131562707);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_JavaLangString == null) {}
              for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_JavaLangString + "(" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c + ")")
              {
                paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131561971), new Object[] { paramView });
                paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 230).setTitle((String)localObject).setMessage(paramView);
                paramView.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131562701), new dqi(this, paramView));
                paramView.setPositiveButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131558431));
                paramView.setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131561746), new dqj(this, paramView));
                paramView.setNegativeButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131558432));
                paramView.show();
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
                break;
              }
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.B == 3)
        {
          switch (paramInt)
          {
          default: 
            break;
          case 0: 
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_Boolean)
            {
              ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e, 0L);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
              continue;
            }
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, TroopMemberGagActivity.class);
            paramView.putExtra("param_key_troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c);
            paramView.putExtra("param_key_memberUin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
            break;
          case 1: 
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
            break;
          case 2: 
            paramView = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2131624405);
            paramView.setContentView(2130903221);
            ((TextView)paramView.findViewById(2131231469)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131562758));
            ((TextView)paramView.findViewById(2131231029)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131561973));
            ((TextView)paramView.findViewById(2131231667)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131563216));
            localObject = (CheckBox)paramView.findViewById(2131231667);
            TextView localTextView1 = (TextView)paramView.findViewById(2131231472);
            TextView localTextView2 = (TextView)paramView.findViewById(2131231473);
            localTextView1.setText(17039360);
            localTextView2.setText(17039370);
            localTextView1.setOnClickListener(new dqk(this, paramView));
            localTextView2.setOnClickListener(new dql(this, (CheckBox)localObject, paramView));
            paramView.show();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_movegrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
            break;
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.B == 4) && (paramInt == 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqh
 * JD-Core Version:    0.7.0.1
 */