import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class deg
  extends ConfigObserver
{
  public deg(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSettingSettingActivity.a(this.a, paramUpgradeDetailWrapper);
    QQSettingSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     deg
 * JD-Core Version:    0.7.0.1
 */