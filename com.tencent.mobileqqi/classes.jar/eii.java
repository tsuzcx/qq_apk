import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class eii
  extends ConfigObserver
{
  public eii(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    MainAssistObserver.a(this.a, paramUpgradeDetailWrapper);
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eii
 * JD-Core Version:    0.7.0.1
 */