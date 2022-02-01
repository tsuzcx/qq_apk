import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class dee
  extends FriendListObserver
{
  public dee(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  protected void b(boolean paramBoolean, Map paramMap)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SecuritySettingActivity", 2, "onSetGeneralSettingsC2CRoaming issuc =" + paramBoolean);
    }
    this.a.h();
    if (paramBoolean)
    {
      QQToast.a(this.a.getApplicationContext(), 2, 2131562538, 0).b(this.a.d());
      return;
    }
    if (QQSettingMsgHistoryActivity.a(this.a) != null)
    {
      QQSettingMsgHistoryActivity.a(this.a).setOnCheckedChangeListener(null);
      paramMap = QQSettingMsgHistoryActivity.a(this.a);
      if (this.a.b.f() != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramMap.setChecked(paramBoolean);
      QQSettingMsgHistoryActivity.a(this.a).setOnCheckedChangeListener(this.a);
      QQToast.a(this.a.getApplicationContext(), 2131562036, 0).b(this.a.d());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dee
 * JD-Core Version:    0.7.0.1
 */