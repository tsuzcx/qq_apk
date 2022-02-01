import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bvr
  extends WtloginObserver
{
  public bvr(AuthDevActivity paramAuthDevActivity) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      AuthDevActivity.a(this.a, true);
      AuthDevActivity.b(this.a);
      if (paramInt != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCheckDevLockSms.success");
      }
      AuthDevActivity.b(this.a, true);
      EquipmentLockImpl.a().a(this.a.b, this.a, this.a.b.a(), true);
      AuthDevActivity.c(this.a, true);
      AuthDevActivity.a(this.a).setText(this.a.getString(2131561947));
      AuthDevActivity.a(this.a).setContentDescription(this.a.getString(2131561947));
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131562015), 0).b(this.a.d());
      AuthDevActivity.c(this.a);
      paramWUserSigInfo = this.a.b.a(LoginInfoActivity.class);
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
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.d());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131562567), 0).b(this.a.d());
  }
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevActivity.a(this.a, true);
    AuthDevActivity.b(this.a);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "OnCloseDevLock.success");
      }
      AuthDevActivity.b(this.a, false);
      AuthDevActivity.a(this.a).setVisibility(8);
      EquipmentLockImpl.a().a(this.a.b, this.a, this.a.b.a(), false);
      AuthDevActivity.a(this.a).setText(this.a.getString(2131562008));
      AuthDevActivity.a(this.a).setContentDescription(this.a.getString(2131562008));
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131561950), 0).b(this.a.d());
      paramWUserSigInfo = this.a.b.a(LoginInfoActivity.class);
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
      QQToast.a(this.a.getApplicationContext(), 1, paramErrMsg.getMessage(), 0).b(this.a.d());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131562039), 0).b(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bvr
 * JD-Core Version:    0.7.0.1
 */