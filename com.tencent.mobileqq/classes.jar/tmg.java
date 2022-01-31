import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class tmg
  extends AccountObserver
{
  public tmg(RegisterByNicknameAndPwdActivity paramRegisterByNicknameAndPwdActivity) {}
  
  public void onGetQuickRegisterAccount(boolean paramBoolean, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterByNicknameAndPwdActivity", 2, "onGetQuickRegisterAccount code = " + paramInt + ";uin = " + paramString1 + ";phoneNum=" + paramString2);
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c();
    if (!paramBoolean) {
      try
      {
        paramString1 = new String(paramArrayOfByte, "utf-8");
        paramString2 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramString2 = this.a.getString(2131434198);
        }
        this.a.a(paramString2, 1);
        return;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          paramString1 = null;
        }
      }
    }
    if (paramInt == 0)
    {
      RegisterByNicknameAndPwdActivity.a(this.a, paramString1);
      RegisterByNicknameAndPwdActivity.b(this.a, paramString2);
      if ((TextUtils.isEmpty(RegisterByNicknameAndPwdActivity.a(this.a))) || (TextUtils.isEmpty(RegisterByNicknameAndPwdActivity.b(this.a))))
      {
        this.a.a(2131434198, 1);
        return;
      }
      paramString1 = new Intent(this.a, RegisterQQNumberActivity.class);
      paramString1.putExtra("key_register_secret_phone", paramString2);
      paramString1.putExtra("uin", RegisterByNicknameAndPwdActivity.a(this.a));
      paramString1.putExtra("key_register_password", String.valueOf(RegisterByNicknameAndPwdActivity.a(this.a).getText()));
      paramString1.putExtra("key_register_unbind", true);
      paramString1.putExtra("key_register_from_quick_register", RegisterByNicknameAndPwdActivity.a(this.a));
      paramString1.putExtra("key_register_is_phone_num_registered", this.a.b);
      paramString1.putExtra("key_register_has_pwd", this.a.c);
      paramString1.putExtra("key_register_from_send_sms", RegisterByNicknameAndPwdActivity.b(this.a));
      paramString1.putExtra("key_register_chose_bind_phone", false);
      this.a.startActivity(paramString1);
      this.a.finish();
      return;
    }
    this.a.a(2131434198, 1);
  }
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterByNicknameAndPwdActivity", 2, "RegisterByNicknameAndPwdActivity onRegisterCommitPassResp ");
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c();
    if (!paramBoolean) {
      try
      {
        paramString = new String(paramArrayOfByte2, "utf-8");
        paramArrayOfByte1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayOfByte1 = this.a.getString(2131434198);
        }
        this.a.a(paramArrayOfByte1, 1);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte2 = new StringBuilder().append("RegisterByNicknameAndPwdActivity onRegisterCommitPassResp code = ").append(paramInt).append(";uin = ").append(paramString).append(";contactsig = ");
      if (paramArrayOfByte1 != null) {
        break label197;
      }
    }
    label197:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("RegisterByNicknameAndPwdActivity", 2, paramBoolean);
      if (paramInt != 0) {
        break label242;
      }
      RegisterByNicknameAndPwdActivity.a(this.a, paramString);
      RegisterByNicknameAndPwdActivity.a(this.a, paramArrayOfByte1);
      if (!TextUtils.isEmpty(RegisterByNicknameAndPwdActivity.a(this.a))) {
        break;
      }
      this.a.a(2131434198, 1);
      return;
    }
    if ((RegisterByNicknameAndPwdActivity.a(this.a) == null) || (RegisterByNicknameAndPwdActivity.a(this.a).length == 0))
    {
      this.a.a(2131434198, 1);
      return;
    }
    this.a.a();
    return;
    label242:
    this.a.a(2131434198, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmg
 * JD-Core Version:    0.7.0.1
 */