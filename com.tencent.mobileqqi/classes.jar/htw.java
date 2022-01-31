import android.text.TextUtils;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class htw
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  public htw(AuthDevVerifyCodeActivity2 paramAuthDevVerifyCodeActivity2) {}
  
  private void a(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevVerifyCodeActivity2.a(this.a);
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onRecvVerifyCode uin:" + paramString + " seq=" + paramInt1);
        if (paramDevlockInfo != null) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onRecvVerifyCode info.TimeLimit:" + paramDevlockInfo.TimeLimit);
        }
      }
      setSeq(paramInt1);
      paramInt2 = 60;
      paramInt1 = paramInt2;
      if (paramDevlockInfo != null)
      {
        paramInt1 = paramInt2;
        if (paramDevlockInfo.TimeLimit > 0) {
          paramInt1 = paramDevlockInfo.TimeLimit;
        }
      }
      AuthDevVerifyCodeActivity2.a(this.a, paramInt1);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onRecvVerifyCode ret = " + paramInt2 + " seq=" + paramInt1);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onRecvVerifyCode  errMsg:" + paramErrMsg.getMessage() + " seq=" + paramInt1);
      }
    }
    if ((paramInt2 == 9) || (paramInt2 == 155))
    {
      this.a.setResult(-1);
      this.a.finish();
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      AuthDevVerifyCodeActivity2.a(this.a, paramErrMsg.getMessage(), 1);
      return;
    }
    paramString = this.a.getString(2131561658);
    AuthDevVerifyCodeActivity2.b(this.a, paramString, 1);
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    if (this.a.isFinishing()) {
      return;
    }
    AuthDevVerifyCodeActivity2.b(this.a);
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onRecvCheckSMSResult uin:" + paramString + " seq=" + paramInt1);
      }
      setSeq(paramInt1);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onRecvCheckSMSResult ret = " + paramInt2 + " seq=" + paramInt1);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onRecvCheckSMSResult  errMsg:" + paramErrMsg.getMessage() + " seq=" + paramInt1);
      }
    }
    if ((paramInt2 == 9) || (paramInt2 == 155))
    {
      this.a.setResult(-1);
      this.a.finish();
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      AuthDevVerifyCodeActivity2.c(this.a, paramErrMsg.getMessage(), 1);
      return;
    }
    paramString = this.a.getString(2131561658);
    AuthDevVerifyCodeActivity2.d(this.a, paramString, 1);
  }
  
  public void onRecvNotice(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onRecvNotice uin:" + paramString + " seq=" + paramInt1);
    }
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_REFRESH_SMS_RESULT)
    {
      a(paramInt1, paramString, paramInt2, paramErrMsg, paramDevlockInfo);
      return;
    }
    b(paramInt1, paramString, paramInt2, paramErrMsg, paramDevlockInfo);
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onVerifyClose ret = " + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onVerifyClose  errMsg:" + paramErrMsg.getMessage());
      }
    }
    if (this.a.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity2", 2, "onVerifyClose activity is finishing.");
      }
      return;
    }
    AuthDevVerifyCodeActivity2.c(this.a);
    AuthDevVerifyCodeActivity2.b(this.a);
    this.a.setResult(-1);
    this.a.finish();
    EquipmentLockImpl.a().a(this.a.b, this.a, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     htw
 * JD-Core Version:    0.7.0.1
 */