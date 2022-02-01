import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class uhh
  extends WtloginObserver
{
  public uhh(AuthDevActivity paramAuthDevActivity) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.this$0.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.a(this.this$0, true);
      AuthDevActivity.c(this.this$0);
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "OnCheckDevLockSms result : ret is ", Integer.valueOf(paramInt) });
      if (paramInt != 0) {
        break;
      }
      paramWUserSigInfo = (AccountManager)this.this$0.app.getManager(0);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.refreshDA2(this.this$0.app.getCurrentAccountUin(), null);
      }
      AuthDevActivity.b(this.this$0).setOnCheckedChangeListener(null);
      AuthDevActivity.b(this.this$0).setChecked(true);
      AuthDevActivity.b(this.this$0).setOnCheckedChangeListener(AuthDevActivity.a(this.this$0));
      paramWUserSigInfo = (acll)this.this$0.app.getBusinessHandler(34);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.cMq();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.success");
      }
      AuthDevActivity.b(this.this$0, true);
      afsf.a().a(this.this$0.app, this.this$0, this.this$0.app.getCurrentAccountUin(), true);
      AuthDevActivity.c(this.this$0, true);
      QQToast.a(this.this$0.getApplicationContext(), 2, this.this$0.getString(2131693163), 0).show(this.this$0.getTitleBarHeight());
      AuthDevActivity.d(this.this$0);
      paramWUserSigInfo = this.this$0.app.getHandler(LoginInfoActivity.class);
    } while (paramWUserSigInfo == null);
    paramWUserSigInfo.obtainMessage(20140331, 1, 0).sendToTarget();
    return;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.fail ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.fail errMsg=" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(this.this$0.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 1, this.this$0.getString(2131693219), 0).show(this.this$0.getTitleBarHeight());
  }
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.this$0.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.a(this.this$0, true);
      AuthDevActivity.c(this.this$0);
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "OnCloseDevLock response , ret is ", Integer.valueOf(paramInt) });
      if (paramInt != 0) {
        break;
      }
      paramWUserSigInfo = (WtloginManager)this.this$0.app.getManager(1);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.RefreshMemorySig();
      }
      AuthDevActivity.b(this.this$0).setOnCheckedChangeListener(null);
      AuthDevActivity.b(this.this$0).setChecked(false);
      AuthDevActivity.b(this.this$0).setOnCheckedChangeListener(AuthDevActivity.a(this.this$0));
      AuthDevActivity.a(this.this$0).setVisibility(8);
      AuthDevActivity.b(this.this$0).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.success");
      }
      AuthDevActivity.b(this.this$0, false);
      AuthDevActivity.a(this.this$0).setVisibility(8);
      afsf.a().a(this.this$0.app, this.this$0, this.this$0.app.getCurrentAccountUin(), false);
      QQToast.a(this.this$0.getApplicationContext(), 2, this.this$0.getString(2131693181), 0).show(this.this$0.getTitleBarHeight());
      paramWUserSigInfo = this.this$0.app.getHandler(LoginInfoActivity.class);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.obtainMessage(20140331, 0, 0).sendToTarget();
      }
      AuthDevActivity.b(this.this$0, null);
      AuthDevActivity.a(this.this$0, AuthDevActivity.b(this.this$0));
    } while (!AuthDevActivity.b(this.this$0));
    AuthDevActivity.e(this.this$0);
    return;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail errMsg=" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(this.this$0.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 1, this.this$0.getString(2131693180), 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhh
 * JD-Core Version:    0.7.0.1
 */