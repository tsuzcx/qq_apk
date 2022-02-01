import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.AccountManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class uhr
  extends WtloginObserver
{
  public uhr(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void OnAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.gV();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnAskDevLockSms DevlockInfo.TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount);
      }
      if (paramDevlockInfo.TimeLimit <= 0) {
        paramDevlockInfo.TimeLimit = 60;
      }
      AuthDevVerifyCodeActivity.a(this.this$0, paramDevlockInfo.TimeLimit);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnAskDevLockSms ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnAskDevLockSms  errMsg:" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.this$0.cq(paramErrMsg.getMessage(), 1);
      return;
    }
    paramWUserSigInfo = this.this$0.getString(2131717096);
    this.this$0.cq(paramWUserSigInfo, 1);
  }
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnCheckDevLockSms ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnCheckDevLockSms  errMsg:" + paramErrMsg.getMessage());
      }
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    AuthDevVerifyCodeActivity.a(this.this$0);
    if (paramInt == 0)
    {
      paramWUserSigInfo = (AccountManager)this.this$0.app.getManager(0);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshDA2(this.this$0.app.getCurrentAccountUin(), null);
      }
      afsf.a().u(null, this.this$0.app.getCurrentAccountUin(), 9);
      this.this$0.setResult(-1);
      this.this$0.finish();
      paramErrMsg = (AppInterface)AuthDevVerifyCodeActivity.a(this.this$0).get();
      paramWUserSigInfo = "";
      if (paramErrMsg != null) {
        paramWUserSigInfo = paramErrMsg.getAccount();
      }
      afsf.a().a(paramErrMsg, this.this$0, paramWUserSigInfo, true);
      return;
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.this$0.cq(paramErrMsg.getMessage(), 1);
      return;
    }
    this.this$0.J(2131717144, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhr
 * JD-Core Version:    0.7.0.1
 */