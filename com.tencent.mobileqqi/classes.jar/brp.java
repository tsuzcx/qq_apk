import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class brp
  extends ConfigObserver
{
  public brp(AboutActivity paramAboutActivity) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
    paramUpgradeDetailWrapper = this.a.b.a();
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     brp
 * JD-Core Version:    0.7.0.1
 */