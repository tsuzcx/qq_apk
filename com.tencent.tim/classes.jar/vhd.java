import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class vhd
  extends WtloginObserver
{
  public vhd(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
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
      if ((LoginVerifyCodeActivity2.c(this.this$0) == 2) || (LoginVerifyCodeActivity2.c(this.this$0) == 3))
      {
        this.this$0.gV();
        paramArrayOfByte = new Intent();
        paramArrayOfByte.putExtra("last_account", paramString);
        this.this$0.setResult(-1, paramArrayOfByte);
        this.this$0.finish();
      }
    }
    for (;;)
    {
      return;
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putByteArray("connect_data", artw.ah(LoginVerifyCodeActivity2.a(this.this$0)));
      paramArrayOfByte.putLong("dwSrcAppid", 1600001540L);
      paramArrayOfByte.putLong("dwDstAppid", 1600001540L);
      LoginVerifyCodeActivity2.a(this.this$0).ssoGetTicketNoPasswd(paramString, 4096, this.this$0.a, paramArrayOfByte);
      return;
      this.this$0.gV();
      if (paramInt2 == -20160326)
      {
        this.this$0.finish();
        return;
      }
      if (paramInt2 == 2008)
      {
        this.this$0.J(2131694440, 0);
        this.this$0.finish();
        return;
      }
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject1 = localObject3;
      if (paramErrMsg != null)
      {
        String str = paramErrMsg.getMessage();
        localObject1 = localObject3;
        localObject2 = str;
        if (paramErrMsg.getType() == 1)
        {
          localObject1 = paramErrMsg.getOtherinfo();
          localObject2 = str;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramErrMsg = new Intent(this.this$0, NotificationActivity.class);
        paramErrMsg.putExtra("type", 8);
        if (paramInt2 == 40) {
          paramErrMsg.putExtra("msg", localObject2);
        }
        for (;;)
        {
          paramErrMsg.putExtra("loginalias", paramString);
          paramErrMsg.putExtra("loginret", paramInt2);
          paramErrMsg.putExtra("expiredSig", paramArrayOfByte);
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.i("LoginVerifyCodeActivity", 4, "OnGetStViaSMSVerifyLogin, goto Notification");
          }
          paramErrMsg.putExtra("lh_is_from_login_verify_code", true);
          this.this$0.startActivityForResult(paramErrMsg, 1);
          return;
          paramErrMsg.putExtra("msg", localObject2 + " " + (String)localObject1);
        }
        this.this$0.startActivity(paramErrMsg);
        return;
      }
      if (TextUtils.isEmpty(localObject2)) {
        this.this$0.bRr();
      }
      while (paramInt2 == 155)
      {
        this.this$0.finish();
        return;
        this.this$0.cq(localObject2, 0);
      }
    }
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
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.gV();
    if (paramInt3 != 0)
    {
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        this.this$0.bRr();
        return;
      }
      this.this$0.cq(paramString1, 0);
      return;
    }
    LoginVerifyCodeActivity2.a(this.this$0, 60);
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
    if (this.this$0.isFinishing()) {
      return;
    }
    if (paramInt != 0)
    {
      this.this$0.gV();
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1))
      {
        this.this$0.bRr();
        return;
      }
      this.this$0.cq(paramString1, 0);
      return;
    }
    LoginVerifyCodeActivity2.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhd
 * JD-Core Version:    0.7.0.1
 */