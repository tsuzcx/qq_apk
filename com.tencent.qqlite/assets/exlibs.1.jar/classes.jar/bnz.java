import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class bnz
  implements View.OnClickListener
{
  public bnz(TroopMemberCardActivity paramTroopMemberCardActivity, CheckBox paramCheckBox, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = new ArrayList();
    paramView.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e)));
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c), paramView, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    paramView = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.p == 3)
    {
      paramView = "0";
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label161;
      }
    }
    label161:
    for (String str = "0";; str = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, paramView, str, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.p != 2) {
        break;
      }
      paramView = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnz
 * JD-Core Version:    0.7.0.1
 */