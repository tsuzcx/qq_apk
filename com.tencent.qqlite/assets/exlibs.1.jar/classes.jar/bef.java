import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class bef
  extends ConfigObserver
{
  public bef(QQSetting paramQQSetting) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSetting.a(this.a, paramUpgradeDetailWrapper);
    QQSetting.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bef
 * JD-Core Version:    0.7.0.1
 */