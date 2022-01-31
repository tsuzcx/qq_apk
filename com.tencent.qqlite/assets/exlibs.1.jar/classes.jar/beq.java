import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class beq
  implements View.OnClickListener
{
  public beq(QQSetting paramQQSetting) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.a.jdField_a_of_type_Boolean)
      {
        this.a.jdField_a_of_type_Boolean = true;
        paramView = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        paramView.f = 1;
        paramView.g = 8;
        ProfileActivity.a(this.a.a(), paramView, 1009);
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_profile", 0, 0, "", "", "", "");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     beq
 * JD-Core Version:    0.7.0.1
 */