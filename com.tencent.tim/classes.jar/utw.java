import android.text.TextUtils;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class utw
  extends WtloginObserver
{
  public utw(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (!this.this$0.isResume())
    {
      this.this$0.bwV();
      return;
    }
    if (((this.this$0.w == null) || (!this.this$0.w.isShowing())) && (paramInt == 0) && (paramDevlockInfo != null))
    {
      this.this$0.b = paramDevlockInfo;
      afrz.a().update(this.this$0.b.TransferInfo);
      return;
    }
    this.this$0.bwV();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "OnCheckDevLockStatus ret = " + paramInt);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo devSetup:" + paramDevlockInfo.DevSetup + " countryCode:" + paramDevlockInfo.CountryCode + " mobile:" + paramDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + paramDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount + " AllowSet:" + paramDevlockInfo.AllowSet);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo.MbGuideInfoType:" + paramDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.DevlockPushActivity", 2, "DevlockInfo.MbGuideInfo:" + paramDevlockInfo.MbGuideInfo);
      }
      this.this$0.b = paramDevlockInfo;
      afrz.a().update(this.this$0.b.TransferInfo);
      this.this$0.b(this.this$0.b);
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
 * Qualified Name:     utw
 * JD-Core Version:    0.7.0.1
 */