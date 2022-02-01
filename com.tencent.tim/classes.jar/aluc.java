import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

class aluc
  extends AccountObserver
{
  aluc(alub paramalub) {}
  
  public void onGetQuickRegisterAccount(boolean paramBoolean, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.i("Login_Optimize_RegisterWithNickAndPwd", 1, "onGetQuickRegisterAccount code = " + paramInt + ";uin = " + ApolloUtil.iY(paramString1) + ";phoneNum=" + paramString2 + ";mIsfromLH=" + this.b.czs);
    if (this.b.a.isFinishing()) {
      return;
    }
    this.b.a.gV();
    if (!paramBoolean) {
      try
      {
        paramString1 = new String(paramArrayOfByte, "utf-8");
        paramString2 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramString2 = this.b.a.getString(2131717096);
        }
        this.b.a.cq(paramString2, 1);
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
      alub.a(this.b, paramString1);
      alub.b(this.b, paramString2);
      if ((TextUtils.isEmpty(alub.a(this.b))) || (TextUtils.isEmpty(alub.b(this.b))))
      {
        this.b.a.J(2131717096, 1);
        return;
      }
      paramString1 = new Intent(this.b.a, RegisterQQNumberActivity.class);
      paramString1.putExtra("key_register_secret_phone", paramString2);
      paramString1.putExtra("uin", alub.a(this.b));
      paramString1.putExtra("key_register_password", alub.c(this.b));
      paramString1.putExtra("key_register_unbind", true);
      paramString1.putExtra("key_register_from_quick_register", this.b.aRU);
      paramString1.putExtra("key_register_is_phone_num_registered", this.b.a.aRQ);
      paramString1.putExtra("key_register_has_pwd", this.b.a.aRR);
      paramString1.putExtra("key_register_from_send_sms", this.b.bac);
      paramString1.putExtra("key_register_chose_bind_phone", false);
      if ((this.b.czr) && (!this.b.czs))
      {
        alub.a(this.b, paramString1, false);
        return;
      }
      this.b.a.startActivity(paramString1);
      this.b.a.finish();
      return;
    }
    this.b.a.J(2131717096, 1);
  }
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    QLog.i("RegisterWithNickAndPwd", 1, "RegisterByNicknameAndPwdActivity onRegisterCommitPassResp ");
    if (this.b.a.isFinishing()) {
      return;
    }
    try
    {
      paramArrayOfByte2 = new String(paramArrayOfByte2, "utf-8");
      QQAppInterface localQQAppInterface = this.b.app;
      if (paramBoolean)
      {
        str = Integer.toString(paramInt);
        if (paramArrayOfByte2 != null) {
          break label166;
        }
        localObject = "";
        anot.a(localQQAppInterface, "new_reg", "setting_page_yes", "result", "", 1, "", str, "", (String)localObject, "", "", "", "", "");
        this.b.a.gV();
        if (paramBoolean) {
          break label173;
        }
        paramString = paramArrayOfByte2;
        if (TextUtils.isEmpty(paramArrayOfByte2)) {
          paramString = this.b.a.getString(2131717096);
        }
        this.b.a.cq(paramString, 1);
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte2)
    {
      for (;;)
      {
        paramArrayOfByte2.printStackTrace();
        paramArrayOfByte2 = null;
        continue;
        String str = "-1001";
        continue;
        label166:
        Object localObject = paramArrayOfByte2;
      }
      label173:
      paramArrayOfByte2 = new StringBuilder().append("RegisterByNicknameAndPwdActivity onRegisterCommitPassResp code = ").append(paramInt).append(";uin = ").append(ApolloUtil.iY(paramString)).append(";contactsig = ");
      if (paramArrayOfByte1 == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.i("RegisterWithNickAndPwd", 1, paramBoolean);
        if (paramInt != 0) {
          break label328;
        }
        alub.a(this.b, paramString);
        alub.a(this.b, paramArrayOfByte1);
        if (!TextUtils.isEmpty(alub.a(this.b))) {
          break;
        }
        this.b.a.J(2131717096, 1);
        return;
      }
      if ((alub.a(this.b) == null) || (alub.a(this.b).length == 0))
      {
        this.b.a.J(2131717096, 1);
        return;
      }
      this.b.bRp();
      return;
    }
    label328:
    this.b.a.J(2131717096, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aluc
 * JD-Core Version:    0.7.0.1
 */