import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class cuq
  extends WtloginObserver
{
  public cuq(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
        QLog.d("Q.devlock.LoginInfoActivity", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
        QLog.d("Q.devlock.LoginInfoActivity", 2, "DevlockInfo.ProtectIntro:" + paramDevlockInfo.ProtectIntro + "  info.MbGuideType:" + paramDevlockInfo.MbGuideType);
        QLog.d("Q.devlock.LoginInfoActivity", 2, "DevlockInfo.MbGuideMsg:" + paramDevlockInfo.MbGuideMsg);
        QLog.d("Q.devlock.LoginInfoActivity", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.LoginInfoActivity", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
      }
      LoginInfoActivity.a(this.a, paramDevlockInfo);
      LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.LoginInfoActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
      }
      if (paramDevlockInfo == null) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
    LoginInfoActivity.b(this.a);
    paramDevlockInfo = this.a.getString(2131562568);
    paramWUserSigInfo = paramDevlockInfo;
    if (paramErrMsg != null)
    {
      paramWUserSigInfo = paramDevlockInfo;
      if (!TextUtils.isEmpty(paramErrMsg.getMessage())) {
        paramWUserSigInfo = paramErrMsg.getMessage();
      }
    }
    QQToast.a(this.a.getApplicationContext(), paramWUserSigInfo, 0).b(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cuq
 * JD-Core Version:    0.7.0.1
 */