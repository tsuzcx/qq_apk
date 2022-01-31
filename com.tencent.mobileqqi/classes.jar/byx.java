import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class byx
  implements View.OnClickListener
{
  public byx(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_b_of_type_AndroidAppDialog != null) && (this.a.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     byx
 * JD-Core Version:    0.7.0.1
 */