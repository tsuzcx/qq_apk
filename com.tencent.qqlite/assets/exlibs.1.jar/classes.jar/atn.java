import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.CommonWebActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class atn
  implements ActionSheet.OnButtonClickListener
{
  public atn(LoginActivity paramLoginActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    if (LoginActivity.a(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      paramView = new Intent(this.a, CommonWebActivity.class);
      paramView.putExtra("uin", this.a.app.a());
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
      this.a.startActivity(paramView);
    }
    for (;;)
    {
      LoginActivity.b(this.a, true);
      LoginActivity.a(this.a).dismiss();
      return;
      if (paramInt == 1)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
        com.tencent.common.app.BaseApplicationImpl.c = SystemClock.uptimeMillis() - LoginActivity.a(this.a);
        boolean bool = this.a.getIntent().getBooleanExtra("login_from_account_change", false);
        paramView = new Intent(this.a, LoginPhoneNumActivity.class);
        paramView.putExtra("login_from_account_change", bool);
        this.a.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atn
 * JD-Core Version:    0.7.0.1
 */