import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class bec
  extends ConfigObserver
{
  public bec(QQSetting paramQQSetting) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSetting.a(this.a, paramUpgradeDetailWrapper);
    QQSetting.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bec
 * JD-Core Version:    0.7.0.1
 */