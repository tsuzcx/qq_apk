import Wallet.AcsGetMsgRsp;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.1.1;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.1.2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class whs
  implements BusinessObserver
{
  public whs(QQNotifySettingBaseFragment paramQQNotifySettingBaseFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((QQNotifySettingBaseFragment.a(this.a).isShowing()) && (QQNotifySettingBaseFragment.a(this.a) != null)) {
      QQNotifySettingBaseFragment.a(this.a).dismiss();
    }
    if (paramInt == 2005)
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQNotifySettingBaseFragment.access$100(), 2, "acs msg succ");
      }
      if (!paramBoolean) {
        break label114;
      }
      paramBundle = (AcsGetMsgRsp)paramBundle.getSerializable("rsp");
      if (paramBundle != null) {
        QQNotifySettingBaseFragment.a(this.a).post(new QQNotifySettingBaseFragment.1.1(this, paramBundle));
      }
    }
    else
    {
      return;
    }
    QQNotifySettingBaseFragment.a(this.a).post(new QQNotifySettingBaseFragment.1.2(this));
    return;
    label114:
    this.a.bYi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whs
 * JD-Core Version:    0.7.0.1
 */