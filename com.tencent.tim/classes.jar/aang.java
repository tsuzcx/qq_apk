import android.content.Intent;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView.27.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.AccountObserver;

public class aang
  extends AccountObserver
{
  public aang(LoginView paramLoginView) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super.onCheckQuickRegisterAccount(paramBoolean, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_LoginActivity.LoginView", 2, "onCheckQuickRegisterAccount|isSuccess= " + paramBoolean + ",code=" + paramInt);
    }
    if (!this.this$0.m.isFinishing()) {}
    try
    {
      this.this$0.m.dismissDialog(4);
      if ((paramBoolean) && (paramInt == 0))
      {
        paramArrayOfByte = new Intent(this.this$0.m, RegisterByNicknameAndPwdActivity.class);
        paramArrayOfByte.putExtra("key_register_binduin", this.this$0.mAppInterface.getCurrentAccountUin());
        paramArrayOfByte.putExtra("key_register_from_quick_register", true);
        paramArrayOfByte.putExtra("key_register_is_phone_num_registered", true);
        paramArrayOfByte.putExtra("not_need_verify_sms", true);
        this.this$0.m.startActivity(paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      paramArrayOfByte = new Intent(this.this$0.m, RegisterPhoneNumActivity.class);
      paramArrayOfByte.putExtra("key_register_from", 3);
      this.this$0.m.startActivity(paramArrayOfByte);
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    QLog.d("login", 1, "LoginActivity onLoginFailed ret=" + paramInt1);
    if (!this.this$0.m.isFinishing()) {}
    try
    {
      this.this$0.m.dismissDialog(0);
      this.this$0.m.runOnUiThread(new LoginView.27.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt1);
      }
      if (!TextUtils.isEmpty(this.this$0.bdr))
      {
        List localList = BaseApplicationImpl.sApplication.getAllAccounts();
        if ((localList != null) && (localList.size() > 0))
        {
          str = this.this$0.a.getText().toString();
          int i = 0;
          for (;;)
          {
            if (i >= localList.size()) {
              break label250;
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
      } while (!str.equals(this.this$0.mAppInterface.jm(localSimpleAccount.getUin())));
      aqmj.i(BaseApplicationImpl.sApplication, this.this$0.bdr, true);
      label250:
      if ((paramString2 == null) || (paramString2.equals("")))
      {
        QQToast.a(this.this$0.m, 2131696270, 0).show();
        return;
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        Intent localIntent = new Intent(this.this$0.m, NotificationActivity.class);
        localIntent.putExtra("type", 8);
        if (paramInt1 == 40)
        {
          localIntent.putExtra("msg", paramString2);
          localIntent.putExtra("errorver", paramInt2);
          anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          localIntent.putExtra("loginalias", paramString1);
          localIntent.putExtra("loginret", paramInt1);
          localIntent.putExtra("errorUrl", paramString3);
          localIntent.putExtra("expiredSig", paramArrayOfByte);
          this.this$0.m.startActivity(localIntent);
          return;
          localIntent.putExtra("msg", paramString2 + " " + paramString3);
        }
      }
      if (paramInt1 == 2008)
      {
        aqha.a(this.this$0.m, 230, acfp.m(2131707957), acfp.m(2131707952), "OK", null, new aanh(this), null).show();
        QQToast.a(this.this$0.m, 2131694440, 0).show();
        return;
      }
      aqha.a(this.this$0.m, 230, acfp.m(2131707945), paramString2, new aani(this), null).show();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("login", 1, "LoginActivity onLoginSuccess");
    if (LoginView.f(this.this$0))
    {
      anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
      anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 1, 0, "", "", "", "");
    }
  }
  
  public void onLoginTimeout(String paramString)
  {
    QLog.d("login", 1, "LoginActivity onLoginTimeout");
    if (!this.this$0.m.isFinishing()) {}
    try
    {
      this.this$0.m.dismissDialog(0);
      if (!TextUtils.isEmpty(this.this$0.bdr))
      {
        paramString = BaseApplicationImpl.sApplication.getAllAccounts();
        if ((paramString != null) && (paramString.size() > 0))
        {
          str = this.this$0.a.getText().toString();
          int i = 0;
          for (;;)
          {
            if (i >= paramString.size()) {
              break label160;
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
      } while (!str.equals(this.this$0.mAppInterface.jm(localSimpleAccount.getUin())));
      aqmj.i(BaseApplicationImpl.sApplication, this.this$0.bdr, true);
      label160:
      QQToast.a(this.this$0.m, 2131696270, 0).show();
    }
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (!this.this$0.m.isFinishing()) {}
    try
    {
      this.this$0.m.dismissDialog(0);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aang
 * JD-Core Version:    0.7.0.1
 */