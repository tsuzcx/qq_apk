import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Locale;

public class udi
  implements ausj.a
{
  public udi(AddAccountActivity paramAddAccountActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (AddAccountActivity.a(this.this$0)) {
      return;
    }
    if (paramInt == 0)
    {
      anot.c(this.this$0.app, "dc00898", "", "", "0X8007353", "0X8007353", 0, 0, "", "", "", "");
      paramView = null;
      if (this.this$0.a != null) {
        paramView = this.this$0.a.getText().toString();
      }
      if (TextUtils.isEmpty(paramView)) {
        break label292;
      }
    }
    label292:
    for (paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });; paramView = "https://ti.qq.com/safe/forgetpw?source_id=2756")
    {
      Intent localIntent = new Intent(this.this$0, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.this$0.app.getCurrentAccountUin());
      localIntent.putExtra("reqType", 3);
      localIntent.putExtra("url", paramView);
      this.this$0.startActivity(localIntent);
      for (;;)
      {
        AddAccountActivity.c(this.this$0, true);
        AddAccountActivity.a(this.this$0).dismiss();
        return;
        if (paramInt == 1)
        {
          anot.c(this.this$0.app, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
          anot.a(this.this$0.app, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
          boolean bool = this.this$0.getIntent().getBooleanExtra("login_from_account_change", false);
          paramView = new Intent(this.this$0, LoginPhoneNumActivity.class);
          paramView.putExtra("login_from_account_change", bool);
          this.this$0.startActivity(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udi
 * JD-Core Version:    0.7.0.1
 */