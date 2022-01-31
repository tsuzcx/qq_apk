import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.AddAccountActivity.3.1;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class zwp
  extends AccountObserver
{
  public zwp(AddAccountActivity paramAddAccountActivity) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super.onCheckQuickRegisterAccount(paramBoolean, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_AddAccountActivity", 2, "onCheckQuickRegisterAccount|isSuccess= " + paramBoolean + ",code=" + paramInt);
    }
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(1);
      if ((paramBoolean) && (paramInt == 0))
      {
        paramArrayOfByte = new Intent(this.a, RegisterByNicknameAndPwdActivity.class);
        paramArrayOfByte.putExtra("key_register_binduin", this.a.app.getCurrentAccountUin());
        paramArrayOfByte.putExtra("key_register_from_quick_register", true);
        paramArrayOfByte.putExtra("key_register_is_phone_num_registered", true);
        paramArrayOfByte.putExtra("not_need_verify_sms", true);
        this.a.startActivity(paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      paramArrayOfByte = new Intent(this.a, RegisterPhoneNumActivity.class);
      paramArrayOfByte.putExtra("key_register_from", 1);
      this.a.startActivity(paramArrayOfByte);
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte)
  {
    QLog.d("AddAccountActivity", 1, "onLoginFailed ret=" + paramInt);
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      this.a.runOnUiThread(new AddAccountActivity.3.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt);
      }
      if ((paramString2 == null) || (paramString2.equals("")))
      {
        bbmy.a(this.a, 2131628946, 0).a();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
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
          localIntent.putExtra("expiredSig", paramArrayOfByte);
          this.a.startActivity(localIntent);
          return;
          localIntent.putExtra("msg", paramString2 + " " + paramString3);
        }
      }
      if (paramInt == 2008)
      {
        babr.a(this.a, 230, ajjy.a(2131634022), ajjy.a(2131634023), "OK", null, new zwq(this), null).show();
        bbmy.a(this.a, 2131627489, 0).a();
        return;
      }
      babr.a(this.a, 230, ajjy.a(2131634026), paramString2, new zwr(this), null).show();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    QLog.d("AddAccountActivity", 1, "onLoginSuccess");
  }
  
  public void onLoginTimeout(String paramString)
  {
    QLog.d("AddAccountActivity", 1, "onLoginTimeout");
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      bbmy.a(this.a, 2131628946, 0).a();
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void onUserCancel(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zwp
 * JD-Core Version:    0.7.0.1
 */