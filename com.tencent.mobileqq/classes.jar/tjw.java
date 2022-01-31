import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class tjw
  extends FriendListObserver
{
  public tjw(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  protected void onSetGeneralSettingsC2CRoaming(boolean paramBoolean, Map paramMap)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SecuritySettingActivity", 2, "onSetGeneralSettingsC2CRoaming issuc =" + paramBoolean);
    }
    this.a.e();
    if (paramBoolean)
    {
      QQToast.a(this.a.getApplicationContext(), 2, 2131434977, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (QQSettingMsgHistoryActivity.a(this.a) != null)
    {
      QQSettingMsgHistoryActivity.a(this.a).setOnCheckedChangeListener(null);
      paramMap = QQSettingMsgHistoryActivity.a(this.a);
      if (this.a.app.e() != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramMap.setChecked(paramBoolean);
      QQSettingMsgHistoryActivity.a(this.a).setOnCheckedChangeListener(this.a);
      QQToast.a(this.a.getApplicationContext(), 2131434978, 0).b(this.a.getTitleBarHeight());
      return;
    }
  }
  
  protected void onSetMessageRaoam(boolean paramBoolean)
  {
    if (paramBoolean) {
      QQSettingMsgHistoryActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tjw
 * JD-Core Version:    0.7.0.1
 */