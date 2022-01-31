import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class aru
  implements View.OnClickListener
{
  public aru(LbsBaseActivity paramLbsBaseActivity, Runnable paramRunnable) {}
  
  public void onClick(View paramView)
  {
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.app, "CliOper", "", "", "0X8004444", "0X8004444", 0, 0, "", "", "", "");
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.app.e(false);
      if ((LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity) != null) && (LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity).isShowing())) {
        LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity).dismiss();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.a(1, 2131362912);
    } while ((LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity) == null) || (!LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity).isShowing()));
    LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aru
 * JD-Core Version:    0.7.0.1
 */