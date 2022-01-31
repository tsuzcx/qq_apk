import android.text.TextUtils;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bwc
  extends WtloginObserver
{
  public bwc(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void OnAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.g();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "OnAskDevLockSms DevlockInfo.TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount);
      }
      if (paramDevlockInfo.TimeLimit <= 0) {
        paramDevlockInfo.TimeLimit = 60;
      }
      AuthDevVerifyCodeActivity.a(this.a, paramDevlockInfo.TimeLimit);
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
      this.a.a(paramErrMsg.getMessage(), 1);
      return;
    }
    paramWUserSigInfo = this.a.getString(2131561658);
    this.a.a(paramWUserSigInfo, 1);
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
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevVerifyCodeActivity.a(this.a);
    if (paramInt == 0)
    {
      paramErrMsg = this.a.b.a();
      if (EquipmentLockImpl.a().c()) {}
      for (paramWUserSigInfo = "Push";; paramWUserSigInfo = "Manually")
      {
        ReportController.b(null, "P_CliOper", "Safe_DeviceLock", paramErrMsg, "UserBehavior", paramWUserSigInfo, 0, 8, "", "", "", "");
        this.a.setResult(-1);
        this.a.finish();
        EquipmentLockImpl.a().a(this.a.b, this.a, this.a.b.a(), true);
        return;
      }
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      this.a.a(paramErrMsg.getMessage(), 1);
      return;
    }
    this.a.a(2131563224, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bwc
 * JD-Core Version:    0.7.0.1
 */