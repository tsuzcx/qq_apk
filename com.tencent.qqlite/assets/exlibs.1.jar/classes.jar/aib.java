import android.text.TextUtils;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aib
  extends WtloginObserver
{
  public aib(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (!this.a.isResume())
    {
      DevlockPushActivity.a(this.a);
      return;
    }
    if (((DevlockPushActivity.a(this.a) == null) || (!DevlockPushActivity.a(this.a).isShowing())) && (paramInt == 0) && (paramDevlockInfo != null))
    {
      DevlockPushActivity.a(this.a, paramDevlockInfo);
      return;
    }
    DevlockPushActivity.a(this.a);
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
      }
      DevlockPushActivity.a(this.a, paramDevlockInfo);
      DevlockPushActivity.a(this.a, DevlockPushActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
      if (paramErrMsg != null) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
      }
      if (paramDevlockInfo == null) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus DevlockInfo is null");
      }
    }
    paramDevlockInfo = this.a.getString(2131364212);
    paramWUserSigInfo = paramDevlockInfo;
    if (paramErrMsg != null)
    {
      paramWUserSigInfo = paramDevlockInfo;
      if (!TextUtils.isEmpty(paramErrMsg.getMessage())) {
        paramWUserSigInfo = paramErrMsg.getMessage();
      }
    }
    QQToast.a(this.a.getApplicationContext(), paramWUserSigInfo, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aib
 * JD-Core Version:    0.7.0.1
 */