import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.WtloginManagerImpl;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;

public class aamy
  implements ausj.a
{
  public aamy(LoginView paramLoginView) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    LoginView.h(this.this$0, false);
    if (LoginView.g(this.this$0)) {
      return;
    }
    if (paramInt == 0)
    {
      anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X8007353", "0X8007353", 0, 0, "", "", "", "");
      anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
      anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 3, 0, "", "", "", "");
      anot.a(this.this$0.mAppInterface, "new_reg_805", "log_page", "re_clk", "", 1, "");
      anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X800AA2C", "0X800AA2C", 0, 0, "", "", "", "");
      paramView = null;
      if (this.this$0.a == null) {}
    }
    for (paramView = this.this$0.a.getText().toString();; paramView = "https://ti.qq.com/safe/forgetpw?source_id=2756") {
      for (;;)
      {
        try
        {
          Long.parseLong(paramView);
          if (TextUtils.isEmpty(paramView)) {
            break;
          }
          paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });
          paramView = new StringBuilder(paramView);
          localObject = ((WtloginManagerImpl)this.this$0.mAppInterface.getManager(1)).getGUID();
          byte[] arrayOfByte = util.get_bssid_addr(this.this$0.m);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
            paramView.append("&bssid=").append(MD5.toMD5(arrayOfByte));
          }
          paramView.append("&guid=").append(util.buf_to_string((byte[])localObject)).append("&appid=").append(AppSetting.getAppId());
          paramView = paramView.toString();
          QLog.d("LoginActivity.LoginView", 1, new Object[] { "forgetpwd url is ", paramView });
          localObject = new Intent(this.this$0.m, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("uin", this.this$0.mAppInterface.getCurrentAccountUin());
          ((Intent)localObject).putExtra("reqType", 3);
          ((Intent)localObject).putExtra("url", paramView);
          this.this$0.m.startActivity((Intent)localObject);
          LoginView.g(this.this$0, true);
          LoginView.a(this.this$0).dismiss();
          return;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          Object localObject = null;
          paramView = (View)localObject;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("LoginActivity.LoginView", 4, String.format(Locale.getDefault(), "forget pwd %s", new Object[] { this.this$0.a.getText().toString() }));
          paramView = (View)localObject;
          continue;
        }
        if (paramInt == 1)
        {
          anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
          anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
          anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 2, 0, "", "", "", "");
          anot.a(this.this$0.mAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
          anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X800AA2D", "0X800AA2D", 0, 0, "", "", "", "");
          boolean bool = this.this$0.m.getIntent().getBooleanExtra("login_from_account_change", false);
          paramView = new Intent(this.this$0.m, LoginPhoneNumActivity.class);
          paramView.putExtra("login_from_account_change", bool);
          this.this$0.m.startActivity(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamy
 * JD-Core Version:    0.7.0.1
 */