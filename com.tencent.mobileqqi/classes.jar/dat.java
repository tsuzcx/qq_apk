import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class dat
  extends WtloginObserver
{
  public dat(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    this.a.g();
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  login success ret =  " + paramInt2);
      }
      paramString = this.a.b.a(LoginPhoneNumActivity.class);
      if (paramString != null) {
        paramString.sendEmptyMessage(2015);
      }
      this.a.finish();
    }
    for (;;)
    {
      return;
      if (paramInt2 == -20160326)
      {
        this.a.finish();
        return;
      }
      if (paramInt2 == 2008)
      {
        this.a.a(2131563021, 0);
        this.a.finish();
        return;
      }
      paramString = null;
      if (paramErrMsg != null) {
        paramString = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString)) {
        this.a.a(2131562783, 1);
      }
      while (paramInt2 == 155)
      {
        this.a.finish();
        return;
        this.a.a(paramString, 0);
      }
    }
  }
  
  public void OnGetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetSubaccountStViaSMSVerifyLogin  userAccount = " + paramString2 + " mainAccount=" + paramString1 + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetSubaccountStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("logintime", 2, "login end.......");
    }
    if (paramInt2 == 0) {
      if ((paramString1 != null) && (paramString2 != null) && (paramString1.equals(paramString2)))
      {
        SubAccountAssistantForward.d(this.a.b);
        LoginVerifyCodeActivity.b(this.a);
        LoginVerifyCodeActivity.a(this.a, 2131561657, 0);
        this.a.finish();
      }
    }
    for (;;)
    {
      return;
      if (this.a.b != null)
      {
        paramString1 = new HashMap();
        paramString1.put("param_FailCode", "12001");
        paramString1.put("fail_step", "loginsucc");
        paramString1.put("fail_location", "subLogin");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.b.a(), "actSBLogin", true, 0L, 0L, paramString1, "");
        SharedPreUtils.a(this.a.b.getApplication().getApplicationContext(), paramString2, true);
        this.a.getAppRuntime().getSubAccountKey(this.a.b.getAccount(), paramString2, this.a.a);
        SubAccountAssistantImpl.a().a(this.a.b, paramString2, 0, "");
        return;
        this.a.g();
        if (paramInt2 == -20160326)
        {
          this.a.finish();
          return;
        }
        if (paramInt2 == 2008)
        {
          this.a.a(2131563021, 0);
          this.a.finish();
          return;
        }
        paramString1 = null;
        if (paramErrMsg != null) {
          paramString1 = paramErrMsg.getMessage();
        }
        if (TextUtils.isEmpty(paramString1)) {
          this.a.a(2131562783, 1);
        }
        while (paramInt2 == 155)
        {
          this.a.finish();
          return;
          this.a.a(paramString1, 0);
        }
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
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      this.a.g();
      if (paramInt3 == 0) {
        break;
      }
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1)) {
        this.a.a(2131562783, 1);
      }
      while (paramInt3 == 155)
      {
        this.a.finish();
        return;
        this.a.a(paramString1, 0);
      }
    }
    LoginVerifyCodeActivity.a(this.a, 60);
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
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      if (paramInt == 0) {
        break;
      }
      this.a.g();
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1)) {
        this.a.a(2131562783, 1);
      }
      while (paramInt == 155)
      {
        this.a.finish();
        return;
        this.a.a(paramString1, 0);
      }
    }
    LoginVerifyCodeActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dat
 * JD-Core Version:    0.7.0.1
 */