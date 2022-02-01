import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class ddq
  extends ConfigObserver
{
  public ddq(QQSettingMe paramQQSettingMe) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSettingMe.a(this.a, paramUpgradeDetailWrapper);
    if (this.a.b) {
      this.a.a.runOnUiThread(new ddr(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddq
 * JD-Core Version:    0.7.0.1
 */