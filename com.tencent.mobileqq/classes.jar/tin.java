import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class tin
  extends ConfigObserver
{
  public tin(QQSettingMe paramQQSettingMe) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSettingMe.a(this.a, paramUpgradeDetailWrapper);
    if (this.a.c) {
      this.a.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tin
 * JD-Core Version:    0.7.0.1
 */