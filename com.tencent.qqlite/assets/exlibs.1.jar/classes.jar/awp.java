import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class awp
  implements View.OnClickListener
{
  public awp(NearbyActivity paramNearbyActivity, Runnable paramRunnable) {}
  
  public void onClick(View paramView)
  {
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.app, "CliOper", "", "", "0X8004444", "0X8004444", 0, 0, "", "", "", "");
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.app.e(false);
      if ((NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) != null) && (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).isShowing())) {
        NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.finish();
    }
    do
    {
      return;
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, 1, 2131362923);
    } while ((NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) == null) || (!NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).isShowing()));
    NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awp
 * JD-Core Version:    0.7.0.1
 */