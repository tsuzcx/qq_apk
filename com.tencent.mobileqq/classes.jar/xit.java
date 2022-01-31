import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Locale;

public class xit
  implements ActionSheet.OnButtonClickListener
{
  public xit(LoginView paramLoginView) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (LoginView.a(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      ReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007353", "0X8007353", 0, 0, "", "", "", "");
      ReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
      ReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 3, 0, "", "", "", "");
      paramView = null;
      if (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) {}
    }
    for (paramView = this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();; paramView = "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756") {
      for (;;)
      {
        try
        {
          Long.parseLong(paramView);
          if (TextUtils.isEmpty(paramView)) {
            break;
          }
          paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756", paramView });
          localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          localIntent.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localIntent.putExtra("reqType", 3);
          localIntent.putExtra("url", paramView);
          this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
          LoginView.b(this.a, true);
          LoginView.a(this.a).dismiss();
          return;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          Intent localIntent = null;
          paramView = localIntent;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("LoginActivity.LoginView", 4, String.format(Locale.getDefault(), "forget pwd %s", new Object[] { this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() }));
          paramView = localIntent;
          continue;
        }
        if (paramInt == 1)
        {
          ReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
          ReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
          ReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 2, 0, "", "", "", "");
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
          boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("login_from_account_change", false);
          paramView = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, LoginPhoneNumActivity.class);
          paramView.putExtra("login_from_account_change", bool);
          this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xit
 * JD-Core Version:    0.7.0.1
 */