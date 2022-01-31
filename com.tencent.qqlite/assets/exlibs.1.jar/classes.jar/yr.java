import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class yr
  extends WtloginObserver
{
  public yr(AuthDevActivity paramAuthDevActivity) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.a(this.a, true);
      AuthDevActivity.c(this.a);
      if (paramInt != 0) {
        break;
      }
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(null);
      AuthDevActivity.b(this.a).setChecked(true);
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
      paramWUserSigInfo = (SecSvcHandler)this.a.app.a(33);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.success");
      }
      AuthDevActivity.b(this.a, true);
      EquipmentLockImpl.a().a(this.a.app, this.a, this.a.app.a(), true);
      AuthDevActivity.c(this.a, true);
      AuthDevActivity.b(this.a).setText(this.a.getString(2131364202));
      AuthDevActivity.b(this.a).setContentDescription(this.a.getString(2131364202));
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131364205), 0).b(this.a.getTitleBarHeight());
      AuthDevActivity.d(this.a);
      paramWUserSigInfo = this.a.app.a(LoginInfoActivity.class);
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
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131364229), 0).b(this.a.getTitleBarHeight());
  }
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevActivity.a(this.a, true);
    AuthDevActivity.c(this.a);
    if (paramInt == 0)
    {
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(null);
      AuthDevActivity.b(this.a).setChecked(false);
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
      AuthDevActivity.a(this.a).setVisibility(8);
      AuthDevActivity.b(this.a).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.success");
      }
      AuthDevActivity.b(this.a, false);
      AuthDevActivity.a(this.a).setVisibility(8);
      EquipmentLockImpl.a().a(this.a.app, this.a, this.a.app.a(), false);
      AuthDevActivity.b(this.a).setText(this.a.getString(2131364203));
      AuthDevActivity.b(this.a).setContentDescription(this.a.getString(2131364203));
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131364227), 0).b(this.a.getTitleBarHeight());
      paramWUserSigInfo = this.a.app.a(LoginInfoActivity.class);
      if (paramWUserSigInfo != null) {
        paramWUserSigInfo.obtainMessage(20140331, 0, 0).sendToTarget();
      }
      AuthDevActivity.a(this.a, null);
      AuthDevActivity.a(this.a, AuthDevActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.fail errMsg=" + paramErrMsg.getMessage());
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131364228), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     yr
 * JD-Core Version:    0.7.0.1
 */