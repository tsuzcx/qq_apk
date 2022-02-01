import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class def
  extends WtloginObserver
{
  public def(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      if ((paramInt == 0) && (paramDevlockInfo != null))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQSetting2Activity", 2, "OnCheckDevLockStatus ret = " + paramInt);
          QLog.d("QQSetting2Activity", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
          QLog.d("QQSetting2Activity", 2, "DevlockInfo.ProtectIntro:" + paramDevlockInfo.ProtectIntro + "  info.MbGuideType:" + paramDevlockInfo.MbGuideType);
          QLog.d("QQSetting2Activity", 2, "DevlockInfo.MbGuideMsg:" + paramDevlockInfo.MbGuideMsg);
          QLog.d("QQSetting2Activity", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
          QLog.d("QQSetting2Activity", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
        }
        this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = paramDevlockInfo;
        this.a.a(this.a.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "OnCheckDevLockStatus ret = " + paramInt);
        if (paramErrMsg != null) {
          QLog.d("QQSetting2Activity", 2, "OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
        }
        if (paramDevlockInfo == null) {
          QLog.d("QQSetting2Activity", 2, "OnCheckDevLockStatus DevlockInfo is null");
        }
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    } while (!this.a.isResume());
    paramWUserSigInfo = this.a.getString(2131562073);
    QQToast.a(this.a.getApplicationContext(), paramWUserSigInfo, 0).b(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     def
 * JD-Core Version:    0.7.0.1
 */