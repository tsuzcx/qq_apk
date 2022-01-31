import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class wun
  implements DialogInterface.OnClickListener
{
  public wun(DialogBaseActivity paramDialogBaseActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Boolean)
    {
      paramDialogInterface = new Intent(BaseActivity.sTopActivity, SplashActivity.class);
      paramDialogInterface.putExtra("main_tab_id", 1);
      paramDialogInterface.setFlags(603979776);
      BaseActivity.sTopActivity.startActivity(paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity.finish();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity.app, "dc00898", "", "", "0X8006AA6", "0X8006AA6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wun
 * JD-Core Version:    0.7.0.1
 */