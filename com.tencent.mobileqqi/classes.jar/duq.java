import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class duq
  implements DialogInterface.OnClickListener
{
  public duq(TroopDisbandActivity paramTroopDisbandActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.a == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.a = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
    }
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity))
    {
      paramDialogInterface = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
      if (paramDialogInterface != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.d & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity;
          localTroopDisbandActivity.d |= 0x1;
          paramDialogInterface.i(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.a.a(0, 2131562256, 1000);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.a.a(2, 2131562571, 1500);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.a.a(2, 2131562488, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     duq
 * JD-Core Version:    0.7.0.1
 */