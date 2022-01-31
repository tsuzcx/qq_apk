import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class ene
  extends ConfigObserver
{
  public ene(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    MainAssistObserver.a(this.a, paramUpgradeDetailWrapper);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ene
 * JD-Core Version:    0.7.0.1
 */