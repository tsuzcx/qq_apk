import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class vgf
  extends WtloginObserver
{
  public vgf(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "OnCheckDevLockStatus ret = " + paramInt);
        QLog.d("LoginInfoActivity.AccDevSec", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
        QLog.d("LoginInfoActivity.AccDevSec", 2, "DevlockInfo.ProtectIntro:" + paramDevlockInfo.ProtectIntro + "  info.MbGuideType:" + paramDevlockInfo.MbGuideType);
        QLog.d("LoginInfoActivity.AccDevSec", 2, "DevlockInfo.MbGuideMsg:" + paramDevlockInfo.MbGuideMsg);
        QLog.d("LoginInfoActivity.AccDevSec", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
        QLog.d("LoginInfoActivity.AccDevSec", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
      }
      afrz.a().update(paramDevlockInfo.TransferInfo);
      LoginInfoActivity.a(this.this$0, paramDevlockInfo);
      LoginInfoActivity.a(this.this$0, LoginInfoActivity.a(this.this$0));
      LoginInfoActivity.b(this.this$0, LoginInfoActivity.a(this.this$0));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "OnCheckDevLockStatus ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
      }
      if (paramDevlockInfo == null) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
    LoginInfoActivity.e(this.this$0);
    paramDevlockInfo = this.this$0.getString(2131693206);
    paramWUserSigInfo = paramDevlockInfo;
    if (paramErrMsg != null)
    {
      paramWUserSigInfo = paramDevlockInfo;
      if (!TextUtils.isEmpty(paramErrMsg.getMessage())) {
        paramWUserSigInfo = paramErrMsg.getMessage();
      }
    }
    QQToast.a(this.this$0.getApplicationContext(), paramWUserSigInfo, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgf
 * JD-Core Version:    0.7.0.1
 */