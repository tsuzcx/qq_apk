import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class tnv
  extends ConfigObserver
{
  public tnv(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSettingSettingActivity.a(this.a, paramUpgradeDetailWrapper);
    QQSettingSettingActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnv
 * JD-Core Version:    0.7.0.1
 */