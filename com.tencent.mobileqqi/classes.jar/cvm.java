import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class cvm
  extends WtloginObserver
{
  public cvm(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (paramInt2 == 0)
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  login success ret =  " + paramInt2);
      if ((LoginVerifyCodeActivity2.c(this.a) == 2) || (LoginVerifyCodeActivity2.c(this.a) == 3))
      {
        this.a.g();
        paramErrMsg = new Intent();
        paramErrMsg.putExtra("last_account", paramString);
        this.a.setResult(-1, paramErrMsg);
        this.a.finish();
        return;
      }
      LoginVerifyCodeActivity2.a(this.a).ssoGetTicketNoPasswd(paramString, 4096, this.a.a);
      return;
    }
    this.a.g();
    paramString = null;
    if (paramErrMsg != null) {
      paramString = paramErrMsg.getMessage();
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.a.d();
      return;
    }
    this.a.a(paramString, 0);
  }
  
  public void OnRefreshSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.mobile=" + paramString1 + " msg=" + paramString2 + " timeLimit=" + paramInt2);
      QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.ret=" + paramInt3);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.errMsg=" + paramErrMsg);
      }
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.g();
    if (paramInt3 != 0)
    {
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        this.a.d();
        return;
      }
      this.a.a(paramString1, 0);
      return;
    }
    LoginVerifyCodeActivity2.a(this.a, 60);
  }
  
  public void OnVerifySMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnVerifySMSVerifyLoginAccount mobile=" + paramString1 + " msgCode=" + paramString2 + " ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnVerifySMSVerifyLoginAccount errMsg=" + paramErrMsg.getMessage());
      }
    }
    if (this.a.isFinishing()) {
      return;
    }
    if (paramInt != 0)
    {
      this.a.g();
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        this.a.d();
        return;
      }
      this.a.a(paramString1, 0);
      return;
    }
    LoginVerifyCodeActivity2.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvm
 * JD-Core Version:    0.7.0.1
 */