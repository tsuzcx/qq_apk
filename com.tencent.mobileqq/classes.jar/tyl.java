import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class tyl
  implements View.OnClickListener
{
  public tyl(TroopMemberListActivity paramTroopMemberListActivity, List paramList, CheckBox paramCheckBox, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.a(20);
    String str;
    if (paramView != null)
    {
      paramView.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label141;
      }
    }
    label141:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, str, paramView, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tyl
 * JD-Core Version:    0.7.0.1
 */