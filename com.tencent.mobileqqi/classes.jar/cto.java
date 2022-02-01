import android.content.Intent;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

public class cto
  extends AccountObserver
{
  public cto(LoginActivity paramLoginActivity) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QLog.d("login", 1, "LoginActivity onLoginFailed ret=" + paramInt);
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      this.a.runOnUiThread(new ctp(this));
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt);
      }
      if (!TextUtils.isEmpty(this.a.c))
      {
        List localList = this.a.getAppRuntime().getApplication().getAllAccounts();
        if ((localList != null) && (localList.size() > 0))
        {
          str = this.a.a.getText().toString();
          int i = 0;
          for (;;)
          {
            if (i >= localList.size()) {
              break label258;
            }
            localSimpleAccount = (SimpleAccount)localList.get(i);
            if (localSimpleAccount != null) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      String str;
      SimpleAccount localSimpleAccount;
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (!str.equals(this.a.b.b(localSimpleAccount.getUin())));
      SharedPreUtils.a(this.a.b.getApplication().getApplicationContext(), this.a.c, true);
      label258:
      if ((paramString2 == null) || (paramString2.equals("")))
      {
        QQToast.a(this.a, 2131562451, 0).a();
        return;
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        Intent localIntent = new Intent(this.a, NotificationActivity.class);
        localIntent.putExtra("type", 8);
        if (paramInt == 40) {
          localIntent.putExtra("msg", paramString2);
        }
        for (;;)
        {
          localIntent.putExtra("loginalias", paramString1);
          localIntent.putExtra("loginret", paramInt);
          this.a.startActivity(localIntent);
          return;
          localIntent.putExtra("msg", LocaleString.a(this.a, paramString2) + " " + paramString3);
        }
      }
      if (paramInt == 2008)
      {
        QQToast.a(this.a, 2131563021, 0).a();
        return;
      }
      QQToast.a(this.a, LocaleString.a(this.a, paramString2), 0).a();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    if (paramString1.equals(LoginActivity.a(this.a))) {
      PrivacyDeclareHelper.a(paramString1, null);
    }
    for (;;)
    {
      QLog.d("login", 1, "LoginActivity onLoginSuccess");
      return;
      PrivacyDeclareHelper.a(paramString1, LoginActivity.a(this.a));
    }
  }
  
  protected void onLoginTimeout(String paramString)
  {
    QLog.d("login", 1, "LoginActivity onLoginTimeout");
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      if (!TextUtils.isEmpty(this.a.c))
      {
        paramString = this.a.getAppRuntime().getApplication().getAllAccounts();
        if ((paramString != null) && (paramString.size() > 0))
        {
          str = this.a.a.getText().toString();
          int i = 0;
          for (;;)
          {
            if (i >= paramString.size()) {
              break label170;
            }
            localSimpleAccount = (SimpleAccount)paramString.get(i);
            if (localSimpleAccount != null) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      String str;
      SimpleAccount localSimpleAccount;
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      } while (!str.equals(this.a.b.b(localSimpleAccount.getUin())));
      SharedPreUtils.a(this.a.b.getApplication().getApplicationContext(), this.a.c, true);
      label170:
      QQToast.a(this.a, 2131562451, 0).a();
    }
  }
  
  protected void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cto
 * JD-Core Version:    0.7.0.1
 */