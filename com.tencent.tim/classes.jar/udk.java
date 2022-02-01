import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.AddAccountActivity.4.1;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class udk
  extends AccountObserver
{
  public udk(AddAccountActivity paramAddAccountActivity) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super.onCheckQuickRegisterAccount(paramBoolean, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_AddAccountActivity", 2, "onCheckQuickRegisterAccount|isSuccess= " + paramBoolean + ",code=" + paramInt);
    }
    if (!this.this$0.isFinishing()) {}
    try
    {
      this.this$0.dismissDialog(1);
      if ((paramBoolean) && (paramInt == 0))
      {
        paramArrayOfByte = new Intent(this.this$0, RegisterByNicknameAndPwdActivity.class);
        paramArrayOfByte.putExtra("key_register_binduin", this.this$0.app.getCurrentAccountUin());
        paramArrayOfByte.putExtra("key_register_from_quick_register", true);
        paramArrayOfByte.putExtra("key_register_is_phone_num_registered", true);
        paramArrayOfByte.putExtra("not_need_verify_sms", true);
        this.this$0.startActivity(paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      paramArrayOfByte = new Intent(this.this$0, RegisterPhoneNumActivity.class);
      paramArrayOfByte.putExtra("key_register_from", 1);
      this.this$0.startActivity(paramArrayOfByte);
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    QLog.d("AddAccountActivity", 1, "onLoginFailed ret=" + paramInt1);
    if (!this.this$0.isFinishing()) {}
    try
    {
      this.this$0.dismissDialog(0);
      this.this$0.runOnUiThread(new AddAccountActivity.4.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt1);
      }
      if ((paramString2 == null) || (paramString2.equals("")))
      {
        QQToast.a(this.this$0, 2131696270, 0).show();
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
        Intent localIntent = new Intent(this.this$0, NotificationActivity.class);
        localIntent.putExtra("type", 8);
        if (paramInt1 == 40)
        {
          localIntent.putExtra("msg", paramString2);
          localIntent.putExtra("errorver", paramInt2);
        }
        for (;;)
        {
          localIntent.putExtra("loginalias", paramString1);
          localIntent.putExtra("loginret", paramInt1);
          localIntent.putExtra("errorUrl", paramString3);
          localIntent.putExtra("expiredSig", paramArrayOfByte);
          this.this$0.startActivity(localIntent);
          return;
          localIntent.putExtra("msg", paramString2 + " " + paramString3);
        }
      }
      if (paramInt1 == 2008)
      {
        aqha.a(this.this$0, 230, acfp.m(2131702033), acfp.m(2131702034), "OK", null, new udl(this), null).show();
        QQToast.a(this.this$0, 2131694440, 0).show();
        return;
      }
      aqha.a(this.this$0, 230, acfp.m(2131702037), paramString2, new udm(this), null).show();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("AddAccountActivity", 1, "onLoginSuccess");
  }
  
  public void onLoginTimeout(String paramString)
  {
    QLog.d("AddAccountActivity", 1, "onLoginTimeout");
    if (!this.this$0.isFinishing()) {}
    try
    {
      this.this$0.dismissDialog(0);
      QQToast.a(this.this$0, 2131696270, 0).show();
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
    if (!this.this$0.isFinishing()) {}
    try
    {
      this.this$0.dismissDialog(0);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udk
 * JD-Core Version:    0.7.0.1
 */