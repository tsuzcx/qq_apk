import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class brs
  implements View.OnClickListener
{
  public brs(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "2", "", "", "");
    this.a.a(this.a.a(), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.a.jdField_b_of_type_AndroidAppDialog != null) && (this.a.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     brs
 * JD-Core Version:    0.7.0.1
 */