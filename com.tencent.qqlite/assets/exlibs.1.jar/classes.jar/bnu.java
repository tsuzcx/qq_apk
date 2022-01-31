import android.content.Intent;
import android.view.View;
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

public class bnu
  implements ActionSheet.OnButtonClickListener
{
  public bnu(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.g()) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.D == 1) {
        switch (paramInt)
        {
        }
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e), false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_def", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e), true);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
        continue;
        Object localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.D == 2)
        {
          if (paramInt == 0) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.p == 3)
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, TroopDisbandActivity.class);
              paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c);
              paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b);
              paramView.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d);
              paramView.putExtra("leftViewText", 2131363665);
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivityForResult(paramView, 4);
            }
            else
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131363428);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b == null) {}
              for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b + "(" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c + ")")
              {
                paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131363424), new Object[] { paramView });
                paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 230).setTitle((String)localObject).setMessage(paramView);
                paramView.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131363042), new bnv(this, paramView));
                paramView.setPositiveButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131361813));
                paramView.setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131362794), new bnw(this, paramView));
                paramView.setNegativeButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131361814));
                paramView.show();
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
                break;
              }
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.D == 3)
        {
          switch (paramInt)
          {
          default: 
            break;
          case 0: 
            paramView = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.getManager(42);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_Boolean)
            {
              paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e, 0L);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c), "", "");
              continue;
            }
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, TroopMemberGagActivity.class);
            ((Intent)localObject).putExtra("param_key_troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c);
            ((Intent)localObject).putExtra("param_key_memberUin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity((Intent)localObject);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c), "", "");
            break;
          case 1: 
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
            break;
          case 2: 
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.p == 3)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.i();
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.h();
            break;
          case 3: 
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.h();
            break;
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.D == 4) && (paramInt == 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnu
 * JD-Core Version:    0.7.0.1
 */